package com.bytedance.sdk.openadsdk.component.banner;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTBannerAd;
import com.bytedance.sdk.openadsdk.component.banner.b;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Map;
/* loaded from: classes4.dex */
public class e implements TTBannerAd, am.a {

    /* renamed from: a  reason: collision with root package name */
    private final d f6577a;

    /* renamed from: b  reason: collision with root package name */
    private final a f6578b;
    private final Context c;
    private am d;
    private int e;
    private l f;
    private TTBannerAd.AdInteractionListener g;
    private TTAppDownloadListener h;
    private com.bytedance.sdk.openadsdk.dislike.b i;
    private final b j;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a k;
    private String l = "banner_ad";
    private AdSlot m;

    public e(Context context, a aVar, AdSlot adSlot) {
        this.c = context;
        this.f6578b = aVar;
        this.m = adSlot;
        this.f = aVar.b();
        this.f6577a = new d(context);
        this.j = b.a(this.c);
        a(this.f6577a.b(), aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public View getBannerView() {
        return this.f6577a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setBannerInteractionListener(TTBannerAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.h = tTAppDownloadListener;
        if (this.k != null) {
            this.k.a(this.h);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public int getInteractionType() {
        if (this.f == null) {
            return -1;
        }
        return this.f.H();
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null) {
            return null;
        }
        b(dislikeInteractionCallback);
        this.f6577a.a(this.i);
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null) {
            a(dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setSlideIntervalTime(int i) {
        if (i > 0) {
            this.l = "slide_banner_ad";
            a(this.f6577a.b(), this.f6578b);
            this.f6577a.a();
            this.f6577a.a(1000);
            if (i < 30000) {
                i = 30000;
            } else if (i > 120000) {
                i = 120000;
            }
            this.e = i;
            this.d = new am(Looper.getMainLooper(), this);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public Map<String, Object> getMediaExtraInfo() {
        if (this.f != null) {
            return this.f.ae();
        }
        return null;
    }

    private void a(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        b(dislikeInteractionCallback);
        this.f6577a.a(this.i);
    }

    private void b(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.i == null) {
            this.i = new com.bytedance.sdk.openadsdk.dislike.b(this.c, this.f);
        }
        this.i.setDislikeInteractionCallback(dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (message.what == 1) {
            a();
        }
    }

    private void a() {
        this.j.a(this.m, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.e.1
            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
            public void a(@NonNull a aVar) {
                e.this.a(aVar);
                e.this.f6577a.e();
                e.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.component.banner.b.a
            public void a() {
                e.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.d != null) {
            this.d.removeCallbacksAndMessages(null);
            this.d.sendEmptyMessageDelayed(1, this.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.d != null) {
            this.d.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull a aVar) {
        if (this.f6577a.c() != null && !this.f6577a.f()) {
            a(this.f6577a.c(), aVar);
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(l lVar) {
        if (lVar.H() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.c, lVar, this.l);
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull c cVar, @NonNull a aVar) {
        cVar.a(aVar.a());
        final l b2 = aVar.b();
        this.f = b2;
        this.i = new com.bytedance.sdk.openadsdk.dislike.b(this.c, this.f);
        cVar.a(b2);
        this.k = a(b2);
        if (this.k != null) {
            this.k.b();
            if (cVar.getContext() != null && (cVar.getContext() instanceof Activity)) {
                this.k.a((Activity) cVar.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.c.d.a(b2);
        EmptyView a2 = a(cVar);
        if (a2 == null) {
            a2 = new EmptyView(this.c, cVar);
            cVar.addView(a2);
        }
        if (this.k != null) {
            this.k.a(a2);
        }
        a2.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.e.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (e.this.k != null) {
                    if (z) {
                        if (e.this.k != null) {
                            e.this.k.b();
                        }
                    } else if (e.this.k != null) {
                        e.this.k.c();
                    }
                }
                if (z) {
                    e.this.b();
                    u.b("TTBannerAd", "获得焦点，开始计时");
                    return;
                }
                u.b("TTBannerAd", "失去焦点，停止计时");
                e.this.c();
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (e.this.k != null) {
                    e.this.k.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                e.this.c();
                if (e.this.k != null) {
                    e.this.k.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                e.this.b();
                u.b("TTBannerAd", "BANNER SHOW");
                com.bytedance.sdk.openadsdk.c.d.a(e.this.c, b2, e.this.l, (Map<String, Object>) null);
                if (e.this.g != null) {
                    e.this.g.onAdShow(view, b2.H());
                }
                if (b2.ab()) {
                    aj.a(b2, view);
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this.c, b2, this.l, 2);
        aVar2.a(cVar);
        aVar2.b(this.f6577a.d());
        aVar2.a(this.k);
        aVar2.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.component.banner.e.3
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (e.this.g != null) {
                    e.this.g.onAdClicked(view, i);
                }
            }
        });
        cVar.setOnClickListener(aVar2);
        cVar.setOnTouchListener(aVar2);
        if (this.k != null) {
            this.k.a(this.h);
        }
        a2.setNeedCheckingShow(true);
    }

    private EmptyView a(ViewGroup viewGroup) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i2);
                if (!(childAt instanceof EmptyView)) {
                    i = i2 + 1;
                } else {
                    return (EmptyView) childAt;
                }
            } else {
                return null;
            }
        }
    }
}
