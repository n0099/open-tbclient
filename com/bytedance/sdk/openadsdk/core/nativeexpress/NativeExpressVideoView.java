package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
/* loaded from: classes6.dex */
public class NativeExpressVideoView extends NativeExpressView implements g, c.b, c.InterfaceC0297c {

    /* renamed from: a  reason: collision with root package name */
    public int f28291a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28292b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28293c;

    /* renamed from: d  reason: collision with root package name */
    public int f28294d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28295e;
    public ExpressVideoView v;
    public com.bytedance.sdk.openadsdk.multipro.b.a w;
    public long x;
    public long y;

    public NativeExpressVideoView(@NonNull Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot, String str) {
        super(context, lVar, adSlot, str);
        this.f28291a = 1;
        this.f28292b = false;
        this.f28293c = true;
        this.f28295e = true;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.d.o oVar) {
        if (oVar == null) {
            return;
        }
        double e2 = oVar.e();
        double f2 = oVar.f();
        double g2 = oVar.g();
        double h2 = oVar.h();
        int a2 = (int) al.a(this.f28305g, (float) e2);
        int a3 = (int) al.a(this.f28305g, (float) f2);
        int a4 = (int) al.a(this.f28305g, (float) g2);
        int a5 = (int) al.a(this.f28305g, (float) h2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.n.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new FrameLayout.LayoutParams(a4, a5);
        }
        layoutParams.width = a4;
        layoutParams.height = a5;
        layoutParams.topMargin = a3;
        layoutParams.leftMargin = a2;
        this.n.setLayoutParams(layoutParams);
        this.n.removeAllViews();
        ExpressVideoView expressVideoView = this.v;
        if (expressVideoView != null) {
            this.n.addView(expressVideoView);
            this.v.a(0L, true, false);
            a(this.f28294d);
            if (!x.d(this.f28305g) && !this.f28293c && this.f28295e) {
                this.v.e();
            }
            setShowAdInteractionView(false);
        }
    }

