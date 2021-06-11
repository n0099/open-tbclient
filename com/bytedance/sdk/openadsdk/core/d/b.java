package com.bytedance.sdk.openadsdk.core.d;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f27919a;

    /* renamed from: b  reason: collision with root package name */
    public String f27920b;

    /* renamed from: c  reason: collision with root package name */
    public String f27921c;

    /* renamed from: d  reason: collision with root package name */
    public int f27922d;

    /* renamed from: e  reason: collision with root package name */
    public int f27923e;

    /* renamed from: f  reason: collision with root package name */
    public int f27924f;

    /* renamed from: g  reason: collision with root package name */
    public String f27925g;

    public String a() {
        return this.f27925g;
    }

    public String b() {
        return this.f27919a;
    }

    public String c() {
        return this.f27920b;
    }

    public String d() {
        return this.f27921c;
    }

    public int e() {
        return this.f27922d;
    }

    public int f() {
        return this.f27923e;
    }

    public int g() {
        return this.f27924f;
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
        this.f27925g = str;
    }

    public void b(String str) {
        this.f27919a = str;
    }

    public void c(String str) {
        this.f27920b = str;
    }

    public void d(String str) {
        this.f27921c = str;
    }

    public void a(int i2) {
        this.f27922d = i2;
    }

    public void b(int i2) {
        this.f27923e = i2;
    }

    public void c(int i2) {
        this.f27924f = i2;
    }
}
