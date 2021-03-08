package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
/* loaded from: classes6.dex */
public class a extends b {
    private boolean D;
    private TTDrawFeedAd.DrawVideoListener E;
    private int F;

    /* renamed from: a  reason: collision with root package name */
    private boolean f4355a;
    private boolean b;

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.E = drawVideoListener;
    }

    public a(@NonNull Context context, @NonNull l lVar, @NonNull String str, int i) {
        super(context, lVar, str, i);
        this.f4355a = true;
        this.b = false;
        this.D = false;
    }

    public void a(boolean z) {
        this.f4355a = z;
    }

    public void b(boolean z) {
        this.b = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        int i5;
        if (!a(2)) {
            if (h() && c(view) && !this.D) {
                u.b("ClickCreativeListener", "拦截原生视频view走普通点击事件.....");
                super.a(view, i, i2, i3, i4);
                return;
            }
            i();
            u.b("ClickCreativeListener", "走创意区域点击事件.....");
            if (this.c == null) {
                this.c = p.a();
            }
            if (this.c != null) {
                this.i = a(i, i2, i3, i4, this.w, this.x, this.g == null ? null : this.g.get(), this.h == null ? null : this.h.get());
                int T = this.d.T();
                switch (T) {
                    case 2:
                    case 3:
                        if (this.k != null || this.b) {
                            com.bytedance.sdk.openadsdk.c.d.a(this.c, "click_button", this.d, this.i, this.e, true, this.o);
                        }
                        z.a(true);
                        boolean a2 = z.a(this.c, this.d, this.f, this.k, this.p, aj.a(this.f), this.n, true, this.o, this.r, a(this.e));
                        if (this.f4355a) {
                            com.bytedance.sdk.openadsdk.c.d.a(this.c, "click", this.d, this.i, this.e, a2, this.o);
                            i5 = T;
                            break;
                        }
                        i5 = T;
                        break;
                    case 4:
                        if ((this.k != null || this.p != null) && !"feed_video_middle_page".equals(this.e) && this.d.C() && !TextUtils.isEmpty(n.a(this.d))) {
                            boolean a3 = z.a(this.c, this.d, this.f, this.k, this.p, this.e, this.n, true, this.o, this.r, a(this.e));
                            if (this.f4355a) {
                                com.bytedance.sdk.openadsdk.c.d.a(this.c, "click", this.d, this.i, this.e, a3, this.o);
                            }
                            i5 = T;
                            break;
                        } else {
                            if (this.n != null) {
                                this.n.g();
                                if (this.f4355a) {
                                    com.bytedance.sdk.openadsdk.c.d.a(this.c, "click", this.d, this.i, this.e, true, this.o);
                                    i5 = T;
                                    break;
                                }
                            }
                            i5 = T;
                            break;
                        }
                    case 5:
                        String b = b(this.e);
                        if (!TextUtils.isEmpty(b)) {
                            com.bytedance.sdk.openadsdk.c.d.a(this.c, "click_call", this.d, this.i, b, true, this.o);
                        }
                        com.bytedance.sdk.openadsdk.c.d.a(this.c, "click", this.d, this.i, this.e, aj.d(view.getContext(), this.d.aa()), this.o);
                        i5 = T;
                        break;
                    default:
                        i5 = -1;
                        break;
                }
                if (this.j != null) {
                    this.j.a(view, i5);
                }
                if (aj.b(this.d) && this.E != null) {
                    this.E.onClick();
                }
            }
        }
    }

    private boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.equals("feed_video_middle_page");
    }

    protected boolean a() {
        boolean z = false;
        if (this.d == null) {
            return true;
        }
        switch (p.h().c(aj.d(this.d.aj()))) {
            case 1:
                return x.d(this.c);
            case 2:
                if (x.e(this.c) || x.d(this.c)) {
                    z = true;
                }
                return z;
            case 3:
                return false;
            case 4:
            default:
                return true;
        }
    }

    private boolean f() {
        return this.d != null && this.d.k() == 1 && l.c(this.d);
    }

    private boolean c(View view) {
        boolean z = false;
        if (view == null) {
            return false;
        }
        if (view instanceof NativeVideoTsView) {
            u.c("ClickCreativeListener", "NativeVideoTsView....");
            return true;
        } else if (view.getId() == ac.e(this.c, "tt_video_ad_cover_center_layout") || view.getId() == ac.e(this.c, "tt_video_ad_logo_image") || view.getId() == ac.e(this.c, "tt_video_btn_ad_image_tv") || view.getId() == ac.e(this.c, "tt_video_ad_name") || view.getId() == ac.e(this.c, "tt_video_ad_button")) {
            u.c("ClickCreativeListener", "tt_video_ad_cover_center_layout....");
            return true;
        } else if (view.getId() == ac.e(this.c, "tt_root_view") || view.getId() == ac.e(this.c, "tt_video_play")) {
            u.c("ClickCreativeListener", "tt_root_view....");
            return true;
        } else {
            if (view instanceof ViewGroup) {
                int i = 0;
                while (true) {
                    if (i >= ((ViewGroup) view).getChildCount()) {
                        break;
                    } else if (c(((ViewGroup) view).getChildAt(i))) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
            }
            return z;
        }
    }

    private boolean g() {
        return this instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.d;
    }

    private boolean h() {
        if (this.d == null || g() || !l.c(this.d)) {
            return false;
        }
        if (this.F == 0) {
            this.F = aj.c(this.d.aj());
        }
        u.b("ClickCreativeListener", "!isViewVisibility()=" + (!b()) + ",isAutoPlay()=" + a() + ",!isCoverPageVisibility()=" + (!c()));
        if (this.F == 5 && f() && a() && !b() && !c()) {
            return false;
        }
        return this.F == 1 || this.F == 2 || this.F == 5;
    }

    private String b(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c = 2;
                    break;
                }
                break;
            case -712491894:
                if (str.equals("embeded_ad")) {
                    c = 0;
                    break;
                }
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c = 5;
                    break;
                }
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c = 4;
                    break;
                }
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c = 1;
                    break;
                }
                break;
            case 2091589896:
                if (str.equals("slide_banner_ad")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
                return "feed_call";
            case 2:
                return "banner_call";
            case 3:
                return "banner_call";
            case 4:
                return "interaction_call";
            case 5:
                return "splash_ad";
            default:
                return "";
        }
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    public void c(boolean z) {
        this.D = z;
    }

    private void i() {
        if (this.D && this.n != null && (this.n instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d)) {
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) this.n).f(true);
        }
    }
}
