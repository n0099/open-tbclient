package com.baidu.tieba.pb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.R;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class WebActivity extends com.baidu.tieba.e {
    private WebView b = null;
    private ImageView c = null;
    private ImageView d = null;
    private Button e = null;
    private Button f = null;
    private ProgressBar g = null;
    private String h = null;
    private WebChromeClient i = null;

    public static void a(Context context, String str) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", str);
        context.startActivity(intent);
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            this.h = bundle.getString("url");
        } else {
            this.h = getIntent().getStringExtra("url");
        }
        String guessUrl = URLUtil.guessUrl(this.h);
        if (this.h == null || !URLUtil.isNetworkUrl(guessUrl)) {
            return;
        }
        this.b.loadUrl(guessUrl);
    }

    private void c(String str) {
        if (this.b != null) {
            try {
                WebView.class.getMethod(str, new Class[0]).invoke(this.b, new Object[0]);
            } catch (Exception e) {
                com.baidu.tieba.c.ae.b(getClass().getName(), "callHiddenWebViewMethod", "error = " + e.getMessage());
            }
        }
    }

    private void g() {
        setContentView(R.layout.web_activity);
        this.g = (ProgressBar) findViewById(R.id.progress);
        this.b = (WebView) findViewById(R.id.webview);
        this.b.setWebViewClient(new dk(this));
        this.i = CompatibleUtile.getInstance().getWebChromeClient(this);
        this.b.setWebChromeClient(this.i);
        WebSettings settings = this.b.getSettings();
        settings.setBuiltInZoomControls(true);
        settings.setJavaScriptEnabled(true);
        settings.setPluginsEnabled(true);
        com.baidu.tieba.c.ag.a(settings);
        this.c = (ImageView) findViewById(R.id.webBack);
        this.c.setEnabled(false);
        this.c.setOnClickListener(new dl(this));
        this.d = (ImageView) findViewById(R.id.webForward);
        this.d.setEnabled(false);
        this.d.setOnClickListener(new dm(this));
        this.e = (Button) findViewById(R.id.refresh);
        this.e.setOnClickListener(new dn(this));
        this.f = (Button) findViewById(R.id.back);
        this.f.setOnClickListener(new Cdo(this));
    }

    @Override // com.baidu.tieba.e
    public void a() {
        super.a();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        TiebaApplication.a().a((com.baidu.tieba.e) this);
        com.baidu.tieba.c.ag.c((Activity) this);
        g();
        a(bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TiebaApplication.a().b((com.baidu.tieba.e) this);
        if (this.g != null) {
            this.g.setVisibility(8);
        }
        if (this.i == null || !(this.i instanceof CompatibleUtile.FullscreenableChromeClient)) {
            return;
        }
        ((CompatibleUtile.FullscreenableChromeClient) this.i).hideCustomView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onPause() {
        super.onPause();
        this.b.pauseTimers();
        c("onPause");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.e, android.app.Activity
    public void onResume() {
        super.onResume();
        this.b.resumeTimers();
        c("onResume");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("url", this.h);
    }
}
