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
import com.baidu.sapi2.SapiContext;
import com.bytedance.sdk.openadsdk.TTCustomController;
import com.bytedance.sdk.openadsdk.TTDownloadEventLogger;
import com.bytedance.sdk.openadsdk.TTGlobalAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTSecAbs;
import com.bytedance.sdk.openadsdk.utils.aj;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class i {
    private static volatile i u = null;
    private static TTCustomController x = new TTCustomController() { // from class: com.bytedance.sdk.openadsdk.core.i.1
    };
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private String f4461a;
    @NonNull
    private String b;
    private boolean c;
    @Nullable
    private String d;
    @Nullable
    private String e;
    private TTGlobalAppDownloadListener i;
    private TTDownloadEventLogger n;
    private TTSecAbs o;
    private String[] p;
    private TTCustomController q;
    private String r;
    private String s;
    private boolean t;
    private com.bytedance.sdk.openadsdk.b.c v;
    private com.bytedance.sdk.openadsdk.core.g.c w;
    private int f = 0;
    private boolean g = true;
    private boolean h = false;
    private final Set<Integer> j = Collections.synchronizedSet(new HashSet());
    private boolean k = false;
    private Bitmap l = null;
    private com.bytedance.sdk.openadsdk.utils.a m = new com.bytedance.sdk.openadsdk.utils.a();

    public boolean a() {
        return this.m.a();
    }

    public boolean b() {
        return this.t;
    }

    public boolean a(Activity activity) {
        return this.m.a(activity);
    }

    public com.bytedance.sdk.openadsdk.utils.a c() {
        return this.m;
    }

    private i() {
        this.t = false;
        com.bytedance.sdk.openadsdk.i.g.a.a(p.a());
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
            } catch (Throwable th) {
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

    public void a(TTCustomController tTCustomController) {
        this.q = tTCustomController;
    }

    @NonNull
    public TTCustomController e() {
        if (m.b != null) {
            return m.b;
        }
        return this.q == null ? x : this.q;
    }

    @NonNull
    public String f() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "app_id", (String) null) : this.f4461a;
    }

    public void a(@NonNull String str) {
        e(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "app_id", str);
        }
        this.f4461a = str;
        y();
    }

    private void y() {
        HashMap hashMap = new HashMap();
        String f = d().f();
        if (TextUtils.isEmpty(f)) {
            f = String.valueOf(164362);
        }
        hashMap.put("host_appid", f);
        hashMap.put(SapiContext.KEY_SDK_VERSION, "3.4.0.1");
        com.bytedance.embedapplog.b.K(hashMap);
    }

    @NonNull
    public String g() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "name", (String) null) : this.b;
    }

    public void b(@NonNull String str) {
        f(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "name", str);
        }
        this.b = str;
    }

    public boolean h() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", false) : this.c;
    }

    public void a(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", Boolean.valueOf(z));
        }
        this.c = z;
    }

    @Nullable
    public String i() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "keywords", (String) null) : this.d;
    }

    public void c(@Nullable String str) {
        g(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "keywords", str);
        }
        this.d = str;
    }

    @Nullable
    public String j() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "extra_data", (String) null) : this.e;
    }

    public void d(@Nullable String str) {
        h(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "extra_data", str);
        }
        this.e = str;
    }

    public void a(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", Integer.valueOf(i));
        }
        this.f = i;
    }

    public int k() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", 0) : this.f;
    }

    public void b(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_show_notify", Boolean.valueOf(z));
        }
        this.g = z;
    }

    public boolean l() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_show_notify", true) : this.g;
    }

    public void c(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_lp_when_screen_lock", Boolean.valueOf(z));
        }
        this.h = z;
    }

    public void a(TTGlobalAppDownloadListener tTGlobalAppDownloadListener) {
        this.i = tTGlobalAppDownloadListener;
    }

    public TTDownloadEventLogger m() {
        return this.n;
    }

    public void a(TTDownloadEventLogger tTDownloadEventLogger) {
        this.n = tTDownloadEventLogger;
    }

    public TTSecAbs n() {
        return this.o;
    }

    public void a(TTSecAbs tTSecAbs) {
        this.o = tTSecAbs;
    }

    public boolean b(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String b = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "network_state", (String) null);
            if (TextUtils.isEmpty(b)) {
                return false;
            }
            String[] split = b.split(",");
            if (split.length > 0) {
                for (String str : split) {
                    if (!TextUtils.isEmpty(str) && String.valueOf(i).equals(str)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return this.j.contains(Integer.valueOf(i));
    }

    public void a(int... iArr) {
        if (iArr != null) {
            try {
                this.j.clear();
                for (int i : iArr) {
                    this.j.add(Integer.valueOf(i));
                }
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    if (!this.j.isEmpty()) {
                        StringBuilder sb = new StringBuilder();
                        for (Integer num : this.j) {
                            sb.append(num).append(",");
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
    }

    public void o() {
        e(this.f4461a);
        f(this.b);
    }

    private static void e(String str) {
        com.bytedance.sdk.openadsdk.utils.z.a(str, "appid不能为空");
    }

    private static void f(String str) {
        com.bytedance.sdk.openadsdk.utils.z.a(str, "name不能为空");
    }

    private static void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.utils.z.a(str.length() <= 1000, "keyword超长, 最长为1000");
        }
    }

    private static void h(String str) {
        if (!TextUtils.isEmpty(str)) {
            com.bytedance.sdk.openadsdk.utils.z.a(str.length() <= 1000, "data超长, 最长为1000");
        }
    }

    public com.bytedance.sdk.openadsdk.b.c p() {
        if (this.v == null) {
            this.v = new com.bytedance.sdk.openadsdk.b.c(10, 8);
        }
        return this.v;
    }

    public com.bytedance.sdk.openadsdk.b.c q() {
        if (this.v == null) {
            this.v = new com.bytedance.sdk.openadsdk.b.c(10, 8, true);
        }
        return this.v;
    }

    public com.bytedance.sdk.openadsdk.core.g.c r() {
        if (this.w == null) {
            this.w = new com.bytedance.sdk.openadsdk.core.g.c(10, 8);
        }
        return this.w;
    }

    public boolean s() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", false) : this.k;
    }

    public void d(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", Boolean.valueOf(z));
        }
        this.k = z;
    }

    public Bitmap t() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.utils.f.a(com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "pause_icon", (String) null)) : this.l;
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
        int i;
        if (com.bytedance.sdk.openadsdk.multipro.b.b() && strArr != null && strArr.length > 0) {
            StringBuilder sb = new StringBuilder();
            int length = strArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                String str = strArr[i2];
                if (TextUtils.isEmpty(str)) {
                    i = i3;
                } else {
                    i = i3 + 1;
                    if (i3 > 0) {
                        sb.append(",");
                    }
                    sb.append(str);
                }
                i2++;
                i3 = i;
            }
            String sb2 = sb.toString();
            if (!TextUtils.isEmpty(sb2)) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "need_clear_task_reset", sb2);
            }
        }
        this.p = strArr;
    }

    public String u() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String b = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "tob_ab_sdk_version", (String) null);
            if (TextUtils.isEmpty(b)) {
                return "";
            }
            return b;
        } else if (TextUtils.isEmpty(this.r)) {
            return "";
        } else {
            return this.r;
        }
    }

    public boolean v() {
        return "5001121".equals(this.f4461a);
    }

    public boolean w() {
        return "com.union_test.toutiao".equals(aj.e());
    }

    public String x() {
        if (!TextUtils.isEmpty(this.s)) {
            return this.s;
        }
        this.s = com.bytedance.sdk.openadsdk.utils.k.a();
        if (!TextUtils.isEmpty(this.s)) {
            return this.s;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        com.bytedance.sdk.openadsdk.utils.k.a(valueOf);
        this.s = valueOf;
        return this.s;
    }
}
