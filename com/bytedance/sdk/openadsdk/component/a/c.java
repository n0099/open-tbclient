package com.bytedance.sdk.openadsdk.component.a;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTFeedAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.multipro.b.a;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.Map;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class c extends com.bytedance.sdk.openadsdk.core.e.a implements TTFeedAd, c.b, c.InterfaceC1024c, a.InterfaceC1040a {

    /* renamed from: a  reason: collision with root package name */
    com.bytedance.sdk.openadsdk.multipro.b.a f4237a;
    boolean b;
    boolean c;
    int d;
    AdSlot e;
    int f;
    private int[] n;
    private TTFeedAd.VideoAdListener o;
    private TTFeedAd.CustomizeVideo p;
    private boolean q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(@NonNull Context context, @NonNull l lVar, int i, AdSlot adSlot) {
        super(context, lVar, i, adSlot);
        this.n = null;
        this.b = false;
        this.c = true;
        this.q = false;
        this.f = i;
        this.e = adSlot;
        this.f4237a = new com.bytedance.sdk.openadsdk.multipro.b.a();
        this.d = aj.d(this.h.aj());
        a(this.d);
    }

    public boolean g() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.e.a, com.bytedance.sdk.openadsdk.TTNativeAd
    public View getAdView() {
        NativeVideoTsView nativeVideoTsView;
        if (this.h == null || this.i == null) {
            return null;
        }
        if (h()) {
            try {
                nativeVideoTsView = new NativeVideoTsView(this.i, this.h, false, false, aj.b(this.f), false, false);
                if (i()) {
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
                        c.this.f4237a.f4918a = z;
                        c.this.f4237a.e = j;
                        c.this.f4237a.f = j2;
                        c.this.f4237a.g = j3;
                        c.this.f4237a.d = z2;
                    }
                });
                nativeVideoTsView.setVideoAdLoadListener(this);
                nativeVideoTsView.setVideoAdInteractionListener(this);
                if (5 == this.f) {
                    nativeVideoTsView.setIsAutoPlay(this.b ? this.e.isAutoPlay() : this.c);
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
        if (h() && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
            return nativeVideoTsView;
        }
        return null;
    }

    private boolean i() {
        return this.h != null && this.h.M() == null && this.h.k() == 1 && l.c(this.h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        if (!l.c(this.h)) {
            return false;
        }
        return true;
    }

    private void a(int i) {
        int c = p.h().c(i);
        if (3 == c) {
            this.b = false;
            this.c = false;
        } else if (1 == c && x.d(this.i)) {
            this.b = false;
            this.c = true;
        } else if (2 == c) {
            if (x.e(this.i) || x.d(this.i)) {
                this.b = false;
                this.c = true;
            }
        } else if (4 == c) {
            this.b = true;
        }
    }

    public void setVideoAdListener(TTFeedAd.VideoAdListener videoAdListener) {
        this.o = videoAdListener;
    }

    public double getVideoDuration() {
        if (this.h == null || this.h.R() == null) {
            return 0.0d;
        }
        return this.h.R().e();
    }

    public int getAdViewWidth() {
        try {
            if (this.n == null) {
                this.n = t.a(this.h);
            }
            if (this.n == null || this.n.length < 2) {
                return 1280;
            }
            return this.n[0];
        } catch (Throwable th) {
            u.c("TTFeedAdImpl", "getAdViewWidth error", th);
            return 1280;
        }
    }

    public int getAdViewHeight() {
        try {
            if (this.n == null) {
                this.n = t.a(this.h);
            }
            if (this.n == null || this.n.length < 2) {
                return 720;
            }
            return this.n[1];
        } catch (Throwable th) {
            u.c("TTFeedAdImpl", "getAdViewHeight error", th);
            return 720;
        }
    }

    public TTFeedAd.CustomizeVideo getCustomVideo() {
        if (!l.a(this.h)) {
            return null;
        }
        if (this.p == null) {
            this.p = new TTFeedAd.CustomizeVideo() { // from class: com.bytedance.sdk.openadsdk.component.a.c.3
                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public String getVideoUrl() {
                    if (c.this.h != null && c.this.h.a() == 1 && c.this.h.R() != null) {
                        if (!c.this.q) {
                            c.this.q = true;
                        }
                        return c.this.h.R().i();
                    }
                    return null;
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoStart() {
                    d.a(c.this.i, c.this.h, aj.a(c.this.h), "feed_play", 0L, 0, (Map<String, Object>) null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoPause(long j) {
                    d.a(c.this.i, c.this.h, aj.a(c.this.h), "feed_pause", j, com.bytedance.sdk.openadsdk.core.video.e.a.a(j, ((long) c.this.getVideoDuration()) * 1000), (Map<String, Object>) null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoContinue(long j) {
                    d.a(c.this.i, c.this.h, aj.a(c.this.h), "feed_continue", j, com.bytedance.sdk.openadsdk.core.video.e.a.a(j, ((long) c.this.getVideoDuration()) * 1000), (Map<String, Object>) null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoFinish() {
                    d.a(c.this.i, c.this.h, aj.a(c.this.h), "feed_over", ((long) c.this.getVideoDuration()) * 1000, 100, (Map<String, Object>) null);
                }

                @Override // com.bytedance.sdk.openadsdk.TTFeedAd.CustomizeVideo
                public void reportVideoBreak(long j) {
                    d.a(c.this.i, c.this.h, aj.a(c.this.h), "feed_break", j, com.bytedance.sdk.openadsdk.core.video.e.a.a(j, ((long) c.this.getVideoDuration()) * 1000), (Map<String, Object>) null);
                }
            };
        }
        return this.p;
    }

    public void f() {
        if (this.o != null) {
            this.o.onVideoLoad(this);
        }
    }

    public void a(int i, int i2) {
        if (this.o != null) {
            this.o.onVideoError(i, i2);
        }
    }

    public void d_() {
        if (this.o != null) {
            this.o.onVideoAdStartPlay(this);
        }
    }

    public void e_() {
        if (this.o != null) {
            this.o.onVideoAdPaused(this);
        }
    }

    public void c() {
        if (this.o != null) {
            this.o.onVideoAdContinuePlay(this);
        }
    }

    public void a(long j, long j2) {
        if (this.o != null) {
            this.o.onProgressUpdate(j, j2);
        }
    }

    public void d() {
        if (this.o != null) {
            this.o.onVideoAdComplete(this);
        }
    }

    public com.bytedance.sdk.openadsdk.multipro.b.a e() {
        return this.f4237a;
    }
}
