package com.bytedance.sdk.openadsdk.core.d;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f28642a;

    /* renamed from: b  reason: collision with root package name */
    public String f28643b;

    /* renamed from: c  reason: collision with root package name */
    public String f28644c;

    /* renamed from: d  reason: collision with root package name */
    public int f28645d;

    /* renamed from: e  reason: collision with root package name */
    public int f28646e;

    /* renamed from: f  reason: collision with root package name */
    public int f28647f;

    /* renamed from: g  reason: collision with root package name */
    public String f28648g;

    public String a() {
        return this.f28648g;
    }

    public String b() {
        return this.f28642a;
    }

    public String c() {
        return this.f28643b;
    }

    public String d() {
        return this.f28644c;
    }

    public int e() {
        return this.f28645d;
    }

    public int f() {
        return this.f28646e;
    }

    public int g() {
        return this.f28647f;
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
        this.f28648g = str;
    }

    public void b(String str) {
        this.f28642a = str;
    }

    public void c(String str) {
        this.f28643b = str;
    }

    public void d(String str) {
        this.f28644c = str;
    }

    public void a(int i2) {
        this.f28645d = i2;
    }

    public void b(int i2) {
        this.f28646e = i2;
    }

    public void c(int i2) {
        this.f28647f = i2;
    }
}
