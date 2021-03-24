package com.bytedance.sdk.openadsdk.core.dynamic.b;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f28282a;

    /* renamed from: b  reason: collision with root package name */
    public float f28283b;

    /* renamed from: c  reason: collision with root package name */
    public float f28284c;

    /* renamed from: d  reason: collision with root package name */
    public float f28285d;

    /* renamed from: e  reason: collision with root package name */
    public float f28286e;

    /* renamed from: f  reason: collision with root package name */
    public float f28287f;

    /* renamed from: g  reason: collision with root package name */
    public c f28288g;

    /* renamed from: h  reason: collision with root package name */
    public List<f> f28289h;

    public void a(String str) {
        this.f28282a = str;
    }

    public float b() {
        return this.f28284c;
    }

    public float c() {
        return this.f28285d;
    }

    public float d() {
        return this.f28286e;
    }

    public void e(float f2) {
        this.f28287f = f2;
    }

    public List<f> f() {
        return this.f28289h;
    }

    public float a() {
        return this.f28283b;
    }

    public void b(float f2) {
        this.f28284c = f2;
    }

    public void c(float f2) {
        this.f28285d = f2;
    }

    public void d(float f2) {
        this.f28286e = f2;
    }

    public c e() {
        return this.f28288g;
    }

    public void a(float f2) {
        this.f28283b = f2;
    }

    public void a(c cVar) {
        this.f28288g = cVar;
    }

    public void a(f fVar) {
        if (this.f28289h == null) {
            this.f28289h = new ArrayList();
        }
        this.f28289h.add(fVar);
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
