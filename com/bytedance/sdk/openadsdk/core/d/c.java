package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f28112a;

    /* renamed from: b  reason: collision with root package name */
    public String f28113b;

    /* renamed from: c  reason: collision with root package name */
    public String f28114c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f28115d;

    /* renamed from: e  reason: collision with root package name */
    public String f28116e;

    /* renamed from: f  reason: collision with root package name */
    public String f28117f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f28118g = new HashMap<>();

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f28118g.put(str, str2);
    }

    public String b() {
        return this.f28112a;
    }

    public String c() {
        return this.f28113b;
    }

    public String d() {
        return this.f28114c;
    }

    public JSONArray e() {
        return this.f28115d;
    }

    public String f() {
        return this.f28116e;
    }

    public String g() {
        return this.f28117f;
    }

    public void b(String str) {
        this.f28113b = str;
    }

    public void c(String str) {
        this.f28114c = str;
    }

    public void d(String str) {
        this.f28116e = str;
    }

    public void e(String str) {
        this.f28117f = str;
    }

    public HashMap<String, String> a() {
        return this.f28118g;
    }

    public void a(String str) {
        this.f28112a = str;
    }

    public void a(JSONArray jSONArray) {
        this.f28115d = jSONArray;
    }
}
