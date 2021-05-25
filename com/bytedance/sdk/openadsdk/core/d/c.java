package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f27823a;

    /* renamed from: b  reason: collision with root package name */
    public String f27824b;

    /* renamed from: c  reason: collision with root package name */
    public String f27825c;

    /* renamed from: d  reason: collision with root package name */
    public JSONArray f27826d;

    /* renamed from: e  reason: collision with root package name */
    public String f27827e;

    /* renamed from: f  reason: collision with root package name */
    public String f27828f;

    /* renamed from: g  reason: collision with root package name */
    public HashMap<String, String> f27829g = new HashMap<>();

    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f27829g.put(str, str2);
    }

    public String b() {
        return this.f27823a;
    }

    public String c() {
        return this.f27824b;
    }

    public String d() {
        return this.f27825c;
    }

    public JSONArray e() {
        return this.f27826d;
    }

    public String f() {
        return this.f27827e;
    }

    public String g() {
        return this.f27828f;
    }

    public void b(String str) {
        this.f27824b = str;
    }

    public void c(String str) {
        this.f27825c = str;
    }

    public void d(String str) {
        this.f27827e = str;
    }

    public void e(String str) {
        this.f27828f = str;
    }

    public HashMap<String, String> a() {
        return this.f27829g;
    }

    public void a(String str) {
        this.f27823a = str;
    }

    public void a(JSONArray jSONArray) {
        this.f27826d = jSONArray;
    }
}
