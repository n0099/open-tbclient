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
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b extends l implements al.a {

    /* renamed from: a  reason: collision with root package name */
    protected a f4370a;
    protected final Context b;
    protected com.bytedance.sdk.openadsdk.core.d.l c;
    protected AdSlot d;
    protected TTNativeExpressAd.ExpressAdInteractionListener e;
    protected TTAppDownloadListener f;
    TTDislikeDialogAbstract g;
    private com.bytedance.sdk.openadsdk.dislike.b h;
    private al i;
    private int j;
    private TTAdDislike.DislikeInteractionCallback k;
    private Context l;
    private String o = "banner_ad";

    public b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.b = context;
        this.c = lVar;
        this.d = adSlot;
        a(context, lVar, adSlot);
    }

    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.f4370a = new a(context, lVar, adSlot);
        a(this.f4370a.getCurView(), this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f4370a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        if (this.c == null) {
            return -1;
        }
        return this.c.ak();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        if (this.c == null) {
            return null;
        }
        return this.c.al();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.e = expressAdInteractionListener;
        this.f4370a.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.e = adInteractionListener;
        this.f4370a.setExpressInteractionListener(adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.f = tTAppDownloadListener;
        if (this.n != null) {
            this.n.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        if (this.c == null) {
            return -1;
        }
        return this.c.T();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f4370a.e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        if (this.f4370a != null) {
            this.f4370a.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null && activity != null) {
            this.k = dislikeInteractionCallback;
            a(activity, dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            u.b("dialog is null, please check");
            return;
        }
        this.g = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.c);
        if (this.f4370a != null && this.f4370a.getCurView() != null) {
            this.f4370a.getCurView().setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.h == null) {
            a(activity, (TTAdDislike.DislikeInteractionCallback) null);
        }
        return this.h;
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.h == null) {
            this.h = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.c);
        }
        this.l = activity;
        this.h.setDislikeInteractionCallback(dislikeInteractionCallback);
        if (this.f4370a != null && this.f4370a.getCurView() != null) {
            this.f4370a.getCurView().setDislike(this.h);
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar.T() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.b, lVar, this.o);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.i != null) {
            this.i.removeCallbacksAndMessages(null);
            this.i.sendEmptyMessageDelayed(112201, this.j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.i != null) {
            this.i.removeCallbacksAndMessages(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (this.f4370a.getNextView() != null && this.f4370a.b()) {
            b(this.f4370a.getNextView(), lVar);
            a(this.f4370a.getNextView(), lVar);
        }
    }

    private void b(@NonNull NativeExpressView nativeExpressView, @NonNull com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (nativeExpressView != null && lVar != null) {
            if (this.k != null) {
                this.h.a(lVar);
                if (nativeExpressView != null) {
                    nativeExpressView.setDislike(this.h);
                }
            }
            if (this.g != null) {
                this.g.setMaterialMeta(lVar);
                if (nativeExpressView != null) {
                    nativeExpressView.setOuterDislike(this.g);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@NonNull final NativeExpressView nativeExpressView, @NonNull final com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (nativeExpressView != null && lVar != null) {
            this.c = lVar;
            final com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = a(lVar);
            nativeExpressView.setBackupListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.1
                @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
                public boolean a(NativeExpressView nativeExpressView2, int i) {
                    try {
                        nativeExpressView2.l();
                        BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(nativeExpressView2.getContext());
                        bannerExpressBackupView.a(b.this.c, nativeExpressView2, a2);
                        bannerExpressBackupView.setDislikeInner(b.this.h);
                        bannerExpressBackupView.setDislikeOuter(b.this.g);
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
                a3 = new EmptyView(this.b, nativeExpressView);
                nativeExpressView.addView(a3);
            }
            if (a2 != null) {
                a2.a(a3);
            }
            a3.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.2
                @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
                public void a(boolean z) {
                    u.b("checkWebViewIsTransparent", "TAG=" + b.this.o + ",onWindowFocusChanged....hasWindowFocus=" + z);
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
                    u.e("AdEvent", "pangolin ad show " + aj.a(lVar, nativeExpressView));
                    d.a(b.this.b, lVar, b.this.o, hashMap);
                    if (b.this.e != null) {
                        b.this.e.onAdShow(view, lVar.T());
                    }
                    b.this.a();
                    if (!b.this.m.getAndSet(true)) {
                    }
                    if (b.this.f4370a != null && b.this.f4370a.getCurView() != null) {
                        b.this.f4370a.getCurView().i();
                        b.this.f4370a.getCurView().g();
                    }
                }
            });
            e eVar = new e(this.b, lVar, this.o, 2);
            eVar.a(nativeExpressView);
            eVar.a(a2);
            eVar.a(this);
            nativeExpressView.setClickListener(eVar);
            com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.b, lVar, this.o, 2);
            dVar.a(nativeExpressView);
            dVar.a(a2);
            dVar.a(this);
            nativeExpressView.setClickCreativeListener(dVar);
            a(a2, nativeExpressView);
            a3.setNeedCheckingShow(true);
        }
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, NativeExpressView nativeExpressView) {
        if (aVar != null && nativeExpressView != null) {
            String str = "";
            if (this.c != null) {
                str = this.c.ag();
            }
            this.n = new l.a(this.f, str);
            aVar.a(this.n);
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
        if (this.c != null) {
            return this.c.ar();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i) {
        if (i > 0) {
            this.o = "slide_banner_ad";
            a(this.f4370a.getCurView(), this.c);
            this.f4370a.setDuration(1000);
            if (i < 30000) {
                i = 30000;
            } else if (i > 120000) {
                i = 120000;
            }
            this.j = i;
            this.i = new al(Looper.getMainLooper(), this);
        }
    }

    private void c() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.b).a(this.d, 1, null, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.3
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
            public void a(List<com.bytedance.sdk.openadsdk.core.d.l> list) {
                com.bytedance.sdk.openadsdk.core.d.l lVar = list == null ? null : list.get(0);
                b.this.f4370a.a(lVar, b.this.d);
                b.this.b(lVar);
                b.this.f4370a.c();
                b.this.a();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
            public void a() {
                b.this.a();
            }
        }, 5000);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        if (message.what == 112201) {
            c();
        }
    }
}
