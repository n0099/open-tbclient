package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class k extends l {

    /* renamed from: a  reason: collision with root package name */
    protected NativeExpressView f4495a;
    protected final Context b;
    protected com.bytedance.sdk.openadsdk.core.d.l c;
    protected String d = "embeded_ad";
    private TTNativeExpressAd.ExpressAdInteractionListener e;
    private TTAppDownloadListener f;
    private TTAdDislike.DislikeInteractionCallback g;
    private com.bytedance.sdk.openadsdk.dislike.b h;
    private TTDislikeDialogAbstract i;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a j;

    public k(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.b = context;
        this.c = lVar;
        a(context, lVar, adSlot);
    }

    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.f4495a = new NativeExpressView(context, lVar, adSlot, this.d);
        a(this.f4495a, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f4495a;
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
        this.f4495a.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.e = adInteractionListener;
        this.f4495a.setExpressInteractionListener(adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.f = tTAppDownloadListener;
        if (this.n != null) {
            this.n.a(tTAppDownloadListener);
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
    public int getInteractionType() {
        if (this.c == null) {
            return -1;
        }
        return this.c.T();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f4495a.h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        if (this.f4495a != null) {
            this.f4495a.k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null && activity != null) {
            this.g = dislikeInteractionCallback;
            a(activity, dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            u.b("dialog is null, please check");
            return;
        }
        this.i = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.c);
        if (this.f4495a != null) {
            this.f4495a.setOuterDislike(tTDislikeDialogAbstract);
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
        this.h.setDislikeInteractionCallback(dislikeInteractionCallback);
        if (this.f4495a != null) {
            this.f4495a.setDislike(this.h);
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar.T() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.b, lVar, this.d);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @SuppressLint({"ClickableViewAccessibility"})
    public void a(@NonNull NativeExpressView nativeExpressView, @NonNull final com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.c = lVar;
        nativeExpressView.setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i) {
                try {
                    nativeExpressView2.l();
                    h hVar = new h(nativeExpressView2.getContext());
                    hVar.a(k.this.c, nativeExpressView2, k.this.j);
                    hVar.setDislikeInner(k.this.h);
                    hVar.setDislikeOuter(k.this.i);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
        this.j = a(lVar);
        if (this.j != null) {
            this.j.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.j.a((Activity) nativeExpressView.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.c.d.a(lVar);
        EmptyView a2 = a(nativeExpressView);
        if (a2 == null) {
            a2 = new EmptyView(this.b, nativeExpressView);
            nativeExpressView.addView(a2);
        }
        if (this.j != null) {
            this.j.a(a2);
        }
        a2.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.2
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
            public void a() {
                if (k.this.j != null) {
                    k.this.j.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (k.this.j != null) {
                    k.this.j.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                u.b("TTNativeExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(k.this.f4495a.getDynamicShowType()));
                u.e("AdEvent", "pangolin ad show " + aj.a(lVar, view));
                com.bytedance.sdk.openadsdk.c.d.a(k.this.b, lVar, k.this.d, hashMap);
                if (k.this.e != null) {
                    k.this.e.onAdShow(view, lVar.T());
                }
                if (!k.this.m.getAndSet(true)) {
                }
                if (k.this.f4495a != null) {
                    k.this.f4495a.i();
                    k.this.f4495a.g();
                }
            }
        });
        e eVar = new e(this.b, lVar, this.d, aj.a(this.d));
        eVar.a(nativeExpressView);
        eVar.a(this.j);
        eVar.a(this);
        this.f4495a.setClickListener(eVar);
        d dVar = new d(this.b, lVar, this.d, aj.a(this.d));
        dVar.a(nativeExpressView);
        dVar.a(this.j);
        dVar.a(this);
        this.f4495a.setClickCreativeListener(dVar);
        a(this.j, this.f4495a);
        a2.setNeedCheckingShow(true);
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
}
