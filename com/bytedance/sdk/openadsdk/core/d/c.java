package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f28113a;

    /* renamed from: b  reason: collision with root package name */
    public String f28114b;

    /* renamed from: c  reason: collision with root package name */
    public String f28115c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f28116d;

    /* renamed from: e  reason: collision with root package name */
    public String f28117e;

    /* renamed from: f  reason: collision with root package name */
    public String f28118f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f28119g = new HashMap<>();

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f28119g.put(str, str2);
    }

    public String b() {
        return this.f28113a;
    }

    public String c() {
        return this.f28114b;
    }

    public String d() {
        return this.f28115c;
    }

    public JSONArray e() {
        return this.f28116d;
    }

    public String f() {
        return this.f28117e;
    }

    public String g() {
        return this.f28118f;
    }

    public void b(String str) {
        this.f28114b = str;
    }

    public void c(String str) {
        this.f28115c = str;
    }

    public void d(String str) {
        this.f28117e = str;
    }

    public void e(String str) {
        this.f28118f = str;
    }

    public HashMap<String, String> a() {
        return this.f28119g;
    }

    public void a(String str) {
        this.f28113a = str;
    }

    public void a(JSONArray jSONArray) {
        this.f28116d = jSONArray;
    }
}
