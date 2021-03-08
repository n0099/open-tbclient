package com.bytedance.sdk.openadsdk.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.u;
import com.meizu.cloud.pushsdk.notification.model.TimeDisplaySetting;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private String f4211a;
    private com.bytedance.sdk.openadsdk.core.d.l b;
    private Boolean c;
    private Boolean d;
    private Boolean e;
    private JSONObject f;
    private JSONArray g;
    private JSONArray h;
    private boolean i;
    private final Object j;

    public p(int i, String str, com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f4211a = "embeded_ad";
        this.c = false;
        this.d = false;
        this.e = false;
        this.i = false;
        this.j = new Object();
        this.f4211a = str;
        this.b = lVar;
        this.f = new JSONObject();
        this.g = new JSONArray();
        this.h = new JSONArray();
        a(this.f, "webview_source", Integer.valueOf(i));
    }

    protected p() {
        this.f4211a = "embeded_ad";
        this.c = false;
        this.d = false;
        this.e = false;
        this.i = false;
        this.j = new Object();
    }

    public void a() {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.1
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f, "render_start", jSONObject);
                }
            }
        });
    }

    public void b() {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.12
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f, "render_success", jSONObject);
                }
            }
        });
    }

    public void a(final int i) {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.14
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    p.this.a(i, (String) null);
                }
            }
        });
    }

    public void a(final int i, final String str) {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.15
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                    p.this.a(jSONObject, "code", Integer.valueOf(i));
                    if (str != null) {
                        p.this.a(jSONObject, "msg", str);
                    }
                    p.this.a(p.this.f, "render_error", jSONObject);
                }
            }
        });
    }

    public void c() {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.16
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f, "native_render_start", jSONObject);
                }
            }
        });
    }

    public void d() {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.17
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f, "native_render_end", jSONObject);
                }
            }
        });
    }

    public void e() {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.18
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f, "webview_load_start", (Object) jSONObject, false);
                }
            }
        });
    }

    public void f() {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.19
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f, "webview_load_success", jSONObject);
                }
            }
        });
    }

    public void g() {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.20
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    p.this.a((JSONObject) null);
                }
            }
        });
    }

    public void a(final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    JSONObject jSONObject2 = jSONObject;
                    if (jSONObject2 == null) {
                        jSONObject2 = new JSONObject();
                    }
                    p.this.a(jSONObject2, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(System.currentTimeMillis()));
                    p.this.a(p.this.f, "webview_load_error", jSONObject2);
                }
            }
        });
    }

    public void h() {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.3
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f, "native_endcard_show", jSONObject);
                }
            }
        });
    }

    public void i() {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.4
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                    p.this.a(p.this.f, "native_endcard_close", jSONObject);
                }
            }
        });
    }

    public void j() {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.5
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                    p.this.a(jSONObject, "type", "native_enterBackground");
                    p.this.a(p.this.g, jSONObject);
                }
            }
        });
    }

    public void k() {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.6
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    long currentTimeMillis = System.currentTimeMillis();
                    JSONObject jSONObject = new JSONObject();
                    p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                    p.this.a(jSONObject, "type", "native_enterForeground");
                    p.this.a(p.this.g, jSONObject);
                }
            }
        });
    }

    public void a(final String str, final long j, final long j2, final int i) {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.7
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (!TextUtils.isEmpty(str) && j2 >= j) {
                        JSONObject jSONObject = new JSONObject();
                        p.this.a(jSONObject, "start_ts", Long.valueOf(j));
                        p.this.a(jSONObject, "end_ts", Long.valueOf(j2));
                        p.this.a(jSONObject, "intercept_type", Integer.valueOf(i));
                        p.this.a(jSONObject, "type", "intercept_html");
                        p.this.a(jSONObject, "url", str);
                        p.this.a(jSONObject, "duration", Long.valueOf(j2 - j));
                        p.this.a(p.this.h, jSONObject);
                    }
                }
            }
        });
    }

    public void b(final String str, final long j, final long j2, final int i) {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.8
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (!TextUtils.isEmpty(str) && j2 >= j) {
                        JSONObject jSONObject = new JSONObject();
                        p.this.a(jSONObject, "start_ts", Long.valueOf(j));
                        p.this.a(jSONObject, "end_ts", Long.valueOf(j2));
                        p.this.a(jSONObject, "intercept_type", Integer.valueOf(i));
                        p.this.a(jSONObject, "type", "intercept_js");
                        p.this.a(jSONObject, "url", str);
                        p.this.a(jSONObject, "duration", Long.valueOf(j2 - j));
                        p.this.a(p.this.h, jSONObject);
                    }
                }
            }
        });
    }

    public void a(final String str) {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.9
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (!TextUtils.isEmpty(str)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                        p.this.a(jSONObject, "jsb", str);
                        p.this.a(p.this.f, "webview_jsb_start", jSONObject);
                    }
                }
            }
        });
    }

    public void b(final String str) {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.10
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (!TextUtils.isEmpty(str)) {
                        long currentTimeMillis = System.currentTimeMillis();
                        JSONObject jSONObject = new JSONObject();
                        p.this.a(jSONObject, TimeDisplaySetting.TIME_DISPLAY_SETTING, Long.valueOf(currentTimeMillis));
                        p.this.a(jSONObject, "jsb", str);
                        p.this.a(p.this.f, "webview_jsb_end", jSONObject);
                    }
                }
            }
        });
    }

    public void b(final JSONObject jSONObject) {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.11
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (p.this.f != null && jSONObject != null) {
                        Iterator<String> keys = jSONObject.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            p.this.a(p.this.f, next, jSONObject.opt(next));
                        }
                        p.this.d = true;
                        p.this.m();
                    }
                }
            }
        });
    }

    public void l() {
        this.c = true;
    }

    public void a(boolean z) {
        this.e = Boolean.valueOf(z);
    }

    public void m() {
        com.bytedance.sdk.openadsdk.j.e.a().execute(new com.bytedance.sdk.openadsdk.j.g() { // from class: com.bytedance.sdk.openadsdk.c.p.13
            @Override // java.lang.Runnable
            public void run() {
                synchronized (p.this.j) {
                    if (p.this.n()) {
                        if (!p.this.i) {
                            if (p.this.g != null && p.this.g.length() != 0) {
                                try {
                                    p.this.f.put("native_switchBackgroundAndForeground", p.this.g);
                                } catch (Exception e) {
                                }
                            }
                            if (p.this.h != null && p.this.h.length() != 0) {
                                try {
                                    p.this.f.put("intercept_source", p.this.h);
                                } catch (Exception e2) {
                                }
                            }
                            HashMap hashMap = new HashMap();
                            hashMap.put("webview_time_track", p.this.f);
                            if (com.bytedance.sdk.openadsdk.core.i.d().v() && p.this.f != null) {
                                u.b("WebviewTimeTrack", p.this.f.toString());
                            }
                            d.h(com.bytedance.sdk.openadsdk.core.p.a(), p.this.b, p.this.f4211a, "webview_time_track", hashMap);
                            p.this.i = true;
                        }
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n() {
        return this.e.booleanValue() || (this.d.booleanValue() && this.c.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            if (!z) {
                try {
                    if (jSONObject.has(str)) {
                        return;
                    }
                } catch (Exception e) {
                    return;
                }
            }
            jSONObject.put(str, obj);
        }
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
            } catch (Exception e) {
            }
        }
    }
}
