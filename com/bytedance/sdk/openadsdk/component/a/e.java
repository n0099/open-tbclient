package com.bytedance.sdk.openadsdk.component.a;

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
import com.bytedance.sdk.openadsdk.component.a.b;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Map;
/* loaded from: classes5.dex */
public class e implements TTBannerAd, am.a {

    /* renamed from: a  reason: collision with root package name */
    public final d f27350a;

    /* renamed from: b  reason: collision with root package name */
    public final a f27351b;

    /* renamed from: c  reason: collision with root package name */
    public final Context f27352c;

    /* renamed from: d  reason: collision with root package name */
    public am f27353d;

    /* renamed from: e  reason: collision with root package name */
    public int f27354e;

    /* renamed from: f  reason: collision with root package name */
    public l f27355f;

    /* renamed from: g  reason: collision with root package name */
    public TTBannerAd.AdInteractionListener f27356g;

    /* renamed from: h  reason: collision with root package name */
    public TTAppDownloadListener f27357h;
    public com.bytedance.sdk.openadsdk.dislike.b i;
    public final b j;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a k;
    public String l = "banner_ad";
    public AdSlot m;

    public e(Context context, a aVar, AdSlot adSlot) {
        this.f27352c = context;
        this.f27351b = aVar;
        this.m = adSlot;
        this.f27355f = aVar.b();
        this.f27350a = new d(context);
        this.j = b.a(this.f27352c);
        a(this.f27350a.b(), aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public View getBannerView() {
        return this.f27350a;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public TTAdDislike getDislikeDialog(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null) {
            return null;
        }
        b(dislikeInteractionCallback);
        this.f27350a.a(this.i);
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public int getInteractionType() {
        l lVar = this.f27355f;
        if (lVar == null) {
            return -1;
        }
        return lVar.Z();
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.f27355f;
        if (lVar != null) {
            return lVar.ay();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setBannerInteractionListener(TTBannerAd.AdInteractionListener adInteractionListener) {
        this.f27356g = adInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.f27357h = tTAppDownloadListener;
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.k;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null) {
            return;
        }
        a(dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTBannerAd
    public void setSlideIntervalTime(int i) {
        if (i <= 0) {
            return;
        }
        this.l = "slide_banner_ad";
        a(this.f27350a.b(), this.f27351b);
        this.f27350a.a();
        this.f27350a.a(1000);
        if (i < 30000) {
            i = 30000;
        } else if (i > 120000) {
            i = 120000;
        }
        this.f27354e = i;
        this.f27353d = new am(Looper.getMainLooper(), this);
    }

    private void b(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.i == null) {
            this.i = new com.bytedance.sdk.openadsdk.dislike.b(this.f27352c, this.f27355f, this.l);
        }
        this.i.setDislikeInteractionCallback(dislikeInteractionCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        am amVar = this.f27353d;
        if (amVar != null) {
            amVar.removeCallbacksAndMessages(null);
        }
    }

    private void a(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        b(dislikeInteractionCallback);
        this.f27350a.a(this.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        am amVar = this.f27353d;
        if (amVar != null) {
            amVar.removeCallbacksAndMessages(null);
            this.f27353d.sendEmptyMessageDelayed(1, this.f27354e);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (message.what == 1) {
            a();
        }
    }

    private void a() {
        this.j.a(this.m, new b.a() { // from class: com.bytedance.sdk.openadsdk.component.a.e.1
            @Override // com.bytedance.sdk.openadsdk.component.a.b.a
            public void a(@NonNull a aVar) {
                e.this.a(aVar);
                e.this.f27350a.e();
                e.this.b();
            }

            @Override // com.bytedance.sdk.openadsdk.component.a.b.a
            public void a() {
                e.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(@NonNull a aVar) {
        if (this.f27350a.c() == null || this.f27350a.f()) {
            return;
        }
        a(this.f27350a.c(), aVar);
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(l lVar) {
        if (lVar.Z() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f27352c, lVar, this.l);
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull c cVar, @NonNull a aVar) {
        cVar.a(aVar.a());
        final l b2 = aVar.b();
        this.f27355f = b2;
        this.i = new com.bytedance.sdk.openadsdk.dislike.b(this.f27352c, b2, this.l);
        cVar.a(b2);
        com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = a(b2);
        this.k = a2;
        if (a2 != null) {
            a2.b();
            if (cVar.getContext() != null && (cVar.getContext() instanceof Activity)) {
                this.k.a((Activity) cVar.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.c.d.a(b2);
        EmptyView a3 = a(cVar);
        if (a3 == null) {
            a3 = new EmptyView(this.f27352c, cVar);
            cVar.addView(a3);
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar2 = this.k;
        if (aVar2 != null) {
            aVar2.a(a3);
        }
        a3.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.component.a.e.2
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
            public void b() {
                e.this.c();
                if (e.this.k != null) {
                    e.this.k.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (e.this.k != null) {
                    e.this.k.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                e.this.b();
                u.b("TTBannerAd", "BANNER SHOW");
                u.e("AdEvent", "pangolin ad show " + ak.a(b2, view));
                com.bytedance.sdk.openadsdk.c.d.a(e.this.f27352c, b2, e.this.l, (Map<String, Object>) null);
                if (e.this.f27356g != null) {
                    e.this.f27356g.onAdShow(view, b2.Z());
                }
            }
        });
        com.bytedance.sdk.openadsdk.core.a.a aVar3 = new com.bytedance.sdk.openadsdk.core.a.a(this.f27352c, b2, this.l, 2);
        aVar3.a(cVar);
        aVar3.b(this.f27350a.d());
        aVar3.a(this.k);
        aVar3.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.component.a.e.3
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (e.this.f27356g != null) {
                    e.this.f27356g.onAdClicked(view, i);
                }
            }
        });
        cVar.setOnClickListener(aVar3);
        cVar.setOnTouchListener(aVar3);
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar4 = this.k;
        if (aVar4 != null) {
            aVar4.a(this.f27357h);
        }
        a3.setNeedCheckingShow(true);
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }
}
