package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f27926a;

    /* renamed from: b  reason: collision with root package name */
    public String f27927b;

    /* renamed from: c  reason: collision with root package name */
    public String f27928c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f27929d;

    /* renamed from: e  reason: collision with root package name */
    public String f27930e;

    /* renamed from: f  reason: collision with root package name */
    public String f27931f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f27932g = new HashMap<>();

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f27932g.put(str, str2);
    }

    public String b() {
        return this.f27926a;
    }

    public String c() {
        return this.f27927b;
    }

    public String d() {
        return this.f27928c;
    }

    public JSONArray e() {
        return this.f27929d;
    }

    public String f() {
        return this.f27930e;
    }

    public String g() {
        return this.f27931f;
    }

    public void b(String str) {
        this.f27927b = str;
    }

    public void c(String str) {
        this.f27928c = str;
    }

    public void d(String str) {
        this.f27930e = str;
    }

    public void e(String str) {
        this.f27931f = str;
    }

    public HashMap<String, String> a() {
        return this.f27932g;
    }

    public void a(String str) {
        this.f27926a = str;
    }

    public void a(JSONArray jSONArray) {
        this.f27929d = jSONArray;
    }
}
