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
import com.alibaba.fastjson.asm.Label;
import com.baidu.searchbox.aperf.bosuploader.BOSTokenRequest;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.b;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.r;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.u;
import com.sina.weibo.sdk.utils.FileUtils;
import d.p.a.d.g;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes5.dex */
public class c extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public static final HashSet<String> f28703a;

    /* renamed from: b  reason: collision with root package name */
    public final x f28704b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f28705c;

    /* renamed from: d  reason: collision with root package name */
    public final String f28706d;

    /* renamed from: e  reason: collision with root package name */
    public j f28707e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f28708f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28709g = true;

    static {
        HashSet<String> hashSet = new HashSet<>();
        f28703a = hashSet;
        hashSet.add("png");
        f28703a.add("ico");
        f28703a.add("jpg");
        f28703a.add("gif");
        f28703a.add("svg");
        f28703a.add("jpeg");
    }

    public c(Context context, x xVar, String str) {
        this.f28705c = context;
        this.f28704b = xVar;
        this.f28706d = str;
    }

    public static String a(String str) {
        int lastIndexOf;
        String substring;
        if (str == null || (lastIndexOf = str.lastIndexOf(46)) < 0 || lastIndexOf == str.length() - 1 || (substring = str.substring(lastIndexOf)) == null || !f28703a.contains(substring.toLowerCase(Locale.getDefault()))) {
            return null;
        }
        return FileUtils.IMAGE_FILE_START + substring;
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        if (u.a()) {
            u.a("WebChromeClient", "onPageFinished " + str);
        }
        j jVar = this.f28707e;
        if (jVar != null) {
            jVar.a(webView, str);
        }
        if (webView != null && this.f28708f) {
            try {
                String a2 = a.a(p.h().i(), this.f28706d);
                if (!TextUtils.isEmpty(a2)) {
                    t.a(webView, a2);
                }
            } catch (Throwable unused) {
            }
        }
        super.onPageFinished(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        j jVar = this.f28707e;
        if (jVar != null) {
            jVar.a(webView, str, bitmap);
        }
        if (this.f28709g) {
            a.a(this.f28705c).a(Build.VERSION.SDK_INT >= 19).a(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, int i, String str, String str2) {
        super.onReceivedError(webView, i, str, str2);
        j jVar = this.f28707e;
        if (jVar != null) {
            jVar.a(i, str, str2, a(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(21)
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (this.f28707e == null || webResourceResponse == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String uri = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("Accept")) {
            str = requestHeaders.get("Accept");
        } else if (requestHeaders.containsKey(BOSTokenRequest.ACCEPT)) {
            str = requestHeaders.get(BOSTokenRequest.ACCEPT);
        }
        this.f28707e.a(webResourceResponse.getStatusCode(), String.valueOf(webResourceResponse.getReasonPhrase()), uri, str);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (i.d().w()) {
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
        if (this.f28707e != null) {
            int i = 0;
            String str = "SslError: unknown";
            String str2 = null;
            if (sslError != null) {
                try {
                    i = sslError.getPrimaryError();
                    str = "SslError: " + String.valueOf(sslError);
                    str2 = sslError.getUrl();
                } catch (Throwable unused) {
                }
            }
            this.f28707e.a(i, str, str2, a(str2));
        }
    }

    @Override // android.webkit.WebViewClient
    @RequiresApi(api = 21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        j jVar = this.f28707e;
        if (jVar != null) {
            jVar.a(webView, webResourceRequest);
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse;
        String lowerCase;
        u.b("WebChromeClient", "shouldOverrideUrlLoading " + str);
        try {
            parse = Uri.parse(str);
            lowerCase = parse.getScheme().toLowerCase();
        } catch (Exception e2) {
            u.b("WebChromeClient", "shouldOverrideUrlLoading", e2);
            x xVar = this.f28704b;
            if (xVar != null && xVar.d()) {
                return true;
            }
        }
        if ("bytedance".equals(lowerCase)) {
            r.a(parse, this.f28704b);
            return true;
        }
        if (g.k.a(parse) && this.f28704b != null && this.f28704b.c() != null) {
            String l = this.f28704b.l();
            l c2 = this.f28704b.c();
            d.p.a.b.a.a.c p = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(l, c2, null).p();
            d.p.a.b.a.a.a e3 = com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(c2).e();
            boolean a2 = com.bytedance.sdk.openadsdk.downloadnew.a.g.d().n().a(this.f28705c, parse, p, com.bytedance.sdk.openadsdk.downloadnew.a.b.b.a(c2, this.f28704b.l()).d(), e3);
            k.a(true);
            if (a2) {
                return true;
            }
        }
        if (!com.bytedance.sdk.openadsdk.utils.x.a(str) && this.f28704b != null && this.f28704b.c() != null) {
            final String l2 = this.f28704b.l();
            u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading tag " + l2);
            final l c3 = this.f28704b.c();
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(parse);
            intent.addFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
            com.bytedance.sdk.openadsdk.c.d.a(this.f28705c, c3, l2, "lp_open_dpl", lowerCase);
            if (ak.c(this.f28705c)) {
                if (ak.a(this.f28705c, intent)) {
                    u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading 该app已经安装 tag " + l2 + " URL " + str);
                    com.bytedance.sdk.openadsdk.utils.b.a(this.f28705c, intent, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.widget.webview.c.1
                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a() {
                            u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading startActivitySuccess ");
                            com.bytedance.sdk.openadsdk.c.d.b(c.this.f28705c, c3, l2, "lp_openurl");
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), c3, l2, "lp_deeplink_success_realtime");
                        }

                        @Override // com.bytedance.sdk.openadsdk.utils.b.a
                        public void a(Throwable th) {
                            u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading 调起该app失败 ");
                            com.bytedance.sdk.openadsdk.c.d.b(c.this.f28705c, c3, l2, "lp_openurl_failed");
                            com.bytedance.sdk.openadsdk.c.d.b(p.a(), c3, l2, "lp_deeplink_fail_realtime");
                        }
                    });
                    u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading OpenAppSuccEvent.obtain().send true ");
                    com.bytedance.sdk.openadsdk.c.k.a().a(c3, l2, true);
                } else {
                    u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading 该app没有安装 tag " + l2 + " url " + str);
                    com.bytedance.sdk.openadsdk.c.d.b(this.f28705c, c3, l2, "lp_openurl_failed");
                    com.bytedance.sdk.openadsdk.c.d.b(p.a(), c3, l2, "lp_deeplink_fail_realtime");
                }
            } else {
                this.f28705c.startActivity(intent);
                u.f("TTWebViewClient", "TTWebView shouldOverrideUrlLoading startActivitySuccess ");
                com.bytedance.sdk.openadsdk.c.d.b(this.f28705c, c3, l2, "lp_openurl");
                com.bytedance.sdk.openadsdk.c.k.a().a(c3, l2, true);
            }
            return true;
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(23)
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (this.f28707e == null || webResourceError == null) {
            return;
        }
        Uri url = webResourceRequest.getUrl();
        String str = "";
        String uri = url != null ? url.toString() : "";
        Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
        if (requestHeaders.containsKey("Accept")) {
            str = requestHeaders.get("Accept");
        } else if (requestHeaders.containsKey(BOSTokenRequest.ACCEPT)) {
            str = requestHeaders.get(BOSTokenRequest.ACCEPT);
        }
        this.f28707e.a(webResourceError.getErrorCode(), String.valueOf(webResourceError.getDescription()), uri, str);
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return super.shouldInterceptRequest(webView, str);
    }

    public c(Context context, x xVar, String str, j jVar) {
        this.f28705c = context;
        this.f28704b = xVar;
        this.f28706d = str;
        this.f28707e = jVar;
    }
}
