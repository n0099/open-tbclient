package com.bytedance.sdk.openadsdk.downloadnew.a;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.h.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.downloadnew.a.a.f;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.m;
import com.bytedance.sdk.openadsdk.utils.u;
import com.ss.android.a.a.d.a;
import com.ss.android.downloadlib.i;
import com.ss.android.socialbase.downloader.d.o;
import com.ss.android.socialbase.downloader.downloader.g;
import java.io.File;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static volatile String f7397a;
    private static Context c;
    private static Map<Integer, a.InterfaceC1030a> d;

    /* renamed from: b  reason: collision with root package name */
    private static final AtomicBoolean f7398b = new AtomicBoolean(false);
    private static boolean e = true;
    private static com.ss.android.a.a.b.a.a f = new com.ss.android.a.a.b.a.a() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.e.1
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
            f7397a = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getPath();
        } catch (Throwable th) {
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
            if (!f7398b.get()) {
                synchronized (e.class) {
                    if (!f7398b.get()) {
                        f7398b.set(b(c));
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
                f7397a = str;
                m.a();
            }
            u.b("LibHolder", "path: " + String.valueOf(f7397a));
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
        boolean x;
        l h = p.h();
        if (h != null && e != (x = h.x())) {
            e = x;
            a();
        }
    }

    public static i d() {
        if (!f7398b.get()) {
            b(p.a());
        }
        return i.iz(g());
    }

    public static void e() {
        d().g();
        if (!TextUtils.isEmpty(f7397a)) {
            com.bytedance.sdk.openadsdk.utils.l.c(new File(f7397a));
        }
    }

    public static void a(int i) {
        if (d != null) {
            d.remove(Integer.valueOf(i));
        }
    }

    public static void a(int i, a.InterfaceC1030a interfaceC1030a) {
        if (interfaceC1030a != null) {
            if (d == null) {
                d = Collections.synchronizedMap(new WeakHashMap());
            }
            d.put(Integer.valueOf(i), interfaceC1030a);
        }
    }

    @Nullable
    private static Map<Integer, a.InterfaceC1030a> h() {
        return d;
    }

    public static boolean a(String str, String str2, com.bytedance.sdk.openadsdk.core.d.l lVar, Object obj) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || lVar == null) {
            return false;
        }
        Map<Integer, a.InterfaceC1030a> h = h();
        if (h == null) {
            return false;
        }
        Iterator<Map.Entry<Integer, a.InterfaceC1030a>> it = h.entrySet().iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                Map.Entry<Integer, a.InterfaceC1030a> next = it.next();
                int intValue = next.getKey().intValue();
                a.InterfaceC1030a value = next.getValue();
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
        List<com.ss.android.socialbase.downloader.g.c> b2 = com.ss.android.socialbase.appdownloader.d.eGM().b(context);
        if (!b2.isEmpty()) {
            for (com.ss.android.socialbase.downloader.g.c cVar : b2) {
                if (cVar != null && str.equals(cVar.j())) {
                    return true;
                }
            }
        }
        return false;
    }

    private e() {
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
        com.ss.android.a.a.a eGD = i.iz(applicationContext).eGD();
        if (eGD == null) {
            return false;
        }
        eGD.a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.d(applicationContext)).a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.b(applicationContext)).a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.e(applicationContext)).a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.c(applicationContext)).a(new com.ss.android.a.a.a.i() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.e.2
            @Override // com.ss.android.a.a.a.i
            public JSONObject a() {
                return e.i();
            }
        }).a(new com.bytedance.sdk.openadsdk.downloadnew.a.a.a(applicationContext)).a(new a.C1230a().aai("143").aah("open_news").aaj("3.2.5.1").aak(String.valueOf(3251)).eFB()).aag(packageName + ".TTFileProvider").a(a(applicationContext, i()));
        com.ss.android.downloadlib.f.a.a();
        i.iz(applicationContext).eGE().a(1);
        i.iz(applicationContext).a(f);
        com.ss.android.socialbase.appdownloader.d.eGM().a(new o() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.e.3
            @Override // com.ss.android.socialbase.downloader.d.o
            public boolean a(Intent intent) {
                return false;
            }
        });
        return true;
    }

    private static g a(Context context, JSONObject jSONObject) {
        return new g(context).b(new com.ss.android.socialbase.downloader.d.e() { // from class: com.bytedance.sdk.openadsdk.downloadnew.a.e.4
            @Override // com.ss.android.socialbase.downloader.d.e
            public JSONObject a() {
                return e.i();
            }
        }).SG(jSONObject.optInt("download_exp_switch_temp", 1023409663)).b(new f(context));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static JSONObject i() {
        l h = p.h();
        return (h == null || h.q() == null) ? new JSONObject() : h.q();
    }
}
