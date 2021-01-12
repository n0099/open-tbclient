package com.bytedance.sdk.openadsdk.core.d;

import com.baidu.ar.gesture.GestureAR;
import com.bytedance.sdk.openadsdk.utils.u;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f6485a;

    /* renamed from: b  reason: collision with root package name */
    private String f6486b;
    private String c;
    private int d;
    private int e;
    private int f;
    private String g;

    public String a() {
        return this.g;
    }

    public void a(String str) {
        this.g = str;
    }

    public String b() {
        return this.f6485a;
    }

    public void b(String str) {
        this.f6485a = str;
    }

    public String c() {
        return this.f6486b;
    }

    public void c(String str) {
        this.f6486b = str;
    }

    public String d() {
        return this.c;
    }

    public void d(String str) {
        this.c = str;
    }

    public int e() {
        return this.d;
    }

    public void a(int i) {
        this.d = i;
    }

    public int f() {
        return this.e;
    }

    public void b(int i) {
        this.e = i;
    }

    public int g() {
        return this.f;
    }

    public void c(int i) {
        this.f = i;
    }

    public JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", c());
            jSONObject.put("app_size", g());
            jSONObject.put("comment_num", f());
            jSONObject.put("download_url", b());
            jSONObject.put("package_name", d());
            jSONObject.put(GestureAR.SDK_TO_LUA_GESTURE_RESULT_SCORE, e());
        } catch (Exception e) {
            u.b(e.toString());
        }
        return jSONObject;
    }
}
