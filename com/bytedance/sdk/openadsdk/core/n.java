package com.bytedance.sdk.openadsdk.core;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.StyleRes;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes5.dex */
public class n extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public View f28151a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28152b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f28153c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f28154d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f28155e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28156f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f28157g;

    /* renamed from: h  reason: collision with root package name */
    public a f28158h;
    public boolean i;

    /* loaded from: classes5.dex */
    public interface a {
        void a(View view);

        void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout);

        void b(View view);
    }

    public n(@NonNull Context context) {
        this(context, 0);
    }

    private void b() {
        try {
            if (this.f28157g != null && this.f28157g.getChildCount() > 0) {
                View childAt = this.f28157g.getChildAt(0);
                if (childAt instanceof NativeExpressView) {
                    NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                    if (nativeExpressView.m()) {
                        this.f28157g.setVisibility(0);
                        this.f28153c.setVisibility(8);
                        this.f28154d.setVisibility(8);
                        this.f28155e.setVisibility(8);
                        this.f28156f.setVisibility(8);
                        final View findViewById = nativeExpressView.findViewById(ad.e(this.f28152b, "tt_bu_close"));
                        if (findViewById != null) {
                            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (n.this.f28158h != null) {
                                        n.this.f28158h.a(findViewById);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    public void show() {
        b();
        super.show();
    }

    public n(@NonNull Context context, @StyleRes int i) {
        super(context, i == 0 ? ad.g(context, "tt_wg_insert_dialog") : i);
        this.i = false;
        this.f28152b = context;
    }

    public void a(boolean z, a aVar) {
        this.i = z;
        this.f28158h = aVar;
        a();
        a aVar2 = this.f28158h;
        if (aVar2 != null) {
            aVar2.a(this.f28153c, this.f28154d, this.f28157g);
        }
    }

    private void a() {
        setCancelable(false);
        View inflate = LayoutInflater.from(this.f28152b).inflate(ad.f(this.f28152b, "tt_insert_ad_layout"), (ViewGroup) null);
        this.f28151a = inflate;
        setContentView(inflate);
        this.f28153c = (ImageView) this.f28151a.findViewById(ad.e(this.f28152b, "tt_insert_ad_img"));
        this.f28154d = (ImageView) this.f28151a.findViewById(ad.e(this.f28152b, "tt_insert_dislike_icon_img"));
        this.f28155e = (ImageView) this.f28151a.findViewById(ad.e(this.f28152b, "tt_insert_ad_logo"));
        this.f28156f = (TextView) this.f28151a.findViewById(ad.e(this.f28152b, "tt_insert_ad_text"));
        this.f28157g = (FrameLayout) this.f28151a.findViewById(ad.e(this.f28152b, "tt_insert_express_ad_fl"));
        int c2 = al.c(this.f28152b);
        int i = c2 / 3;
        this.f28153c.setMaxWidth(c2);
        this.f28153c.setMinimumWidth(i);
        this.f28153c.setMinimumHeight(i);
        this.f28157g.setMinimumWidth(i);
        this.f28157g.setMinimumHeight(i);
        this.f28153c.setVisibility(this.i ? 8 : 0);
        this.f28154d.setVisibility(0);
        this.f28155e.setVisibility(this.i ? 8 : 0);
        this.f28156f.setVisibility(this.i ? 8 : 0);
        this.f28157g.setVisibility(this.i ? 0 : 8);
        int a2 = (int) al.a(this.f28152b, 15.0f);
        al.a(this.f28154d, a2, a2, a2, a2);
        this.f28154d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.f28158h != null) {
                    n.this.f28158h.a(view);
                }
            }
        });
        this.f28156f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.f28158h != null) {
                    n.this.f28158h.b(view);
                }
            }
        });
    }
}
