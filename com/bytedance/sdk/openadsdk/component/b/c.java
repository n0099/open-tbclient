package com.bytedance.sdk.openadsdk.component.b;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.rtc.PeerConnectionClient;
import com.baidu.sapi2.SapiOptions;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.v;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class c extends com.bytedance.sdk.openadsdk.core.e.a implements TTFeedAd, c.b, c.InterfaceC0317c, a.InterfaceC0333a {

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.multipro.b.a f27388a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f27389b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f27390c;

    /* renamed from: d  reason: collision with root package name */
    public int f27391d;

    /* renamed from: e  reason: collision with root package name */
    public AdSlot f27392e;

    /* renamed from: f  reason: collision with root package name */
    public int f27393f;
    public int[] n;
    public TTFeedAd.VideoAdListener o;
    public TTFeedAd.CustomizeVideo p;
    public boolean q;

    public c(@NonNull Context context, @NonNull l lVar, int i, AdSlot adSlot) {
        super(context, lVar, i, adSlot);
        this.n = null;
        this.f27389b = false;
        this.f27390c = true;
        this.q = false;
        this.f27393f = i;
        this.f27392e = adSlot;
        this.f27388a = new com.bytedance.sdk.openadsdk.multipro.b.a();
        int d2 = ak.d(this.f28022h.ap());
        this.f27391d = d2;
        a(d2);
    }

    public void d_() {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdStartPlay(this);
        }
    }

    public void e_() {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdPaused(this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.e.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        NativeVideoTsView nativeVideoTsView;
        if (this.f28022h != null && this.i != null) {
            if (h()) {
                try {
                    nativeVideoTsView = new NativeVideoTsView(this.i, this.f28022h, false, false, ak.b(this.f27393f), false, false);
                    if (i()) {
                        nativeVideoTsView.setVideoAdClickListener(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.component.b.c.1
                            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
                            public void a(View view, int i) {
                                if (c.this.f28021g != null) {
                                    c.this.f28021g.a(view, i);
                                }
                            }
                        });
                    }
                    nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.component.b.c.2
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                        public void a(boolean z, long j, long j2, long j3, boolean z2) {
                            com.bytedance.sdk.openadsdk.multipro.b.a aVar = c.this.f27388a;
                            aVar.f29572a = z;
                            aVar.f29576e = j;
                            aVar.f29577f = j2;
                            aVar.f29578g = j3;
                            aVar.f29575d = z2;
                        }
                    });
                    nativeVideoTsView.setVideoAdLoadListener(this);
                    nativeVideoTsView.setVideoAdInteractionListener(this);
                    if (5 == this.f27393f) {
                        nativeVideoTsView.setIsAutoPlay(this.f27389b ? this.f27392e.isAutoPlay() : this.f27390c);
                    } else {
                        nativeVideoTsView.setIsAutoPlay(this.f27390c);
                    }
                    nativeVideoTsView.setIsQuiet(p.h().a(this.f27391d));
                } catch (Exception unused) {
                }
                if (!h() && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
                    return nativeVideoTsView;
                }
            }
            nativeVideoTsView = null;
            if (!h()) {
            }
        }
        return null;
    }

    public int getAdViewHeight() {
        try {
            if (this.n == null) {
                this.n = v.a(this.f28022h);
            }
            if (this.n != null && this.n.length >= 2) {
                return this.n[1];
            }
            return PeerConnectionClient.HD_VIDEO_HEIGHT;
        } catch (Throwable th) {
            u.c("TTFeedAdImpl", "getAdViewHeight error", th);
            return PeerConnectionClient.HD_VIDEO_HEIGHT;
        }
    }

    public int getAdViewWidth() {
        try {
            if (this.n == null) {
                this.n = v.a(this.f28022h);
            }
            if (this.n != null && this.n.length >= 2) {
                return this.n[0];
            }
            return 1280;
        } catch (Throwable th) {
            u.c("TTFeedAdImpl", "getAdViewWidth error", th);
            return 1280;
        }
    }

    public TTFeedAd.CustomizeVideo getCustomVideo() {
        if (l.a(this.f28022h)) {
            if (this.p == null) {
                this.p = new TTFeedAd.CustomizeVideo() { // from class: com.bytedance.sdk.openadsdk.component.b.c.3
                    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                    public String getVideoUrl() {
                        if (c.this.f28022h == null || c.this.f28022h.a() != 1 || c.this.f28022h.X() == null) {
                            return null;
                        }
                        if (!c.this.q) {
                            c.this.q = true;
                        }
                        return c.this.f28022h.X().i();
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                    public void reportVideoAutoStart() {
                        d.a(c.this.i, c.this.f28022h, ak.a(c.this.f28022h), "feed_auto_play", 0L, 0, (Map<String, Object>) null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                    public void reportVideoBreak(long j) {
                        d.a(c.this.i, c.this.f28022h, ak.a(c.this.f28022h), "feed_break", j, com.bytedance.sdk.openadsdk.core.video.e.a.a(j, ((long) c.this.getVideoDuration()) * 1000), (Map<String, Object>) null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                    public void reportVideoContinue(long j) {
                        d.a(c.this.i, c.this.f28022h, ak.a(c.this.f28022h), "feed_continue", j, com.bytedance.sdk.openadsdk.core.video.e.a.a(j, ((long) c.this.getVideoDuration()) * 1000), (Map<String, Object>) null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                    public void reportVideoError(long j, int i, int i2) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("creative_id", c.this.f28022h.am());
                        hashMap.put("error_code", Integer.valueOf(i));
                        hashMap.put("extra_error_code", Integer.valueOf(i2));
                        v X = c.this.f28022h.X();
                        if (X != null) {
                            hashMap.put("video_size", Long.valueOf(X.d()));
                            hashMap.put("video_resolution", X.f());
                        }
                        hashMap.put("duration", Long.valueOf(j));
                        hashMap.put(SapiOptions.s, Integer.valueOf(com.bytedance.sdk.openadsdk.core.video.e.a.a(j, ((long) c.this.getVideoDuration()) * 1000)));
                        d.d(c.this.i, c.this.f28022h, ak.a(c.this.f28022h), "play_error", hashMap);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                    public void reportVideoFinish() {
                        d.a(c.this.i, c.this.f28022h, ak.a(c.this.f28022h), "feed_over", ((long) c.this.getVideoDuration()) * 1000, 100, (Map<String, Object>) null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                    public void reportVideoPause(long j) {
                        d.a(c.this.i, c.this.f28022h, ak.a(c.this.f28022h), "feed_pause", j, com.bytedance.sdk.openadsdk.core.video.e.a.a(j, ((long) c.this.getVideoDuration()) * 1000), (Map<String, Object>) null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                    public void reportVideoStart() {
                        d.a(c.this.i, c.this.f28022h, ak.a(c.this.f28022h), "feed_play", 0L, 0, (Map<String, Object>) null);
                    }

                    @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                    public void reportVideoStartError(int i, int i2) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("creative_id", c.this.f28022h.am());
                        hashMap.put("error_code", Integer.valueOf(i));
                        hashMap.put("extra_error_code", Integer.valueOf(i2));
                        v X = c.this.f28022h.X();
                        if (X != null) {
                            hashMap.put("video_size", Long.valueOf(X.d()));
                            hashMap.put("video_resolution", X.f());
                        }
                        d.d(c.this.i, c.this.f28022h, ak.a(c.this.f28022h), "play_start_error", hashMap);
                    }
                };
            }
            return this.p;
        }
        return null;
    }

    public double getVideoDuration() {
        l lVar = this.f28022h;
        if (lVar == null || lVar.X() == null) {
            return 0.0d;
        }
        return this.f28022h.X().e();
    }

    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        this.o = videoAdListener;
    }

    private boolean i() {
        l lVar = this.f28022h;
        return lVar != null && lVar.S() == null && this.f28022h.k() == 1 && l.c(this.f28022h);
    }

    public void c() {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdContinuePlay(this);
        }
    }

    public void d() {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onVideoAdComplete(this);
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a e() {
        return this.f27388a;
    }

    public void f() {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onVideoLoad(this);
        }
    }

    public boolean g() {
        return this.q;
    }

    public boolean h() {
        return l.c(this.f28022h);
    }

    private void a(int i) {
        int c2 = p.h().c(i);
        if (3 == c2) {
            this.f27389b = false;
            this.f27390c = false;
        } else if (1 == c2 && x.d(this.i)) {
            this.f27389b = false;
            this.f27390c = true;
        } else if (2 != c2) {
            if (4 == c2) {
                this.f27389b = true;
            }
        } else if (x.e(this.i) || x.d(this.i)) {
            this.f27389b = false;
            this.f27390c = true;
        }
    }

    public void a(int i, int i2) {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onVideoError(i, i2);
        }
    }

    public void a(long j, long j2) {
        TTFeedAd.VideoAdListener videoAdListener = this.o;
        if (videoAdListener != null) {
            videoAdListener.onProgressUpdate(j, j2);
        }
    }
}
