package com.bytedance.sdk.openadsdk.core.d;

import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public String f28105a;

    /* renamed from: b  reason: collision with root package name */
    public String f28106b;

    /* renamed from: c  reason: collision with root package name */
    public String f28107c;

    /* renamed from: d  reason: collision with root package name */
    public int f28108d;

    /* renamed from: e  reason: collision with root package name */
    public int f28109e;

    /* renamed from: f  reason: collision with root package name */
    public int f28110f;

    /* renamed from: g  reason: collision with root package name */
    public String f28111g;

    public String a() {
        return this.f28111g;
    }

    public String b() {
        return this.f28105a;
    }

    public String c() {
        return this.f28106b;
    }

    public String d() {
        return this.f28107c;
    }

    public int e() {
        return this.f28108d;
    }

    public int f() {
        return this.f28109e;
    }

    public int g() {
        return this.f28110f;
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
        this.f28111g = str;
    }

    public void b(String str) {
        this.f28105a = str;
    }

    public void c(String str) {
        this.f28106b = str;
    }

    public void d(String str) {
        this.f28107c = str;
    }

    public void a(int i) {
        this.f28108d = i;
    }

    public void b(int i) {
        this.f28109e = i;
    }

    public void c(int i) {
        this.f28110f = i;
    }
}
