package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
/* loaded from: classes6.dex */
public class NativeExpressVideoView extends NativeExpressView implements g, c.b, c.InterfaceC1024c {

    /* renamed from: a  reason: collision with root package name */
    int f4475a;
    boolean b;
    boolean c;
    int d;
    boolean e;
    private ExpressVideoView v;
    private com.bytedance.sdk.openadsdk.multipro.b.a w;
    private long x;
    private long y;

    public NativeExpressVideoView(@NonNull Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot, String str) {
        super(context, lVar, adSlot, str);
        this.f4475a = 1;
        this.b = false;
        this.c = true;
        this.e = true;
        e();
    }

    protected void e() {
        this.n = new FrameLayout(this.g);
        this.d = aj.d(this.l.aj());
        a(this.d);
        n();
        addView(this.n, new FrameLayout.LayoutParams(-1, -1));
        super.a();
        getWebView().setBackgroundColor(0);
    }

    private void n() {
        try {
            this.w = new com.bytedance.sdk.openadsdk.multipro.b.a();
            this.v = new ExpressVideoView(this.g, this.l, this.j);
            this.v.setShouldCheckNetChange(false);
            this.v.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                public void a(boolean z, long j, long j2, long j3, boolean z2) {
                    NativeExpressVideoView.this.w.f4918a = z;
                    NativeExpressVideoView.this.w.e = j;
                    NativeExpressVideoView.this.w.f = j2;
                    NativeExpressVideoView.this.w.g = j3;
                    NativeExpressVideoView.this.w.d = z2;
                }
            });
            this.v.setVideoAdLoadListener(this);
            this.v.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.j)) {
                this.v.setIsAutoPlay(this.b ? this.k.isAutoPlay() : this.c);
            } else if ("splash_ad".equals(this.j)) {
                this.v.setIsAutoPlay(true);
            } else {
                this.v.setIsAutoPlay(this.c);
            }
            if ("splash_ad".equals(this.j)) {
                this.v.setIsQuiet(true);
            } else {
                this.v.setIsQuiet(p.h().a(this.d));
            }
            this.v.d();
        } catch (Exception e) {
            this.v = null;
            u.f("NativeExpressVideoView", "（dev ignore）ExpressVideoView-->print:" + e.toString());
        }
    }

    void a(int i) {
        int c = p.h().c(i);
        if (3 == c) {
            this.b = false;
            this.c = false;
        } else if (1 == c) {
            this.b = false;
            this.c = x.d(this.g);
        } else if (2 == c) {
            if (x.e(this.g) || x.d(this.g)) {
                this.b = false;
                this.c = true;
            }
        } else if (4 == c) {
            this.b = true;
        }
        if (!this.c) {
            this.f4475a = 3;
        }
        u.c("NativeVideoAdView", "mIsAutoPlay=" + this.c + ",status=" + c);
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        return this.w;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        if (this.v != null) {
            this.v.setCanInterruptVideoPlay(z);
        }
    }

    private void setShowAdInteractionView(boolean z) {
        if (this.v != null) {
            this.v.setShowAdInteractionView(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void b() {
        super.b();
        this.i.a((g) this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(com.bytedance.sdk.openadsdk.core.d.o oVar) {
        if (oVar != null && oVar.b()) {
            b(oVar);
        }
        super.a(oVar);
    }

    private void b(final com.bytedance.sdk.openadsdk.core.d.o oVar) {
        if (oVar != null) {
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
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.d.o oVar) {
        if (oVar != null) {
            double e = oVar.e();
            double f = oVar.f();
            double g = oVar.g();
            double h = oVar.h();
            int a2 = (int) ak.a(this.g, (float) e);
            int a3 = (int) ak.a(this.g, (float) f);
            int a4 = (int) ak.a(this.g, (float) g);
            int a5 = (int) ak.a(this.g, (float) h);
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
            if (this.v != null) {
                this.n.addView(this.v);
                this.v.a(0L, true, false);
                a(this.d);
                if (!x.d(this.g) && !this.c && this.e) {
                    this.v.e();
                }
                setShowAdInteractionView(false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void f(boolean z) {
        u.b("NativeExpressVideoView", "onMuteVideo,mute:" + z);
        if (this.v != null && this.v.getNativeVideoController() != null) {
            this.v.getNativeVideoController().c(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void O() {
        u.b("NativeExpressVideoView", "onSkipVideo");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void d(int i) {
        u.b("NativeExpressVideoView", "onChangeVideoState,stateType:" + i);
        if (this.v == null) {
            u.f("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
            return;
        }
        switch (i) {
            case 1:
                this.v.a(0L, true, false);
                return;
            case 2:
            case 3:
                this.v.setVideoPlayStatus(i);
                this.v.setCanInterruptVideoPlay(true);
                this.v.performClick();
                return;
            case 4:
                this.v.getNativeVideoController().m();
                return;
            case 5:
                this.v.a(0L, true, false);
                return;
            default:
                return;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (i != -1 && jVar != null) {
            switch (i) {
                case 4:
                    if (this.j == "draw_ad") {
                        if (this.v != null) {
                            this.v.performClick();
                            return;
                        }
                        return;
                    }
                    break;
            }
            super.a(i, jVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar, boolean z) {
        if (i != -1 && jVar != null) {
            switch (i) {
                case 4:
                    if (this.j == "draw_ad") {
                        if (this.v != null) {
                            this.v.performClick();
                            return;
                        }
                        return;
                    }
                    break;
            }
            super.a(i, jVar, z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long P() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int Q() {
        if (this.f4475a == 3 && this.v != null) {
            this.v.d();
        }
        if (this.v == null || !this.v.getNativeVideoController().x()) {
            return this.f4475a;
        }
        return 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void R() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d_() {
        this.e = false;
        u.b("NativeExpressVideoView", "onVideoAdStartPlay");
        if (this.m != null) {
            this.m.onVideoAdStartPlay();
        }
        this.f4475a = 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void e_() {
        this.e = false;
        u.b("NativeExpressVideoView", "onVideoAdPaused");
        if (this.m != null) {
            this.m.onVideoAdPaused();
        }
        this.o = true;
        this.f4475a = 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void c() {
        this.e = false;
        u.b("NativeExpressVideoView", "onVideoAdContinuePlay");
        if (this.m != null) {
            this.m.onVideoAdContinuePlay();
        }
        this.o = false;
        this.f4475a = 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void a(long j, long j2) {
        this.e = false;
        if (this.m != null) {
            this.m.onProgressUpdate(j, j2);
        }
        if (this.f4475a != 5 && this.f4475a != 3 && j > this.x) {
            this.f4475a = 2;
        }
        this.x = j;
        this.y = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d() {
        this.e = false;
        u.b("NativeExpressVideoView", "onVideoComplete");
        if (this.m != null) {
            this.m.onVideoAdComplete();
        }
        this.f4475a = 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC1024c
    public void f() {
        u.b("NativeExpressVideoView", "onVideoLoad");
        if (this.m != null) {
            this.m.onVideoLoad();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC1024c
    public void a(int i, int i2) {
        u.b("NativeExpressVideoView", "onVideoError,errorCode:" + i + ",extraCode:" + i2);
        if (this.m != null) {
            this.m.onVideoError(i, i2);
        }
        this.x = this.y;
        this.f4475a = 4;
    }
}
