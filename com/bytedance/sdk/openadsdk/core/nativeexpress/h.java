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
import com.baidu.android.imsdk.internal.Constants;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import java.util.Locale;
/* loaded from: classes6.dex */
class h extends BackupView {
    private static i[] k = {new i(2, 3.0241935f, 375, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER), new i(3, 1.25f, 375, 300), new i(4, 1.4044944f, 375, 267), new i(16, 1.25f, 375, 300), new i(5, 1.25f, 375, 300), new i(15, 1.25f, 375, 300)};
    private int l;
    private View m;
    private NativeExpressView n;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a o;

    public h(@NonNull Context context) {
        super(context);
        this.f4471a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        u.b("FeedExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.b = lVar;
        this.n = nativeExpressView;
        this.o = aVar;
        this.l = aj.d(this.b.aj());
        a(this.l);
        b();
        this.n.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void b() {
        i b = b(this.b.ak());
        this.f = ak.c(this.f4471a, this.n.getExpectExpressWidth());
        this.g = ak.c(this.f4471a, this.n.getExpectExpressHeight());
        if (this.f <= 0) {
            this.f = ak.c(this.f4471a);
        }
        if (this.g <= 0) {
            this.g = Float.valueOf(this.f / b.c).intValue();
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
        if (aj.c(this.b.aj()) == 9) {
            this.e = "draw_ad";
            g();
            return;
        }
        this.e = "embeded_ad";
        switch (this.b.ak()) {
            case 2:
                c();
                return;
            case 3:
                e();
                return;
            case 4:
                d();
                return;
            case 5:
                h();
                return;
            case 15:
                f();
                return;
            case 16:
                i();
                return;
            default:
                return;
        }
    }

    private i b(int i) {
        i[] iVarArr;
        i iVar = k[0];
        try {
            for (i iVar2 : k) {
                if (iVar2.f4494a == i) {
                    return iVar2;
                }
            }
            return iVar;
        } catch (Throwable th) {
            return iVar;
        }
    }

    private void a(ImageView imageView) {
        com.bytedance.sdk.openadsdk.h.d.a(this.f4471a).a(this.b.Z().get(0).a(), imageView);
    }

    private void c() {
        this.m = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_feed_img_small"), (ViewGroup) this, true);
        a((ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_img")));
        ((TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_title"))).setText(getTitle());
        ((ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        a((View) this, true);
    }

    private void d() {
        this.m = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_feed_img_group"), (ViewGroup) this, true);
        TextView textView = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_download"));
        String a2 = this.b.Z().get(0).a();
        String a3 = this.b.Z().get(1).a();
        String a4 = this.b.Z().get(2).a();
        com.bytedance.sdk.openadsdk.h.d.a(this.f4471a).a(a2, (ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_img_1")));
        com.bytedance.sdk.openadsdk.h.d.a(this.f4471a).a(a3, (ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_img_2")));
        com.bytedance.sdk.openadsdk.h.d.a(this.f4471a).a(a4, (ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_img_3")));
        com.bytedance.sdk.openadsdk.h.d.a(this.f4471a).a(this.b.U().a(), (ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_icon")));
        ((ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView.setText(this.b.af());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void e() {
        this.m = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        this.m.findViewById(ac.e(this.f4471a, "tt_bu_video_container")).setVisibility(8);
        this.m.findViewById(ac.e(this.f4471a, "tt_bu_img_container")).setVisibility(0);
        ImageView imageView = (ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_img"));
        TextView textView = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_download"));
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.g);
        a(imageView);
        ((ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView.setText(this.b.af());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void f() {
        this.m = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
        this.m.findViewById(ac.e(this.f4471a, "tt_bu_video_container")).setVisibility(0);
        this.m.findViewById(ac.e(this.f4471a, "tt_bu_img_container")).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.m.findViewById(ac.e(this.f4471a, "tt_bu_video_container_inner"));
        TextView textView = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_title"));
        TextView textView3 = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_video_name1"));
        TextView textView4 = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_video_name2"));
        TextView textView5 = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_download"));
        TextView textView6 = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_video_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.m.findViewById(ac.e(this.f4471a, "tt_bu_video_score_bar"));
        com.bytedance.sdk.openadsdk.h.d.a(this.f4471a).a(this.b.U().a(), (ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_video_icon")));
        ((ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        int e = this.b.ah() != null ? this.b.ah().e() : 4;
        textView6.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(e)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(e);
        tTRatingBar.setStarImageWidth(ak.c(this.f4471a, 15.0f));
        tTRatingBar.setStarImageHeight(ak.c(this.f4471a, 14.0f));
        tTRatingBar.setStarImagePadding(ak.c(this.f4471a, 4.0f));
        tTRatingBar.a();
        textView3.setText(getNameOrSource());
        textView4.setText(getTitle());
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView5.setText(this.b.af());
        }
        View videoView = getVideoView();
        if (videoView != null) {
            int i = (this.f * Constants.METHOD_IM_FRIEND_GROUP_QUERY) / 375;
            frameLayout.removeAllViews();
            frameLayout.addView(videoView, new ViewGroup.LayoutParams(i, (i * 16) / 9));
        }
        a((View) this, false);
        a((View) textView5, true);
    }

    private void g() {
        this.m = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_draw"), (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) this.m.findViewById(ac.e(this.f4471a, "tt_bu_video_container"));
        TextView textView = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_title"));
        TextView textView3 = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_download"));
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView3.setText(this.b.af());
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
        this.m = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) this.m.findViewById(ac.e(this.f4471a, "tt_bu_video_container"));
        frameLayout.setVisibility(0);
        this.m.findViewById(ac.e(this.f4471a, "tt_bu_img_container")).setVisibility(8);
        TextView textView = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_download"));
        ((ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView.setText(this.b.af());
        }
        View videoView = getVideoView();
        if (videoView != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(videoView, new ViewGroup.LayoutParams(this.f, (this.f * 9) / 16));
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void i() {
        this.m = LayoutInflater.from(this.f4471a).inflate(ac.f(this.f4471a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
        this.m.findViewById(ac.e(this.f4471a, "tt_bu_video_container")).setVisibility(8);
        this.m.findViewById(ac.e(this.f4471a, "tt_bu_img_container")).setVisibility(0);
        TextView textView = (TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_download"));
        a((ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_img")));
        ((ImageView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.m.findViewById(ac.e(this.f4471a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.b.af())) {
            textView.setText(this.b.af());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (this.n != null) {
            this.n.a(i, jVar);
        }
    }
}
