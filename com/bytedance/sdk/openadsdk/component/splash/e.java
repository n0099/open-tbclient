package com.bytedance.sdk.openadsdk.component.splash;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.TTSplashAd;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.TTCountdownView;
import com.bytedance.sdk.openadsdk.e.a;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes5.dex */
public class e implements TTSplashAd {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f28518a;

    /* renamed from: b  reason: collision with root package name */
    public AtomicBoolean f28519b;

    /* renamed from: c  reason: collision with root package name */
    public int f28520c;

    /* renamed from: d  reason: collision with root package name */
    public final Context f28521d;

    /* renamed from: e  reason: collision with root package name */
    public final l f28522e;

    /* renamed from: f  reason: collision with root package name */
    public TsView f28523f;

    /* renamed from: g  reason: collision with root package name */
    public TTSplashAd.AdInteractionListener f28524g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28525h;

    /* renamed from: i  reason: collision with root package name */
    public long f28526i;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a j;
    public d k;
    public String l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public NativeExpressView r;
    public String s;
    public AdSlot t;
    public TTNativeExpressAd.ExpressAdInteractionListener u;
    public AtomicBoolean v;
    public AtomicBoolean w;
    public TTAppDownloadListener x;

    public e(@NonNull Context context, @NonNull l lVar, AdSlot adSlot, String str) {
        this.f28520c = 3;
        this.f28526i = 0L;
        this.l = null;
        this.m = false;
        this.n = false;
        this.p = true;
        this.q = -1;
        this.v = new AtomicBoolean(false);
        this.w = new AtomicBoolean(false);
        this.f28518a = new AtomicBoolean(false);
        this.f28519b = new AtomicBoolean(false);
        this.f28521d = context;
        this.f28522e = lVar;
        this.n = lVar.ax();
        this.t = adSlot;
        this.s = str;
        b();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public int getInteractionType() {
        l lVar = this.f28522e;
        if (lVar == null) {
            return -1;
        }
        return lVar.Z();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.f28522e;
        if (lVar != null) {
            return lVar.ay();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    @NonNull
    public View getSplashView() {
        l lVar = this.f28522e;
        if (lVar == null || lVar.X() == null || this.f28523f.getVideoContainer() == null || this.l == null || c()) {
            return this.f28523f;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        NativeExpressView nativeExpressView;
        if (expressAdInteractionListener == null || (nativeExpressView = this.r) == null) {
            return;
        }
        this.u = expressAdInteractionListener;
        nativeExpressView.h();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.x = tTAppDownloadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setNotAllowSdkCountdown() {
        this.f28525h = true;
        TsView tsView = this.f28523f;
        if (tsView != null) {
            tsView.setSkipIconVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setSplashInteractionListener(TTSplashAd.AdInteractionListener adInteractionListener) {
        this.f28524g = adInteractionListener;
    }

    private void b() {
        this.f28523f = new TsView(this.f28521d);
        com.bytedance.sdk.openadsdk.c.d.a(this.f28522e);
        if (this.f28522e.X() != null && this.n) {
            this.f28523f.setVideoViewVisibility(0);
            this.f28523f.setImageViewVisibility(8);
            this.f28523f.setVoiceViewListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.f28523f.setVoiceViewImageResource(e.this.p ? ad.d(e.this.f28521d, "tt_splash_unmute") : ad.d(e.this.f28521d, "tt_splash_mute"));
                    e eVar = e.this;
                    eVar.p = !eVar.p;
                    if (e.this.k != null) {
                        e.this.k.c(e.this.p);
                    }
                }
            });
        }
        if (!this.n) {
            this.f28523f.setVideoViewVisibility(8);
            this.f28523f.setImageViewVisibility(0);
        }
        if (this.f28522e.m() == 0) {
            TsView tsView = this.f28523f;
            if (tsView != null) {
                tsView.setAdlogoViewVisibility(8);
            }
        } else {
            TsView tsView2 = this.f28523f;
            if (tsView2 != null) {
                tsView2.setAdlogoViewVisibility(0);
            }
        }
        if (this.f28522e.au() <= 0) {
            a(3);
        } else {
            int au = this.f28522e.au();
            this.f28520c = au;
            a(au);
        }
        a(this.f28522e);
        e();
        d();
    }

    private boolean c() {
        this.k = new d(this.f28521d, this.f28523f.getVideoContainer(), this.f28522e);
        u.f("wzj", "mVideoCachePath:" + this.l);
        this.k.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                if (e.this.k != null) {
                    e.this.k.m();
                }
                if (e.this.f28524g != null) {
                    e.this.f28524g.onAdTimeOver();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, long j2) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j, int i2) {
            }
        });
        boolean a2 = this.k.a(this.l, this.f28522e.am(), this.f28523f.getVideoContainer().getWidth(), this.f28523f.getVideoContainer().getHeight(), null, this.f28522e.ap(), 0L, this.p);
        this.o = a2;
        return a2;
    }

    private void d() {
        l lVar = this.f28522e;
        if (lVar == null || lVar.d() == 1) {
            return;
        }
        if (this.f28522e.X() == null) {
            this.r = new NativeExpressView(this.f28521d, this.f28522e, this.t, this.s);
        } else if (!TextUtils.isEmpty(this.l)) {
            com.bytedance.sdk.openadsdk.core.video.a.a.a(this.f28522e.X().i(), this.l);
            this.r = new NativeExpressVideoView(this.f28521d, this.f28522e, this.t, this.s);
        }
        NativeExpressView nativeExpressView = this.r;
        if (nativeExpressView == null) {
            return;
        }
        a(nativeExpressView, this.f28522e);
        this.r.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.3
            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdClicked(View view, int i2) {
                if (e.this.u != null) {
                    e.this.u.onAdClicked(view, i2);
                }
                if (e.this.f28524g != null) {
                    e.this.f28524g.onAdClicked(view, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onAdShow(View view, int i2) {
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderFail(View view, String str, int i2) {
                u.f("splash", "onRenderFail:" + str);
                if (e.this.u != null) {
                    e.this.u.onRenderFail(view, str, i2);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
            public void onRenderSuccess(View view, float f2, float f3) {
                if (e.this.v.get()) {
                    return;
                }
                if (view == null || f2 <= 0.0f || f3 <= 0.0f) {
                    e.this.u.onRenderFail(view, "width <=0 or height <= 0", 110);
                    return;
                }
                e.this.f28523f.a(8, 0, 0, 0, 0);
                e.this.f28523f.setExpressView(e.this.r);
                if (e.this.u != null) {
                    e.this.u.onRenderSuccess(view, f2, f3);
                }
                e.this.w.set(true);
            }
        });
    }

    private void e() {
        if (this.f28522e.X() != null) {
            if (this.l != null) {
                this.q = 1;
            } else {
                this.q = 2;
            }
        } else {
            this.q = 0;
        }
        this.j = b(this.f28522e);
        EmptyView emptyView = new EmptyView(this.f28521d, this.f28523f);
        emptyView.setAdType(3);
        this.f28523f.addView(emptyView);
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.j;
        if (aVar != null) {
            aVar.a(emptyView);
        }
        a(false);
        emptyView.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.6
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (e.this.j != null) {
                    if (z) {
                        e.this.j.b();
                    } else {
                        e.this.j.c();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (e.this.j != null) {
                            e.this.j.d();
                        }
                    }
                }, 1000L);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                e.this.v.set(true);
                if (e.this.j != null) {
                    e.this.j.a();
                }
                if (e.this.j == null || e.this.f28523f == null || e.this.f28523f.getParent() == null) {
                    return;
                }
                Context context = null;
                try {
                    context = ((View) e.this.f28523f.getParent()).getContext();
                } catch (Exception unused) {
                }
                if (context == null || !(context instanceof Activity)) {
                    return;
                }
                e.this.j.a((Activity) context);
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                TTCountdownView countDownView;
                e.this.v.set(true);
                e.this.f28526i = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                if (e.this.f28522e != null) {
                    if (e.this.f28522e.X() != null) {
                        if (e.this.l != null) {
                            hashMap.put("splash_show_type", 1);
                        } else {
                            hashMap.put("splash_show_type", 2);
                        }
                    } else {
                        hashMap.put("splash_show_type", 0);
                    }
                }
                if (e.this.w.get()) {
                    hashMap.put("splash_show_type", 3);
                }
                u.e("AdEvent", "pangolin ad show " + ak.a(e.this.f28522e, view));
                com.bytedance.sdk.openadsdk.c.d.a(e.this.f28521d, e.this.f28522e, e.this.s, hashMap);
                if (!e.this.f28525h && e.this.f28523f != null && (countDownView = e.this.f28523f.getCountDownView()) != null) {
                    countDownView.setCountdownListener(new TTCountdownView.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.6.2
                        @Override // com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.a
                        public void a() {
                            e.this.g();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.a
                        public void b() {
                            if (e.this.f28524g != null) {
                                e.this.f28524g.onAdTimeOver();
                            }
                            try {
                                if (e.this.k != null) {
                                    if (e.this.k.A()) {
                                        e.this.k.c(true);
                                    }
                                    if (!e.this.w.get()) {
                                        e.this.k.b();
                                    }
                                    e.this.k.m();
                                }
                            } catch (Throwable unused) {
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.a
                        public void c() {
                            e.this.f();
                        }
                    });
                    if (!e.this.f28519b.get()) {
                        countDownView.a();
                    }
                }
                if (e.this.f28524g != null) {
                    e.this.f28524g.onAdShow(e.this.f28523f, e.this.f28522e.Z());
                }
                u.b("TTSplashAdImpl", "bindViewInteraction 开屏广告展示");
            }
        });
        emptyView.setNeedCheckingShow(true);
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(this.q));
        com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this.f28521d, this.f28522e, this.s, 4);
        aVar2.a(hashMap);
        l lVar = this.f28522e;
        if (lVar != null && this.f28523f != null) {
            if (lVar.M() == 2) {
                View fullClickBarView = this.f28523f.getFullClickBarView();
                if (fullClickBarView != null) {
                    aVar2.a(fullClickBarView);
                    fullClickBarView.setOnClickListener(aVar2);
                    fullClickBarView.setOnTouchListener(aVar2);
                }
            } else {
                aVar2.a(this.f28523f);
                this.f28523f.setOnClickListenerInternal(aVar2);
                this.f28523f.setOnTouchListenerInternal(aVar2);
            }
        }
        aVar2.b(this.f28523f.getDislikeView());
        aVar2.a(this.j);
        aVar2.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.7
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i2) {
                if (e.this.f28524g != null) {
                    e.this.f28524g.onAdClicked(view, i2);
                }
            }
        });
        this.f28523f.setSkipListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.f28522e != null && e.this.f28522e.X() != null && e.this.o && e.this.k != null) {
                    e.this.k.m();
                    if (!e.this.w.get()) {
                        e eVar = e.this;
                        eVar.a(eVar.s, "feed_break");
                    }
                }
                if (!TextUtils.isEmpty(e.this.f28522e.ap())) {
                    com.bytedance.sdk.openadsdk.c.d.a(e.this.f28521d, e.this.f28526i > 0 ? System.currentTimeMillis() - e.this.f28526i : 0L, e.this.f28522e);
                }
                if (e.this.f28524g != null) {
                    e.this.f28520c = 0;
                    e.this.f28524g.onAdSkip();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (this.k != null) {
                this.k.h();
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            if (this.k != null) {
                this.k.k();
            }
        } catch (Throwable unused) {
        }
    }

    private void a(l lVar) {
        if (lVar == null || this.f28523f == null) {
            return;
        }
        int M = lVar.M();
        String N = lVar.N();
        int P = lVar.P();
        int O = lVar.O();
        int Q = lVar.Q();
        int R = lVar.R();
        if (M == 2) {
            if (!TextUtils.isEmpty(N)) {
                this.f28523f.a(0, P, O, Q, R);
                this.f28523f.setClickBarDesc(N);
                return;
            }
            this.f28523f.a(0, P, O, Q, R);
            this.f28523f.setClickBarDesc("查看详情");
        } else if (TextUtils.isEmpty(N)) {
            this.f28523f.a(8, P, O, Q, R);
        } else {
            this.f28523f.a(0, P, O, Q, R);
            this.f28523f.setClickBarDesc(N);
        }
    }

    public e(@NonNull Context context, @NonNull l lVar, String str, AdSlot adSlot, String str2) {
        this.f28520c = 3;
        this.f28526i = 0L;
        this.l = null;
        this.m = false;
        this.n = false;
        this.p = true;
        this.q = -1;
        this.v = new AtomicBoolean(false);
        this.w = new AtomicBoolean(false);
        this.f28518a = new AtomicBoolean(false);
        this.f28519b = new AtomicBoolean(false);
        this.f28521d = context;
        this.f28522e = lVar;
        this.n = lVar.ax();
        this.l = str;
        this.t = adSlot;
        this.s = str2;
        b();
    }

    private void a(@NonNull NativeExpressView nativeExpressView, @NonNull l lVar) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a b2 = b(lVar);
        this.j = b2;
        if (b2 != null) {
            b2.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.j.a((Activity) nativeExpressView.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.c.d.a(lVar);
        EmptyView emptyView = new EmptyView(this.f28521d, nativeExpressView);
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.j;
        if (aVar != null) {
            aVar.a(emptyView);
        }
        emptyView.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.4
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (e.this.j != null) {
                    if (z) {
                        if (e.this.j != null) {
                            e.this.j.b();
                        }
                    } else if (e.this.j != null) {
                        e.this.j.c();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (e.this.j != null) {
                    e.this.j.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (e.this.j != null) {
                    e.this.j.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                if (e.this.r != null) {
                    e.this.r.g();
                }
            }
        });
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", 3);
        Context context = this.f28521d;
        String str = this.s;
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(context, lVar, str, ak.a(str));
        eVar.a(nativeExpressView);
        eVar.a(this.j);
        eVar.a(hashMap);
        this.r.setClickListener(eVar);
        Context context2 = this.f28521d;
        String str2 = this.s;
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(context2, lVar, str2, ak.a(str2));
        dVar.a(nativeExpressView);
        dVar.a(this.j);
        dVar.a(hashMap);
        this.r.setClickCreativeListener(dVar);
        emptyView.setNeedCheckingShow(true);
        a(true);
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a b(l lVar) {
        if (lVar.Z() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28521d, lVar, this.s);
        }
        return null;
    }

    public void a(com.bytedance.sdk.openadsdk.i.a.d dVar) {
        Drawable a2;
        if (dVar.d()) {
            this.f28523f.setGifView(dVar.b());
        } else if (this.f28522e.af() == null || this.f28522e.af().get(0) == null) {
        } else {
            if (dVar.a() != null) {
                a2 = new BitmapDrawable(dVar.a());
            } else {
                a2 = o.a(dVar.b(), this.f28522e.af().get(0).b());
            }
            this.f28523f.setDrawable(a2);
        }
    }

    private void a(final boolean z) {
        if (this.j == null) {
            return;
        }
        l lVar = this.f28522e;
        final String am = lVar != null ? lVar.am() : "";
        this.j.a(new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.5
            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadActive(long j, long j2, String str, String str2) {
                if (e.this.x != null) {
                    e.this.x.onDownloadActive(j, j2, str, str2);
                }
                if (!z || j <= 0) {
                    return;
                }
                a.C0316a.a(am, 3, (int) ((j2 * 100) / j));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFailed(long j, long j2, String str, String str2) {
                if (e.this.x != null) {
                    e.this.x.onDownloadFailed(j, j2, str, str2);
                }
                if (!z || j <= 0) {
                    return;
                }
                a.C0316a.a(am, 4, (int) ((j2 * 100) / j));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadFinished(long j, String str, String str2) {
                if (e.this.x != null) {
                    e.this.x.onDownloadFinished(j, str, str2);
                }
                if (z) {
                    a.C0316a.a(am, 5, 100);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onDownloadPaused(long j, long j2, String str, String str2) {
                if (e.this.x != null) {
                    e.this.x.onDownloadPaused(j, j2, str, str2);
                }
                if (!z || j <= 0) {
                    return;
                }
                a.C0316a.a(am, 2, (int) ((j2 * 100) / j));
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onIdle() {
                if (e.this.x != null) {
                    e.this.x.onIdle();
                }
                if (z) {
                    a.C0316a.a(am, 1, 0);
                }
            }

            @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
            public void onInstalled(String str, String str2) {
                if (e.this.x != null) {
                    e.this.x.onInstalled(str, str2);
                }
                if (z) {
                    a.C0316a.a(am, 6, 100);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        d dVar = this.k;
        if (dVar != null) {
            com.bytedance.sdk.openadsdk.c.d.a(this.f28521d, this.f28522e, str, str2, this.k.p(), this.k.r(), ak.a(this.f28522e, dVar.o(), this.k.u()));
        }
    }

    public boolean a() {
        l lVar = this.f28522e;
        return lVar != null && lVar.d() == 2;
    }

    private void a(int i2) {
        TsView tsView = this.f28523f;
        if (tsView != null) {
            tsView.setCountDownTime(i2);
        }
    }
}
