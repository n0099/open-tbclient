package com.bytedance.sdk.openadsdk.core.dynamic.b;

import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    private String A;
    private boolean B;

    /* renamed from: a  reason: collision with root package name */
    private float f4414a;
    private float b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private float j;
    private int k;
    private int l;
    private String m;
    private String n;
    private String o;
    private String p;
    private String q;
    private String r;
    private String s;
    private String t;
    private String u;
    private String v;
    private String w;
    private String x;
    private String y;
    private String z;

    public float a() {
        return this.f4414a;
    }

    public void a(float f) {
        this.f4414a = f;
    }

    public float b() {
        return this.b;
    }

    public void b(float f) {
        this.b = f;
    }

    public void c(float f) {
        this.c = f;
    }

    public void d(float f) {
        this.d = f;
    }

    public void e(float f) {
        this.e = f;
    }

    public float c() {
        return this.f;
    }

    public void f(float f) {
        this.f = f;
    }

    public float d() {
        return this.g;
    }

    public void g(float f) {
        this.g = f;
    }

    public float e() {
        return this.h;
    }

    public void h(float f) {
        this.h = f;
    }

    public float f() {
        return this.i;
    }

    public void i(float f) {
        this.i = f;
    }

    public float g() {
        return this.j;
    }

    public void j(float f) {
        this.j = f;
    }

    public int h() {
        return this.k;
    }

    public void a(int i) {
        this.k = i;
    }

    public void b(int i) {
        this.l = i;
    }

    public void a(String str) {
        this.m = str;
    }

    public void b(String str) {
        this.n = str;
    }

    public String i() {
        return this.o;
    }

    public void c(String str) {
        this.o = str;
    }

    public String j() {
        return this.p;
    }

    public void d(String str) {
        this.p = str;
    }

    public String k() {
        return this.q;
    }

    public void e(String str) {
        this.q = str;
    }

    public String l() {
        return this.r;
    }

    public void f(String str) {
        this.r = str;
    }

    public void g(String str) {
        this.s = str;
    }

    public void h(String str) {
        this.t = str;
    }

    public void i(String str) {
        this.u = str;
    }

    public void j(String str) {
        this.v = str;
    }

    public void k(String str) {
        this.w = str;
    }

    public String m() {
        return this.x;
    }

    public void l(String str) {
        this.x = str;
    }

    public String n() {
        return this.y;
    }

    public void m(String str) {
        this.y = str;
    }

    public void n(String str) {
        this.z = str;
    }

    public void o(String str) {
        this.A = str;
    }

    public boolean o() {
        return this.B;
    }

    public void a(boolean z) {
        this.B = z;
    }

    public static d a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        d dVar = new d();
        dVar.a(jSONObject.optString("adType", "embeded"));
        dVar.l(jSONObject.optString("clickArea", "creative"));
        dVar.m(jSONObject.optString("clickTigger", "click"));
        dVar.b(jSONObject.optString("fontFamily", "PingFangSC"));
        dVar.c(jSONObject.optString("textAlign", "left"));
        dVar.d(jSONObject.optString("color", "#999999"));
        dVar.e(jSONObject.optString("bgColor", "transparent"));
        dVar.f(jSONObject.optString("borderColor", "#000000"));
        dVar.g(jSONObject.optString("borderStyle", "solid"));
        dVar.h(jSONObject.optString("heightMode", "auto"));
        dVar.i(jSONObject.optString("widthMode", "fixed"));
        dVar.j(jSONObject.optString("interactText", ""));
        dVar.k(jSONObject.optString("interactType", ""));
        dVar.n(jSONObject.optString("justifyHorizontal", "space-around"));
        dVar.o(jSONObject.optString("justifyVertical", "flex-start"));
        dVar.a(jSONObject.optInt("timingStart"));
        dVar.b(jSONObject.optInt("timingEnd"));
        dVar.d((float) jSONObject.optDouble("width", 0.0d));
        dVar.c((float) jSONObject.optDouble("height", 0.0d));
        dVar.a((float) jSONObject.optDouble("borderRadius", 0.0d));
        dVar.b((float) jSONObject.optDouble("borderSize", 0.0d));
        dVar.e((float) jSONObject.optDouble("interactValidate", 0.0d));
        dVar.j((float) jSONObject.optDouble("fontSize", 0.0d));
        dVar.f((float) jSONObject.optDouble("paddingBottom", 0.0d));
        dVar.g((float) jSONObject.optDouble("paddingLeft", 0.0d));
        dVar.h((float) jSONObject.optDouble("paddingRight", 0.0d));
        dVar.i((float) jSONObject.optDouble("paddingTop", 0.0d));
        dVar.a(jSONObject.optBoolean("lineFeed", false));
        return dVar;
    }
}
