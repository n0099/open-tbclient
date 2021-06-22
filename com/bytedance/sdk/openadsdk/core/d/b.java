package com.bytedance.sdk.openadsdk.core.d;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f28001a;

    /* renamed from: b  reason: collision with root package name */
    public String f28002b;

    /* renamed from: c  reason: collision with root package name */
    public String f28003c;

    /* renamed from: d  reason: collision with root package name */
    public int f28004d;

    /* renamed from: e  reason: collision with root package name */
    public int f28005e;

    /* renamed from: f  reason: collision with root package name */
    public int f28006f;

    /* renamed from: g  reason: collision with root package name */
    public String f28007g;

    public String a() {
        return this.f28007g;
    }

    public String b() {
        return this.f28001a;
    }

    public String c() {
        return this.f28002b;
    }

    public String d() {
        return this.f28003c;
    }

    public int e() {
        return this.f28004d;
    }

    public int f() {
        return this.f28005e;
    }

    public int g() {
        return this.f28006f;
    }

    public JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", c());
            jSONObject.put("app_size", g());
            jSONObject.put("comment_num", f());
            jSONObject.put("download_url", b());
            jSONObject.put("package_name", d());
            jSONObject.put("score", e());
        } catch (Exception e2) {
            com.bytedance.sdk.openadsdk.utils.u.b(e2.toString());
        }
        return jSONObject;
    }

    public void a(String str) {
        this.f28007g = str;
    }

    public void b(String str) {
        this.f28001a = str;
    }

    public void c(String str) {
        this.f28002b = str;
    }

    public void d(String str) {
        this.f28003c = str;
    }

    public void a(int i2) {
        this.f28004d = i2;
    }

    public void b(int i2) {
        this.f28005e = i2;
    }

    public void c(int i2) {
        this.f28006f = i2;
    }
}
