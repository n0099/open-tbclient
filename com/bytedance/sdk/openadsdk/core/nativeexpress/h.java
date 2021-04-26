package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Locale;
/* loaded from: classes5.dex */
public class h extends BackupView {
    public static i[] k = {new i(2, 3.0241935f, 375, 124), new i(3, 1.25f, 375, 300), new i(4, 1.4044944f, 375, 267), new i(16, 1.25f, 375, 300), new i(5, 1.25f, 375, 300), new i(15, 1.25f, 375, 300)};
    public int l;
    public View m;
    public NativeExpressView n;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a o;

    public h(@NonNull Context context) {
        super(context);
        this.f29034a = context;
    }

    private void b() {
        i b2 = b(this.f29035b.aq());
        this.f29039f = al.c(this.f29034a, this.n.getExpectExpressWidth());
        this.f29040g = al.c(this.f29034a, this.n.getExpectExpressHeight());
        if (this.f29039f <= 0) {
            this.f29039f = al.c(this.f29034a);
        }
        if (this.f29040g <= 0) {
            this.f29040g = Float.valueOf(this.f29039f / b2.f29097c).intValue();
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
        if (layoutParams instanceof FrameLayout.LayoutParams) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 17;
        }
        setLayoutParams(layoutParams);
        if (ak.c(this.f29035b.ap()) == 9) {
            this.f29038e = "draw_ad";
            g();
            return;
        }
        this.f29038e = "embeded_ad";
        int aq = this.f29035b.aq();
        if (aq == 2) {
            c();
        } else if (aq == 3) {
            e();
        } else if (aq == 4) {
            d();
        } else if (aq == 5) {
            h();
        } else if (aq == 15) {
            f();
        } else if (aq != 16) {
        } else {
            i();
        }
    }

