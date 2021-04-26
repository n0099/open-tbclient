package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f28634a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f28635b;

    public d(Context context) {
        this.f28635b = context.getSharedPreferences("ttopenadsdk", 0);
    }

    public static d a(Context context) {
        if (f28634a == null) {
            synchronized (d.class) {
                if (f28634a == null) {
                    f28634a = new d(context);
                }
            }
        }
        return f28634a;
    }

    public String b(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("ttopenadsdk", str, str2);
        }
        return this.f28635b.getString(str, str2);
    }

    public int b(String str, int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, i2);
        }
        return this.f28635b.getInt(str, i2);
    }

    public void a(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, str2);
        } else {
            this.f28635b.edit().putString(str, str2).apply();
        }
    }

    public boolean b(String str, boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, z);
        }
        return this.f28635b.getBoolean(str, z);
    }

    public void a(String str, int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Integer.valueOf(i2));
        } else {
            this.f28635b.edit().putInt(str, i2).apply();
        }
    }

    public Long b(String str, long j) {
        long j2;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            j2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, j);
        } else {
            j2 = this.f28635b.getLong(str, j);
        }
        return Long.valueOf(j2);
    }

    public void a(String str, boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Boolean.valueOf(z));
        } else {
            this.f28635b.edit().putBoolean(str, z).apply();
        }
    }

    public void a(String str, long j) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Long.valueOf(j));
        } else {
            this.f28635b.edit().putLong(str, j).apply();
        }
    }
}
