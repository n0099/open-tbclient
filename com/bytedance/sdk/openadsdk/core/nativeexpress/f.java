package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import org.apache.http.HttpHost;
/* loaded from: classes4.dex */
public class f extends com.bytedance.sdk.openadsdk.core.widget.webview.c {

    /* renamed from: a  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.d.l f6936a;
    private boolean h;

    public f(Context context, x xVar, com.bytedance.sdk.openadsdk.core.d.l lVar, com.bytedance.sdk.openadsdk.c.j jVar, boolean z) {
        super(context, xVar, lVar.T(), jVar);
        this.f6936a = lVar;
        this.h = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        try {
            return shouldInterceptRequest(webView, webResourceRequest.getUrl().toString());
        } catch (Throwable th) {
            u.c("ExpressClient", "shouldInterceptRequest error1", th);
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            WebResourceResponse a2 = a(webView, str);
            a(currentTimeMillis, System.currentTimeMillis(), str, a2 != null ? 1 : 2);
            if (a2 != null) {
                return a2;
            }
        } catch (Throwable th) {
            u.c("ExpressClient", "shouldInterceptRequest error2", th);
        }
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.g = false;
        super.onPageStarted(webView, str, bitmap);
    }

    private WebResourceResponse a(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.core.d.k kVar;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e.a a2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
        if (a2 != e.a.IMAGE) {
            Iterator<com.bytedance.sdk.openadsdk.core.d.k> it = this.f6936a.M().iterator();
            while (it.hasNext()) {
                kVar = it.next();
                if (!TextUtils.isEmpty(kVar.a()) && !TextUtils.isEmpty(str)) {
                    String a3 = kVar.a();
                    if (a3.startsWith("https")) {
                        a3 = a3.replaceFirst("https", HttpHost.DEFAULT_SCHEME_NAME);
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", HttpHost.DEFAULT_SCHEME_NAME) : str).equals(a3)) {
                        break;
                    }
                }
            }
        }
        kVar = null;
        if (a2 == e.a.IMAGE || kVar != null) {
            return a(str);
        }
        return com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(str, a2);
    }

    private WebResourceResponse a(String str) {
        WebResourceResponse webResourceResponse;
        File a2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(com.bytedance.sdk.openadsdk.i.a.a.a().a(str, 0, 0, null), this.h);
        } catch (Throwable th) {
            u.c("ExpressClient", "get image WebResourceResponse error", th);
        }
        if (a2 != null && a2.exists() && a2.length() > 0) {
            webResourceResponse = new WebResourceResponse(e.a.IMAGE.a(), "utf-8", new FileInputStream(a2));
            return webResourceResponse;
        }
        webResourceResponse = null;
        return webResourceResponse;
    }

    private void a(long j, long j2, String str, int i) {
        if (this.e != null && this.e.a() != null) {
            e.a a2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
            if (a2 == e.a.HTML) {
                this.e.a().a(str, j, j2, i);
            } else if (a2 == e.a.JS) {
                this.e.a().b(str, j, j2, i);
            }
        }
    }
}
