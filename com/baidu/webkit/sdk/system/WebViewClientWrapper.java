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
/* loaded from: classes5.dex */
public final class WebViewClientWrapper extends WebViewClient {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    public final com.baidu.webkit.sdk.WebViewClient mClient;
    public final WebViewImpl mWebView;

    public WebViewClientWrapper(WebViewImpl webViewImpl, com.baidu.webkit.sdk.WebViewClient webViewClient) {
        this.mWebView = webViewImpl;
        this.mClient = webViewClient;
    }

    @Override // android.webkit.WebViewClient
    public final void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        this.mClient.doUpdateVisitedHistory(this.mWebView.getWebView(), str, z, false, false, false);
    }

    @Override // android.webkit.WebViewClient
    public final void onFormResubmission(WebView webView, Message message, Message message2) {
        this.mClient.onFormResubmission(this.mWebView.getWebView(), message, message2);
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        this.mClient.onLoadResource(this.mWebView.getWebView(), str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageCommitVisible(WebView webView, String str) {
        this.mClient.onPageCommitVisible(this.mWebView.getWebView(), str, false);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        this.mClient.onPageFinished(this.mWebView.getWebView(), str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.mClient.onPageStarted(this.mWebView.getWebView(), str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public final void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
        this.mClient.onReceivedClientCertRequest(this.mWebView.getWebView(), ClientCertRequestImpl.from(clientCertRequest));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        this.mClient.onReceivedError(this.mWebView.getWebView(), i, str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.mClient.onReceivedError(this.mWebView.getWebView(), WebResourceRequestImpl.from(webResourceRequest), WebResourceErrorImpl.from(webResourceError));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.mClient.onReceivedHttpAuthRequest(this.mWebView.getWebView(), HttpAuthHandlerImpl.from(httpAuthHandler), str, str2);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.mClient.onReceivedHttpError(this.mWebView.getWebView(), WebResourceRequestImpl.from(webResourceRequest), Glue.cast(webResourceResponse));
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        this.mClient.onReceivedLoginRequest(this.mWebView.getWebView(), str, str2, str3);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.mClient.onReceivedSslError(this.mWebView.getWebView(), sslErrorHandler, sslError);
    }

    @Override // android.webkit.WebViewClient
    public final void onScaleChanged(WebView webView, float f2, float f3) {
        this.mClient.onScaleChanged(this.mWebView.getWebView(), f2, f3);
    }

    @Override // android.webkit.WebViewClient
    public final void onTooManyRedirects(WebView webView, Message message, Message message2) {
        this.mClient.onTooManyRedirects(this.mWebView.getWebView(), message, message2);
    }

    @Override // android.webkit.WebViewClient
    public final void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.mClient.onUnhandledKeyEvent(this.mWebView.getWebView(), keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return Glue.cast(this.mClient.shouldInterceptRequest(this.mWebView.getWebView(), WebResourceRequestImpl.from(webResourceRequest)));
    }

    @Override // android.webkit.WebViewClient
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return Glue.cast(this.mClient.shouldInterceptRequest(this.mWebView.getWebView(), str));
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return this.mClient.shouldOverrideKeyEvent(this.mWebView.getWebView(), keyEvent);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return this.mClient.shouldOverrideUrlLoading(this.mWebView.getWebView(), str);
    }
}
