package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.view.BaseWebView;
/* loaded from: classes.dex */
public class AppsActivity extends com.baidu.tieba.e {
    private String c = null;
    private BaseWebView d = null;
    private Button e = null;
    private s f = null;
    private LinearLayout g = null;
    private ProgressBar h = null;
    private Button i = null;
    private RelativeLayout j = null;
    private RelativeLayout k = null;
    private TextView l = null;

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, AppsActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    public static void i() {
        com.baidu.tieba.c.k.a("", 7);
        SharedPreferences.Editor edit = TiebaApplication.b().getSharedPreferences("settings", 0).edit();
        edit.putLong("app_inverval", System.currentTimeMillis());
        edit.commit();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_activity);
        k();
        a(bundle);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getString("url");
        } else {
            this.c = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - getSharedPreferences("settings", 0).getLong("app_inverval", 0L) > 86400000) {
            j();
        } else if (!l()) {
            j();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.f != null) {
            this.f.a();
        }
        this.f = new s(this, this.c);
        this.f.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e
    public void b(int i) {
        super.b(i);
        com.baidu.tieba.c.ad.a(this.j, i);
        com.baidu.tieba.c.ad.a(this.d, i);
        com.baidu.tieba.c.ad.c(this.k, i);
        com.baidu.tieba.c.ad.e((TextView) this.e, i);
        com.baidu.tieba.c.ad.c(this.l, i);
        com.baidu.tieba.c.ad.e((View) this.i, i);
    }

    private void k() {
        this.j = (RelativeLayout) findViewById(R.id.parent);
        this.k = (RelativeLayout) findViewById(R.id.title);
        this.l = (TextView) findViewById(R.id.title_text);
        this.d = (BaseWebView) findViewById(R.id.app_webView);
        this.d.setDownloadEnabled(true);
        this.h = (ProgressBar) findViewById(R.id.app_progress);
        this.g = (LinearLayout) findViewById(R.id.webview_fail_imageview);
        this.g.setOnClickListener(new p(this));
        this.i = (Button) findViewById(R.id.refresh);
        this.i.setOnClickListener(new q(this));
        this.e = (Button) findViewById(R.id.back);
        this.e.setOnClickListener(new r(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean l() {
        String b = com.baidu.tieba.c.k.b(7);
        if (b == null || b.length() <= 1) {
            return false;
        }
        this.h.setVisibility(8);
        this.d.loadDataWithBaseURL("http://c.tieba.baidu.com/", b, "text/html", BdUtil.UTF8, "");
        return true;
    }
}
