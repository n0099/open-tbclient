package com.baidu.tieba.pb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.URLUtil;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.baidu.tieba.BaseActivity;
import com.baidu.tieba.R;
import com.baidu.tieba.util.TiebaLog;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public class WebActivity extends BaseActivity {
    WebView mWebView = null;
    ImageView mWebback = null;
    ImageView mWebForward = null;
    Button mRefresh = null;
    Button mBack = null;
    ProgressBar progress = null;
    String url = null;

    public static void startActivity(Context context, String url) {
        Intent intent = new Intent(context, WebActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        InitUI();
        InitData(savedInstanceState);
    }

    private void InitUI() {
        setContentView(R.layout.web_activity);
        this.progress = (ProgressBar) findViewById(R.id.progress);
        this.mWebView = (WebView) findViewById(R.id.webview);
        this.mWebView.setWebViewClient(new WebViewClient() { // from class: com.baidu.tieba.pb.WebActivity.1
            @Override // android.webkit.WebViewClient
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (WebActivity.this.mWebView.canGoBack()) {
                    WebActivity.this.mWebback.setEnabled(true);
                } else {
                    WebActivity.this.mWebback.setEnabled(false);
                }
                if (WebActivity.this.mWebView.canGoForward()) {
                    WebActivity.this.mWebForward.setEnabled(true);
                } else {
                    WebActivity.this.mWebForward.setEnabled(false);
                }
                WebActivity.this.progress.setVisibility(8);
                WebActivity.this.mRefresh.setVisibility(0);
            }

            @Override // android.webkit.WebViewClient
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (WebActivity.this.mWebView.canGoBack()) {
                    WebActivity.this.mWebback.setEnabled(true);
                } else {
                    WebActivity.this.mWebback.setEnabled(false);
                }
                if (WebActivity.this.mWebView.canGoForward()) {
                    WebActivity.this.mWebForward.setEnabled(true);
                } else {
                    WebActivity.this.mWebForward.setEnabled(false);
                }
                WebActivity.this.progress.setVisibility(0);
                WebActivity.this.mRefresh.setVisibility(8);
            }
        });
        this.mWebView.setWebChromeClient(new WebChromeClient() { // from class: com.baidu.tieba.pb.WebActivity.2
            @Override // android.webkit.WebChromeClient
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        });
        WebSettings webSettings = this.mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setPluginsEnabled(true);
        this.mWebback = (ImageView) findViewById(R.id.webBack);
        this.mWebback.setEnabled(false);
        this.mWebback.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.WebActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WebActivity.this.mWebView.canGoBack()) {
                    WebActivity.this.mWebView.goBack();
                }
            }
        });
        this.mWebForward = (ImageView) findViewById(R.id.webForward);
        this.mWebForward.setEnabled(false);
        this.mWebForward.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.WebActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                if (WebActivity.this.mWebView.canGoForward()) {
                    WebActivity.this.mWebView.goForward();
                }
            }
        });
        this.mRefresh = (Button) findViewById(R.id.refresh);
        this.mRefresh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.WebActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WebActivity.this.mWebView.reload();
            }
        });
        this.mBack = (Button) findViewById(R.id.back);
        this.mBack.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.pb.WebActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View v) {
                WebActivity.this.finish();
            }
        });
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.mWebView.pauseTimers();
        callHiddenWebViewMethod("onPause");
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        this.mWebView.resumeTimers();
        callHiddenWebViewMethod("onResume");
    }

    private void InitData(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            this.url = savedInstanceState.getString("url");
        } else {
            Intent intent = getIntent();
            this.url = intent.getStringExtra("url");
        }
        String validUrl = URLUtil.guessUrl(this.url);
        if (this.url != null && URLUtil.isNetworkUrl(validUrl)) {
            this.mWebView.loadUrl(validUrl);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.BaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.progress != null) {
            this.progress.setVisibility(8);
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("url", this.url);
    }

    private void callHiddenWebViewMethod(String name) {
        if (this.mWebView != null) {
            try {
                Method method = WebView.class.getMethod(name, new Class[0]);
                method.invoke(this.mWebView, new Object[0]);
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "callHiddenWebViewMethod", "error = " + ex.getMessage());
            }
        }
    }
}
