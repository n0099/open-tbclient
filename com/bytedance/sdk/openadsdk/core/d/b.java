package com.bytedance.sdk.openadsdk.core.d;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f27887a;

    /* renamed from: b  reason: collision with root package name */
    public String f27888b;

    /* renamed from: c  reason: collision with root package name */
    public String f27889c;

    /* renamed from: d  reason: collision with root package name */
    public int f27890d;

    /* renamed from: e  reason: collision with root package name */
    public int f27891e;

    /* renamed from: f  reason: collision with root package name */
    public int f27892f;

    /* renamed from: g  reason: collision with root package name */
    public String f27893g;

    public String a() {
        return this.f27893g;
    }

    public String b() {
        return this.f27887a;
    }

    public String c() {
        return this.f27888b;
    }

    public String d() {
        return this.f27889c;
    }

    public int e() {
        return this.f27890d;
    }

    public int f() {
        return this.f27891e;
    }

    public int g() {
        return this.f27892f;
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
        this.f27893g = str;
    }

    public void b(String str) {
        this.f27887a = str;
    }

    public void c(String str) {
        this.f27888b = str;
    }

    public void d(String str) {
        this.f27889c = str;
    }

    public void a(int i2) {
        this.f27890d = i2;
    }

    public void b(int i2) {
        this.f27891e = i2;
    }

    public void c(int i2) {
        this.f27892f = i2;
    }
}
