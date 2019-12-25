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
/* loaded from: classes9.dex */
public final class f {
    protected static final String a = "BdboxApp:".toLowerCase();
    public WebView d;
    public String e;
    private String h = "/data/data/";
    public HashMap<String, Object> b = null;
    public boolean c = true;
    private String i = null;
    public boolean f = true;
    public boolean g = false;
    private boolean j = false;
    private boolean k = true;

    public f(WebView webView) {
        this.d = webView;
        try {
            this.h += webView.getContext().getPackageName();
        } catch (Exception e) {
            com.a.a.a.a.a.a.a.a(e);
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
                    sb.append("prompt('").append(a).append("'+");
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

    private static boolean e() {
        return Build.VERSION.SDK_INT >= 17;
    }

    public final void a(String str) {
        if (!this.k || str == null || str.startsWith("javascript")) {
            return;
        }
        this.i = str;
        if (this.d == null || this.d.getSettings() == null) {
            return;
        }
        if (!this.i.startsWith("file://")) {
            this.d.getSettings().setJavaScriptEnabled(true);
            return;
        }
        boolean z = false;
        try {
            z = WebViewFactory.hasProvider() ? ((Boolean) WebViewFactory.getProvider().getStaticWebSeting(WebViewFactoryProvider.SETTING_JS_ENABLE_ON_FILE_SCHEMA)).booleanValue() : false;
        } catch (UnsatisfiedLinkError e) {
            com.a.a.a.a.a.a.a.a(e);
        } catch (Throwable th) {
            Log.e("WebViewSecureProcessor", "getStaticWebSeting error:" + th);
        }
        this.d.getSettings().setJavaScriptEnabled(z);
    }

    public final boolean a() {
        if (this.c) {
            if (!e()) {
                return true;
            }
        }
        return false;
    }

    public final void b() {
        if (!this.f || !a()) {
            if (this.g) {
                this.d.execJavaScript("var event = document.createEvent('Events');event.initEvent('runtimeready', false, false);document.dispatchEvent(event);");
            }
        } else if (this.e != null) {
            this.d.execJavaScript(this.e);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("(function JsAddJavascriptInterface_(){");
            for (String str : c().keySet()) {
                try {
                    a(sb, c().get(str), str);
                } catch (JSONException e) {
                }
            }
            if (this.g) {
                sb.append("var event = document.createEvent('Events');event.initEvent('runtimeready', false, false);document.dispatchEvent(event);");
            }
            sb.append("}");
            sb.append(")()");
            this.e = sb.toString();
            this.d.execJavaScript(this.e);
        }
    }

    public final HashMap<String, Object> c() {
        if (this.b == null) {
            this.b = new HashMap<>();
        }
        return this.b;
    }

    public final boolean d() {
        if (e()) {
            return false;
        }
        this.d.removeJavascriptInterface("searchBoxJavaBridge_");
        return true;
    }
}
