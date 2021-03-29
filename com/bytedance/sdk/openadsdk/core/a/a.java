package com.bytedance.sdk.openadsdk.core.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.TTNativeAd;
import com.bytedance.sdk.openadsdk.TTNativeExpressAd;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.n;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.z;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
/* loaded from: classes6.dex */
public class a extends b {
    public boolean D;
    public TTDrawFeedAd.DrawVideoListener E;
    public int F;

    /* renamed from: a  reason: collision with root package name */
    public boolean f28016a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28017b;

    public a(@NonNull Context context, @NonNull l lVar, @NonNull String str, int i) {
        super(context, lVar, str, i);
        this.f28016a = true;
        this.f28017b = false;
        this.D = false;
    }

    private boolean c(View view) {
        if (view == null) {
            return false;
        }
        if (view instanceof NativeVideoTsView) {
            u.c("ClickCreativeListener", "NativeVideoTsView....");
            return true;
        } else if (view.getId() != ad.e(this.f28018c, "tt_video_ad_cover_center_layout") && view.getId() != ad.e(this.f28018c, "tt_video_ad_logo_image") && view.getId() != ad.e(this.f28018c, "tt_video_btn_ad_image_tv") && view.getId() != ad.e(this.f28018c, "tt_video_ad_name") && view.getId() != ad.e(this.f28018c, "tt_video_ad_button")) {
            if (view.getId() != ad.e(this.f28018c, "tt_root_view") && view.getId() != ad.e(this.f28018c, "tt_video_play")) {
                if (!(view instanceof ViewGroup)) {
                    return false;
                }
                int i = 0;
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i >= viewGroup.getChildCount()) {
                        return false;
                    }
                    if (c(viewGroup.getChildAt(i))) {
                        return true;
                    }
                    i++;
                }
            } else {
                u.c("ClickCreativeListener", "tt_root_view....");
                return true;
            }
        } else {
            u.c("ClickCreativeListener", "tt_video_ad_cover_center_layout....");
            return true;
        }
    }

    private boolean f() {
        l lVar = this.f28019d;
        return lVar != null && lVar.k() == 1 && l.c(this.f28019d);
    }

    private boolean g() {
        return this instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.d;
    }

    private boolean h() {
        if (this.f28019d == null || g() || !l.c(this.f28019d)) {
            return false;
        }
        if (this.F == 0) {
            this.F = ak.c(this.f28019d.ap());
        }
        StringBuilder sb = new StringBuilder();
        sb.append("!isViewVisibility()=");
        sb.append(!b());
        sb.append(",isAutoPlay()=");
        sb.append(a());
        sb.append(",!isCoverPageVisibility()=");
        sb.append(!c());
        u.b("ClickCreativeListener", sb.toString());
        if (this.F == 5 && f() && a() && !b() && !c()) {
            return false;
        }
        int i = this.F;
        return i == 1 || i == 2 || i == 5;
    }

    private void i() {
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
        if (this.D && (aVar = this.n) != null && (aVar instanceof com.bytedance.sdk.openadsdk.downloadnew.a.d)) {
            ((com.bytedance.sdk.openadsdk.downloadnew.a.d) aVar).f(true);
        }
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.E = drawVideoListener;
    }

    public void b(boolean z) {
        this.f28017b = z;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private String b(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1695837674:
                if (str.equals("banner_ad")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case -712491894:
                if (str.equals("embeded_ad")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 174971131:
                if (str.equals("splash_ad")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1844104722:
                if (str.equals("interaction")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1912999166:
                if (str.equals("draw_ad")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 2091589896:
                if (str.equals("slide_banner_ad")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        return (c2 == 0 || c2 == 1) ? "feed_call" : (c2 == 2 || c2 == 3) ? "banner_call" : c2 != 4 ? c2 != 5 ? "" : "splash_ad" : "interaction_call";
    }

    public void a(boolean z) {
        this.f28016a = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.a.b, com.bytedance.sdk.openadsdk.core.a.c
    public void a(View view, int i, int i2, int i3, int i4) {
        TTDrawFeedAd.DrawVideoListener drawVideoListener;
        if (a(2)) {
            return;
        }
        if (h() && c(view) && !this.D) {
            u.b("ClickCreativeListener", "拦截原生视频view走普通点击事件.....");
            super.a(view, i, i2, i3, i4);
            return;
        }
        i();
        u.b("ClickCreativeListener", "走创意区域点击事件.....");
        if (this.f28018c == null) {
            this.f28018c = p.a();
        }
        if (this.f28018c == null) {
            return;
        }
        long j = this.w;
        long j2 = this.x;
        WeakReference<View> weakReference = this.f28022g;
        View view2 = weakReference == null ? null : weakReference.get();
        WeakReference<View> weakReference2 = this.f28023h;
        this.i = a(i, i2, i3, i4, j, j2, view2, weakReference2 == null ? null : weakReference2.get());
        int Z = this.f28019d.Z();
        if (Z == 2 || Z == 3) {
            if (this.k != null || this.f28017b) {
                com.bytedance.sdk.openadsdk.c.d.a(this.f28018c, "click_button", this.f28019d, this.i, this.f28020e, true, this.o);
            }
            z.a(true);
            Context context = this.f28018c;
            l lVar = this.f28019d;
            int i5 = this.f28021f;
            boolean a2 = z.a(context, lVar, i5, this.k, this.p, ak.a(i5), this.n, true, this.o, this.r, a(this.f28020e));
            if (this.f28016a) {
                com.bytedance.sdk.openadsdk.c.d.a(this.f28018c, PrefetchEvent.STATE_CLICK, this.f28019d, this.i, this.f28020e, a2, this.o);
            }
        } else if (Z != 4) {
            if (Z != 5) {
                Z = -1;
            } else {
                String b2 = b(this.f28020e);
                if (!TextUtils.isEmpty(b2)) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.f28018c, "click_call", this.f28019d, this.i, b2, true, this.o);
                }
                com.bytedance.sdk.openadsdk.c.d.a(this.f28018c, PrefetchEvent.STATE_CLICK, this.f28019d, this.i, this.f28020e, ak.d(view.getContext(), this.f28019d.ag()), this.o);
            }
        } else if ((this.k != null || this.p != null) && !"feed_video_middle_page".equals(this.f28020e) && this.f28019d.C() && !TextUtils.isEmpty(n.a(this.f28019d))) {
            Context context2 = this.f28018c;
            l lVar2 = this.f28019d;
            int i6 = this.f28021f;
            TTNativeAd tTNativeAd = this.k;
            TTNativeExpressAd tTNativeExpressAd = this.p;
            String str = this.f28020e;
            boolean a3 = z.a(context2, lVar2, i6, tTNativeAd, tTNativeExpressAd, str, this.n, true, this.o, this.r, a(str));
            if (this.f28016a) {
                com.bytedance.sdk.openadsdk.c.d.a(this.f28018c, PrefetchEvent.STATE_CLICK, this.f28019d, this.i, this.f28020e, a3, this.o);
            }
        } else {
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = this.n;
            if (aVar != null) {
                aVar.g();
                if (this.f28016a) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.f28018c, PrefetchEvent.STATE_CLICK, this.f28019d, this.i, this.f28020e, true, this.o);
                }
            }
        }
        b.a aVar2 = this.j;
        if (aVar2 != null) {
            aVar2.a(view, Z);
        }
        if (!ak.b(this.f28019d) || (drawVideoListener = this.E) == null) {
            return;
        }
        drawVideoListener.onClick();
    }

    public void c(boolean z) {
        this.D = z;
    }

    private boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.equals("feed_video_middle_page");
    }

    public boolean a() {
        l lVar = this.f28019d;
        if (lVar == null) {
            return true;
        }
        int c2 = p.h().c(ak.d(lVar.ap()));
        if (c2 != 1) {
            return c2 != 2 ? c2 != 3 : x.e(this.f28018c) || x.d(this.f28018c);
        }
        return x.d(this.f28018c);
    }
}
