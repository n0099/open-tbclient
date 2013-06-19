package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.c.br;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class AboutActivity extends com.baidu.tieba.e {
    private ImageView o;
    private TextView c = null;
    private TextView d = null;
    private ImageView e = null;
    private Button f = null;
    private c g = null;
    private br h = null;
    private LinearLayout i = null;
    private ProgressBar j = null;
    private View k = null;
    private TextView l = null;
    private TextView m = null;
    private ImageView n = null;
    private d p = null;

    public static void a(Context context) {
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.about_activity);
        this.j = (ProgressBar) findViewById(R.id.about_progress);
        this.k = findViewById(R.id.title);
        this.i = (LinearLayout) findViewById(R.id.parent);
        this.l = (TextView) findViewById(R.id.title_text);
        this.d = (TextView) findViewById(R.id.author);
        this.m = (TextView) findViewById(R.id.info);
        this.n = (ImageView) findViewById(R.id.divider);
        this.c = (TextView) findViewById(R.id.version);
        this.c.setText(String.valueOf(getString(R.string.app_name)) + " Android " + com.baidu.tieba.a.i.i());
        this.e = (ImageView) findViewById(R.id.title_back);
        this.e.setOnClickListener(new a(this));
        this.f = (Button) findViewById(R.id.check_update_button);
        this.f.setOnClickListener(new b(this));
        this.o = (ImageView) findViewById(R.id.new_version_logo_about);
        c();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        m();
        if (this.g != null) {
            this.g.cancel();
        }
        if (this.j != null) {
            this.j.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.d.ac.a(this.i, i);
        com.baidu.tieba.d.ac.d(this.k, i);
        com.baidu.tieba.d.ac.a(this.e, i);
        com.baidu.tieba.d.ac.f(this.l, i);
        if (i == 1) {
            this.c.setTextColor(com.baidu.tieba.d.ac.a(i));
            this.d.setTextColor(com.baidu.tieba.d.ac.a(i));
            this.m.setTextColor(com.baidu.tieba.d.ac.a(i));
            this.n.setImageResource(R.drawable.list_divider_1);
            return;
        }
        this.c.setTextColor(getResources().getColor(17170444));
        this.d.setTextColor(getResources().getColor(17170444));
        this.m.setTextColor(getResources().getColor(17170444));
        this.n.setImageResource(R.drawable.list_divider);
    }

    public void b() {
        if (this.g != null) {
            this.g.cancel();
        }
        this.g = new c(this, null);
        this.g.setPriority(3);
        this.g.execute(new String[0]);
    }

    public void c() {
        if (TiebaApplication.aR()) {
            this.o.setVisibility(0);
        } else {
            this.o.setVisibility(8);
        }
    }

    private void d() {
        this.p = new d(this, null);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.baidu.tieba.broadcast.newversion");
        registerReceiver(this.p, intentFilter);
    }

    private void m() {
        if (this.p != null) {
            unregisterReceiver(this.p);
        }
    }
}
