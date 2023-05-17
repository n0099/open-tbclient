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
/* loaded from: classes8.dex */
public final class a {
    public static final String a = WebChromeClient.MSG_PROMPT_HEADER.toLowerCase();
    public HashMap<String, Object> b;
    public WebView c;
    public String d;
    public String g;
    @SuppressLint({"SdCardPath"})
    public String e = "/data/data/";
    public boolean f = true;
    public boolean h = true;
    public boolean i = true;

    public a(WebView webView) {
        this.c = webView;
        try {
            this.e += webView.getContext().getPackageName();
        } catch (Exception e) {
            e.printStackTrace();
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
                    sb.append(a);
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
        if (!this.i || str == null || str.startsWith("javascript")) {
            return;
        }
        this.g = str;
        WebView webView = this.c;
        if (webView == null || webView.getSettings() == null) {
            return;
        }
        if (!this.g.startsWith("file://")) {
            this.c.getSettings().setJavaScriptEnabled(true);
            return;
        }
        boolean z = false;
        try {
            if (WebViewFactory.hasProvider()) {
                z = ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA)).booleanValue();
            }
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e("WebViewSecureProcessor", "getStaticWebSeting error:".concat(String.valueOf(th)));
        }
        this.c.getSettings().setJavaScriptEnabled(z);
    }

    public final void a(boolean z) {
        if (z == this.f) {
            return;
        }
        if (z) {
            throw new RuntimeException("can not reverse!!");
        }
        this.f = z;
        for (String str : d().keySet()) {
            this.c.addJavascriptInterface(d().get(str), str, false);
        }
        HashMap<String, Object> hashMap = this.b;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.d = null;
    }

    public final boolean a() {
        return this.f && (g() ^ true);
    }

    public final void b(boolean z) {
        this.h = z;
    }

    public final boolean b() {
        return this.h;
    }

    public final void c() {
        if (this.h && a()) {
            String str = this.d;
            if (str != null) {
                this.c.execJavaScript(str);
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
            this.d = sb2;
            this.c.execJavaScript(sb2);
        }
    }

    public final HashMap<String, Object> d() {
        if (this.b == null) {
            this.b = new HashMap<>();
        }
        return this.b;
    }

    public final boolean e() {
        if (g()) {
            return false;
        }
        this.c.removeJavascriptInterface("searchBoxJavaBridge_");
        return true;
    }

    public final void f() {
        if (e()) {
            new Thread(new Runnable() { // from class: com.baidu.webkit.internal.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    for (int i = 0; i < 100; i++) {
                        try {
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (a.this.c != null && !a.this.c.isDestroyed()) {
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
