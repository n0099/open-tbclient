package com.baidu.tieba.pb;

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
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.slidingmenu.lib.R;
/* loaded from: classes.dex */
public class WebActivity extends com.baidu.tieba.e {
    protected WebView c = null;
    private ImageView i = null;
    private ImageView j = null;
    private ImageView k = null;
    protected ImageView d = null;
    private ProgressBar l = null;
    protected String e = null;
    private WebChromeClient m = null;
    private LinearLayout n = null;
    protected String f = null;
    protected String g = null;
    protected df h = null;
    private Handler o = new Handler();
    private Runnable p = new cz(this);

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", str);
        intent.putExtra("bduss", str2);
        intent.putExtra("ptoken", str3);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.e().a((com.baidu.tieba.e) this);
        com.baidu.tieba.d.ag.b((Activity) this);
        d();
        if (bundle == null) {
            this.f = getIntent().getStringExtra("bduss");
        } else {
            this.f = bundle.getString("bduss");
        }
        if (bundle == null) {
            this.g = getIntent().getStringExtra("ptoken");
        } else {
            this.g = bundle.getString("ptoken");
        }
        b();
        a(bundle);
    }

    public void b() {
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("baidu.com", "BDUSS=" + this.f + "; domain=.baidu.com;");
        cookieManager.setCookie("baidu.com", "PTOKEN=" + this.g + "; domain=.baidu.com;");
        CookieSyncManager.getInstance().sync();
    }

    @Override // com.baidu.tieba.e, com.baidu.adp.a.a
    public void a_() {
        super.a_();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.n.setVisibility(8);
    }

    private void d() {
        setContentView(R.layout.web_activity);
        this.n = (LinearLayout) findViewById(R.id.softkey);
        this.l = (ProgressBar) findViewById(R.id.progress);
        this.c = (WebView) findViewById(R.id.webview);
        this.c.setWebViewClient(new da(this));
        this.m = CompatibleUtile.getInstance().getWebChromeClient(this);
        this.c.setWebChromeClient(this.m);
        WebSettings settings = this.c.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setPluginsEnabled(true);
        com.baidu.tieba.d.ag.a(settings);
        this.i = (ImageView) findViewById(R.id.webBack);
        this.i.setEnabled(false);
        this.i.setOnClickListener(new db(this));
        this.j = (ImageView) findViewById(R.id.webForward);
        this.j.setEnabled(false);
        this.j.setOnClickListener(new dc(this));
        this.k = (ImageView) findViewById(R.id.refresh);
        this.k.setOnClickListener(new dd(this));
        this.d = (ImageView) findViewById(R.id.back);
        this.d.setOnClickListener(new de(this));
    }

    @Override // com.baidu.tieba.e, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            f();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.c.pauseTimers();
        c("onPause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.c.resumeTimers();
        c("onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.o.removeCallbacks(this.p);
        TiebaApplication.e().b((com.baidu.tieba.e) this);
        if (this.l != null) {
            this.l.setVisibility(8);
        }
        if (this.m != null && (this.m instanceof CompatibleUtile.FullscreenableChromeClient)) {
            ((CompatibleUtile.FullscreenableChromeClient) this.m).hideCustomView();
        }
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.e = bundle.getString("url");
        } else {
            this.e = getIntent().getStringExtra("url");
        }
        if (this.e == null) {
            finish();
        } else {
            this.o.postDelayed(this.p, 150L);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("url", this.e);
        bundle.putString("bduss", this.f);
        bundle.putString("ptoken", this.g);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f = bundle.getString("bduss");
        this.g = bundle.getString("ptoken");
    }

    private void c(String str) {
        if (this.c != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.c, new Object[0]);
            } catch (Exception e) {
                com.baidu.tieba.d.ae.b(getClass().getName(), "callHiddenWebViewMethod", "error = " + e.getMessage());
            }
        }
    }

    public void a(df dfVar) {
        this.h = dfVar;
    }
}
