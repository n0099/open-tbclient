package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.data.Config;
/* loaded from: classes.dex */
public class AboutActivity extends BaseActivity {
    private TextView version = null;
    private Button mBack = null;

    public static void startActivity(Context context) {
        Intent intent = new Intent(context, AboutActivity.class);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        this.version = (TextView) findViewById(R.id.version);
        this.version.setText(String.valueOf(getString(R.string.app_name)) + " Android " + Config.VERSION);
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.more.AboutActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View arg0) {
                AboutActivity.this.finish();
            }
        });
    }
}
