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
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.c;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b extends l {

    /* renamed from: a  reason: collision with root package name */
    a f6475a;

    /* renamed from: b  reason: collision with root package name */
    private NativeExpressView f6476b;
    private final Context c;
    private com.bytedance.sdk.openadsdk.core.d.l d;
    private TTNativeExpressAd.ExpressAdInteractionListener f;
    private TTNativeExpressAd.AdInteractionListener g;
    private TTAppDownloadListener h;
    private com.bytedance.sdk.openadsdk.dislike.b i;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a j;
    private Dialog k;
    private ImageView l;
    private FrameLayout m;
    private String n = "interaction";

    public b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.c = context;
        this.d = lVar;
        this.f6476b = new NativeExpressView(context, lVar, adSlot, this.n);
        a(this.f6476b, this.d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f6476b;
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
        this.f = expressAdInteractionListener;
        this.f6476b.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.g = adInteractionListener;
        this.f = adInteractionListener;
        this.f6476b.setExpressInteractionListener(adInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        this.h = tTAppDownloadListener;
        if (this.j != null) {
            this.j.a(this.h);
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
    public int getInteractionType() {
        if (this.d == null) {
            return -1;
        }
        return this.d.H();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void render() {
        this.f6476b.h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        if (this.f6476b != null) {
            this.f6476b.k();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeCallback(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null && activity != null) {
            a(activity, dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        if (tTDislikeDialogAbstract == null) {
            u.b("dialog is null, please check");
            return;
        }
        tTDislikeDialogAbstract.setMaterialMeta(this.d);
        if (this.f6476b != null) {
            this.f6476b.setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.i == null) {
            this.i = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.d);
            this.i.setIsInteractionAd();
        }
        this.i.setDislikeInteractionCallback(dislikeInteractionCallback);
        if (this.f6476b != null) {
            this.f6476b.setDislike(this.i);
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar.H() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.c, lVar, this.n);
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull NativeExpressView nativeExpressView, @NonNull final com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.d = lVar;
        this.f6476b.setBackupListener(new c() { // from class: com.bytedance.sdk.openadsdk.core.c.b.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i) {
                try {
                    b.this.f6476b.l();
                    b.this.f6475a = new a(nativeExpressView2.getContext());
                    b.this.f6475a.a(b.this.d, b.this.f6476b, b.this.j);
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
        d.a(lVar);
        EmptyView a2 = a(nativeExpressView);
        if (a2 == null) {
            a2 = new EmptyView(this.c, nativeExpressView);
            nativeExpressView.addView(a2);
        }
        if (this.j != null) {
            this.j.a(a2);
        }
        a2.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                u.b("TTInteractionExpressAd", "ExpressView onWindowFocusChanged=" + z);
                if (b.this.j != null) {
                    if (z) {
                        if (b.this.j != null) {
                            b.this.j.b();
                        }
                    } else if (b.this.j != null) {
                        b.this.j.c();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (b.this.j != null) {
                    b.this.j.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (b.this.j != null) {
                    b.this.j.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                u.b("TTInteractionExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(b.this.f6476b.m() ? 1 : 0));
                d.a(b.this.c, lVar, b.this.n, hashMap);
                if (b.this.f != null) {
                    b.this.f.onAdShow(view, lVar.H());
                }
                if (lVar.ab()) {
                    aj.a(lVar, view);
                }
                if (!b.this.e.getAndSet(true) && b.this.f6476b != null) {
                    ak.a(b.this.c, b.this.d, b.this.n, b.this.f6476b.getWebView());
                }
                if (b.this.f6476b != null) {
                    b.this.f6476b.i();
                    b.this.f6476b.g();
                }
            }
        });
        if (this.j != null) {
            this.j.a(this.h);
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

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void showInteractionExpressAd(@NonNull Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                u.b("不能在子线程调用 TTInteractionExpressAd.showInteractionAd");
            } else {
                a(activity);
            }
        }
    }

    private void a(Activity activity) {
        if (this.k == null) {
            this.k = new n(activity);
            this.k.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.c.b.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.j != null) {
                        b.this.j.d();
                    }
                    if (b.this.g != null) {
                        b.this.g.onAdDismiss();
                    }
                }
            });
            ((n) this.k).a(true, new n.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.4
                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    b.this.l = imageView2;
                    b.this.m = frameLayout;
                    b.this.m.addView(b.this.f6476b, new FrameLayout.LayoutParams(-1, -1));
                    b.this.a();
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(View view) {
                    b.this.b();
                    d.a(b.this.c, b.this.d, "interaction");
                    u.b("TTInteractionExpressAd", "dislike事件发出");
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void b(View view) {
                    b.this.i.showDislikeDialog();
                }
            });
        }
        if (this.f6475a != null) {
            this.f6475a.a(this.k);
        }
        if (!this.k.isShowing()) {
            this.k.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        e eVar = new e(this.c, this.d, this.n, 3);
        eVar.a(this.f6476b);
        eVar.b(this.l);
        eVar.a(this.j);
        this.f6476b.setClickListener(eVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.c, this.d, this.n, 3);
        dVar.a(this.f6476b);
        dVar.b(this.l);
        dVar.a(this.j);
        dVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.5
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (i == 2 || i == 3 || i == 5) {
                    b.this.b();
                }
            }
        });
        this.f6476b.setClickCreativeListener(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.k != null) {
            this.k.dismiss();
        }
    }
}
