package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class k extends l {

    /* renamed from: a  reason: collision with root package name */
    public NativeExpressView f28226a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f28227b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f28228c;

    /* renamed from: d  reason: collision with root package name */
    public String f28229d = "embeded_ad";

    /* renamed from: e  reason: collision with root package name */
    public TTNativeExpressAd.ExpressAdInteractionListener f28230e;

    /* renamed from: f  reason: collision with root package name */
    public TTAppDownloadListener f28231f;

    /* renamed from: g  reason: collision with root package name */
    public TTAdDislike.DislikeInteractionCallback f28232g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b f28233h;
    public TTDislikeDialogAbstract i;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a j;

    public k(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.f28227b = context;
        this.f28228c = lVar;
        a(context, lVar, adSlot);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        NativeExpressView nativeExpressView = this.f28226a;
        if (nativeExpressView != null) {
            nativeExpressView.k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.f28233h == null) {
            a(activity, (TTAdDislike.DislikeInteractionCallback) null);
        }
        return this.f28233h;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f28226a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28228c;
        if (lVar == null) {
            return null;
        }
        return lVar.ar();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28228c;
        if (lVar == null) {
            return -1;
        }
        return lVar.aq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28228c;
        if (lVar == null) {
            return -1;
        }
        return lVar.Z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28228c;
        if (lVar != null) {
            return lVar.ay();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public PersonalizationPrompt getPersonalizationPrompt() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28228c;
        if (lVar == null) {
            return null;
        }
        return lVar.as();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f28226a.h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null || activity == null) {
            return;
        }
        this.f28232g = dislikeInteractionCallback;
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            u.b("dialog is null, please check");
            return;
        }
        this.i = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.f28228c);
        NativeExpressView nativeExpressView = this.f28226a;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.f28231f = tTAppDownloadListener;
        l.a aVar = this.n;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f28230e = expressAdInteractionListener;
        this.f28226a.setExpressInteractionListener(expressAdInteractionListener);
    }

    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        NativeExpressView nativeExpressView = new NativeExpressView(context, lVar, adSlot, this.f28229d);
        this.f28226a = nativeExpressView;
        a(nativeExpressView, this.f28228c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f28230e = adInteractionListener;
        this.f28226a.setExpressInteractionListener(adInteractionListener);
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.f28233h == null) {
            this.f28233h = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.f28228c, this.f28229d);
        }
        this.f28233h.setDislikeInteractionCallback(dislikeInteractionCallback);
        NativeExpressView nativeExpressView = this.f28226a;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.f28233h);
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar.Z() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f28227b, lVar, this.f28229d);
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@NonNull NativeExpressView nativeExpressView, @NonNull final com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f28228c = lVar;
        nativeExpressView.setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i) {
                try {
                    nativeExpressView2.l();
                    h hVar = new h(nativeExpressView2.getContext());
                    hVar.a(k.this.f28228c, nativeExpressView2, k.this.j);
                    hVar.setDislikeInner(k.this.f28233h);
                    hVar.setDislikeOuter(k.this.i);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = a(lVar);
        this.j = a2;
        if (a2 != null) {
            a2.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.j.a((Activity) nativeExpressView.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.c.d.a(lVar);
        EmptyView a3 = a(nativeExpressView);
        if (a3 == null) {
            a3 = new EmptyView(this.f28227b, nativeExpressView);
            nativeExpressView.addView(a3);
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.j;
        if (aVar != null) {
            aVar.a(a3);
        }
        a3.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (k.this.j != null) {
                    if (z) {
                        if (k.this.j != null) {
                            k.this.j.b();
                        }
                    } else if (k.this.j != null) {
                        k.this.j.c();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (k.this.j != null) {
                    k.this.j.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (k.this.j != null) {
                    k.this.j.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                u.b("TTNativeExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(k.this.f28226a.getDynamicShowType()));
                u.e("AdEvent", "pangolin ad show " + ak.a(lVar, view));
                k kVar = k.this;
                com.bytedance.sdk.openadsdk.c.d.a(kVar.f28227b, lVar, kVar.f28229d, hashMap);
                if (k.this.f28230e != null) {
                    k.this.f28230e.onAdShow(view, lVar.Z());
                }
                k.this.m.getAndSet(true);
                NativeExpressView nativeExpressView2 = k.this.f28226a;
                if (nativeExpressView2 != null) {
                    nativeExpressView2.i();
                    k.this.f28226a.g();
                }
            }
        });
        Context context = this.f28227b;
        String str = this.f28229d;
        e eVar = new e(context, lVar, str, ak.a(str));
        eVar.a(nativeExpressView);
        eVar.a(this.j);
        eVar.a(this);
        this.f28226a.setClickListener(eVar);
        Context context2 = this.f28227b;
        String str2 = this.f28229d;
        d dVar = new d(context2, lVar, str2, ak.a(str2));
        dVar.a(nativeExpressView);
        dVar.a(this.j);
        dVar.a(this);
        this.f28226a.setClickCreativeListener(dVar);
        a(this.j, this.f28226a);
        a3.setNeedCheckingShow(true);
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, NativeExpressView nativeExpressView) {
        if (aVar == null || nativeExpressView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f28228c;
        l.a aVar2 = new l.a(this.f28231f, lVar != null ? lVar.am() : "");
        this.n = aVar2;
        aVar.a(aVar2);
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
