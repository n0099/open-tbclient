package com.bytedance.sdk.openadsdk.core.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.PersonalizationPrompt;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b extends l {

    /* renamed from: a  reason: collision with root package name */
    public NativeExpressView f27978a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f27979b;

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.d.l f27980c;

    /* renamed from: d  reason: collision with root package name */
    public TTNativeExpressAd.ExpressAdInteractionListener f27981d;

    /* renamed from: e  reason: collision with root package name */
    public TTNativeExpressAd.AdInteractionListener f27982e;

    /* renamed from: f  reason: collision with root package name */
    public TTAppDownloadListener f27983f;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b f27984g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f27985h;

    /* renamed from: i  reason: collision with root package name */
    public Dialog f27986i;
    public ImageView j;
    public FrameLayout k;
    public a l;
    public String o = "interaction";

    public b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.f27979b = context;
        this.f27980c = lVar;
        a(context, lVar, adSlot, "interaction");
        a(this.f27978a, this.f27980c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        NativeExpressView nativeExpressView = this.f27978a;
        if (nativeExpressView != null) {
            nativeExpressView.k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.f27984g == null) {
            a(activity, (TTAdDislike.DislikeInteractionCallback) null);
        }
        return this.f27984g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f27978a;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public List<FilterWord> getFilterWords() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f27980c;
        if (lVar == null) {
            return null;
        }
        return lVar.ar();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getImageMode() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f27980c;
        if (lVar == null) {
            return -1;
        }
        return lVar.aq();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public int getInteractionType() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f27980c;
        if (lVar == null) {
            return -1;
        }
        return lVar.Z();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public Map<String, Object> getMediaExtraInfo() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f27980c;
        if (lVar != null) {
            return lVar.ay();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public PersonalizationPrompt getPersonalizationPrompt() {
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f27980c;
        if (lVar == null) {
            return null;
        }
        return lVar.as();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f27978a.h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null || activity == null) {
            return;
        }
        a(activity, dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            u.b("dialog is null, please check");
            return;
        }
        tTDislikeDialogAbstract.setMaterialMeta(this.f27980c);
        NativeExpressView nativeExpressView = this.f27978a;
        if (nativeExpressView != null) {
            nativeExpressView.setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.f27983f = tTAppDownloadListener;
        l.a aVar = this.n;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener) {
        this.f27981d = expressAdInteractionListener;
        this.f27978a.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(@NonNull Activity activity) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        if (Looper.getMainLooper() != Looper.myLooper()) {
            u.b("不能在子线程调用 TTInteractionExpressAd.showInteractionAd");
        } else {
            a(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        Dialog dialog = this.f27986i;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void a(@NonNull Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot, String str) {
        this.f27978a = new NativeExpressView(context, lVar, adSlot, this.o);
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.f27984g == null) {
            com.bytedance.sdk.openadsdk.dislike.b bVar = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.f27980c, this.o);
            this.f27984g = bVar;
            bVar.setIsInteractionAd();
        }
        this.f27984g.setDislikeInteractionCallback(dislikeInteractionCallback);
        NativeExpressView nativeExpressView = this.f27978a;
        if (nativeExpressView != null) {
            nativeExpressView.setDislike(this.f27984g);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.f27982e = adInteractionListener;
        this.f27981d = adInteractionListener;
        this.f27978a.setExpressInteractionListener(adInteractionListener);
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar.Z() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f27979b, lVar, this.o);
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull NativeExpressView nativeExpressView, @NonNull final com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.f27980c = lVar;
        this.f27978a.setBackupListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.c.b.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i2) {
                try {
                    b.this.f27978a.l();
                    b.this.l = new a(nativeExpressView2.getContext());
                    b.this.l.a(b.this.f27980c, b.this.f27978a, b.this.f27985h);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
        com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = a(lVar);
        this.f27985h = a2;
        if (a2 != null) {
            a2.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.f27985h.a((Activity) nativeExpressView.getContext());
            }
        }
        d.a(lVar);
        EmptyView a3 = a(nativeExpressView);
        if (a3 == null) {
            a3 = new EmptyView(this.f27979b, nativeExpressView);
            nativeExpressView.addView(a3);
        }
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f27985h;
        if (aVar != null) {
            aVar.a(a3);
        }
        a3.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                u.b("TTInteractionExpressAd", "ExpressView onWindowFocusChanged=" + z);
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar2 = b.this.f27985h;
                if (aVar2 != null) {
                    if (z) {
                        if (aVar2 != null) {
                            aVar2.b();
                        }
                    } else if (aVar2 != null) {
                        aVar2.c();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar2 = b.this.f27985h;
                if (aVar2 != null) {
                    aVar2.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar2 = b.this.f27985h;
                if (aVar2 != null) {
                    aVar2.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                u.b("TTInteractionExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(b.this.f27978a.m() ? 1 : 0));
                u.e("AdEvent", "pangolin ad show " + ak.a(lVar, view));
                b bVar = b.this;
                d.a(bVar.f27979b, lVar, bVar.o, hashMap);
                TTNativeExpressAd.ExpressAdInteractionListener expressAdInteractionListener = b.this.f27981d;
                if (expressAdInteractionListener != null) {
                    expressAdInteractionListener.onAdShow(view, lVar.Z());
                }
                b.this.m.getAndSet(true);
                NativeExpressView nativeExpressView2 = b.this.f27978a;
                if (nativeExpressView2 != null) {
                    nativeExpressView2.i();
                    b.this.f27978a.g();
                }
            }
        });
        a(this.f27985h, this.f27978a);
        a3.setNeedCheckingShow(true);
    }

    private void a(com.bytedance.sdk.openadsdk.downloadnew.core.a aVar, NativeExpressView nativeExpressView) {
        if (aVar == null || nativeExpressView == null) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.d.l lVar = this.f27980c;
        l.a aVar2 = new l.a(this.f27983f, lVar != null ? lVar.am() : "");
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

    private void a(Activity activity) {
        if (this.f27986i == null) {
            n nVar = new n(activity);
            this.f27986i = nVar;
            nVar.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.c.b.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = b.this.f27985h;
                    if (aVar != null) {
                        aVar.d();
                    }
                    TTNativeExpressAd.AdInteractionListener adInteractionListener = b.this.f27982e;
                    if (adInteractionListener != null) {
                        adInteractionListener.onAdDismiss();
                    }
                }
            });
            ((n) this.f27986i).a(true, new n.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.4
                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    b bVar = b.this;
                    bVar.j = imageView2;
                    bVar.k = frameLayout;
                    frameLayout.addView(bVar.f27978a, new FrameLayout.LayoutParams(-1, -1));
                    b.this.a();
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void b(View view) {
                    b bVar = b.this;
                    com.bytedance.sdk.openadsdk.dislike.b bVar2 = bVar.f27984g;
                    if (bVar2 != null) {
                        bVar2.showDislikeDialog();
                    } else {
                        TTDelegateActivity.a(bVar.f27979b, bVar.f27980c);
                    }
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(View view) {
                    b.this.b();
                    b bVar = b.this;
                    d.a(bVar.f27979b, bVar.f27980c, "interaction");
                    u.b("TTInteractionExpressAd", "dislike事件发出");
                }
            });
        }
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(this.f27986i);
        }
        if (this.f27986i.isShowing()) {
            return;
        }
        this.f27986i.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        e eVar = new e(this.f27979b, this.f27980c, this.o, 3);
        eVar.a(this.f27978a);
        eVar.b(this.j);
        eVar.a(this.f27985h);
        eVar.a(this);
        this.f27978a.setClickListener(eVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.f27979b, this.f27980c, this.o, 3);
        dVar.a(this.f27978a);
        dVar.b(this.j);
        dVar.a(this);
        dVar.a(this.f27985h);
        dVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.5
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i2) {
                if (i2 == 2 || i2 == 3 || i2 == 5) {
                    b.this.b();
                }
            }
        });
        this.f27978a.setClickCreativeListener(dVar);
    }
}
