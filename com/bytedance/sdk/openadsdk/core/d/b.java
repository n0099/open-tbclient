package com.bytedance.sdk.openadsdk.core.d;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f27791a;

    /* renamed from: b  reason: collision with root package name */
    public String f27792b;

    /* renamed from: c  reason: collision with root package name */
    public String f27793c;

    /* renamed from: d  reason: collision with root package name */
    public int f27794d;

    /* renamed from: e  reason: collision with root package name */
    public int f27795e;

    /* renamed from: f  reason: collision with root package name */
    public int f27796f;

    /* renamed from: g  reason: collision with root package name */
    public String f27797g;

    public String a() {
        return this.f27797g;
    }

    public String b() {
        return this.f27791a;
    }

    public String c() {
        return this.f27792b;
    }

    public String d() {
        return this.f27793c;
    }

    public int e() {
        return this.f27794d;
    }

    public int f() {
        return this.f27795e;
    }

    public int g() {
        return this.f27796f;
    }

    public JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(DpStatConstants.KEY_APP_NAME, c());
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
        this.f27797g = str;
    }

    public void b(String str) {
        this.f27791a = str;
    }

    public void c(String str) {
        this.f27792b = str;
    }

    public void d(String str) {
        this.f27793c = str;
    }

    public void a(int i) {
        this.f27794d = i;
    }

    public void b(int i) {
        this.f27795e = i;
    }

    public void c(int i) {
        this.f27796f = i;
    }
}
