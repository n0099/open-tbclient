package com.bytedance.sdk.openadsdk.core.bannerexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.asm.Opcodes;
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import java.util.Locale;
/* loaded from: classes6.dex */
public class BannerExpressBackupView extends BackupView {
    public static i[] k = {new i(1, 6.6666665f, 600, 90), new i(1, 6.4f, 640, 100), new i(1, 4.0f, 600, 150), new i(2, 1.2f, 600, 500), new i(3, 1, 1.5f, 600, 400), new i(3, 2, 2.0f, 600, 300), new i(3, 3, 2.3076923f, 600, 260), new i(3, 4, 1.7783505f, 690, 388)};
    public View l;
    public NativeExpressView m;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a n;
    public int o;

    public BannerExpressBackupView(@NonNull Context context) {
        super(context);
        this.o = 1;
        this.f28477a = context;
    }

    private void b() {
        i a2 = a(this.m.getExpectExpressWidth(), this.m.getExpectExpressHeight());
        if (this.m.getExpectExpressWidth() > 0 && this.m.getExpectExpressHeight() > 0) {
            if (this.m.getExpectExpressWidth() > this.m.getExpectExpressHeight()) {
                this.f28482f = al.c(this.f28477a, this.m.getExpectExpressHeight() * a2.f28537c);
                this.f28483g = al.c(this.f28477a, this.m.getExpectExpressHeight());
            } else {
                this.f28482f = al.c(this.f28477a, this.m.getExpectExpressWidth());
                this.f28483g = al.c(this.f28477a, this.m.getExpectExpressWidth() / a2.f28537c);
            }
        } else {
            int c2 = al.c(this.f28477a);
            this.f28482f = c2;
            this.f28483g = Float.valueOf(c2 / a2.f28537c).intValue();
        }
        int i = this.f28482f;
        if (i > 0 && i > al.c(this.f28477a)) {
            float c3 = al.c(this.f28477a) / this.f28482f;
            this.f28482f = al.c(this.f28477a);
            this.f28483g = Float.valueOf(this.f28483g * c3).intValue();
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(this.f28482f, this.f28483g);
        }
        layoutParams.width = this.f28482f;
        layoutParams.height = this.f28483g;
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        int i2 = a2.f28535a;
        if (i2 == 1) {
            d();
        } else if (i2 == 2) {
            c();
        } else if (i2 == 3) {
            a(a2);
        } else {
            d();
        }
    }

