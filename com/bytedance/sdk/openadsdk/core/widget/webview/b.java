package com.bytedance.sdk.openadsdk.core.widget.webview;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.c.j;
import com.bytedance.sdk.openadsdk.core.x;
import com.bytedance.sdk.openadsdk.utils.r;
/* loaded from: classes5.dex */
public class b extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28692a = WebChromeClient.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public final x f28693b;

    /* renamed from: c  reason: collision with root package name */
    public j f28694c;

    public b(x xVar, j jVar) {
        this.f28693b = xVar;
        this.f28694c = jVar;
    }

    private boolean a(@NonNull String str) {
        try {
            String str2 = f28692a;
            Log.w(str2, "message:" + str);
            Uri parse = Uri.parse(str);
            if ("bytedance".equals(parse.getScheme().toLowerCase())) {
                r.a(parse, this.f28693b);
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onConsoleMessage(String str, int i, String str2) {
        if (!TextUtils.isEmpty(str)) {
            a(str);
        }
        super.onConsoleMessage(str, i, str2);
    }

    @Override // android.webkit.WebChromeClient
    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        j jVar = this.f28694c;
        if (jVar != null) {
            jVar.a(webView, i);
        }
    }

    @Override // android.webkit.WebChromeClient
    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        super.onShowCustomView(view, customViewCallback);
    }

    @Override // android.webkit.WebChromeClient
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage == null || TextUtils.isEmpty(consoleMessage.message()) || !a(consoleMessage.message())) {
            return super.onConsoleMessage(consoleMessage);
        }
        return true;
    }
}
