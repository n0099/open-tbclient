package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f29546a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f29547b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f29548c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f29549d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f29550e = true;

    /* renamed from: f  reason: collision with root package name */
    public boolean f29551f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f29552g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f29553h = true;

    public a(Context context) {
        this.f29546a = new WeakReference<>(context);
    }

    public static a a(Context context) {
        return new a(context);
    }

    public a b(boolean z) {
        this.f29548c = z;
        return this;
    }

    private void b(WebView webView) {
        try {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        } catch (Throwable th) {
            u.b(th.toString());
        }
    }

    public a a(boolean z) {
        this.f29553h = z;
        return this;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0078 -> B:44:0x007b). Please submit an issue!!! */
    @SuppressLint({"SetJavaScriptEnabled"})
    public void a(WebView webView) {
        if (webView == null || this.f29546a.get() == null) {
            return;
        }
        b(webView);
        WebSettings settings = webView.getSettings();
        a(settings);
        if (settings == null) {
            return;
        }
        try {
            settings.setJavaScriptEnabled(true);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.f29548c) {
                settings.setSupportZoom(true);
                settings.setBuiltInZoomControls(true);
            } else {
                settings.setSupportZoom(false);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(this.f29549d);
        settings.setDomStorageEnabled(this.f29550e);
        settings.setAllowFileAccess(this.f29551f);
        settings.setBlockNetworkImage(true ^ this.f29552g);
        settings.setDisplayZoomControls(false);
        if (Build.VERSION.SDK_INT < 28) {
            this.f29553h = false;
        }
        try {
            if (Build.VERSION.SDK_INT >= 11 && !this.f29553h) {
                webView.setLayerType(0, null);
            } else if (Build.VERSION.SDK_INT >= 16 && this.f29553h) {
                webView.setLayerType(2, null);
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a(WebSettings webSettings) {
        try {
            if (Build.VERSION.SDK_INT >= 17) {
                webSettings.setMediaPlaybackRequiresUserGesture(false);
            }
        } catch (Throwable th) {
            u.b(th.toString());
        }
    }

    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || "0".equals(str2) || !str.contains("{{ad_id}}")) {
            return null;
        }
        String replace = str.replace("{{ad_id}}", str2);
        return "javascript:(function () {    var JS_ACTLOG_URL = '" + replace + "';    var head = document.getElementsByTagName('head')[0];    var script = document.createElement('script');    script.type = 'text/javascript';    script.src = JS_ACTLOG_URL;    head.appendChild(script);})();";
    }
}
