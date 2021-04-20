package com.bytedance.sdk.openadsdk.core.dynamic.b;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f27968a;

    /* renamed from: b  reason: collision with root package name */
    public float f27969b;

    /* renamed from: c  reason: collision with root package name */
    public float f27970c;

    /* renamed from: d  reason: collision with root package name */
    public float f27971d;

    /* renamed from: e  reason: collision with root package name */
    public float f27972e;

    /* renamed from: f  reason: collision with root package name */
    public float f27973f;

    /* renamed from: g  reason: collision with root package name */
    public c f27974g;

    /* renamed from: h  reason: collision with root package name */
    public List<f> f27975h;

    public void a(String str) {
        this.f27968a = str;
    }

    public float b() {
        return this.f27970c;
    }

    public float c() {
        return this.f27971d;
    }

    public float d() {
        return this.f27972e;
    }

    public void e(float f2) {
        this.f27973f = f2;
    }

    public List<f> f() {
        return this.f27975h;
    }

    public float a() {
        return this.f27969b;
    }

    public void b(float f2) {
        this.f27970c = f2;
    }

    public void c(float f2) {
        this.f27971d = f2;
    }

    public void d(float f2) {
        this.f27972e = f2;
    }

    public c e() {
        return this.f27974g;
    }

    public void a(float f2) {
        this.f27969b = f2;
    }

    public void a(c cVar) {
        this.f27974g = cVar;
    }

    public void a(f fVar) {
        if (this.f27975h == null) {
            this.f27975h = new ArrayList();
        }
        this.f27975h.add(fVar);
    }

    public static void a(JSONObject jSONObject, f fVar) {
        if (jSONObject == null || fVar == null) {
            return;
        }
        fVar.a(jSONObject.optString("id", "root"));
        fVar.a((float) jSONObject.optDouble("x", 0.0d));
        fVar.b((float) jSONObject.optDouble("y", 0.0d));
        fVar.c((float) jSONObject.optDouble("width", 0.0d));
        fVar.d((float) jSONObject.optDouble("height", 0.0d));
        fVar.e((float) jSONObject.optDouble("remainWidth", 0.0d));
        c cVar = new c();
        c.a(jSONObject.optJSONObject("brick"), cVar);
        fVar.a(cVar);
        JSONArray optJSONArray = jSONObject.optJSONArray("children");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return;
        }
        for (int i = 0; i < optJSONArray.length(); i++) {
            Object opt = optJSONArray.opt(i);
            if (opt != null && !StringUtil.NULL_STRING.equals(opt.toString()) && (opt instanceof JSONArray)) {
                int i2 = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) opt;
                    if (i2 < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                        f fVar2 = new f();
                        a(optJSONObject, fVar2);
                        fVar.a(fVar2);
                        i2++;
                    }
                }
            }
        }
    }
}
