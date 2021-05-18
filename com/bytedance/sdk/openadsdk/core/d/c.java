package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f27894a;

    /* renamed from: b  reason: collision with root package name */
    public String f27895b;

    /* renamed from: c  reason: collision with root package name */
    public String f27896c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f27897d;

    /* renamed from: e  reason: collision with root package name */
    public String f27898e;

    /* renamed from: f  reason: collision with root package name */
    public String f27899f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f27900g = new HashMap<>();

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f27900g.put(str, str2);
    }

    public String b() {
        return this.f27894a;
    }

    public String c() {
        return this.f27895b;
    }

    public String d() {
        return this.f27896c;
    }

    public JSONArray e() {
        return this.f27897d;
    }

    public String f() {
        return this.f27898e;
    }

    public String g() {
        return this.f27899f;
    }

    public void b(String str) {
        this.f27895b = str;
    }

    public void c(String str) {
        this.f27896c = str;
    }

    public void d(String str) {
        this.f27898e = str;
    }

    public void e(String str) {
        this.f27899f = str;
    }

    public HashMap<String, String> a() {
        return this.f27900g;
    }

    public void a(String str) {
        this.f27894a = str;
    }

    public void a(JSONArray jSONArray) {
        this.f27897d = jSONArray;
    }
}
