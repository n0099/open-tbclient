package com.bytedance.sdk.openadsdk.component.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdNative;
import com.bytedance.sdk.openadsdk.TTAdSdk;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.component.splash.a;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.m;
import com.bytedance.sdk.openadsdk.core.d.r;
import com.bytedance.sdk.openadsdk.core.d.v;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.q;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.j;
import com.bytedance.sdk.openadsdk.utils.k;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import d.c.c.b.b.b;
import d.c.c.b.d.o;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b implements am.a {
    public static Set<b> j = Collections.synchronizedSet(new HashSet());
    public l A;
    public a E;

    /* renamed from: a  reason: collision with root package name */
    public AdSlot f27614a;

    /* renamed from: b  reason: collision with root package name */
    public m f27615b;

    /* renamed from: d  reason: collision with root package name */
    public final q f27617d;

    /* renamed from: e  reason: collision with root package name */
    public Context f27618e;

    /* renamed from: f  reason: collision with root package name */
    public final am f27619f;

    /* renamed from: h  reason: collision with root package name */
    public e f27621h;
    public e i;
    public com.bytedance.sdk.openadsdk.component.splash.a k;
    public boolean o;
    public long p;
    public long q;
    public com.bytedance.sdk.openadsdk.core.d.a u;
    public com.bytedance.sdk.openadsdk.core.d.a v;
    public com.bytedance.sdk.openadsdk.h.a.c w;
    public r y;

    /* renamed from: c  reason: collision with root package name */
    public TTAdNative.SplashAdListener f27616c = null;

    /* renamed from: g  reason: collision with root package name */
    public final AtomicBoolean f27620g = new AtomicBoolean(false);
    public AtomicBoolean l = new AtomicBoolean(false);
    public AtomicBoolean m = new AtomicBoolean(false);
    public AtomicBoolean n = new AtomicBoolean(false);
    public long r = 0;
    public final AtomicBoolean s = new AtomicBoolean(false);
    public final AtomicBoolean t = new AtomicBoolean(false);
    public int x = 0;
    public boolean z = false;
    public int B = 4;
    public AtomicBoolean C = new AtomicBoolean(false);
    public AtomicBoolean D = new AtomicBoolean(false);

    /* loaded from: classes5.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public int f27662a;

        /* renamed from: b  reason: collision with root package name */
        public int f27663b;

        /* renamed from: c  reason: collision with root package name */
        public String f27664c;

        /* renamed from: d  reason: collision with root package name */
        public TTSplashAd f27665d;

        /* renamed from: e  reason: collision with root package name */
        public com.bytedance.sdk.openadsdk.h.a.c f27666e;

        public a(int i, int i2, String str, TTSplashAd tTSplashAd, com.bytedance.sdk.openadsdk.h.a.c cVar) {
            this.f27662a = i;
            this.f27663b = i2;
            this.f27664c = str;
            this.f27665d = tTSplashAd;
            this.f27666e = cVar;
        }
    }

    public b(Context context) {
        if (context != null) {
            this.f27618e = context.getApplicationContext();
        }
        this.f27617d = p.f();
        this.f27619f = new am(Looper.getMainLooper(), this);
        Context context2 = this.f27618e;
        this.k = com.bytedance.sdk.openadsdk.component.splash.a.a(context2 == null ? p.a() : context2);
        this.o = p.h().t();
        j.add(this);
        f();
    }

    private boolean d() {
        u.f("splashLoadAd", "try checkSpashAdCacheIsValidAndTryShowAd......");
        com.bytedance.sdk.openadsdk.h.a.c a2 = a(15001, (com.bytedance.sdk.openadsdk.core.d.p) null);
        if (!this.k.b(this.f27614a.getCodeId()) && !this.k.a(this.f27614a.getCodeId())) {
            u.f("splashLoadAd", "没有缓存数据..........");
            if (this.s.get() || this.t.get()) {
                a(15001, new a(2, -12, h.a(-12), null, a2), (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
            }
            this.x = 0;
            return false;
        } else if (this.k.a(this.f27614a, true)) {
            u.b("splashLoadAd", "======== 缓存过期 ========");
            if (this.s.get() || this.t.get()) {
                a(15001, new a(2, -11, h.a(-11), null, a2), (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
            }
            this.x = 2;
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e() {
        int q = p.h().q();
        return (2 == q || 3 == q) ? false : true;
    }

    private void f() {
        r rVar = new r();
        this.y = rVar;
        rVar.m(System.currentTimeMillis());
        if (TTAdSdk.isColdStartSdk.get()) {
            this.y.b(0);
            TTAdSdk.isColdStartSdk.set(false);
            return;
        }
        this.y.b(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.y == null) {
            return;
        }
        this.y.a(System.currentTimeMillis() - this.y.u());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f27618e == null || this.A == null || this.y == null || !p.h().v()) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("image_size", this.y.i());
            jSONObject.put("image_resolution", this.y.j());
            jSONObject.put("image_response_header", this.y.k());
            jSONObject.put("download_client_start_time", this.y.p());
            jSONObject.put("download_net_time", this.y.q());
            jSONObject.put("download_write_time", this.y.r());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        com.bytedance.sdk.openadsdk.c.d.a(this.f27618e, this.A, "splash_ad", "download_image_duration", this.y.f(), jSONObject);
    }

    private void i() {
        com.bytedance.sdk.openadsdk.component.splash.a aVar = this.k;
        if (aVar != null) {
            aVar.a(this.f27614a, this.f27615b);
        }
    }

    private void j() {
        l lVar;
        u.b("splashLoadAd", "loadSplashOnLineVideo");
        com.bytedance.sdk.openadsdk.core.d.a aVar = this.u;
        if (aVar == null || this.w == null || aVar.c() == null || this.u.c().size() == 0 || (lVar = this.u.c().get(0)) == null || lVar.x() != 3) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.p pVar = new com.bytedance.sdk.openadsdk.core.d.p(this.u, lVar, null);
        if (lVar.X() == null) {
            return;
        }
        String i = lVar.X().i();
        u.b("splashLoadAd", "loadSplashOnLineVideo videoPath " + i);
        if (TextUtils.isEmpty(i)) {
            return;
        }
        u.b("splashLoadAd", "loadSplashOnLineVideo splashAdTryCallback");
        e a2 = a(pVar, i);
        a(15003, new a(1, 0, null, a2, this.w), pVar, a2, i);
    }

    private m k() {
        long currentTimeMillis = System.currentTimeMillis();
        m mVar = new m();
        mVar.f27883f = currentTimeMillis;
        return mVar;
    }

    private boolean c() {
        if (d()) {
            a(15001, this.f27614a.getCodeId());
            return true;
        }
        return false;
    }

    private void b() {
        if (this.f27616c == null) {
            return;
        }
        int q = p.h().q();
        this.y.a(q);
        if (q == 0) {
            this.s.set(false);
            this.t.set(false);
            u.b("splashLoadAd", "splash_type_real_time=====只走实时");
            a(this.f27614a);
        } else if (q == 1) {
            this.s.set(false);
            this.t.set(false);
            u.b("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存");
            if (!c()) {
                u.c("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存失败，进行网络请求");
                a(this.f27614a);
                return;
            }
            u.c("splashLoadAd", "splash_type_priorrity_cache_defualt=====优先缓存--->执行缓存成功！！");
        } else if (q == 2) {
            u.b("splashLoadAd", "splash_type_concurrent_priority_real_time=====并发请求广告和check缓存，优先使用实时");
            this.s.set(true);
            this.t.set(false);
            a(this.f27614a);
            c();
        } else if (q != 3) {
        } else {
            this.s.set(false);
            this.t.set(true);
            u.b("splashLoadAd", "splash_type_concurrent_first_come_first_use=====并发请求广告和check缓存，谁先到用谁");
            a(this.f27614a);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(l lVar) {
        if (lVar != null && lVar.X() == null) {
            int q = p.h().q();
            this.z = q == 0 || q == 2;
        }
    }

    private void c(com.bytedance.sdk.openadsdk.h.a.c cVar) {
        u.f("splashLoadAd", "reportMarkAtRespSucc outer_call_send");
        if (cVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        u.f("splashLoadAd", "reportMarkAtRespSucc sSplashLoadImageSource " + com.bytedance.sdk.openadsdk.i.a.b.f29133a);
        try {
            jSONObject.put("image_CacheType", com.bytedance.sdk.openadsdk.i.a.b.f29133a);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.h.a.a().c(cVar.b(jSONObject.toString()));
    }

    private void d(l lVar) {
        if (this.f27618e == null || lVar == null || this.y == null || !p.h().v()) {
            return;
        }
        boolean K = p.h().K();
        boolean w = this.y.w();
        long currentTimeMillis = System.currentTimeMillis();
        if (w) {
            this.y.c(currentTimeMillis - this.y.t());
        } else {
            r rVar = this.y;
            rVar.k(currentTimeMillis - rVar.y());
            this.y.o(currentTimeMillis - this.y.t());
        }
        JSONObject jSONObject = new JSONObject();
        if (K) {
            try {
                jSONObject.put("pre_connect_status", com.bytedance.sdk.openadsdk.core.m.f28147d);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        jSONObject.put("if_pre_connect", K ? 1 : 0);
        jSONObject.put("splash_load_type", this.y.a());
        jSONObject.put("splash_final_type", this.y.b());
        jSONObject.put("active_type", this.y.c());
        jSONObject.put("splash_creative_type", this.y.d());
        jSONObject.put("splash_load_type", this.y.a());
        if (this.z) {
            jSONObject.put("load_duration", this.y.e());
            jSONObject.put("download_image_duration", this.y.x());
            jSONObject.put("cache_image_duration", this.y.g());
            jSONObject.put("image_cachetype", this.y.h());
            jSONObject.put("image_size", this.y.i());
            jSONObject.put("image_resolution", this.y.j());
            jSONObject.put("image_response_header", this.y.k());
            jSONObject.put("client_start_time", this.y.l());
            jSONObject.put("network_time", this.y.m());
            jSONObject.put("sever_time", this.y.n());
            jSONObject.put("client_end_time", this.y.o());
            jSONObject.put("download_client_start_time", this.y.p());
            jSONObject.put("download_net_time", this.y.q());
            jSONObject.put("download_write_time", this.y.r());
            jSONObject.put("download_client_end_time", this.y.s());
        }
        com.bytedance.sdk.openadsdk.c.d.a(this.f27618e, lVar, "splash_ad", "splash_ad_loadtime", currentTimeMillis - this.y.u(), jSONObject);
    }

    public static b a(Context context) {
        return new b(context);
    }

    public void a(AdSlot adSlot, @NonNull TTAdNative.SplashAdListener splashAdListener, int i) {
        this.f27615b = k();
        this.f27614a = adSlot;
        this.f27616c = splashAdListener;
        this.f27620g.set(false);
        this.f27621h = null;
        this.i = null;
        u.b("splashLoadAd", "开发者传入的超时时长 timeOut " + i);
        final long j2 = (long) i;
        int c2 = p.h().c(adSlot.getCodeId());
        u.b("splashLoadAd", "云控的超时时长 cloudTimeOut " + c2);
        if (c2 > 0) {
            u.b("splashLoadAd", "云控控制的超时时长大于0比较 较服务端下发的超时时长和开发者配置的超时时长 ");
            if (c2 >= i) {
                i = c2;
            }
        } else if (i < 500) {
            i = 500;
        }
        u.f("splashLoadAd", "getSplashAd 实际 timeOut " + i);
        long j3 = (long) i;
        this.f27619f.sendEmptyMessageDelayed(2, j3);
        int i2 = i + (-300);
        if (i2 > 0) {
            i = i2;
        }
        this.f27619f.sendEmptyMessageDelayed(3, i);
        m mVar = this.f27615b;
        mVar.f27884g = j2;
        mVar.f27885h = c2;
        mVar.i = j3;
        com.bytedance.sdk.openadsdk.l.e.a(new g("getSplashAd") { // from class: com.bytedance.sdk.openadsdk.component.splash.b.1
            @Override // java.lang.Runnable
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("publisher_timeout_control", j2);
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.h.a.a().b(com.bytedance.sdk.openadsdk.h.a.c.b().a(3).c(b.this.f27614a.getCodeId()).f(b.this.f27615b.f27878a).b(jSONObject.toString()));
            }
        });
        b();
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(final com.bytedance.sdk.openadsdk.core.d.a aVar, Context context, final com.bytedance.sdk.openadsdk.h.a.c cVar) {
        u.f("splashLoadAd", " SplashUtils preLoadVideo");
        if (!c.b(aVar) || context == null) {
            return;
        }
        final l lVar = aVar.c().get(0);
        final int d2 = ak.d(lVar.ap());
        v X = lVar.X();
        c.a(lVar, X != null ? 2 : 0);
        if (X != null) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            String i = X.i();
            u.f("splashLoadAd", "SplashUtils preLoadVideo videoUrl " + i);
            if (i == null) {
                a(aVar, context, cVar);
                return;
            }
            this.u = aVar;
            this.w = cVar;
            c.a(lVar, 1);
            String l = X.l();
            if (TextUtils.isEmpty(l)) {
                l = j.a(i);
            }
            final String str = l;
            final File a2 = c.a(p.a(), com.bytedance.sdk.openadsdk.component.splash.a.a(p.a()).a(String.valueOf(d2), com.bytedance.sdk.openadsdk.multipro.b.b()), str);
            if (p.h().e(String.valueOf(d2)) && !x.d(p.a())) {
                if (str != null && a2.exists()) {
                    u.b("splashLoadAd", "非wifi环境，已缓存相同url的视频文件也是可以播放的");
                    com.bytedance.sdk.openadsdk.component.splash.a.a(p.a()).b(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, null));
                    a(15000, d2 + "");
                    return;
                }
                u.b("splashLoadAd", "非wifi环境");
                return;
            }
            com.bytedance.sdk.openadsdk.i.e.c().a(i, new b.InterfaceC1824b() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.6
                @Override // d.c.c.b.b.b.InterfaceC1824b
                public File a(String str2) {
                    try {
                        File parentFile = a2.getParentFile();
                        if (parentFile == null || !parentFile.exists()) {
                            return null;
                        }
                        u.b("splashLoadAd", "SplashAdLoadManager getFile " + str2);
                        c.a(a2);
                        return i.d().r().a(str, parentFile);
                    } catch (IOException e2) {
                        u.f("splashLoadAd", "datastoreGet throw IOException : " + e2.toString());
                        return null;
                    }
                }

                @Override // d.c.c.b.b.c.a
                public void a(long j2, long j3) {
                }

                @Override // d.c.c.b.b.b.InterfaceC1824b
                public File b(String str2) {
                    return a2;
                }

                @Override // d.c.c.b.d.o.a
                public void b(o<File> oVar) {
                    b.this.B = 3;
                    c.a(elapsedRealtime, true, false, lVar, oVar == null ? -2L : oVar.f66591h, oVar);
                    cVar.b(-14).g(h.a(-14));
                    a aVar2 = new a(2, -14, h.a(-14), null, cVar);
                    u.f("splashLoadAd", "视频文件缓存失败 onErrorResponse REQUEST_TYPE_REAL_NETWORK");
                    b.this.a(15000, aVar2, (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                }

                @Override // d.c.c.b.b.b.InterfaceC1824b
                public void a(String str2, File file) {
                    if (file != null) {
                        u.b("splashLoadAd", "SplashAdLoadManager 视频文件下载成功保存到本地 putFile s " + str2 + " File " + file.getPath());
                        c.a(file);
                        com.bytedance.sdk.openadsdk.component.splash.a.a(p.a()).a(file);
                    }
                }

                @Override // d.c.c.b.d.o.a
                public void a(o<File> oVar) {
                    if (oVar == null || oVar.f66584a == null) {
                        b.this.B = 3;
                        cVar.b(-14).g(h.a(-14));
                        a aVar2 = new a(2, -14, h.a(-14), null, cVar);
                        u.f("splashLoadAd", "视频文件缓存失败 response == null REQUEST_TYPE_REAL_NETWORK");
                        b.this.a(15000, aVar2, (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                        c.a(elapsedRealtime, true, false, lVar, oVar == null ? -3L : oVar.f66591h, oVar);
                        return;
                    }
                    com.bytedance.sdk.openadsdk.component.splash.a.a(p.a()).b(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, null));
                    u.f("splashLoadAd", "视频文件获取成功, 尝试加载视频开屏");
                    com.bytedance.sdk.openadsdk.component.splash.a.a(p.a()).a(new com.bytedance.sdk.openadsdk.core.d.p(aVar, lVar, null), new a.d() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.6.1
                        @Override // com.bytedance.sdk.openadsdk.component.splash.a.d
                        public void a() {
                            b bVar = b.this;
                            bVar.a(15000, d2 + "");
                        }
                    });
                    c.a(elapsedRealtime, true, true, lVar, 0L, oVar);
                }
            });
            return;
        }
        u.f("splashLoadAd", "未下发视频文件，则加载图片完成后给予回调");
        a(aVar, context, cVar);
    }

    private void a() {
        AdSlot adSlot;
        if (this.k == null || (adSlot = this.f27614a) == null || !TextUtils.isEmpty(adSlot.getBidAdm())) {
            return;
        }
        this.k.b(this.f27614a, this.f27615b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final int i, final String str) {
        u.f("splashLoadAd", "tryDisplaySplashAdFromCache rit " + str);
        if (this.k.b(str)) {
            this.k.a(str, new a.c() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.2
                @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                public void a(@NonNull com.bytedance.sdk.openadsdk.core.d.p pVar) {
                    b.this.A = pVar.a();
                    b bVar = b.this;
                    bVar.b(bVar.A);
                    if (pVar.a() != null && pVar.a().X() != null && pVar.a().X().i() != null) {
                        String a2 = b.this.k.a(pVar.a());
                        if (a2 == null) {
                            u.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess videoPath == null tryDisplaySplashImageFromCache");
                            b.this.a(str);
                            return;
                        }
                        u.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess videoPath " + a2);
                        com.bytedance.sdk.openadsdk.h.a.c a3 = b.this.a(4, pVar);
                        e a4 = b.this.a(pVar, a2);
                        if (i == 15000) {
                            b.this.m.set(!b.this.a(pVar.a()));
                        }
                        b.this.n.set(!b.this.a(pVar.a()));
                        if (i == 15000 || !b.this.o) {
                            b.this.l.set(true);
                            u.c("splashLoadAd", "不检测直接返回缓存....splashAd=" + a4);
                            u.f("splashLoadAd", "tryDisplaySplashAdFromCache onSuccess 加载视频缓存");
                            b bVar2 = b.this;
                            bVar2.a(i, new a(1, 0, null, a4, a3), pVar, a4, a2);
                        } else {
                            b.this.a(pVar, a4, a2);
                        }
                        if (b.this.a(pVar.a())) {
                            b.this.a(pVar, a4, a2, a3, i);
                            return;
                        }
                        return;
                    }
                    u.f("splashLoadAd", "tryDisplaySplashAdFromCache videoPath == null tryDisplaySplashImageFromCache");
                    b.this.a(str);
                }

                @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
                public void a() {
                    b.this.a(str);
                }
            });
        } else {
            a(str);
        }
    }

    public boolean a(l lVar) {
        return lVar != null && lVar.d() == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.h.a.c a(int i, com.bytedance.sdk.openadsdk.core.d.p pVar) {
        String str;
        String str2;
        String str3 = null;
        if (pVar == null || pVar.a() == null) {
            str = null;
            str2 = null;
        } else {
            str2 = pVar.a().am();
            str = pVar.a().ap();
            if (!TextUtils.isEmpty(str)) {
                try {
                    str3 = new JSONObject(str).getString(IAdRequestParam.REQ_ID);
                } catch (Throwable unused) {
                }
            }
        }
        if (str3 == null) {
            str3 = this.f27615b.f27878a;
        }
        com.bytedance.sdk.openadsdk.h.a.c c2 = com.bytedance.sdk.openadsdk.h.a.c.b().f(str3).a(i).c(this.f27614a.getCodeId());
        if (str2 != null) {
            c2.d(str2);
        }
        if (str != null) {
            c2.h(str);
        }
        return c2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(l lVar) {
        if (lVar == null || this.y == null) {
            return;
        }
        if (lVar.X() != null) {
            this.y.c(2);
        } else {
            this.y.c(1);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        this.k.b(str, new a.c() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.3
            @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
            public void a(@NonNull com.bytedance.sdk.openadsdk.core.d.p pVar) {
                com.bytedance.sdk.openadsdk.h.a.c a2 = b.this.a(4, pVar);
                b.this.A = pVar.a();
                b bVar = b.this;
                bVar.b(bVar.A);
                if (!c.b(pVar)) {
                    if (b.this.e()) {
                        u.b("splashLoadAd", "缓存广告素材解析出错");
                        b bVar2 = b.this;
                        bVar2.a(bVar2.f27614a);
                        return;
                    }
                    b bVar3 = b.this;
                    bVar3.a(15001, new a(2, 0, null, null, a2), pVar, (e) null, (String) null);
                    return;
                }
                pVar.a().c(true);
                pVar.a().d(false);
                b.this.n.set(!b.this.a(pVar.a()));
                e a3 = b.this.a(pVar, (String) null);
                if (!b.this.o) {
                    u.c("splashLoadAd", ".....不检测直接返回缓存....");
                    b.this.l.set(true);
                    b bVar4 = b.this;
                    bVar4.a(15001, new a(1, 0, null, a3, a2), pVar, a3, (String) null);
                } else {
                    b.this.a(pVar, a3, (String) null);
                }
                if (b.this.a(pVar.a())) {
                    b.this.a(pVar, a3, (String) null, a2, 15001);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.component.splash.a.c
            public void a() {
                u.b("splashLoadAd", "缓存广告对象解析出错");
                if (!b.this.e()) {
                    com.bytedance.sdk.openadsdk.h.a.c a2 = b.this.a(4, (com.bytedance.sdk.openadsdk.core.d.p) null);
                    b bVar = b.this;
                    bVar.a(15001, new a(2, 0, null, null, a2), (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                    return;
                }
                b bVar2 = b.this;
                bVar2.a(bVar2.f27614a);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdSlot adSlot) {
        u.f("splashLoadAd", "try LoadSplashAdFromNetwork......");
        final com.bytedance.sdk.openadsdk.h.a.c a2 = a(3, (com.bytedance.sdk.openadsdk.core.d.p) null);
        if (p.h().i(adSlot.getCodeId()) || adSlot.getExpressViewAcceptedWidth() > 0.0f) {
            this.f27615b.f27882e = 2;
        }
        q qVar = this.f27617d;
        if (qVar instanceof com.bytedance.sdk.openadsdk.core.r) {
            ((com.bytedance.sdk.openadsdk.core.r) qVar).a(this.y);
        }
        this.f27617d.a(adSlot, this.f27615b, 3, new q.b() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.4
            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(int i, String str) {
                a2.b(i).g(str);
                if (i == 20001) {
                    b.this.B = 1;
                } else {
                    b.this.B = 0;
                }
                u.b("splashLoadAd", "tryLoadSplashAdFromNetwork REQUEST_TYPE_REAL_NETWORK onError" + i + ",msg=" + h.a(i));
                b bVar = b.this;
                bVar.a(15000, new a(2, i, str, null, a2), (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                u.b("splashLoadAd", str + i);
            }

            @Override // com.bytedance.sdk.openadsdk.core.q.b
            public void a(com.bytedance.sdk.openadsdk.core.d.a aVar) {
                b.this.g();
                b.this.y.l(System.currentTimeMillis());
                if (aVar != null) {
                    a2.f(aVar.a());
                }
                if (!c.b(aVar)) {
                    b.this.B = 1;
                    a2.b(-3).g(h.a(-3));
                    a aVar2 = new a(2, -3, h.a(-3), null, a2);
                    u.b("splashLoadAd", "tryLoadSplashAdFromNetwork 网络请求的广告解析失败 REQUEST_TYPE_REAL_NETWORK");
                    b.this.a(15000, aVar2, (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                    u.b("SplashAdLoadManager", "网络请求的广告解析失败");
                    return;
                }
                l lVar = aVar.c().get(0);
                String ap = lVar.ap();
                String am = lVar.am();
                b.this.v = aVar;
                if (!TextUtils.isEmpty(ap)) {
                    a2.h(ap).d(am);
                    try {
                        a2.f(new JSONObject(ap).getString(IAdRequestParam.REQ_ID));
                    } catch (Throwable unused) {
                    }
                }
                u.f("splashLoadAd", "tryLoadSplashAdFromNetwork splashAdMeta.isValid() " + lVar.aH());
                if (lVar.aH()) {
                    b.this.p = 0L;
                    b.this.A = lVar;
                    b.this.b(lVar);
                    b.this.c(lVar);
                    int x = lVar.x();
                    int z = lVar.z();
                    k.a(z);
                    u.f("splashLoadAd", " 开屏素材存储是否是内部存储还是外部存储 storageFrom " + z);
                    u.f("splashLoadAd", "tryLoadSplashAdFromNetwork cacheSort " + x);
                    if (x == 1) {
                        b bVar = b.this;
                        bVar.a(aVar, bVar.f27618e, a2);
                        return;
                    }
                    b bVar2 = b.this;
                    bVar2.b(aVar, bVar2.f27618e, a2);
                    return;
                }
                a2.b(-3).g(h.a(-3));
                a aVar3 = new a(2, -3, h.a(-3), null, a2);
                u.b("splashLoadAd", "tryLoadSplashAdFromNetwork not splashAdMeta.isValid() REQUEST_TYPE_REAL_NETWORK");
                b.this.B = 1;
                b.this.a(15000, aVar3, (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                u.b("SplashAdLoadManager", "网络请求的广告解析失败");
            }
        });
    }

    private void b(com.bytedance.sdk.openadsdk.h.a.c cVar) {
        int i;
        u.f("splashLoadAd", "reportMarkAtRespFail outer_call_no_rsp");
        if (cVar == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (d()) {
            i = 1;
        } else {
            i = this.x;
            if (i == 2) {
                c.a(this.f27618e, this.f27614a);
            }
        }
        u.f("splashLoadAd", "reportMarkAtRespFail cacheStatus " + i);
        try {
            jSONObject.put("if_have_cache", i);
            jSONObject.put("if_have_rt_ads", this.B);
        } catch (Throwable unused) {
        }
        com.bytedance.sdk.openadsdk.h.a.a().d(cVar.b(jSONObject.toString()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.bytedance.sdk.openadsdk.core.d.a aVar, Context context, final com.bytedance.sdk.openadsdk.h.a.c cVar) {
        u.f("splashLoadAd", " SplashUtils preLoadImage");
        if (!c.b(aVar) || context == null) {
            return;
        }
        final l lVar = aVar.c().get(0);
        com.bytedance.sdk.openadsdk.core.d.k ab = lVar.ab();
        if (ab == null) {
            ab = lVar.af().get(0);
        }
        final String a2 = ab.a();
        u.b("splashLoadAd", "开屏加载的图片链接 url " + a2);
        int b2 = ab.b();
        final boolean z = lVar.X() != null;
        this.q = System.currentTimeMillis();
        this.r = SystemClock.elapsedRealtime();
        c.a(lVar, z ? 2 : 0);
        com.bytedance.sdk.openadsdk.i.e.c().g().a(this.y);
        com.bytedance.sdk.openadsdk.utils.o.a(context, a2, b2, new o.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.5
            @Override // com.bytedance.sdk.openadsdk.utils.o.a
            @MainThread
            public void a(@NonNull com.bytedance.sdk.openadsdk.i.a.d dVar) {
                b.this.a(dVar);
                u.f("splashLoadAd", "图片加载成功");
                c.a(aVar);
                b.this.y.d(com.bytedance.sdk.openadsdk.i.a.b.f29133a);
                if (!z) {
                    System.currentTimeMillis();
                    long unused = b.this.q;
                    com.bytedance.sdk.openadsdk.l.e.a(new g("preLoadImage") { // from class: com.bytedance.sdk.openadsdk.component.splash.b.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            com.bytedance.sdk.openadsdk.c.d.a(lVar, "splash_ad", System.currentTimeMillis() - b.this.q);
                        }
                    }, 5);
                }
                if (!dVar.c()) {
                    b.this.B = 3;
                    c.a(cVar, a2);
                    cVar.b(-7).g(h.a(-7));
                    a aVar2 = new a(2, -7, h.a(-7), null, cVar);
                    u.b("splashLoadAd", "preLoadImage  data == null REQUEST_TYPE_REAL_NETWORK");
                    b.this.B = 3;
                    b.this.a(15000, aVar2, (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                    if (z) {
                        c.a(b.this.r, false, false, lVar, -7, null);
                    }
                    u.b("SplashAdLoadManager", "图片加载失败");
                    return;
                }
                lVar.d(false);
                e eVar = new e(b.this.f27618e, lVar, b.this.f27614a, "splash_ad");
                b.this.i = eVar;
                eVar.a(dVar);
                b.this.m.set(lVar.d() == 1);
                b.this.a(15000, new a(1, 0, null, eVar, cVar), (com.bytedance.sdk.openadsdk.core.d.p) null, eVar, (String) null);
                if (b.this.a(lVar)) {
                    b.this.a((com.bytedance.sdk.openadsdk.core.d.p) null, eVar, (String) null, cVar);
                }
                if (z) {
                    c.a(b.this.r, false, true, lVar, 0L, null);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.utils.o.a
            public void b() {
                b.this.h();
            }

            @Override // com.bytedance.sdk.openadsdk.utils.o.a
            @MainThread
            public void a() {
                c.a(aVar);
                b.this.B = 3;
                c.a(cVar, a2);
                cVar.b(-7).g(h.a(-7));
                u.b("splashLoadAd", "splashLoad----5-LoadImageBytes-onFailed-code=-7,msg=" + h.a(-7));
                b bVar = b.this;
                bVar.a(15000, new a(2, -7, h.a(-7), null, cVar), (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
                if (z) {
                    c.a(b.this.r, false, false, lVar, -7L, null);
                }
                u.b("SplashAdLoadManager", "图片加载失败");
            }
        }, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(final com.bytedance.sdk.openadsdk.core.d.p pVar, final e eVar, final String str, final com.bytedance.sdk.openadsdk.h.a.c cVar, final int i) {
        if (eVar == null) {
            return;
        }
        eVar.renderExpressAd(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.7
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str2, int i2) {
                if (i == 15000) {
                    b.this.m.set(true);
                    u.b("splashLoadAd", "模版渲染--》onRenderFail msg: " + str2 + " code " + i2);
                } else {
                    b.this.n.set(true);
                    u.b("splashLoadAd", "缓存模版渲染--》onRenderFail msg: " + str2 + " code " + i2);
                }
                b bVar = b.this;
                bVar.a(i, new a(1, 0, null, eVar, cVar), pVar, eVar, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                if (i == 15000) {
                    b.this.m.set(true);
                    u.b("splashLoadAd", "模版渲染--》onRenderSuccess start....= 实时 ");
                } else {
                    b.this.n.set(true);
                    u.b("splashLoadAd", "缓存模版渲染--》onRenderSuccess start....=缓存");
                }
                b bVar = b.this;
                bVar.a(i, new a(1, 0, null, eVar, cVar), pVar, eVar, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a(final com.bytedance.sdk.openadsdk.core.d.p pVar, final e eVar, final String str, final com.bytedance.sdk.openadsdk.h.a.c cVar) {
        if (eVar == null) {
            return;
        }
        eVar.renderExpressAd(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.8
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str2, int i) {
                b.this.m.set(true);
                u.b("splashLoadAd", "实时模版渲染--》onRenderFail msg: " + str2 + " code " + i);
                int i2 = pVar == null ? 15000 : 15001;
                b bVar = b.this;
                bVar.a(i2, new a(1, 0, null, eVar, cVar), pVar, eVar, str);
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                b.this.m.set(true);
                int i = pVar == null ? 15000 : 15001;
                StringBuilder sb = new StringBuilder();
                sb.append("实时模版渲染--》onRenderSuccess start....=");
                sb.append(i == 15000 ? "实时" : "缓存");
                u.b("splashLoadAd", sb.toString());
                b bVar = b.this;
                bVar.a(i, new a(1, 0, null, eVar, cVar), pVar, eVar, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final com.bytedance.sdk.openadsdk.core.d.p pVar, final e eVar, final String str) {
        u.c("splashLoadAd", "执行 checkAdFromServer 检测缓存....");
        if (c.a(pVar)) {
            l a2 = pVar.a();
            final com.bytedance.sdk.openadsdk.h.a.c a3 = a(4, pVar);
            p.f().a(a2.am(), a2.ap(), new q.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.b.9
                @Override // com.bytedance.sdk.openadsdk.core.q.a
                public void a(boolean z, long j2, long j3) {
                    c.a(b.this.f27614a, z, j2, j3);
                    if (!z || b.this.f27620g.get()) {
                        if (b.this.e() && !b.this.f27620g.get()) {
                            u.b("splashLoadAd", "开屏视频缓存广告不在投放期并且开屏广告没有回调出去则加载");
                            b bVar = b.this;
                            bVar.a(bVar.f27614a);
                            return;
                        }
                        u.b("splashLoadAd", "并发请求开屏视频check 失败 无需再网络请求");
                        int i = (int) j2;
                        a3.b(i).g(h.a(i));
                        b bVar2 = b.this;
                        bVar2.a(15001, new a(2, 0, null, null, a3), pVar, (e) null, (String) null);
                        return;
                    }
                    u.b("splashLoadAd", "check 成功回调.......");
                    b.this.l.set(true);
                    b bVar3 = b.this;
                    bVar3.a(15001, new a(1, 0, null, eVar, a3), pVar, eVar, str);
                }
            });
            return;
        }
        u.b("splashLoadAd", "checkAdFromServer check fail !!!!");
        if (e()) {
            u.b("splashLoadAd", "checkAdFromServer check fail !!!! ---> tryLoadSplashAdFromNetwork !!!");
            a(this.f27614a);
            return;
        }
        com.bytedance.sdk.openadsdk.h.a.c a4 = a(4, (com.bytedance.sdk.openadsdk.core.d.p) null);
        u.b("splashLoadAd", "checkAdFromServer check fail !!!! ---> return callback !!!");
        a(15001, new a(2, 0, null, null, a4), pVar, (e) null, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b3, code lost:
        if (r8.D.get() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b5, code lost:
        com.bytedance.sdk.openadsdk.utils.u.d("splashLoadAd", "splashAdTryCallback 实时请求失败（实时先回，缓存还没回）...等待缓存");
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bd, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00be, code lost:
        com.bytedance.sdk.openadsdk.utils.u.d("splashLoadAd", "splashAdTryCallback 实时请求失败（缓存先回，实时后回）....");
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00cb, code lost:
        if (r8.l.get() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00d3, code lost:
        if (r8.m.get() != false) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00db, code lost:
        if (r8.n.get() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00df, code lost:
        if (r8.E == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00e1, code lost:
        com.bytedance.sdk.openadsdk.utils.u.d("splashLoadAd", "splashAdTryCallback 实时请求失败（缓存先回，实时后回）....尝试回调缓存成功！");
        r8.y.a("cache_ad");
        a(r8.E);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f5, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fc, code lost:
        if (r8.l.get() == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0104, code lost:
        if (r8.n.get() != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0106, code lost:
        com.bytedance.sdk.openadsdk.utils.u.d("splashLoadAd", "splashAdTryCallback 当为模版广告，存在缓存的情况下，模版渲染还没有回来时等待模版广告渲染回来！");
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x010e, code lost:
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void a(int i, a aVar, com.bytedance.sdk.openadsdk.core.d.p pVar, e eVar, String str) {
        boolean z = true;
        try {
            if (i == 15000) {
                u.f("splashLoadAd", "splashAdTryCallback start....实时请求来了！=" + eVar);
                this.C.set(true);
            } else if (i == 15001) {
                u.f("splashLoadAd", "splashAdTryCallback start....缓存请求来了！=" + eVar);
                this.D.set(true);
            } else if (i == 15004) {
                u.f("splashLoadAd", "splashAdTryCallback start....超时请求来了！=" + eVar);
                this.B = 2;
            } else if (i == 15003) {
                u.f("splashLoadAd", "splashAdTryCallback start....渲染超时请求来了！=" + eVar);
            }
            if (this.f27620g.get()) {
                u.f("splashLoadAd", "splashAdTryCallback mSplashAdHasLoad==true 已成功回调，不再执行回调操作！！！");
            } else if (eVar == null) {
                if (!this.s.get() && !this.t.get()) {
                    u.d("splashLoadAd", "普通类型走这，直接失败回调");
                    a(i);
                    a(aVar);
                }
                if (i == 15001) {
                    if (!this.C.get()) {
                        u.d("splashLoadAd", "splashAdTryCallback 缓存请求失败(缓存先回来)，实时还没有回调....等待...！");
                        return;
                    }
                    u.d("splashLoadAd", "splashAdTryCallback 缓存请求失败(缓存先回来)，实时也失败....直接回调出去！");
                } else if (this.s.get() && i == 15004) {
                    u.d("splashLoadAd", "如果实时已超时，REQUEST_TYPE_TIMEOUT--->>>>");
                    if (this.D.get()) {
                        if (!this.C.get()) {
                            u.d("splashLoadAd", "如果实时已超时，实时是否渲染成功 " + this.m.get() + " 缓存渲染是否成功 " + this.n.get());
                            if (this.l.get() && (this.m.get() || this.n.get())) {
                                u.d("splashLoadAd", "如果实时已超时，缓存成功直接回调");
                                this.y.a("cache_ad");
                                a(this.E);
                                return;
                            }
                            u.d("splashLoadAd", "如果实时已超时，直接失败回调");
                        }
                    } else {
                        u.d("splashLoadAd", "如果实时已超时，缓存也失败直接回调，直接失败回调");
                    }
                }
                a(i);
                a(aVar);
            } else {
                if (str == null && pVar != null && eVar != null) {
                    eVar.a(new com.bytedance.sdk.openadsdk.i.a.d(pVar.b()));
                }
                if (this.s.get() && i == 15001) {
                    if (this.D.get() && !this.C.get()) {
                        u.d("splashLoadAd", "如果缓存先回来,实时还没有回来，实时是否渲染成功 " + this.m.get() + " 缓存渲染是否成功 " + this.n.get());
                        if (this.l.get() && this.n.get()) {
                            u.d("splashLoadAd", "缓存赋值给resultTemp");
                            this.E = aVar;
                            u.d("splashLoadAd", "如果缓存先回来,实时还没有回来，等待实时回来");
                            return;
                        }
                    }
                    if (this.C.get() && this.i != null && this.i.a()) {
                        u.d("splashLoadAd", "此时实时可能在渲染，避免缓存的渲染成功后直接被回调");
                        return;
                    }
                }
                if (i == 15000) {
                    u.d("splashLoadAd", "splashAdTryCallback 实时或渲染成功回调......！");
                }
                if (this.s.get() && i == 15000 && !this.m.get()) {
                    u.b("splashLoadAd", "优先实时，且实时类型广告图片加载成功；如果是模板广告且渲染未成功，则继续等待");
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("splashAdTryCallback..（ 是否缓存已check成功：");
                sb.append(this.l.get());
                sb.append(" || 是否渲染超时：");
                sb.append(i == 15003);
                sb.append(" || 是否为实时请求");
                if (i != 15000) {
                    z = false;
                }
                sb.append(z);
                sb.append("） && （是否实时模版渲染完成：");
                sb.append(this.m.get());
                sb.append(" || 是否缓存模版渲染完成：");
                sb.append(this.n.get());
                sb.append("）");
                u.b("splashLoadAd", sb.toString());
                if ((this.l.get() || i == 15000 || i == 15003) && (this.m.get() || this.n.get())) {
                    a(i);
                    a(aVar);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(int i) {
        if (this.y == null) {
            return;
        }
        if (i == 15000 && this.m.get()) {
            this.y.a("real_time_ad");
        } else {
            this.y.a("cache_ad");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.bytedance.sdk.openadsdk.i.a.d dVar) {
        if (dVar == null || this.y == null) {
            return;
        }
        byte[] b2 = dVar.b();
        if (b2 != null && this.y.i() == 0.0d) {
            this.y.a(b2.length / 1024.0f);
        }
        Bitmap a2 = dVar.a();
        if (a2 != null && TextUtils.isEmpty(this.y.j())) {
            this.y.b(a2.getWidth() + "X" + a2.getHeight());
        }
        Map<String, String> e2 = dVar.e();
        if (e2 == null || e2.size() <= 0 || this.y.k() != null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        for (String str : e2.keySet()) {
            if (!TextUtils.isEmpty(str)) {
                try {
                    jSONObject.put(str, e2.get(str));
                } catch (Exception e3) {
                    u.f("SplashAdLoadManager", e3.getMessage());
                }
            }
        }
        this.y.a(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e a(com.bytedance.sdk.openadsdk.core.d.p pVar, String str) {
        if (c.a(pVar)) {
            if (str != null) {
                pVar.a().d(true);
            }
            e eVar = new e(this.f27618e, pVar.a(), str, this.f27614a, "splash_ad");
            this.f27621h = eVar;
            return eVar;
        }
        return null;
    }

    private synchronized void a(a aVar) {
        u.f("splashLoadAd", "onCallback ......");
        i();
        if (aVar == null) {
            u.a("splashAdListener is null, then return");
            j.remove(this);
        } else if (this.f27616c == null) {
            u.a("splashAdListener is null, then return");
            if (aVar.f27662a == 3) {
                a(aVar.f27666e);
            }
            j.remove(this);
        } else if (!this.f27620g.get()) {
            this.f27620g.set(true);
            int i = aVar.f27662a;
            if (i == 1) {
                c(aVar.f27666e);
                this.f27616c.onSplashAdLoad(aVar.f27665d);
                d(this.A);
            } else if (i == 2) {
                u.f("splashLoadAd", "onCallback CALLBACK_RESULT_FAILED");
                b(aVar.f27666e);
                this.f27616c.onError(aVar.f27663b, aVar.f27664c);
            } else if (i != 3) {
                this.f27616c.onError(-2, h.a(-2));
            } else {
                u.f("splashLoadAd", "onCallback CALLBACK_RESULT_TIMEOUT");
                a(aVar.f27666e);
                this.f27616c.onTimeout();
            }
            if (this.f27619f != null) {
                this.f27619f.removeMessages(2);
                this.f27619f.removeMessages(3);
            }
            this.f27616c = null;
            j.remove(this);
        } else {
            this.f27616c = null;
            if (aVar.f27662a == 3) {
                a(aVar.f27666e);
            }
            j.remove(this);
        }
    }

    private void a(com.bytedance.sdk.openadsdk.h.a.c cVar) {
        u.f("splashLoadAd", "onLogTimeoutEvent");
        b(cVar);
        com.bytedance.sdk.openadsdk.h.a.a().g(cVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00e5, code lost:
        if (r14 != null) goto L33;
     */
    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Message message) {
        e eVar;
        if (message.what == 1) {
            if (!this.f27620g.get()) {
                this.f27620g.set(true);
                b();
                u.b("SplashAdLoadManager", "尝试从缓存中取");
            } else {
                i();
                u.b("SplashAdLoadManager", "开始预加载");
            }
            this.f27619f.removeCallbacksAndMessages(null);
        }
        if (message.what == 2) {
            this.f27619f.removeCallbacksAndMessages(null);
            if (this.f27620g.get()) {
                return;
            }
            u.b("splashLoadAd", "MSG_USER_TIME_OUT----7-");
            a(15004, new a(3, 0, null, null, a(0, (com.bytedance.sdk.openadsdk.core.d.p) null)), (com.bytedance.sdk.openadsdk.core.d.p) null, (e) null, (String) null);
        }
        int i = 3;
        if (message.what == 3) {
            this.f27619f.removeMessages(3);
            if (this.f27620g.get()) {
                return;
            }
            this.m.set(true);
            this.n.set(true);
            int q = p.h().q();
            if (q == 0) {
                eVar = this.i;
            } else if (q != 1) {
                if (q != 2) {
                    if (q == 3) {
                        if (this.f27621h == null || !this.l.get()) {
                            eVar = null;
                        } else {
                            u.b("splashLoadAd", "谁回来用谁//--mCacheTTSplashAd");
                            eVar = this.f27621h;
                            i = 4;
                        }
                        if (this.i != null) {
                            u.b("splashLoadAd", "谁回来用谁//--mRealNetWorkTTSplashAd");
                            eVar = this.i;
                        }
                    }
                    eVar = null;
                } else {
                    eVar = this.i;
                    if (eVar != null) {
                        u.b("splashLoadAd", "超时使用实时--mRealNetWorkTTSplashAd");
                    } else {
                        if (this.f27621h != null && this.l.get()) {
                            u.b("splashLoadAd", "超时使用实时//--mCacheTTSplashAd");
                            eVar = this.f27621h;
                            i = 4;
                        }
                        eVar = null;
                    }
                }
            } else if (this.f27621h != null && this.l.get()) {
                eVar = this.f27621h;
                i = 4;
            } else {
                eVar = this.i;
            }
            if (eVar != null && eVar.a()) {
                u.f("splashLoadAd", "超时了 temp != null ");
                a(15003, new a(1, 0, null, eVar, a(i, (com.bytedance.sdk.openadsdk.core.d.p) null)), (com.bytedance.sdk.openadsdk.core.d.p) null, eVar, (String) null);
                return;
            }
            u.f("splashLoadAd", "超时了 开始加载在线视频");
            j();
        }
    }
}
