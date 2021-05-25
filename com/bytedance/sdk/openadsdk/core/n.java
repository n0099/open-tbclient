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
    public View f28195a;

    /* renamed from: b  reason: collision with root package name */
    public Context f28196b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f28197c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f28198d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f28199e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f28200f;

    /* renamed from: g  reason: collision with root package name */
    public FrameLayout f28201g;

    /* renamed from: h  reason: collision with root package name */
    public a f28202h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f28203i;

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
            if (this.f28201g != null && this.f28201g.getChildCount() > 0) {
                View childAt = this.f28201g.getChildAt(0);
                if (childAt instanceof NativeExpressView) {
                    NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                    if (nativeExpressView.m()) {
                        this.f28201g.setVisibility(0);
                        this.f28197c.setVisibility(8);
                        this.f28198d.setVisibility(8);
                        this.f28199e.setVisibility(8);
                        this.f28200f.setVisibility(8);
                        final View findViewById = nativeExpressView.findViewById(ad.e(this.f28196b, "tt_bu_close"));
                        if (findViewById != null) {
                            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (n.this.f28202h != null) {
                                        n.this.f28202h.a(findViewById);
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
        this.f28203i = false;
        this.f28196b = context;
    }

    public void a(boolean z, a aVar) {
        this.f28203i = z;
        this.f28202h = aVar;
        a();
        a aVar2 = this.f28202h;
        if (aVar2 != null) {
            aVar2.a(this.f28197c, this.f28198d, this.f28201g);
        }
    }

    private void a() {
        setCancelable(false);
        View inflate = LayoutInflater.from(this.f28196b).inflate(ad.f(this.f28196b, "tt_insert_ad_layout"), (ViewGroup) null);
        this.f28195a = inflate;
        setContentView(inflate);
        this.f28197c = (ImageView) this.f28195a.findViewById(ad.e(this.f28196b, "tt_insert_ad_img"));
        this.f28198d = (ImageView) this.f28195a.findViewById(ad.e(this.f28196b, "tt_insert_dislike_icon_img"));
        this.f28199e = (ImageView) this.f28195a.findViewById(ad.e(this.f28196b, "tt_insert_ad_logo"));
        this.f28200f = (TextView) this.f28195a.findViewById(ad.e(this.f28196b, "tt_insert_ad_text"));
        this.f28201g = (FrameLayout) this.f28195a.findViewById(ad.e(this.f28196b, "tt_insert_express_ad_fl"));
        int c2 = al.c(this.f28196b);
        int i2 = c2 / 3;
        this.f28197c.setMaxWidth(c2);
        this.f28197c.setMinimumWidth(i2);
        this.f28197c.setMinimumHeight(i2);
        this.f28201g.setMinimumWidth(i2);
        this.f28201g.setMinimumHeight(i2);
        this.f28197c.setVisibility(this.f28203i ? 8 : 0);
        this.f28198d.setVisibility(0);
        this.f28199e.setVisibility(this.f28203i ? 8 : 0);
        this.f28200f.setVisibility(this.f28203i ? 8 : 0);
        this.f28201g.setVisibility(this.f28203i ? 0 : 8);
        int a2 = (int) al.a(this.f28196b, 15.0f);
        al.a(this.f28198d, a2, a2, a2, a2);
        this.f28198d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.f28202h != null) {
                    n.this.f28202h.a(view);
                }
            }
        });
        this.f28200f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.f28202h != null) {
                    n.this.f28202h.b(view);
                }
            }
        });
    }
}
