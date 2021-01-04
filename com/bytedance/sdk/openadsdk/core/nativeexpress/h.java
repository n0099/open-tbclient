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
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.util.Locale;
/* loaded from: classes4.dex */
class h extends BackupView {
    private static i[] j = {new i(2, 3.0241935f, 375, Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER), new i(3, 1.25f, 375, 300), new i(4, 1.4044944f, 375, 267), new i(16, 1.25f, 375, 300), new i(5, 1.25f, 375, 300), new i(15, 1.25f, 375, 300)};
    boolean h;
    boolean i;
    private int k;
    private View l;
    private NativeExpressView m;
    private com.bytedance.sdk.openadsdk.downloadnew.core.a n;

    public h(@NonNull Context context) {
        super(context);
        this.h = true;
        this.i = true;
        this.f6914a = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.core.d.l lVar, NativeExpressView nativeExpressView, com.bytedance.sdk.openadsdk.downloadnew.core.a aVar) {
        u.b("FeedExpressBackupView", "show backup view");
        setBackgroundColor(-1);
        this.f6915b = lVar;
        this.m = nativeExpressView;
        this.n = aVar;
        this.k = aj.d(this.f6915b.W());
        b(this.k);
        c();
        this.m.addView(this, new ViewGroup.LayoutParams(-2, -2));
    }

