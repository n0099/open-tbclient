package com.bytedance.sdk.openadsdk.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import androidx.annotation.RequiresApi;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.bytedance.sdk.openadsdk.core.widget.webview.a.e;
import com.bytedance.sdk.openadsdk.utils.t;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class j {
    private String f;
    private final Context g;
    private final com.bytedance.sdk.openadsdk.core.d.l h;
    private WebView p;
    private JSONObject v;
    private p w;

    /* renamed from: a  reason: collision with root package name */
    private int f4203a = 1;
    private boolean b = false;
    private boolean c = false;
    private boolean d = false;
    private int e = -1;
    private String i = "landingpage";
    private long j = 0;
    private long k = 0;
    private long l = 0;
    private long m = 0;
    private boolean n = false;
    private AtomicInteger o = new AtomicInteger(0);
    private boolean q = false;
    private AtomicInteger r = new AtomicInteger(0);
    private String u = "";
    private List<com.bytedance.sdk.openadsdk.core.d.d> s = new ArrayList();
    private ConcurrentHashMap<String, com.bytedance.sdk.openadsdk.core.d.d> t = new ConcurrentHashMap<>();

    public j(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, WebView webView) {
        this.g = context;
        this.h = lVar;
        this.p = webView;
        if (Build.VERSION.SDK_INT >= 19) {
            this.p.addJavascriptInterface(new a(), "JS_LANDING_PAGE_LOG_OBJ");
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.i = str;
        }
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

    public void a(WebView webView, int i) {
        u.b("LandingPageLog", "onWebProgress: " + i);
        if (this.l == 0 && i > 0) {
            this.l = System.currentTimeMillis();
        } else if (this.m == 0 && i == 100) {
            this.m = System.currentTimeMillis();
        }
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        u.b("LandingPageLog", "onWebStarted: " + String.valueOf(str));
        if (this.w != null) {
            this.w.e();
        }
        if (!this.b) {
            this.b = true;
            a("load_start", new JSONObject());
        }
    }

    public void a(WebView webView, String str) {
        u.b("LandingPageLog", "onWebFinished: " + String.valueOf(str));
        if (this.w != null) {
            this.w.f();
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
        if (this.f4203a != 3) {
            this.f4203a = 2;
        }
        if (this.f4203a == 2) {
            long j = this.m - this.l;
            if (!this.c) {
                this.c = true;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("load_duration", j);
                } catch (Exception e) {
                }
                a("load_finish", jSONObject);
            }
        } else if (!this.d) {
            this.d = true;
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("error_code", this.e);
                jSONObject2.put("error_msg", this.f);
            } catch (Exception e2) {
            }
            a("load_fail", jSONObject2);
        }
    }

    public void a(WebView webView, int i, String str, String str2) {
        u.b("LandingPageLog", "onWebError: " + i + ", " + String.valueOf(str) + ", " + String.valueOf(str2));
        if (this.w != null) {
            this.w.g();
        }
        this.f4203a = 3;
        this.e = i;
        this.f = str;
    }

    public void b() {
        u.b("LandingPageLog", MissionEvent.MESSAGE_RESUME);
        this.j = System.currentTimeMillis();
    }

    public void c() {
        u.b("LandingPageLog", MissionEvent.MESSAGE_STOP);
        boolean z = this.f4203a == 2;
        this.k = System.currentTimeMillis();
        long j = this.k - this.j;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("load_status", this.f4203a);
            jSONObject.put("stay_page_duration", j);
            jSONObject.put("max_scroll_percent", z ? this.o.get() : 0);
        } catch (JSONException e) {
        }
        a("landing_close", jSONObject);
    }

    public void d() {
        u.b("LandingPageLog", MissionEvent.MESSAGE_DESTROY);
        e();
        this.p = null;
    }

    @RequiresApi(api = 21)
    public void a(WebView webView, WebResourceRequest webResourceRequest) {
        com.bytedance.sdk.openadsdk.core.d.d dVar;
        if (webResourceRequest != null && !TextUtils.isEmpty(webResourceRequest.getUrl().toString())) {
            String uri = webResourceRequest.getUrl().toString();
            if (b(uri)) {
                if (this.t == null) {
                    this.t = new ConcurrentHashMap<>();
                }
                if (this.t.containsKey(uri)) {
                    dVar = this.t.get(uri);
                } else {
                    dVar = new com.bytedance.sdk.openadsdk.core.d.d();
                    this.t.put(uri, dVar);
                    dVar.a(uri);
                }
                dVar.a(webResourceRequest.getRequestHeaders());
            }
        }
    }

    private void a(String str, JSONObject jSONObject) {
        JSONObject jSONObject2;
        if (this.q && this.h != null && !TextUtils.isEmpty(str)) {
            if (jSONObject == null) {
                jSONObject2 = null;
            } else {
                try {
                    jSONObject.put("is_playable", this.h.C() ? 1 : 0);
                    jSONObject.put("usecache", com.bytedance.sdk.openadsdk.core.g.a.a().a(this.h) ? 1 : 0);
                } catch (JSONException e) {
                }
                try {
                    jSONObject2 = new JSONObject();
                    try {
                        jSONObject2.put("ad_extra_data", jSONObject.toString());
                    } catch (JSONException e2) {
                    }
                } catch (JSONException e3) {
                    jSONObject2 = null;
                }
            }
            u.b("LandingPageLog", "sendEvent: " + String.valueOf(this.i) + ", " + String.valueOf(str) + ", ext=" + String.valueOf(jSONObject2));
            d.c(this.g, this.h, this.i, str, jSONObject2);
        }
    }

    private boolean b(String str) {
        com.bytedance.sdk.openadsdk.core.h.h h;
        return (TextUtils.isEmpty(str) || this.h == null || this.h.v() == 0 || com.bytedance.sdk.openadsdk.core.widget.webview.a.e.a(str) != e.a.HTML || (h = com.bytedance.sdk.openadsdk.core.p.h()) == null || h.m() <= this.r.get()) ? false : true;
    }

    private void e() {
        if (this.s != null && this.s.size() != 0) {
            if (!com.bytedance.sdk.openadsdk.core.p.h().v() || x.c(com.bytedance.sdk.openadsdk.core.p.a()) == 4) {
                com.bytedance.sdk.openadsdk.g.a.a().a(this.s, this.h, this.v);
            }
        }
    }

    /* loaded from: classes6.dex */
    private class a {
        private a() {
        }

        @JavascriptInterface
        public void readPercent(String str) {
            int i = 0;
            u.b("LandingPageLog", "measure height: " + (j.this.p == null ? 0 : j.this.p.getMeasuredHeight()));
            u.b("LandingPageLog", "read percent: " + String.valueOf(str));
            try {
                int intValue = Float.valueOf(str).intValue();
                if (intValue > 100) {
                    i = 100;
                } else if (intValue >= 0) {
                    i = intValue;
                }
            } catch (Throwable th) {
            }
            j.this.o.set(i);
        }

        @JavascriptInterface
        public String getUrl() {
            return j.this.u;
        }

        @JavascriptInterface
        public void readHtml(String str, String str2) {
            com.bytedance.sdk.openadsdk.core.d.d dVar;
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (j.this.t == null) {
                    j.this.t = new ConcurrentHashMap();
                }
                if (j.this.t.containsKey(str)) {
                    dVar = (com.bytedance.sdk.openadsdk.core.d.d) j.this.t.get(str);
                } else {
                    dVar = new com.bytedance.sdk.openadsdk.core.d.d();
                    j.this.t.put(str, dVar);
                    dVar.a(str);
                }
                dVar.b(str2);
                if (j.this.s == null) {
                    j.this.s = new ArrayList();
                }
                j.this.s.add(dVar);
            }
        }
    }
}
