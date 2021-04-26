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
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final String f27420a = WebChromeClient.MSG_PROMPT_HEADER.toLowerCase();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Object> f27421b;

    /* renamed from: c  reason: collision with root package name */
    public WebView f27422c;

    /* renamed from: d  reason: collision with root package name */
    public String f27423d;

    /* renamed from: g  reason: collision with root package name */
    public String f27426g;
    @SuppressLint({"SdCardPath"})

    /* renamed from: e  reason: collision with root package name */
    public String f27424e = "/data/data/";

    /* renamed from: f  reason: collision with root package name */
    public boolean f27425f = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f27427h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27428i = true;

    public e(WebView webView) {
        this.f27422c = webView;
        try {
            this.f27424e += webView.getContext().getPackageName();
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
                    sb.append(f27420a);
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
        if (!this.f27428i || str == null || str.startsWith("javascript")) {
            return;
        }
        this.f27426g = str;
        WebView webView = this.f27422c;
        if (webView == null || webView.getSettings() == null) {
            return;
        }
        if (!this.f27426g.startsWith("file://")) {
            this.f27422c.getSettings().setJavaScriptEnabled(true);
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
            Log.e("WebViewSecureProcessor", "getStaticWebSeting error:" + th);
        }
        this.f27422c.getSettings().setJavaScriptEnabled(z);
    }

    public final void a(boolean z) {
        if (z == this.f27425f) {
            return;
        }
        if (z) {
            throw new RuntimeException("can not reverse!!");
        }
        this.f27425f = z;
        for (String str : d().keySet()) {
            this.f27422c.addJavascriptInterface(d().get(str), str, false);
        }
        HashMap<String, Object> hashMap = this.f27421b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.f27423d = null;
    }

    public final boolean a() {
        return this.f27425f && (g() ^ true);
    }

    public final void b(boolean z) {
        this.f27427h = z;
    }

    public final boolean b() {
        return this.f27427h;
    }

    public final void c() {
        if (this.f27427h && a()) {
            String str = this.f27423d;
            if (str != null) {
                this.f27422c.execJavaScript(str);
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
            this.f27423d = sb2;
            this.f27422c.execJavaScript(sb2);
        }
    }

    public final HashMap<String, Object> d() {
        if (this.f27421b == null) {
            this.f27421b = new HashMap<>();
        }
        return this.f27421b;
    }

    public final boolean e() {
        if (g()) {
            return false;
        }
        this.f27422c.removeJavascriptInterface("searchBoxJavaBridge_");
        return true;
    }

    public final void f() {
        if (e()) {
            new Thread(new f(this), "T7@removeSearchBoxImpl").start();
        }
    }
}
