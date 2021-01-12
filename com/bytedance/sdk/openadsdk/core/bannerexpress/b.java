package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.b;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class b extends l implements am.a {

    /* renamed from: a  reason: collision with root package name */
    TTDislikeDialogAbstract f6462a;

    /* renamed from: b  reason: collision with root package name */
    private a f6463b;
    private final Context c;
    private com.bytedance.sdk.openadsdk.core.d.l d;
    private AdSlot f;
    private TTNativeExpressAd.ExpressAdInteractionListener g;
    private TTAppDownloadListener h;
    private com.bytedance.sdk.openadsdk.dislike.b i;
    private am j;
    private int k;
    private TTAdDislike.DislikeInteractionCallback l;
    private Context m;
    private String n = "banner_ad";

    public b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.c = context;
        this.d = lVar;
        this.f = adSlot;
        this.f6463b = new a(context, lVar, adSlot);
        b(this.f6463b.c(), this.d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f6463b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        if (this.d == null) {
            return -1;
        }
        return this.d.X();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        if (this.d == null) {
            return null;
        }
        return this.d.Y();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.g = expressAdInteractionListener;
        this.f6463b.a(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
        this.f6463b.a(adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.h = tTAppDownloadListener;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        if (this.d == null) {
            return -1;
        }
        return this.d.H();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f6463b.a();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        if (this.f6463b != null) {
            this.f6463b.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null && activity != null) {
            this.l = dislikeInteractionCallback;
            a(activity, dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            u.b("dialog is null, please check");
            return;
        }
        this.f6462a = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.d);
        if (this.f6463b != null && this.f6463b.c() != null) {
            this.f6463b.c().setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.i == null) {
            this.i = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.d);
        }
        this.m = activity;
        this.i.setDislikeInteractionCallback(dislikeInteractionCallback);
        if (this.f6463b != null && this.f6463b.c() != null) {
            this.f6463b.c().setDislike(this.i);
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar.H() == 4) {
            com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.c, lVar, this.n);
            if (this.h != null) {
                a2.a(this.h);
                return a2;
            }
            return a2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.j != null) {
            this.j.removeCallbacksAndMessages(null);
            this.j.sendEmptyMessageDelayed(112201, this.k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.j != null) {
            this.j.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (this.f6463b.d() != null && this.f6463b.f()) {
            a(this.f6463b.d(), lVar);
            b(this.f6463b.d(), lVar);
        }
    }

    private void a(@NonNull NativeExpressView nativeExpressView, @NonNull com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (nativeExpressView != null && lVar != null) {
            if (this.l != null) {
                this.i.a(lVar);
                if (nativeExpressView != null) {
                    nativeExpressView.setDislike(this.i);
                }
            }
            if (this.f6462a != null) {
                this.f6462a.setMaterialMeta(lVar);
                if (nativeExpressView != null) {
                    nativeExpressView.setOuterDislike(this.f6462a);
                }
            }
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void b(@NonNull final NativeExpressView nativeExpressView, @NonNull final com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (nativeExpressView != null && lVar != null) {
            this.d = lVar;
            final com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = a(lVar);
            nativeExpressView.setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.1
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
                public boolean a(NativeExpressView nativeExpressView2, int i) {
                    try {
                        nativeExpressView2.l();
                        BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(nativeExpressView2.getContext());
                        bannerExpressBackupView.a(b.this.d, nativeExpressView2, a2);
                        bannerExpressBackupView.setDislikeInner(b.this.i);
                        bannerExpressBackupView.setDislikeOuter(b.this.f6462a);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
            });
            if (a2 != null) {
                a2.b();
                if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                    a2.a((Activity) nativeExpressView.getContext());
                }
            }
            d.a(lVar);
            EmptyView a3 = a(nativeExpressView);
            if (a3 == null) {
                a3 = new EmptyView(this.c, nativeExpressView);
                nativeExpressView.addView(a3);
            }
            if (a2 != null) {
                a2.a(a3);
            }
            a3.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.2
                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    u.b("checkWebViewIsTransparent", "TAG=" + b.this.n + ",onWindowFocusChanged....hasWindowFocus=" + z);
                    if (a2 != null) {
                        if (z) {
                            if (a2 != null) {
                                a2.b();
                            }
                        } else if (a2 != null) {
                            a2.c();
                        }
                    }
                    if (z) {
                        b.this.a();
                        u.b("TTBannerExpressAd", "获得焦点，开始计时");
                        return;
                    }
                    u.b("TTBannerExpressAd", "失去焦点，停止计时");
                    b.this.b();
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a() {
                    if (a2 != null) {
                        a2.a();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void b() {
                    if (a2 != null) {
                        a2.d();
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(View view) {
                    u.b("TTBannerExpressAd", "ExpressView SHOW");
                    if (a2 != null) {
                        a2.a();
                    }
                    HashMap hashMap = new HashMap();
                    hashMap.put("dynamic_show_type", Integer.valueOf(nativeExpressView.m() ? 1 : 0));
                    d.a(b.this.c, lVar, b.this.n, hashMap);
                    if (b.this.g != null) {
                        b.this.g.onAdShow(view, lVar.H());
                    }
                    if (lVar.ab()) {
                        aj.a(lVar, view);
                    }
                    b.this.a();
                    if (!b.this.e.getAndSet(true) && b.this.f6463b != null && b.this.f6463b.c() != null) {
                        ak.a(b.this.c, b.this.d, b.this.n, b.this.f6463b.c().getWebView());
                    }
                    if (b.this.f6463b != null && b.this.f6463b.c() != null) {
                        b.this.f6463b.c().i();
                        b.this.f6463b.c().g();
                    }
                }
            });
            e eVar = new e(this.c, lVar, this.n, 2);
            eVar.a(nativeExpressView);
            eVar.a(a2);
            nativeExpressView.setClickListener(eVar);
            com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.c, lVar, this.n, 2);
            dVar.a(nativeExpressView);
            dVar.a(a2);
            nativeExpressView.setClickCreativeListener(dVar);
            if (a2 != null) {
                a2.a(this.h);
            }
            a3.setNeedCheckingShow(true);
        }
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

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        if (this.d != null) {
            return this.d.ae();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i) {
        if (i > 0) {
            this.n = "slide_banner_ad";
            b(this.f6463b.c(), this.d);
            this.f6463b.a(1000);
            if (i < 30000) {
                i = 30000;
            } else if (i > 120000) {
                i = 120000;
            }
            this.k = i;
            this.j = new am(Looper.getMainLooper(), this);
        }
    }

    private void c() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.c).a(this.f, 1, null, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.3
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
            public void a(List<com.bytedance.sdk.openadsdk.core.d.l> list) {
                com.bytedance.sdk.openadsdk.core.d.l lVar = list == null ? null : list.get(0);
                b.this.f6463b.a(lVar, b.this.f);
                b.this.b(lVar);
                b.this.f6463b.e();
                b.this.a();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
            public void a() {
                b.this.a();
            }
        }, 5000);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (message.what == 112201) {
            c();
        }
    }
}
