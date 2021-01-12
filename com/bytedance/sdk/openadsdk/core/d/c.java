package com.bytedance.sdk.openadsdk.core.d;

import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONArray;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private String f6487a;

    /* renamed from: b  reason: collision with root package name */
    private String f6488b;
    private String c;
    private JSONArray d;
    private String e;
    private String f;
    private HashMap<String, String> g = new HashMap<>();

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.g.put(str, str2);
        }
    }

    public HashMap<String, String> a() {
        return this.g;
    }

    public String b() {
        return this.f6487a;
    }

    public void a(String str) {
        this.f6487a = str;
    }

    public String c() {
        return this.f6488b;
    }

    public void b(String str) {
        this.f6488b = str;
    }

    public String d() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public JSONArray e() {
        return this.d;
    }

    public void a(JSONArray jSONArray) {
        this.d = jSONArray;
    }

    public String f() {
        return this.e;
    }

    public void d(String str) {
        this.e = str;
    }

    public String g() {
        return this.f;
    }

    public void e(String str) {
        this.f = str;
    }
}
