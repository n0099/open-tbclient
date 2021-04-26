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
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.al;
/* loaded from: classes5.dex */
public class a extends BackupView {
    public static i[] k = {new i(1, 1.0f, 300, 300), new i(2, 0.6666667f, 300, 450), new i(3, 1.5f, 300, 200)};
    public View l;
    public NativeExpressView m;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a n;
    public int o;
    public Dialog p;

    public a(@NonNull Context context) {
        super(context);
        this.o = 1;
        this.f29034a = context;
    }

    private void b() {
        i a2 = a(this.m.getExpectExpressWidth(), this.m.getExpectExpressHeight());
        if (this.m.getExpectExpressWidth() > 0 && this.m.getExpectExpressHeight() > 0) {
            if (this.m.getExpectExpressWidth() > this.m.getExpectExpressHeight()) {
                this.f29039f = al.c(this.f29034a, this.m.getExpectExpressHeight() * a2.f29097c);
                this.f29040g = al.c(this.f29034a, this.m.getExpectExpressHeight());
            } else {
                this.f29039f = al.c(this.f29034a, this.m.getExpectExpressWidth());
                this.f29040g = al.c(this.f29034a, this.m.getExpectExpressWidth() / a2.f29097c);
            }
        } else {
            this.f29039f = al.c(this.f29034a, a2.f29098d);
            this.f29040g = al.c(this.f29034a, a2.f29099e);
        }
        int i2 = this.f29039f;
        if (i2 > 0 && i2 > al.c(this.f29034a)) {
            float c2 = al.c(this.f29034a) / this.f29039f;
            this.f29039f = al.c(this.f29034a);
            this.f29040g = Float.valueOf(this.f29040g * c2).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f29039f, this.f29040g);
        }
        layoutParams.width = this.f29039f;
        layoutParams.height = this.f29040g;
        setLayoutParams(layoutParams);
        int i3 = a2.f29095a;
        if (i3 == 1) {
            c();
        } else if (i3 == 2) {
            d();
        } else if (i3 == 3) {
            e();
        } else {
            c();
        }
    }

    private void c() {
        View inflate = LayoutInflater.from(this.f29034a).inflate(ad.f(this.f29034a, "tt_backup_insert_layout1"), (ViewGroup) this, true);
        this.l = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ad.e(this.f29034a, "tt_ad_container"));
        ImageView imageView = (ImageView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_img"));
        View findViewById = this.l.findViewById(ad.e(this.f29034a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_icon"));
        TextView textView = (TextView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_title"));
        TextView textView2 = (TextView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_download"));
        TextView textView4 = (TextView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_dislike"));
        int a2 = (int) al.a(this.f29034a, 15.0f);
        al.a(findViewById, a2, a2, a2, a2);
        b(findViewById);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (!TextUtils.isEmpty(this.f29035b.al())) {
            textView3.setText(this.f29035b.al());
        }
        if (this.f29035b.X() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                int i2 = this.f29039f;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, (i2 * 9) / 16);
                layoutParams.gravity = 17;
                frameLayout.addView(videoView, 0, layoutParams);
            }
            al.a((View) imageView, 8);
            al.a((View) frameLayout, 0);
        } else {
            a(imageView);
            al.a((View) imageView, 0);
            al.a((View) frameLayout, 8);
        }
        e.c().a(this.f29035b.aa().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        a((View) this, true);
        a((View) textView3, true);
        a((View) textView4, true);
        a(frameLayout);
    }

    private void d() {
        View inflate = LayoutInflater.from(this.f29034a).inflate(ad.f(this.f29034a, "tt_backup_insert_layout2"), (ViewGroup) this, true);
        this.l = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ad.e(this.f29034a, "tt_ad_container"));
        ImageView imageView = (ImageView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_img"));
        View findViewById = this.l.findViewById(ad.e(this.f29034a, "tt_bu_close"));
        ImageView imageView2 = (ImageView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_icon"));
        TextView textView = (TextView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_title"));
        TextView textView2 = (TextView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_download"));
        TextView textView4 = (TextView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_dislike"));
        int a2 = (int) al.a(this.f29034a, 15.0f);
        al.a(findViewById, a2, a2, a2, a2);
        b(findViewById);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (!TextUtils.isEmpty(this.f29035b.al())) {
            textView3.setText(this.f29035b.al());
        }
        if (this.f29035b.X() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                int i2 = this.f29039f;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, (i2 * 9) / 16);
                layoutParams.gravity = 17;
                frameLayout.addView(videoView, 0, layoutParams);
            }
            al.a((View) imageView, 8);
            al.a((View) frameLayout, 0);
        } else {
            a(imageView);
            al.a((View) imageView, 0);
            al.a((View) frameLayout, 8);
        }
        e.c().a(this.f29035b.aa().a(), imageView2);
        textView.setText(getTitle());
        textView2.setText(getDescription());
        a((View) this, true);
        a((View) textView3, true);
        a((View) textView4, true);
        a(frameLayout);
    }

    private void e() {
        View inflate = LayoutInflater.from(this.f29034a).inflate(ad.f(this.f29034a, "tt_backup_insert_layout3"), (ViewGroup) this, true);
        this.l = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ad.e(this.f29034a, "tt_ad_container"));
        ImageView imageView = (ImageView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_img"));
        View findViewById = this.l.findViewById(ad.e(this.f29034a, "tt_bu_close"));
        TextView textView = (TextView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.l.findViewById(ad.e(this.f29034a, "tt_bu_dislike"));
        int a2 = (int) al.a(this.f29034a, 15.0f);
        al.a(findViewById, a2, a2, a2, a2);
        b(findViewById);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.c.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.a();
            }
        });
        if (this.f29035b.X() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                int c2 = this.f29039f - al.c(this.f29034a, 12.0f);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(c2, (c2 * 9) / 16);
                layoutParams.gravity = 17;
                frameLayout.addView(videoView, 0, layoutParams);
            }
            al.a((View) imageView, 8);
            al.a((View) frameLayout, 0);
        } else {
            a(imageView);
            al.a((View) imageView, 0);
            al.a((View) frameLayout, 8);
        }
        textView.setText(getDescription());
        a((View) this, true);
        a(this.l, true);
        a((View) textView2, true);
        a(frameLayout);
    }

    public void a(Dialog dialog) {
        this.p = dialog;
    }

    public void a(l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        setBackgroundColor(-1);
        this.f29035b = lVar;
        this.m = nativeExpressView;
        this.n = aVar;
        this.f29038e = "interaction";
        a(this.f29041h);
        this.m.addView(this, new ViewGroup.LayoutParams(-2, -2));
        b();
    }

    private void a(ImageView imageView) {
        e.c().a(this.f29035b.af().get(0).a(), imageView);
    }

    private i a(int i2, int i3) {
        i[] iVarArr;
        try {
            float floatValue = Float.valueOf(i2).floatValue() / Float.valueOf(i3).floatValue();
            i iVar = k[0];
            float f2 = Float.MAX_VALUE;
            for (i iVar2 : k) {
                float abs = Math.abs(iVar2.f29097c - floatValue);
                if (abs <= f2) {
                    iVar = iVar2;
                    f2 = abs;
                }
            }
            return iVar;
        } catch (Throwable unused) {
            return k[0];
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void a(int i2, j jVar) {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.a(i2, jVar);
        }
    }

    private void b(View view) {
        if (view == null) {
            return;
        }
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
