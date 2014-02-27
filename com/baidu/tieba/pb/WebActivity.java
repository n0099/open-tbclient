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
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.cloudsdk.social.core.SocialConstants;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.tieba.util.UtilHelper;
import com.slidingmenu.lib.R;
@SuppressLint({"SetJavaScriptEnabled"})
/* loaded from: classes.dex */
public class WebActivity extends com.baidu.tieba.f {
    protected WebView a = null;
    private ImageView g = null;
    private ImageView h = null;
    private ImageView i = null;
    protected ImageView b = null;
    private ProgressBar j = null;
    protected String c = null;
    private WebChromeClient k = null;
    private LinearLayout l = null;
    protected String d = null;
    protected String e = null;
    protected ew f = null;
    private Handler m = new Handler();
    private Runnable n = new eq(this);

    public static void a(Context context, String str, String str2, String str3) {
        if (UtilHelper.e(context)) {
            BdUtilHelper.a(context, context.getString(R.string.web_view_corrupted));
            return;
        }
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra(SocialConstants.PARAM_URL, str);
        intent.putExtra("bduss", str2);
        intent.putExtra(SapiAccountManager.SESSION_PTOKEN, str3);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.g().a(this);
        UtilHelper.b((Activity) this);
        setContentView(R.layout.web_activity);
        this.l = (LinearLayout) findViewById(R.id.softkey);
        this.j = (ProgressBar) findViewById(R.id.progress);
        this.a = (WebView) findViewById(R.id.webview);
        CompatibleUtile.getInstance().removeJavascriptInterface(this.a);
        this.a.setWebViewClient(new er(this));
        this.k = CompatibleUtile.getInstance().getWebChromeClient(this);
        this.a.setWebChromeClient(this.k);
        WebSettings settings = this.a.getSettings();
        try {
            settings.setBuiltInZoomControls(true);
            settings.setJavaScriptEnabled(true);
            settings.setPluginsEnabled(true);
            UtilHelper.a(settings);
        } catch (Throwable th) {
            com.baidu.adp.lib.util.e.a(WebActivity.class.getName(), "set webview settings.", th);
        }
        this.g = (ImageView) findViewById(R.id.webBack);
        this.g.setEnabled(false);
        this.g.setOnClickListener(new es(this));
        this.h = (ImageView) findViewById(R.id.webForward);
        this.h.setEnabled(false);
        this.h.setOnClickListener(new et(this));
        this.i = (ImageView) findViewById(R.id.refresh);
        this.i.setOnClickListener(new eu(this));
        this.b = (ImageView) findViewById(R.id.back);
        this.b.setOnClickListener(new ev(this));
        if (bundle == null) {
            this.d = getIntent().getStringExtra("bduss");
        } else {
            this.d = bundle.getString("bduss");
        }
        if (bundle == null) {
            this.e = getIntent().getStringExtra(SapiAccountManager.SESSION_PTOKEN);
        } else {
            this.e = bundle.getString(SapiAccountManager.SESSION_PTOKEN);
        }
        CookieSyncManager.createInstance(this);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.setAcceptCookie(true);
        cookieManager.setCookie("baidu.com", "BDUSS=" + this.d + "; domain=.baidu.com;");
        cookieManager.setCookie("baidu.com", "PTOKEN=" + this.e + "; domain=.baidu.com;");
        CookieSyncManager.getInstance().sync();
        if (bundle != null) {
            this.c = bundle.getString(SocialConstants.PARAM_URL);
        } else {
            this.c = getIntent().getStringExtra(SocialConstants.PARAM_URL);
        }
        if (this.c == null) {
            finish();
        } else {
            this.m.postDelayed(this.n, 150L);
        }
    }

    @Override // com.baidu.tieba.f, com.baidu.adp.a.a
    public void releaseResouce() {
        super.releaseResouce();
        finish();
    }

    @Override // com.baidu.tieba.f, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            closeActivity();
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onPause() {
        super.onPause();
        this.a.pauseTimers();
        a("onPause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, android.app.Activity
    public void onResume() {
        super.onResume();
        this.a.resumeTimers();
        a("onResume");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.f, com.baidu.adp.a.a, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.m.removeCallbacks(this.n);
        TiebaApplication.g().b(this);
        if (this.j != null) {
            this.j.setVisibility(8);
        }
        if (this.k != null && (this.k instanceof CompatibleUtile.FullscreenableChromeClient)) {
            ((CompatibleUtile.FullscreenableChromeClient) this.k).hideCustomView();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString(SocialConstants.PARAM_URL, this.c);
        bundle.putString("bduss", this.d);
        bundle.putString(SapiAccountManager.SESSION_PTOKEN, this.e);
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.d = bundle.getString("bduss");
        this.e = bundle.getString(SapiAccountManager.SESSION_PTOKEN);
    }

    private void a(String str) {
        if (this.a != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.a, new Object[0]);
            } catch (Exception e) {
                com.baidu.adp.lib.util.e.b(getClass().getName(), "callHiddenWebViewMethod", "error = " + e.getMessage());
            }
        }
    }
}
