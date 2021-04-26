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
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
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
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class b extends l implements am.a {

    /* renamed from: a  reason: collision with root package name */
    public a f28599a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f28600b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f28601c;

    /* renamed from: d  reason: collision with root package name */
    public AdSlot f28602d;

    /* renamed from: e  reason: collision with root package name */
    public TTNativeExpressAd.ExpressAdInteractionListener f28603e;

    /* renamed from: f  reason: collision with root package name */
    public TTAppDownloadListener f28604f;

    /* renamed from: g  reason: collision with root package name */
    public TTDislikeDialogAbstract f28605g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b f28606h;

    /* renamed from: i  reason: collision with root package name */
    public am f28607i;
    public int j;
    public TTAdDislike.DislikeInteractionCallback k;
    public Context l;
    public String o = "banner_ad";

    public b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.f28600b = context;
        this.f28601c = lVar;
        this.f28602d = adSlot;
        a(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        a aVar = this.f28599a;
        if (aVar != null) {
            aVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.f28606h == null) {
            a(activity, (TTAdDislike.DislikeInteractionCallback) null);
        }
        return this.f28606h;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f28599a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28601c;
        if (lVar == null) {
            return null;
        }
        return lVar.ar();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28601c;
        if (lVar == null) {
            return -1;
        }
        return lVar.aq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28601c;
        if (lVar == null) {
            return -1;
        }
        return lVar.Z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28601c;
        if (lVar != null) {
            return lVar.ay();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public PersonalizationPrompt getPersonalizationPrompt() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28601c;
        if (lVar == null) {
            return null;
        }
        return lVar.as();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f28599a.e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null || activity == null) {
            return;
        }
        this.k = dislikeInteractionCallback;
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            u.b("dialog is null, please check");
            return;
        }
        this.f28605g = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.f28601c);
        a aVar = this.f28599a;
        if (aVar == null || aVar.getCurView() == null) {
            return;
        }
        this.f28599a.getCurView().setOuterDislike(tTDislikeDialogAbstract);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.f28604f = tTAppDownloadListener;
        l.a aVar = this.n;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f28603e = expressAdInteractionListener;
        this.f28599a.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setSlideIntervalTime(int i2) {
        if (i2 <= 0) {
            return;
        }
        this.o = "slide_banner_ad";
        a(this.f28599a.getCurView(), this.f28601c);
        this.f28599a.setDuration(1000);
        if (i2 < 30000) {
            i2 = 30000;
        } else if (i2 > 120000) {
            i2 = 120000;
        }
        this.j = i2;
        this.f28607i = new am(Looper.getMainLooper(), this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        am amVar = this.f28607i;
        if (amVar != null) {
            amVar.removeCallbacksAndMessages(null);
        }
    }

    private void c() {
        com.bytedance.sdk.openadsdk.core.nativeexpress.b.a(this.f28600b).a(this.f28602d, 1, null, new b.a() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.3
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
            public void a(List<com.bytedance.sdk.openadsdk.core.d.l> list) {
                if (list == null || list.isEmpty()) {
                    b.this.a();
                    return;
                }
                com.bytedance.sdk.openadsdk.core.d.l lVar = list.get(0);
                b bVar = b.this;
                bVar.f28599a.a(lVar, bVar.f28602d);
                b.this.b(lVar);
                b.this.f28599a.c();
                b.this.a();
            }

            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.b.a
            public void a() {
                b.this.a();
            }
        }, 5000);
    }

    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        a aVar = new a(context, lVar, adSlot);
        this.f28599a = aVar;
        a(aVar.getCurView(), this.f28601c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f28603e = adInteractionListener;
        this.f28599a.setExpressInteractionListener(adInteractionListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(@NonNull com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (this.f28599a.getNextView() == null || !this.f28599a.b()) {
            return;
        }
        b(this.f28599a.getNextView(), lVar);
        a(this.f28599a.getNextView(), lVar);
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.f28606h == null) {
            this.f28606h = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.f28601c, this.o);
        }
        this.l = activity;
        this.f28606h.setDislikeInteractionCallback(dislikeInteractionCallback);
        a aVar = this.f28599a;
        if (aVar == null || aVar.getCurView() == null) {
            return;
        }
        this.f28599a.getCurView().setDislike(this.f28606h);
    }

    private void b(@NonNull NativeExpressView nativeExpressView, @NonNull com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (nativeExpressView == null || lVar == null) {
            return;
        }
        if (this.k != null) {
            this.f28606h.a(lVar);
            if (nativeExpressView != null) {
                nativeExpressView.setDislike(this.f28606h);
            }
        }
        TTDislikeDialogAbstract tTDislikeDialogAbstract = this.f28605g;
        if (tTDislikeDialogAbstract != null) {
            tTDislikeDialogAbstract.setMaterialMeta(lVar);
            if (nativeExpressView != null) {
                nativeExpressView.setOuterDislike(this.f28605g);
            }
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar.Z() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28600b, lVar, this.o);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        am amVar = this.f28607i;
        if (amVar != null) {
            amVar.removeCallbacksAndMessages(null);
            this.f28607i.sendEmptyMessageDelayed(112201, this.j);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@NonNull final NativeExpressView nativeExpressView, @NonNull final com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (nativeExpressView == null || lVar == null) {
            return;
        }
        this.f28601c = lVar;
        final com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = a(lVar);
        nativeExpressView.setBackupListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i2) {
                try {
                    nativeExpressView2.l();
                    BannerExpressBackupView bannerExpressBackupView = new BannerExpressBackupView(nativeExpressView2.getContext());
                    bannerExpressBackupView.a(b.this.f28601c, nativeExpressView2, a2);
                    bannerExpressBackupView.setDislikeInner(b.this.f28606h);
                    bannerExpressBackupView.setDislikeOuter(b.this.f28605g);
                    return true;
                } catch (Exception unused) {
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
            a3 = new EmptyView(this.f28600b, nativeExpressView);
            nativeExpressView.addView(a3);
        }
        if (a2 != null) {
            a2.a(a3);
        }
        a3.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.b.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                u.b("checkWebViewIsTransparent", "TAG=" + b.this.o + ",onWindowFocusChanged....hasWindowFocus=" + z);
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = a2;
                if (aVar != null) {
                    if (z) {
                        if (aVar != null) {
                            aVar.b();
                        }
                    } else if (aVar != null) {
                        aVar.c();
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
            public void b() {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = a2;
                if (aVar != null) {
                    aVar.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = a2;
                if (aVar != null) {
                    aVar.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                u.b("TTBannerExpressAd", "ExpressView SHOW");
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = a2;
                if (aVar != null) {
                    aVar.a();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(nativeExpressView.m() ? 1 : 0));
                u.e("AdEvent", "pangolin ad show " + ak.a(lVar, nativeExpressView));
                b bVar = b.this;
                d.a(bVar.f28600b, lVar, bVar.o, hashMap);
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = b.this.f28603e;
                if (expressAdInteractionListener != null) {
                    expressAdInteractionListener.onAdShow(view, lVar.Z());
                }
                b.this.a();
                b.this.m.getAndSet(true);
                a aVar2 = b.this.f28599a;
                if (aVar2 == null || aVar2.getCurView() == null) {
                    return;
                }
                b.this.f28599a.getCurView().i();
                b.this.f28599a.getCurView().g();
            }
        });
        e eVar = new e(this.f28600b, lVar, this.o, 2);
        eVar.a(nativeExpressView);
        eVar.a(a2);
        eVar.a(this);
        nativeExpressView.setClickListener(eVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.f28600b, lVar, this.o, 2);
        dVar.a(nativeExpressView);
        dVar.a(a2);
        dVar.a(this);
        nativeExpressView.setClickCreativeListener(dVar);
        a(a2, nativeExpressView);
        a3.setNeedCheckingShow(true);
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, NativeExpressView nativeExpressView) {
        if (aVar == null || nativeExpressView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28601c;
        l.a aVar2 = new l.a(this.f28604f, lVar != null ? lVar.am() : "");
        this.n = aVar2;
        aVar.a(aVar2);
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (message.what == 112201) {
            c();
        }
    }
}
