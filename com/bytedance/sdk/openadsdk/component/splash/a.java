package com.bytedance.sdk.openadsdk.component.splash;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.u;
import com.kwad.sdk.collector.AppStatusRules;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class a implements am.a {

    /* renamed from: a  reason: collision with root package name */
    private static final Integer f6679a = 1;

    /* renamed from: b  reason: collision with root package name */
    private static final Integer f6680b = 2;
    private static final Integer c = 3;
    @SuppressLint({"StaticFieldLeak"})
    private static volatile a d;
    private Context e;
    private e i;
    private f j;
    private C0979a n;
    private final am f = new am(Looper.getMainLooper(), this);
    private final WeakHashMap<Integer, c> g = new WeakHashMap<>();
    private final WeakHashMap<Integer, d> h = new WeakHashMap<>();
    private long k = 0;
    private long l = 0;
    private AtomicBoolean m = new AtomicBoolean(false);

    /* loaded from: classes4.dex */
    interface c {
        void a();

        void a(@NonNull o oVar);
    }

    /* loaded from: classes4.dex */
    interface d {
        void a();
    }

    private a(Context context) {
        if (context != null) {
            this.e = context.getApplicationContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static a a(Context context) {
        if (d == null) {
            synchronized (a.class) {
                if (d == null) {
                    d = new a(context);
                }
            }
        }
        return d;
    }

    private Context b() {
        return this.e != null ? this.e : p.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(o oVar) {
        int c2;
        if (oVar != null && (c2 = com.bytedance.sdk.openadsdk.component.splash.c.c(oVar)) > 0) {
            a(c2, oVar.a().Z());
            c(oVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(o oVar, @NonNull d dVar) {
        if (dVar != null) {
            this.h.put(c, dVar);
            a(oVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(o oVar) {
        int c2 = com.bytedance.sdk.openadsdk.component.splash.c.c(oVar);
        if (c2 > 0) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_video_ad_cache" + c2, (Boolean) true);
            } else {
                b().getSharedPreferences("tt_splash", 0).edit().putBoolean("has_video_ad_cache" + c2, true).apply();
            }
        }
    }

    private void c(o oVar) {
        if (this.j == null) {
            this.j = new f(oVar);
        } else {
            this.j.a(oVar);
        }
        com.bytedance.sdk.openadsdk.k.a.a().c(this.j, 10);
    }

    private void a(int i, long j) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "expiration" + i, Long.valueOf(j));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", IMTrack.DbBuilder.ACTION_UPDATE + i, Long.valueOf(System.currentTimeMillis() / 1000));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_ad_cache" + i, (Boolean) true);
            return;
        }
        b().getSharedPreferences("tt_splash", 0).edit().putLong("expiration" + i, j).putLong(IMTrack.DbBuilder.ACTION_UPDATE + i, System.currentTimeMillis() / 1000).putBoolean("has_ad_cache" + i, true).apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final String str, @NonNull c cVar) {
        this.g.put(f6680b, cVar);
        if (TextUtils.isEmpty(str)) {
            Message obtainMessage = this.f.obtainMessage();
            obtainMessage.what = 2;
            this.f.sendMessage(obtainMessage);
            return;
        }
        com.bytedance.sdk.openadsdk.k.a.a().c(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.splash.a.1
            @Override // java.lang.Runnable
            public void run() {
                l lVar;
                u.b("TTExecutor", "readSplashMaterialMeta....->run....");
                Message obtainMessage2 = a.this.f.obtainMessage();
                obtainMessage2.what = 2;
                try {
                    com.bytedance.sdk.openadsdk.core.d.a f2 = a.this.f(str);
                    o oVar = new o(f2, null, null);
                    if (f2 != null && f2.c() != null && !f2.c().isEmpty() && (lVar = f2.c().get(0)) != null) {
                        oVar.a(lVar);
                    }
                    obtainMessage2.obj = oVar;
                    a.this.f.sendMessage(obtainMessage2);
                } catch (Throwable th) {
                    a.this.f.sendMessage(obtainMessage2);
                }
                a.this.d(str);
            }
        }, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str, @NonNull c cVar) {
        if (TextUtils.isEmpty(str)) {
            cVar.a();
            return;
        }
        this.g.put(f6679a, cVar);
        com.bytedance.sdk.openadsdk.k.a.a().c(e(str), 10);
    }

    private Runnable e(String str) {
        if (this.i == null) {
            this.i = new e(str);
        } else {
            this.i.a(str);
        }
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_ad_cache" + str, false);
        }
        return b().getSharedPreferences("tt_splash", 0).getBoolean("has_ad_cache" + str, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_video_ad_cache" + str, false);
        }
        return b().getSharedPreferences("tt_splash", 0).getBoolean("has_video_ad_cache" + str, false);
    }

    @NonNull
    b c(String str) {
        boolean z = false;
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            long a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "expiration" + str, 0L);
            long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", IMTrack.DbBuilder.ACTION_UPDATE + str, 0L);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < a3 || currentTimeMillis >= a2) {
                z = true;
            }
            bVar.f6693a = z;
            bVar.f6694b = a3;
            bVar.c = a2;
            bVar.d = currentTimeMillis;
            return bVar;
        }
        SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
        long j = sharedPreferences.getLong("expiration" + str, 0L);
        long j2 = sharedPreferences.getLong(IMTrack.DbBuilder.ACTION_UPDATE + str, 0L);
        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
        if (currentTimeMillis2 < j2 || currentTimeMillis2 >= j) {
            z = true;
        }
        bVar.f6693a = z;
        bVar.f6694b = j2;
        bVar.c = j;
        bVar.d = currentTimeMillis2;
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        boolean f6693a = true;

        /* renamed from: b  reason: collision with root package name */
        long f6694b = 0;
        long c = 0;
        long d = 0;

        b() {
        }
    }

    public String a(String str, boolean z) {
        if (z) {
            return "splash_video_cache_" + str + "/";
        }
        return "/splash_video_cache_" + str + "/";
    }

    public void a(File file) {
        try {
            u.f("splashLoadAd", "SplashAdCacheManager trimFileCache " + file.getPath());
            i.c().p().a(file);
        } catch (IOException e2) {
            u.f("SplashAdCacheManager", "trimFileCache IOException:" + e2.toString());
        }
    }

    public String a(l lVar) {
        if (lVar == null || lVar.F() == null || TextUtils.isEmpty(lVar.F().h())) {
            return null;
        }
        return a(lVar.F().h(), lVar.F().k(), String.valueOf(aj.d(lVar.W())));
    }

    public String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = j.a(str);
        }
        String a2 = a(String.valueOf(str3), com.bytedance.sdk.openadsdk.multipro.b.b());
        u.f("splashLoadAd", "getVideoPath  cacheDirPath " + a2);
        File a3 = com.bytedance.sdk.openadsdk.component.splash.c.a(this.e, a2, str2);
        if (a3 != null && a3.exists() && a3.isFile()) {
            u.f("splashLoadAd", "getVideoPath  file.getAbsolutePath() " + a3.getAbsolutePath());
            return a3.getAbsolutePath();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        d remove;
        if (message.what == 1) {
            c remove2 = this.g.remove(f6679a);
            if (remove2 != null) {
                if (message.obj != null && (message.obj instanceof o)) {
                    remove2.a((o) message.obj);
                    u.b("SplashAdCacheManager", "缓存反序列化成功");
                } else {
                    remove2.a();
                    u.b("SplashAdCacheManager", "缓存反序列化失败");
                }
            }
            u.b("SplashAdCacheManager", "OnLoadCacheCallback is null: " + (remove2 == null));
            this.f.removeCallbacksAndMessages(null);
        } else if (message.what == 2) {
            c remove3 = this.g.remove(f6680b);
            if (remove3 != null) {
                if (message.obj != null && (message.obj instanceof o)) {
                    remove3.a((o) message.obj);
                    u.b("SplashAdCacheManager", "视频物料缓存反序列化成功");
                } else {
                    remove3.a();
                    u.b("SplashAdCacheManager", "视频物料缓存反序列化失败");
                }
            }
            u.b("SplashAdCacheManager", "OnLoadCacheCallback is null: " + (remove3 == null));
            this.f.removeCallbacksAndMessages(null);
        } else if (message.what == 3 && this.h != null && (remove = this.h.remove(c)) != null) {
            remove.a();
        }
    }

    public boolean a(AdSlot adSlot, boolean z) {
        b c2 = a(this.e).c(adSlot.getCodeId());
        if (z && c2.f6693a) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("available_type", 0);
                jSONObject.putOpt("creative_timeout_duration", Long.valueOf((c2.d - c2.f6694b) / 3600));
                com.bytedance.sdk.openadsdk.h.a.a().n(com.bytedance.sdk.openadsdk.h.a.d.b().a(4).c(adSlot.getCodeId()).b(jSONObject.toString()));
            } catch (Throwable th) {
            }
        }
        return c2.f6693a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_materialMeta", "materialMeta" + str);
                com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "has_ad_cache" + str);
                com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "has_video_ad_cache" + str);
                com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "expiration" + str);
                com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "expiration" + str);
                return;
            }
            b().getSharedPreferences("tt_materialMeta", 0).edit().remove("materialMeta" + str).apply();
            b().getSharedPreferences("tt_splash", 0).edit().remove("has_ad_cache" + str).remove("has_video_ad_cache" + str).remove("expiration" + str).remove("expiration" + str).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0094 -> B:40:0x0013). Please submit an issue!!! */
    public void a() {
        File externalCacheDir;
        File[] listFiles;
        try {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_materialMeta");
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash");
            } else {
                b().getSharedPreferences("tt_materialMeta", 0).edit().clear().apply();
                b().getSharedPreferences("tt_splash", 0).edit().clear().apply();
            }
        } catch (Throwable th) {
        }
        try {
            if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && b().getExternalCacheDir() != null) {
                externalCacheDir = b().getExternalCacheDir();
            } else {
                externalCacheDir = b().getCacheDir();
            }
            if (externalCacheDir != null && externalCacheDir.exists() && externalCacheDir.isDirectory() && (listFiles = externalCacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.splash.a.2
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null) {
                        String name = file.getName();
                        return name.contains("splash_ad_cache") || name.contains("splash_video_cache");
                    }
                    return false;
                }
            })) != null && listFiles.length > 0) {
                for (File file : listFiles) {
                    try {
                        com.bytedance.sdk.openadsdk.utils.l.c(file);
                    } catch (Throwable th2) {
                    }
                }
            }
        } catch (Throwable th3) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private String f6696b;

        public e(String str) {
            this.f6696b = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            this.f6696b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar;
            Message obtainMessage = a.this.f.obtainMessage();
            obtainMessage.what = 1;
            try {
                com.bytedance.sdk.openadsdk.core.d.a f = a.this.f(this.f6696b);
                o oVar = new o(f, null, null);
                if (f != null && f.c() != null && !f.c().isEmpty() && (lVar = f.c().get(0)) != null && lVar.ai()) {
                    String a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(a.this.a(f), a.this.b(f), a.this.b(f), ImageView.ScaleType.CENTER_INSIDE);
                    com.bytedance.sdk.openadsdk.i.a.a.a();
                    String b2 = com.bytedance.sdk.openadsdk.i.a.a.b();
                    u.f("splashLoadAd", " readSplashAdFromCache 开始获取缓存文件 filePath " + b2);
                    File file = new File(b2, a2);
                    u.f("splashLoadAd", " readSplashAdFromCache path " + file.getPath());
                    if (file == null || !file.exists() || !file.isFile() || file.length() <= 0) {
                        u.f("splashLoadAd", " readSplashAdFromCache 获取文件失败 " + file.getPath());
                        obtainMessage.obj = null;
                        a.this.f.sendMessage(obtainMessage);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.i.a.b.f7489a = 1;
                    u.f("splashLoadAd", " readSplashAdFromCache 获取文件成功 cacheKey " + a2);
                    byte[] a3 = a(file);
                    if (a3 != null && a3.length != 0) {
                        oVar.a(lVar);
                        oVar.a(a3);
                    }
                }
                obtainMessage.obj = oVar;
                a.this.f.sendMessage(obtainMessage);
            } catch (Throwable th) {
                a.this.f.sendMessage(obtainMessage);
            }
            try {
                u.f("splashLoadAd", "获取缓存广告之后将其清空 clearCache " + this.f6696b);
                a.this.d(this.f6696b);
            } catch (Throwable th2) {
            }
        }

        private byte[] a(File file) {
            Throwable th;
            FileInputStream fileInputStream;
            FileInputStream fileInputStream2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            try {
                fileInputStream2 = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr, 0, bArr.length);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr, 0, read);
                    } catch (Exception e) {
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e2) {
                            }
                        }
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        return byteArrayOutputStream.toByteArray();
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (byteArrayOutputStream != null) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (IOException e3) {
                                throw th;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                }
                byteArrayOutputStream.flush();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
            } catch (Exception e5) {
                fileInputStream2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileInputStream = null;
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private o f6698b;

        public f(o oVar) {
            this.f6698b = oVar;
        }

        public void a(o oVar) {
            this.f6698b = oVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [681=4] */
        private void a() {
            if (a.this.f == null) {
                return;
            }
            Message obtainMessage = a.this.f.obtainMessage();
            obtainMessage.what = 3;
            try {
                int c = com.bytedance.sdk.openadsdk.component.splash.c.c(this.f6698b);
                if (c <= 0) {
                    a.this.f.sendMessage(obtainMessage);
                } else if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_materialMeta", "materialMeta" + c, this.f6698b.c().d());
                    a.this.f.sendMessage(obtainMessage);
                } else {
                    p.a().getSharedPreferences("tt_materialMeta", 0).edit().putString("materialMeta" + c, this.f6698b.c().d()).apply();
                    a.this.f.sendMessage(obtainMessage);
                }
            } catch (Throwable th) {
                a.this.f.sendMessage(obtainMessage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.core.d.a f(String str) {
        String string;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            string = com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_materialMeta", "materialMeta" + str, (String) null);
        } else {
            string = b().getSharedPreferences("tt_materialMeta", 0).getString("materialMeta" + str, null);
        }
        if (!TextUtils.isEmpty(string)) {
            try {
                r.a a2 = r.a.a(new JSONObject(string));
                if (a2 != null && a2.h != null) {
                    return a2.h;
                }
            } catch (JSONException e2) {
            }
        }
        return null;
    }

    private void c(final AdSlot adSlot, m mVar) {
        if (this.m.getAndSet(true)) {
            u.b("splashLoad", "已在预加载开屏广告....不再发出");
            return;
        }
        if ((p.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) && mVar != null) {
            mVar.e = 2;
        }
        p.f().a(adSlot, mVar, 4, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.splash.a.3
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                u.b("splashLoad", "广告物料预加载失败...." + str + i);
                u.b("SplashAdCacheManager", str + i);
                a.this.m.set(false);
                if (a.this.n != null) {
                    a.this.n.a(adSlot);
                }
                if (adSlot != null) {
                    k.a(System.currentTimeMillis(), adSlot.getCodeId());
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(final com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (!com.bytedance.sdk.openadsdk.component.splash.c.b(aVar)) {
                    a.this.m.set(false);
                    if (a.this.n != null) {
                        a.this.n.a(adSlot);
                    }
                } else {
                    u.b("splashLoad", "广告物料预加载成功....");
                    final l lVar = aVar.c().get(0);
                    if (lVar.ai()) {
                        final boolean z = lVar.F() != null;
                        com.bytedance.sdk.openadsdk.core.d.k J = lVar.J();
                        if (J == null) {
                            J = lVar.M().get(0);
                        }
                        String a2 = J.a();
                        int b2 = J.b();
                        a.this.k = System.currentTimeMillis();
                        com.bytedance.sdk.openadsdk.component.splash.c.a(lVar, z ? 2 : 0);
                        a.this.l = SystemClock.elapsedRealtime();
                        com.bytedance.sdk.openadsdk.utils.o.a(a.this.e, a2, b2, new o.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.a.3.1
                            @Override // com.bytedance.sdk.openadsdk.utils.o.a
                            @MainThread
                            public void a(@NonNull byte[] bArr) {
                                com.bytedance.sdk.openadsdk.component.splash.c.a(aVar);
                                com.bytedance.sdk.openadsdk.component.splash.c.a(lVar);
                                if (!z) {
                                    com.bytedance.sdk.openadsdk.c.d.a(lVar, "splash_ad", "download_creative_duration", System.currentTimeMillis() - a.this.k);
                                }
                                a.this.k = 0L;
                                u.b("SplashAdCacheManager", "图片数据加载的广告缓存到本地");
                                u.b("splashLoad", "预加载成功，广告缓存到本地----10");
                                a.a(a.this.e).a(new com.bytedance.sdk.openadsdk.core.d.o(aVar, lVar, bArr));
                                if (z) {
                                    com.bytedance.sdk.openadsdk.component.splash.c.a(a.this.l, false, true, lVar, 0L, null);
                                }
                                a.this.m.set(false);
                                if (a.this.n == null) {
                                    return;
                                }
                                a.this.n.a(adSlot);
                            }

                            @Override // com.bytedance.sdk.openadsdk.utils.o.a
                            @MainThread
                            public void a() {
                                com.bytedance.sdk.openadsdk.component.splash.c.a(aVar);
                                u.b("SplashAdCacheManager", "图片数据加载失败");
                                u.b("splashLoad", "图片数据预加载失败....");
                                if (z) {
                                    com.bytedance.sdk.openadsdk.component.splash.c.a(a.this.l, false, false, lVar, -7L, null);
                                }
                                a.this.m.set(false);
                                if (a.this.n == null) {
                                    return;
                                }
                                a.this.n.a(adSlot);
                            }
                        }, true);
                    }
                }
                if (adSlot != null) {
                    k.a(System.currentTimeMillis(), adSlot.getCodeId());
                }
            }
        });
    }

    public void a(AdSlot adSlot, m mVar) {
        if (p.h().u() && adSlot != null) {
            m mVar2 = mVar == null ? new m() : mVar.a();
            mVar2.f = System.currentTimeMillis();
            c(adSlot, mVar2);
        }
    }

    public void b(AdSlot adSlot, m mVar) {
        if (adSlot != null && mVar != null) {
            if (this.n == null) {
                this.n = new C0979a();
            }
            this.n.a(adSlot, mVar);
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.component.splash.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C0979a {

        /* renamed from: a  reason: collision with root package name */
        a f6688a;

        /* renamed from: b  reason: collision with root package name */
        private ConcurrentHashMap<String, C0980a> f6689b;

        private C0979a() {
            this.f6688a = a.a(p.a());
            this.f6689b = new ConcurrentHashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AdSlot adSlot, m mVar) {
            int z;
            if (adSlot != null && mVar != null && a()) {
                if (!this.f6689b.containsKey(adSlot.getCodeId())) {
                    u.f("SplashAdCacheManager", "add adSlot.getCodeId() " + adSlot.getCodeId());
                    this.f6689b.put(adSlot.getCodeId(), new C0980a(adSlot.getCodeId(), adSlot, mVar));
                }
                if (!p.l() && (z = p.h().z()) > 0) {
                    p.k();
                    com.bytedance.sdk.openadsdk.k.a.a().a(new com.bytedance.sdk.openadsdk.k.c() { // from class: com.bytedance.sdk.openadsdk.component.splash.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            u.f("SplashAdCacheManager", "触发定时器进行检测实现需要加载开屏广告");
                            C0979a.this.a(C0979a.this.f6689b);
                        }
                    }, (z * 60000) + 10000);
                }
            }
        }

        private boolean a() {
            return p.h().y() == 1 && p.h().z() > 0;
        }

        private int a(long j) {
            if (j <= 0) {
                return 0;
            }
            long currentTimeMillis = System.currentTimeMillis() - j;
            if (currentTimeMillis > 0) {
                u.f("SplashAdCacheManager", "CircleLoadSplashAd getIntervalTime temp " + currentTimeMillis);
                return (int) (currentTimeMillis / AppStatusRules.DEFAULT_GRANULARITY);
            }
            return 0;
        }

        private boolean a(String str) {
            u.f("SplashAdCacheManager", "CircleLoadSplashAd isLoadSplashAd rit " + str);
            long a2 = k.a(str);
            u.f("SplashAdCacheManager", "CircleLoadSplashAd isLoadSplashAd lastLoadAdTime " + a2);
            return a(a2) >= p.h().z();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ConcurrentHashMap<String, C0980a> concurrentHashMap) {
            C0980a value;
            if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                u.f("SplashAdCacheManager", "mloadSplashParaHashMap == null || mloadSplashParaHashMap.size() == 0 ");
                return;
            }
            Iterator<Map.Entry<String, C0980a>> it = concurrentHashMap.entrySet().iterator();
            if (it != null) {
                while (it.hasNext()) {
                    Map.Entry<String, C0980a> next = it.next();
                    u.f("SplashAdCacheManager", "entry.getKey()  " + next.getKey() + " entry.getValue() " + next.getValue());
                    if (next != null && (value = next.getValue()) != null) {
                        if (!value.a()) {
                            AdSlot adSlot = value.f6692b;
                            m mVar = value.c;
                            u.f("SplashAdCacheManager", " loadSplashParamHashMapTest " + concurrentHashMap.size());
                            u.f("SplashAdCacheManager", "byRitLoadSplashAd 开始请求广告");
                            value.a(true);
                            a(next.getKey(), adSlot, mVar);
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
        }

        private void a(String str, AdSlot adSlot, m mVar) {
            if (!TextUtils.isEmpty(str)) {
                if (a(str)) {
                    if (this.f6688a != null) {
                        u.f("SplashAdCacheManager", "adSlot " + adSlot.getExpressViewAcceptedWidth() + "  " + adSlot.getExpressViewAcceptedHeight());
                        u.f(" SplashAdCacheManager", "循环请求广告 adSlot getCodeId " + adSlot.getCodeId());
                        this.f6688a.a(adSlot, mVar);
                    }
                } else if (b(this.f6689b)) {
                    u.f("SplashAdCacheManager", "还存在没有加载的开屏rit需要加载开屏");
                    a(this.f6689b);
                } else {
                    c(this.f6689b);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.sdk.openadsdk.component.splash.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0980a {

            /* renamed from: a  reason: collision with root package name */
            String f6691a;

            /* renamed from: b  reason: collision with root package name */
            AdSlot f6692b;
            m c;
            boolean d = false;

            C0980a(String str, AdSlot adSlot, m mVar) {
                this.f6691a = str;
                this.f6692b = adSlot;
                this.c = mVar;
            }

            public void a(boolean z) {
                this.d = z;
            }

            public boolean a() {
                return this.d;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AdSlot adSlot) {
            if (adSlot != null && this.f6689b != null) {
                u.f("SplashAdCacheManager", "SplashAdCacheManager 已经加载过了 adSlot.getCodeId() " + adSlot.getCodeId());
                C0980a c0980a = this.f6689b.get(adSlot.getCodeId());
                if (c0980a != null) {
                    c0980a.a(true);
                }
                u.f("SplashAdCacheManager", "SplashAdCacheManager 是否需要加载其他rit开屏广告");
                a(this.f6689b);
                if (!b(this.f6689b)) {
                    c(this.f6689b);
                }
            }
        }

        private boolean b(ConcurrentHashMap<String, C0980a> concurrentHashMap) {
            if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
                for (Map.Entry<String, C0980a> entry : concurrentHashMap.entrySet()) {
                    C0980a value = entry.getValue();
                    if (value != null && !value.a()) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }

        private void c(ConcurrentHashMap<String, C0980a> concurrentHashMap) {
            if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
                u.f("SplashAdCacheManager", "重置开屏rit请求状态");
                Iterator<Map.Entry<String, C0980a>> it = concurrentHashMap.entrySet().iterator();
                if (it != null) {
                    while (it.hasNext()) {
                        C0980a value = it.next().getValue();
                        if (value != null) {
                            value.a(false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
        l lVar;
        com.bytedance.sdk.openadsdk.core.d.k kVar;
        if (aVar == null || aVar.c() == null || aVar.c().size() == 0 || (lVar = aVar.c().get(0)) == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.d.k J = lVar.J();
        if (J != null) {
            kVar = J;
        } else if (lVar.M() == null || lVar.M().size() == 0) {
            return "";
        } else {
            kVar = lVar.M().get(0);
        }
        if (kVar == null) {
            return "";
        }
        return kVar.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(com.bytedance.sdk.openadsdk.core.d.a aVar) {
        com.bytedance.sdk.openadsdk.core.d.k kVar;
        if (aVar == null) {
            return -1;
        }
        if (aVar.c() == null || aVar.c().size() == 0) {
            return -1;
        }
        l lVar = aVar.c().get(0);
        if (lVar == null) {
            return -1;
        }
        com.bytedance.sdk.openadsdk.core.d.k J = lVar.J();
        if (J != null) {
            kVar = J;
        } else if (lVar.M() == null || lVar.M().size() == 0) {
            return -1;
        } else {
            kVar = lVar.M().get(0);
        }
        if (kVar == null) {
            return -1;
        }
        return kVar.b();
    }
}
