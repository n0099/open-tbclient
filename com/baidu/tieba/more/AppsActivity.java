package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.coreExtra.view.BaseWebView;
/* loaded from: classes.dex */
public class AppsActivity extends BaseActivity {
    private String a = null;
    private BaseWebView b = null;
    private ImageView c = null;
    private j d = null;
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
        com.baidu.adp.lib.e.f.a().a(new f());
        com.baidu.tbadk.core.sharedPref.b.a().b("app_inverval", System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(com.baidu.tieba.v.app_activity);
        c();
        a(bundle);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.a = bundle.getString("url");
        } else {
            this.a = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tbadk.core.sharedPref.b.a().a("app_inverval", 0L) > 86400000) {
            b();
        } else if (!d()) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.d != null) {
            this.d.cancel();
        }
        this.d = new j(this, this.a);
        this.d.setPriority(3);
        this.d.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        com.baidu.tbadk.core.util.ay.a(this.h, i);
        com.baidu.tbadk.core.util.ay.a(this.b, i);
        com.baidu.tbadk.core.util.ay.d(this.i, i);
        com.baidu.tbadk.core.util.ay.a(this.c, i);
        com.baidu.tbadk.core.util.ay.d(this.j, i);
        com.baidu.tbadk.core.util.ay.b(this.g, i);
    }

    private void c() {
        this.h = (RelativeLayout) findViewById(com.baidu.tieba.u.parent);
        this.i = (RelativeLayout) findViewById(com.baidu.tieba.u.title);
        this.j = (TextView) findViewById(com.baidu.tieba.u.title_text);
        this.b = (BaseWebView) findViewById(com.baidu.tieba.u.app_webView);
        this.b.setDownloadEnabled(true);
        this.f = (ProgressBar) findViewById(com.baidu.tieba.u.app_progress);
        this.e = (LinearLayout) findViewById(com.baidu.tieba.u.webview_fail_imageview);
        this.e.setOnClickListener(new g(this));
        this.g = (ImageView) findViewById(com.baidu.tieba.u.refresh);
        this.g.setOnClickListener(new h(this));
        this.c = (ImageView) findViewById(com.baidu.tieba.u.back);
        this.c.setOnClickListener(new i(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        String b = com.baidu.tieba.util.k.b(7);
        if (b == null || b.length() <= 1) {
            return false;
        }
        this.f.setVisibility(8);
        this.b.loadDataWithBaseURL(TbConfig.SERVER_ADDRESS, b, "text/html", "utf-8", "");
        return true;
    }
}
