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
/* loaded from: classes5.dex */
public class f extends com.bytedance.sdk.openadsdk.core.widget.webview.c {

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f28213a;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28214h;

    public f(Context context, x xVar, com.bytedance.sdk.openadsdk.core.d.l lVar, com.bytedance.sdk.openadsdk.c.j jVar, boolean z) {
        super(context, xVar, lVar.am(), jVar);
        this.f28213a = lVar;
        this.f28214h = z;
    }

    private WebResourceResponse a(WebView webView, String str) {
        com.bytedance.sdk.openadsdk.core.d.k kVar = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e.a a2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
        if (a2 != e.a.IMAGE) {
            Iterator<com.bytedance.sdk.openadsdk.core.d.k> it = this.f28213a.af().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                com.bytedance.sdk.openadsdk.core.d.k next = it.next();
                if (!TextUtils.isEmpty(next.a()) && !TextUtils.isEmpty(str)) {
                    String a3 = next.a();
                    if (a3.startsWith("https")) {
                        a3 = a3.replaceFirst("https", "http");
                    }
                    if ((str.startsWith("https") ? str.replaceFirst("https", "http") : str).equals(a3)) {
                        kVar = next;
                        break;
                    }
                }
            }
        }
        if (a2 != e.a.IMAGE && kVar == null) {
            return com.bytedance.sdk.openadsdk.core.widget.webview.a.a.a(str, a2);
        }
        return a(str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        this.f28700f = false;
        super.onPageFinished(webView, str);
    }

    @Override // com.bytedance.sdk.openadsdk.core.widget.webview.c, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.f28701g = false;
        super.onPageStarted(webView, str, bitmap);
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

    private WebResourceResponse a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            File a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(com.bytedance.sdk.openadsdk.i.a.a.a().a(str, 0, 0, null), this.f28214h);
            if (a2 == null || !a2.exists() || a2.length() <= 0) {
                return null;
            }
            return new WebResourceResponse(e.a.IMAGE.a(), "utf-8", new FileInputStream(a2));
        } catch (Throwable th) {
            u.c("ExpressClient", "get image WebResourceResponse error", th);
            return null;
        }
    }

    private void a(long j, long j2, String str, int i) {
        com.bytedance.sdk.openadsdk.c.j jVar = this.f28699e;
        if (jVar == null || jVar.a() == null) {
            return;
        }
        e.a a2 = com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str);
        if (a2 == e.a.HTML) {
            this.f28699e.a().a(str, j, j2, i);
        } else if (a2 == e.a.JS) {
            this.f28699e.a().b(str, j, j2, i);
        }
    }
}
