package com.bytedance.sdk.openadsdk.component.splash;

import android.app.Activity;
import android.content.Context;
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
import com.bytedance.sdk.openadsdk.d.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.o;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
/* loaded from: classes6.dex */
public class e implements TTSplashAd {

    /* renamed from: a  reason: collision with root package name */
    public AtomicBoolean f4343a;
    public AtomicBoolean b;
    private int c;
    private final Context d;
    private final l e;
    private TsView f;
    private TTSplashAd.AdInteractionListener g;
    private boolean h;
    private long i;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a j;
    private d k;
    private String l;
    private boolean m;
    private boolean n;
    private boolean o;
    private boolean p;
    private int q;
    private NativeExpressView r;
    private String s;
    private AdSlot t;
    private TTNativeExpressAd.ExpressAdInteractionListener u;
    private AtomicBoolean v;
    private AtomicBoolean w;
    private TTAppDownloadListener x;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(@NonNull Context context, @NonNull l lVar, AdSlot adSlot, String str) {
        this.c = 3;
        this.i = 0L;
        this.l = null;
        this.m = false;
        this.n = false;
        this.p = true;
        this.q = -1;
        this.v = new AtomicBoolean(false);
        this.w = new AtomicBoolean(false);
        this.f4343a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.d = context;
        this.e = lVar;
        this.n = lVar.aq();
        this.t = adSlot;
        this.s = str;
        b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(@NonNull Context context, @NonNull l lVar, String str, AdSlot adSlot, String str2) {
        this.c = 3;
        this.i = 0L;
        this.l = null;
        this.m = false;
        this.n = false;
        this.p = true;
        this.q = -1;
        this.v = new AtomicBoolean(false);
        this.w = new AtomicBoolean(false);
        this.f4343a = new AtomicBoolean(false);
        this.b = new AtomicBoolean(false);
        this.d = context;
        this.e = lVar;
        this.n = lVar.aq();
        this.l = str;
        this.t = adSlot;
        this.s = str2;
        b();
    }

    private void b() {
        this.f = new TsView(this.d);
        com.bytedance.sdk.openadsdk.c.d.a(this.e);
        if (this.e.R() != null && this.n) {
            this.f.setVideoViewVisibility(0);
            this.f.setImageViewVisibility(8);
            this.f.setVoiceViewListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    e.this.f.setVoiceViewImageResource(e.this.p ? ac.d(e.this.d, "tt_splash_unmute") : ac.d(e.this.d, "tt_splash_mute"));
                    e.this.p = !e.this.p;
                    if (e.this.k != null) {
                        e.this.k.c(e.this.p);
                    }
                }
            });
        }
        if (!this.n) {
            this.f.setVideoViewVisibility(8);
            this.f.setImageViewVisibility(0);
        }
        if (this.e.m() == 0) {
            if (this.f != null) {
                this.f.setAdlogoViewVisibility(8);
            }
        } else if (this.f != null) {
            this.f.setAdlogoViewVisibility(0);
        }
        if (this.e.an() <= 0) {
            a(3);
        } else {
            this.c = this.e.an();
            a(this.c);
        }
        e();
        d();
    }

    private boolean c() {
        this.k = new d(this.d, this.f.getVideoContainer(), this.e);
        u.f("wzj", "mVideoCachePath:" + this.l);
        this.k.a(new c.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.2
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void b(long j, int i) {
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a() {
                if (e.this.k != null) {
                    e.this.k.m();
                }
                if (e.this.g != null) {
                    e.this.g.onAdTimeOver();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
            public void a(long j, long j2) {
            }
        });
        boolean a2 = this.k.a(this.l, this.e.ag(), this.f.getVideoContainer().getWidth(), this.f.getVideoContainer().getHeight(), null, this.e.aj(), 0L, this.p);
        this.o = a2;
        return a2;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void renderExpressAd(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        if (expressAdInteractionListener != null && this.r != null) {
            this.u = expressAdInteractionListener;
            this.r.h();
        }
    }

    private void d() {
        if (this.e != null && this.e.d() != 1) {
            if (this.e.R() == null) {
                this.r = new NativeExpressView(this.d, this.e, this.t, this.s);
            } else if (!TextUtils.isEmpty(this.l)) {
                com.bytedance.sdk.openadsdk.core.video.a.a.a(this.e.R().i(), this.l);
                this.r = new NativeExpressVideoView(this.d, this.e, this.t, this.s);
            }
            if (this.r != null) {
                a(this.r, this.e);
                this.r.setExpressInteractionListener(new TTNativeExpressAd.ExpressAdInteractionListener() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.3
                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdClicked(View view, int i) {
                        if (e.this.u != null) {
                            e.this.u.onAdClicked(view, i);
                        }
                        if (e.this.g != null) {
                            e.this.g.onAdClicked(view, i);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onAdShow(View view, int i) {
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderFail(View view, String str, int i) {
                        u.f("splash", "onRenderFail:" + str);
                        if (e.this.u != null) {
                            e.this.u.onRenderFail(view, str, i);
                        }
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTNativeExpressAd.ExpressAdInteractionListener
                    public void onRenderSuccess(View view, float f, float f2) {
                        if (!e.this.v.get()) {
                            if (view == null || f <= 0.0f || f2 <= 0.0f) {
                                e.this.u.onRenderFail(view, "width <=0 or height <= 0", 110);
                                return;
                            }
                            e.this.f.setExpressView(e.this.r);
                            if (e.this.u != null) {
                                e.this.u.onRenderSuccess(view, f, f2);
                            }
                            e.this.w.set(true);
                        }
                    }
                });
            }
        }
    }

    private void a(@NonNull NativeExpressView nativeExpressView, @NonNull l lVar) {
        this.j = a(lVar);
        if (this.j != null) {
            this.j.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.j.a((Activity) nativeExpressView.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.c.d.a(lVar);
        EmptyView emptyView = new EmptyView(this.d, nativeExpressView);
        if (this.j != null) {
            this.j.a(emptyView);
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
            public void a() {
                if (e.this.j != null) {
                    e.this.j.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (e.this.j != null) {
                    e.this.j.d();
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
        com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(this.d, lVar, this.s, aj.a(this.s));
        eVar.a(nativeExpressView);
        eVar.a(this.j);
        eVar.a(hashMap);
        this.r.setClickListener(eVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.d, lVar, this.s, aj.a(this.s));
        dVar.a(nativeExpressView);
        dVar.a(this.j);
        dVar.a(hashMap);
        this.r.setClickCreativeListener(dVar);
        emptyView.setNeedCheckingShow(true);
        a(this.j, this.r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(byte[] bArr) {
        if (b(bArr)) {
            this.f.setGifView(bArr);
        } else if (this.e.Z() != null && this.e.Z().get(0) != null) {
            this.f.setDrawable(o.a(bArr, this.e.Z().get(0).b()));
        }
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, NativeExpressView nativeExpressView) {
        if (aVar != null && nativeExpressView != null) {
            final String str = "";
            if (this.e != null) {
                str = this.e.ag();
            }
            aVar.a(new TTAppDownloadListener() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.5
                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onIdle() {
                    if (e.this.x != null) {
                        e.this.x.onIdle();
                    }
                    a.C1028a.a(str, 1, 0);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadActive(long j, long j2, String str2, String str3) {
                    if (e.this.x != null) {
                        e.this.x.onDownloadActive(j, j2, str2, str3);
                    }
                    if (j > 0) {
                        a.C1028a.a(str, 3, (int) ((100 * j2) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadPaused(long j, long j2, String str2, String str3) {
                    if (e.this.x != null) {
                        e.this.x.onDownloadPaused(j, j2, str2, str3);
                    }
                    if (j > 0) {
                        a.C1028a.a(str, 2, (int) ((100 * j2) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFailed(long j, long j2, String str2, String str3) {
                    if (e.this.x != null) {
                        e.this.x.onDownloadFailed(j, j2, str2, str3);
                    }
                    if (j > 0) {
                        a.C1028a.a(str, 4, (int) ((100 * j2) / j));
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onDownloadFinished(long j, String str2, String str3) {
                    if (e.this.x != null) {
                        e.this.x.onDownloadFinished(j, str2, str3);
                    }
                    a.C1028a.a(str, 5, 100);
                }

                @Override // com.bytedance.sdk.openadsdk.TTAppDownloadListener
                public void onInstalled(String str2, String str3) {
                    if (e.this.x != null) {
                        e.this.x.onInstalled(str2, str3);
                    }
                    a.C1028a.a(str, 6, 100);
                }
            });
        }
    }

    private boolean b(byte[] bArr) {
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    private void e() {
        if (this.e.R() != null) {
            if (this.l != null) {
                this.q = 1;
            } else {
                this.q = 2;
            }
        } else {
            this.q = 0;
        }
        this.j = a(this.e);
        EmptyView emptyView = new EmptyView(this.d, this.f);
        emptyView.setAdType(3);
        this.f.addView(emptyView);
        if (this.j != null) {
            this.j.a(emptyView);
        }
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
            public void a() {
                Context context;
                e.this.v.set(true);
                if (e.this.j != null) {
                    e.this.j.a();
                }
                if (e.this.j != null && e.this.f != null && e.this.f.getParent() != null) {
                    try {
                        context = ((View) e.this.f.getParent()).getContext();
                    } catch (Exception e) {
                        context = null;
                    }
                    if (context != null && (context instanceof Activity)) {
                        e.this.j.a((Activity) context);
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
            public void a(View view) {
                TTCountdownView countDownView;
                e.this.v.set(true);
                e.this.i = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                if (e.this.e != null) {
                    if (e.this.e.R() != null) {
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
                u.e("AdEvent", "pangolin ad show " + aj.a(e.this.e, view));
                com.bytedance.sdk.openadsdk.c.d.a(e.this.d, e.this.e, e.this.s, hashMap);
                if (!e.this.h && e.this.f != null && (countDownView = e.this.f.getCountDownView()) != null) {
                    countDownView.setCountdownListener(new TTCountdownView.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.6.2
                        @Override // com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.a
                        public void a() {
                            e.this.g();
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.a
                        public void b() {
                            if (e.this.g != null) {
                                e.this.g.onAdTimeOver();
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
                            } catch (Throwable th) {
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.core.widget.TTCountdownView.a
                        public void c() {
                            e.this.f();
                        }
                    });
                    if (!e.this.b.get()) {
                        countDownView.a();
                    }
                }
                if (e.this.g != null) {
                    e.this.g.onAdShow(e.this.f, e.this.e.T());
                }
                u.b("TTSplashAdImpl", "bindViewInteraction 开屏广告展示");
            }
        });
        emptyView.setNeedCheckingShow(true);
        HashMap hashMap = new HashMap();
        hashMap.put("splash_show_type", Integer.valueOf(this.q));
        com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this.d, this.e, this.s, 4);
        aVar.a(hashMap);
        aVar.a(this.f);
        aVar.b(this.f.getDislikeView());
        aVar.a(this.j);
        aVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.7
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (e.this.g != null) {
                    e.this.g.onAdClicked(view, i);
                }
            }
        });
        this.f.setOnClickListenerInternal(aVar);
        this.f.setOnTouchListenerInternal(aVar);
        this.f.setSkipListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.component.splash.e.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (e.this.e != null && e.this.e.R() != null && e.this.o && e.this.k != null) {
                    e.this.k.m();
                    if (!e.this.w.get()) {
                        e.this.a(e.this.s, "feed_break");
                    }
                }
                if (!TextUtils.isEmpty(e.this.e.aj())) {
                    com.bytedance.sdk.openadsdk.c.d.a(e.this.d, e.this.i > 0 ? System.currentTimeMillis() - e.this.i : 0L, e.this.e);
                }
                if (e.this.g != null) {
                    e.this.c = 0;
                    e.this.g.onAdSkip();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        if (this.k != null) {
            com.bytedance.sdk.openadsdk.c.d.a(this.d, this.e, str, str2, this.k.p(), this.k.r(), aj.a(this.e, this.k.o(), this.k.u()));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    @NonNull
    public View getSplashView() {
        if (this.e == null || this.e.R() == null || this.f.getVideoContainer() == null || this.l == null || c()) {
            return this.f;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public int getInteractionType() {
        if (this.e == null) {
            return -1;
        }
        return this.e.T();
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setSplashInteractionListener(TTSplashAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.x = tTAppDownloadListener;
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(l lVar) {
        if (lVar.T() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.d, lVar, this.s);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public void setNotAllowSdkCountdown() {
        this.h = true;
        if (this.f != null) {
            this.f.setSkipIconVisibility(8);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTSplashAd
    public Map<String, Object> getMediaExtraInfo() {
        if (this.e != null) {
            return this.e.ar();
        }
        return null;
    }

    public boolean a() {
        return this.e != null && this.e.d() == 2;
    }

    private void a(int i) {
        if (this.f != null) {
            this.f.setCountDownTime(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            if (this.k != null) {
                this.k.h();
            }
        } catch (Throwable th) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        try {
            if (this.k != null) {
                this.k.k();
            }
        } catch (Throwable th) {
        }
    }
}
