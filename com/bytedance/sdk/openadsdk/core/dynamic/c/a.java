package com.bytedance.sdk.openadsdk.core.dynamic.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.d.c;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private static String e;

    /* renamed from: a  reason: collision with root package name */
    private Context f4417a;
    private SSWebView b;
    private String c;
    private c d;

    public a(@NonNull Context context) {
        this.f4417a = context;
        this.b = new SSWebView(this.f4417a);
        if (Build.VERSION.SDK_INT >= 19) {
            this.b.addJavascriptInterface(new C1019a(), "JS_DYNAMIC_LAYOUT_OBJ");
        }
        this.b.loadUrl("about:blank");
        a();
    }

    public static void a(String str) {
        e = str;
    }

    private void a() {
        String c = c();
        if (!TextUtils.isEmpty(c)) {
            t.a(this.b, c);
        }
    }

    public void a(c cVar) {
        this.d = cVar;
    }

    public void b(String str) {
        this.c = str;
        if (TextUtils.isEmpty(e) && this.d != null) {
            this.d.a(null);
            d();
        }
        b();
    }

    private void b() {
        t.a(this.b, "javascript:var res = getLayoutInfo(" + this.c + ");window.JS_DYNAMIC_LAYOUT_OBJ.calculateResult(JSON.stringify(res));");
    }

    private static String c() {
        if (TextUtils.isEmpty(e)) {
            return null;
        }
        return "javascript:" + ("var global = Function('return this')();global.jsCoreGlobal = {width:" + ak.b(p.a(), ak.c(p.a())) + ",height:" + ak.b(p.a(), ak.d(p.a())) + ",os:'Android'};global.systemFontSizeRatioNative = 1.2" + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR) + ("(function () {var JS_TTDYNAMIC_URL = '" + e + "';var xhrObj = new XMLHttpRequest();xhrObj.open('GET', JS_TTDYNAMIC_URL, false);xhrObj.send('');var se = document.createElement('script');se.type = 'text/javascript';se.text = xhrObj.responseText;document.getElementsByTagName('head')[0].appendChild(se);})();");
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.dynamic.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    private class C1019a {
        private C1019a() {
        }

        @JavascriptInterface
        public String jsCoreGlobal() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", ak.b(p.a(), ak.c(a.this.f4417a)));
                jSONObject.put("height", ak.b(p.a(), ak.d(a.this.f4417a)));
                jSONObject.put("os", "Android");
            } catch (Exception e) {
            }
            return jSONObject.toString();
        }

        @JavascriptInterface
        public double systemFontSizeRatioNative() {
            return 1.2d;
        }

        @JavascriptInterface
        public String getDomSizeFromNative(String str, String str2, String str3, boolean z, boolean z2, int i) {
            double d;
            double d2;
            JSONObject jSONObject = new JSONObject();
            u.f("DynamicBaseWidget", "getDomSizeFromNative String brickType==" + str2);
            u.f("DynamicBaseWidget", "getDomSizeFromNative String str==" + str);
            if (str.startsWith("<svg") || "dislike".equals(str2)) {
                jSONObject.put("width", 10.0d);
                jSONObject.put("height", 10.0d);
                return jSONObject.toString();
            } else if ("logo".equals(str2)) {
                jSONObject.put("width", "union".equals(str) ? 10.0d : 20.0d);
                jSONObject.put("height", 10.0d);
                return jSONObject.toString();
            } else {
                JSONObject jSONObject2 = new JSONObject(str3);
                int length = str.length();
                float optDouble = (float) jSONObject2.optDouble("fontSize");
                float optDouble2 = (float) jSONObject2.optDouble("letterSpacing");
                float optDouble3 = (float) jSONObject2.optDouble("lineHeight");
                float optDouble4 = (float) jSONObject2.optDouble("maxWidth");
                double d3 = (length * (optDouble + optDouble2)) - optDouble2;
                u.f("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + optDouble2 + ",lineHeight==" + optDouble3 + ",maxWidth ==" + optDouble4 + ",totalStrLength" + d3);
                if (z) {
                    d2 = optDouble4;
                    int i2 = ((int) (d3 / optDouble4)) + 1;
                    if (!z2 || i2 < i) {
                        i = i2;
                    }
                    d = optDouble3 * optDouble * i * 1.2d;
                } else {
                    d = optDouble3 * optDouble * 1.2d;
                    if (d3 > optDouble4) {
                        d3 = optDouble4;
                    }
                    d2 = d3;
                }
                jSONObject.put("width", d2);
                jSONObject.put("height", d);
                u.f("DynamicBaseWidget", "getDomSizeFromNative fontSize==" + optDouble + ",width==" + d2 + ",height ==" + d);
                return jSONObject.toString();
            }
        }

        @JavascriptInterface
        public void calculateResult(String str) {
            a.this.c(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        f fVar = new f();
        try {
            f.a(new JSONObject(str), fVar);
        } catch (Exception e2) {
            fVar = null;
        }
        if (this.d != null) {
            this.d.a(fVar);
        }
        d();
    }

    private void d() {
        aa.a(this.f4417a, this.b);
        aa.a(this.b);
        this.b = null;
    }
}
