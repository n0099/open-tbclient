package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.ag;
/* loaded from: classes5.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public String f27505a;

    /* renamed from: b  reason: collision with root package name */
    public Context f27506b;

    public i(Context context, String str) {
        this.f27506b = context;
        this.f27505a = TextUtils.isEmpty(str) ? "" : str;
    }

    @Nullable
    private Context b() {
        Context context = this.f27506b;
        return context == null ? p.a() : context;
    }

    private String c() {
        return this.f27505a + "_adslot";
    }

    private String d() {
        return this.f27505a + "_adslot_preload";
    }

    @Nullable
    private SharedPreferences f(String str) {
        try {
            if (b() != null) {
                return b().getSharedPreferences(str, 0);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    private String g(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return this.f27505a + "_cache_" + str;
    }

    public String a(String str) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.b(g(str), "material_data", (String) null);
            }
            return f(g(str)).getString("material_data", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    public AdSlot e(String str) {
        String string;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                string = com.bytedance.sdk.openadsdk.multipro.d.a.b(c(), str, (String) null);
            } else {
                string = f(c()).getString(str, null);
            }
            return ag.a(string);
        } catch (Throwable unused) {
            return null;
        }
    }

    public long b(String str) {
        long j = 0;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                j = com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "create_time", 0L);
            } else {
                j = f(g(str)).getLong("create_time", 0L);
            }
        } catch (Throwable unused) {
        }
        return j;
    }

    public boolean c(String str) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                return com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "has_played", true);
            }
            return f(g(str)).getBoolean("has_played", true);
        } catch (Throwable unused) {
            return true;
        }
    }

    public void d(String str) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str));
            } else {
                f(g(str)).edit().clear().apply();
            }
        } catch (Throwable unused) {
        }
    }

    public void a(String str, String str2) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "has_played", Boolean.FALSE);
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "create_time", Long.valueOf(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "material_data", str2);
                return;
            }
            f(g(str)).edit().putBoolean("has_played", false).putLong("create_time", System.currentTimeMillis()).putString("material_data", str2).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String a2 = ag.a(adSlot);
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(d(), "preload_data", a2);
                    } else {
                        f(d()).edit().putString("preload_data", a2).apply();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String a2 = ag.a(adSlot);
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(c(), adSlot.getCodeId(), a2);
                    } else {
                        f(c()).edit().putString(adSlot.getCodeId(), a2).apply();
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Nullable
    public AdSlot a() {
        String str;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                str = com.bytedance.sdk.openadsdk.multipro.d.a.b(d(), "preload_data", (String) null);
                com.bytedance.sdk.openadsdk.multipro.d.a.a(d());
            } else {
                SharedPreferences f2 = f(d());
                String string = f2.getString("preload_data", null);
                f2.edit().clear().apply();
                str = string;
            }
            return ag.a(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
