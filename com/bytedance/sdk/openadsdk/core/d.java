package com.bytedance.sdk.openadsdk.core;

import android.content.Context;
import android.content.SharedPreferences;
/* loaded from: classes6.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static volatile d f27993a;

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f27994b;

    public d(Context context) {
        this.f27994b = context.getSharedPreferences("ttopenadsdk", 0);
    }

    public static d a(Context context) {
        if (f27993a == null) {
            synchronized (d.class) {
                if (f27993a == null) {
                    f27993a = new d(context);
                }
            }
        }
        return f27993a;
    }

    public String b(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("ttopenadsdk", str, str2);
        }
        return this.f27994b.getString(str, str2);
    }

    public int b(String str, int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, i2);
        }
        return this.f27994b.getInt(str, i2);
    }

    public void a(String str, String str2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, str2);
        } else {
            this.f27994b.edit().putString(str, str2).apply();
        }
    }

    public boolean b(String str, boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, z);
        }
        return this.f27994b.getBoolean(str, z);
    }

    public void a(String str, int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Integer.valueOf(i2));
        } else {
            this.f27994b.edit().putInt(str, i2).apply();
        }
    }

    public Long b(String str, long j) {
        long j2;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            j2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, j);
        } else {
            j2 = this.f27994b.getLong(str, j);
        }
        return Long.valueOf(j2);
    }

    public void a(String str, boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Boolean.valueOf(z));
        } else {
            this.f27994b.edit().putBoolean(str, z).apply();
        }
    }

    public void a(String str, long j) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("ttopenadsdk", str, Long.valueOf(j));
        } else {
            this.f27994b.edit().putLong(str, j).apply();
        }
    }
}
