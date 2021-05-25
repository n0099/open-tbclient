package com.bytedance.sdk.openadsdk.core.dynamic.b;

import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public String f28005a;

    /* renamed from: b  reason: collision with root package name */
    public float f28006b;

    /* renamed from: c  reason: collision with root package name */
    public float f28007c;

    /* renamed from: d  reason: collision with root package name */
    public float f28008d;

    /* renamed from: e  reason: collision with root package name */
    public float f28009e;

    /* renamed from: f  reason: collision with root package name */
    public float f28010f;

    /* renamed from: g  reason: collision with root package name */
    public c f28011g;

    /* renamed from: h  reason: collision with root package name */
    public List<f> f28012h;

    public void a(String str) {
        this.f28005a = str;
    }

    public float b() {
        return this.f28007c;
    }

    public float c() {
        return this.f28008d;
    }

    public float d() {
        return this.f28009e;
    }

    public void e(float f2) {
        this.f28010f = f2;
    }

    public List<f> f() {
        return this.f28012h;
    }

    public float a() {
        return this.f28006b;
    }

    public void b(float f2) {
        this.f28007c = f2;
    }

    public void c(float f2) {
        this.f28008d = f2;
    }

    public void d(float f2) {
        this.f28009e = f2;
    }

    public c e() {
        return this.f28011g;
    }

    public void a(float f2) {
        this.f28006b = f2;
    }

    public void a(c cVar) {
        this.f28011g = cVar;
    }

    public void a(f fVar) {
        if (this.f28012h == null) {
            this.f28012h = new ArrayList();
        }
        this.f28012h.add(fVar);
    }

    public static void a(JSONObject jSONObject, f fVar) {
        if (jSONObject == null || fVar == null) {
            return;
        }
        fVar.a(jSONObject.optString("id", PrefetchEvent.EVENT_DATA_ROOT_PATH));
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