    private void c() {
        View inflate = LayoutInflater.from(this.f28477a).inflate(ad.f(this.f28477a, "tt_backup_banner_layout2"), (ViewGroup) this, true);
        this.l = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ad.e(this.f28477a, "tt_ad_content_layout"));
        View findViewById = this.l.findViewById(ad.e(this.f28477a, "tt_bu_close"));
        ImageView imageView = (ImageView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_img"));
        ImageView imageView2 = (ImageView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_icon"));
        TextView textView = (TextView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_download"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        int a2 = (int) al.a(this.f28477a, 15.0f);
        al.a(findViewById, a2, a2, a2, a2);
        ((TextView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_title"))).setText(getTitle());
        ((TextView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_desc"))).setText(getDescription());
        if (!TextUtils.isEmpty(this.f28478b.al())) {
            textView.setText(this.f28478b.al());
        }
        if (this.f28478b.X() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                int c2 = this.f28482f - al.c(this.f28477a, 14.0f);
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
        e.c().a(this.f28478b.aa().a(), imageView2);
        a((View) this, true);
        a((View) textView, true);
        a(frameLayout);
    }

    private void d() {
        View inflate = LayoutInflater.from(this.f28477a).inflate(ad.f(this.f28477a, "tt_backup_banner_layout1"), (ViewGroup) this, true);
        this.l = inflate;
        View findViewById = inflate.findViewById(ad.e(this.f28477a, "tt_bu_close"));
        TextView textView = (TextView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.l.findViewById(ad.e(this.f28477a, "tt_bu_score_bar"));
        TextView textView2 = (TextView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_download"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        e.c().a(this.f28478b.aa().a(), (ImageView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_icon")));
        ((TextView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.f28478b.al())) {
            textView2.setText(this.f28478b.al());
        }
        int e2 = this.f28478b.an() != null ? this.f28478b.an().e() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(e2)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(e2);
        tTRatingBar.setStarImageWidth(al.c(this.f28477a, 15.0f));
        tTRatingBar.setStarImageHeight(al.c(this.f28477a, 14.0f));
        tTRatingBar.setStarImagePadding(al.c(this.f28477a, 4.0f));
        tTRatingBar.a();
        a((View) this, true);
        a((View) textView2, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void a(int i, j jVar) {
        NativeExpressView nativeExpressView = this.m;
        if (nativeExpressView != null) {
            nativeExpressView.a(i, jVar);
        }
    }

    public void a(l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        setBackgroundColor(-1);
        this.f28478b = lVar;
        this.m = nativeExpressView;
        this.n = aVar;
        this.f28481e = "banner_ad";
        nativeExpressView.addView(this, new ViewGroup.LayoutParams(-2, -2));
        int d2 = ak.d(this.f28478b.ap());
        this.f28484h = d2;
        a(d2);
        b();
    }

    private void a(ImageView imageView) {
        e.c().a(this.f28478b.af().get(0).a(), imageView);
    }

    private void a(i iVar) {
        View inflate = LayoutInflater.from(this.f28477a).inflate(ad.f(this.f28477a, "tt_backup_banner_layout3"), (ViewGroup) this, true);
        this.l = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ad.e(this.f28477a, "tt_ad_content_layout"));
        View findViewById = this.l.findViewById(ad.e(this.f28477a, "tt_bu_close"));
        ImageView imageView = (ImageView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_img"));
        ImageView imageView2 = (ImageView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_icon"));
        TextView textView = (TextView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_title"));
        TextView textView2 = (TextView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_name"));
        TextView textView4 = (TextView) this.l.findViewById(ad.e(this.f28477a, "tt_bu_download"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        int a2 = (int) al.a(this.f28477a, 15.0f);
        al.a(findViewById, a2, a2, a2, a2);
        if (this.f28478b.X() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                int i = (this.f28483g * 266) / 400;
                int i2 = (this.f28482f * 406) / 600;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, (i2 * 9) / 16);
                int i3 = iVar.f28536b;
                if (i3 == 1) {
                    int i4 = (this.f28482f * 406) / 600;
                    layoutParams = new FrameLayout.LayoutParams(i4, (i4 * 9) / 16);
                } else if (i3 == 2) {
                    layoutParams = new FrameLayout.LayoutParams(-1, -1);
                } else if (i3 == 3) {
                    int i5 = (this.f28483g * Opcodes.NEWARRAY) / 260;
                    layoutParams = new FrameLayout.LayoutParams((i5 * 16) / 9, i5);
                } else if (i3 == 4) {
                    int i6 = (this.f28482f * 480) / 690;
                    layoutParams = new FrameLayout.LayoutParams(i6, (i6 * 9) / 16);
                }
                layoutParams.gravity = 17;
                frameLayout.addView(videoView, 0, layoutParams);
            }
            al.a((View) imageView, 8);
        } else {
            a(imageView);
            al.a((View) imageView, 0);
        }
        e.c().a(this.f28478b.aa().a(), imageView2);
        textView3.setText(getNameOrSource());
        textView.setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
        textView2.setText(getDescription());
        if (!TextUtils.isEmpty(this.f28478b.al())) {
            textView4.setText(this.f28478b.al());
        }
        a((View) this, true);
        a((View) textView4, true);
        a(frameLayout);
    }

    private i a(int i, int i2) {
        i[] iVarArr;
        try {
            float floatValue = Float.valueOf(i).floatValue() / Float.valueOf(i2).floatValue();
            i iVar = k[0];
            float f2 = Float.MAX_VALUE;
            for (i iVar2 : k) {
                float abs = Math.abs(iVar2.f28537c - floatValue);
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
}
