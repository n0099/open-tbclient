package com.baidu.tieba.more;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.browser.core.util.BdUtil;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.as;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class AppsActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private String f1465a = null;
    private BaseWebView b = null;
    private ImageView c = null;
    private t d = null;
    private LinearLayout e = null;
    private ProgressBar f = null;
    private ImageView g = null;
    private RelativeLayout j = null;
    private RelativeLayout k = null;
    private TextView l = null;

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, AppsActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    public static void b() {
        DatabaseService.a("", 7);
        com.baidu.tieba.sharedPref.b.a().b("app_inverval", System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_activity);
        d();
        a(bundle);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.f1465a = bundle.getString("url");
        } else {
            this.f1465a = getIntent().getStringExtra("url");
        }
        if (System.currentTimeMillis() - com.baidu.tieba.sharedPref.b.a().a("app_inverval", 0L) > Util.MILLSECONDS_OF_DAY) {
            c();
        } else if (!e()) {
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.d != null) {
            this.d.cancel();
        }
        this.d = new t(this, this.f1465a);
        this.d.setPriority(3);
        this.d.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void a(int i) {
        super.a(i);
        as.a(this.j, i);
        as.a(this.b, i);
        as.d(this.k, i);
        as.a(this.c, i);
        as.f(this.l, i);
        as.b(this.g, i);
    }

    private void d() {
        this.j = (RelativeLayout) findViewById(R.id.parent);
        this.k = (RelativeLayout) findViewById(R.id.title);
        this.l = (TextView) findViewById(R.id.title_text);
        this.b = (BaseWebView) findViewById(R.id.app_webView);
        this.b.setDownloadEnabled(true);
        this.f = (ProgressBar) findViewById(R.id.app_progress);
        this.e = (LinearLayout) findViewById(R.id.webview_fail_imageview);
        this.e.setOnClickListener(new q(this));
        this.g = (ImageView) findViewById(R.id.refresh);
        this.g.setOnClickListener(new r(this));
        this.c = (ImageView) findViewById(R.id.back);
        this.c.setOnClickListener(new s(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        String b = DatabaseService.b(7);
        if (b == null || b.length() <= 1) {
            return false;
        }
        this.f.setVisibility(8);
        this.b.loadDataWithBaseURL(com.baidu.tieba.data.g.f1032a, b, "text/html", BdUtil.UTF8, "");
        return true;
    }
}
