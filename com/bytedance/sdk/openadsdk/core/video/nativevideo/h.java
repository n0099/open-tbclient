package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.t;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.e.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderSurfaceView;
import com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderTextureView;
import com.bytedance.sdk.openadsdk.core.widget.RoundImageView;
import com.bytedance.sdk.openadsdk.core.widget.g;
import com.bytedance.sdk.openadsdk.core.widget.h;
import com.bytedance.sdk.openadsdk.downloadnew.core.a;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h implements b, com.bytedance.sdk.openadsdk.core.video.renderview.a, g.a, h.b, al.a {
    com.bytedance.sdk.openadsdk.core.widget.h A;
    d B;
    boolean C;
    com.bytedance.sdk.openadsdk.downloadnew.core.a D;
    c E;
    com.bytedance.sdk.openadsdk.core.a.a F;
    com.bytedance.sdk.openadsdk.core.a.a G;
    TTDrawFeedAd.DrawVideoListener H;
    boolean I;
    private View J;
    private TextView K;
    private TextView L;
    private NativeVideoTsView.b M;
    private final String N;

    /* renamed from: a  reason: collision with root package name */
    View f4568a;
    com.bytedance.sdk.openadsdk.core.video.renderview.b b;
    ImageView c;
    View d;
    View e;
    ImageView f;
    ViewStub g;
    View h;
    ImageView i;
    View j;
    RoundImageView k;
    TextView l;
    TextView m;
    TextView n;
    ProgressBar o;
    ViewStub p;
    int q;
    int r;
    int s;
    int t;
    boolean u;
    boolean v;
    int w;
    EnumSet<b.a> x;
    l y;
    Context z;

    public h(Context context, View view, boolean z, EnumSet<b.a> enumSet, l lVar, c cVar, boolean z2) {
        this.u = true;
        this.C = true;
        this.I = true;
        this.N = Build.MODEL;
        if (!(this instanceof g)) {
            this.z = p.a().getApplicationContext();
            c(z2);
            this.f4568a = view;
            this.u = z;
            this.x = enumSet == null ? EnumSet.noneOf(b.a.class) : enumSet;
            this.E = cVar;
            this.y = lVar;
            c(8);
            a(context, this.f4568a);
            a();
            n();
        }
    }

    public h(Context context, View view, boolean z, EnumSet<b.a> enumSet, l lVar, c cVar) {
        this(context, view, z, enumSet, lVar, cVar, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        String str;
        int i;
        String str2 = this.C ? "embeded_ad" : "embeded_ad_landingpage";
        if (aj.b(this.y)) {
            i = 6;
            str = this.C ? "draw_ad" : "draw_ad_landingpage";
        } else if (aj.e(this.y)) {
            i = 7;
            str = "rewarded_video";
        } else if (aj.f(this.y)) {
            i = 5;
            str = "fullscreen_interstitial_ad";
        } else {
            str = str2;
            i = 1;
        }
        if (this.y.T() == 4) {
            this.D = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.z, this.y, str);
            this.D.a(2, new a.InterfaceC1029a() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.1
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a.InterfaceC1029a
                public boolean a(int i2, l lVar, String str3, String str4, Object obj) {
                    if (i2 == 2 && lVar != null && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        if (str4.equals("click_start_play")) {
                            com.bytedance.sdk.openadsdk.c.d.a(h.this.z, h.this.y, str3, h.this.C ? "click_start" : "click_start_detail", (JSONObject) null);
                        } else if (str4.equals("click_open")) {
                            if (h.this.C) {
                                com.bytedance.sdk.openadsdk.c.d.j(h.this.z, h.this.y, str3, aj.h(h.this.y), null);
                            } else {
                                com.bytedance.sdk.openadsdk.c.d.i(h.this.z, h.this.y, str3, "click_open_detail", null);
                            }
                        }
                    }
                    return true;
                }
            });
        }
        z();
        this.F = new com.bytedance.sdk.openadsdk.core.a.a(this.z, this.y, str, i);
        this.F.d(true);
        this.F.b(true);
        if (this.C) {
            this.F.a(true);
        } else {
            this.F.a(false);
            this.F.c(true);
        }
        this.F.a(this.E);
        this.F.e(true);
        if (this.D != null && this.F != null) {
            this.F.a(this.D);
        }
        if (y()) {
            this.G = new com.bytedance.sdk.openadsdk.core.a.a(this.z, this.y, str, i) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.2
                @Override // com.bytedance.sdk.openadsdk.core.a.a
                public boolean b() {
                    boolean a2 = h.this.A != null ? h.this.A.a() : false;
                    u.c("ClickCreativeListener", "isVisible=" + a2 + ",mPlayBtn.getVisibility() == VISIBLE->" + (h.this.c.getVisibility() == 0));
                    return a2 || h.this.c.getVisibility() == 0;
                }

                @Override // com.bytedance.sdk.openadsdk.core.a.a
                public boolean c() {
                    return (h.this.h != null && h.this.h.getVisibility() == 0) || (h.this.j != null && h.this.j.getVisibility() == 0) || ((h.this.k != null && h.this.k.getVisibility() == 0) || (h.this.l != null && h.this.l.getVisibility() == 0));
                }
            };
            this.G.d(true);
            this.G.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.3
                @Override // com.bytedance.sdk.openadsdk.core.a.b.a
                public void a(View view, int i2) {
                    if (h.this.M != null) {
                        h.this.M.a(view, i2);
                    }
                }
            });
            this.G.b(true);
            if (this.C) {
                this.G.a(true);
            } else {
                this.G.a(false);
            }
            this.G.a(this.E);
            this.G.e(true);
            if (this.D != null) {
                this.G.a(this.D);
            }
            if (this.f4568a != null) {
                this.f4568a.setOnClickListener(this.G);
                this.f4568a.setOnTouchListener(this.G);
            }
        }
    }

    private boolean y() {
        return this.y != null && this.y.M() == null && this.y.k() == 1 && l.c(this.y);
    }

    public void a(NativeVideoTsView.b bVar) {
        this.M = bVar;
    }

    private void z() {
        if (this.z != null && this.f4568a != null) {
            View view = new View(this.z) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.4
                private final AtomicBoolean b = new AtomicBoolean(true);

                @Override // android.view.View
                protected void onMeasure(int i, int i2) {
                    super.onMeasure(0, 0);
                }

                @Override // android.view.View
                public void onWindowFocusChanged(boolean z) {
                    super.onWindowFocusChanged(z);
                    if (h.this.D != null) {
                        if (z) {
                            h.this.D.b();
                        } else {
                            h.this.D.c();
                        }
                    }
                }

                @Override // android.view.View
                protected void onAttachedToWindow() {
                    super.onAttachedToWindow();
                    a();
                }

                @Override // android.view.View
                public void onFinishTemporaryDetach() {
                    super.onFinishTemporaryDetach();
                    a();
                }

                private void a() {
                    if (this.b.getAndSet(false) && h.this.D != null) {
                        h.this.D.a();
                    }
                }

                private void b() {
                    if (!this.b.getAndSet(true) && h.this.D != null) {
                        h.this.D.d();
                    }
                }

                @Override // android.view.View
                protected void onDetachedFromWindow() {
                    super.onDetachedFromWindow();
                    b();
                }

                @Override // android.view.View
                public void onStartTemporaryDetach() {
                    super.onStartTemporaryDetach();
                    b();
                }
            };
            if (this.f4568a instanceof ViewGroup) {
                ((ViewGroup) this.f4568a).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.video.renderview.b o() {
        return this.b;
    }

    private boolean A() {
        return "C8817D".equals(this.N) || "M5".equals(this.N) || "R7t".equals(this.N);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Context context, View view) {
        View sSRenderSurfaceView;
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = aj.a(context);
        if (a2 == null) {
            a2 = "0";
        }
        boolean z = Build.VERSION.SDK_INT != 20 || Integer.valueOf(a2).intValue() >= 1572864;
        if (!A() && z && i.d().s() && Build.VERSION.SDK_INT >= 14) {
            sSRenderSurfaceView = new SSRenderTextureView(this.z);
            u.b("NewLiveViewLayout", "use TextureView......");
        } else {
            sSRenderSurfaceView = new SSRenderSurfaceView(this.z);
            u.b("NewLiveViewLayout", "use SurfaceView......");
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(sSRenderSurfaceView, 0, layoutParams);
            view.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        }
        ak.a(sSRenderSurfaceView, 8);
        this.b = (com.bytedance.sdk.openadsdk.core.video.renderview.b) sSRenderSurfaceView;
        this.c = (ImageView) view.findViewById(ac.e(context, "tt_video_play"));
        this.o = (ProgressBar) view.findViewById(ac.e(context, "tt_video_progress"));
        this.d = view.findViewById(ac.e(context, "tt_video_loading_retry_layout"));
        this.e = view.findViewById(ac.e(context, "tt_video_loading_progress"));
        this.f = (ImageView) view.findViewById(ac.e(context, "tt_video_loading_cover_image"));
        this.g = (ViewStub) view.findViewById(ac.e(context, "tt_video_ad_cover"));
        this.p = (ViewStub) view.findViewById(ac.e(context, "tt_video_draw_layout_viewStub"));
        u.b("useTime", "NativeVideoLayout**findViews use time :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, Context context) {
        if (view != null && context != null && this.g != null && this.g.getParent() != null && this.h == null) {
            this.h = this.g.inflate();
            this.i = (ImageView) view.findViewById(ac.e(context, "tt_video_ad_finish_cover_image"));
            this.j = view.findViewById(ac.e(context, "tt_video_ad_cover_center_layout"));
            this.k = (RoundImageView) view.findViewById(ac.e(context, "tt_video_ad_logo_image"));
            this.l = (TextView) view.findViewById(ac.e(context, "tt_video_btn_ad_image_tv"));
            this.m = (TextView) view.findViewById(ac.e(context, "tt_video_ad_name"));
            this.n = (TextView) view.findViewById(ac.e(context, "tt_video_ad_button"));
        }
    }

    private void b(View view, Context context) {
        if (view != null && context != null && this.p != null && this.p.getParent() != null && this.J == null) {
            this.p.inflate();
            this.J = view.findViewById(ac.e(context, "tt_video_ad_cover_center_layout_draw"));
            this.K = (TextView) view.findViewById(ac.e(context, "tt_video_ad_button_draw"));
            this.L = (TextView) view.findViewById(ac.e(context, "tt_video_ad_replay"));
        }
    }

    void p() {
        if (this.B != null && this.A == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.A = new com.bytedance.sdk.openadsdk.core.widget.h();
            this.A.a(this.z, this.f4568a);
            this.A.a(this.B, this);
            u.b("useTime", "mVideoTrafficTipLayout use time :" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean a(int i, t tVar, boolean z) {
        return this.A == null || this.A.a(i, tVar, z);
    }

    public void q() {
        if (this.A != null) {
            this.A.a(false);
        }
    }

    public void a(a aVar) {
        if (aVar instanceof d) {
            this.B = (d) aVar;
            p();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        if (this.B == null) {
            u.f("NewLiveViewLayout", "callback is null");
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.b.a(this);
        if (this.c != null) {
            this.c.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.r()) {
                        if (h.this.n == null || h.this.n.getVisibility() != 0) {
                            h.this.B.a(h.this, view);
                        }
                    }
                }
            });
        }
    }

    public void d(int i) {
        ak.a(this.f4568a, 0);
        if (this.b != null) {
            this.b.setVisibility(i);
        }
    }

    public void c(boolean z) {
        this.C = z;
        if (this.C) {
            if (this.F != null) {
                this.F.a(true);
            }
            if (this.G != null) {
                this.G.a(true);
                return;
            }
            return;
        }
        if (this.F != null) {
            this.F.a(false);
            this.F.c(true);
        }
        if (this.G != null) {
            this.G.a(false);
            this.G.c(true);
        }
    }

    public void b() {
    }

    public void c() {
    }

    public void a(boolean z) {
    }

    public void a(int i, int i2) {
        if (i == -1) {
            i = ak.c(this.z);
        }
        if (i > 0) {
            this.q = i;
            if (i() || h() || this.x.contains(b.a.fixedSize)) {
                this.r = i2;
            } else {
                this.r = e(i);
            }
            b(this.q, this.r);
        }
    }

    public void b(boolean z, boolean z2) {
        if (this.c != null) {
            if (z) {
                this.c.setImageResource(ac.d(this.z, "tt_play_movebar_textpage"));
            } else {
                this.c.setImageResource(ac.d(this.z, "tt_stop_movebar_textpage"));
            }
        }
    }

    public void a(String str) {
    }

    public void b(int i, int i2) {
        ViewGroup.LayoutParams layoutParams = this.f4568a.getLayoutParams();
        if (i == -1 || i == -2 || i > 0) {
            layoutParams.width = i;
        }
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.height = i2;
        }
        this.f4568a.setLayoutParams(layoutParams);
    }

    private int e(int i) {
        if (this.s <= 0 || this.t <= 0) {
            return 0;
        }
        int dimensionPixelSize = this.z.getResources().getDimensionPixelSize(ac.h(this.z, "tt_video_container_maxheight"));
        int dimensionPixelSize2 = this.z.getResources().getDimensionPixelSize(ac.h(this.z, "tt_video_container_minheight"));
        int i2 = (int) (((i * 1.0f) / this.s) * this.t);
        if (i2 <= dimensionPixelSize) {
            return i2 < dimensionPixelSize2 ? dimensionPixelSize2 : i2;
        }
        return dimensionPixelSize;
    }

    public void c(int i, int i2) {
        this.s = i;
        this.t = i2;
    }

    public void a(int i) {
        u.c("Progress", "setSeekProgress-percent=" + i);
        ak.a((View) this.o, 0);
        if (this.o != null) {
            this.o.setProgress(i);
        }
    }

    public void a(long j, long j2) {
    }

    public void c(@Nullable ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.f4568a.getParent() != null) {
                ((ViewGroup) this.f4568a.getParent()).removeView(this.f4568a);
            }
            viewGroup.addView(this.f4568a);
            c(0);
        }
    }

    public View s() {
        return this.f4568a;
    }

    public void d() {
        ak.g(this.d);
        ak.g(this.e);
        if (this.f != null && this.y != null && this.y.R() != null && this.y.R().h() != null) {
            ak.g(this.f);
            com.bytedance.sdk.openadsdk.h.d.a(this.z).a(this.y.R().h(), this.f);
        }
        if (this.c != null && this.c.getVisibility() == 0) {
            ak.a((View) this.c, 8);
        }
    }

    public void t() {
        ak.g(this.d);
        ak.g(this.e);
        if (this.c != null && this.c.getVisibility() == 0) {
            ak.a((View) this.c, 8);
        }
    }

    public void e() {
        a(false, this.u);
        v();
    }

    public void a(long j) {
    }

    @RequiresApi(api = 14)
    @TargetApi(14)
    public void u() {
        ak.a(this.f4568a, 0);
        if (this.b != null) {
            View view = this.b.getView();
            if (view instanceof TextureView) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    viewGroup.removeView(view);
                    viewGroup.addView(view, indexOfChild);
                }
            }
            ak.a(view, 8);
            ak.a(view, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        ak.a(this.h, 8);
        ak.a((View) this.i, 8);
        ak.a(this.j, 8);
        ak.a((View) this.k, 8);
        ak.a((View) this.l, 8);
        ak.a((View) this.m, 8);
        ak.a((View) this.n, 8);
    }

    private void f(int i) {
        ak.a(this.j, i);
        ak.a(this.J, i);
    }

    public void d(boolean z) {
        this.I = z;
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(l lVar, WeakReference<Context> weakReference, boolean z) {
        String a2;
        if (lVar != null) {
            a(false, this.u);
            a(this.f4568a, p.a());
            if (this.h != null) {
                ak.a(this.h, 0);
            }
            if (this.i != null) {
                ak.a((View) this.i, 0);
            }
            if (aj.b(this.y)) {
                b(this.f4568a, p.a());
                ak.a(this.j, 8);
                ak.a((View) this.i, 0);
                ak.a(this.J, 0);
                ak.a((View) this.K, 0);
                ak.a((View) this.L, 0);
                if (this.L != null && x.c(p.a()) == 0) {
                    ak.a((View) this.L, 8);
                }
                if (this.h != null) {
                    this.h.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.6
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (h.this.E != null) {
                                ((a) h.this.E).g();
                                if (h.this.H != null) {
                                    h.this.H.onClickRetry();
                                }
                            }
                        }
                    });
                }
                if (this.i != null && this.y != null && this.y.R() != null && this.y.R().h() != null) {
                    com.bytedance.sdk.openadsdk.core.video.e.b.a((long) this.y.R().e(), this.y.R().i(), new b.InterfaceC1023b() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.7
                        @Override // com.bytedance.sdk.openadsdk.core.video.e.b.InterfaceC1023b
                        public void a(Bitmap bitmap) {
                            if (bitmap != null) {
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) h.this.i.getLayoutParams();
                                if (bitmap.getWidth() > bitmap.getHeight()) {
                                    layoutParams.width = ak.c(p.a());
                                    layoutParams.height = (bitmap.getHeight() * ak.c(p.a())) / bitmap.getWidth();
                                    layoutParams.addRule(13);
                                    h.this.i.setLayoutParams(layoutParams);
                                }
                                h.this.i.setImageBitmap(bitmap);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.h.d.a(h.this.z).a(h.this.y.R().h(), h.this.i);
                        }
                    });
                }
            } else {
                ak.a(this.j, 0);
                if (this.i != null && this.y != null && this.y.R() != null && this.y.R().h() != null) {
                    com.bytedance.sdk.openadsdk.h.d.a(this.z).a(this.y.R().h(), this.i);
                }
            }
            String str = "";
            if (!TextUtils.isEmpty(lVar.S())) {
                str = lVar.S();
            } else if (!TextUtils.isEmpty(lVar.ad())) {
                str = lVar.ad();
            } else if (!TextUtils.isEmpty(lVar.ae())) {
                str = lVar.ae();
            }
            if (this.k != null && this.y != null && this.y.U() != null && this.y.U().a() != null) {
                ak.a((View) this.k, 0);
                ak.a((View) this.l, 4);
                com.bytedance.sdk.openadsdk.h.d.a(this.z).a(this.y.U().a(), this.k);
                if (y()) {
                    this.k.setOnClickListener(this.G);
                    this.k.setOnTouchListener(this.G);
                } else {
                    this.k.setOnClickListener(this.F);
                    this.k.setOnTouchListener(this.F);
                }
            } else if (!TextUtils.isEmpty(str)) {
                ak.a((View) this.k, 4);
                ak.a((View) this.l, 0);
                if (this.l != null) {
                    this.l.setText(str.substring(0, 1));
                    if (y()) {
                        this.l.setOnClickListener(this.G);
                        this.l.setOnTouchListener(this.G);
                    } else {
                        this.l.setOnClickListener(this.F);
                        this.l.setOnTouchListener(this.F);
                    }
                }
            }
            if (this.m != null && !TextUtils.isEmpty(str)) {
                this.m.setText(str);
            }
            ak.a((View) this.m, 0);
            ak.a((View) this.n, 0);
            switch (lVar.T()) {
                case 2:
                case 3:
                    a2 = ac.a(this.z, "tt_video_mobile_go_detail");
                    break;
                case 4:
                    a2 = ac.a(this.z, "tt_video_download_apk");
                    break;
                case 5:
                    a2 = ac.a(this.z, "tt_video_dial_phone");
                    break;
                default:
                    a2 = ac.a(this.z, "tt_video_mobile_go_detail");
                    break;
            }
            if (this.n != null) {
                this.n.setText(a2);
                this.n.setOnClickListener(this.F);
                this.n.setOnTouchListener(this.F);
            }
            if (this.K != null) {
                this.K.setText(a2);
                this.K.setOnClickListener(this.F);
                this.K.setOnTouchListener(this.F);
            }
            if (!this.I) {
                f(4);
            }
        }
    }

    public void w() {
        ak.f(this.d);
        ak.f(this.e);
        if (this.f != null) {
            ak.f(this.f);
        }
    }

    public void f() {
        ak.f(this.d);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.b.getHolder()) {
            this.v = true;
            if (r()) {
                this.B.a(this, surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        if (surfaceHolder == this.b.getHolder() && r()) {
            this.B.a(this, surfaceHolder, i, i2, i3);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.b.getHolder()) {
            this.v = false;
            if (r()) {
                this.B.b(this, surfaceHolder);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceTexture surfaceTexture, int i, int i2) {
        this.v = true;
        if (r()) {
            this.B.a(this, surfaceTexture);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public boolean a(SurfaceTexture surfaceTexture) {
        this.v = false;
        if (r()) {
            this.B.b(this, surfaceTexture);
            return true;
        }
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture) {
    }

    public void g() {
        if (this.o != null) {
            this.o.setProgress(0);
            this.o.setSecondaryProgress(0);
        }
        c(8);
        if (x()) {
            this.b.setVisibility(8);
        }
        if (this.f != null) {
            this.f.setImageDrawable(null);
        }
        c(8);
        ak.a(this.h, 8);
        ak.a((View) this.i, 8);
        ak.a(this.j, 8);
        ak.a((View) this.k, 8);
        ak.a((View) this.l, 8);
        ak.a((View) this.m, 8);
        if (this.A != null) {
            this.A.a(true);
        }
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return this.u;
    }

    public void a(@Nullable ViewGroup viewGroup) {
    }

    public void b(@Nullable ViewGroup viewGroup) {
    }

    public void a(Message message) {
    }

    public void a(boolean z, boolean z2, boolean z3) {
        int i = 0;
        ak.a((View) this.o, 0);
        ak.a((View) this.c, (!z || this.d.getVisibility() == 0) ? 8 : 8);
    }

    public void a(boolean z, boolean z2) {
        ak.a((View) this.o, z ? 0 : 8);
        ak.a((View) this.c, 8);
    }

    public void j() {
        a(true, false);
    }

    public boolean b(int i) {
        return false;
    }

    public void b(boolean z) {
    }

    public boolean k() {
        return this.v;
    }

    public void c(int i) {
        this.w = i;
        ak.a(this.f4568a, i);
    }

    public void a(View view, boolean z) {
    }

    public void l() {
    }

    public boolean m() {
        return this.A != null && this.A.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean x() {
        return !this.x.contains(b.a.alwayShowMediaView) || this.u;
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.H = drawVideoListener;
        if (this.F != null) {
            this.F.a(drawVideoListener);
        }
    }
}
