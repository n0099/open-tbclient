package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
public class AppsActivity extends com.baidu.tbadk.a {
    private String a = null;
    private BaseWebView b = null;
    private ImageView c = null;
    private i d = null;
    private LinearLayout e = null;
    private ProgressBar f = null;
    private ImageView g = null;
    private RelativeLayout h = null;
    private RelativeLayout i = null;
    private TextView j = null;

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, AppsActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    public static void a() {
        com.baidu.tieba.util.k.a("", 7);
        com.baidu.tbadk.core.sharedPref.b.a().b("app_inverval", System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.a.i.app_activity);
        this.h = (RelativeLayout) findViewById(com.baidu.tieba.a.h.parent);
        this.i = (RelativeLayout) findViewById(com.baidu.tieba.a.h.title);
        this.j = (TextView) findViewById(com.baidu.tieba.a.h.title_text);
        this.b = (BaseWebView) findViewById(com.baidu.tieba.a.h.app_webView);
        this.b.setDownloadEnabled(true);
        this.f = (ProgressBar) findViewById(com.baidu.tieba.a.h.app_progress);
        this.e = (LinearLayout) findViewById(com.baidu.tieba.a.h.webview_fail_imageview);
        this.e.setOnClickListener(new f(this));
        this.g = (ImageView) findViewById(com.baidu.tieba.a.h.refresh);
        this.g.setOnClickListener(new g(this));
        this.c = (ImageView) findViewById(com.baidu.tieba.a.h.back);
        this.c.setOnClickListener(new h(this));
        if (bundle != null) {
            this.a = bundle.getString("url");
        } else {
            this.a = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.a().a("app_inverval", 0L) > 86400000) {
            b();
        } else if (!c()) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.d != null) {
            this.d.cancel();
        }
        this.d = new i(this, this.a);
        this.d.setPriority(3);
        this.d.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.a
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        ba.a(this.h, i);
        ba.a(this.b, i);
        ba.d(this.i, i);
        ba.a(this.c, i);
        ba.d(this.j, i);
        ba.b(this.g, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c() {
        String a = com.baidu.tieba.util.k.a(7);
        if (a == null || a.length() <= 1) {
            return false;
        }
        this.f.setVisibility(8);
        this.b.loadDataWithBaseURL(com.baidu.tbadk.core.data.n.a, a, "text/html", "utf-8", "");
        return true;
    }
}
