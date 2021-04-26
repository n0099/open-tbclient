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
    public View f29021a;

    /* renamed from: b  reason: collision with root package name */
    public Context f29022b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f29023c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f29024d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f29025e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f29026f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f29027g;

    /* renamed from: h  reason: collision with root package name */
    public a f29028h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f29029i;

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
            if (this.f29027g != null && this.f29027g.getChildCount() > 0) {
                View childAt = this.f29027g.getChildAt(0);
                if (childAt instanceof NativeExpressView) {
                    NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                    if (nativeExpressView.m()) {
                        this.f29027g.setVisibility(0);
                        this.f29023c.setVisibility(8);
                        this.f29024d.setVisibility(8);
                        this.f29025e.setVisibility(8);
                        this.f29026f.setVisibility(8);
                        final View findViewById = nativeExpressView.findViewById(ad.e(this.f29022b, "tt_bu_close"));
                        if (findViewById != null) {
                            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (n.this.f29028h != null) {
                                        n.this.f29028h.a(findViewById);
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
        this.f29029i = false;
        this.f29022b = context;
    }

    public void a(boolean z, a aVar) {
        this.f29029i = z;
        this.f29028h = aVar;
        a();
        a aVar2 = this.f29028h;
        if (aVar2 != null) {
            aVar2.a(this.f29023c, this.f29024d, this.f29027g);
        }
    }

    private void a() {
        setCancelable(false);
        View inflate = LayoutInflater.from(this.f29022b).inflate(ad.f(this.f29022b, "tt_insert_ad_layout"), (ViewGroup) null);
        this.f29021a = inflate;
        setContentView(inflate);
        this.f29023c = (ImageView) this.f29021a.findViewById(ad.e(this.f29022b, "tt_insert_ad_img"));
        this.f29024d = (ImageView) this.f29021a.findViewById(ad.e(this.f29022b, "tt_insert_dislike_icon_img"));
        this.f29025e = (ImageView) this.f29021a.findViewById(ad.e(this.f29022b, "tt_insert_ad_logo"));
        this.f29026f = (TextView) this.f29021a.findViewById(ad.e(this.f29022b, "tt_insert_ad_text"));
        this.f29027g = (FrameLayout) this.f29021a.findViewById(ad.e(this.f29022b, "tt_insert_express_ad_fl"));
        int c2 = al.c(this.f29022b);
        int i2 = c2 / 3;
        this.f29023c.setMaxWidth(c2);
        this.f29023c.setMinimumWidth(i2);
        this.f29023c.setMinimumHeight(i2);
        this.f29027g.setMinimumWidth(i2);
        this.f29027g.setMinimumHeight(i2);
        this.f29023c.setVisibility(this.f29029i ? 8 : 0);
        this.f29024d.setVisibility(0);
        this.f29025e.setVisibility(this.f29029i ? 8 : 0);
        this.f29026f.setVisibility(this.f29029i ? 8 : 0);
        this.f29027g.setVisibility(this.f29029i ? 0 : 8);
        int a2 = (int) al.a(this.f29022b, 15.0f);
        al.a(this.f29024d, a2, a2, a2, a2);
        this.f29024d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.f29028h != null) {
                    n.this.f29028h.a(view);
                }
            }
        });
        this.f29026f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.f29028h != null) {
                    n.this.f29028h.b(view);
                }
            }
        });
    }
}
