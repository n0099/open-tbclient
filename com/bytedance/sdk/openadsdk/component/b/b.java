package com.bytedance.sdk.openadsdk.component.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.x;
/* loaded from: classes6.dex */
public class b extends c implements TTDrawFeedAd {
    public boolean n;
    public Bitmap o;
    public int p;
    public TTDrawFeedAd.DrawVideoListener q;

    public b(@NonNull Context context, @NonNull l lVar, int i2, AdSlot adSlot) {
        super(context, lVar, i2, adSlot);
    }

    private void i() {
        int i2 = this.p;
        if (i2 >= 200) {
            this.p = 200;
        } else if (i2 <= 20) {
            this.p = 20;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0298c
    public /* bridge */ /* synthetic */ void a(int i2, int i3) {
        super.a(i2, i3);
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void d_() {
        super.d_();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.multipro.b.a.InterfaceC0314a
    public /* bridge */ /* synthetic */ com.bytedance.sdk.openadsdk.multipro.b.a e() {
        return super.e();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void e_() {
        super.e_();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC0298c
    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.multipro.b.a.InterfaceC0314a
    public /* bridge */ /* synthetic */ boolean g() {
        return super.g();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.e.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        NativeDrawVideoTsView nativeDrawVideoTsView;
        if (this.f28053h != null && this.f28054i != null) {
            if (h()) {
                try {
                    nativeDrawVideoTsView = new NativeDrawVideoTsView(this.f28054i, this.f28053h);
                    nativeDrawVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.component.b.b.1
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                            com.bytedance.sdk.openadsdk.multipro.b.a aVar = ((c) b.this).f27391a;
                            aVar.f29651a = z;
                            aVar.f29655e = j;
                            aVar.f29656f = j2;
                            aVar.f29657g = j3;
                            aVar.f29654d = z2;
                        }
                    });
                    nativeDrawVideoTsView.setVideoAdLoadListener(this);
                    nativeDrawVideoTsView.setVideoAdInteractionListener(this);
                    int d2 = ak.d(this.f28053h.ap());
                    nativeDrawVideoTsView.setIsAutoPlay(a(d2));
                    nativeDrawVideoTsView.setIsQuiet(p.h().a(d2));
                    nativeDrawVideoTsView.setCanInterruptVideoPlay(this.n);
                    if (this.o != null) {
                        nativeDrawVideoTsView.a(this.o, this.p);
                    }
                    nativeDrawVideoTsView.setDrawVideoListener(this.q);
                } catch (Exception unused) {
                }
                if (!h() && nativeDrawVideoTsView != null && nativeDrawVideoTsView.a(0L, true, false)) {
                    return nativeDrawVideoTsView;
                }
            }
            nativeDrawVideoTsView = null;
            if (!h()) {
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ int getAdViewHeight() {
        return super.getAdViewHeight();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ int getAdViewWidth() {
        return super.getAdViewWidth();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ TTFeedAd.CustomizeVideo getCustomVideo() {
        return super.getCustomVideo();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ double getVideoDuration() {
        return super.getVideoDuration();
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setCanInterruptVideoPlay(boolean z) {
        this.n = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.q = drawVideoListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setPauseIcon(Bitmap bitmap, int i2) {
        this.o = bitmap;
        this.p = i2;
        i();
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        super.setVideoAdListener(videoAdListener);
    }

    @Override // com.bytedance.sdk.openadsdk.component.b.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void a(long j, long j2) {
        super.a(j, j2);
    }

    private boolean a(int i2) {
        int c2 = p.h().c(i2);
        if (3 == c2) {
            return false;
        }
        if (1 != c2 || !x.d(this.f28054i)) {
            if (2 != c2) {
                return false;
            }
            if (!x.e(this.f28054i) && !x.d(this.f28054i)) {
                return false;
            }
        }
        return true;
    }
}
