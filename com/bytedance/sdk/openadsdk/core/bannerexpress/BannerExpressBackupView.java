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
import com.bytedance.sdk.openadsdk.h.d;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.util.Locale;
/* loaded from: classes6.dex */
public class BannerExpressBackupView extends BackupView {
    private static i[] k = {new i(1, 6.6666665f, 600, 90), new i(1, 6.4f, 640, 100), new i(1, 4.0f, 600, 150), new i(2, 1.2f, 600, 500), new i(3, 1, 1.5f, 600, 400), new i(3, 2, 2.0f, 600, 300), new i(3, 3, 2.3076923f, 600, 260), new i(3, 4, 1.7783505f, 690, 388)};
    private View l;
    private NativeExpressView m;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a n;
    private int o;

    public BannerExpressBackupView(@NonNull Context context) {
        super(context);
        this.o = 1;
        this.f4471a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, j jVar) {
        if (this.m != null) {
            this.m.a(i, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        setBackgroundColor(-1);
        this.b = lVar;
        this.m = nativeExpressView;
        this.n = aVar;
        this.e = "banner_ad";
        this.m.addView(this, new ViewGroup.LayoutParams(-2, -2));
        this.h = aj.d(this.b.aj());
        a(this.h);
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
            this.f = ak.c(this.f4471a);
            this.g = Float.valueOf(this.f / a2.c).intValue();
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
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (a2.f4494a == 1) {
            d();
        } else if (a2.f4494a == 2) {
            c();
        } else if (a2.f4494a == 3) {
            a(a2);
        } else {
            d();
        }
    }

    private void a(ImageView imageView) {
        d.a(this.f4471a).a(this.b.Z().get(0).a(), imageView);
    }

    private void a(i iVar) {
        this.l = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_banner_layout3"), (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) this.l.findViewById(ac.e(this.f4471a, "tt_ad_content_layout"));
        View findViewById = this.l.findViewById(ac.e(this.f4471a, "tt_bu_close"));
        ImageView imageView = (ImageView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_img"));
        ImageView imageView2 = (ImageView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_icon"));
        TextView textView = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_title"));
        TextView textView2 = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_desc"));
        TextView textView3 = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_name"));
        TextView textView4 = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_download"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        int a2 = (int) ak.a(this.f4471a, 15.0f);
        ak.a(findViewById, a2, a2, a2, a2);
        if (this.b.R() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                int i = (this.g * 266) / 400;
                int i2 = (this.f * 406) / 600;
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i2, (i2 * 9) / 16);
                if (iVar.b == 1) {
                    int i3 = (this.f * 406) / 600;
                    layoutParams = new FrameLayout.LayoutParams(i3, (i3 * 9) / 16);
                } else if (iVar.b == 2) {
                    layoutParams = new FrameLayout.LayoutParams(-1, -1);
                } else if (iVar.b == 3) {
                    int i4 = (this.g * Opcodes.NEWARRAY) / 260;
                    layoutParams = new FrameLayout.LayoutParams((i4 * 16) / 9, i4);
                } else if (iVar.b == 4) {
                    int i5 = (this.f * 480) / 690;
                    layoutParams = new FrameLayout.LayoutParams(i5, (i5 * 9) / 16);
                }
                layoutParams.gravity = 17;
                frameLayout.addView(videoView, 0, layoutParams);
            }
            ak.a((View) imageView, 8);
        } else {
            a(imageView);
            ak.a((View) imageView, 0);
        }
        d.a(this.f4471a).a(this.b.U().a(), imageView2);
        textView3.setText(getNameOrSource());
        textView.setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
        textView2.setText(getDescription());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView4.setText(this.b.af());
        }
        a((View) this, true);
        a((View) textView4, true);
        a(frameLayout);
    }

    private void c() {
        this.l = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_banner_layout2"), (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) this.l.findViewById(ac.e(this.f4471a, "tt_ad_content_layout"));
        View findViewById = this.l.findViewById(ac.e(this.f4471a, "tt_bu_close"));
        ImageView imageView = (ImageView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_img"));
        ImageView imageView2 = (ImageView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_icon"));
        TextView textView = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_download"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        int a2 = (int) ak.a(this.f4471a, 15.0f);
        ak.a(findViewById, a2, a2, a2, a2);
        ((TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_title"))).setText(getTitle());
        ((TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_desc"))).setText(getDescription());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView.setText(this.b.af());
        }
        if (this.b.R() != null) {
            View videoView = getVideoView();
            if (videoView != null) {
                frameLayout.removeAllViews();
                int c = this.f - ak.c(this.f4471a, 14.0f);
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
        d.a(this.f4471a).a(this.b.U().a(), imageView2);
        a((View) this, true);
        a((View) textView, true);
        a(frameLayout);
    }

    private void d() {
        this.l = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_banner_layout1"), (ViewGroup) this, true);
        View findViewById = this.l.findViewById(ac.e(this.f4471a, "tt_bu_close"));
        TextView textView = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.l.findViewById(ac.e(this.f4471a, "tt_bu_score_bar"));
        TextView textView2 = (TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_download"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        d.a(this.f4471a).a(this.b.U().a(), (ImageView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_icon")));
        ((TextView) this.l.findViewById(ac.e(this.f4471a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView2.setText(this.b.af());
        }
        int e = this.b.ah() != null ? this.b.ah().e() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(e)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(e);
        tTRatingBar.setStarImageWidth(ak.c(this.f4471a, 15.0f));
        tTRatingBar.setStarImageHeight(ak.c(this.f4471a, 14.0f));
        tTRatingBar.setStarImagePadding(ak.c(this.f4471a, 4.0f));
        tTRatingBar.a();
        a((View) this, true);
        a((View) textView2, true);
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
}
