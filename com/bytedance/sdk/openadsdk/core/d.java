package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static volatile d f4384a = null;
    private final SharedPreferences b;

    private d(Context context) {
        this.b = context.getSharedPreferences("ttopenadsdk", 0);
    }

    public static d a(Context context) {
        if (f4384a == null) {
            synchronized (d.class) {
                if (f4384a == null) {
                    f4384a = new d(context);
                }
            }
        }
        return f4384a;
    }

    public void a(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, str2);
        } else {
            this.b.edit().putString(str, str2).apply();
        }
    }

    public String b(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("ttopenadsdk", str, str2);
        }
        return this.b.getString(str, str2);
    }

    public void a(String str, int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Integer.valueOf(i));
        } else {
            this.b.edit().putInt(str, i).apply();
        }
    }

    public int b(String str, int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, i);
        }
        return this.b.getInt(str, i);
    }

    public void a(String str, boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Boolean.valueOf(z));
        } else {
            this.b.edit().putBoolean(str, z).apply();
        }
    }

    public boolean b(String str, boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, z);
        }
        return this.b.getBoolean(str, z);
    }

    public void a(String str, long j) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Long.valueOf(j));
        } else {
            this.b.edit().putLong(str, j).apply();
        }
    }

    public Long b(String str, long j) {
        long j2;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            j2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, j);
        } else {
            j2 = this.b.getLong(str, j);
        }
        return Long.valueOf(j2);
    }

    public void a(String str, float f) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Float.valueOf(f));
        } else {
            this.b.edit().putFloat(str, f).apply();
        }
    }

    public float b(String str, float f) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, f);
        }
        return this.b.getFloat(str, f);
    }
}
