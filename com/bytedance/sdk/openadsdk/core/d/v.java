package com.bytedance.sdk.openadsdk.core.d;

import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public int f27939a;

    /* renamed from: b  reason: collision with root package name */
    public int f27940b;

    /* renamed from: c  reason: collision with root package name */
    public long f27941c;

    /* renamed from: d  reason: collision with root package name */
    public double f27942d;

    /* renamed from: e  reason: collision with root package name */
    public String f27943e;

    /* renamed from: f  reason: collision with root package name */
    public String f27944f;

    /* renamed from: g  reason: collision with root package name */
    public String f27945g;

    /* renamed from: h  reason: collision with root package name */
    public String f27946h;
    public String i;
    public String j;
    public int k;
    public int l = 0;
    public int m = 0;

    public int a() {
        return this.k;
    }

    public int b() {
        return this.f27939a;
    }

    public int c() {
        return this.f27940b;
    }

    public long d() {
        return this.f27941c;
    }

    public double e() {
        return this.f27942d;
    }

    public String f() {
        return this.f27943e;
    }

    public int[] g() {
        try {
            int indexOf = this.f27943e.indexOf("x");
            return new int[]{Integer.parseInt(this.f27943e.substring(0, indexOf).trim()), Integer.parseInt(this.f27943e.substring(indexOf + 1).trim())};
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.u.c("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    public String h() {
        return this.f27944f;
    }

    public String i() {
        return this.f27945g;
    }

    public String j() {
        return this.f27946h;
    }

    public String k() {
        return this.i;
    }

    public String l() {
        return this.j;
    }

    public JSONObject m() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", b());
            jSONObject.put("cover_url", h());
            jSONObject.put("cover_width", c());
            jSONObject.put("endcard", j());
            jSONObject.put("file_hash", l());
            jSONObject.put("resolution", f());
            jSONObject.put("size", d());
            jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, e());
            jSONObject.put("video_url", i());
            jSONObject.put("playable_download_url", k());
            jSONObject.put("if_playable_loading_show", n());
            jSONObject.put("remove_loading_page_type", o());
            jSONObject.put("fallback_endcard_judge", a());
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    public int n() {
        return this.l;
    }

    public int o() {
        return this.m;
    }

    public void a(int i) {
        this.k = i;
    }

    public void b(int i) {
        this.f27939a = i;
    }

    public void c(int i) {
        this.f27940b = i;
    }

    public void d(String str) {
        this.f27946h = str;
    }

    public void e(String str) {
        this.i = str;
    }

    public void f(String str) {
        this.j = str;
    }

    public void a(long j) {
        this.f27941c = j;
    }

    public void b(String str) {
        this.f27944f = str;
    }

    public void c(String str) {
        this.f27945g = str;
    }

    public void d(int i) {
        this.l = i;
    }

    public void e(int i) {
        this.m = i;
    }

    public void a(double d2) {
        this.f27942d = d2;
    }

    public void a(String str) {
        this.f27943e = str;
    }

    public static int[] a(l lVar) {
        if (lVar == null || lVar.X() == null) {
            return null;
        }
        return lVar.X().g();
    }
}
