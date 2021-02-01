package com.baidu.webkit.internal;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.baidu.webkit.sdk.Log;
import com.baidu.webkit.sdk.WebView;
import com.baidu.webkit.sdk.WebViewFactory;
import com.baidu.webkit.sdk.WebViewFactoryProvider;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONException;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    protected static final String f5671a = "BdboxApp:".toLowerCase();

    /* renamed from: b  reason: collision with root package name */
    public HashMap<String, Object> f5672b;
    public WebView c;
    public String d;
    private String g;
    @SuppressLint({"SdCardPath"})
    private String e = "/data/data/";
    private boolean f = true;
    private boolean h = true;
    private boolean i = true;

    public e(WebView webView) {
        this.c = webView;
        try {
            this.e += webView.getContext().getPackageName();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"NewApi"})
    private static void a(StringBuilder sb, Object obj, String str) throws JSONException {
        if (obj == null || TextUtils.isEmpty(str)) {
            return;
        }
        Class<?> cls = obj.getClass();
        sb.append("if(typeof(window." + str + ")=='undefined'){");
        sb.append("window.").append(str).append("={");
        Method[] methods = cls.getMethods();
        HashSet hashSet = new HashSet();
        for (Method method : methods) {
            if (((JavascriptInterface) method.getAnnotation(JavascriptInterface.class)) != null) {
                String name = method.getName();
                if (!hashSet.contains(name)) {
                    hashSet.add(name);
                    sb.append(name).append(":function(){");
                    if (method.getReturnType() != Void.TYPE) {
                        sb.append("return ");
                    }
                    sb.append("prompt('").append(f5671a).append("'+");
                    sb.append("JSON.stringify({");
                    sb.append("obj:'").append(str).append("',");
                    sb.append("func:'").append(name).append("',");
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

    private static boolean g() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public final void a(String str) {
        if (!this.i || str == null || str.startsWith("javascript")) {
            return;
        }
        this.g = str;
        if (this.c == null || this.c.getSettings() == null) {
            return;
        }
        if (!this.g.startsWith("file://")) {
            this.c.getSettings().setJavaScriptEnabled(true);
            return;
        }
        boolean z = false;
        try {
            z = WebViewFactory.hasProvider() ? ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA)).booleanValue() : false;
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        } catch (Throwable th) {
            Log.e("WebViewSecureProcessor", "getStaticWebSeting error:" + th);
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
        if (this.f5672b != null) {
            this.f5672b.clear();
        }
        this.d = null;
    }

    public final boolean a() {
        if (this.f) {
            if (!g()) {
                return true;
            }
        }
        return false;
    }

    public final void b(boolean z) {
        this.h = z;
    }

    public final boolean b() {
        return this.h;
    }

    public final void c() {
        if (this.h && a()) {
            if (this.d != null) {
                this.c.execJavaScript(this.d);
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("(function JsAddJavascriptInterface_(){");
            for (String str : d().keySet()) {
                try {
                    a(sb, d().get(str), str);
                } catch (JSONException e) {
                }
            }
            sb.append("}");
            sb.append(")()");
            this.d = sb.toString();
            this.c.execJavaScript(this.d);
        }
    }

    public final HashMap<String, Object> d() {
        if (this.f5672b == null) {
            this.f5672b = new HashMap<>();
        }
        return this.f5672b;
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
            new Thread(new f(this), "T7@removeSearchBoxImpl").start();
        }
    }
}
