package com.bytedance.sdk.openadsdk.core.dynamic.b;

import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.pb.interactionpopupwindow.CustomDialogData;
import kotlinx.coroutines.DebugKt;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d {
    public String A;
    public boolean B;

    /* renamed from: a  reason: collision with root package name */
    public float f27993a;

    /* renamed from: b  reason: collision with root package name */
    public float f27994b;

    /* renamed from: c  reason: collision with root package name */
    public float f27995c;

    /* renamed from: d  reason: collision with root package name */
    public float f27996d;

    /* renamed from: e  reason: collision with root package name */
    public float f27997e;

    /* renamed from: f  reason: collision with root package name */
    public float f27998f;

    /* renamed from: g  reason: collision with root package name */
    public float f27999g;

    /* renamed from: h  reason: collision with root package name */
    public float f28000h;

    /* renamed from: i  reason: collision with root package name */
    public float f28001i;
    public float j;
    public int k;
    public int l;
    public String m;
    public String n;
    public String o;
    public String p;
    public String q;
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;
    public String z;

    public float a() {
        return this.f27993a;
    }

    public float b() {
        return this.f27994b;
    }

    public void c(float f2) {
        this.f27995c = f2;
    }

    public void d(float f2) {
        this.f27996d = f2;
    }

    public void e(float f2) {
        this.f27997e = f2;
    }

    public void f(float f2) {
        this.f27998f = f2;
    }

    public void g(float f2) {
        this.f27999g = f2;
    }

    public void h(float f2) {
        this.f28000h = f2;
    }

    public void i(float f2) {
        this.f28001i = f2;
    }

    public void j(float f2) {
        this.j = f2;
    }

    public String k() {
        return this.q;
    }

    public String l() {
        return this.r;
    }

    public String m() {
        return this.x;
    }

    public String n() {
        return this.y;
    }

    public void o(String str) {
        this.A = str;
    }

    public void a(float f2) {
        this.f27993a = f2;
    }

    public void b(float f2) {
        this.f27994b = f2;
    }

    public float c() {
        return this.f27998f;
    }

    public float d() {
        return this.f27999g;
    }

    public float e() {
        return this.f28000h;
    }

    public float f() {
        return this.f28001i;
    }

    public float g() {
        return this.j;
    }

    public int h() {
        return this.k;
    }

    public String i() {
        return this.o;
    }

    public String j() {
        return this.p;
    }

    public void k(String str) {
        this.w = str;
    }

    public void l(String str) {
        this.x = str;
    }

    public void m(String str) {
        this.y = str;
    }

    public void n(String str) {
        this.z = str;
    }

    public boolean o() {
        return this.B;
    }

    public void a(int i2) {
        this.k = i2;
    }

    public void b(int i2) {
        this.l = i2;
    }

    public void c(String str) {
        this.o = str;
    }

    public void d(String str) {
        this.p = str;
    }

    public void e(String str) {
        this.q = str;
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

    public void a(String str) {
        this.m = str;
    }

    public void b(String str) {
        this.n = str;
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
        dVar.m(jSONObject.optString("clickTigger", PrefetchEvent.STATE_CLICK));
        dVar.b(jSONObject.optString("fontFamily", "PingFangSC"));
        dVar.c(jSONObject.optString("textAlign", CustomDialogData.POS_LEFT));
        dVar.d(jSONObject.optString("color", "#999999"));
        dVar.e(jSONObject.optString("bgColor", OpenFlutter.EXTRA_TRANSPARANT));
        dVar.f(jSONObject.optString("borderColor", "#000000"));
        dVar.g(jSONObject.optString("borderStyle", "solid"));
        dVar.h(jSONObject.optString("heightMode", DebugKt.DEBUG_PROPERTY_VALUE_AUTO));
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
