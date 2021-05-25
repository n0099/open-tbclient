package com.bytedance.sdk.openadsdk.core.d;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f27816a;

    /* renamed from: b  reason: collision with root package name */
    public String f27817b;

    /* renamed from: c  reason: collision with root package name */
    public String f27818c;

    /* renamed from: d  reason: collision with root package name */
    public int f27819d;

    /* renamed from: e  reason: collision with root package name */
    public int f27820e;

    /* renamed from: f  reason: collision with root package name */
    public int f27821f;

    /* renamed from: g  reason: collision with root package name */
    public String f27822g;

    public String a() {
        return this.f27822g;
    }

    public String b() {
        return this.f27816a;
    }

    public String c() {
        return this.f27817b;
    }

    public String d() {
        return this.f27818c;
    }

    public int e() {
        return this.f27819d;
    }

    public int f() {
        return this.f27820e;
    }

    public int g() {
        return this.f27821f;
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
        this.f27822g = str;
    }

    public void b(String str) {
        this.f27816a = str;
    }

    public void c(String str) {
        this.f27817b = str;
    }

    public void d(String str) {
        this.f27818c = str;
    }

    public void a(int i2) {
        this.f27819d = i2;
    }

    public void b(int i2) {
        this.f27820e = i2;
    }

    public void c(int i2) {
        this.f27821f = i2;
    }
}
