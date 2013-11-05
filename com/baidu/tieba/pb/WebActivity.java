package com.baidu.tieba.pb;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class WebActivity extends com.baidu.tieba.j {

    /* renamed from: a  reason: collision with root package name */
    protected WebView f2035a = null;
    private ImageView g = null;
    private ImageView j = null;
    private ImageView k = null;
    protected ImageView b = null;
    private ProgressBar l = null;
    protected String c = null;
    private WebChromeClient m = null;
    private LinearLayout n = null;
    protected String d = null;
    protected String e = null;
    protected dt f = null;
    private Handler o = new Handler();
    private Runnable p = new dn(this);

    public static void a(Context context, String str, String str2, String str3) {
        if (UtilHelper.f(context)) {
            UtilHelper.a(context, context.getString(R.string.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(SocialConstants.PARAM_URL, str);
        intent.putExtra(SocialConstants.PARAM_BDUSS, str2);
        intent.putExtra("ptoken", str3);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.g().a((com.baidu.tieba.j) this);
        UtilHelper.b((Activity) this);
        c();
        if (bundle == null) {
            this.d = getIntent().getStringExtra(SocialConstants.PARAM_BDUSS);
        } else {
            this.d = bundle.getString(SocialConstants.PARAM_BDUSS);
        }
        if (bundle == null) {
            this.e = getIntent().getStringExtra("ptoken");
        } else {
            this.e = bundle.getString("ptoken");
        }
        b();
        a(bundle);
    }

    public void b() {
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("baidu.com", "BDUSS=" + this.d + "; domain=.baidu.com;");
        cookieManager.setCookie("baidu.com", "PTOKEN=" + this.e + "; domain=.baidu.com;");
        CookieSyncManager.getInstance().sync();
    }

    @Override // com.baidu.tieba.j, com.baidu.adp.a.a
    public void a_() {
        super.a_();
        finish();
    }

    private void c() {
        setContentView(R.layout.web_activity);
        this.n = (LinearLayout) findViewById(R.id.softkey);
        this.l = (ProgressBar) findViewById(R.id.progress);
        this.f2035a = (WebView) findViewById(R.id.webview);
        CompatibleUtile.getInstance().removeJavascriptInterface(this.f2035a);
        this.f2035a.setWebViewClient(new Cdo(this));
        this.m = CompatibleUtile.getInstance().getWebChromeClient(this);
        this.f2035a.setWebChromeClient(this.m);
        WebSettings settings = this.f2035a.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setPluginsEnabled(true);
        UtilHelper.a(settings);
        this.g = (ImageView) findViewById(R.id.webBack);
        this.g.setEnabled(false);
        this.g.setOnClickListener(new dp(this));
        this.j = (ImageView) findViewById(R.id.webForward);
        this.j.setEnabled(false);
        this.j.setOnClickListener(new dq(this));
        this.k = (ImageView) findViewById(R.id.refresh);
        this.k.setOnClickListener(new dr(this));
        this.b = (ImageView) findViewById(R.id.back);
        this.b.setOnClickListener(new ds(this));
    }

    @Override // com.baidu.tieba.j, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            h();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f2035a.pauseTimers();
        c("onPause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onResume() {
        super.onResume();
        this.f2035a.resumeTimers();
        c("onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.j, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.o.removeCallbacks(this.p);
        TiebaApplication.g().b((com.baidu.tieba.j) this);
        if (this.l != null) {
            this.l.setVisibility(8);
        }
        if (this.m != null && (this.m instanceof CompatibleUtile.FullscreenableChromeClient)) {
            ((CompatibleUtile.FullscreenableChromeClient) this.m).hideCustomView();
        }
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.c = bundle.getString(SocialConstants.PARAM_URL);
        } else {
            this.c = getIntent().getStringExtra(SocialConstants.PARAM_URL);
        }
        if (this.c == null) {
            finish();
        } else {
            this.o.postDelayed(this.p, 150L);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(SocialConstants.PARAM_URL, this.c);
        bundle.putString(SocialConstants.PARAM_BDUSS, this.d);
        bundle.putString("ptoken", this.e);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.d = bundle.getString(SocialConstants.PARAM_BDUSS);
        this.e = bundle.getString("ptoken");
    }

    private void c(String str) {
        if (this.f2035a != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.f2035a, new Object[0]);
            } catch (Exception e) {
                com.baidu.tieba.util.be.b(getClass().getName(), "callHiddenWebViewMethod", "error = " + e.getMessage());
            }
        }
    }
}
