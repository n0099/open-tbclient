package com.baidu.webkit.internal;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebChromeClient;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONException;
/* loaded from: classes5.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final String f26618a = WebChromeClient.MSG_PROMPT_HEADER.toLowerCase();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Object> f26619b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f26620c;

    /* renamed from: d  reason: collision with root package name */
    public String f26621d;

    /* renamed from: g  reason: collision with root package name */
    public String f26624g;
    @SuppressLint({"SdCardPath"})

    /* renamed from: e  reason: collision with root package name */
    public String f26622e = "/data/data/";

    /* renamed from: f  reason: collision with root package name */
    public boolean f26623f = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f26625h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f26626i = true;

    public a(WebView webView) {
        this.f26620c = webView;
        try {
            this.f26622e += webView.getContext().getPackageName();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(StringBuilder sb, Object obj, String str) throws JSONException {
        if (obj == null || TextUtils.isEmpty(str)) {
            return;
        }
        Class<?> cls = obj.getClass();
        sb.append("if(typeof(window." + str + ")=='undefined'){");
        sb.append("window.");
        sb.append(str);
        sb.append("={");
        Method[] methods = cls.getMethods();
        HashSet hashSet = new HashSet();
        for (Method method : methods) {
            if (((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) != null) {
                String name = method.getName();
                if (!hashSet.contains(name)) {
                    hashSet.add(name);
                    sb.append(name);
                    sb.append(":function(){");
                    if (method.getReturnType() != Void.TYPE) {
                        sb.append("return ");
                    }
                    sb.append("prompt('");
                    sb.append(f26618a);
                    sb.append("'+");
                    sb.append("JSON.stringify({");
                    sb.append("obj:'");
                    sb.append(str);
                    sb.append("',");
                    sb.append("func:'");
                    sb.append(name);
                    sb.append("',");
                    sb.append("args:Array.prototype.slice.call(arguments)");
                    sb.append("})");
                    sb.append(");");
                    sb.append("},");
                }
            }
        }
        int length = sb.length() - 1;
        if (sb.charAt(length) == ',') {
            sb.deleteCharAt(length);
        }
        sb.append("};");
        sb.append("}");
    }

    public static boolean g() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public final void a(String str) {
        if (!this.f26626i || str == null || str.startsWith("javascript")) {
            return;
        }
        this.f26624g = str;
        WebView webView = this.f26620c;
        if (webView == null || webView.getSettings() == null) {
            return;
        }
        if (!this.f26624g.startsWith("file://")) {
            this.f26620c.getSettings().setJavaScriptEnabled(true);
            return;
        }
        boolean z = false;
        try {
            if (WebViewFactory.hasProvider()) {
                z = ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA)).booleanValue();
            }
        } catch (UnsatisfiedLinkError e2) {
            e2.printStackTrace();
        } catch (Throwable th) {
            Log.e("WebViewSecureProcessor", "getStaticWebSeting error:".concat(String.valueOf(th)));
        }
        this.f26620c.getSettings().setJavaScriptEnabled(z);
    }

    public final void a(boolean z) {
        if (z == this.f26623f) {
            return;
        }
        if (z) {
            throw new RuntimeException("can not reverse!!");
        }
        this.f26623f = z;
        for (String str : d().keySet()) {
            this.f26620c.addJavascriptInterface(d().get(str), str, false);
        }
        HashMap<String, Object> hashMap = this.f26619b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f26621d = null;
    }

    public final boolean a() {
        return this.f26623f && (g() ^ true);
    }

    public final void b(boolean z) {
        this.f26625h = z;
    }

    public final boolean b() {
        return this.f26625h;
    }

    public final void c() {
        if (this.f26625h && a()) {
            String str = this.f26621d;
            if (str != null) {
                this.f26620c.execJavaScript(str);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(function JsAddJavascriptInterface_(){");
            for (String str2 : d().keySet()) {
                try {
                    a(sb, d().get(str2), str2);
                } catch (JSONException unused) {
                }
            }
            sb.append("}");
            sb.append(")()");
            String sb2 = sb.toString();
            this.f26621d = sb2;
            this.f26620c.execJavaScript(sb2);
        }
    }

    public final HashMap<String, Object> d() {
        if (this.f26619b == null) {
            this.f26619b = new HashMap<>();
        }
        return this.f26619b;
    }

    public final boolean e() {
        if (g()) {
            return false;
        }
        this.f26620c.removeJavascriptInterface("searchBoxJavaBridge_");
        return true;
    }

    public final void f() {
        if (e()) {
            new Thread(new Runnable() { // from class: com.baidu.webkit.internal.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (int i2 = 0; i2 < 100; i2++) {
                        try {
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        if (a.this.f26620c != null && !a.this.f26620c.isDestroyed()) {
                            a.this.e();
                            Thread.sleep(20L);
                        }
                        return;
                    }
                }
            }, "T7@removeSearchBoxImpl").start();
        }
    }
}
