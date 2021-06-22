package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j {

    /* renamed from: d  reason: collision with root package name */
    public String f27443d;

    /* renamed from: e  reason: collision with root package name */
    public String f27444e;

    /* renamed from: f  reason: collision with root package name */
    public final Context f27445f;

    /* renamed from: g  reason: collision with root package name */
    public final com.bytedance.sdk.openadsdk.core.d.l f27446g;
    public WebView p;
    public JSONObject v;
    public p w;

    /* renamed from: a  reason: collision with root package name */
    public int f27440a = 1;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27441b = false;

    /* renamed from: c  reason: collision with root package name */
    public int f27442c = -1;

    /* renamed from: h  reason: collision with root package name */
    public String f27447h = "landingpage";

    /* renamed from: i  reason: collision with root package name */
    public long f27448i = 0;
    public long j = 0;
    public long k = 0;
    public long l = 0;
    public long m = 0;
    public boolean n = false;
    public AtomicInteger o = new AtomicInteger(0);
    public boolean q = false;
    public AtomicInteger r = new AtomicInteger(0);
    public String u = "";
    public AtomicBoolean x = new AtomicBoolean(false);
    public List<com.bytedance.sdk.openadsdk.core.d.d> s = new ArrayList();
    public ConcurrentHashMap<String, com.bytedance.sdk.openadsdk.core.d.d> t = new ConcurrentHashMap<>();

    /* loaded from: classes6.dex */
    public class a {
        public a() {
        }

        @JavascriptInterface
        public String getUrl() {
            return j.this.u;
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
            com.bytedance.sdk.openadsdk.core.d.d dVar;
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return;
            }
            if (j.this.t == null) {
                j.this.t = new ConcurrentHashMap();
            }
            if (j.this.t.containsKey(str)) {
                dVar = (com.bytedance.sdk.openadsdk.core.d.d) j.this.t.get(str);
            } else {
                com.bytedance.sdk.openadsdk.core.d.d dVar2 = new com.bytedance.sdk.openadsdk.core.d.d();
                j.this.t.put(str, dVar2);
                dVar2.a(str);
                dVar = dVar2;
            }
            dVar.b(str2);
            if (j.this.s == null) {
                j.this.s = new ArrayList();
            }
            j.this.s.add(dVar);
        }

        @JavascriptInterface
        public void readPercent(String str) {
            StringBuilder sb = new StringBuilder();
            sb.append("measure height: ");
            int i2 = 0;
            sb.append(j.this.p == null ? 0 : j.this.p.getMeasuredHeight());
            u.b("LandingPageLog", sb.toString());
            u.b("LandingPageLog", "read percent: " + String.valueOf(str));
            try {
                int intValue = Float.valueOf(str).intValue();
                if (intValue > 100) {
                    i2 = 100;
                } else if (intValue >= 0) {
                    i2 = intValue;
                }
            } catch (Throwable unused) {
            }
            j.this.o.set(i2);
        }
    }

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, WebView webView) {
        this.f27445f = context;
        this.f27446g = lVar;
        this.p = webView;
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.addJavascriptInterface(new a(), "JS_LANDING_PAGE_LOG_OBJ");
        }
    }

    private void e() {
        List<com.bytedance.sdk.openadsdk.core.d.d> list = this.s;
        if (list == null || list.size() == 0) {
            return;
        }
        if (!com.bytedance.sdk.openadsdk.core.p.h().u() || x.c(com.bytedance.sdk.openadsdk.core.p.a()) == 4) {
            com.bytedance.sdk.openadsdk.h.a.a().a(this.s, this.f27446g, this.v);
        }
    }

    public void b() {
        u.b("LandingPageLog", MissionEvent.MESSAGE_RESUME);
        if (this.m == 0) {
            this.m = System.currentTimeMillis();
        }
        this.f27448i = System.currentTimeMillis();
    }

    public void c() {
        u.b("LandingPageLog", MissionEvent.MESSAGE_STOP);
        if (this.f27440a == 2) {
            long currentTimeMillis = System.currentTimeMillis();
            this.j = currentTimeMillis;
            long j = currentTimeMillis - this.f27448i;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("load_status", this.f27440a);
                jSONObject.put("max_scroll_percent", this.o.get());
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (JSONException unused) {
            }
            a("stay_page", jSONObject, j);
        }
    }

    public void d() {
        u.b("LandingPageLog", MissionEvent.MESSAGE_DESTROY);
        e();
        this.p = null;
        if (this.x.get()) {
            return;
        }
        d.b(this.f27445f, this.f27446g, this.f27447h, System.currentTimeMillis() - this.m);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f27447h = str;
    }

    private boolean b(String str) {
        com.bytedance.sdk.openadsdk.core.d.l lVar;
        com.bytedance.sdk.openadsdk.core.h.h h2;
        return (TextUtils.isEmpty(str) || (lVar = this.f27446g) == null || lVar.v() == 0 || com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str) != e.a.HTML || (h2 = com.bytedance.sdk.openadsdk.core.p.h()) == null || h2.l() <= this.r.get()) ? false : true;
    }

    public p a() {
        return this.w;
    }

    public void a(p pVar) {
        this.w = pVar;
    }

    public void a(JSONObject jSONObject) {
        this.v = jSONObject;
    }

    public j a(boolean z) {
        this.q = z;
        return this;
    }

    public void a(WebView webView, int i2) {
        u.b("LandingPageLog", "onWebProgress: " + i2);
        if (this.k == 0 && i2 > 0) {
            this.k = System.currentTimeMillis();
        } else if (this.l == 0 && i2 == 100) {
            this.l = System.currentTimeMillis();
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        u.b("LandingPageLog", "onWebStarted: " + String.valueOf(str));
        p pVar = this.w;
        if (pVar != null) {
            pVar.e();
        }
        if (this.f27441b) {
            return;
        }
        this.f27441b = true;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("render_type", "h5");
            jSONObject.putOpt("render_type_2", 0);
        } catch (Exception unused) {
        }
        a("load_start", jSONObject);
    }

    public void a(WebView webView, String str) {
        u.b("LandingPageLog", "onWebFinished: " + String.valueOf(str));
        p pVar = this.w;
        if (pVar != null) {
            pVar.f();
        }
        if (webView != null && !this.n && this.q) {
            this.n = true;
            t.a(webView, "javascript:\n    function sendScroll() {\n        try {\n            var totalH = document.body.scrollHeight || document.documentElement.scrollHeight;\n            var clientH = window.innerHeight || document.documentElement.clientHeight;\n            var scrollH = document.body.scrollTop || document.documentElement.scrollTop;\n            var validH = scrollH + clientH;\n            var result = (validH / totalH * 100).toFixed(2);\n            console.log('LandingPageLogscroll status: (' + scrollH + '+' + clientH + ')/' + totalH + '=' + result);\n            window.JS_LANDING_PAGE_LOG_OBJ.readPercent(result);\n        } catch (e) {\n            console.log('sendScroll error' + e)\n        }\n    }\nsendScroll();\nwindow.addEventListener('scroll', function (e) {\n    sendScroll();\n});");
            if (b(str)) {
                this.u = str;
                t.a(webView, "javascript:var url = window.JS_LANDING_PAGE_LOG_OBJ.getUrl();window.JS_LANDING_PAGE_LOG_OBJ.readHtml(url,document.documentElement.outerHTML);");
                this.r.incrementAndGet();
            }
        }
        if (this.x.get()) {
            return;
        }
        if (this.f27440a != 3) {
            this.f27440a = 2;
        }
        this.x.set(true);
        this.f27448i = System.currentTimeMillis();
        if (this.f27440a == 2) {
            long j = this.l - this.k;
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("error_code", this.f27442c);
                jSONObject.put("error_msg", this.f27443d);
                jSONObject.put("error_url", this.f27444e);
                jSONObject.putOpt("render_type", "h5");
                jSONObject.putOpt("render_type_2", 0);
            } catch (Exception unused) {
            }
            a("load_finish", jSONObject, j);
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("error_code", this.f27442c);
            jSONObject2.put("error_msg", this.f27443d);
            jSONObject2.put("error_url", this.f27444e);
            jSONObject2.putOpt("render_type", "h5");
            jSONObject2.putOpt("render_type_2", 0);
        } catch (Exception unused2) {
        }
        a("load_fail", jSONObject2);
    }

    public void a(int i2, String str, String str2, String str3) {
        u.b("LandingPageLog", "onWebError: " + i2 + StringUtil.ARRAY_ELEMENT_SEPARATOR + str + StringUtil.ARRAY_ELEMENT_SEPARATOR + str2 + "，" + str3);
        p pVar = this.w;
        if (pVar != null) {
            pVar.g();
        }
        if (!(str3 != null && str3.startsWith("image"))) {
            this.f27440a = 3;
        }
        this.f27442c = i2;
        this.f27443d = str;
        this.f27444e = str2;
    }

    @RequiresApi(api = 21)
    public void a(WebView webView, WebResourceRequest webResourceRequest) {
        com.bytedance.sdk.openadsdk.core.d.d dVar;
        if (webResourceRequest == null || TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
            return;
        }
        String uri = webResourceRequest.getUrl().toString();
        if (b(uri)) {
            if (this.t == null) {
                this.t = new ConcurrentHashMap<>();
            }
            if (this.t.containsKey(uri)) {
                dVar = this.t.get(uri);
            } else {
                com.bytedance.sdk.openadsdk.core.d.d dVar2 = new com.bytedance.sdk.openadsdk.core.d.d();
                this.t.put(uri, dVar2);
                dVar2.a(uri);
                dVar = dVar2;
            }
            dVar.a(webResourceRequest.getRequestHeaders());
        }
    }

    private void a(String str, JSONObject jSONObject) {
        a(str, jSONObject, -1L);
    }

    private void a(String str, JSONObject jSONObject, long j) {
        if (!this.q || this.f27446g == null || TextUtils.isEmpty(str)) {
            return;
        }
        JSONObject jSONObject2 = null;
        if (jSONObject != null) {
            try {
                int i2 = 1;
                jSONObject.put("is_playable", this.f27446g.C() ? 1 : 0);
                if (!com.bytedance.sdk.openadsdk.core.g.a.a().a(this.f27446g)) {
                    i2 = 0;
                }
                jSONObject.put("usecache", i2);
            } catch (JSONException unused) {
            }
            try {
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("ad_extra_data", jSONObject.toString());
                    if (j > 0) {
                        jSONObject3.put("duration", j);
                    }
                } catch (JSONException unused2) {
                }
                jSONObject2 = jSONObject3;
            } catch (JSONException unused3) {
            }
        }
        u.b("LandingPageLog", "sendEvent: " + String.valueOf(this.f27447h) + StringUtil.ARRAY_ELEMENT_SEPARATOR + String.valueOf(str) + ", ext=" + String.valueOf(jSONObject2));
        d.c(this.f27445f, this.f27446g, this.f27447h, str, jSONObject2);
    }
}
