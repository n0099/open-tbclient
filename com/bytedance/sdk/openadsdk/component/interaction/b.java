package com.bytedance.sdk.openadsdk.component.interaction;

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
import com.bytedance.sdk.adnet.b.d;
import com.bytedance.sdk.adnet.core.p;
import com.bytedance.sdk.openadsdk.TTAdDislike;
import com.bytedance.sdk.openadsdk.TTAppDownloadListener;
import com.bytedance.sdk.openadsdk.TTInteractionAd;
import com.bytedance.sdk.openadsdk.c.d;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.n;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Map;
/* loaded from: classes4.dex */
class b implements TTInteractionAd {
    private static boolean j;

    /* renamed from: a  reason: collision with root package name */
    private final Context f6587a;

    /* renamed from: b  reason: collision with root package name */
    private final l f6588b;
    private Dialog c;
    private com.bytedance.sdk.openadsdk.dislike.b d;
    private TTInteractionAd.AdInteractionListener e;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a f;
    private com.bytedance.sdk.openadsdk.core.l g;
    private ImageView h;
    private ImageView i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, l lVar) {
        this.f6587a = context;
        this.f6588b = lVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@NonNull com.bytedance.sdk.openadsdk.core.l lVar) {
        this.g = lVar;
        d.a(this.f6588b);
        if (getInteractionType() == 4) {
            this.f = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.f6587a, this.f6588b, "interaction");
        }
        this.d = new com.bytedance.sdk.openadsdk.dislike.b(this.f6587a, this.f6588b);
        a();
    }

    private void a() {
        if (this.c == null) {
            this.c = new n(this.f6587a);
            this.c.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.1
                @Override // android.content.DialogInterface.OnShowListener
                public void onShow(DialogInterface dialogInterface) {
                    if (b.this.c.isShowing()) {
                        d.a(b.this.f6587a, b.this.f6588b, "interaction", (Map<String, Object>) null);
                        if (b.this.e != null) {
                            b.this.e.onAdShow();
                        }
                        if (b.this.f6588b.ab()) {
                            aj.a(b.this.f6588b, b.this.i);
                        }
                    }
                }
            });
            this.c.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    if (b.this.f != null) {
                        b.this.f.d();
                    }
                }
            });
            ((n) this.c).a(false, new n.a() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.3
                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout) {
                    b.this.i = imageView;
                    b.this.h = imageView2;
                    b.this.b();
                    b.this.c();
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void a(View view) {
                    b.this.d();
                    d.a(b.this.f6587a, b.this.f6588b, "interaction");
                    if (b.this.e != null) {
                        b.this.e.onAdDismiss();
                    }
                    u.b("TTInteractionAdImpl", "dislike事件发出");
                }

                @Override // com.bytedance.sdk.openadsdk.core.n.a
                public void b(View view) {
                    b.this.d.showDislikeDialog();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void b() {
        com.bytedance.sdk.openadsdk.core.a.a aVar = new com.bytedance.sdk.openadsdk.core.a.a(this.f6587a, this.f6588b, "interaction", 3);
        aVar.a(this.i);
        aVar.b(this.h);
        aVar.a(this.f);
        aVar.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.4
            @Override // com.bytedance.sdk.openadsdk.core.a.b.a
            public void a(View view, int i) {
                if (b.this.e != null) {
                    b.this.e.onAdClicked();
                }
                if (i == 2 || i == 3 || i == 5) {
                    b.this.d();
                    if (b.this.e != null) {
                        b.this.e.onAdDismiss();
                    }
                }
            }
        });
        this.i.setOnClickListener(aVar);
        this.i.setOnTouchListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int b2 = this.f6588b.M().get(0).b();
        e.a(this.f6587a).g().a(this.f6588b.M().get(0).a(), new d.InterfaceC0972d() { // from class: com.bytedance.sdk.openadsdk.component.interaction.b.5
            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0972d
            public void a() {
            }

            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0972d
            public void a(d.c cVar, boolean z) {
                if (cVar == null || cVar.a() == null) {
                    if (b.this.g != null) {
                        b.this.g.b();
                        return;
                    }
                    return;
                }
                b.this.i.setImageBitmap(cVar.a());
                if (b.this.g != null) {
                    b.this.g.a();
                }
            }

            @Override // com.bytedance.sdk.adnet.b.d.InterfaceC0972d
            public void b() {
            }

            @Override // com.bytedance.sdk.adnet.core.p.a
            public void a(p<Bitmap> pVar) {
            }

            @Override // com.bytedance.sdk.adnet.core.p.a
            public void b(p<Bitmap> pVar) {
                if (b.this.g != null) {
                    b.this.g.b();
                }
            }
        }, b2, b2);
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setAdInteractionListener(TTInteractionAd.AdInteractionListener adInteractionListener) {
        this.e = adInteractionListener;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setShowDislikeIcon(TTAdDislike.DislikeInteractionCallback dislikeInteractionCallback) {
        if (dislikeInteractionCallback != null) {
            this.d.setDislikeInteractionCallback(dislikeInteractionCallback);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public void setDownloadListener(TTAppDownloadListener tTAppDownloadListener) {
        if (this.f != null) {
            this.f.a(tTAppDownloadListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public int getInteractionType() {
        if (this.f6588b == null) {
            return -1;
        }
        return this.f6588b.H();
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    public Map<String, Object> getMediaExtraInfo() {
        if (this.f6588b != null) {
            return this.f6588b.ae();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.TTInteractionAd
    @MainThread
    public void showInteractionAd(Activity activity) {
        if (!activity.isFinishing()) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                throw new IllegalStateException("不能在子线程调用 TTInteractionAd.showInteractionAd");
            }
            if (!j) {
                j = true;
                this.c.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        j = false;
        this.c.dismiss();
    }
}
