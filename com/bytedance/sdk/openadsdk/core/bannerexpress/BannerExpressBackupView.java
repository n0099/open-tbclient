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
import com.bytedance.sdk.openadsdk.core.d.j;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.i.e;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.ak;
import java.util.Locale;
/* loaded from: classes4.dex */
public class BannerExpressBackupView extends BackupView {
    private static i[] h = {new i(1, 6.6666665f, 600, 90), new i(1, 6.4f, 640, 100), new i(1, 4.0f, 600, 150), new i(2, 1.2f, 600, 500), new i(3, 1.5f, 600, 400), new i(3, 2.0f, 600, 300), new i(3, 2.3076923f, 600, 260), new i(3, 1.7783505f, 690, 388)};
    private View i;
    private NativeExpressView j;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a k;
    private int l;

    public BannerExpressBackupView(@NonNull Context context) {
        super(context);
        this.l = 1;
        this.f6915a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, j jVar) {
        if (this.j != null) {
            this.j.a(i, jVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        setBackgroundColor(-1);
        this.f6916b = lVar;
        this.j = nativeExpressView;
        this.k = aVar;
        this.e = "banner_ad";
        this.j.addView(this, new ViewGroup.LayoutParams(-2, -2));
        b();
    }

    private void b() {
        i a2 = a(this.j.getExpectExpressWidth(), this.j.getExpectExpressHeight());
        if (this.j.getExpectExpressWidth() > 0 && this.j.getExpectExpressHeight() > 0) {
            if (this.j.getExpectExpressWidth() > this.j.getExpectExpressHeight()) {
                this.f = ak.c(this.f6915a, this.j.getExpectExpressHeight() * a2.f6945b);
                this.g = ak.c(this.f6915a, this.j.getExpectExpressHeight());
            } else {
                this.f = ak.c(this.f6915a, this.j.getExpectExpressWidth());
                this.g = ak.c(this.f6915a, this.j.getExpectExpressWidth() / a2.f6945b);
            }
        } else {
            this.f = ak.c(this.f6915a);
            this.g = Float.valueOf(this.f / a2.f6945b).intValue();
        }
        if (this.f > 0 && this.f > ak.c(this.f6915a)) {
            float c = ak.c(this.f6915a) / this.f;
            this.f = ak.c(this.f6915a);
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
        if (a2.f6944a == 1) {
            e();
        } else if (a2.f6944a == 2) {
            d();
        } else if (a2.f6944a == 3) {
            c();
        } else {
            e();
        }
    }

    private void a(ImageView imageView) {
        e.a(this.f6915a).a(this.f6916b.M().get(0).a(), imageView);
    }

    private void c() {
        this.i = LayoutInflater.from(this.f6915a).inflate(ac.f(this.f6915a, "tt_backup_banner_layout3"), (ViewGroup) this, true);
        View findViewById = this.i.findViewById(ac.e(this.f6915a, "tt_bu_close"));
        TextView textView = (TextView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_download"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        int a2 = (int) ak.a(this.f6915a, 15.0f);
        ak.a(findViewById, a2, a2, a2, a2);
        a((ImageView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_img")));
        e.a(this.f6915a).a(this.f6916b.I().a(), (ImageView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_icon")));
        ((TextView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_name"))).setText(getNameOrSource());
        ((TextView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_title"))).setText(String.format(Locale.getDefault(), "%s提供的广告", getNameOrSource()));
        ((TextView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_desc"))).setText(getDescription());
        if (!TextUtils.isEmpty(this.f6916b.S())) {
            textView.setText(this.f6916b.S());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void d() {
        this.i = LayoutInflater.from(this.f6915a).inflate(ac.f(this.f6915a, "tt_backup_banner_layout2"), (ViewGroup) this, true);
        View findViewById = this.i.findViewById(ac.e(this.f6915a, "tt_bu_close"));
        TextView textView = (TextView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_download"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        int a2 = (int) ak.a(this.f6915a, 15.0f);
        ak.a(findViewById, a2, a2, a2, a2);
        a((ImageView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_img")));
        e.a(this.f6915a).a(this.f6916b.I().a(), (ImageView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_icon")));
        ((TextView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_title"))).setText(getTitle());
        ((TextView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_desc"))).setText(getDescription());
        if (!TextUtils.isEmpty(this.f6916b.S())) {
            textView.setText(this.f6916b.S());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void e() {
        this.i = LayoutInflater.from(this.f6915a).inflate(ac.f(this.f6915a, "tt_backup_banner_layout1"), (ViewGroup) this, true);
        View findViewById = this.i.findViewById(ac.e(this.f6915a, "tt_bu_close"));
        TextView textView = (TextView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.i.findViewById(ac.e(this.f6915a, "tt_bu_score_bar"));
        TextView textView2 = (TextView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_download"));
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.bannerexpress.BannerExpressBackupView.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BannerExpressBackupView.this.a();
            }
        });
        e.a(this.f6915a).a(this.f6916b.I().a(), (ImageView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_icon")));
        ((TextView) this.i.findViewById(ac.e(this.f6915a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.f6916b.S())) {
            textView2.setText(this.f6916b.S());
        }
        int e = this.f6916b.U() != null ? this.f6916b.U().e() : 4;
        textView.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(e)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(e);
        tTRatingBar.setStarImageWidth(ak.c(this.f6915a, 15.0f));
        tTRatingBar.setStarImageHeight(ak.c(this.f6915a, 14.0f));
        tTRatingBar.setStarImagePadding(ak.c(this.f6915a, 4.0f));
        tTRatingBar.a();
        a((View) this, false);
        a((View) textView2, true);
    }

    private i a(int i, int i2) {
        try {
            float floatValue = Float.valueOf(i).floatValue() / Float.valueOf(i2).floatValue();
            i iVar = h[0];
            float f = Float.MAX_VALUE;
            i[] iVarArr = h;
            int length = iVarArr.length;
            int i3 = 0;
            while (i3 < length) {
                i iVar2 = iVarArr[i3];
                float abs = Math.abs(iVar2.f6945b - floatValue);
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
            return h[0];
        }
    }
}
