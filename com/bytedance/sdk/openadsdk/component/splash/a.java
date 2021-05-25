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
import com.bumptech.glide.load.engine.GlideException;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a implements am.a {

    /* renamed from: a  reason: collision with root package name */
    public static final Integer f27598a = 1;

    /* renamed from: b  reason: collision with root package name */
    public static final Integer f27599b = 2;

    /* renamed from: c  reason: collision with root package name */
    public static final Integer f27600c = 3;
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f27601d;

    /* renamed from: e  reason: collision with root package name */
    public Context f27602e;

    /* renamed from: i  reason: collision with root package name */
    public e f27606i;
    public f j;
    public C0288a n;

    /* renamed from: f  reason: collision with root package name */
    public final am f27603f = new am(Looper.getMainLooper(), this);

    /* renamed from: g  reason: collision with root package name */
    public final WeakHashMap<Integer, c> f27604g = new WeakHashMap<>();

    /* renamed from: h  reason: collision with root package name */
    public final WeakHashMap<Integer, d> f27605h = new WeakHashMap<>();
    public long k = 0;
    public long l = 0;
    public AtomicBoolean m = new AtomicBoolean(false);

    /* renamed from: com.bytedance.sdk.openadsdk.component.splash.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0288a {

        /* renamed from: a  reason: collision with root package name */
        public a f27616a;

        /* renamed from: b  reason: collision with root package name */
        public ConcurrentHashMap<String, C0289a> f27617b;

        /* renamed from: com.bytedance.sdk.openadsdk.component.splash.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public class C0289a {

            /* renamed from: a  reason: collision with root package name */
            public String f27619a;

            /* renamed from: b  reason: collision with root package name */
            public AdSlot f27620b;

            /* renamed from: c  reason: collision with root package name */
            public m f27621c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f27622d = false;

            public C0289a(String str, AdSlot adSlot, m mVar) {
                this.f27619a = str;
                this.f27620b = adSlot;
                this.f27621c = mVar;
            }

            public void a(boolean z) {
                this.f27622d = z;
            }

            public boolean a() {
                return this.f27622d;
            }
        }

        private boolean b(ConcurrentHashMap<String, C0289a> concurrentHashMap) {
            if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                return false;
            }
            for (Map.Entry<String, C0289a> entry : concurrentHashMap.entrySet()) {
                C0289a value = entry.getValue();
                if (value != null && !value.a()) {
                    return true;
                }
            }
            return false;
        }

        private void c(ConcurrentHashMap<String, C0289a> concurrentHashMap) {
            if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
                return;
            }
            u.f("SplashAdCacheManager", "重置开屏rit请求状态");
            Iterator<Map.Entry<String, C0289a>> it = concurrentHashMap.entrySet().iterator();
            if (it == null) {
                return;
            }
            while (it.hasNext()) {
                C0289a value = it.next().getValue();
                if (value != null) {
                    value.a(false);
                }
            }
        }

        public C0288a() {
            this.f27616a = a.a(p.a());
            this.f27617b = new ConcurrentHashMap<>();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AdSlot adSlot, m mVar) {
            int y;
            if (adSlot == null || mVar == null || !a()) {
                return;
            }
            if (!this.f27617b.containsKey(adSlot.getCodeId())) {
                u.f("SplashAdCacheManager", "add adSlot.getCodeId() " + adSlot.getCodeId());
                this.f27617b.put(adSlot.getCodeId(), new C0289a(adSlot.getCodeId(), adSlot, mVar));
            }
            if (!p.k() && (y = p.h().y()) > 0) {
                p.j();
                com.bytedance.sdk.openadsdk.l.e.d().scheduleWithFixedDelay(new g("timeLoopLoadAd") { // from class: com.bytedance.sdk.openadsdk.component.splash.a.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        u.f("SplashAdCacheManager", "触发定时器进行检测实现需要加载开屏广告");
                        C0288a c0288a = C0288a.this;
                        c0288a.a(c0288a.f27617b);
                    }
                }, 0L, (y * 60000) + 10000, TimeUnit.MILLISECONDS);
            }
        }

        private boolean a() {
            return p.h().x() == 1 && p.h().y() > 0;
        }

        private int a(long j) {
            if (j <= 0) {
                return 0;
            }
            long currentTimeMillis = System.currentTimeMillis() - j;
            if (currentTimeMillis <= 0) {
                return 0;
            }
            u.f("SplashAdCacheManager", "CircleLoadSplashAd getIntervalTime temp " + currentTimeMillis);
            return (int) (currentTimeMillis / 60000);
        }

        private boolean a(String str) {
            u.f("SplashAdCacheManager", "CircleLoadSplashAd isLoadSplashAd rit " + str);
            long b2 = k.b(str);
            u.f("SplashAdCacheManager", "CircleLoadSplashAd isLoadSplashAd lastLoadAdTime " + b2);
            return a(b2) >= p.h().y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(ConcurrentHashMap<String, C0289a> concurrentHashMap) {
            Map.Entry<String, C0289a> next;
            C0289a value;
            if (concurrentHashMap != null && concurrentHashMap.size() != 0) {
                Iterator<Map.Entry<String, C0289a>> it = concurrentHashMap.entrySet().iterator();
                if (it == null) {
                    return;
                }
                while (it.hasNext() && (next = it.next()) != null && (value = next.getValue()) != null) {
                    if (!value.a()) {
                        AdSlot adSlot = value.f27620b;
                        m mVar = value.f27621c;
                        u.f("SplashAdCacheManager", " loadSplashParamHashMapTest " + concurrentHashMap.size());
                        u.f("SplashAdCacheManager", "byRitLoadSplashAd 开始请求广告");
                        value.a(true);
                        a(next.getKey(), adSlot, mVar);
                        return;
                    }
                }
                return;
            }
            u.f("SplashAdCacheManager", "mloadSplashParaHashMap == null || mloadSplashParaHashMap.size() == 0 ");
        }

        private void a(String str, AdSlot adSlot, m mVar) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (a(str)) {
                if (this.f27616a != null) {
                    u.f("SplashAdCacheManager", "adSlot " + adSlot.getExpressViewAcceptedWidth() + GlideException.IndentedAppendable.INDENT + adSlot.getExpressViewAcceptedHeight());
                    StringBuilder sb = new StringBuilder();
                    sb.append("循环请求广告 adSlot getCodeId ");
                    sb.append(adSlot.getCodeId());
                    u.f(" SplashAdCacheManager", sb.toString());
                    this.f27616a.a(adSlot, mVar);
                }
            } else if (b(this.f27617b)) {
                u.f("SplashAdCacheManager", "还存在没有加载的开屏rit需要加载开屏");
                a(this.f27617b);
            } else {
                c(this.f27617b);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(AdSlot adSlot) {
            if (adSlot == null || this.f27617b == null) {
                return;
            }
            u.f("SplashAdCacheManager", "SplashAdCacheManager 已经加载过了 adSlot.getCodeId() " + adSlot.getCodeId());
            C0289a c0289a = this.f27617b.get(adSlot.getCodeId());
            if (c0289a != null) {
                c0289a.a(true);
            }
            u.f("SplashAdCacheManager", "SplashAdCacheManager 是否需要加载其他rit开屏广告");
            a(this.f27617b);
            if (b(this.f27617b)) {
                return;
            }
            c(this.f27617b);
        }
    }

    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f27624a = true;

        /* renamed from: b  reason: collision with root package name */
        public long f27625b = 0;

        /* renamed from: c  reason: collision with root package name */
        public long f27626c = 0;

        /* renamed from: d  reason: collision with root package name */
        public long f27627d = 0;
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a();

        void a(@NonNull com.bytedance.sdk.openadsdk.core.d.p pVar);
    }

    /* loaded from: classes6.dex */
    public interface d {
        void a();
    }

    /* loaded from: classes6.dex */
    public class e extends g {

        /* renamed from: b  reason: collision with root package name */
        public String f27629b;

        public e(String str) {
            super("ReadCacheTask");
            this.f27629b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            l lVar;
            Message obtainMessage = a.this.f27603f.obtainMessage();
            obtainMessage.what = 1;
            try {
                com.bytedance.sdk.openadsdk.core.d.a f2 = a.this.f(this.f27629b);
                com.bytedance.sdk.openadsdk.core.d.p pVar = new com.bytedance.sdk.openadsdk.core.d.p(f2, null, null);
                if (f2 != null && f2.c() != null && !f2.c().isEmpty() && (lVar = f2.c().get(0)) != null && lVar.aH()) {
                    String a2 = com.bytedance.sdk.openadsdk.i.a.a.a().a(a.this.a(f2), a.this.b(f2), a.this.b(f2), ImageView.ScaleType.CENTER_INSIDE);
                    com.bytedance.sdk.openadsdk.i.a.a.a();
                    String b2 = com.bytedance.sdk.openadsdk.i.a.a.b();
                    u.f("splashLoadAd", " readSplashAdFromCache 开始获取缓存文件 filePath " + b2);
                    File file = new File(b2, a2);
                    u.f("splashLoadAd", " readSplashAdFromCache path " + file.getPath());
                    if (file.exists() && file.isFile() && file.length() > 0) {
                        com.bytedance.sdk.openadsdk.i.a.b.f29209a = 1;
                        u.f("splashLoadAd", " readSplashAdFromCache 获取文件成功 cacheKey " + a2);
                        byte[] a3 = a(file);
                        if (a3 != null && a3.length != 0) {
                            pVar.a(lVar);
                            pVar.a(a3);
                        }
                    }
                    u.f("splashLoadAd", " readSplashAdFromCache 获取文件失败 " + file.getPath());
                    obtainMessage.obj = null;
                    a.this.f27603f.sendMessage(obtainMessage);
                    return;
                }
                obtainMessage.obj = pVar;
            } catch (Throwable unused) {
            }
            a.this.f27603f.sendMessage(obtainMessage);
            try {
                u.f("splashLoadAd", "获取缓存广告之后将其清空 clearCache " + this.f27629b);
                a.this.d(this.f27629b);
            } catch (Throwable unused2) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(String str) {
            this.f27629b = str;
        }

        private byte[] a(File file) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            FileInputStream fileInputStream = null;
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    while (true) {
                        try {
                            int read = fileInputStream2.read(bArr, 0, 1024);
                            if (read == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        } catch (Exception unused) {
                            fileInputStream = fileInputStream2;
                            byteArrayOutputStream.close();
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return byteArrayOutputStream.toByteArray();
                        } catch (Throwable th) {
                            th = th;
                            fileInputStream = fileInputStream2;
                            try {
                                byteArrayOutputStream.close();
                                if (fileInputStream != null) {
                                    fileInputStream.close();
                                }
                            } catch (IOException unused2) {
                            }
                            throw th;
                        }
                    }
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            } catch (Exception unused4) {
            } catch (Throwable th2) {
                th = th2;
            }
            return byteArrayOutputStream.toByteArray();
        }
    }

    /* loaded from: classes6.dex */
    public class f extends g {

        /* renamed from: b  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.core.d.p f27631b;

        public f(com.bytedance.sdk.openadsdk.core.d.p pVar) {
            super("WriteCacheTask");
            this.f27631b = pVar;
        }

        public void a(com.bytedance.sdk.openadsdk.core.d.p pVar) {
            this.f27631b = pVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
        }

        private void a() {
            int c2;
            if (a.this.f27603f == null) {
                return;
            }
            Message obtainMessage = a.this.f27603f.obtainMessage();
            obtainMessage.what = 3;
            try {
                c2 = com.bytedance.sdk.openadsdk.component.splash.c.c(this.f27631b);
            } catch (Throwable unused) {
            }
            if (c2 > 0) {
                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                    com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_materialMeta", "materialMeta" + c2, this.f27631b.c().d());
                } else {
                    SharedPreferences.Editor edit = p.a().getSharedPreferences("tt_materialMeta", 0).edit();
                    edit.putString("materialMeta" + c2, this.f27631b.c().d()).apply();
                    a.this.f27603f.sendMessage(obtainMessage);
                    return;
                }
            }
            a.this.f27603f.sendMessage(obtainMessage);
        }
    }

    public a(Context context) {
        if (context != null) {
            this.f27602e = context.getApplicationContext();
        }
    }

    private void c(com.bytedance.sdk.openadsdk.core.d.p pVar) {
        f fVar = this.j;
        if (fVar == null) {
            this.j = new f(pVar);
        } else {
            fVar.a(pVar);
        }
        com.bytedance.sdk.openadsdk.l.e.a(this.j, 10);
    }

    private g e(String str) {
        e eVar = this.f27606i;
        if (eVar != null) {
            eVar.a(str);
        } else {
            this.f27606i = new e(str);
        }
        return this.f27606i;
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
            SharedPreferences sharedPreferences = b().getSharedPreferences("tt_materialMeta", 0);
            string = sharedPreferences.getString("materialMeta" + str, null);
        }
        if (!TextUtils.isEmpty(string)) {
            try {
                r.a a2 = r.a.a(new JSONObject(string));
                if (a2 != null && a2.f28354h != null) {
                    return a2.f28354h;
                }
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_materialMeta", "materialMeta" + str);
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "has_ad_cache" + str);
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "has_video_ad_cache" + str);
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "expiration" + str);
            com.bytedance.sdk.openadsdk.multipro.d.a.c("tt_splash", "expiration" + str);
            return;
        }
        SharedPreferences.Editor edit = b().getSharedPreferences("tt_materialMeta", 0).edit();
        edit.remove("materialMeta" + str).apply();
        SharedPreferences.Editor edit2 = b().getSharedPreferences("tt_splash", 0).edit();
        SharedPreferences.Editor remove = edit2.remove("has_ad_cache" + str);
        SharedPreferences.Editor remove2 = remove.remove("has_video_ad_cache" + str);
        SharedPreferences.Editor remove3 = remove2.remove("expiration" + str);
        remove3.remove("expiration" + str).apply();
    }

    private Context b() {
        Context context = this.f27602e;
        return context != null ? context : p.a();
    }

    public static a a(Context context) {
        if (f27601d == null) {
            synchronized (a.class) {
                if (f27601d == null) {
                    f27601d = new a(context);
                }
            }
        }
        return f27601d;
    }

    public void b(com.bytedance.sdk.openadsdk.core.d.p pVar) {
        int c2 = com.bytedance.sdk.openadsdk.component.splash.c.c(pVar);
        if (c2 <= 0) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_video_ad_cache" + c2, Boolean.TRUE);
            return;
        }
        SharedPreferences.Editor edit = b().getSharedPreferences("tt_splash", 0).edit();
        edit.putBoolean("has_video_ad_cache" + c2, true).apply();
    }

    @NonNull
    public b c(String str) {
        b bVar = new b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        boolean z = true;
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            long a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "expiration" + str, 0L);
            long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", IMTrack.DbBuilder.ACTION_UPDATE + str, 0L);
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis >= a3 && currentTimeMillis < a2) {
                z = false;
            }
            bVar.f27624a = z;
            bVar.f27625b = a3;
            bVar.f27626c = a2;
            bVar.f27627d = currentTimeMillis;
            return bVar;
        }
        SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
        long j = sharedPreferences.getLong("expiration" + str, 0L);
        long j2 = sharedPreferences.getLong(IMTrack.DbBuilder.ACTION_UPDATE + str, 0L);
        long currentTimeMillis2 = System.currentTimeMillis() / 1000;
        if (currentTimeMillis2 >= j2 && currentTimeMillis2 < j) {
            z = false;
        }
        bVar.f27624a = z;
        bVar.f27625b = j2;
        bVar.f27626c = j;
        bVar.f27627d = currentTimeMillis2;
        return bVar;
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.p pVar) {
        int c2;
        if (pVar != null && (c2 = com.bytedance.sdk.openadsdk.component.splash.c.c(pVar)) > 0) {
            a(c2, pVar.a().at());
            c(pVar);
        }
    }

    public void b(String str, @NonNull c cVar) {
        if (TextUtils.isEmpty(str)) {
            cVar.a();
            return;
        }
        this.f27604g.put(f27598a, cVar);
        com.bytedance.sdk.openadsdk.l.e.a(e(str), 10);
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.p pVar, @NonNull d dVar) {
        if (dVar == null) {
            return;
        }
        this.f27605h.put(f27600c, dVar);
        a(pVar);
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_video_ad_cache" + str, false);
        }
        SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
        return sharedPreferences.getBoolean("has_video_ad_cache" + str, false);
    }

    private void a(int i2, long j) {
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "expiration" + i2, Long.valueOf(j));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", IMTrack.DbBuilder.ACTION_UPDATE + i2, Long.valueOf(System.currentTimeMillis() / 1000));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_ad_cache" + i2, Boolean.TRUE);
            return;
        }
        SharedPreferences.Editor edit = b().getSharedPreferences("tt_splash", 0).edit();
        SharedPreferences.Editor putLong = edit.putLong("expiration" + i2, j);
        SharedPreferences.Editor putLong2 = putLong.putLong(IMTrack.DbBuilder.ACTION_UPDATE + i2, System.currentTimeMillis() / 1000);
        putLong2.putBoolean("has_ad_cache" + i2, true).apply();
    }

    public void b(AdSlot adSlot, m mVar) {
        if (adSlot == null || mVar == null) {
            return;
        }
        if (this.n == null) {
            this.n = new C0288a();
        }
        this.n.a(adSlot, mVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(com.bytedance.sdk.openadsdk.core.d.a aVar) {
        l lVar;
        if (aVar == null || aVar.c() == null || aVar.c().size() == 0 || (lVar = aVar.c().get(0)) == null) {
            return -1;
        }
        com.bytedance.sdk.openadsdk.core.d.k ab = lVar.ab();
        if (ab == null) {
            if (lVar.af() == null || lVar.af().size() == 0) {
                return -1;
            }
            ab = lVar.af().get(0);
        }
        if (ab == null) {
            return -1;
        }
        return ab.b();
    }

    private void c(final AdSlot adSlot, m mVar) {
        if (this.m.getAndSet(true)) {
            u.b("splashLoad", "已在预加载开屏广告....不再发出");
            return;
        }
        if ((p.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) && mVar != null) {
            mVar.f27913e = 2;
        }
        p.f().a(adSlot, mVar, 4, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.splash.a.3
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i2, String str) {
                u.b("splashLoad", "广告物料预加载失败...." + str + i2);
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(i2);
                u.b("SplashAdCacheManager", sb.toString());
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
                    if (lVar.aH()) {
                        final boolean z = lVar.X() != null;
                        com.bytedance.sdk.openadsdk.core.d.k ab = lVar.ab();
                        if (ab == null) {
                            ab = lVar.af().get(0);
                        }
                        String a2 = ab.a();
                        int b2 = ab.b();
                        a.this.k = System.currentTimeMillis();
                        com.bytedance.sdk.openadsdk.component.splash.c.a(lVar, z ? 2 : 0);
                        a.this.l = SystemClock.elapsedRealtime();
                        com.bytedance.sdk.openadsdk.core.d.r b3 = com.bytedance.sdk.openadsdk.i.e.c().g().b();
                        if (b3 != null) {
                            b3.b(false);
                        }
                        o.a(a.this.f27602e, a2, b2, new o.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.a.3.1
                            @Override // com.bytedance.sdk.openadsdk.utils.o.a
                            @MainThread
                            public void a(@NonNull com.bytedance.sdk.openadsdk.i.a.d dVar) {
                                com.bytedance.sdk.openadsdk.component.splash.c.a(aVar);
                                if (!z) {
                                    com.bytedance.sdk.openadsdk.c.d.a(lVar, "splash_ad", System.currentTimeMillis() - a.this.k);
                                }
                                a.this.k = 0L;
                                u.b("SplashAdCacheManager", "图片数据加载的广告缓存到本地");
                                u.b("splashLoad", "预加载成功，广告缓存到本地----10");
                                a.a(a.this.f27602e).a(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, dVar.b()));
                                if (z) {
                                    com.bytedance.sdk.openadsdk.component.splash.c.a(a.this.l, false, true, lVar, 0L, null);
                                }
                                a.this.m.set(false);
                                if (a.this.n != null) {
                                    a.this.n.a(adSlot);
                                }
                            }

                            @Override // com.bytedance.sdk.openadsdk.utils.o.a
                            public void b() {
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
                                if (a.this.n != null) {
                                    a.this.n.a(adSlot);
                                }
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

    public void a(final String str, @NonNull c cVar) {
        this.f27604g.put(f27599b, cVar);
        if (TextUtils.isEmpty(str)) {
            Message obtainMessage = this.f27603f.obtainMessage();
            obtainMessage.what = 2;
            this.f27603f.sendMessage(obtainMessage);
            return;
        }
        com.bytedance.sdk.openadsdk.l.e.a(new g("readSplashMaterialMeta") { // from class: com.bytedance.sdk.openadsdk.component.splash.a.1
            @Override // java.lang.Runnable
            public void run() {
                l lVar;
                u.b("TTExecutor", "readSplashMaterialMeta....->run....");
                Message obtainMessage2 = a.this.f27603f.obtainMessage();
                obtainMessage2.what = 2;
                try {
                    com.bytedance.sdk.openadsdk.core.d.a f2 = a.this.f(str);
                    com.bytedance.sdk.openadsdk.core.d.p pVar = new com.bytedance.sdk.openadsdk.core.d.p(f2, null, null);
                    if (f2 != null && f2.c() != null && !f2.c().isEmpty() && (lVar = f2.c().get(0)) != null) {
                        pVar.a(lVar);
                    }
                    obtainMessage2.obj = pVar;
                } catch (Throwable unused) {
                }
                a.this.f27603f.sendMessage(obtainMessage2);
                a.this.d(str);
            }
        }, 10);
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            return com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_splash", "has_ad_cache" + str, false);
        }
        SharedPreferences sharedPreferences = b().getSharedPreferences("tt_splash", 0);
        return sharedPreferences.getBoolean("has_ad_cache" + str, false);
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
            i.d().r().a(file);
        } catch (IOException e2) {
            u.f("SplashAdCacheManager", "trimFileCache IOException:" + e2.toString());
        }
    }

    public String a(l lVar) {
        if (lVar == null || lVar.X() == null || TextUtils.isEmpty(lVar.X().i())) {
            return null;
        }
        return a(lVar.X().i(), lVar.X().l(), String.valueOf(ak.d(lVar.ap())));
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
        File a3 = com.bytedance.sdk.openadsdk.component.splash.c.a(this.f27602e, a2, str2);
        if (a3 != null && a3.exists() && a3.isFile()) {
            u.f("splashLoadAd", "getVideoPath  file.getAbsolutePath() " + a3.getAbsolutePath());
            return a3.getAbsolutePath();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        WeakHashMap<Integer, d> weakHashMap;
        d remove;
        int i2 = message.what;
        if (i2 == 1) {
            c remove2 = this.f27604g.remove(f27598a);
            if (remove2 != null) {
                Object obj = message.obj;
                if (obj != null && (obj instanceof com.bytedance.sdk.openadsdk.core.d.p)) {
                    remove2.a((com.bytedance.sdk.openadsdk.core.d.p) obj);
                    u.b("SplashAdCacheManager", "缓存反序列化成功");
                } else {
                    remove2.a();
                    u.b("SplashAdCacheManager", "缓存反序列化失败");
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("OnLoadCacheCallback is null: ");
            sb.append(remove2 == null);
            u.b("SplashAdCacheManager", sb.toString());
            this.f27603f.removeCallbacksAndMessages(null);
        } else if (i2 != 2) {
            if (i2 != 3 || (weakHashMap = this.f27605h) == null || (remove = weakHashMap.remove(f27600c)) == null) {
                return;
            }
            remove.a();
        } else {
            c remove3 = this.f27604g.remove(f27599b);
            if (remove3 != null) {
                Object obj2 = message.obj;
                if (obj2 != null && (obj2 instanceof com.bytedance.sdk.openadsdk.core.d.p)) {
                    remove3.a((com.bytedance.sdk.openadsdk.core.d.p) obj2);
                    u.b("SplashAdCacheManager", "视频物料缓存反序列化成功");
                } else {
                    remove3.a();
                    u.b("SplashAdCacheManager", "视频物料缓存反序列化失败");
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("OnLoadCacheCallback is null: ");
            sb2.append(remove3 == null);
            u.b("SplashAdCacheManager", sb2.toString());
            this.f27603f.removeCallbacksAndMessages(null);
        }
    }

    public boolean a(AdSlot adSlot, boolean z) {
        b c2 = a(this.f27602e).c(adSlot.getCodeId());
        if (z && c2.f27624a) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("available_type", 0);
                jSONObject.putOpt("creative_timeout_duration", Long.valueOf((c2.f27627d - c2.f27625b) / 3600));
                com.bytedance.sdk.openadsdk.h.a.a().n(com.bytedance.sdk.openadsdk.h.a.c.b().a(4).c(adSlot.getCodeId()).b(jSONObject.toString()));
            } catch (Throwable unused) {
            }
        }
        return c2.f27624a;
    }

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
        } catch (Throwable unused) {
        }
        try {
            if (("mounted".equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) && b().getExternalCacheDir() != null) {
                externalCacheDir = b().getExternalCacheDir();
            } else {
                externalCacheDir = b().getCacheDir();
            }
            if (externalCacheDir == null || !externalCacheDir.exists() || !externalCacheDir.isDirectory() || (listFiles = externalCacheDir.listFiles(new FileFilter() { // from class: com.bytedance.sdk.openadsdk.component.splash.a.2
                @Override // java.io.FileFilter
                public boolean accept(File file) {
                    if (file != null) {
                        String name = file.getName();
                        return name.contains("splash_ad_cache") || name.contains("splash_video_cache");
                    }
                    return false;
                }
            })) == null || listFiles.length <= 0) {
                return;
            }
            for (File file : listFiles) {
                try {
                    com.bytedance.sdk.openadsdk.utils.l.c(file);
                } catch (Throwable unused2) {
                }
            }
        } catch (Throwable unused3) {
        }
    }

    public void a(AdSlot adSlot, m mVar) {
        if (p.h().s() && adSlot != null && TextUtils.isEmpty(adSlot.getBidAdm())) {
            m mVar2 = mVar == null ? new m() : mVar.a();
            mVar2.f27914f = System.currentTimeMillis();
            c(adSlot, mVar2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
        l lVar;
        if (aVar == null || aVar.c() == null || aVar.c().size() == 0 || (lVar = aVar.c().get(0)) == null) {
            return "";
        }
        com.bytedance.sdk.openadsdk.core.d.k ab = lVar.ab();
        if (ab == null) {
            if (lVar.af() == null || lVar.af().size() == 0) {
                return "";
            }
            ab = lVar.af().get(0);
        }
        return ab == null ? "" : ab.a();
    }
}