    private void c() {
        View inflate = LayoutInflater.from(this.f29034a).inflate(ad.f(this.f29034a, "tt_backup_feed_img_small"), (ViewGroup) this, true);
        this.m = inflate;
        a((ImageView) inflate.findViewById(ad.e(this.f29034a, "tt_bu_img")));
        ((TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_title"))).setText(getTitle());
        ((ImageView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        a((View) this, true);
    }

    private void d() {
        View inflate = LayoutInflater.from(this.f29034a).inflate(ad.f(this.f29034a, "tt_backup_feed_img_group"), (ViewGroup) this, true);
        this.m = inflate;
        TextView textView = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_download"));
        String a2 = this.f29035b.af().get(0).a();
        String a3 = this.f29035b.af().get(1).a();
        String a4 = this.f29035b.af().get(2).a();
        com.bytedance.sdk.openadsdk.i.e.c().a(a2, (ImageView) inflate.findViewById(ad.e(this.f29034a, "tt_bu_img_1")));
        com.bytedance.sdk.openadsdk.i.e.c().a(a3, (ImageView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_img_2")));
        com.bytedance.sdk.openadsdk.i.e.c().a(a4, (ImageView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_img_3")));
        com.bytedance.sdk.openadsdk.i.e.c().a(this.f29035b.aa().a(), (ImageView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_icon")));
        ((ImageView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.f29035b.al())) {
            textView.setText(this.f29035b.al());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void e() {
        View inflate = LayoutInflater.from(this.f29034a).inflate(ad.f(this.f29034a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        this.m = inflate;
        inflate.findViewById(ad.e(this.f29034a, "tt_bu_video_container")).setVisibility(8);
        this.m.findViewById(ad.e(this.f29034a, "tt_bu_img_container")).setVisibility(0);
        ImageView imageView = (ImageView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_img"));
        TextView textView = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_download"));
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.f29040g);
        a(imageView);
        ((ImageView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.f29035b.al())) {
            textView.setText(this.f29035b.al());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void f() {
        View inflate = LayoutInflater.from(this.f29034a).inflate(ad.f(this.f29034a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
        this.m = inflate;
        inflate.findViewById(ad.e(this.f29034a, "tt_bu_video_container")).setVisibility(0);
        this.m.findViewById(ad.e(this.f29034a, "tt_bu_img_container")).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.m.findViewById(ad.e(this.f29034a, "tt_bu_video_container_inner"));
        TextView textView = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_title"));
        TextView textView3 = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_video_name1"));
        TextView textView4 = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_video_name2"));
        TextView textView5 = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_download"));
        TextView textView6 = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_video_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.m.findViewById(ad.e(this.f29034a, "tt_bu_video_score_bar"));
        com.bytedance.sdk.openadsdk.i.e.c().a(this.f29035b.aa().a(), (ImageView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_video_icon")));
        ((ImageView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        int e2 = this.f29035b.an() != null ? this.f29035b.an().e() : 4;
        textView6.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(e2)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(e2);
        tTRatingBar.setStarImageWidth(al.c(this.f29034a, 15.0f));
        tTRatingBar.setStarImageHeight(al.c(this.f29034a, 14.0f));
        tTRatingBar.setStarImagePadding(al.c(this.f29034a, 4.0f));
        tTRatingBar.a();
        textView3.setText(getNameOrSource());
        textView4.setText(getTitle());
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f29035b.al())) {
            textView5.setText(this.f29035b.al());
        }
        View videoView = getVideoView();
        if (videoView != null) {
            int i2 = (this.f29039f * 123) / 375;
            frameLayout.removeAllViews();
            frameLayout.addView(videoView, new ViewGroup.LayoutParams(i2, (i2 * 16) / 9));
        }
        a((View) this, false);
        a((View) textView5, true);
    }

    private void g() {
        View inflate = LayoutInflater.from(this.f29034a).inflate(ad.f(this.f29034a, "tt_backup_draw"), (ViewGroup) this, true);
        this.m = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ad.e(this.f29034a, "tt_bu_video_container"));
        TextView textView = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_title"));
        TextView textView3 = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_download"));
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f29035b.al())) {
            textView3.setText(this.f29035b.al());
        }
        View videoView = getVideoView();
        if (videoView != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(videoView, new ViewGroup.LayoutParams(-1, -1));
        }
        a((View) textView2, false);
        a((View) textView, false);
        a((View) textView3, true);
    }

    private void h() {
        View inflate = LayoutInflater.from(this.f29034a).inflate(ad.f(this.f29034a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        this.m = inflate;
        FrameLayout frameLayout = (FrameLayout) inflate.findViewById(ad.e(this.f29034a, "tt_bu_video_container"));
        frameLayout.setVisibility(0);
        this.m.findViewById(ad.e(this.f29034a, "tt_bu_img_container")).setVisibility(8);
        TextView textView = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_download"));
        ((ImageView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.f29035b.al())) {
            textView.setText(this.f29035b.al());
        }
        View videoView = getVideoView();
        if (videoView != null) {
            frameLayout.removeAllViews();
            int i2 = this.f29039f;
            frameLayout.addView(videoView, new ViewGroup.LayoutParams(i2, (i2 * 9) / 16));
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void i() {
        View inflate = LayoutInflater.from(this.f29034a).inflate(ad.f(this.f29034a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
        this.m = inflate;
        inflate.findViewById(ad.e(this.f29034a, "tt_bu_video_container")).setVisibility(8);
        this.m.findViewById(ad.e(this.f29034a, "tt_bu_img_container")).setVisibility(0);
        TextView textView = (TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_download"));
        a((ImageView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_img")));
        ((ImageView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ad.e(this.f29034a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.f29035b.al())) {
            textView.setText(this.f29035b.al());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        u.b("FeedExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.f29035b = lVar;
        this.n = nativeExpressView;
        this.o = aVar;
        int d2 = ak.d(lVar.ap());
        this.l = d2;
        a(d2);
        b();
        this.n.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void a(ImageView imageView) {
        com.bytedance.sdk.openadsdk.i.e.c().a(this.f29035b.af().get(0).a(), imageView);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    public void a(int i2, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        NativeExpressView nativeExpressView = this.n;
        if (nativeExpressView != null) {
            nativeExpressView.a(i2, jVar);
        }
    }

    private i b(int i2) {
        i[] iVarArr = k;
        i iVar = iVarArr[0];
        try {
            for (i iVar2 : iVarArr) {
                if (iVar2.f29095a == i2) {
                    return iVar2;
                }
            }
            return iVar;
        } catch (Throwable unused) {
            return iVar;
        }
    }
}
