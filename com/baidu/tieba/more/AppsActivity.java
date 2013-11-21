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
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.util.DatabaseService;
import com.baidu.tieba.util.bd;
import com.baidu.tieba.view.BaseWebView;
import com.slidingmenu.lib.R;
import com.tencent.mm.sdk.platformtools.Util;
/* loaded from: classes.dex */
public class AppsActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    private String f1941a = null;
    private BaseWebView b = null;
    private ImageView c = null;
    private v d = null;
    private LinearLayout e = null;
    private ProgressBar f = null;
    private ImageView g = null;
    private RelativeLayout h = null;
    private RelativeLayout i = null;
    private TextView j = null;

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, AppsActivity.class);
        intent.putExtra(SocialConstants.PARAM_URL, str);
        context.startActivity(intent);
    }

    public static void a() {
        DatabaseService.a("", 7);
        com.baidu.tieba.sharedPref.b.a().b("app_inverval", System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.app_activity);
        c();
        a(bundle);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.f1941a = bundle.getString(SocialConstants.PARAM_URL);
        } else {
            this.f1941a = getIntent().getStringExtra(SocialConstants.PARAM_URL);
        }
        if (System.currentTimeMillis() - com.baidu.tieba.sharedPref.b.a().a("app_inverval", 0L) > Util.MILLSECONDS_OF_DAY) {
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
        this.d = new v(this, this.f1941a);
        this.d.setPriority(3);
        this.d.execute(new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        bd.a(this.h, i);
        bd.a(this.b, i);
        bd.d(this.i, i);
        bd.a(this.c, i);
        bd.e(this.j, i);
        bd.b(this.g, i);
    }

    private void c() {
        this.h = (RelativeLayout) findViewById(R.id.parent);
        this.i = (RelativeLayout) findViewById(R.id.title);
        this.j = (TextView) findViewById(R.id.title_text);
        this.b = (BaseWebView) findViewById(R.id.app_webView);
        this.b.setDownloadEnabled(true);
        this.f = (ProgressBar) findViewById(R.id.app_progress);
        this.e = (LinearLayout) findViewById(R.id.webview_fail_imageview);
        this.e.setOnClickListener(new s(this));
        this.g = (ImageView) findViewById(R.id.refresh);
        this.g.setOnClickListener(new t(this));
        this.c = (ImageView) findViewById(R.id.back);
        this.c.setOnClickListener(new u(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean d() {
        String b = DatabaseService.b(7);
        if (b == null || b.length() <= 1) {
            return false;
        }
        this.f.setVisibility(8);
        this.b.loadDataWithBaseURL(com.baidu.tieba.data.h.f1201a, b, "text/html", BdUtil.UTF8, "");
        return true;
    }
}
