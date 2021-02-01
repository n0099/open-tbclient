package com.bytedance.sdk.openadsdk.component.reward;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.af;
/* loaded from: classes6.dex */
class h {

    /* renamed from: a  reason: collision with root package name */
    private String f6338a;

    /* renamed from: b  reason: collision with root package name */
    private Context f6339b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Context context, String str) {
        this.f6339b = context;
        this.f6338a = TextUtils.isEmpty(str) ? "" : str;
    }

    @Nullable
    private Context b() {
        return this.f6339b == null ? p.a() : this.f6339b;
    }

    @Nullable
    private SharedPreferences f(String str) {
        try {
            if (b() != null) {
                return b().getSharedPreferences(str, 0);
            }
        } catch (Throwable th) {
        }
        return null;
    }

    private String g(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "0";
        }
        return this.f6338a + "_cache_" + str;
    }

    private String c() {
        return this.f6338a + "_adslot";
    }

    private String d() {
        return this.f6338a + "_adslot_preload";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str) {
        String str2 = null;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                str2 = com.bytedance.sdk.openadsdk.multipro.d.a.b(g(str), "material_data", (String) null);
            } else {
                str2 = f(g(str)).getString("material_data", null);
            }
        } catch (Throwable th) {
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b(String str) {
        long j = 0;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                j = com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "create_time", 0L);
            } else {
                j = f(g(str)).getLong("create_time", 0L);
            }
        } catch (Throwable th) {
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(String str) {
        boolean z = true;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                z = com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "has_played", true);
            } else {
                z = f(g(str)).getBoolean("has_played", true);
            }
        } catch (Throwable th) {
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "has_played", (Boolean) false);
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "create_time", Long.valueOf(System.currentTimeMillis()));
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str), "material_data", str2);
            } else {
                f(g(str)).edit().putBoolean("has_played", false).putLong("create_time", System.currentTimeMillis()).putString("material_data", str2).apply();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a(g(str));
            } else {
                f(g(str)).edit().clear().apply();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public AdSlot e(String str) {
        String string;
        AdSlot adSlot = null;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                string = com.bytedance.sdk.openadsdk.multipro.d.a.b(c(), str, (String) null);
            } else {
                string = f(c()).getString(str, null);
            }
            adSlot = af.a(string);
            return adSlot;
        } catch (Throwable th) {
            return adSlot;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String a2 = af.a(adSlot);
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(c(), adSlot.getCodeId(), a2);
                    } else {
                        f(c()).edit().putString(adSlot.getCodeId(), a2).apply();
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(AdSlot adSlot) {
        if (adSlot != null) {
            try {
                if (!TextUtils.isEmpty(adSlot.getCodeId())) {
                    String a2 = af.a(adSlot);
                    if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                        com.bytedance.sdk.openadsdk.multipro.d.a.a(d(), "preload_data", a2);
                    } else {
                        f(d()).edit().putString("preload_data", a2).apply();
                    }
                }
            } catch (Throwable th) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public AdSlot a() {
        String string;
        AdSlot adSlot = null;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                string = com.bytedance.sdk.openadsdk.multipro.d.a.b(d(), "preload_data", (String) null);
                com.bytedance.sdk.openadsdk.multipro.d.a.a(d());
            } else {
                SharedPreferences f = f(d());
                string = f.getString("preload_data", null);
                f.edit().clear().apply();
            }
            adSlot = af.a(string);
            return adSlot;
        } catch (Throwable th) {
            return adSlot;
        }
    }
}
