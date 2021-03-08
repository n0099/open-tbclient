package com.bytedance.sdk.openadsdk.core.c;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
/* loaded from: classes6.dex */
class a extends BackupView {
    private static i[] k = {new i(1, 1.0f, 300, 300), new i(2, 0.6666667f, 300, 450), new i(3, 1.5f, 300, 200)};
    private View l;
    private NativeExpressView m;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a n;
    private int o;
    private Dialog p;

    public a(@NonNull Context context) {
        super(context);
        this.o = 1;
        this.f4471a = context;
    }

    public void a(Dialog dialog) {
        this.p = dialog;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        setBackgroundColor(-1);
        this.b = lVar;
        this.m = nativeExpressView;
        this.n = aVar;
        this.e = "interaction";
        a(this.h);
        this.m.addView(this, new ViewGroup.LayoutParams(-2, -2));
        b();
    }

    private void b() {
        i a2 = a(this.m.getExpectExpressWidth(), this.m.getExpectExpressHeight());
        if (this.m.getExpectExpressWidth() > 0 && this.m.getExpectExpressHeight() > 0) {
            if (this.m.getExpectExpressWidth() > this.m.getExpectExpressHeight()) {
                this.f = ak.c(this.f4471a, this.m.getExpectExpressHeight() * a2.c);
                this.g = ak.c(this.f4471a, this.m.getExpectExpressHeight());
            } else {
                this.f = ak.c(this.f4471a, this.m.getExpectExpressWidth());
                this.g = ak.c(this.f4471a, this.m.getExpectExpressWidth() / a2.c);
            }
        } else {
            this.f = ak.c(this.f4471a, a2.d);
            this.g = ak.c(this.f4471a, a2.e);
        }
        if (this.f > 0 && this.f > ak.c(this.f4471a)) {
            float c = ak.c(this.f4471a) / this.f;
            this.f = ak.c(this.f4471a);
            this.g = Float.valueOf(c * this.g).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f, this.g);
        }
        layoutParams.width = this.f;
        layoutParams.height = this.g;
        setLayoutParams(layoutParams);
        if (a2.f4494a == 1) {
            c();
        } else if (a2.f4494a == 2) {
            d();
        } else if (a2.f4494a == 3) {
            e();
        } else {
            c();
        }
    }

    private void a(ImageView imageView) {
        d.a(this.f4471a).a(this.b.Z().get(0).a(), imageView);
    }

    private void c() {
        this.l = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_insert_layout1"), (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) this.l.findViewById(ac.e(this.f4471a, "tt_ad_container"));
        ImageView imageView = (ImageView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_img"));
        View findViewById = this.l.findViewById(ac.e(this.f4471a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_icon"));
        TextView textView = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_title"));
        TextView textView2 = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_download"));
        TextView textView4 = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_dislike"));
        int a2 = (int) ak.a(this.f4471a, 15.0f);
        ak.a(findViewById, a2, a2, a2, a2);
        b(findViewById);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (!TextUtils.isEmpty(this.b.af())) {
            textView3.setText(this.b.af());
        }
        if (this.b.R() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f, (this.f * 9) / 16);
                layoutParams.gravity = 17;
                frameLayout.addView(videoView, 0, layoutParams);
            }
            ak.a((View) imageView, 8);
            ak.a((View) frameLayout, 0);
        } else {
            a(imageView);
            ak.a((View) imageView, 0);
            ak.a((View) frameLayout, 8);
        }
        d.a(this.f4471a).a(this.b.U().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        a((View) this, true);
        a((View) textView3, true);
        a((View) textView4, true);
        a(frameLayout);
    }

    private void b(View view) {
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (a.this.p != null) {
                        a.this.p.dismiss();
                    }
                }
            });
        }
    }

    private void d() {
        this.l = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_insert_layout2"), (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) this.l.findViewById(ac.e(this.f4471a, "tt_ad_container"));
        ImageView imageView = (ImageView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_img"));
        View findViewById = this.l.findViewById(ac.e(this.f4471a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_icon"));
        TextView textView = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_title"));
        TextView textView2 = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_download"));
        TextView textView4 = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_dislike"));
        int a2 = (int) ak.a(this.f4471a, 15.0f);
        ak.a(findViewById, a2, a2, a2, a2);
        b(findViewById);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (!TextUtils.isEmpty(this.b.af())) {
            textView3.setText(this.b.af());
        }
        if (this.b.R() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f, (this.f * 9) / 16);
                layoutParams.gravity = 17;
                frameLayout.addView(videoView, 0, layoutParams);
            }
            ak.a((View) imageView, 8);
            ak.a((View) frameLayout, 0);
        } else {
            a(imageView);
            ak.a((View) imageView, 0);
            ak.a((View) frameLayout, 8);
        }
        d.a(this.f4471a).a(this.b.U().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        a((View) this, true);
        a((View) textView3, true);
        a((View) textView4, true);
        a(frameLayout);
    }

    private void e() {
        this.l = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_insert_layout3"), (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) this.l.findViewById(ac.e(this.f4471a, "tt_ad_container"));
        ImageView imageView = (ImageView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_img"));
        View findViewById = this.l.findViewById(ac.e(this.f4471a, "tt_bu_close"));
        TextView textView = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_dislike"));
        int a2 = (int) ak.a(this.f4471a, 15.0f);
        ak.a(findViewById, a2, a2, a2, a2);
        b(findViewById);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (this.b.R() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                int c = this.f - ak.c(this.f4471a, 12.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c, (c * 9) / 16);
                layoutParams.gravity = 17;
                frameLayout.addView(videoView, 0, layoutParams);
            }
            ak.a((View) imageView, 8);
            ak.a((View) frameLayout, 0);
        } else {
            a(imageView);
            ak.a((View) imageView, 0);
            ak.a((View) frameLayout, 8);
        }
        textView.setText(getDescription());
        a((View) this, true);
        a(this.l, true);
        a((View) textView2, true);
        a(frameLayout);
    }

    private i a(int i, int i2) {
        try {
            float floatValue = Float.valueOf(i).floatValue() / Float.valueOf(i2).floatValue();
            i iVar = k[0];
            float f = Float.MAX_VALUE;
            i[] iVarArr = k;
            int length = iVarArr.length;
            int i3 = 0;
            while (i3 < length) {
                i iVar2 = iVarArr[i3];
                float abs = Math.abs(iVar2.c - floatValue);
                if (abs > f) {
                    abs = f;
                    iVar2 = iVar;
                }
                i3++;
                f = abs;
                iVar = iVar2;
            }
            return iVar;
        } catch (Throwable th) {
            return k[0];
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, j jVar) {
        if (this.m != null) {
            this.m.a(i, jVar);
        }
    }
}
