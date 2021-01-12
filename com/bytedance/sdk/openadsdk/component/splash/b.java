package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.bytedance.sdk.adnet.b.b;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.component.splash.a;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.d.o;
import com.bytedance.sdk.openadsdk.core.d.s;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b implements am.a {
    private static Set<b> j = Collections.synchronizedSet(new HashSet());
    private a A;

    /* renamed from: a  reason: collision with root package name */
    private AdSlot f6400a;

    /* renamed from: b  reason: collision with root package name */
    private m f6401b;
    private final q d;
    private Context e;
    private final am f;
    private e h;
    private e i;
    private com.bytedance.sdk.openadsdk.component.splash.a k;
    private boolean o;
    private long p;
    private long q;
    private com.bytedance.sdk.openadsdk.core.d.a u;
    private com.bytedance.sdk.openadsdk.core.d.a v;
    private com.bytedance.sdk.openadsdk.h.a.d w;
    private TTAdNative.SplashAdListener c = null;
    private final AtomicBoolean g = new AtomicBoolean(false);
    private AtomicBoolean l = new AtomicBoolean(false);
    private AtomicBoolean m = new AtomicBoolean(false);
    private AtomicBoolean n = new AtomicBoolean(false);
    private long r = 0;
    private final AtomicBoolean s = new AtomicBoolean(false);
    private final AtomicBoolean t = new AtomicBoolean(false);
    private int x = 4;
    private AtomicBoolean y = new AtomicBoolean(false);
    private AtomicBoolean z = new AtomicBoolean(false);

    public static b a(Context context) {
        return new b(context);
    }

    private b(Context context) {
        if (context != null) {
            this.e = context.getApplicationContext();
        }
        this.d = p.f();
        this.f = new am(Looper.myLooper(), this);
        this.k = com.bytedance.sdk.openadsdk.component.splash.a.a(this.e != null ? this.e : p.a());
        this.o = p.h().v();
        j.add(this);
    }

    public void a(AdSlot adSlot, @NonNull TTAdNative.SplashAdListener splashAdListener, int i) {
        this.f6400a = adSlot;
        this.c = splashAdListener;
        this.g.set(false);
        this.h = null;
        this.i = null;
        long j2 = i;
        int c = p.h().c(adSlot.getCodeId());
        if (c != -1) {
            i = c;
        }
        u.f("splashLoadAd", "getSplashAd timeOut " + i);
        if (i <= 3000) {
            i = 3000;
        }
        this.f.sendEmptyMessageDelayed(2, i);
        int i2 = i - 300;
        if (i2 > 0) {
            i = i2;
        }
        this.f.sendEmptyMessageDelayed(3, i);
        this.f6401b = new m();
        this.f6401b.f = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("publisher_timeout_control", j2);
        } catch (Throwable th) {
        }
        com.bytedance.sdk.openadsdk.h.a.a().b(com.bytedance.sdk.openadsdk.h.a.d.b().a(3).c(this.f6400a.getCodeId()).f(this.f6401b.f6513a).b(jSONObject.toString()));
        b();
        a();
    }

    private void a() {
        if (this.k != null) {
            this.k.b(this.f6400a, this.f6401b);
        }
    }

    private void b() {
        if (this.c != null) {
            switch (p.h().s()) {
                case 0:
                    this.s.set(false);
                    this.t.set(false);
                    u.b("splashLoadAd", "splash_type_real_time=====只走实时");
                    a(this.f6400a);
                    return;
                case 1:
                    this.s.set(false);
                    this.t.set(false);
                    u.b("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存");
                    if (!c()) {
                        u.c("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存失败，进行网络请求");
                        a(this.f6400a);
                        return;
                    }
                    u.c("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存成功！！");
                    return;
                case 2:
                    u.b("splashLoadAd", "splash_type_concurrent_priority_real_time=====并发请求广告和check缓存，优先使用实时");
                    this.s.set(true);
                    this.t.set(false);
                    a(this.f6400a);
                    c();
                    return;
                case 3:
                    this.s.set(false);
                    this.t.set(true);
                    u.b("splashLoadAd", "splash_type_concurrent_first_come_first_use=====并发请求广告和check缓存，谁先到用谁");
                    a(this.f6400a);
                    c();
                    return;
                default:
                    return;
            }
        }
    }

    private boolean c() {
        if (d()) {
            a(15001);
            return true;
        }
        return false;
    }

    private boolean d() {
        u.f("splashLoadAd", "try checkSpashAdCacheIsValidAndTryShowAd......");
        com.bytedance.sdk.openadsdk.h.a.d a2 = a(15001, (o) null);
        if (!this.k.b(this.f6400a.getCodeId()) && !this.k.a(this.f6400a.getCodeId())) {
            u.f("splashLoadAd", "没有缓存数据..........");
            if (this.s.get() || this.t.get()) {
                a(15001, new a(2, -12, h.a(-12), null, a2), (o) null, (e) null, (String) null);
            }
            return false;
        } else if (this.k.a(this.f6400a, true)) {
            c.a(this.e, this.f6400a);
            u.b("splashLoadAd", "======== 缓存过期 ========");
            if (this.s.get() || this.t.get()) {
                a(15001, new a(2, -11, h.a(-11), null, a2), (o) null, (e) null, (String) null);
            }
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        int s = p.h().s();
        return (2 == s || 3 == s) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i) {
        u.f("splashLoadAd", "tryDisplaySplashAdFromCache");
        if (this.k.b(this.f6400a.getCodeId())) {
            this.k.a(this.f6400a.getCodeId(), new a.c() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.1
                @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                public void a(@NonNull o oVar) {
                    if (oVar.a() != null && oVar.a().F() != null && oVar.a().F().h() != null) {
                        String a2 = b.this.k.a(oVar.a());
                        if (a2 == null) {
                            u.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess videoPath == null tryDisplaySplashImageFromCache");
                            b.this.f();
                            return;
                        }
                        u.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess videoPath " + a2);
                        com.bytedance.sdk.openadsdk.h.a.d a3 = b.this.a(4, oVar);
                        e a4 = b.this.a(oVar, a2);
                        b.this.n.set(oVar.a().B() == null);
                        if (b.this.o) {
                            b.this.a(oVar, a4, a2);
                        } else {
                            b.this.l.set(true);
                            u.c("splashLoadAd", "不检测直接返回缓存....splashAd=" + a4);
                            u.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess 加载视频缓存");
                            b.this.a(i, new a(1, 0, null, a4, a3), oVar, a4, a2);
                        }
                        if (oVar.a().B() != null) {
                            b.this.a(oVar, a4, a2, a3);
                            return;
                        }
                        return;
                    }
                    u.f("splashLoadAd", "tryDisplaySplashAdFromCache videoPath == null tryDisplaySplashImageFromCache");
                    b.this.f();
                }

                @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                public void a() {
                    b.this.f();
                }
            });
        } else {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.h.a.d a(int i, o oVar) {
        String str;
        String str2;
        String str3;
        if (oVar == null || oVar.a() == null) {
            str = null;
            str2 = null;
            str3 = null;
        } else {
            str3 = oVar.a().T();
            str2 = oVar.a().W();
            if (TextUtils.isEmpty(str2)) {
                str = null;
            } else {
                try {
                    str = new JSONObject(str2).getString("req_id");
                } catch (Throwable th) {
                    str = null;
                }
            }
        }
        if (str == null) {
            str = this.f6401b.f6513a;
        }
        com.bytedance.sdk.openadsdk.h.a.d c = com.bytedance.sdk.openadsdk.h.a.d.b().f(str).a(i).c(this.f6400a.getCodeId());
        if (str3 != null) {
            c.d(str3);
        }
        if (str2 != null) {
            c.h(str2);
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.k.b(this.f6400a.getCodeId(), new a.c() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.4
            @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
            public void a(@NonNull o oVar) {
                com.bytedance.sdk.openadsdk.h.a.d a2 = b.this.a(4, oVar);
                if (!c.b(oVar)) {
                    if (!b.this.e()) {
                        b.this.a(15001, new a(2, 0, null, null, a2), oVar, (e) null, (String) null);
                        return;
                    }
                    u.b("SplashAdLoadManager", "缓存广告素材解析出错");
                    b.this.a(b.this.f6400a);
                    return;
                }
                oVar.a().c(true);
                oVar.a().d(false);
                b.this.n.set(oVar.a().B() == null);
                e a3 = b.this.a(oVar, (String) null);
                if (b.this.o) {
                    b.this.a(oVar, a3, (String) null);
                } else {
                    u.c("splashLoadAd", ".....不检测直接返回缓存....");
                    b.this.l.set(true);
                    b.this.a(15001, new a(1, 0, null, a3, a2), oVar, a3, (String) null);
                }
                if (oVar.a().B() != null) {
                    b.this.a(oVar, a3, (String) null, a2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
            public void a() {
                u.b("splashLoadAd", "缓存广告对象解析出错");
                if (b.this.e()) {
                    b.this.a(b.this.f6400a);
                    return;
                }
                b.this.a(15001, new a(2, 0, null, null, b.this.a(4, (o) null)), (o) null, (e) null, (String) null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        u.f("splashLoadAd", "try LoadSplashAdFromNetwork......");
        final com.bytedance.sdk.openadsdk.h.a.d a2 = a(3, (o) null);
        if (p.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
            this.f6401b.e = 2;
        }
        this.d.a(adSlot, this.f6401b, 3, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.5
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                a2.b(i).g(str);
                if (i == 20001) {
                    b.this.x = 1;
                } else {
                    b.this.x = 0;
                }
                u.b("splashLoadAd", "tryLoadSplashAdFromNetwork REQUEST_TYPE_REAL_NETWORK onError" + i + ",msg=" + h.a(i));
                b.this.a((int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, new a(2, i, str, null, a2), (o) null, (e) null, (String) null);
                u.b("splashLoadAd", str + i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                if (aVar != null) {
                    a2.f(aVar.a());
                }
                if (!c.b(aVar)) {
                    b.this.x = 1;
                    a2.b(-3).g(h.a(-3));
                    a aVar2 = new a(2, -3, h.a(-3), null, a2);
                    u.b("splashLoadAd", "tryLoadSplashAdFromNetwork 网络请求的广告解析失败 REQUEST_TYPE_REAL_NETWORK");
                    b.this.a((int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, aVar2, (o) null, (e) null, (String) null);
                    u.b("SplashAdLoadManager", "网络请求的广告解析失败");
                    return;
                }
                l lVar = aVar.c().get(0);
                String W = lVar.W();
                String T = lVar.T();
                b.this.v = aVar;
                if (!TextUtils.isEmpty(W)) {
                    a2.h(W).d(T);
                    try {
                        a2.f(new JSONObject(W).getString("req_id"));
                    } catch (Throwable th) {
                    }
                }
                u.f("splashLoadAd", "tryLoadSplashAdFromNetwork splashAdMeta.isValid() " + lVar.ai());
                if (lVar.ai()) {
                    b.this.p = 0L;
                    int n = lVar.n();
                    int p = lVar.p();
                    k.a(p);
                    u.f("splashLoadAd", " 开屏素材存储是否是内部存储还是外部存储 storageFrom " + p);
                    u.f("splashLoadAd", "tryLoadSplashAdFromNetwork cacheSort " + n);
                    if (n == 1) {
                        b.this.a(aVar, b.this.e, a2);
                        return;
                    } else {
                        b.this.b(aVar, b.this.e, a2);
                        return;
                    }
                }
                a2.b(-3).g(h.a(-3));
                a aVar3 = new a(2, -3, h.a(-3), null, a2);
                u.b("splashLoadAd", "tryLoadSplashAdFromNetwork not splashAdMeta.isValid() REQUEST_TYPE_REAL_NETWORK");
                b.this.x = 1;
                b.this.a((int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, aVar3, (o) null, (e) null, (String) null);
                u.b("SplashAdLoadManager", "网络请求的广告解析失败");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.bytedance.sdk.openadsdk.core.d.a aVar, Context context, final com.bytedance.sdk.openadsdk.h.a.d dVar) {
        u.f("splashLoadAd", " SplashUtils preLoadImage");
        if (c.b(aVar) && context != null) {
            final l lVar = aVar.c().get(0);
            com.bytedance.sdk.openadsdk.core.d.k J = lVar.J();
            if (J == null) {
                J = lVar.M().get(0);
            }
            final String a2 = J.a();
            int b2 = J.b();
            final boolean z = lVar.F() != null;
            this.q = System.currentTimeMillis();
            this.r = SystemClock.elapsedRealtime();
            c.a(lVar, z ? 2 : 0);
            com.bytedance.sdk.openadsdk.utils.o.a(context, a2, b2, new o.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.6
                @Override // com.bytedance.sdk.openadsdk.utils.o.a
                @MainThread
                public void a(@NonNull byte[] bArr) {
                    u.f("splashLoadAd", "图片加载成功");
                    c.a(aVar);
                    c.a(lVar);
                    if (!z) {
                        com.bytedance.sdk.openadsdk.c.d.a(lVar, "splash_ad", "download_creative_duration", System.currentTimeMillis() - b.this.q);
                    }
                    if (bArr == null) {
                        b.this.x = 3;
                        c.a(dVar, a2);
                        dVar.b(-7).g(h.a(-7));
                        a aVar2 = new a(2, -7, h.a(-7), null, dVar);
                        u.b("splashLoadAd", "preLoadImage  data == null REQUEST_TYPE_REAL_NETWORK");
                        b.this.x = 3;
                        b.this.a((int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, aVar2, (com.bytedance.sdk.openadsdk.core.d.o) null, (e) null, (String) null);
                        if (z) {
                            c.a(b.this.r, false, false, lVar, -7, null);
                        }
                        u.b("SplashAdLoadManager", "图片加载失败");
                        return;
                    }
                    lVar.d(false);
                    e eVar = new e(b.this.e, lVar, b.this.f6400a, "splash_ad");
                    b.this.i = eVar;
                    eVar.a(bArr);
                    b.this.m.set(lVar.B() == null);
                    b.this.a((int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, new a(1, 0, null, eVar, dVar), (com.bytedance.sdk.openadsdk.core.d.o) null, eVar, (String) null);
                    b.this.b((com.bytedance.sdk.openadsdk.core.d.o) null, eVar, (String) null, dVar);
                    if (z) {
                        c.a(b.this.r, false, true, lVar, 0L, null);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.utils.o.a
                @MainThread
                public void a() {
                    c.a(aVar);
                    b.this.x = 3;
                    c.a(dVar, a2);
                    dVar.b(-7).g(h.a(-7));
                    u.b("splashLoadAd", "splashLoad----5-LoadImageBytes-onFailed-code=-7,msg=" + h.a(-7));
                    b.this.a((int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, new a(2, -7, h.a(-7), null, dVar), (com.bytedance.sdk.openadsdk.core.d.o) null, (e) null, (String) null);
                    if (z) {
                        c.a(b.this.r, false, false, lVar, -7L, null);
                    }
                    u.b("SplashAdLoadManager", "图片加载失败");
                }
            }, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.bytedance.sdk.openadsdk.core.d.a aVar, Context context, final com.bytedance.sdk.openadsdk.h.a.d dVar) {
        u.f("splashLoadAd", " SplashUtils preLoadVideo");
        if (c.b(aVar) && context != null) {
            final l lVar = aVar.c().get(0);
            int d = aj.d(lVar.W());
            s F = lVar.F();
            c.a(lVar, F != null ? 2 : 0);
            if (F != null) {
                final long elapsedRealtime = SystemClock.elapsedRealtime();
                String h = F.h();
                u.f("splashLoadAd", "SplashUtils preLoadVideo videoUrl " + h);
                if (h == null) {
                    a(aVar, context, dVar);
                    return;
                }
                this.u = aVar;
                this.w = dVar;
                c.a(lVar, 1);
                final String k = F.k();
                if (TextUtils.isEmpty(k)) {
                    k = j.a(h);
                }
                final File a2 = c.a(p.a(), com.bytedance.sdk.openadsdk.component.splash.a.a(p.a()).a(String.valueOf(d), com.bytedance.sdk.openadsdk.multipro.b.b()), k);
                if (p.h().e(String.valueOf(d)) && !x.d(p.a())) {
                    if (k != null && a2.exists()) {
                        u.b("splashLoadAd", "非wifi环境，已缓存相同url的视频文件也是可以播放的");
                        com.bytedance.sdk.openadsdk.component.splash.a.a(p.a()).b(new com.bytedance.sdk.openadsdk.core.d.o(aVar, lVar, null));
                        a(BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
                        return;
                    }
                    u.b("splashLoadAd", "非wifi环境");
                    return;
                }
                com.bytedance.sdk.openadsdk.i.e.a(p.a()).a(h, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.7
                    @Override // com.bytedance.sdk.adnet.b.b.a
                    public File a(String str) {
                        try {
                            File parentFile = a2.getParentFile();
                            if (parentFile != null && parentFile.exists()) {
                                u.b("splashLoadAd", "SplashAdLoadManager getFile " + str);
                                c.a(a2);
                                return i.c().p().a(k, parentFile);
                            }
                        } catch (IOException e) {
                            u.f("splashLoadAd", "datastoreGet throw IOException : " + e.toString());
                        }
                        return null;
                    }

                    @Override // com.bytedance.sdk.adnet.b.b.a
                    public void a(String str, File file) {
                        if (file != null) {
                            u.b("splashLoadAd", "SplashAdLoadManager 视频文件下载成功保存到本地 putFile s " + str + " File " + file.getPath());
                            c.a(file);
                            com.bytedance.sdk.openadsdk.component.splash.a.a(p.a()).a(file);
                        }
                    }

                    @Override // com.bytedance.sdk.adnet.b.b.a
                    public File b(String str) {
                        return a2;
                    }

                    @Override // com.bytedance.sdk.adnet.b.c.a
                    public void a(long j2, long j3) {
                    }

                    @Override // com.bytedance.sdk.adnet.core.p.a
                    public void a(com.bytedance.sdk.adnet.core.p<File> pVar) {
                        if (pVar == null || pVar.f6045a == null) {
                            b.this.x = 3;
                            dVar.b(-14).g(h.a(-14));
                            a aVar2 = new a(2, -14, h.a(-14), null, dVar);
                            u.f("splashLoadAd", "视频文件缓存失败 response == null REQUEST_TYPE_REAL_NETWORK");
                            b.this.a((int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, aVar2, (com.bytedance.sdk.openadsdk.core.d.o) null, (e) null, (String) null);
                            c.a(elapsedRealtime, true, false, lVar, pVar == null ? -3L : pVar.h, pVar);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.component.splash.a.a(p.a()).b(new com.bytedance.sdk.openadsdk.core.d.o(aVar, lVar, null));
                        u.f("splashLoadAd", "视频文件获取成功, 尝试加载视频开屏");
                        com.bytedance.sdk.openadsdk.component.splash.a.a(p.a()).a(new com.bytedance.sdk.openadsdk.core.d.o(aVar, lVar, null), new a.d() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.7.1
                            @Override // com.bytedance.sdk.openadsdk.component.splash.a.d
                            public void a() {
                                b.this.a((int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL);
                            }
                        });
                        c.a(elapsedRealtime, true, true, lVar, 0L, pVar);
                    }

                    @Override // com.bytedance.sdk.adnet.core.p.a
                    public void b(com.bytedance.sdk.adnet.core.p<File> pVar) {
                        b.this.x = 3;
                        c.a(elapsedRealtime, true, false, lVar, pVar == null ? -2L : pVar.h, pVar);
                        dVar.b(-14).g(h.a(-14));
                        a aVar2 = new a(2, -14, h.a(-14), null, dVar);
                        u.f("splashLoadAd", "视频文件缓存失败 onErrorResponse REQUEST_TYPE_REAL_NETWORK");
                        b.this.a((int) BdStatisticsManager.INIT_UPLOAD_TIME_INTERVAL, aVar2, (com.bytedance.sdk.openadsdk.core.d.o) null, (e) null, (String) null);
                    }
                });
                return;
            }
            u.f("splashLoadAd", "未下发视频文件，则加载图片完成后给予回调");
            a(aVar, context, dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(final com.bytedance.sdk.openadsdk.core.d.o oVar, final e eVar, final String str, final com.bytedance.sdk.openadsdk.h.a.d dVar) {
        if (eVar != null) {
            eVar.renderExpressAd(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.8
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str2, int i) {
                    b.this.n.set(true);
                    u.b("splashLoadAd", "缓存模版渲染--》onRenderFail start....splashAd=" + eVar);
                    b.this.a(oVar == null ? 15000 : 15001, new a(1, 0, null, eVar, dVar), oVar, eVar, str);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f, float f2) {
                    b.this.n.set(true);
                    int i = oVar == null ? 15000 : 15001;
                    u.b("splashLoadAd", "缓存模版渲染--》onRenderSuccess start....=" + (i == 15000 ? "实时" : "缓存"));
                    b.this.a(i, new a(1, 0, null, eVar, dVar), oVar, eVar, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b(final com.bytedance.sdk.openadsdk.core.d.o oVar, final e eVar, final String str, final com.bytedance.sdk.openadsdk.h.a.d dVar) {
        if (eVar != null) {
            eVar.renderExpressAd(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.9
                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdClicked(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onAdShow(View view, int i) {
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderFail(View view, String str2, int i) {
                    b.this.m.set(true);
                    u.b("splashLoadAd", "实时模版渲染--》onRenderFail start....splashAd=" + eVar);
                    b.this.a(oVar == null ? 15000 : 15001, new a(1, 0, null, eVar, dVar), oVar, eVar, str);
                }

                @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                public void onRenderSuccess(View view, float f, float f2) {
                    b.this.m.set(true);
                    int i = oVar == null ? 15000 : 15001;
                    u.b("splashLoadAd", "实时模版渲染--》onRenderSuccess start....=" + (i == 15000 ? "实时" : "缓存"));
                    b.this.a(i, new a(1, 0, null, eVar, dVar), oVar, eVar, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.bytedance.sdk.openadsdk.core.d.o oVar, final e eVar, final String str) {
        u.c("splashLoadAd", "执行 checkAdFromServer 检测缓存....");
        if (c.a(oVar)) {
            l a2 = oVar.a();
            final com.bytedance.sdk.openadsdk.h.a.d a3 = a(4, oVar);
            p.f().a(a2.T(), a2.W(), new q.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.10
                @Override // com.bytedance.sdk.openadsdk.core.q.a
                public void a(boolean z, long j2, long j3) {
                    c.a(b.this.f6400a, z, j2, j3);
                    if (!z || b.this.g.get()) {
                        if (b.this.e()) {
                            u.b("SplashAdLoadManager", "开屏视频缓存广告不在投放期或本次调用已回调出去");
                            b.this.a(b.this.f6400a);
                            return;
                        }
                        u.b("splashLoadAd", "并发请求开屏视频check 失败 无需再网络请求");
                        a3.b((int) j2).g(h.a((int) j2));
                        b.this.a(15001, new a(2, 0, null, null, a3), oVar, (e) null, (String) null);
                        return;
                    }
                    u.b("splashLoadAd", "check 成功回调.......");
                    b.this.l.set(true);
                    b.this.a(15001, new a(1, 0, null, eVar, a3), oVar, eVar, str);
                }
            });
            return;
        }
        u.b("splashLoadAd", "checkAdFromServer check fail !!!!");
        if (e()) {
            u.b("splashLoadAd", "checkAdFromServer check fail !!!! ---> tryLoadSplashAdFromNetwork !!!");
            a(this.f6400a);
            return;
        }
        com.bytedance.sdk.openadsdk.h.a.d a4 = a(4, (com.bytedance.sdk.openadsdk.core.d.o) null);
        u.b("splashLoadAd", "checkAdFromServer check fail !!!! ---> return callback !!!");
        a(15001, new a(2, 0, null, null, a4), oVar, (e) null, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(int i, a aVar, com.bytedance.sdk.openadsdk.core.d.o oVar, e eVar, String str) {
        synchronized (this) {
            if (i == 15000) {
                u.f("splashLoadAd", "splashAdTryCallback start....实时请求来了！=" + eVar);
                this.y.set(true);
            } else if (i == 15001) {
                u.f("splashLoadAd", "splashAdTryCallback start....缓存请求来了！=" + eVar);
                this.z.set(true);
            } else if (i == 15004) {
                u.f("splashLoadAd", "splashAdTryCallback start....超时请求来了！=" + eVar);
                this.x = 2;
            } else if (i == 15003) {
                u.f("splashLoadAd", "splashAdTryCallback start....渲染超时请求来了！=" + eVar);
            }
            if (this.g.get()) {
                u.f("splashLoadAd", "splashAdTryCallback mSplashAdHasLoad==true 已成功回调，不再执行回调操作！！！");
            } else if (eVar == null) {
                if (this.s.get() || this.t.get()) {
                    if (i == 15000) {
                        if (!this.z.get()) {
                            u.d("splashLoadAd", "splashAdTryCallback 实时请求失败（实时先回，缓存还没回）...等待缓存");
                        } else {
                            u.d("splashLoadAd", "splashAdTryCallback 实时请求失败（缓存先回，实时后回）....");
                            if (this.l.get() && ((this.m.get() || this.n.get()) && this.A != null)) {
                                u.d("splashLoadAd", "splashAdTryCallback 实时请求失败（缓存先回，实时后回）....尝试回调缓存成功！");
                                a(this.A);
                            } else if (this.l.get() && !this.n.get()) {
                                u.d("splashLoadAd", "splashAdTryCallback 当为模版广告，存在缓存的情况下，模版渲染还没有回来时等待模版广告渲染回来！");
                            }
                        }
                    } else if (i == 15001) {
                        if (!this.y.get()) {
                            u.d("splashLoadAd", "splashAdTryCallback 缓存请求失败(缓存先回来)，实时还没有回调....等待...！");
                        } else {
                            u.d("splashLoadAd", "splashAdTryCallback 缓存请求失败(缓存先回来)，实时也失败....直接回调出去！");
                        }
                    } else if (this.s.get() && i == 15004) {
                        u.d("splashLoadAd", "如果实时已超时，REQUEST_TYPE_TIMEOUT--->>>>");
                        if (this.z.get()) {
                            if (!this.y.get()) {
                                u.d("splashLoadAd", "如果实时已超时，实时是否渲染成功 " + this.m.get() + " 缓存渲染是否成功 " + this.n.get());
                                if (this.l.get() && (this.m.get() || this.n.get())) {
                                    u.d("splashLoadAd", "如果实时已超时，缓存成功直接回调");
                                    a(this.A);
                                } else {
                                    u.d("splashLoadAd", "如果实时已超时，直接失败回调");
                                }
                            }
                        } else {
                            u.d("splashLoadAd", "如果实时已超时，缓存也失败直接回调，直接失败回调");
                        }
                    }
                } else {
                    u.d("splashLoadAd", "普通类型走这，直接失败回调");
                }
                a(aVar);
            } else {
                if (str == null && oVar != null && eVar != null) {
                    eVar.a(oVar.b());
                }
                if (this.s.get() && i == 15001) {
                    if (this.z.get() && !this.y.get()) {
                        u.d("splashLoadAd", "如果缓存先回来,实时还没有回来，实时是否渲染成功 " + this.m.get() + " 缓存渲染是否成功 " + this.n.get());
                        if (this.l.get() && this.n.get()) {
                            u.d("splashLoadAd", "缓存赋值给resultTemp");
                            this.A = aVar;
                            u.d("splashLoadAd", "如果缓存先回来,实时还没有回来，等待实时回来");
                        }
                    }
                    if (this.y.get() && this.i != null && this.i.a()) {
                        u.d("splashLoadAd", "此时实时可能在渲染，避免缓存的渲染成功后直接被回调");
                    }
                }
                if (i == 15000) {
                    u.d("splashLoadAd", "splashAdTryCallback 实时或渲染成功回调......！");
                }
                if (this.s.get() && i == 15000 && !this.m.get()) {
                    u.b("splashLoadAd", "优先实时，且实时类型广告图片加载成功；如果是模板广告且渲染未成功，则继续等待");
                } else {
                    u.b("splashLoadAd", "splashAdTryCallback..（ 是否缓存已check成功：" + this.l.get() + " || 是否渲染超时：" + (i == 15003) + " || 是否为实时请求" + (i == 15000) + "） && （是否实时模版渲染成功：" + this.m.get() + " || 是否缓存模版渲染成功：" + this.n.get() + "）");
                    if ((this.l.get() || i == 15000 || i == 15003) && (this.m.get() || this.n.get())) {
                        a(aVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e a(com.bytedance.sdk.openadsdk.core.d.o oVar, String str) {
        if (c.a(oVar)) {
            if (str != null) {
                oVar.a().d(true);
            }
            e eVar = new e(this.e, oVar.a(), str, this.f6400a, "splash_ad");
            this.h = eVar;
            return eVar;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f6424a;

        /* renamed from: b  reason: collision with root package name */
        public int f6425b;
        public String c;
        public TTSplashAd d;
        public com.bytedance.sdk.openadsdk.h.a.d e;

        public a(int i, int i2, String str, TTSplashAd tTSplashAd, com.bytedance.sdk.openadsdk.h.a.d dVar) {
            this.f6424a = i;
            this.f6425b = i2;
            this.c = str;
            this.d = tTSplashAd;
            this.e = dVar;
        }
    }

    private void g() {
        if (this.k != null) {
            this.k.a(this.f6400a, this.f6401b);
        }
    }

    private synchronized void a(a aVar) {
        u.f("splashLoadAd", "onCallback ......");
        g();
        if (aVar == null) {
            u.a("splashAdListener is null, then return");
            j.remove(this);
        } else if (this.c == null) {
            u.a("splashAdListener is null, then return");
            if (aVar.f6424a == 3) {
                a(aVar.e);
            }
            j.remove(this);
        } else if (!this.g.get()) {
            this.g.set(true);
            switch (aVar.f6424a) {
                case 1:
                    c(aVar.e);
                    this.c.onSplashAdLoad(aVar.d);
                    break;
                case 2:
                    u.f("splashLoadAd", "onCallback CALLBACK_RESULT_FAILED");
                    b(aVar.e);
                    this.c.onError(aVar.f6425b, aVar.c);
                    break;
                case 3:
                    u.f("splashLoadAd", "onCallback CALLBACK_RESULT_TIMEOUT");
                    a(aVar.e);
                    this.c.onTimeout();
                    break;
                default:
                    this.c.onError(-2, h.a(-2));
                    break;
            }
            if (this.f != null) {
                this.f.removeMessages(2);
                this.f.removeMessages(3);
            }
            this.c = null;
            j.remove(this);
        } else {
            this.c = null;
            if (aVar.f6424a == 3) {
                a(aVar.e);
            }
            j.remove(this);
        }
    }

    private void a(com.bytedance.sdk.openadsdk.h.a.d dVar) {
        u.f("splashLoadAd", "onLogTimeoutEvent");
        b(dVar);
        com.bytedance.sdk.openadsdk.h.a.a().g(dVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        final e eVar;
        int i = 4;
        int i2 = 3;
        if (message.what == 1) {
            if (!this.g.get()) {
                this.g.set(true);
                b();
                u.b("SplashAdLoadManager", "尝试从缓存中取");
            } else {
                g();
                u.b("SplashAdLoadManager", "开始预加载");
            }
            this.f.removeCallbacksAndMessages(null);
        }
        if (message.what == 2) {
            this.f.removeCallbacksAndMessages(null);
            if (!this.g.get()) {
                u.b("splashLoadAd", "MSG_USER_TIME_OUT----7-");
                final com.bytedance.sdk.openadsdk.h.a.d a2 = a(0, (com.bytedance.sdk.openadsdk.core.d.o) null);
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.11
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.a(15004, new a(3, 0, null, null, a2), (com.bytedance.sdk.openadsdk.core.d.o) null, (e) null, (String) null);
                    }
                });
            } else {
                return;
            }
        }
        if (message.what == 3) {
            this.f.removeMessages(3);
            if (!this.g.get()) {
                this.m.set(true);
                this.n.set(true);
                switch (p.h().s()) {
                    case 0:
                        eVar = this.i;
                        break;
                    case 1:
                        if (this.h != null && this.l.get()) {
                            eVar = this.h;
                            i2 = 4;
                            break;
                        } else {
                            if (this.i != null) {
                                eVar = this.i;
                                break;
                            }
                            eVar = null;
                            break;
                        }
                        break;
                    case 2:
                        if (this.i != null) {
                            eVar = this.i;
                            u.b("splashLoadAd", "超时使用实时--mRealNetWorkTTSplashAd");
                            break;
                        } else {
                            if (this.h != null && this.l.get()) {
                                u.b("splashLoadAd", "超时使用实时//--mCacheTTSplashAd");
                                eVar = this.h;
                                i2 = 4;
                                break;
                            }
                            eVar = null;
                            break;
                        }
                    case 3:
                        if (this.h == null || !this.l.get()) {
                            i = 3;
                            eVar = null;
                        } else {
                            u.b("splashLoadAd", "谁回来用谁//--mCacheTTSplashAd");
                            eVar = this.h;
                        }
                        if (this.i == null) {
                            i2 = i;
                            break;
                        } else {
                            u.b("splashLoadAd", "谁回来用谁//--mRealNetWorkTTSplashAd");
                            eVar = this.i;
                            i2 = i;
                            break;
                        }
                        break;
                    default:
                        eVar = null;
                        break;
                }
                if (eVar != null && eVar.a()) {
                    u.f("splashLoadAd", "超时了 temp != null ");
                    final com.bytedance.sdk.openadsdk.h.a.d a3 = a(i2, (com.bytedance.sdk.openadsdk.core.d.o) null);
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.2
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.a(15003, new a(1, 0, null, eVar, a3), (com.bytedance.sdk.openadsdk.core.d.o) null, eVar, (String) null);
                        }
                    });
                    return;
                }
                u.f("splashLoadAd", "超时了 开始加载在线视频");
                h();
            }
        }
    }

    private void h() {
        l lVar;
        u.b("splashLoadAd", "loadSplashOnLineVideo");
        if (this.u != null && this.w != null && this.u.c() != null && this.u.c().size() != 0 && (lVar = this.u.c().get(0)) != null && lVar.n() == 3) {
            final com.bytedance.sdk.openadsdk.core.d.o oVar = new com.bytedance.sdk.openadsdk.core.d.o(this.u, lVar, null);
            if (lVar.F() != null) {
                final String h = lVar.F().h();
                u.b("splashLoadAd", "loadSplashOnLineVideo videoPath " + h);
                if (!TextUtils.isEmpty(h)) {
                    final e a2 = a(oVar, h);
                    u.b("splashLoadAd", "loadSplashOnLineVideo splashAdTryCallback");
                    new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.3
                        @Override // java.lang.Runnable
                        public void run() {
                            b.this.a(15003, new a(1, 0, null, a2, b.this.w), oVar, a2, h);
                        }
                    });
                }
            }
        }
    }

    private void b(com.bytedance.sdk.openadsdk.h.a.d dVar) {
        int i;
        u.f("splashLoadAd", "reportMarkAtRespFail outer_call_no_rsp");
        if (dVar != null) {
            JSONObject jSONObject = new JSONObject();
            if (d()) {
                i = 1;
            } else {
                i = 0;
            }
            u.f("splashLoadAd", "reportMarkAtRespFail mRealTimeNoRspStatus " + this.x);
            try {
                jSONObject.put("if_have_cache", i);
                jSONObject.put("if_have_rt_ads", this.x);
            } catch (Throwable th) {
            }
            com.bytedance.sdk.openadsdk.h.a.a().d(dVar.b(jSONObject.toString()));
        }
    }

    private void c(com.bytedance.sdk.openadsdk.h.a.d dVar) {
        u.f("splashLoadAd", "reportMarkAtRespSucc outer_call_send");
        if (dVar != null) {
            JSONObject jSONObject = new JSONObject();
            u.f("splashLoadAd", "reportMarkAtRespSucc sSplashLoadImageSource " + com.bytedance.sdk.openadsdk.i.a.b.f7190a);
            try {
                jSONObject.put("image_CacheType", com.bytedance.sdk.openadsdk.i.a.b.f7190a);
            } catch (Throwable th) {
            }
            com.bytedance.sdk.openadsdk.h.a.a().c(dVar.b(jSONObject.toString()));
        }
    }
}
