package com.baidu.tieba.passaccount.app;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.webkit.CookieManager;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r extends WebViewClient {
    final /* synthetic */ QALoginActivity eom;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(QALoginActivity qALoginActivity) {
        this.eom = qALoginActivity;
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        sslErrorHandler.proceed();
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String str2;
        String str3;
        WebView webView2;
        WebView webView3;
        String str4;
        super.onPageStarted(webView, str, bitmap);
        str2 = this.eom.eok;
        if (str.startsWith(str2)) {
            String cookie = CookieManager.getInstance().getCookie(str);
            if (cookie.contains("BDUSS=")) {
                String[] split = cookie.split("=");
                int i = 0;
                while (true) {
                    if (i >= split.length) {
                        break;
                    } else if (!split[i].contains("BDUSS") || i + 1 >= split.length) {
                        i++;
                    } else {
                        this.eom.mBduss = split[i + 1];
                        break;
                    }
                }
            }
            str3 = this.eom.mBduss;
            if (str3 != null) {
                str4 = this.eom.mBduss;
                if (str4.length() > 0) {
                    this.eom.aLw();
                    return;
                }
            }
            this.eom.showToast("登录失败");
            if (com.baidu.adp.lib.util.i.hj()) {
                webView2 = this.eom.mWebView;
                if (webView2 != null) {
                    webView3 = this.eom.mWebView;
                    webView3.reload();
                }
            }
        }
    }
}
