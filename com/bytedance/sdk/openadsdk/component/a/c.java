package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.x;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c extends com.bytedance.sdk.openadsdk.core.e.a implements TTFeedAd, c.b, c.InterfaceC1013c, a.InterfaceC1028a {

    /* renamed from: a  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.multipro.b.a f6257a;

    /* renamed from: b  reason: collision with root package name */
    boolean f6258b;
    boolean c;
    int d;
    AdSlot e;
    int f;
    private TTFeedAd.VideoAdListener m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(@NonNull Context context, @NonNull l lVar, int i) {
        super(context, lVar, i);
        this.f6258b = false;
        this.c = true;
        this.f = i;
        this.f6257a = new com.bytedance.sdk.openadsdk.multipro.b.a();
        this.d = aj.d(this.h.W());
        a(this.d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(@NonNull Context context, @NonNull l lVar, int i, AdSlot adSlot) {
        super(context, lVar, i);
        this.f6258b = false;
        this.c = true;
        this.f = i;
        this.e = adSlot;
        this.f6257a = new com.bytedance.sdk.openadsdk.multipro.b.a();
        this.d = aj.d(this.h.W());
        a(this.d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.e.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        NativeVideoTsView nativeVideoTsView;
        if (this.h == null || this.i == null) {
            return null;
        }
        if (g()) {
            try {
                nativeVideoTsView = new NativeVideoTsView(this.i, this.h);
                if (h()) {
                    nativeVideoTsView.setVideoAdClickListener(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.component.a.c.1
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
                        public void a(View view, int i) {
                            if (c.this.g != null) {
                                c.this.g.a(view, i);
                            }
                        }
                    });
                }
                nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.component.a.c.2
                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                    public void a(boolean z, long j, long j2, long j3, boolean z2) {
                        c.this.f6257a.f7402a = z;
                        c.this.f6257a.e = j;
                        c.this.f6257a.f = j2;
                        c.this.f6257a.g = j3;
                        c.this.f6257a.d = z2;
                    }
                });
                nativeVideoTsView.setVideoAdLoadListener(this);
                nativeVideoTsView.setVideoAdInteractionListener(this);
                if (5 == this.f) {
                    nativeVideoTsView.setIsAutoPlay(this.f6258b ? this.e.isAutoPlay() : this.c);
                } else {
                    nativeVideoTsView.setIsAutoPlay(this.c);
                }
                nativeVideoTsView.setIsQuiet(p.h().a(this.d));
            } catch (Exception e) {
                nativeVideoTsView = null;
            }
        } else {
            nativeVideoTsView = null;
        }
        if (g() && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
            return nativeVideoTsView;
        }
        return null;
    }

    private boolean h() {
        return this.h != null && this.h.B() == null && this.h.e() == 1 && (this.h.X() == 5 || this.h.X() == 15);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g() {
        if (getImageMode() != 5 && getImageMode() != 15) {
            return false;
        }
        return true;
    }

    private void a(int i) {
        int c = p.h().c(i);
        if (3 == c) {
            this.f6258b = false;
            this.c = false;
        } else if (1 == c && x.d(this.i)) {
            this.f6258b = false;
            this.c = true;
        } else if (2 == c) {
            if (x.e(this.i) || x.d(this.i)) {
                this.f6258b = false;
                this.c = true;
            }
        } else if (4 == c) {
            this.f6258b = true;
        }
    }

    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        this.m = videoAdListener;
    }

    public double getVideoDuration() {
        if (this.h == null || this.h.F() == null) {
            return 0.0d;
        }
        return this.h.F().e();
    }

    public void f() {
        if (this.m != null) {
            this.m.onVideoLoad(this);
        }
    }

    public void a(int i, int i2) {
        if (this.m != null) {
            this.m.onVideoError(i, i2);
        }
    }

    public void e() {
        if (this.m != null) {
            this.m.onVideoAdStartPlay(this);
        }
    }

    public void d() {
        if (this.m != null) {
            this.m.onVideoAdPaused(this);
        }
    }

    public void c() {
        if (this.m != null) {
            this.m.onVideoAdContinuePlay(this);
        }
    }

    public void a(long j, long j2) {
        if (this.m != null) {
            this.m.onProgressUpdate(j, j2);
        }
    }

    public void d_() {
        if (this.m != null) {
            this.m.onVideoAdComplete(this);
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a a() {
        return this.f6257a;
    }
}
