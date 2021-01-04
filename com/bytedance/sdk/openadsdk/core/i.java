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
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes4.dex */
public class i {
    private static final i t = new i();
    private static TTCustomController w = new TTCustomController() { // from class: com.bytedance.sdk.openadsdk.core.i.1
    };
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private String f6900a;
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private String f6901b;
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
    private boolean s;
    private com.bytedance.sdk.openadsdk.b.c u;
    private com.bytedance.sdk.openadsdk.core.g.c v;
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
        return this.s;
    }

    public boolean a(Activity activity) {
        return this.m.a(activity);
    }

    private i() {
        this.s = false;
        com.bytedance.sdk.openadsdk.j.g.a.a(p.a());
        this.j.add(4);
        Context a2 = p.a();
        if (a2 instanceof Application) {
            ((Application) a2).registerActivityLifecycleCallbacks(this.m);
        } else if (a2 != null && a2.getApplicationContext() != null) {
            ((Application) a2.getApplicationContext()).registerActivityLifecycleCallbacks(this.m);
        }
        if (Build.VERSION.SDK_INT >= 26) {
            try {
                this.s = ((ShortcutManager) p.a().getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
            } catch (Throwable th) {
            }
        }
    }

    public static i c() {
        return t;
    }

    public void a(TTCustomController tTCustomController) {
        this.q = tTCustomController;
    }

    @NonNull
    public TTCustomController d() {
        if (m.f6907b != null) {
            return m.f6907b;
        }
        return this.q == null ? w : this.q;
    }

    @NonNull
    public String e() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "app_id", (String) null) : this.f6900a;
    }

    public void a(@NonNull String str) {
        e(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "app_id", str);
        }
        this.f6900a = str;
        v();
    }

    private void v() {
        HashMap hashMap = new HashMap();
        String e = c().e();
        if (TextUtils.isEmpty(e)) {
            e = String.valueOf(164362);
        }
        hashMap.put("host_appid", e);
        hashMap.put(SapiContext.KEY_SDK_VERSION, "3.2.5.1");
        com.bytedance.embedapplog.b.H(hashMap);
    }

    @NonNull
    public String f() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "name", (String) null) : this.f6901b;
    }

    public void b(@NonNull String str) {
        f(str);
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "name", str);
        }
        this.f6901b = str;
    }

    public boolean g() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", false) : this.c;
    }

    public void a(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_paid", Boolean.valueOf(z));
        }
        this.c = z;
    }

    @Nullable
    public String h() {
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
    public String i() {
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

    public int j() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "title_bar_theme", 0) : this.f;
    }

    public void b(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "allow_show_notify", Boolean.valueOf(z));
        }
        this.g = z;
    }

    public boolean k() {
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

    public TTDownloadEventLogger l() {
        return this.n;
    }

    public void a(TTDownloadEventLogger tTDownloadEventLogger) {
        this.n = tTDownloadEventLogger;
    }

    public TTSecAbs m() {
        return this.o;
    }

    public void a(TTSecAbs tTSecAbs) {
        this.o = tTSecAbs;
    }

    public boolean b(int i) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "network_state", (String) null);
            if (TextUtils.isEmpty(b2)) {
                return false;
            }
            String[] split = b2.split(",");
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

    public void n() {
        e(this.f6900a);
        f(this.f6901b);
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

    public com.bytedance.sdk.openadsdk.b.c o() {
        if (this.u == null) {
            this.u = new com.bytedance.sdk.openadsdk.b.c(10, 8);
        }
        return this.u;
    }

    public com.bytedance.sdk.openadsdk.b.c p() {
        if (this.u == null) {
            this.u = new com.bytedance.sdk.openadsdk.b.c(10, 8, true);
        }
        return this.u;
    }

    public com.bytedance.sdk.openadsdk.core.g.c q() {
        if (this.v == null) {
            this.v = new com.bytedance.sdk.openadsdk.core.g.c(10, 8);
        }
        return this.v;
    }

    public boolean r() {
        return com.bytedance.sdk.openadsdk.multipro.b.b() ? com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", false) : this.k;
    }

    public void d(boolean z) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_global_info", "is_use_texture", Boolean.valueOf(z));
        }
        this.k = z;
    }

    public Bitmap s() {
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

    public String t() {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            String b2 = com.bytedance.sdk.openadsdk.multipro.d.a.b("sp_global_info", "tob_ab_sdk_version", (String) null);
            if (TextUtils.isEmpty(b2)) {
                return "";
            }
            return b2;
        } else if (TextUtils.isEmpty(this.r)) {
            return "";
        } else {
            return this.r;
        }
    }

    public boolean u() {
        return "5001121".equals(this.f6900a);
    }
}