    private void n() {
        try {
            this.w = new com.bytedance.sdk.openadsdk.multipro.b.a();
            ExpressVideoView expressVideoView = new ExpressVideoView(this.f28305g, this.l, this.j);
            this.v = expressVideoView;
            expressVideoView.setShouldCheckNetChange(false);
            this.v.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                public void a(boolean z, long j, long j2, long j3, boolean z2) {
                    NativeExpressVideoView.this.w.f29722a = z;
                    NativeExpressVideoView.this.w.f29726e = j;
                    NativeExpressVideoView.this.w.f29727f = j2;
                    NativeExpressVideoView.this.w.f29728g = j3;
                    NativeExpressVideoView.this.w.f29725d = z2;
                }
            });
            this.v.setVideoAdLoadListener(this);
            this.v.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.j)) {
                this.v.setIsAutoPlay(this.f28292b ? this.k.isAutoPlay() : this.f28293c);
            } else if ("splash_ad".equals(this.j)) {
                this.v.setIsAutoPlay(true);
            } else {
                this.v.setIsAutoPlay(this.f28293c);
            }
            if ("splash_ad".equals(this.j)) {
                this.v.setIsQuiet(true);
            } else {
                this.v.setIsQuiet(p.h().a(this.f28294d));
            }
            this.v.d();
        } catch (Exception e2) {
            this.v = null;
            u.f("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e2.toString());
        }
    }

    private void setShowAdInteractionView(boolean z) {
        ExpressVideoView expressVideoView = this.v;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void Q() {
        u.b("NativeExpressVideoView", "onSkipVideo");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long R() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int S() {
        ExpressVideoView expressVideoView;
        if (this.f28291a == 3 && (expressVideoView = this.v) != null) {
            expressVideoView.d();
        }
        ExpressVideoView expressVideoView2 = this.v;
        if (expressVideoView2 == null || !expressVideoView2.getNativeVideoController().x()) {
            return this.f28291a;
        }
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void T() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void b() {
        super.b();
        this.f28307i.a((g) this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void d(int i2) {
        u.b("NativeExpressVideoView", "onChangeVideoState,stateType:" + i2);
        ExpressVideoView expressVideoView = this.v;
        if (expressVideoView == null) {
            u.f("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
        } else if (i2 == 1) {
            expressVideoView.a(0L, true, false);
        } else if (i2 == 2 || i2 == 3) {
            this.v.setVideoPlayStatus(i2);
            this.v.setCanInterruptVideoPlay(true);
            this.v.performClick();
        } else if (i2 == 4) {
            expressVideoView.getNativeVideoController().m();
        } else if (i2 != 5) {
        } else {
            expressVideoView.a(0L, true, false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d_() {
        this.f28295e = false;
        u.b("NativeExpressVideoView", "onVideoAdStartPlay");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.m;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoAdStartPlay();
        }
        this.f28291a = 2;
    }

    public void e() {
        this.n = new FrameLayout(this.f28305g);
        int d2 = ak.d(this.l.ap());
        this.f28294d = d2;
        a(d2);
        n();
        addView(this.n, new FrameLayout.LayoutParams(-1, -1));
        super.a();
        getWebView().setBackgroundColor(0);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void e_() {
        this.f28295e = false;
        u.b("NativeExpressVideoView", "onVideoAdPaused");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.m;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoAdPaused();
        }
        this.o = true;
        this.f28291a = 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void f(boolean z) {
        u.b("NativeExpressVideoView", "onMuteVideo,mute:" + z);
        ExpressVideoView expressVideoView = this.v;
        if (expressVideoView == null || expressVideoView.getNativeVideoController() == null) {
            return;
        }
        this.v.getNativeVideoController().c(z);
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        return this.w;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        ExpressVideoView expressVideoView = this.v;
        if (expressVideoView != null) {
            expressVideoView.setCanInterruptVideoPlay(z);
        }
    }

    private void b(final com.bytedance.sdk.openadsdk.core.d.o oVar) {
        if (oVar == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            c(oVar);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.2
                @Override // java.lang.Runnable
                public void run() {
                    NativeExpressVideoView.this.c(oVar);
                }
            });
        }
    }

    public void a(int i2) {
        int c2 = p.h().c(i2);
        if (3 == c2) {
            this.f28292b = false;
            this.f28293c = false;
        } else if (1 == c2) {
            this.f28292b = false;
            this.f28293c = x.d(this.f28305g);
        } else if (2 == c2) {
            if (x.e(this.f28305g) || x.d(this.f28305g)) {
                this.f28292b = false;
                this.f28293c = true;
            }
        } else if (4 == c2) {
            this.f28292b = true;
        }
        if (!this.f28293c) {
            this.f28291a = 3;
        }
        u.c("NativeVideoAdView", "mIsAutoPlay=" + this.f28293c + ",status=" + c2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0297c
    public void f() {
        u.b("NativeExpressVideoView", "onVideoLoad");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.m;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoLoad();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d() {
        this.f28295e = false;
        u.b("NativeExpressVideoView", "onVideoComplete");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.m;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoAdComplete();
        }
        this.f28291a = 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(com.bytedance.sdk.openadsdk.core.d.o oVar) {
        if (oVar != null && oVar.b()) {
            b(oVar);
        }
        super.a(oVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (i2 == -1 || jVar == null) {
            return;
        }
        if (i2 == 4 && this.j == "draw_ad") {
            ExpressVideoView expressVideoView = this.v;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        super.a(i2, jVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar, boolean z) {
        if (i2 == -1 || jVar == null) {
            return;
        }
        if (i2 == 4 && this.j == "draw_ad") {
            ExpressVideoView expressVideoView = this.v;
            if (expressVideoView != null) {
                expressVideoView.performClick();
                return;
            }
            return;
        }
        super.a(i2, jVar, z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void c() {
        this.f28295e = false;
        u.b("NativeExpressVideoView", "onVideoAdContinuePlay");
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.m;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoAdContinuePlay();
        }
        this.o = false;
        this.f28291a = 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void a(long j, long j2) {
        this.f28295e = false;
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.m;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onProgressUpdate(j, j2);
        }
        if (a(j)) {
            this.f28291a = 2;
        }
        this.x = j;
        this.y = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0297c
    public void a(int i2, int i3) {
        u.b("NativeExpressVideoView", "onVideoError,errorCode:" + i2 + ",extraCode:" + i3);
        TTNativeExpressAd.ExpressVideoAdListener expressVideoAdListener = this.m;
        if (expressVideoAdListener != null) {
            expressVideoAdListener.onVideoError(i2, i3);
        }
        this.x = this.y;
        this.f28291a = 4;
    }

    private boolean a(long j) {
        ExpressVideoView expressVideoView;
        int i2 = this.f28291a;
        return !(i2 == 5 || i2 == 3 || j <= this.x) || ((expressVideoView = this.v) != null && expressVideoView.f());
    }
}
