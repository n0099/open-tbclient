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
/* loaded from: classes4.dex */
public class NativeExpressVideoView extends NativeExpressView implements g, c.b, c.InterfaceC1007c {

    /* renamed from: a  reason: collision with root package name */
    int f6618a;

    /* renamed from: b  reason: collision with root package name */
    boolean f6619b;
    boolean c;
    int d;
    private ExpressVideoView t;
    private com.bytedance.sdk.openadsdk.multipro.b.a u;
    private long v;
    private long w;

    public NativeExpressVideoView(@NonNull Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot, String str) {
        super(context, lVar, adSlot, str);
        this.f6618a = 1;
        this.f6619b = false;
        this.c = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void a() {
        this.m = new FrameLayout(this.f);
        this.d = aj.d(this.k.W());
        a(this.d);
        n();
        addView(this.m, new FrameLayout.LayoutParams(-1, -1));
        super.a();
        getWebView().setBackgroundColor(0);
    }

    private void n() {
        try {
            this.u = new com.bytedance.sdk.openadsdk.multipro.b.a();
            this.t = new ExpressVideoView(this.f, this.k, this.i);
            this.t.setShouldCheckNetChange(false);
            this.t.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.1
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                public void a(boolean z, long j, long j2, long j3, boolean z2) {
                    NativeExpressVideoView.this.u.f7400a = z;
                    NativeExpressVideoView.this.u.e = j;
                    NativeExpressVideoView.this.u.f = j2;
                    NativeExpressVideoView.this.u.g = j3;
                    NativeExpressVideoView.this.u.d = z2;
                }
            });
            this.t.setVideoAdLoadListener(this);
            this.t.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.i)) {
                this.t.setIsAutoPlay(this.f6619b ? this.j.isAutoPlay() : this.c);
            } else if ("splash_ad".equals(this.i)) {
                this.t.setIsAutoPlay(true);
            } else {
                this.t.setIsAutoPlay(this.c);
            }
            if ("splash_ad".equals(this.i)) {
                this.t.setIsQuiet(true);
            } else {
                this.t.setIsQuiet(p.h().a(this.d));
            }
            this.t.d();
        } catch (Exception e) {
            this.t = null;
        }
    }

    void a(int i) {
        int c = p.h().c(i);
        if (3 == c) {
            this.f6619b = false;
            this.c = false;
        } else if (1 == c && x.d(this.f)) {
            this.f6619b = false;
            this.c = true;
        } else if (2 == c) {
            if (x.e(this.f) || x.d(this.f)) {
                this.f6619b = false;
                this.c = true;
            }
        } else if (4 == c) {
            this.f6619b = true;
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a getVideoModel() {
        return this.u;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        if (this.t != null) {
            this.t.setCanInterruptVideoPlay(z);
        }
    }

    private void setShowAdInteractionView(boolean z) {
        if (this.t != null) {
            this.t.setShowAdInteractionView(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView
    public void b() {
        super.b();
        this.h.a((g) this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView, com.bytedance.sdk.openadsdk.core.nativeexpress.j
    public void a(com.bytedance.sdk.openadsdk.core.d.n nVar) {
        if (nVar != null && nVar.a()) {
            b(nVar);
        }
        super.a(nVar);
    }

    private void b(final com.bytedance.sdk.openadsdk.core.d.n nVar) {
        if (nVar != null) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                c(nVar);
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressVideoView.2
                    @Override // java.lang.Runnable
                    public void run() {
                        NativeExpressVideoView.this.c(nVar);
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.bytedance.sdk.openadsdk.core.d.n nVar) {
        if (nVar != null) {
            double d = nVar.d();
            double e = nVar.e();
            double f = nVar.f();
            double g = nVar.g();
            int a2 = (int) ak.a(this.f, (float) d);
            int a3 = (int) ak.a(this.f, (float) e);
            int a4 = (int) ak.a(this.f, (float) f);
            int a5 = (int) ak.a(this.f, (float) g);
            u.b("ExpressView", "videoWidth:" + f);
            u.b("ExpressView", "videoHeight:" + g);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.m.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(a4, a5);
            }
            layoutParams.width = a4;
            layoutParams.height = a5;
            layoutParams.topMargin = a3;
            layoutParams.leftMargin = a2;
            this.m.setLayoutParams(layoutParams);
            this.m.removeAllViews();
            this.m.addView(this.t);
            this.t.a(0L, true, false);
            setShowAdInteractionView(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void e(boolean z) {
        u.b("NativeExpressVideoView", "onMuteVideo,mute:" + z);
        if (this.t != null && this.t.getNativeVideoController() != null) {
            this.t.getNativeVideoController().c(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void M() {
        u.b("NativeExpressVideoView", "onSkipVideo");
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void d(int i) {
        u.b("NativeExpressVideoView", "onChangeVideoState,stateType:" + i);
        switch (i) {
            case 1:
                this.t.a(0L, true, false);
                return;
            case 2:
            case 3:
                this.t.setCanInterruptVideoPlay(true);
                this.t.performClick();
                return;
            case 4:
                this.t.getNativeVideoController().l();
                return;
            case 5:
                this.t.a(0L, true, false);
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
                    if (this.i == "draw_ad") {
                        if (this.t != null) {
                            this.t.performClick();
                            return;
                        }
                        return;
                    }
                    break;
            }
            super.a(i, jVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public long N() {
        return this.v;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public int O() {
        if (this.t.getNativeVideoController().w()) {
            return 1;
        }
        return this.f6618a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.g
    public void P() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void e() {
        u.b("NativeExpressVideoView", "onVideoAdStartPlay");
        if (this.l != null) {
            this.l.onVideoAdStartPlay();
        }
        this.f6618a = 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d() {
        u.b("NativeExpressVideoView", "onVideoAdPaused");
        if (this.l != null) {
            this.l.onVideoAdPaused();
        }
        this.n = true;
        this.f6618a = 3;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void c() {
        u.b("NativeExpressVideoView", "onVideoAdContinuePlay");
        if (this.l != null) {
            this.l.onVideoAdContinuePlay();
        }
        this.n = false;
        this.f6618a = 2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void a(long j, long j2) {
        if (this.l != null) {
            this.l.onProgressUpdate(j, j2);
        }
        if (this.f6618a != 5 && this.f6618a != 3 && j > this.v) {
            this.f6618a = 2;
        }
        this.v = j;
        this.w = j2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public void d_() {
        u.b("NativeExpressVideoView", "onVideoComplete");
        if (this.l != null) {
            this.l.onVideoAdComplete();
        }
        this.f6618a = 5;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC1007c
    public void f() {
        u.b("NativeExpressVideoView", "onVideoLoad");
        if (this.l != null) {
            this.l.onVideoLoad();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC1007c
    public void a(int i, int i2) {
        u.b("NativeExpressVideoView", "onVideoError,errorCode:" + i + ",extraCode:" + i2);
        if (this.l != null) {
            this.l.onVideoError(i, i2);
        }
        this.v = this.w;
        this.f6618a = 4;
    }
}
