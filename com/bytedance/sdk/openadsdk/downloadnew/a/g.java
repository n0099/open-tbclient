package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.h.h;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.a;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.m;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.u;
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.a.a.d.a;
import d.o.a.d.f.c;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f29193a;

    /* renamed from: c  reason: collision with root package name */
    public static Context f29195c;

    /* renamed from: d  reason: collision with root package name */
    public static Map<Integer, a.InterfaceC0308a> f29196d;

    /* renamed from: b  reason: collision with root package name */
    public static final AtomicBoolean f29194b = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public static boolean f29197e = true;

    /* renamed from: f  reason: collision with root package name */
    public static d.o.a.a.a.c.a.a f29198f = new d.o.a.a.a.c.a.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.1
        @Override // d.o.a.a.a.c.a.a
        public void a(@NonNull d.o.a.a.a.c.d dVar, @Nullable d.o.a.a.a.c.b bVar, @Nullable d.o.a.a.a.c.c cVar) {
            u.b("LibHolder", "completeListener: onDownloadStart");
        }

        @Override // d.o.a.a.a.c.a.a
        public void b(@Nullable DownloadInfo downloadInfo, String str) {
            u.b("LibHolder", "completeListener: onInstalled");
            g.b(str);
        }

        @Override // d.o.a.a.a.c.a.a
        public void a(@NonNull DownloadInfo downloadInfo, String str) {
            u.b("LibHolder", "completeListener: onDownloadFinished");
        }

        @Override // d.o.a.a.a.c.a.a
        public void a(@NonNull DownloadInfo downloadInfo, BaseException baseException, String str) {
            u.b("LibHolder", "completeListener: onDownloadFailed");
        }

        @Override // d.o.a.a.a.c.a.a
        public void a(@NonNull DownloadInfo downloadInfo) {
            u.b("LibHolder", "completeListener: onCanceled");
        }
    };

    static {
        try {
            f29193a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable unused) {
        }
    }

    public static void b(String str) {
        d.o.a.b.a.c.b d2;
        JSONObject g2;
        JSONObject optJSONObject;
        com.bytedance.sdk.openadsdk.downloadnew.a.b.a a2;
        l lVar;
        if (!al.a()) {
            u.b("LibHolder", "锁屏不执行自启动调起");
        } else if (TextUtils.isEmpty(str) || (d2 = c.g.e().d(str)) == null || (g2 = d2.g()) == null || (optJSONObject = g2.optJSONObject("open_ad_sdk_download_extra")) == null || (a2 = com.bytedance.sdk.openadsdk.downloadnew.a.b.a.a(optJSONObject)) == null || (lVar = a2.f29155a) == null) {
        } else {
            a(str, lVar);
        }
    }

    public static void c(l lVar, String str) {
        if (lVar != null && ak.a(g(), str)) {
            u.b("LibHolder", "通过包名调起 " + str);
        }
    }

    public static d.o.a.d.l d() {
        if (!f29194b.get()) {
            b(p.a());
        }
        return d.o.a.d.l.b(g());
    }

    public static void e() {
        d().p();
        if (TextUtils.isEmpty(f29193a)) {
            return;
        }
        com.bytedance.sdk.openadsdk.utils.l.c(new File(f29193a));
    }

    public static Context g() {
        Context context = f29195c;
        return context == null ? p.a() : context;
    }

    @Nullable
    public static Map<Integer, a.InterfaceC0308a> h() {
        return f29196d;
    }

    @NonNull
    public static JSONObject i() {
        h h2 = p.h();
        if (h2 != null && h2.o() != null) {
            return h2.o();
        }
        return new JSONObject();
    }

    public static void c() {
        boolean w;
        h h2 = p.h();
        if (h2 == null || f29197e == (w = h2.w())) {
            return;
        }
        f29197e = w;
        a();
    }

    public static void a(String str, l lVar) {
        try {
            if (g() != null && !TextUtils.isEmpty(str) && lVar != null && lVar.q()) {
                com.bytedance.sdk.openadsdk.core.d.g ao = lVar.ao();
                if (ao != null && !TextUtils.isEmpty(ao.a())) {
                    u.f("LibHolder", "含有deepLink");
                    if (lVar.G() != 0) {
                        u.f("LibHolder", "deepLink过滤 mMeta.getDownConfigAutoOpen() " + lVar.G());
                        return;
                    }
                }
                if (lVar.q()) {
                    if (q.a(str)) {
                        u.f("LibHolder", "该app已被激活 pkgName " + str);
                    } else if (!lVar.s()) {
                        b(lVar, str);
                    } else {
                        a(g(), lVar, str);
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static void b(final l lVar, final String str) {
        final com.bytedance.sdk.openadsdk.utils.a c2;
        if (a(lVar) || (c2 = i.d().c()) == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        c2.a(new a.InterfaceC0326a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.2
            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0326a
            public void a() {
                if (!al.a()) {
                    u.b("LibHolder", "锁屏不执行自启动调起");
                    com.bytedance.sdk.openadsdk.utils.a aVar = com.bytedance.sdk.openadsdk.utils.a.this;
                    if (aVar != null) {
                        aVar.b();
                        return;
                    }
                    return;
                }
                if (!q.a(str)) {
                    g.b(lVar, currentTimeMillis, com.bytedance.sdk.openadsdk.utils.a.this, str);
                }
                com.bytedance.sdk.openadsdk.utils.a aVar2 = com.bytedance.sdk.openadsdk.utils.a.this;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0326a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0326a
            public void c() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0326a
            public void d() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0326a
            public void e() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0326a
            public void f() {
            }
        });
    }

    public static void b(l lVar, long j, com.bytedance.sdk.openadsdk.utils.a aVar, String str) {
        if (lVar == null) {
            return;
        }
        if (System.currentTimeMillis() - j >= lVar.u() * 1000) {
            String c2 = lVar.an() != null ? lVar.an().c() : "";
            b(aVar, lVar, c2, TextUtils.isEmpty(c2) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？", str);
            return;
        }
        c(lVar, str);
    }

    public static boolean a(l lVar) {
        if (lVar != null && a(i())) {
            int Z = lVar.Z();
            if ((TextUtils.isEmpty(lVar.aA()) || Z != 4) && !k.f()) {
                return false;
            }
            k.a(false);
            return true;
        }
        return false;
    }

    public static void b(final com.bytedance.sdk.openadsdk.utils.a aVar, final l lVar, String str, String str2, final String str3) {
        if (aVar == null) {
            return;
        }
        if (!ak.c(g(), str3)) {
            u.b("LibHolder", "该app未安装 packageName " + str3);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        String am = lVar.am();
        com.bytedance.sdk.openadsdk.utils.g.a(g(), am, str, str2, "立即打开", "退出", new g.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.4
            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void a() {
                g.c(l.this, str3);
                com.bytedance.sdk.openadsdk.utils.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void b() {
                com.bytedance.sdk.openadsdk.utils.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.g.a
            public void c() {
                com.bytedance.sdk.openadsdk.utils.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
            }
        });
    }

    public static void a(Context context, final l lVar, final String str) {
        if (context == null || lVar == null || a(lVar)) {
            return;
        }
        final String c2 = lVar.an() != null ? lVar.an().c() : "";
        final String str2 = TextUtils.isEmpty(c2) ? "应用安装完成，是否立即打开 ？" : "安装完成，是否立即打开 ？";
        final com.bytedance.sdk.openadsdk.utils.a c3 = i.d().c();
        if (c3 == null) {
            return;
        }
        c3.a(new a.InterfaceC0326a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.3
            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0326a
            public void a() {
                try {
                    if (!al.a()) {
                        u.b("LibHolder", "锁屏不执行自启动调起");
                        if (com.bytedance.sdk.openadsdk.utils.a.this != null) {
                            com.bytedance.sdk.openadsdk.utils.a.this.b();
                            return;
                        }
                        return;
                    }
                    if (!q.a(str)) {
                        g.b(com.bytedance.sdk.openadsdk.utils.a.this, lVar, c2, str2, str);
                    }
                    if (com.bytedance.sdk.openadsdk.utils.a.this != null) {
                        com.bytedance.sdk.openadsdk.utils.a.this.b();
                    }
                } catch (Throwable unused) {
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0326a
            public void b() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0326a
            public void c() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0326a
            public void d() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0326a
            public void e() {
            }

            @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC0326a
            public void f() {
            }
        });
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT >= 23) {
            return com.bytedance.sdk.openadsdk.core.f.d.a().a(g(), StorageUtils.EXTERNAL_STORAGE_PERMISSION);
        }
        return true;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        d.o.a.a.a.b a2 = d.o.a.d.l.b(applicationContext).a();
        if (a2 == null) {
            return false;
        }
        a.C1922a c1922a = new a.C1922a();
        c1922a.d("143");
        c1922a.a("open_news");
        c1922a.f("3.4.5.5");
        c1922a.h(String.valueOf(3455));
        d.o.a.a.a.d.a b2 = c1922a.b();
        a2.g(new com.bytedance.sdk.openadsdk.downloadnew.a.a.d(applicationContext));
        a2.e(new com.bytedance.sdk.openadsdk.downloadnew.a.a.b(applicationContext));
        a2.a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.e(applicationContext));
        a2.f(new com.bytedance.sdk.openadsdk.downloadnew.a.a.c(applicationContext));
        a2.h(new d.o.a.a.a.a.i() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.5
            @Override // d.o.a.a.a.a.i
            public JSONObject a() {
                return g.i();
            }
        });
        a2.c(new com.bytedance.sdk.openadsdk.downloadnew.a.a.a(applicationContext));
        a2.b(b2);
        a2.a(packageName + ".TTFileProvider");
        a2.d(a(applicationContext, i()));
        d.o.a.d.n.a.c();
        d.o.a.d.l.b(applicationContext).m().a(1);
        d.o.a.d.l.b(applicationContext).e(f29198f);
        d.o.a.e.a.e.F().o(new d.o.a.e.b.f.h() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.6
            @Override // d.o.a.e.b.f.h
            public boolean a(Intent intent) {
                return false;
            }
        });
        return true;
    }

    public static void a(Context context) {
        if (context == null) {
            context = p.a();
        }
        if (context == null) {
            return;
        }
        f29195c = context.getApplicationContext();
        a();
        if (f29194b.get()) {
            return;
        }
        synchronized (g.class) {
            if (!f29194b.get()) {
                f29194b.set(b(f29195c));
            }
        }
    }

    public static void a() {
        File externalFilesDir;
        String str = null;
        try {
            if (f29197e && !b()) {
                File file = new File(g().getCacheDir(), Environment.DIRECTORY_DOWNLOADS);
                file.mkdirs();
                str = file.getPath();
            }
            if (TextUtils.isEmpty(str)) {
                if ("mounted".equals(Environment.getExternalStorageState()) && (externalFilesDir = g().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS)) != null) {
                    str = externalFilesDir.getPath();
                }
                if (TextUtils.isEmpty(str)) {
                    File file2 = new File(g().getFilesDir(), Environment.DIRECTORY_DOWNLOADS);
                    file2.mkdirs();
                    str = file2.getPath();
                }
            }
            if (!TextUtils.isEmpty(str)) {
                f29193a = str;
                m.a();
            }
            u.b("LibHolder", "path: " + String.valueOf(f29193a));
        } catch (Throwable unused) {
        }
    }

    public static void a(int i2) {
        Map<Integer, a.InterfaceC0308a> map = f29196d;
        if (map != null) {
            map.remove(Integer.valueOf(i2));
        }
    }

    public static void a(int i2, a.InterfaceC0308a interfaceC0308a) {
        if (interfaceC0308a != null) {
            if (f29196d == null) {
                f29196d = Collections.synchronizedMap(new WeakHashMap());
            }
            f29196d.put(Integer.valueOf(i2), interfaceC0308a);
        }
    }

    public static boolean a(String str, String str2, l lVar, Object obj) {
        Map<Integer, a.InterfaceC0308a> h2;
        boolean z = false;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && lVar != null && (h2 = h()) != null) {
            for (Map.Entry<Integer, a.InterfaceC0308a> entry : h2.entrySet()) {
                int intValue = entry.getKey().intValue();
                a.InterfaceC0308a value = entry.getValue();
                if (value != null) {
                    boolean a2 = value.a(intValue, lVar, str, str2, obj);
                    if (!z && !a2) {
                        z = true;
                    }
                }
            }
        }
        return z;
    }

    public static boolean a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            List<DownloadInfo> v = d.o.a.e.a.e.F().v(context);
            if (!v.isEmpty()) {
                for (DownloadInfo downloadInfo : v) {
                    if (downloadInfo != null && str.equals(downloadInfo.T0())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static d.o.a.e.b.g.b a(Context context, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("download_exp_switch_temp", 1040187391);
        d.o.a.e.b.g.b bVar = new d.o.a.e.b.g.b(context);
        bVar.e(new d.o.a.e.b.f.e() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.7
            @Override // d.o.a.e.b.f.e
            public JSONObject a() {
                return g.i();
            }
        });
        bVar.d(optInt);
        bVar.E(new com.bytedance.sdk.openadsdk.downloadnew.a.a.f(context));
        return bVar;
    }

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        return jSONObject.optInt("enable_open_app_dialog") == 1;
    }
}
