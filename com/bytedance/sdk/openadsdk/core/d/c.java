package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f27806a;

    /* renamed from: b  reason: collision with root package name */
    public String f27807b;

    /* renamed from: c  reason: collision with root package name */
    public String f27808c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f27809d;

    /* renamed from: e  reason: collision with root package name */
    public String f27810e;

    /* renamed from: f  reason: collision with root package name */
    public String f27811f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f27812g = new HashMap<>();

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f27812g.put(str, str2);
    }

    public String b() {
        return this.f27806a;
    }

    public String c() {
        return this.f27807b;
    }

    public String d() {
        return this.f27808c;
    }

    public JSONArray e() {
        return this.f27809d;
    }

    public String f() {
        return this.f27810e;
    }

    public String g() {
        return this.f27811f;
    }

    public void b(String str) {
        this.f27807b = str;
    }

    public void c(String str) {
        this.f27808c = str;
    }

    public void d(String str) {
        this.f27810e = str;
    }

    public void e(String str) {
        this.f27811f = str;
    }

    public HashMap<String, String> a() {
        return this.f27812g;
    }

    public void a(String str) {
        this.f27806a = str;
    }

    public void a(JSONArray jSONArray) {
        this.f27809d = jSONArray;
    }
}
