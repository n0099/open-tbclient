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
    public View f28380a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28381b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f28382c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f28383d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f28384e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28385f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f28386g;

    /* renamed from: h  reason: collision with root package name */
    public a f28387h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28388i;

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
            if (this.f28386g != null && this.f28386g.getChildCount() > 0) {
                View childAt = this.f28386g.getChildAt(0);
                if (childAt instanceof NativeExpressView) {
                    NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                    if (nativeExpressView.m()) {
                        this.f28386g.setVisibility(0);
                        this.f28382c.setVisibility(8);
                        this.f28383d.setVisibility(8);
                        this.f28384e.setVisibility(8);
                        this.f28385f.setVisibility(8);
                        final View findViewById = nativeExpressView.findViewById(ad.e(this.f28381b, "tt_bu_close"));
                        if (findViewById != null) {
                            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (n.this.f28387h != null) {
                                        n.this.f28387h.a(findViewById);
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
        this.f28388i = false;
        this.f28381b = context;
    }

    public void a(boolean z, a aVar) {
        this.f28388i = z;
        this.f28387h = aVar;
        a();
        a aVar2 = this.f28387h;
        if (aVar2 != null) {
            aVar2.a(this.f28382c, this.f28383d, this.f28386g);
        }
    }

    private void a() {
        setCancelable(false);
        View inflate = LayoutInflater.from(this.f28381b).inflate(ad.f(this.f28381b, "tt_insert_ad_layout"), (ViewGroup) null);
        this.f28380a = inflate;
        setContentView(inflate);
        this.f28382c = (ImageView) this.f28380a.findViewById(ad.e(this.f28381b, "tt_insert_ad_img"));
        this.f28383d = (ImageView) this.f28380a.findViewById(ad.e(this.f28381b, "tt_insert_dislike_icon_img"));
        this.f28384e = (ImageView) this.f28380a.findViewById(ad.e(this.f28381b, "tt_insert_ad_logo"));
        this.f28385f = (TextView) this.f28380a.findViewById(ad.e(this.f28381b, "tt_insert_ad_text"));
        this.f28386g = (FrameLayout) this.f28380a.findViewById(ad.e(this.f28381b, "tt_insert_express_ad_fl"));
        int c2 = al.c(this.f28381b);
        int i2 = c2 / 3;
        this.f28382c.setMaxWidth(c2);
        this.f28382c.setMinimumWidth(i2);
        this.f28382c.setMinimumHeight(i2);
        this.f28386g.setMinimumWidth(i2);
        this.f28386g.setMinimumHeight(i2);
        this.f28382c.setVisibility(this.f28388i ? 8 : 0);
        this.f28383d.setVisibility(0);
        this.f28384e.setVisibility(this.f28388i ? 8 : 0);
        this.f28385f.setVisibility(this.f28388i ? 8 : 0);
        this.f28386g.setVisibility(this.f28388i ? 0 : 8);
        int a2 = (int) al.a(this.f28381b, 15.0f);
        al.a(this.f28383d, a2, a2, a2, a2);
        this.f28383d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.f28387h != null) {
                    n.this.f28387h.a(view);
                }
            }
        });
        this.f28385f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.f28387h != null) {
                    n.this.f28387h.b(view);
                }
            }
        });
    }
}
