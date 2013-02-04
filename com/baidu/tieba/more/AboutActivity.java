package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class AboutActivity extends com.baidu.tieba.e {
    private TextView b = null;
    private Button c = null;
    private Button d = null;
    private c e = null;
    private com.baidu.tieba.b.t f = null;

    public static void a(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.e != null) {
            this.e.a();
        }
        this.e = new c(this, null);
        this.e.execute(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.about_activity);
        this.b = (TextView) findViewById(R.id.version);
        this.b.setText(String.valueOf(getString(R.string.app_name)) + " Android " + com.baidu.tieba.a.h.h());
        this.c = (Button) findViewById(R.id.back);
        this.c.setOnClickListener(new a(this));
        this.d = (Button) findViewById(R.id.check_update_button);
        this.d.setOnClickListener(new b(this));
    }
}
