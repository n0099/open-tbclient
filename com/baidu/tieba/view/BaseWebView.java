package com.baidu.tieba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes.dex */
public class BaseWebView extends WebView {

    /* renamed from: a  reason: collision with root package name */
    private WebViewClient f1782a;
    private d b;
    private Context c;
    private d d;
    private e e;

    public BaseWebView(Context context) {
        super(context);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.c = context;
        a();
    }

    public void setDownloadEnabled(boolean z) {
        if (z) {
            if (this.d == null) {
                b();
            }
            setOnLoadUrlListener(this.d);
            return;
        }
        setOnLoadUrlListener(null);
    }

    public BaseWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.c = context;
        a();
    }

    public void a() {
        getSettings().setJavaScriptEnabled(true);
        getSettings().setCacheMode(2);
        com.baidu.tieba.util.am.a(getSettings());
        this.f1782a = new MyWebViewClient();
        setWebViewClient(this.f1782a);
        setOnLongClickListener(new b(this));
    }

    /* loaded from: classes.dex */
    public class MyWebViewClient extends WebViewClient {
        public MyWebViewClient() {
        }

        @Override // android.webkit.WebViewClient
        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            Log.d("BaseWebView", "@onPageStarted = " + str);
        }

        @Override // android.webkit.WebViewClient
        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            if (BaseWebView.this.e != null) {
                BaseWebView.this.e.a(webView, str);
            }
            Log.d("BaseWebView", "@onPageFinished = " + str);
        }

        @Override // android.webkit.WebViewClient
        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            if (BaseWebView.this.b != null) {
                return BaseWebView.this.b.a(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        @Override // android.webkit.WebViewClient
        public void onReceivedError(WebView webView, int i, String str, String str2) {
            super.onReceivedError(webView, i, str, str2);
        }
    }

    public void setOnLoadUrlListener(d dVar) {
        this.b = dVar;
    }

    public void setOnPageFinishedListener(e eVar) {
        this.e = eVar;
    }

    private void b() {
        this.d = new c(this);
    }
}
