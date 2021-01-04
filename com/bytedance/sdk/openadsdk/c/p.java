package com.bytedance.sdk.openadsdk.c;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    private String f6545a;

    /* renamed from: b  reason: collision with root package name */
    private com.bytedance.sdk.openadsdk.core.d.l f6546b;
    private Boolean c = false;
    private Boolean d = false;
    private Boolean e = false;
    private volatile boolean i = false;
    private JSONObject f = new JSONObject();
    private JSONArray g = new JSONArray();
    private JSONArray h = new JSONArray();

    public p(int i, String str, com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f6545a = "embeded_ad";
        this.f6545a = str;
        this.f6546b = lVar;
        a(this.f, "webview_source", Integer.valueOf(i));
    }

    public void a() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
        a(this.f, "render_start", jSONObject);
    }

    public void b() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
        a(this.f, "render_success", jSONObject);
    }

    public void a(int i) {
        a(i, (String) null);
    }

    public void a(int i, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
        a(jSONObject, "code", Integer.valueOf(i));
        if (str != null) {
            a(jSONObject, "msg", str);
        }
        a(this.f, "render_error", jSONObject);
    }

    public void c() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
        a(this.f, "native_render_start", jSONObject);
    }

    public void d() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
        a(this.f, "native_render_end", jSONObject);
    }

    public void e() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
        a(this.f, "webview_load_start", (Object) jSONObject, false);
    }

    public void f() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
        a(this.f, "webview_load_success", jSONObject);
    }

    public void g() {
        a((JSONObject) null);
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        a(jSONObject, "ts", Long.valueOf(System.currentTimeMillis()));
        a(this.f, "webview_load_error", jSONObject);
    }

    public void h() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
        a(this.f, "native_endcard_show", jSONObject);
    }

    public void i() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
        a(this.f, "native_endcard_close", jSONObject);
    }

    public void j() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
        a(jSONObject, "type", "native_enterBackground");
        a(this.g, jSONObject);
    }

    public void k() {
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
        a(jSONObject, "type", "native_enterForeground");
        a(this.g, jSONObject);
    }

    public void a(String str, long j, long j2, int i) {
        if (!TextUtils.isEmpty(str) && j2 >= j) {
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, "start_ts", Long.valueOf(j));
            a(jSONObject, "end_ts", Long.valueOf(j2));
            a(jSONObject, "intercept_type", Integer.valueOf(i));
            a(jSONObject, "type", "intercept_html");
            a(jSONObject, "url", str);
            a(jSONObject, "duration", Long.valueOf(j2 - j));
            a(this.h, jSONObject);
        }
    }

    public void b(String str, long j, long j2, int i) {
        if (!TextUtils.isEmpty(str) && j2 >= j) {
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, "start_ts", Long.valueOf(j));
            a(jSONObject, "end_ts", Long.valueOf(j2));
            a(jSONObject, "intercept_type", Integer.valueOf(i));
            a(jSONObject, "type", "intercept_js");
            a(jSONObject, "url", str);
            a(jSONObject, "duration", Long.valueOf(j2 - j));
            a(this.h, jSONObject);
        }
    }

    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
            a(jSONObject, "jsb", str);
            a(this.f, "webview_jsb_start", jSONObject);
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            a(jSONObject, "ts", Long.valueOf(currentTimeMillis));
            a(jSONObject, "jsb", str);
            a(this.f, "webview_jsb_end", jSONObject);
        }
    }

    public void b(JSONObject jSONObject) {
        if (this.f != null && jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                a(this.f, next, jSONObject.opt(next));
            }
            this.d = true;
            m();
        }
    }

    public void l() {
        this.c = true;
    }

    public void a(boolean z) {
        this.e = Boolean.valueOf(z);
    }

    public void m() {
        this.i = true;
        if (n()) {
            if (this.g != null && this.g.length() != 0) {
                try {
                    this.f.put("native_switchBackgroundAndForeground", this.g);
                } catch (Exception e) {
                }
            }
            if (this.h != null && this.h.length() != 0) {
                try {
                    this.f.put("intercept_source", this.h);
                } catch (Exception e2) {
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("webview_time_track", this.f);
            if (com.bytedance.sdk.openadsdk.core.i.c().u() && this.f != null) {
                u.b("WebviewTimeTrack", this.f.toString());
            }
            d.h(com.bytedance.sdk.openadsdk.core.p.a(), this.f6546b, this.f6545a, "webview_time_track", hashMap);
            this.i = false;
        }
    }

    private boolean n() {
        return this.e.booleanValue() || (this.d.booleanValue() && this.c.booleanValue());
    }

    private void a(JSONObject jSONObject, String str, Object obj, boolean z) {
        if (!this.i && jSONObject != null && !TextUtils.isEmpty(str)) {
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

    private void a(JSONObject jSONObject, String str, Object obj) {
        if (!this.i) {
            a(jSONObject, str, obj, true);
        }
    }

    private void a(JSONArray jSONArray, Object obj) {
        if (!this.i && jSONArray != null && jSONArray.length() < 10) {
            try {
                jSONArray.put(obj);
            } catch (Exception e) {
            }
        }
    }
}
