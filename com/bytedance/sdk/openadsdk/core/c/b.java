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
import com.bytedance.sdk.openadsdk.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.l;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class b extends l {

    /* renamed from: a  reason: collision with root package name */
    protected NativeExpressView f4378a;
    protected final Context b;
    protected com.bytedance.sdk.openadsdk.core.d.l c;
    protected TTNativeExpressAd.ExpressAdInteractionListener d;
    protected TTNativeExpressAd.AdInteractionListener e;
    protected TTAppDownloadListener f;
    protected com.bytedance.sdk.openadsdk.dislike.b g;
    protected com.bytedance.sdk.openadsdk.downloadnew.core.a h;
    protected Dialog i;
    protected ImageView j;
    protected FrameLayout k;
    a l;
    private String o = "interaction";

    public b(Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot) {
        this.b = context;
        this.c = lVar;
        a(context, lVar, adSlot, this.o);
        a(this.f4378a, this.c);
    }

    protected void a(@NonNull Context context, com.bytedance.sdk.openadsdk.core.d.l lVar, AdSlot adSlot, String str) {
        this.f4378a = new NativeExpressView(context, lVar, adSlot, this.o);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public View getExpressAdView() {
        return this.f4378a;
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
        this.d = expressAdInteractionListener;
        this.f4378a.setExpressInteractionListener(expressAdInteractionListener);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void setExpressInteractionListener(TTNativeExpressAd.AdInteractionListener adInteractionListener) {
        this.e = adInteractionListener;
        this.d = adInteractionListener;
        this.f4378a.setExpressInteractionListener(adInteractionListener);
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
        this.f4378a.h();
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public void destroy() {
        if (this.f4378a != null) {
            this.f4378a.k();
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
        tTDislikeDialogAbstract.setMaterialMeta(this.c);
        if (this.f4378a != null) {
            this.f4378a.setOuterDislike(tTDislikeDialogAbstract);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.l, com.bytedance.sdk.openadsdk.TTNativeExpressAd
    public TTAdDislike getDislikeDialog(Activity activity) {
        if (this.g == null) {
            a(activity, (TTAdDislike.DislikeInteractionCallback) null);
        }
        return this.g;
    }

    private void a(Activity activity, TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (this.g == null) {
            this.g = new com.bytedance.sdk.openadsdk.dislike.b(activity, this.c);
            this.g.setIsInteractionAd();
        }
        this.g.setDislikeInteractionCallback(dislikeInteractionCallback);
        if (this.f4378a != null) {
            this.f4378a.setDislike(this.g);
        }
    }

    private com.bytedance.sdk.openadsdk.downloadnew.core.a a(com.bytedance.sdk.openadsdk.core.d.l lVar) {
        if (lVar.T() == 4) {
            return com.bytedance.sdk.openadsdk.downloadnew.a.a(this.b, lVar, this.o);
        }
        return null;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void a(@NonNull NativeExpressView nativeExpressView, @NonNull final com.bytedance.sdk.openadsdk.core.d.l lVar) {
        this.c = lVar;
        this.f4378a.setBackupListener(new com.bytedance.sdk.openadsdk.core.nativeexpress.c() { // from class: com.bytedance.sdk.openadsdk.core.c.b.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.c
            public boolean a(NativeExpressView nativeExpressView2, int i) {
                try {
                    b.this.f4378a.l();
                    b.this.l = new a(nativeExpressView2.getContext());
                    b.this.l.a(b.this.c, b.this.f4378a, b.this.h);
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
        });
        this.h = a(lVar);
        if (this.h != null) {
            this.h.b();
            if (nativeExpressView.getContext() != null && (nativeExpressView.getContext() instanceof Activity)) {
                this.h.a((Activity) nativeExpressView.getContext());
            }
        }
        d.a(lVar);
        EmptyView a2 = a(nativeExpressView);
        if (a2 == null) {
            a2 = new EmptyView(this.b, nativeExpressView);
            nativeExpressView.addView(a2);
        }
        if (this.h != null) {
            this.h.a(a2);
        }
        a2.setCallback(new EmptyView.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.2
            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(boolean z) {
                u.b("TTInteractionExpressAd", "ExpressView onWindowFocusChanged=" + z);
                if (b.this.h != null) {
                    if (z) {
                        if (b.this.h != null) {
                            b.this.h.b();
                        }
                    } else if (b.this.h != null) {
                        b.this.h.c();
                    }
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a() {
                if (b.this.h != null) {
                    b.this.h.a();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void b() {
                if (b.this.h != null) {
                    b.this.h.d();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.core.EmptyView.a
            public void a(View view) {
                u.b("TTInteractionExpressAd", "ExpressView SHOW");
                HashMap hashMap = new HashMap();
                hashMap.put("dynamic_show_type", Integer.valueOf(b.this.f4378a.m() ? 1 : 0));
                u.e("AdEvent", "pangolin ad show " + aj.a(lVar, view));
                d.a(b.this.b, lVar, b.this.o, hashMap);
                if (b.this.d != null) {
                    b.this.d.onAdShow(view, lVar.T());
                }
                if (!b.this.m.getAndSet(true)) {
                }
                if (b.this.f4378a != null) {
                    b.this.f4378a.i();
                    b.this.f4378a.g();
                }
            }
        });
        a(this.h, this.f4378a);
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
        if (this.i == null) {
            this.i = new n(activity);
            this.i.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.core.c.b.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.h != null) {
                        b.this.h.d();
                    }
                    if (b.this.e != null) {
                        b.this.e.onAdDismiss();
                    }
                }
            });
            ((n) this.i).a(true, new n.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.4
                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    b.this.j = imageView2;
                    b.this.k = frameLayout;
                    b.this.k.addView(b.this.f4378a, new FrameLayout.LayoutParams(-1, -1));
                    b.this.a();
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(View view) {
                    b.this.b();
                    d.a(b.this.b, b.this.c, "interaction");
                    u.b("TTInteractionExpressAd", "dislike事件发出");
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void b(View view) {
                    if (b.this.g != null) {
                        b.this.g.showDislikeDialog();
                    } else {
                        TTDelegateActivity.a(b.this.c);
                    }
                }
            });
        }
        if (this.l != null) {
            this.l.a(this.i);
        }
        if (!this.i.isShowing()) {
            this.i.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        e eVar = new e(this.b, this.c, this.o, 3);
        eVar.a(this.f4378a);
        eVar.b(this.j);
        eVar.a(this.h);
        eVar.a(this);
        this.f4378a.setClickListener(eVar);
        com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this.b, this.c, this.o, 3);
        dVar.a(this.f4378a);
        dVar.b(this.j);
        dVar.a(this);
        dVar.a(this.h);
        dVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.c.b.5
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (i == 2 || i == 3 || i == 5) {
                    b.this.b();
                }
            }
        });
        this.f4378a.setClickCreativeListener(dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        if (this.i != null) {
            this.i.dismiss();
        }
    }
}
