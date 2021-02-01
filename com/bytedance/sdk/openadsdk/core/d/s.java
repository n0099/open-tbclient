package com.bytedance.sdk.openadsdk.core.d;

import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tieba.recapp.activity.newstyle.AdWebVideoActivityConfig;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    private int f6529a;

    /* renamed from: b  reason: collision with root package name */
    private int f6530b;
    private long c;
    private double d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private int k;
    private int l = 0;
    private int m = 0;

    public int a() {
        return this.k;
    }

    public void a(int i) {
        this.k = i;
    }

    public int b() {
        return this.f6529a;
    }

    public void b(int i) {
        this.f6529a = i;
    }

    public int c() {
        return this.f6530b;
    }

    public void c(int i) {
        this.f6530b = i;
    }

    public long d() {
        return this.c;
    }

    public void a(long j) {
        this.c = j;
    }

    public double e() {
        return this.d;
    }

    public void a(double d) {
        this.d = d;
    }

    public String f() {
        return this.e;
    }

    public void a(String str) {
        this.e = str;
    }

    public String g() {
        return this.f;
    }

    public void b(String str) {
        this.f = str;
    }

    public String h() {
        return this.g;
    }

    public void c(String str) {
        this.g = str;
    }

    public String i() {
        return this.h;
    }

    public void d(String str) {
        this.h = str;
    }

    public String j() {
        return this.i;
    }

    public void e(String str) {
        this.i = str;
    }

    public String k() {
        return this.j;
    }

    public void f(String str) {
        this.j = str;
    }

    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cover_height", b());
            jSONObject.put("cover_url", g());
            jSONObject.put("cover_width", c());
            jSONObject.put("endcard", i());
            jSONObject.put("file_hash", k());
            jSONObject.put("resolution", f());
            jSONObject.put(TiebaInitialize.LogFields.SIZE, d());
            jSONObject.put(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, e());
            jSONObject.put("video_url", h());
            jSONObject.put("playable_download_url", j());
            jSONObject.put("if_playable_loading_show", m());
            jSONObject.put("remove_loading_page_type", n());
            jSONObject.put("fallback_endcard_judge", a());
        } catch (Exception e) {
        }
        return jSONObject;
    }

    public int m() {
        return this.l;
    }

    public void d(int i) {
        this.l = i;
    }

    public int n() {
        return this.m;
    }

    public void e(int i) {
        this.m = i;
    }
}
