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
import com.baidu.tieba.model.cc;
import com.baidu.tieba.util.ao;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class AboutActivity extends com.baidu.tieba.g {
    private ImageView o;

    /* renamed from: a */
    private TextView f1424a = null;
    private TextView b = null;
    private ImageView c = null;
    private Button d = null;
    private c e = null;
    private cc f = null;
    private LinearLayout g = null;
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
    @Override // com.baidu.tieba.g, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.about_activity);
        this.j = (ProgressBar) findViewById(R.id.about_progress);
        this.k = findViewById(R.id.title);
        this.g = (LinearLayout) findViewById(R.id.parent);
        this.l = (TextView) findViewById(R.id.title_text);
        this.b = (TextView) findViewById(R.id.author);
        this.m = (TextView) findViewById(R.id.info);
        this.n = (ImageView) findViewById(R.id.divider);
        this.f1424a = (TextView) findViewById(R.id.version);
        this.f1424a.setText(String.valueOf(getString(R.string.app_name)) + " Android " + com.baidu.tieba.data.g.j());
        this.c = (ImageView) findViewById(R.id.title_back);
        this.c.setOnClickListener(new a(this));
        this.d = (Button) findViewById(R.id.check_update_button);
        this.d.setOnClickListener(new b(this));
        this.o = (ImageView) findViewById(R.id.new_version_logo_about);
        c();
        d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        k();
        if (this.e != null) {
            this.e.cancel();
        }
        if (this.j != null) {
            this.j.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.g
    public void a(int i) {
        super.a(i);
        ao.a(this.g, i);
        ao.d(this.k, i);
        ao.a(this.c, i);
        ao.f(this.l, i);
        if (i == 1) {
            this.f1424a.setTextColor(ao.a(i));
            this.b.setTextColor(ao.a(i));
            this.m.setTextColor(ao.a(i));
            this.n.setImageResource(R.drawable.list_divider_1);
            return;
        }
        this.f1424a.setTextColor(getResources().getColor(17170444));
        this.b.setTextColor(getResources().getColor(17170444));
        this.m.setTextColor(getResources().getColor(17170444));
        this.n.setImageResource(R.drawable.list_divider);
    }

    public void b() {
        if (this.e != null) {
            this.e.cancel();
        }
        this.e = new c(this, null);
        this.e.setPriority(3);
        this.e.execute(new String[0]);
    }

    public void c() {
        if (TiebaApplication.aP()) {
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

    private void k() {
        if (this.p != null) {
            unregisterReceiver(this.p);
        }
    }
}
