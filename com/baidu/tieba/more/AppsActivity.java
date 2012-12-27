package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.view.BaseWebView;
/* loaded from: classes.dex */
public class AppsActivity extends com.baidu.tieba.e {
    private String b = null;
    private BaseWebView c = null;
    private Button d = null;
    private r e = null;
    private LinearLayout f = null;
    private ProgressBar g = null;
    private Button h = null;

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, AppsActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.b = bundle.getString("url");
        } else {
            this.b = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - getSharedPreferences("settings", 0).getLong("app_inverval", 0L) > 86400000) {
            g();
        } else if (i()) {
        } else {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.e != null) {
            this.e.a();
        }
        this.e = new r(this, this.b);
        this.e.execute(new Object[0]);
    }

    private void h() {
        this.c = (BaseWebView) findViewById(R.id.app_webView);
        this.c.setDownloadEnabled(true);
        this.g = (ProgressBar) findViewById(R.id.app_progress);
        this.f = (LinearLayout) findViewById(R.id.webview_fail_imageview);
        this.f.setOnClickListener(new o(this));
        this.h = (Button) findViewById(R.id.refresh);
        this.h.setOnClickListener(new p(this));
        this.d = (Button) findViewById(R.id.back);
        this.d.setOnClickListener(new q(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean i() {
        String a = com.baidu.tieba.c.k.a(7);
        if (a == null || a.length() <= 1) {
            return false;
        }
        this.g.setVisibility(8);
        this.c.loadDataWithBaseURL("http://c.tieba.baidu.com/", a, "text/html", "utf-8", "");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_activity);
        h();
        a(bundle);
    }
}
