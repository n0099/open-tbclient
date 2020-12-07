package com.baidu.webkit.sdk.system;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* loaded from: classes12.dex */
final class WebViewClientWrapper extends WebViewClient {
    static final /* synthetic */ boolean $assertionsDisabled;
    private final com.baidu.webkit.sdk.WebViewClient mClient;
    private final WebViewImpl mWebView;

    static {
        $assertionsDisabled = !WebViewClientWrapper.class.desiredAssertionStatus();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebViewClientWrapper(WebViewImpl webViewImpl, com.baidu.webkit.sdk.WebViewClient webViewClient) {
        this.mWebView = webViewImpl;
        this.mClient = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.doUpdateVisitedHistory(this.mWebView.getWebView(), str, z, false, false, false);
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onFormResubmission(this.mWebView.getWebView(), message, message2);
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onLoadResource(this.mWebView.getWebView(), str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView webView, String str) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onPageCommitVisible(this.mWebView.getWebView(), str, false);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onPageFinished(this.mWebView.getWebView(), str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onPageStarted(this.mWebView.getWebView(), str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onReceivedClientCertRequest(this.mWebView.getWebView(), ClientCertRequestImpl.from(clientCertRequest));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onReceivedError(this.mWebView.getWebView(), i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onReceivedError(this.mWebView.getWebView(), WebResourceRequestImpl.from(webResourceRequest), WebResourceErrorImpl.from(webResourceError));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onReceivedHttpAuthRequest(this.mWebView.getWebView(), HttpAuthHandlerImpl.from(httpAuthHandler), str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onReceivedHttpError(this.mWebView.getWebView(), WebResourceRequestImpl.from(webResourceRequest), Glue.cast(webResourceResponse));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onReceivedLoginRequest(this.mWebView.getWebView(), str, str2, str3);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onReceivedSslError(this.mWebView.getWebView(), sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView webView, float f, float f2) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onScaleChanged(this.mWebView.getWebView(), f, f2);
    }

    @Override // android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onTooManyRedirects(this.mWebView.getWebView(), message, message2);
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        if (!$assertionsDisabled && webView != this.mWebView) {
            throw new AssertionError();
        }
        this.mClient.onUnhandledKeyEvent(this.mWebView.getWebView(), keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if ($assertionsDisabled || webView == this.mWebView) {
            return Glue.cast(this.mClient.shouldInterceptRequest(this.mWebView.getWebView(), WebResourceRequestImpl.from(webResourceRequest)));
        }
        throw new AssertionError();
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if ($assertionsDisabled || webView == this.mWebView) {
            return Glue.cast(this.mClient.shouldInterceptRequest(this.mWebView.getWebView(), str));
        }
        throw new AssertionError();
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        if ($assertionsDisabled || webView == this.mWebView) {
            return this.mClient.shouldOverrideKeyEvent(this.mWebView.getWebView(), keyEvent);
        }
        throw new AssertionError();
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if ($assertionsDisabled || webView == this.mWebView) {
            return this.mClient.shouldOverrideUrlLoading(this.mWebView.getWebView(), str);
        }
        throw new AssertionError();
    }
}
