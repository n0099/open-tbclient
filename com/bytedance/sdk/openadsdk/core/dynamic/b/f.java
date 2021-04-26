package com.bytedance.sdk.openadsdk.core.dynamic.b;

import com.baidu.android.common.others.lang.StringUtil;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f28831a;

    /* renamed from: b  reason: collision with root package name */
    public float f28832b;

    /* renamed from: c  reason: collision with root package name */
    public float f28833c;

    /* renamed from: d  reason: collision with root package name */
    public float f28834d;

    /* renamed from: e  reason: collision with root package name */
    public float f28835e;

    /* renamed from: f  reason: collision with root package name */
    public float f28836f;

    /* renamed from: g  reason: collision with root package name */
    public c f28837g;

    /* renamed from: h  reason: collision with root package name */
    public List<f> f28838h;

    public void a(String str) {
        this.f28831a = str;
    }

    public float b() {
        return this.f28833c;
    }

    public float c() {
        return this.f28834d;
    }

    public float d() {
        return this.f28835e;
    }

    public void e(float f2) {
        this.f28836f = f2;
    }

    public List<f> f() {
        return this.f28838h;
    }

    public float a() {
        return this.f28832b;
    }

    public void b(float f2) {
        this.f28833c = f2;
    }

    public void c(float f2) {
        this.f28834d = f2;
    }

    public void d(float f2) {
        this.f28835e = f2;
    }

    public c e() {
        return this.f28837g;
    }

    public void a(float f2) {
        this.f28832b = f2;
    }

    public void a(c cVar) {
        this.f28837g = cVar;
    }

    public void a(f fVar) {
        if (this.f28838h == null) {
            this.f28838h = new ArrayList();
        }
        this.f28838h.add(fVar);
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
        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
            Object opt = optJSONArray.opt(i2);
            if (opt != null && !StringUtil.NULL_STRING.equals(opt.toString()) && (opt instanceof JSONArray)) {
                int i3 = 0;
                while (true) {
                    JSONArray jSONArray = (JSONArray) opt;
                    if (i3 < jSONArray.length()) {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                        f fVar2 = new f();
                        a(optJSONObject, fVar2);
                        fVar.a(fVar2);
                        i3++;
                    }
                }
            }
        }
    }
}
