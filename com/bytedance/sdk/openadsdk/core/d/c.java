package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f28649a;

    /* renamed from: b  reason: collision with root package name */
    public String f28650b;

    /* renamed from: c  reason: collision with root package name */
    public String f28651c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f28652d;

    /* renamed from: e  reason: collision with root package name */
    public String f28653e;

    /* renamed from: f  reason: collision with root package name */
    public String f28654f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f28655g = new HashMap<>();

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f28655g.put(str, str2);
    }

    public String b() {
        return this.f28649a;
    }

    public String c() {
        return this.f28650b;
    }

    public String d() {
        return this.f28651c;
    }

    public JSONArray e() {
        return this.f28652d;
    }

    public String f() {
        return this.f28653e;
    }

    public String g() {
        return this.f28654f;
    }

    public void b(String str) {
        this.f28650b = str;
    }

    public void c(String str) {
        this.f28651c = str;
    }

    public void d(String str) {
        this.f28653e = str;
    }

    public void e(String str) {
        this.f28654f = str;
    }

    public HashMap<String, String> a() {
        return this.f28655g;
    }

    public void a(String str) {
        this.f28649a = str;
    }

    public void a(JSONArray jSONArray) {
        this.f28652d = jSONArray;
    }
}
