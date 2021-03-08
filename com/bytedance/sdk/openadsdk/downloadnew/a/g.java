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
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.g;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.m;
import com.bytedance.sdk.openadsdk.utils.q;
import com.bytedance.sdk.openadsdk.utils.u;
import com.ss.android.a.a.d.a;
import com.ss.android.socialbase.downloader.d.o;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f4724a;
    private static Context c;
    private static Map<Integer, a.InterfaceC1029a> d;
    private static final AtomicBoolean b = new AtomicBoolean(false);
    private static boolean e = true;
    private static com.ss.android.a.a.b.a.a f = new com.ss.android.a.a.b.a.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.1
        @Override // com.ss.android.a.a.b.a.a
        public void a(@NonNull com.ss.android.a.a.b.c cVar, @Nullable com.ss.android.a.a.b.a aVar, @Nullable com.ss.android.a.a.b.b bVar) {
            u.b("LibHolder", "completeListener: onDownloadStart");
        }

        @Override // com.ss.android.a.a.b.a.a
        public void a(@NonNull com.ss.android.socialbase.downloader.g.c cVar, String str) {
            u.b("LibHolder", "completeListener: onDownloadFinished");
        }

        @Override // com.ss.android.a.a.b.a.a
        public void b(@Nullable com.ss.android.socialbase.downloader.g.c cVar, String str) {
            u.b("LibHolder", "completeListener: onInstalled");
            g.b(str);
        }

        @Override // com.ss.android.a.a.b.a.a
        public void a(@NonNull com.ss.android.socialbase.downloader.g.c cVar, com.ss.android.socialbase.downloader.e.a aVar, String str) {
            u.b("LibHolder", "completeListener: onDownloadFailed");
        }

        @Override // com.ss.android.a.a.b.a.a
        public void a(@NonNull com.ss.android.socialbase.downloader.g.c cVar) {
            u.b("LibHolder", "completeListener: onCanceled");
        }
    };

    static {
        try {
            f4724a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(String str) {
        com.ss.android.b.a.b.a aaX;
        JSONObject q;
        JSONObject optJSONObject;
        com.bytedance.sdk.openadsdk.downloadnew.a.b.a a2;
        l lVar;
        if (!ak.a()) {
            u.b("LibHolder", "锁屏不执行自启动调起");
        } else if (!TextUtils.isEmpty(str) && (aaX = com.ss.android.downloadlib.a.b.d.eEF().aaX(str)) != null && (q = aaX.q()) != null && (optJSONObject = q.optJSONObject("open_ad_sdk_download_extra")) != null && (a2 = com.bytedance.sdk.openadsdk.downloadnew.a.b.a.a(optJSONObject)) != null && (lVar = a2.f4715a) != null) {
            a(str, lVar);
        }
    }

    private static void a(String str, l lVar) {
        try {
            if (g() != null && !TextUtils.isEmpty(str) && lVar != null && lVar.q()) {
                com.bytedance.sdk.openadsdk.core.d.g ai = lVar.ai();
                if (ai != null && !TextUtils.isEmpty(ai.a())) {
                    u.f("LibHolder", "含有deepLink");
                    if (lVar.G() != 0) {
                        u.f("LibHolder", "deepLink过滤 mMeta.getDownConfigAutoOpen() " + lVar.G());
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
        } catch (Throwable th) {
        }
    }

    private static void b(final l lVar, final String str) {
        final com.bytedance.sdk.openadsdk.utils.a c2;
        if (!a(lVar) && (c2 = i.d().c()) != null) {
            final long currentTimeMillis = System.currentTimeMillis();
            c2.a(new a.InterfaceC1047a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.2
                @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                public void a() {
                    if (!ak.a()) {
                        u.b("LibHolder", "锁屏不执行自启动调起");
                        if (com.bytedance.sdk.openadsdk.utils.a.this != null) {
                            com.bytedance.sdk.openadsdk.utils.a.this.b();
                            return;
                        }
                        return;
                    }
                    if (!q.a(str)) {
                        g.b(lVar, currentTimeMillis, com.bytedance.sdk.openadsdk.utils.a.this, str);
                    }
                    if (com.bytedance.sdk.openadsdk.utils.a.this != null) {
                        com.bytedance.sdk.openadsdk.utils.a.this.b();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                public void b() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                public void c() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                public void d() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                public void e() {
                }

                @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                public void f() {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(l lVar, long j, com.bytedance.sdk.openadsdk.utils.a aVar, String str) {
        if (lVar != null) {
            if (System.currentTimeMillis() - j >= lVar.u() * 1000) {
                String str2 = "";
                if (lVar.ah() != null) {
                    str2 = lVar.ah().c();
                }
                String str3 = "安装完成，是否立即打开 ？";
                if (TextUtils.isEmpty(str2)) {
                    str3 = "应用安装完成，是否立即打开 ？";
                }
                b(aVar, lVar, str2, str3, str);
                return;
            }
            c(lVar, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(l lVar, String str) {
        if (lVar != null && aj.a(g(), str)) {
            u.b("LibHolder", "通过包名调起 " + str);
        }
    }

    private static boolean a(l lVar) {
        if (lVar != null && a(i())) {
            int T = lVar.T();
            if ((TextUtils.isEmpty(lVar.at()) || T != 4) && !k.f()) {
                return false;
            }
            k.a(false);
            return true;
        }
        return false;
    }

    private static void a(Context context, final l lVar, final String str) {
        if (context != null && lVar != null && !a(lVar)) {
            final String str2 = "";
            if (lVar.ah() != null) {
                str2 = lVar.ah().c();
            }
            final String str3 = "安装完成，是否立即打开 ？";
            if (TextUtils.isEmpty(str2)) {
                str3 = "应用安装完成，是否立即打开 ？";
            }
            final com.bytedance.sdk.openadsdk.utils.a c2 = i.d().c();
            if (c2 != null) {
                c2.a(new a.InterfaceC1047a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.3
                    @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                    public void a() {
                        try {
                            if (!ak.a()) {
                                u.b("LibHolder", "锁屏不执行自启动调起");
                                if (com.bytedance.sdk.openadsdk.utils.a.this != null) {
                                    com.bytedance.sdk.openadsdk.utils.a.this.b();
                                    return;
                                }
                                return;
                            }
                            if (!q.a(str)) {
                                g.b(com.bytedance.sdk.openadsdk.utils.a.this, lVar, str2, str3, str);
                            }
                            if (com.bytedance.sdk.openadsdk.utils.a.this != null) {
                                com.bytedance.sdk.openadsdk.utils.a.this.b();
                            }
                        } catch (Throwable th) {
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                    public void b() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                    public void c() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                    public void d() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                    public void e() {
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.a.InterfaceC1047a
                    public void f() {
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(final com.bytedance.sdk.openadsdk.utils.a aVar, final l lVar, String str, String str2, final String str3) {
        if (aVar != null) {
            if (!aj.c(g(), str3)) {
                u.b("LibHolder", "该app未安装 packageName " + str3);
            } else {
                com.bytedance.sdk.openadsdk.utils.g.a(lVar.ag(), TextUtils.isEmpty(str) ? "" : str, str2, "立即打开", "退出", new g.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.4
                    @Override // com.bytedance.sdk.openadsdk.utils.g.a
                    public void a() {
                        g.c(l.this, str3);
                        if (aVar != null) {
                            aVar.b();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.g.a
                    public void b() {
                        if (aVar != null) {
                            aVar.b();
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.utils.g.a
                    public void c() {
                        if (aVar != null) {
                            aVar.b();
                        }
                    }
                });
            }
        }
    }

    private static Context g() {
        return c == null ? p.a() : c;
    }

    public static void a(Context context) {
        if (context == null) {
            context = p.a();
        }
        if (context != null) {
            c = context.getApplicationContext();
            a();
            if (!b.get()) {
                synchronized (g.class) {
                    if (!b.get()) {
                        b.set(b(c));
                    }
                }
            }
        }
    }

    public static void a() {
        File externalFilesDir;
        String str = null;
        try {
            if (e && !b()) {
                File file = new File(g().getCacheDir(), Environment.DIRECTORY_DOWNLOADS);
                file.mkdirs();
                String path = file.getPath();
                if (TextUtils.isEmpty(path)) {
                    str = path;
                } else {
                    Runtime.getRuntime().exec("chmod 777 " + path);
                    str = path;
                }
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
                f4724a = str;
                m.a();
            }
            u.b("LibHolder", "path: " + String.valueOf(f4724a));
        } catch (Throwable th) {
        }
    }

    public static boolean b() {
        if (Build.VERSION.SDK_INT < 23) {
            return true;
        }
        return com.bytedance.sdk.openadsdk.core.f.d.a().a(g(), "android.permission.WRITE_EXTERNAL_STORAGE");
    }

    public static void c() {
        boolean w;
        h h = p.h();
        if (h != null && e != (w = h.w())) {
            e = w;
            a();
        }
    }

    public static com.ss.android.downloadlib.i d() {
        if (!b.get()) {
            b(p.a());
        }
        return com.ss.android.downloadlib.i.iB(g());
    }

    public static void e() {
        d().g();
        if (!TextUtils.isEmpty(f4724a)) {
            com.bytedance.sdk.openadsdk.utils.l.c(new File(f4724a));
        }
    }

    public static void a(int i) {
        if (d != null) {
            d.remove(Integer.valueOf(i));
        }
    }

    public static void a(int i, a.InterfaceC1029a interfaceC1029a) {
        if (interfaceC1029a != null) {
            if (d == null) {
                d = Collections.synchronizedMap(new WeakHashMap());
            }
            d.put(Integer.valueOf(i), interfaceC1029a);
        }
    }

    @Nullable
    private static Map<Integer, a.InterfaceC1029a> h() {
        return d;
    }

    public static boolean a(String str, String str2, l lVar, Object obj) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || lVar == null) {
            return false;
        }
        Map<Integer, a.InterfaceC1029a> h = h();
        if (h == null) {
            return false;
        }
        Iterator<Map.Entry<Integer, a.InterfaceC1029a>> it = h.entrySet().iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                Map.Entry<Integer, a.InterfaceC1029a> next = it.next();
                int intValue = next.getKey().intValue();
                a.InterfaceC1029a value = next.getValue();
                if (value != null) {
                    boolean a2 = value.a(intValue, lVar, str, str2, obj);
                    if (!z2 && !a2) {
                        z2 = true;
                    }
                }
                z = z2;
            } else {
                return z2;
            }
        }
    }

    public static boolean a(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        List<com.ss.android.socialbase.downloader.g.c> b2 = com.ss.android.socialbase.appdownloader.d.eFz().b(context);
        if (!b2.isEmpty()) {
            for (com.ss.android.socialbase.downloader.g.c cVar : b2) {
                if (cVar != null && str.equals(cVar.j())) {
                    return true;
                }
            }
        }
        return false;
    }

    private g() {
    }

    private static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        if (TextUtils.isEmpty(packageName)) {
            packageName = "";
        }
        com.ss.android.a.a.a eFq = com.ss.android.downloadlib.i.iB(applicationContext).eFq();
        if (eFq == null) {
            return false;
        }
        eFq.a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.d(applicationContext)).a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.b(applicationContext)).a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.e(applicationContext)).a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.c(applicationContext)).a(new com.ss.android.a.a.a.i() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.5
            @Override // com.ss.android.a.a.a.i
            public JSONObject a() {
                return g.i();
            }
        }).a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.a(applicationContext)).a(new a.C1209a().aat("143").aas("open_news").aau("3.4.0.1").aav(String.valueOf(3401)).eEn()).aar(packageName + ".TTFileProvider").a(a(applicationContext, i()));
        com.ss.android.downloadlib.f.a.a();
        com.ss.android.downloadlib.i.iB(applicationContext).eFr().a(1);
        com.ss.android.downloadlib.i.iB(applicationContext).a(f);
        com.ss.android.socialbase.appdownloader.d.eFz().a(new o() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.6
            @Override // com.ss.android.socialbase.downloader.d.o
            public boolean a(Intent intent) {
                return false;
            }
        });
        return true;
    }

    private static com.ss.android.socialbase.downloader.downloader.g a(Context context, JSONObject jSONObject) {
        return new com.ss.android.socialbase.downloader.downloader.g(context).b(new com.ss.android.socialbase.downloader.d.e() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.g.7
            @Override // com.ss.android.socialbase.downloader.d.e
            public JSONObject a() {
                return g.i();
            }
        }).Rz(jSONObject.optInt("download_exp_switch_temp", 1023409663)).b(new com.bytedance.sdk.openadsdk.downloadnew.a.a.f(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static JSONObject i() {
        h h = p.h();
        return (h == null || h.p() == null) ? new JSONObject() : h.p();
    }

    private static boolean a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return false;
        }
        try {
            return jSONObject.optInt("enable_open_app_dialog") == 1;
        } catch (Throwable th) {
            return false;
        }
    }
}
