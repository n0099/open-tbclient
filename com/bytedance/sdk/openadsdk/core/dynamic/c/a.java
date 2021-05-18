package com.bytedance.sdk.openadsdk.core.dynamic.c;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.bytedance.sdk.openadsdk.core.aa;
import com.bytedance.sdk.openadsdk.core.dynamic.b.f;
import com.bytedance.sdk.openadsdk.core.dynamic.d.c;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.widget.webview.SSWebView;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static String f28084e;

    /* renamed from: a  reason: collision with root package name */
    public Context f28085a;

    /* renamed from: b  reason: collision with root package name */
    public SSWebView f28086b;

    /* renamed from: c  reason: collision with root package name */
    public String f28087c;

    /* renamed from: d  reason: collision with root package name */
    public c f28088d;

    /* renamed from: com.bytedance.sdk.openadsdk.core.dynamic.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0291a {
        public C0291a() {
        }

        @JavascriptInterface
        public void calculateResult(String str) {
            a.this.c(str);
        }

        @JavascriptInterface
        public String getDomSizeFromNative(String str, String str2, String str3, boolean z, boolean z2, int i2) {
            double d2;
            double d3;
            int i3;
            JSONObject jSONObject = new JSONObject();
            u.f("DynamicBaseWidget", "getDomSizeFromNative String brickType==" + str2);
            u.f("DynamicBaseWidget", "getDomSizeFromNative String str==" + str);
            if (!str.startsWith("<svg") && !"dislike".equals(str2)) {
                if ("logo".equals(str2)) {
                    jSONObject.put("width", "union".equals(str) ? 10.0d : 20.0d);
                    jSONObject.put("height", 10.0d);
                    return jSONObject.toString();
                }
                JSONObject jSONObject2 = new JSONObject(str3);
                int length = str.length();
                float optDouble = (float) jSONObject2.optDouble("fontSize");
                float optDouble2 = (float) jSONObject2.optDouble("letterSpacing");
                float optDouble3 = (float) jSONObject2.optDouble("lineHeight");
                float optDouble4 = (float) jSONObject2.optDouble("maxWidth");
                double d4 = (length * (optDouble + optDouble2)) - optDouble2;
                u.f("DynamicBaseWidget", "getDomSizeFromNative letterSpacing==" + optDouble2 + ",lineHeight==" + optDouble3 + ",maxWidth ==" + optDouble4 + ",totalStrLength" + d4);
                if (z) {
                    d3 = optDouble4;
                    int i4 = ((int) (d4 / d3)) + 1;
                    if (!z2 || i4 < (i3 = i2)) {
                        i3 = i4;
                    }
                    d2 = optDouble3 * optDouble * i3 * 1.2d;
                } else {
                    d2 = optDouble3 * optDouble * 1.2d;
                    double d5 = optDouble4;
                    if (d4 > d5) {
                        d4 = d5;
                    }
                    d3 = d4;
                }
                jSONObject.put("width", d3);
                jSONObject.put("height", d2);
                u.f("DynamicBaseWidget", "getDomSizeFromNative fontSize==" + optDouble + ",width==" + d3 + ",height ==" + d2);
                return jSONObject.toString();
            }
            jSONObject.put("width", 10.0d);
            jSONObject.put("height", 10.0d);
            return jSONObject.toString();
        }

        @JavascriptInterface
        public String jsCoreGlobal() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("width", al.b(p.a(), al.c(a.this.f28085a)));
                jSONObject.put("height", al.b(p.a(), al.d(a.this.f28085a)));
                jSONObject.put(IAdRequestParam.OS, "Android");
            } catch (Exception unused) {
            }
            return jSONObject.toString();
        }

        @JavascriptInterface
        public double systemFontSizeRatioNative() {
            return 1.2d;
        }
    }

    public a(@NonNull Context context) {
        this.f28085a = context;
        SSWebView sSWebView = new SSWebView(this.f28085a);
        this.f28086b = sSWebView;
        if (Build.VERSION.SDK_INT >= 19) {
            sSWebView.addJavascriptInterface(new C0291a(), "JS_DYNAMIC_LAYOUT_OBJ");
        }
        this.f28086b.loadUrl("about:blank");
        a();
    }

    public static String c() {
        if (TextUtils.isEmpty(f28084e)) {
            return null;
        }
        return "javascript:" + ("var global = Function('return this')();global.jsCoreGlobal = {width:" + al.b(p.a(), al.c(p.a())) + ",height:" + al.b(p.a(), al.d(p.a())) + ",os:'Android'};global.systemFontSizeRatioNative = 1.2;") + ("(function () {var JS_TTDYNAMIC_URL = '" + f28084e + "';var xhrObj = new XMLHttpRequest();xhrObj.open('GET', JS_TTDYNAMIC_URL, false);xhrObj.send('');var se = document.createElement('script');se.type = 'text/javascript';se.text = xhrObj.responseText;document.getElementsByTagName('head')[0].appendChild(se);})();");
    }

    private void d() {
        aa.a(this.f28085a, this.f28086b);
        aa.a(this.f28086b);
        this.f28086b = null;
    }

    public void b(String str) {
        c cVar;
        this.f28087c = str;
        if (TextUtils.isEmpty(f28084e) && (cVar = this.f28088d) != null) {
            cVar.a(null);
            d();
        }
        b();
    }

    public static void a(String str) {
        f28084e = str;
    }

    private void a() {
        String c2 = c();
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        t.a(this.f28086b, c2);
    }

    private void b() {
        t.a(this.f28086b, "javascript:var res = getLayoutInfo(" + this.f28087c + ");window.JS_DYNAMIC_LAYOUT_OBJ.calculateResult(JSON.stringify(res));");
    }

    public void a(c cVar) {
        this.f28088d = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        f fVar = new f();
        try {
            f.a(new JSONObject(str), fVar);
        } catch (Exception unused) {
            fVar = null;
        }
        c cVar = this.f28088d;
        if (cVar != null) {
            cVar.a(fVar);
        }
        d();
    }
}
