package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.RequiresApi;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.c.k;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes6.dex */
public class c extends WebViewClient {

    /* renamed from: b  reason: collision with root package name */
    protected final x f6843b;
    protected final Context c;
    protected final String d;
    protected j e;
    protected boolean f = true;
    protected boolean g = true;

    public c(Context context, x xVar, String str, j jVar) {
        this.c = context;
        this.f6843b = xVar;
        this.d = str;
        this.e = jVar;
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.e != null) {
            this.e.a(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x006e, code lost:
        if (com.bytedance.sdk.openadsdk.downloadnew.a.e.d().eFg().a(r7.c, r1, com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(r7.f6843b.f(), r7.f6843b.a(), null).eEg()) == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0112, code lost:
        if (r7.f6843b.b() != false) goto L7;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0114 -> B:29:0x0035). Please submit an issue!!! */
    @Override // android.webkit.WebViewClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse;
        String lowerCase;
        boolean z = true;
        u.b("WebChromeClient", "shouldOverrideUrlLoading " + str);
        try {
            parse = Uri.parse(str);
            lowerCase = parse.getScheme().toLowerCase();
        } catch (Exception e) {
            u.b("WebChromeClient", "shouldOverrideUrlLoading", e);
            if (this.f6843b != null) {
            }
        }
        if ("bytedance".equals(lowerCase)) {
            r.a(parse, this.f6843b);
        } else {
            if ("market".equals(lowerCase) && this.f6843b != null && this.f6843b.a() != null) {
            }
            if (!com.bytedance.sdk.openadsdk.utils.x.a(str)) {
                final String f = this.f6843b.f();
                u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading tag " + f);
                final l a2 = this.f6843b.a();
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                intent.addFlags(268435456);
                com.bytedance.sdk.openadsdk.c.d.a(this.c, a2, f, "lp_open_dpl", lowerCase);
                if (aj.a(this.c, intent)) {
                    u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading 该app已经安装 tag " + f + " URL " + str);
                    com.bytedance.sdk.openadsdk.utils.b.a(this.c, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.c.1
                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a() {
                            u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading startActivitySuccess ");
                            com.bytedance.sdk.openadsdk.c.d.b(c.this.c, a2, f, "lp_openurl");
                        }

                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a(Throwable th) {
                            u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading 调起该app失败 ");
                            com.bytedance.sdk.openadsdk.c.d.b(c.this.c, a2, f, "lp_openurl_failed");
                        }
                    });
                    u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading OpenAppSuccEvent.obtain().send true ");
                    k.a().a(a2, f, true);
                } else {
                    u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading 该app没有安装 tag " + f + " url " + str);
                    com.bytedance.sdk.openadsdk.c.d.b(this.c, a2, f, "lp_openurl_failed");
                }
            }
            z = super.shouldOverrideUrlLoading(webView, str);
        }
        return z;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (u.a()) {
            u.a("WebChromeClient", "onPageFinished " + str);
        }
        if (this.e != null) {
            this.e.a(webView, str);
        }
        if (webView != null && this.f) {
            try {
                String a2 = a.a(p.h().j(), this.d);
                if (!TextUtils.isEmpty(a2)) {
                    t.a(webView, a2);
                }
            } catch (Throwable th) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        if (this.e != null) {
            this.e.a(webView, str, bitmap);
        }
        if (this.g) {
            a.a(this.c).a(Build.VERSION.SDK_INT >= 19).a(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        if (this.e != null) {
            this.e.a(webView, i, str, str2);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.e != null && webResourceError != null) {
            this.e.a(webView, webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), null);
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.e != null && webResourceResponse != null) {
            this.e.a(webView, webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), null);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (i.c().u()) {
            if (sslErrorHandler != null) {
                try {
                    sslErrorHandler.proceed();
                    return;
                } catch (Throwable th) {
                    u.b("onReceivedSslError error" + th);
                    return;
                }
            }
            return;
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
        if (this.e != null) {
            int i = 0;
            String str = "SslError: unknown";
            if (sslError != null) {
                try {
                    i = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                } catch (Throwable th2) {
                }
            }
            this.e.a(webView, i, str, null);
        }
    }
}
