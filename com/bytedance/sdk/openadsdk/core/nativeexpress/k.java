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
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes4.dex */
public class k extends l {

    /* renamed from: a  reason: collision with root package name */
    protected NativeExpressView f6945a;

    /* renamed from: b  reason: collision with root package name */
    protected final Context f6946b;
    protected com.bytedance.sdk.openadsdk.core.d.l c;
    protected String d = "embeded_ad";
    private TTNativeExpressAd.ExpressAdInteractionListener f;
    private TTAppDownloadListener g;
    private TTAdDislike.DislikeInteractionCallback h;
    private com.bytedance.sdk.openadsdk.dislike.b i;
    private TTDislikeDialogAbstract j;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a k;

    public k(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.f6946b = context;
        this.c = lVar;
        a(context, lVar, adSlot);
    }

    public void a(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.f6945a = new NativeExpressView(context, lVar, adSlot, this.d);
        a(this.f6945a, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f6945a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        if (this.c == null) {
            return -1;
        }
        return this.c.X();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        if (this.c == null) {
            return null;
        }
        return this.c.Y();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f = expressAdInteractionListener;
        this.f6945a.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f = adInteractionListener;
        this.f6945a.setExpressInteractionListener(adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.g = tTAppDownloadListener;
        if (this.k != null) {
            this.k.a(this.g);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        if (this.c != null) {
            return this.c.ae();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        if (this.c == null) {
            return -1;
        }
        return this.c.H();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f6945a.h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        if (this.f6945a != null) {
            this.f6945a.k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null && activity != null) {
            this.h = dislikeInteractionCallback;
            a(activity, dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            u.b("dialog is null, please check");
            return;
        }
        this.j = tTDislikeDialogAbstract;
        tTDislikeDialogAbstract.setMaterialMeta(this.c);
        if (this.f6945a != null) {
            this.f6945a.setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.i == null) {
            this.i = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.c);
        }
        this.i.setDislikeInteractionCallback(dislikeInteractionCallback);
        if (this.f6945a != null) {
            this.f6945a.setDislike(this.i);
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar.H() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f6946b, lVar, this.d);
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
                    hVar.a(k.this.c, nativeExpressView2, k.this.k);
                    hVar.setDislikeInner(k.this.i);
                    hVar.setDislikeOuter(k.this.j);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
        this.k = a(lVar);
        if (this.k != null) {
            this.k.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.k.a((Activity) nativeExpressView.getContext());
            }
        }
        com.bytedance.sdk.openadsdk.c.d.a(lVar);
        EmptyView a2 = a(nativeExpressView);
        if (a2 == null) {
            a2 = new EmptyView(this.f6946b, nativeExpressView);
            nativeExpressView.addView(a2);
        }
        if (this.k != null) {
            this.k.a(a2);
        }
        a2.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.k.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                if (k.this.k != null) {
                    if (z) {
                        if (k.this.k != null) {
                            k.this.k.b();
                        }
                    } else if (k.this.k != null) {
                        k.this.k.c();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (k.this.k != null) {
                    k.this.k.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (k.this.k != null) {
                    k.this.k.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                u.b("TTNativeExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(k.this.f6945a.m() ? 1 : 0));
                com.bytedance.sdk.openadsdk.c.d.a(k.this.f6946b, lVar, k.this.d, hashMap);
                if (k.this.f != null) {
                    k.this.f.onAdShow(view, lVar.H());
                }
                if (lVar.ab()) {
                    aj.a(lVar, view);
                }
                if (!k.this.e.getAndSet(true) && k.this.f6945a != null) {
                    ak.a(k.this.f6946b, k.this.c, k.this.d, k.this.f6945a.getWebView());
                }
                if (k.this.f6945a != null) {
                    k.this.f6945a.i();
                    k.this.f6945a.g();
                }
            }
        });
        e eVar = new e(this.f6946b, lVar, this.d, aj.a(this.d));
        eVar.a(nativeExpressView);
        eVar.a(this.k);
        eVar.a(this);
        this.f6945a.setClickListener(eVar);
        d dVar = new d(this.f6946b, lVar, this.d, aj.a(this.d));
        dVar.a(nativeExpressView);
        dVar.a(this.k);
        dVar.a(this);
        this.f6945a.setClickCreativeListener(dVar);
        if (this.k != null) {
            this.k.a(this.g);
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
