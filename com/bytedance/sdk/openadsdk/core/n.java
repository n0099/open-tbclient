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
    public View f28159a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28160b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f28161c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f28162d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f28163e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28164f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f28165g;

    /* renamed from: h  reason: collision with root package name */
    public a f28166h;
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
            if (this.f28165g != null && this.f28165g.getChildCount() > 0) {
                View childAt = this.f28165g.getChildAt(0);
                if (childAt instanceof NativeExpressView) {
                    NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                    if (nativeExpressView.m()) {
                        this.f28165g.setVisibility(0);
                        this.f28161c.setVisibility(8);
                        this.f28162d.setVisibility(8);
                        this.f28163e.setVisibility(8);
                        this.f28164f.setVisibility(8);
                        final View findViewById = nativeExpressView.findViewById(ad.e(this.f28160b, "tt_bu_close"));
                        if (findViewById != null) {
                            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (n.this.f28166h != null) {
                                        n.this.f28166h.a(findViewById);
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
        this.f28160b = context;
    }

    public void a(boolean z, a aVar) {
        this.i = z;
        this.f28166h = aVar;
        a();
        a aVar2 = this.f28166h;
        if (aVar2 != null) {
            aVar2.a(this.f28161c, this.f28162d, this.f28165g);
        }
    }

    private void a() {
        setCancelable(false);
        View inflate = LayoutInflater.from(this.f28160b).inflate(ad.f(this.f28160b, "tt_insert_ad_layout"), (ViewGroup) null);
        this.f28159a = inflate;
        setContentView(inflate);
        this.f28161c = (ImageView) this.f28159a.findViewById(ad.e(this.f28160b, "tt_insert_ad_img"));
        this.f28162d = (ImageView) this.f28159a.findViewById(ad.e(this.f28160b, "tt_insert_dislike_icon_img"));
        this.f28163e = (ImageView) this.f28159a.findViewById(ad.e(this.f28160b, "tt_insert_ad_logo"));
        this.f28164f = (TextView) this.f28159a.findViewById(ad.e(this.f28160b, "tt_insert_ad_text"));
        this.f28165g = (FrameLayout) this.f28159a.findViewById(ad.e(this.f28160b, "tt_insert_express_ad_fl"));
        int c2 = al.c(this.f28160b);
        int i = c2 / 3;
        this.f28161c.setMaxWidth(c2);
        this.f28161c.setMinimumWidth(i);
        this.f28161c.setMinimumHeight(i);
        this.f28165g.setMinimumWidth(i);
        this.f28165g.setMinimumHeight(i);
        this.f28161c.setVisibility(this.i ? 8 : 0);
        this.f28162d.setVisibility(0);
        this.f28163e.setVisibility(this.i ? 8 : 0);
        this.f28164f.setVisibility(this.i ? 8 : 0);
        this.f28165g.setVisibility(this.i ? 0 : 8);
        int a2 = (int) al.a(this.f28160b, 15.0f);
        al.a(this.f28162d, a2, a2, a2, a2);
        this.f28162d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.f28166h != null) {
                    n.this.f28166h.a(view);
                }
            }
        });
        this.f28164f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.f28166h != null) {
                    n.this.f28166h.b(view);
                }
            }
        });
    }
}
