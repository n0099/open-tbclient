package com.baidu.zeus;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.KeyEvent;
/* loaded from: classes.dex */
public class WebViewClient {
    public static final int ERROR_AUTHENTICATION = -4;
    public static final int ERROR_BAD_URL = -12;
    public static final int ERROR_CONNECT = -6;
    public static final int ERROR_FAILED_SSL_HANDSHAKE = -11;
    public static final int ERROR_FILE = -13;
    public static final int ERROR_FILE_NOT_FOUND = -14;
    public static final int ERROR_HOST_LOOKUP = -2;
    public static final int ERROR_IO = -7;
    public static final int ERROR_PROXY_AUTHENTICATION = -5;
    public static final int ERROR_REDIRECT_LOOP = -9;
    public static final int ERROR_TIMEOUT = -8;
    public static final int ERROR_TOO_MANY_REQUESTS = -15;
    public static final int ERROR_UNKNOWN = -1;
    public static final int ERROR_UNSUPPORTED_AUTH_SCHEME = -3;
    public static final int ERROR_UNSUPPORTED_SCHEME = -10;

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        return false;
    }

    public boolean shouldOpenFlash(WebView webView, String str) {
        return false;
    }

    public void onFullScreenMode(WebView webView, boolean z, int i, int i2) {
    }

    public void onHasVideo(WebView webView) {
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
    }

    public void onPageFinished(WebView webView, String str) {
    }

    public void onLoadResource(WebView webView, String str) {
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return null;
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        message.sendToTarget();
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        message.sendToTarget();
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.cancel();
    }

    public void onProceededAfterSslError(WebView webView, SslError sslError) {
    }

    public void onReceivedClientCertRequest(WebView webView, ClientCertRequestHandler clientCertRequestHandler, String str) {
        clientCertRequestHandler.cancel();
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        httpAuthHandler.cancel();
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        return false;
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
    }

    public boolean shouldShowSubject(WebView webView, String str, String str2, String str3) {
        return false;
    }

    public void onSubjectsCollected(WebView webView, boolean z, int i) {
    }

    public void onMainActionsCollected(WebView webView, boolean z, int i) {
    }

    public boolean onTextCopied(WebView webView) {
        return false;
    }

    public void onBaiduSearchPVCollected(WebView webView) {
    }

    public void onFirstLayoutDid(WebView webView, String str) {
    }

    public void onPageCanBeScaled(WebView webView) {
    }

    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
    }
}
