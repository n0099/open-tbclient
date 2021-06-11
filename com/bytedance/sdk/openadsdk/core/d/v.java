package com.bytedance.sdk.openadsdk.core.d;

import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class v {

    /* renamed from: a  reason: collision with root package name */
    public int f28068a;

    /* renamed from: b  reason: collision with root package name */
    public int f28069b;

    /* renamed from: c  reason: collision with root package name */
    public long f28070c;

    /* renamed from: d  reason: collision with root package name */
    public double f28071d;

    /* renamed from: e  reason: collision with root package name */
    public String f28072e;

    /* renamed from: f  reason: collision with root package name */
    public String f28073f;

    /* renamed from: g  reason: collision with root package name */
    public String f28074g;

    /* renamed from: h  reason: collision with root package name */
    public String f28075h;

    /* renamed from: i  reason: collision with root package name */
    public String f28076i;
    public String j;
    public int k;
    public int l = 0;
    public int m = 0;

    public int a() {
        return this.k;
    }

    public int b() {
        return this.f28068a;
    }

    public int c() {
        return this.f28069b;
    }

    public long d() {
        return this.f28070c;
    }

    public double e() {
        return this.f28071d;
    }

    public String f() {
        return this.f28072e;
    }

    public int[] g() {
        try {
            int indexOf = this.f28072e.indexOf("x");
            return new int[]{Integer.parseInt(this.f28072e.substring(0, indexOf).trim()), Integer.parseInt(this.f28072e.substring(indexOf + 1).trim())};
        } catch (Throwable th) {
            com.bytedance.sdk.openadsdk.utils.u.c("VideoInfo", "getWidthAndHeight error", th);
            return null;
        }
    }

    public String h() {
        return this.f28073f;
    }

    public String i() {
        return this.f28074g;
    }

    public String j() {
        return this.f28075h;
    }

    public String k() {
        return this.f28076i;
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

    public void a(int i2) {
        this.k = i2;
    }

    public void b(int i2) {
        this.f28068a = i2;
    }

    public void c(int i2) {
        this.f28069b = i2;
    }

    public void d(String str) {
        this.f28075h = str;
    }

    public void e(String str) {
        this.f28076i = str;
    }

    public void f(String str) {
        this.j = str;
    }

    public void a(long j) {
        this.f28070c = j;
    }

    public void b(String str) {
        this.f28073f = str;
    }

    public void c(String str) {
        this.f28074g = str;
    }

    public void d(int i2) {
        this.l = i2;
    }

    public void e(int i2) {
        this.m = i2;
    }

    public void a(double d2) {
        this.f28071d = d2;
    }

    public void a(String str) {
        this.f28072e = str;
    }

    public static int[] a(l lVar) {
        if (lVar == null || lVar.X() == null) {
            return null;
        }
        return lVar.X().g();
    }
}
