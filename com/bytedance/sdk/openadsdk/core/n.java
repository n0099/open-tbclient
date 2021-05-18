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
/* loaded from: classes6.dex */
public class n extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public View f28266a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28267b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f28268c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f28269d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f28270e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28271f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f28272g;

    /* renamed from: h  reason: collision with root package name */
    public a f28273h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28274i;

    /* loaded from: classes6.dex */
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
            if (this.f28272g != null && this.f28272g.getChildCount() > 0) {
                View childAt = this.f28272g.getChildAt(0);
                if (childAt instanceof NativeExpressView) {
                    NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                    if (nativeExpressView.m()) {
                        this.f28272g.setVisibility(0);
                        this.f28268c.setVisibility(8);
                        this.f28269d.setVisibility(8);
                        this.f28270e.setVisibility(8);
                        this.f28271f.setVisibility(8);
                        final View findViewById = nativeExpressView.findViewById(ad.e(this.f28267b, "tt_bu_close"));
                        if (findViewById != null) {
                            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (n.this.f28273h != null) {
                                        n.this.f28273h.a(findViewById);
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

    public n(@NonNull Context context, @StyleRes int i2) {
        super(context, i2 == 0 ? ad.g(context, "tt_wg_insert_dialog") : i2);
        this.f28274i = false;
        this.f28267b = context;
    }

    public void a(boolean z, a aVar) {
        this.f28274i = z;
        this.f28273h = aVar;
        a();
        a aVar2 = this.f28273h;
        if (aVar2 != null) {
            aVar2.a(this.f28268c, this.f28269d, this.f28272g);
        }
    }

    private void a() {
        setCancelable(false);
        View inflate = LayoutInflater.from(this.f28267b).inflate(ad.f(this.f28267b, "tt_insert_ad_layout"), (ViewGroup) null);
        this.f28266a = inflate;
        setContentView(inflate);
        this.f28268c = (ImageView) this.f28266a.findViewById(ad.e(this.f28267b, "tt_insert_ad_img"));
        this.f28269d = (ImageView) this.f28266a.findViewById(ad.e(this.f28267b, "tt_insert_dislike_icon_img"));
        this.f28270e = (ImageView) this.f28266a.findViewById(ad.e(this.f28267b, "tt_insert_ad_logo"));
        this.f28271f = (TextView) this.f28266a.findViewById(ad.e(this.f28267b, "tt_insert_ad_text"));
        this.f28272g = (FrameLayout) this.f28266a.findViewById(ad.e(this.f28267b, "tt_insert_express_ad_fl"));
        int c2 = al.c(this.f28267b);
        int i2 = c2 / 3;
        this.f28268c.setMaxWidth(c2);
        this.f28268c.setMinimumWidth(i2);
        this.f28268c.setMinimumHeight(i2);
        this.f28272g.setMinimumWidth(i2);
        this.f28272g.setMinimumHeight(i2);
        this.f28268c.setVisibility(this.f28274i ? 8 : 0);
        this.f28269d.setVisibility(0);
        this.f28270e.setVisibility(this.f28274i ? 8 : 0);
        this.f28271f.setVisibility(this.f28274i ? 8 : 0);
        this.f28272g.setVisibility(this.f28274i ? 0 : 8);
        int a2 = (int) al.a(this.f28267b, 15.0f);
        al.a(this.f28269d, a2, a2, a2, a2);
        this.f28269d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.f28273h != null) {
                    n.this.f28273h.a(view);
                }
            }
        });
        this.f28271f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.f28273h != null) {
                    n.this.f28273h.b(view);
                }
            }
        });
    }
}
