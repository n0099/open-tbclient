package com.bytedance.sdk.openadsdk.component.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import d.c.c.b.b.d;
import d.c.c.b.d.o;
import java.util.Map;
/* loaded from: classes5.dex */
public class b implements TTInteractionAd {
    public static boolean k;

    /* renamed from: a  reason: collision with root package name */
    public final String f27403a = "interaction";

    /* renamed from: b  reason: collision with root package name */
    public final Context f27404b;

    /* renamed from: c  reason: collision with root package name */
    public final l f27405c;

    /* renamed from: d  reason: collision with root package name */
    public Dialog f27406d;

    /* renamed from: e  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.dislike.b f27407e;

    /* renamed from: f  reason: collision with root package name */
    public TTInteractionAd.AdInteractionListener f27408f;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.downloadnew.core.a f27409g;

    /* renamed from: h  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.l f27410h;
    public ImageView i;
    public ImageView j;

    public b(Context context, l lVar) {
        this.f27404b = context;
        this.f27405c = lVar;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public int getInteractionType() {
        l lVar = this.f27405c;
        if (lVar == null) {
            return -1;
        }
        return lVar.Z();
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public Map<String, Object> getMediaExtraInfo() {
        l lVar = this.f27405c;
        if (lVar != null) {
            return lVar.ay();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setAdInteractionListener(TTInteractionAd.AdInteractionListener adInteractionListener) {
        this.f27408f = adInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.f27409g;
        if (aVar != null) {
            aVar.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback == null) {
            return;
        }
        this.f27407e.setDislikeInteractionCallback(dislikeInteractionCallback);
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    @MainThread
    public void showInteractionAd(Activity activity) {
        if (activity.isFinishing()) {
            return;
        }
        if (Looper.getMainLooper() == Looper.myLooper()) {
            if (k) {
                return;
            }
            k = true;
            this.f27406d.show();
            return;
        }
        throw new IllegalStateException("不能在子线程调用 TTInteractionAd.showInteractionAd");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int b2 = this.f27405c.af().get(0).b();
        e.c().h().g(this.f27405c.af().get(0).a(), new d.k() { // from class: com.bytedance.sdk.openadsdk.component.c.b.5
            @Override // d.c.c.b.b.d.k
            public void a() {
            }

            @Override // d.c.c.b.b.d.k
            public void a(d.i iVar, boolean z) {
                if (iVar == null || iVar.a() == null) {
                    if (b.this.f27410h != null) {
                        b.this.f27410h.b();
                        return;
                    }
                    return;
                }
                b.this.j.setImageBitmap(iVar.a());
                if (b.this.f27410h != null) {
                    b.this.f27410h.a();
                }
            }

            @Override // d.c.c.b.d.o.a
            public void a(o<Bitmap> oVar) {
            }

            @Override // d.c.c.b.b.d.k
            public boolean a(byte[] bArr) {
                return false;
            }

            @Override // d.c.c.b.b.d.k
            public void b() {
            }

            @Override // d.c.c.b.d.o.a
            public void b(o<Bitmap> oVar) {
                if (b.this.f27410h != null) {
                    b.this.f27410h.b();
                }
            }
        }, b2, b2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        k = false;
        this.f27406d.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void b() {
        com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this.f27404b, this.f27405c, "interaction", 3);
        aVar.a(this.j);
        aVar.b(this.i);
        aVar.a(this.f27409g);
        aVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.component.c.b.4
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (b.this.f27408f != null) {
                    b.this.f27408f.onAdClicked();
                }
                if (i == 2 || i == 3 || i == 5) {
                    b.this.d();
                    if (b.this.f27408f != null) {
                        b.this.f27408f.onAdDismiss();
                    }
                }
            }
        });
        this.j.setOnClickListener(aVar);
        this.j.setOnTouchListener(aVar);
    }

    public void a(@NonNull com.bytedance.sdk.openadsdk.core.l lVar) {
        this.f27410h = lVar;
        com.bytedance.sdk.openadsdk.c.d.a(this.f27405c);
        if (getInteractionType() == 4) {
            this.f27409g = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f27404b, this.f27405c, "interaction");
        }
        this.f27407e = new com.bytedance.sdk.openadsdk.dislike.b(this.f27404b, this.f27405c, "interaction");
        a();
    }

    private void a() {
        if (this.f27406d == null) {
            n nVar = new n(this.f27404b);
            this.f27406d = nVar;
            nVar.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.component.c.b.1
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    if (b.this.f27406d.isShowing()) {
                        u.e("AdEvent", "pangolin ad show " + ak.a(b.this.f27405c, (View) null));
                        com.bytedance.sdk.openadsdk.c.d.a(b.this.f27404b, b.this.f27405c, "interaction", (Map<String, Object>) null);
                        if (b.this.f27408f != null) {
                            b.this.f27408f.onAdShow();
                        }
                    }
                }
            });
            this.f27406d.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.component.c.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.f27409g != null) {
                        b.this.f27409g.d();
                    }
                }
            });
            ((n) this.f27406d).a(false, new n.a() { // from class: com.bytedance.sdk.openadsdk.component.c.b.3
                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    b.this.j = imageView;
                    b.this.i = imageView2;
                    b.this.b();
                    b.this.c();
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void b(View view) {
                    b.this.f27407e.showDislikeDialog();
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(View view) {
                    b.this.d();
                    com.bytedance.sdk.openadsdk.c.d.a(b.this.f27404b, b.this.f27405c, "interaction");
                    if (b.this.f27408f != null) {
                        b.this.f27408f.onAdDismiss();
                    }
                    u.b("TTInteractionAdImpl", "dislike事件发出");
                }
            });
        }
    }
}
