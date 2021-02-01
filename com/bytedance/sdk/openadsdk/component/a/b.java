package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeDrawVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.x;
/* loaded from: classes6.dex */
public class b extends c implements TTDrawFeedAd {
    private boolean m;
    private Bitmap n;
    private int o;
    private TTDrawFeedAd.DrawVideoListener p;

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.multipro.b.a.InterfaceC1026a
    public /* bridge */ /* synthetic */ com.bytedance.sdk.openadsdk.multipro.b.a a() {
        return super.a();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC1011c
    public /* bridge */ /* synthetic */ void a(int i, int i2) {
        super.a(i, i2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void a(long j, long j2) {
        super.a(j, j2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void d() {
        super.d();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void d_() {
        super.d_();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.b
    public /* bridge */ /* synthetic */ void e() {
        super.e();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.video.nativevideo.c.InterfaceC1011c
    public /* bridge */ /* synthetic */ void f() {
        super.f();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ double getVideoDuration() {
        return super.getVideoDuration();
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.TTFeedAd
    public /* bridge */ /* synthetic */ void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        super.setVideoAdListener(videoAdListener);
    }

    public b(@NonNull Context context, @NonNull l lVar, int i) {
        super(context, lVar, i);
    }

    @Override // com.bytedance.sdk.openadsdk.component.a.c, com.bytedance.sdk.openadsdk.core.e.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        NativeDrawVideoTsView nativeDrawVideoTsView;
        if (this.h == null || this.i == null) {
            return null;
        }
        if (g()) {
            try {
                nativeDrawVideoTsView = new NativeDrawVideoTsView(this.i, this.h);
                nativeDrawVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.component.a.b.1
                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                    public void a(boolean z, long j, long j2, long j3, boolean z2) {
                        b.this.f6257a.f7402a = z;
                        b.this.f6257a.e = j;
                        b.this.f6257a.f = j2;
                        b.this.f6257a.g = j3;
                        b.this.f6257a.d = z2;
                    }
                });
                nativeDrawVideoTsView.setVideoAdLoadListener(this);
                nativeDrawVideoTsView.setVideoAdInteractionListener(this);
                int d = aj.d(this.h.W());
                nativeDrawVideoTsView.setIsAutoPlay(a(d));
                nativeDrawVideoTsView.setIsQuiet(p.h().a(d));
                nativeDrawVideoTsView.setCanInterruptVideoPlay(this.m);
                if (this.n != null) {
                    nativeDrawVideoTsView.a(this.n, this.o);
                }
                nativeDrawVideoTsView.setDrawVideoListener(this.p);
            } catch (Exception e) {
                nativeDrawVideoTsView = null;
            }
        } else {
            nativeDrawVideoTsView = null;
        }
        if (g() && nativeDrawVideoTsView != null && nativeDrawVideoTsView.a(0L, true, false)) {
            return nativeDrawVideoTsView;
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setCanInterruptVideoPlay(boolean z) {
        this.m = z;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setPauseIcon(Bitmap bitmap, int i) {
        this.n = bitmap;
        this.o = i;
        h();
    }

    private boolean a(int i) {
        int c = p.h().c(i);
        if (3 == c) {
            return false;
        }
        if (1 == c && x.d(this.i)) {
            return true;
        }
        if (2 == c) {
            return x.e(this.i) || x.d(this.i);
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.TTDrawFeedAd
    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.p = drawVideoListener;
    }

    private void h() {
        if (this.o >= 200) {
            this.o = 200;
        } else if (this.o <= 20) {
            this.o = 20;
        }
    }
}