    private void c() {
        i a2 = a(this.f6915b.X());
        this.f = ak.c(this.f6914a, this.m.getExpectExpressWidth());
        this.g = ak.c(this.f6914a, this.m.getExpectExpressHeight());
        if (this.f <= 0) {
            this.f = ak.c(this.f6914a);
        }
        if (this.g <= 0) {
            this.g = Float.valueOf(this.f / a2.f6944b).intValue();
        }
        if (this.f > 0 && this.f > ak.c(this.f6914a)) {
            float c = ak.c(this.f6914a) / this.f;
            this.f = ak.c(this.f6914a);
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
        if (aj.c(this.f6915b.W()) == 9) {
            this.e = "draw_ad";
            h();
            return;
        }
        this.e = "embeded_ad";
        switch (this.f6915b.X()) {
            case 2:
                d();
                return;
            case 3:
                f();
                return;
            case 4:
                e();
                return;
            case 5:
                i();
                return;
            case 15:
                g();
                return;
            case 16:
                j();
                return;
            default:
                return;
        }
    }

    private i a(int i) {
        i[] iVarArr;
        i iVar = j[0];
        try {
            for (i iVar2 : j) {
                if (iVar2.f6943a == i) {
                    return iVar2;
                }
            }
            return iVar;
        } catch (Throwable th) {
            return iVar;
        }
    }

    private void a(ImageView imageView) {
        com.bytedance.sdk.openadsdk.i.e.a(this.f6914a).a(this.f6915b.M().get(0).a(), imageView);
    }

    private void d() {
        this.l = LayoutInflater.from(this.f6914a).inflate(ac.f(this.f6914a, "tt_backup_feed_img_small"), (ViewGroup) this, true);
        a((ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_img")));
        ((TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_title"))).setText(getTitle());
        ((ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        a((View) this, true);
    }

    private void e() {
        this.l = LayoutInflater.from(this.f6914a).inflate(ac.f(this.f6914a, "tt_backup_feed_img_group"), (ViewGroup) this, true);
        TextView textView = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_download"));
        String a2 = this.f6915b.M().get(0).a();
        String a3 = this.f6915b.M().get(1).a();
        String a4 = this.f6915b.M().get(2).a();
        com.bytedance.sdk.openadsdk.i.e.a(this.f6914a).a(a2, (ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_img_1")));
        com.bytedance.sdk.openadsdk.i.e.a(this.f6914a).a(a3, (ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_img_2")));
        com.bytedance.sdk.openadsdk.i.e.a(this.f6914a).a(a4, (ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_img_3")));
        com.bytedance.sdk.openadsdk.i.e.a(this.f6914a).a(this.f6915b.I().a(), (ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_icon")));
        ((ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.f6915b.S())) {
            textView.setText(this.f6915b.S());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void f() {
        this.l = LayoutInflater.from(this.f6914a).inflate(ac.f(this.f6914a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        this.l.findViewById(ac.e(this.f6914a, "tt_bu_video_container")).setVisibility(8);
        this.l.findViewById(ac.e(this.f6914a, "tt_bu_img_container")).setVisibility(0);
        ImageView imageView = (ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_img"));
        TextView textView = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_download"));
        imageView.setAdjustViewBounds(true);
        imageView.setMaxHeight(this.g);
        a(imageView);
        ((ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.f6915b.S())) {
            textView.setText(this.f6915b.S());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void g() {
        this.l = LayoutInflater.from(this.f6914a).inflate(ac.f(this.f6914a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
        this.l.findViewById(ac.e(this.f6914a, "tt_bu_video_container")).setVisibility(0);
        this.l.findViewById(ac.e(this.f6914a, "tt_bu_img_container")).setVisibility(8);
        FrameLayout frameLayout = (FrameLayout) this.l.findViewById(ac.e(this.f6914a, "tt_bu_video_container_inner"));
        TextView textView = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_title"));
        TextView textView3 = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_video_name1"));
        TextView textView4 = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_video_name2"));
        TextView textView5 = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_download"));
        TextView textView6 = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_video_score"));
        TTRatingBar tTRatingBar = (TTRatingBar) this.l.findViewById(ac.e(this.f6914a, "tt_bu_video_score_bar"));
        com.bytedance.sdk.openadsdk.i.e.a(this.f6914a).a(this.f6915b.I().a(), (ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_video_icon")));
        ((ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        int e = this.f6915b.U() != null ? this.f6915b.U().e() : 4;
        textView6.setText(String.format(Locale.getDefault(), "%.1f", Float.valueOf(e)));
        tTRatingBar.setStarEmptyNum(1);
        tTRatingBar.setStarFillNum(e);
        tTRatingBar.setStarImageWidth(ak.c(this.f6914a, 15.0f));
        tTRatingBar.setStarImageHeight(ak.c(this.f6914a, 14.0f));
        tTRatingBar.setStarImagePadding(ak.c(this.f6914a, 4.0f));
        tTRatingBar.a();
        textView3.setText(getNameOrSource());
        textView4.setText(getTitle());
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f6915b.S())) {
            textView5.setText(this.f6915b.S());
        }
        View b2 = b();
        if (b2 != null) {
            int i = (this.f * Constants.METHOD_IM_FRIEND_GROUP_QUERY) / 375;
            frameLayout.removeAllViews();
            frameLayout.addView(b2, new ViewGroup.LayoutParams(i, (i * 16) / 9));
        }
        a((View) this, false);
        a((View) textView5, true);
    }

    private void h() {
        this.l = LayoutInflater.from(this.f6914a).inflate(ac.f(this.f6914a, "tt_backup_draw"), (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) this.l.findViewById(ac.e(this.f6914a, "tt_bu_video_container"));
        TextView textView = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_desc"));
        TextView textView2 = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_title"));
        TextView textView3 = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_download"));
        textView.setText(getDescription());
        textView2.setText(getTitle());
        if (!TextUtils.isEmpty(this.f6915b.S())) {
            textView3.setText(this.f6915b.S());
        }
        View b2 = b();
        if (b2 != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(b2, new ViewGroup.LayoutParams(-1, -1));
        }
        a((View) textView2, false);
        a((View) textView, false);
        a((View) textView3, true);
    }

    private void i() {
        this.l = LayoutInflater.from(this.f6914a).inflate(ac.f(this.f6914a, "tt_backup_feed_horizontal"), (ViewGroup) this, true);
        FrameLayout frameLayout = (FrameLayout) this.l.findViewById(ac.e(this.f6914a, "tt_bu_video_container"));
        frameLayout.setVisibility(0);
        this.l.findViewById(ac.e(this.f6914a, "tt_bu_img_container")).setVisibility(8);
        TextView textView = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_download"));
        ((ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.f6915b.S())) {
            textView.setText(this.f6915b.S());
        }
        View b2 = b();
        if (b2 != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(b2, new ViewGroup.LayoutParams(this.f, (this.f * 9) / 16));
        }
        a((View) this, false);
        a((View) textView, true);
    }

    private void j() {
        this.l = LayoutInflater.from(this.f6914a).inflate(ac.f(this.f6914a, "tt_backup_feed_vertical"), (ViewGroup) this, true);
        this.l.findViewById(ac.e(this.f6914a, "tt_bu_video_container")).setVisibility(8);
        this.l.findViewById(ac.e(this.f6914a, "tt_bu_img_container")).setVisibility(0);
        TextView textView = (TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_download"));
        a((ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_img")));
        ((ImageView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_close"))).setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                h.this.a();
            }
        });
        ((TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_desc"))).setText(getDescription());
        ((TextView) this.l.findViewById(ac.e(this.f6914a, "tt_bu_title"))).setText(getTitle());
        if (!TextUtils.isEmpty(this.f6915b.S())) {
            textView.setText(this.f6915b.S());
        }
        a((View) this, false);
        a((View) textView, true);
    }

    public View b() {
        NativeVideoTsView nativeVideoTsView;
        if (this.f6915b == null || this.f6914a == null) {
            return null;
        }
        if (k()) {
            try {
                nativeVideoTsView = new NativeVideoTsView(this.f6914a, this.f6915b);
                nativeVideoTsView.setControllerStatusCallBack(new NativeVideoTsView.a() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.h.7
                    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.a
                    public void a(boolean z, long j2, long j3, long j4, boolean z2) {
                    }
                });
                nativeVideoTsView.setIsAutoPlay(this.h);
                nativeVideoTsView.setIsQuiet(this.i);
            } catch (Throwable th) {
                nativeVideoTsView = null;
            }
        } else {
            nativeVideoTsView = null;
        }
        if (k() && nativeVideoTsView != null && nativeVideoTsView.a(0L, true, false)) {
            return nativeVideoTsView;
        }
        return null;
    }

    private void b(int i) {
        this.i = p.h().a(this.k);
        int c = p.h().c(i);
        if (3 == c) {
            this.h = false;
        } else if (1 == c && x.d(this.f6914a)) {
            this.h = true;
        } else if (2 == c) {
            if (x.e(this.f6914a) || x.d(this.f6914a)) {
                this.h = true;
            }
        }
    }

    private boolean k() {
        return this.f6915b != null && (this.f6915b.X() == 5 || this.f6915b.X() == 15);
    }

    @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView
    protected void a(int i, com.bytedance.sdk.openadsdk.core.d.j jVar) {
        if (this.m != null) {
            this.m.a(i, jVar);
        }
    }
}
