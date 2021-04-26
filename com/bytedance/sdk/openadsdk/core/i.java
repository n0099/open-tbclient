package com.bytedance.sdk.openadsdk.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.AppLogHelper;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import com.bytedance.sdk.openadsdk.utils.af;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class i {
    public static volatile i u;
    public static TTCustomController x = new TTCustomController() { // from class: com.bytedance.sdk.openadsdk.core.i.1
    };
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    public String f28989a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    public String f28990b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28991c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public String f28992d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public String f28993e;

    /* renamed from: i  reason: collision with root package name */
    public TTGlobalAppDownloadListener f28997i;
    public TTDownloadEventLogger n;
    public TTSecAbs o;
    public String[] p;
    public TTCustomController q;
    public String r;
    public String s;
    public boolean t;
    public com.bytedance.sdk.openadsdk.b.c v;
    public com.bytedance.sdk.openadsdk.core.g.c w;

    /* renamed from: f  reason: collision with root package name */
    public int f28994f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28995g = true;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28996h = false;
    public final Set<Integer> j = Collections.synchronizedSet(new HashSet());
    public boolean k = false;
    public Bitmap l = null;
    public com.bytedance.sdk.openadsdk.utils.a m = new com.bytedance.sdk.openadsdk.utils.a();

    public i() {
        this.t = false;
        com.bytedance.sdk.openadsdk.k.g.a.a(p.a());
        this.j.add(4);
        Context a2 = p.a();
        if (a2 instanceof Application) {
            ((Application) a2).registerActivityLifecycleCallbacks(this.m);
        } else if (a2 != null && a2.getApplicationContext() != null) {
            ((Application) a2.getApplicationContext()).registerActivityLifecycleCallbacks(this.m);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                this.t = ((ShortcutManager) p.a().getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
            } catch (Throwable unused) {
            }
        }
    }

    public static i d() {
        if (u == null) {
            synchronized (i.class) {
                if (u == null) {
                    u = new i();
                }
            }
        }
        return u;
    }

    public boolean a() {
        return this.m.a();
    }

    public boolean b() {
        return this.t;
    }

    public com.bytedance.sdk.openadsdk.utils.a c() {
        return this.m;
    }

    @NonNull
    public TTCustomController e() {
        if (m.f29015b != null) {
            return m.f29015b;
        }
        TTCustomController tTCustomController = this.q;
        return tTCustomController == null ? x : tTCustomController;
    }

    public boolean f() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "sdk_activate_init", true);
        }
        return af.a((String) null, p.a()).b("sdk_activate_init", true);
    }

    @NonNull
    public String g() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", Constants.APP_ID, (String) null);
        }
        return this.f28989a;
    }

    public void h() {
        HashMap<String, Object> hashMap = new HashMap<>();
        String g2 = d().g();
        if (TextUtils.isEmpty(g2)) {
            g2 = String.valueOf(164362);
        }
        hashMap.put("host_appid", g2);
        hashMap.put("sdk_version", "3.4.5.5");
        AppLogHelper.getInstance().setHeaderInfo(hashMap);
    }

    @NonNull
    public String i() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "name", (String) null);
        }
        return this.f28990b;
    }

    public boolean j() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", false);
        }
        return this.f28991c;
    }

    @Nullable
    public String k() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "keywords", (String) null);
        }
        return this.f28992d;
    }

    @Nullable
    public String l() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "extra_data", (String) null);
        }
        return this.f28993e;
    }

    public int m() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", 0);
        }
        return this.f28994f;
    }

    public boolean n() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_show_notify", true);
        }
        return this.f28995g;
    }

    public TTDownloadEventLogger o() {
        return this.n;
    }

    public TTSecAbs p() {
        return this.o;
    }

    public com.bytedance.sdk.openadsdk.b.c q() {
        if (this.v == null) {
            this.v = new com.bytedance.sdk.openadsdk.b.c(10, 8);
        }
        return this.v;
    }

    public com.bytedance.sdk.openadsdk.b.c r() {
        if (this.v == null) {
            this.v = new com.bytedance.sdk.openadsdk.b.c(10, 8, true);
        }
        return this.v;
    }

    public com.bytedance.sdk.openadsdk.core.g.c s() {
        if (this.w == null) {
            this.w = new com.bytedance.sdk.openadsdk.core.g.c(10, 8);
        }
        return this.w;
    }

    public boolean t() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", false);
        }
        return this.k;
    }

    public Bitmap u() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.utils.f.a(com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "pause_icon", (String) null));
        }
        return this.l;
    }

    public String v() {
        if (!com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return TextUtils.isEmpty(this.r) ? "" : this.r;
        }
        String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "tob_ab_sdk_version", (String) null);
        return TextUtils.isEmpty(b2) ? "" : b2;
    }

    public boolean w() {
        return "5001121".equals(this.f28989a);
    }

    public boolean x() {
        return "com.union_test.toutiao".equals(ak.e());
    }

    public String y() {
        if (!TextUtils.isEmpty(this.s)) {
            return this.s;
        }
        String a2 = com.bytedance.sdk.openadsdk.utils.k.a();
        this.s = a2;
        if (!TextUtils.isEmpty(a2)) {
            return this.s;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.utils.k.a(valueOf);
        this.s = valueOf;
        return valueOf;
    }

    public boolean a(Activity activity) {
        return this.m.a(activity);
    }

    public void b(@NonNull String str) {
        f(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "name", str);
        }
        this.f28990b = str;
    }

    public void c(@Nullable String str) {
        g(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "keywords", str);
        }
        this.f28992d = str;
    }

    public void a(TTCustomController tTCustomController) {
        this.q = tTCustomController;
    }

    public static void e(String str) {
        com.bytedance.sdk.openadsdk.utils.z.a(str, "appid不能为空");
    }

    public static void f(String str) {
        com.bytedance.sdk.openadsdk.utils.z.a(str, "name不能为空");
    }

    public static void g(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.z.a(str.length() <= 1000, "keyword超长, 最长为1000");
    }

    public static JSONObject i(String str) {
        String b2;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", str, (String) null);
        } else {
            b2 = af.a((String) null, p.a()).b(str, (String) null);
        }
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        try {
            return new JSONObject(b2);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void a(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "sdk_activate_init", Boolean.valueOf(z));
        }
        af.a((String) null, p.a()).a("sdk_activate_init", z);
    }

    public void e(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", Boolean.valueOf(z));
        }
        this.k = z;
    }

    public void b(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", Boolean.valueOf(z));
        }
        this.f28991c = z;
    }

    public void c(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_show_notify", Boolean.valueOf(z));
        }
        this.f28995g = z;
    }

    public void a(@NonNull String str) {
        e(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", Constants.APP_ID, str);
        }
        this.f28989a = str;
    }

    public void d(@Nullable String str) {
        h(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "extra_data", str);
        }
        this.f28993e = str;
    }

    public static void h(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.z.a(str.length() <= 1000, "data超长, 最长为1000");
    }

    public boolean b(int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "network_state", (String) null);
            if (TextUtils.isEmpty(b2)) {
                return false;
            }
            String[] split = b2.split(",");
            if (split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && String.valueOf(i2).equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return this.j.contains(Integer.valueOf(i2));
    }

    public void a(int i2) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", Integer.valueOf(i2));
        }
        this.f28994f = i2;
    }

    public void d(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_lp_when_screen_lock", Boolean.valueOf(z));
        }
        this.f28996h = z;
    }

    public void a(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
        this.f28997i = tTGlobalAppDownloadListener;
    }

    public void a(TTDownloadEventLogger tTDownloadEventLogger) {
        this.n = tTDownloadEventLogger;
    }

    public void a(TTSecAbs tTSecAbs) {
        this.o = tTSecAbs;
    }

    public void a(int... iArr) {
        if (iArr == null) {
            return;
        }
        try {
            this.j.clear();
            for (int i2 : iArr) {
                this.j.add(Integer.valueOf(i2));
            }
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (!this.j.isEmpty()) {
                    StringBuilder sb = new StringBuilder();
                    for (Integer num : this.j) {
                        sb.append(num);
                        sb.append(",");
                    }
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "network_state", sb.toString());
                    return;
                }
                com.bytedance.sdk.openadsdk.multipro.d.a.c("sp_global_info", "network_state");
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(Bitmap bitmap) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String a2 = com.bytedance.sdk.openadsdk.utils.f.a(bitmap);
            if (!TextUtils.isEmpty(a2)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "pause_icon", a2);
            }
        }
        this.l = bitmap;
    }

    public void a(String[] strArr) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b() && strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    int i3 = i2 + 1;
                    if (i2 > 0) {
                        sb.append(",");
                    }
                    sb.append(str);
                    i2 = i3;
                }
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "need_clear_task_reset", sb2);
            }
        }
        this.p = strArr;
    }

    public static void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("value", str2);
            jSONObject.put("time", System.currentTimeMillis());
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", str, jSONObject.toString());
            } else {
                af.a((String) null, p.a()).a(str, jSONObject.toString());
            }
            com.bytedance.sdk.openadsdk.utils.u.b("GlobalInfo", "update cache", str, " value = ", str2);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public static String a(String str, long j) {
        JSONObject i2;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            i2 = i(str);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (i2 == null) {
            com.bytedance.sdk.openadsdk.utils.u.b("GlobalInfo", "without cache key=", str);
            return null;
        }
        if (System.currentTimeMillis() - i2.getLong("time") <= j) {
            String string = i2.getString("value");
            com.bytedance.sdk.openadsdk.utils.u.b("GlobalInfo", "use cache key=", str, " value = ", string);
            return string;
        }
        com.bytedance.sdk.openadsdk.utils.u.b("GlobalInfo", "without cache key=", str);
        return null;
    }
}
