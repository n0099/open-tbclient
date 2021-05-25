package com.bytedance.sdk.openadsdk.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public String f27285a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f27286b;

    /* renamed from: c  reason: collision with root package name */
    public Boolean f27287c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f27288d;

    /* renamed from: e  reason: collision with root package name */
    public Boolean f27289e;

    /* renamed from: f  reason: collision with root package name */
    public JSONObject f27290f;

    /* renamed from: g  reason: collision with root package name */
    public JSONArray f27291g;

    /* renamed from: h  reason: collision with root package name */
    public JSONArray f27292h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f27293i;
    public final Object j;

    public p(int i2, String str, com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f27285a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.f27287c = bool;
        this.f27288d = bool;
        this.f27289e = bool;
        this.f27293i = false;
        this.j = new Object();
        this.f27285a = str;
        this.f27286b = lVar;
        this.f27290f = new JSONObject();
        this.f27291g = new JSONArray();
        this.f27292h = new JSONArray();
        a(this.f27290f, "webview_source", Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        return this.f27289e.booleanValue() || (this.f27288d.booleanValue() && this.f27287c.booleanValue());
    }

    public void i() {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onNativeEndCardClose") { // from class: com.bytedance.sdk.openadsdk.c.p.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f27290f, "native_endcard_close", jSONObject);
                }
            }
        });
    }

    public void j() {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onNativeEnterBackground") { // from class: com.bytedance.sdk.openadsdk.c.p.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(jSONObject, "type", "native_enterBackground");
                    p.this.a(p.this.f27291g, jSONObject);
                }
            }
        });
    }

    public void k() {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onNativeEnterForeground") { // from class: com.bytedance.sdk.openadsdk.c.p.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(jSONObject, "type", "native_enterForeground");
                    p.this.a(p.this.f27291g, jSONObject);
                }
            }
        });
    }

    public void l() {
        this.f27287c = Boolean.TRUE;
    }

    public void m() {
        com.bytedance.sdk.openadsdk.l.e.a(new com.bytedance.sdk.openadsdk.l.g("trySendTrackInfo") { // from class: com.bytedance.sdk.openadsdk.c.p.13
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (p.this.n()) {
                        if (p.this.f27293i) {
                            return;
                        }
                        if (p.this.f27291g != null && p.this.f27291g.length() != 0) {
                            try {
                                p.this.f27290f.put("native_switchBackgroundAndForeground", p.this.f27291g);
                            } catch (Exception unused) {
                            }
                        }
                        if (p.this.f27292h != null && p.this.f27292h.length() != 0) {
                            try {
                                p.this.f27290f.put("intercept_source", p.this.f27292h);
                            } catch (Exception unused2) {
                            }
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("webview_time_track", p.this.f27290f);
                        if (com.bytedance.sdk.openadsdk.core.i.d().w() && p.this.f27290f != null) {
                            u.b("WebviewTimeTrack", p.this.f27290f.toString());
                        }
                        d.h(com.bytedance.sdk.openadsdk.core.p.a(), p.this.f27286b, p.this.f27285a, "webview_time_track", hashMap);
                        p.this.f27293i = true;
                    }
                }
            }
        });
    }

    public void b() {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onRenderSuc") { // from class: com.bytedance.sdk.openadsdk.c.p.12
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f27290f, "render_success", jSONObject);
                }
            }
        });
    }

    public void c() {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onNativeRenderStart") { // from class: com.bytedance.sdk.openadsdk.c.p.16
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f27290f, "native_render_start", jSONObject);
                }
            }
        });
    }

    public void d() {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onNativeRenderEnd") { // from class: com.bytedance.sdk.openadsdk.c.p.17
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f27290f, "native_render_end", jSONObject);
                }
            }
        });
    }

    public void e() {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onWebviewLoadStart") { // from class: com.bytedance.sdk.openadsdk.c.p.18
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f27290f, "webview_load_start", (Object) jSONObject, false);
                }
            }
        });
    }

    public void f() {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onWebviewLoadSuc") { // from class: com.bytedance.sdk.openadsdk.c.p.19
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f27290f, "webview_load_success", jSONObject);
                }
            }
        });
    }

    public void g() {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onWebviewLoadError") { // from class: com.bytedance.sdk.openadsdk.c.p.20
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    p.this.a((JSONObject) null);
                }
            }
        });
    }

    public void h() {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onNativeEndCardShow") { // from class: com.bytedance.sdk.openadsdk.c.p.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f27290f, "native_endcard_show", jSONObject);
                }
            }
        });
    }

    public void b(final String str, final long j, final long j2, final int i2) {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onInterceptJs") { // from class: com.bytedance.sdk.openadsdk.c.p.8
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (!TextUtils.isEmpty(str) && j2 >= j) {
                        JSONObject jSONObject = new JSONObject();
                        p.this.a(jSONObject, "start_ts", Long.valueOf(j));
                        p.this.a(jSONObject, "end_ts", Long.valueOf(j2));
                        p.this.a(jSONObject, "intercept_type", Integer.valueOf(i2));
                        p.this.a(jSONObject, "type", "intercept_js");
                        p.this.a(jSONObject, "url", str);
                        p.this.a(jSONObject, "duration", Long.valueOf(j2 - j));
                        p.this.a(p.this.f27292h, jSONObject);
                    }
                }
            }
        });
    }

    public void b(final String str) {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onWebviewJsbEnd") { // from class: com.bytedance.sdk.openadsdk.c.p.10
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(jSONObject, "jsb", str);
                    p.this.a(p.this.f27290f, "webview_jsb_end", jSONObject);
                }
            }
        });
    }

    public void b(final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("addExtraH5JsonObject") { // from class: com.bytedance.sdk.openadsdk.c.p.11
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (p.this.f27290f != null && jSONObject != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            p.this.a(p.this.f27290f, next, jSONObject.opt(next));
                        }
                        p.this.f27288d = Boolean.TRUE;
                        p.this.m();
                    }
                }
            }
        });
    }

    public void a() {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onRenderStart") { // from class: com.bytedance.sdk.openadsdk.c.p.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f27290f, "render_start", jSONObject);
                }
            }
        });
    }

    public void a(final int i2) {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onRenderError") { // from class: com.bytedance.sdk.openadsdk.c.p.14
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    p.this.a(i2, (String) null);
                }
            }
        });
    }

    public void a(final int i2, final String str) {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onRenderError") { // from class: com.bytedance.sdk.openadsdk.c.p.15
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(jSONObject, "code", Integer.valueOf(i2));
                    if (str != null) {
                        p.this.a(jSONObject, "msg", str);
                    }
                    p.this.a(p.this.f27290f, "render_error", jSONObject);
                }
            }
        });
    }

    public void a(final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onWebviewLoadError") { // from class: com.bytedance.sdk.openadsdk.c.p.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    p.this.a(jSONObject2, "ts", Long.valueOf(System.currentTimeMillis()));
                    p.this.a(p.this.f27290f, "webview_load_error", jSONObject2);
                }
            }
        });
    }

    public void a(final String str, final long j, final long j2, final int i2) {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onInterceptHtml") { // from class: com.bytedance.sdk.openadsdk.c.p.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (!TextUtils.isEmpty(str) && j2 >= j) {
                        JSONObject jSONObject = new JSONObject();
                        p.this.a(jSONObject, "start_ts", Long.valueOf(j));
                        p.this.a(jSONObject, "end_ts", Long.valueOf(j2));
                        p.this.a(jSONObject, "intercept_type", Integer.valueOf(i2));
                        p.this.a(jSONObject, "type", "intercept_html");
                        p.this.a(jSONObject, "url", str);
                        p.this.a(jSONObject, "duration", Long.valueOf(j2 - j));
                        p.this.a(p.this.f27292h, jSONObject);
                    }
                }
            }
        });
    }

    public void a(final String str) {
        com.bytedance.sdk.openadsdk.l.e.b(new com.bytedance.sdk.openadsdk.l.g("onWebviewJsbStart") { // from class: com.bytedance.sdk.openadsdk.c.p.9
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
                    p.this.a(jSONObject, "jsb", str);
                    p.this.a(p.this.f27290f, "webview_jsb_start", jSONObject);
                }
            }
        });
    }

    public void a(boolean z) {
        this.f27289e = Boolean.valueOf(z);
    }

    public p() {
        this.f27285a = "embeded_ad";
        Boolean bool = Boolean.FALSE;
        this.f27287c = bool;
        this.f27288d = bool;
        this.f27289e = bool;
        this.f27293i = false;
        this.j = new Object();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!z) {
            try {
                if (jSONObject.has(str)) {
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        jSONObject.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj) {
        a(jSONObject, str, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONArray jSONArray, Object obj) {
        if (jSONArray != null && jSONArray.length() < 10) {
            try {
                jSONArray.put(obj);
            } catch (Exception unused) {
            }
        }
    }
}
