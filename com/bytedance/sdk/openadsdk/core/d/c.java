package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f28008a;

    /* renamed from: b  reason: collision with root package name */
    public String f28009b;

    /* renamed from: c  reason: collision with root package name */
    public String f28010c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f28011d;

    /* renamed from: e  reason: collision with root package name */
    public String f28012e;

    /* renamed from: f  reason: collision with root package name */
    public String f28013f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f28014g = new HashMap<>();

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f28014g.put(str, str2);
    }

    public String b() {
        return this.f28008a;
    }

    public String c() {
        return this.f28009b;
    }

    public String d() {
        return this.f28010c;
    }

    public JSONArray e() {
        return this.f28011d;
    }

    public String f() {
        return this.f28012e;
    }

    public String g() {
        return this.f28013f;
    }

    public void b(String str) {
        this.f28009b = str;
    }

    public void c(String str) {
        this.f28010c = str;
    }

    public void d(String str) {
        this.f28012e = str;
    }

    public void e(String str) {
        this.f28013f = str;
    }

    public HashMap<String, String> a() {
        return this.f28014g;
    }

    public void a(String str) {
        this.f28008a = str;
    }

    public void a(JSONArray jSONArray) {
        this.f28011d = jSONArray;
    }
}
