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
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
public class n extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private View f4467a;
    private Context b;
    private ImageView c;
    private ImageView d;
    private ImageView e;
    private TextView f;
    private FrameLayout g;
    private a h;
    private boolean i;

    /* loaded from: classes6.dex */
    public interface a {
        void a(View view);

        void a(ImageView imageView, ImageView imageView2, FrameLayout frameLayout);

        void b(View view);
    }

    public n(@NonNull Context context) {
        this(context, 0);
    }

    public n(@NonNull Context context, @StyleRes int i) {
        super(context, i == 0 ? ac.g(context, "tt_wg_insert_dialog") : i);
        this.i = false;
        this.b = context;
    }

    public void a(boolean z, a aVar) {
        this.i = z;
        this.h = aVar;
        a();
        if (this.h != null) {
            this.h.a(this.c, this.d, this.g);
        }
    }

    private void a() {
        setCancelable(false);
        this.f4467a = LayoutInflater.from(this.b).inflate(ac.f(this.b, "tt_insert_ad_layout"), (ViewGroup) null);
        setContentView(this.f4467a);
        this.c = (ImageView) this.f4467a.findViewById(ac.e(this.b, "tt_insert_ad_img"));
        this.d = (ImageView) this.f4467a.findViewById(ac.e(this.b, "tt_insert_dislike_icon_img"));
        this.e = (ImageView) this.f4467a.findViewById(ac.e(this.b, "tt_insert_ad_logo"));
        this.f = (TextView) this.f4467a.findViewById(ac.e(this.b, "tt_insert_ad_text"));
        this.g = (FrameLayout) this.f4467a.findViewById(ac.e(this.b, "tt_insert_express_ad_fl"));
        int c = ak.c(this.b);
        int i = c / 3;
        this.c.setMaxWidth(c);
        this.c.setMinimumWidth(i);
        this.c.setMinimumHeight(i);
        this.g.setMinimumWidth(i);
        this.g.setMinimumHeight(i);
        this.c.setVisibility(this.i ? 8 : 0);
        this.d.setVisibility(0);
        this.e.setVisibility(this.i ? 8 : 0);
        this.f.setVisibility(this.i ? 8 : 0);
        this.g.setVisibility(this.i ? 0 : 8);
        int a2 = (int) ak.a(this.b, 15.0f);
        ak.a(this.d, a2, a2, a2, a2);
        this.d.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.h != null) {
                    n.this.h.a(view);
                }
            }
        });
        this.f.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (n.this.h != null) {
                    n.this.h.b(view);
                }
            }
        });
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
    }

    @Override // android.app.Dialog
    public void show() {
        b();
        super.show();
    }

    private void b() {
        try {
            if (this.g != null && this.g.getChildCount() > 0) {
                View childAt = this.g.getChildAt(0);
                if (childAt instanceof NativeExpressView) {
                    NativeExpressView nativeExpressView = (NativeExpressView) childAt;
                    if (nativeExpressView.m()) {
                        this.g.setVisibility(0);
                        this.c.setVisibility(8);
                        this.d.setVisibility(8);
                        this.e.setVisibility(8);
                        this.f.setVisibility(8);
                        final View findViewById = nativeExpressView.findViewById(ac.e(this.b, "tt_bu_close"));
                        if (findViewById != null) {
                            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.n.3
                                @Override // android.view.View.OnClickListener
                                public void onClick(View view) {
                                    if (n.this.h != null) {
                                        n.this.h.a(findViewById);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        } catch (Throwable th) {
        }
    }
}
