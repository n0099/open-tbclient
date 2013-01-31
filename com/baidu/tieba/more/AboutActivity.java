package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
/* loaded from: classes.dex */
public class AboutActivity extends com.baidu.tieba.e {
    private ImageView p;
    private TextView c = null;
    private TextView d = null;
    private Button e = null;
    private Button f = null;
    private c g = null;
    private com.baidu.tieba.b.v h = null;
    private LinearLayout i = null;
    private ProgressBar j = null;
    private LinearLayout k = null;
    private Button l = null;
    private TextView m = null;
    private TextView n = null;
    private ImageView o = null;
    private d q = null;

    public static void a(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.about_activity);
        this.j = (ProgressBar) findViewById(R.id.about_progress);
        this.k = (LinearLayout) findViewById(R.id.title);
        this.i = (LinearLayout) findViewById(R.id.parent);
        this.m = (TextView) findViewById(R.id.title_text);
        this.l = (Button) findViewById(R.id.common_button);
        this.d = (TextView) findViewById(R.id.author);
        this.n = (TextView) findViewById(R.id.info);
        this.o = (ImageView) findViewById(R.id.divider);
        this.c = (TextView) findViewById(R.id.version);
        this.c.setText(String.valueOf(getString(R.string.app_name)) + " Android " + com.baidu.tieba.a.i.h());
        this.e = (Button) findViewById(R.id.back);
        this.e.setOnClickListener(new a(this));
        this.f = (Button) findViewById(R.id.check_update_button);
        this.f.setOnClickListener(new b(this));
        this.p = (ImageView) findViewById(R.id.new_version_logo_about);
        j();
        k();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        l();
        if (this.g != null) {
            this.g.a();
        }
        if (this.j != null) {
            this.j.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ad.a(this.i, i);
        com.baidu.tieba.c.ad.c(this.k, i);
        com.baidu.tieba.c.ad.e((TextView) this.e, i);
        com.baidu.tieba.c.ad.d((TextView) this.l, i);
        com.baidu.tieba.c.ad.c(this.m, i);
        if (i == 1) {
            this.c.setTextColor(com.baidu.tieba.c.ad.a(i));
            this.d.setTextColor(com.baidu.tieba.c.ad.a(i));
            this.n.setTextColor(com.baidu.tieba.c.ad.a(i));
            this.o.setImageResource(R.drawable.list_divider_1);
            return;
        }
        this.c.setTextColor(getResources().getColor(17170444));
        this.d.setTextColor(getResources().getColor(17170444));
        this.n.setTextColor(getResources().getColor(17170444));
        this.o.setImageResource(R.drawable.list_divider);
    }

    public void i() {
        if (this.g != null) {
            this.g.a();
        }
        this.g = new c(this, null);
        this.g.execute(new String[0]);
    }

    public void j() {
        if (TiebaApplication.aB()) {
            this.p.setVisibility(0);
        } else {
            this.p.setVisibility(8);
        }
    }

    private void k() {
        this.q = new d(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
        registerReceiver(this.q, intentFilter);
    }

    private void l() {
        if (this.q != null) {
            unregisterReceiver(this.q);
        }
    }
}
