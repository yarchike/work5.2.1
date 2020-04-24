package com.example.work521;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_login = findViewById(R.id.login_btn);
        Button btn_reg = findViewById(R.id.registration_btn);
        btn_login.setOnClickListener(this);
        btn_reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText login = findViewById(R.id.login_text);
        EditText pass = findViewById(R.id.password_text);
        String lg = login.getText().toString();
        String ps = pass.getText().toString();

        switch (v.getId()) {
            case R.id.login_btn:
                if (lg.equals("")) {
                    Toast toast = Toast.makeText(this, getString(R.string.no_login), Toast.LENGTH_LONG);
                    toast.show();
                } else if (ps.equals("")) {
                    Toast toast = Toast.makeText(this, getString(R.string.no_pass), Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    String lgps = FileUtil.readFile(getApplicationContext());
                    String[] lgpas = lgps.split(";");
                    String logn = lgpas[0];
                    String pasw = lgpas[1];
                    if(logn.equals(lg) && pasw.equals(ps)){
                        Toast toast = Toast.makeText(this, getString(R.string.have_access), Toast.LENGTH_LONG);
                        toast.show();
                    }else{
                        Toast toast = Toast.makeText(this, getString(R.string.no_access), Toast.LENGTH_LONG);
                        toast.show();
                    }


                }

                break;
            case R.id.registration_btn:
                if (lg.equals("")) {
                    Toast toast = Toast.makeText(this, getString(R.string.no_login), Toast.LENGTH_LONG);
                    toast.show();
                } else if (ps.equals("")) {
                    Toast toast = Toast.makeText(this,getString(R.string.no_pass), Toast.LENGTH_LONG);
                    toast.show();
                }else{
                    FileUtil.writeFile(getApplicationContext(), lg, ps);
                    login.setText(null);
                    pass.setText(null);
                    Toast toast = Toast.makeText(this, getString(R.string.registration_successful), Toast.LENGTH_LONG);
                    toast.show();
                }

                break;
        }

    }

}
