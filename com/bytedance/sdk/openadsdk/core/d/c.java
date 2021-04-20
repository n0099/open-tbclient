package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f27798a;

    /* renamed from: b  reason: collision with root package name */
    public String f27799b;

    /* renamed from: c  reason: collision with root package name */
    public String f27800c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f27801d;

    /* renamed from: e  reason: collision with root package name */
    public String f27802e;

    /* renamed from: f  reason: collision with root package name */
    public String f27803f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f27804g = new HashMap<>();

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f27804g.put(str, str2);
    }

    public String b() {
        return this.f27798a;
    }

    public String c() {
        return this.f27799b;
    }

    public String d() {
        return this.f27800c;
    }

    public JSONArray e() {
        return this.f27801d;
    }

    public String f() {
        return this.f27802e;
    }

    public String g() {
        return this.f27803f;
    }

    public void b(String str) {
        this.f27799b = str;
    }

    public void c(String str) {
        this.f27800c = str;
    }

    public void d(String str) {
        this.f27802e = str;
    }

    public void e(String str) {
        this.f27803f = str;
    }

    public HashMap<String, String> a() {
        return this.f27804g;
    }

    public void a(String str) {
        this.f27798a = str;
    }

    public void a(JSONArray jSONArray) {
        this.f27801d = jSONArray;
    }
}
