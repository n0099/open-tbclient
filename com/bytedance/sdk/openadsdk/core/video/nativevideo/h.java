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
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.d.v;
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
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class h implements b, com.bytedance.sdk.openadsdk.core.video.renderview.a, g.a, h.b, am.a {
    public com.bytedance.sdk.openadsdk.core.widget.h A;
    public d B;
    public boolean C;
    public com.bytedance.sdk.openadsdk.downloadnew.core.a D;
    public c E;
    public com.bytedance.sdk.openadsdk.core.a.a F;
    public com.bytedance.sdk.openadsdk.core.a.a G;
    public TTDrawFeedAd.DrawVideoListener H;
    public boolean I;
    public View J;
    public TextView K;
    public TextView L;
    public NativeVideoTsView.b M;
    public final String N;

    /* renamed from: a  reason: collision with root package name */
    public View f28671a;

    /* renamed from: b  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.renderview.b f28672b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f28673c;

    /* renamed from: d  reason: collision with root package name */
    public View f28674d;

    /* renamed from: e  reason: collision with root package name */
    public View f28675e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f28676f;

    /* renamed from: g  reason: collision with root package name */
    public ViewStub f28677g;

    /* renamed from: h  reason: collision with root package name */
    public View f28678h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f28679i;
    public View j;
    public RoundImageView k;
    public TextView l;
    public TextView m;
    public TextView n;
    public ProgressBar o;
    public ViewStub p;
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;
    public boolean v;
    public int w;
    public EnumSet<b.a> x;
    public l y;
    public Context z;

    public h(Context context, View view, boolean z, EnumSet<b.a> enumSet, l lVar, c cVar, boolean z2) {
        this.u = true;
        this.C = true;
        this.I = true;
        this.N = Build.MODEL;
        if (this instanceof g) {
            return;
        }
        this.z = p.a().getApplicationContext();
        c(z2);
        this.f28671a = view;
        this.u = z;
        this.x = enumSet == null ? EnumSet.noneOf(b.a.class) : enumSet;
        this.E = cVar;
        this.y = lVar;
        c(8);
        a(context, this.f28671a);
        a();
        n();
    }

    private boolean A() {
        return "C8817D".equals(this.N) || "M5".equals(this.N) || "R7t".equals(this.N);
    }

    private void b(View view, Context context) {
        ViewStub viewStub;
        if (view == null || context == null || (viewStub = this.p) == null || viewStub.getParent() == null || this.J != null) {
            return;
        }
        this.p.inflate();
        this.J = view.findViewById(ad.e(context, "tt_video_ad_cover_center_layout_draw"));
        this.K = (TextView) view.findViewById(ad.e(context, "tt_video_ad_button_draw"));
        this.L = (TextView) view.findViewById(ad.e(context, "tt_video_ad_replay"));
    }

    private int e(int i2) {
        if (this.s <= 0 || this.t <= 0) {
            return 0;
        }
        int dimensionPixelSize = this.z.getResources().getDimensionPixelSize(ad.h(this.z, "tt_video_container_maxheight"));
        int dimensionPixelSize2 = this.z.getResources().getDimensionPixelSize(ad.h(this.z, "tt_video_container_minheight"));
        int i3 = (int) (this.t * ((i2 * 1.0f) / this.s));
        return i3 > dimensionPixelSize ? dimensionPixelSize : i3 < dimensionPixelSize2 ? dimensionPixelSize2 : i3;
    }

    private void f(int i2) {
        al.a(this.j, i2);
        al.a(this.J, i2);
    }

    private boolean y() {
        l lVar = this.y;
        return lVar != null && lVar.S() == null && this.y.k() == 1 && l.c(this.y);
    }

    private void z() {
        if (this.z == null || this.f28671a == null) {
            return;
        }
        View view = new View(this.z) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.4

            /* renamed from: b  reason: collision with root package name */
            public final AtomicBoolean f28684b = new AtomicBoolean(true);

            private void a() {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
                if (!this.f28684b.getAndSet(false) || (aVar = h.this.D) == null) {
                    return;
                }
                aVar.a();
            }

            private void b() {
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar;
                if (this.f28684b.getAndSet(true) || (aVar = h.this.D) == null) {
                    return;
                }
                aVar.d();
            }

            @Override // android.view.View
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                a();
            }

            @Override // android.view.View
            public void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                b();
            }

            @Override // android.view.View
            public void onFinishTemporaryDetach() {
                super.onFinishTemporaryDetach();
                a();
            }

            @Override // android.view.View
            public void onMeasure(int i2, int i3) {
                super.onMeasure(0, 0);
            }

            @Override // android.view.View
            public void onStartTemporaryDetach() {
                super.onStartTemporaryDetach();
                b();
            }

            @Override // android.view.View
            public void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                com.bytedance.sdk.openadsdk.downloadnew.core.a aVar = h.this.D;
                if (aVar != null) {
                    if (z) {
                        aVar.b();
                    } else {
                        aVar.c();
                    }
                }
            }
        };
        View view2 = this.f28671a;
        if (view2 instanceof ViewGroup) {
            ((ViewGroup) view2).addView(view, 0, new RelativeLayout.LayoutParams(0, 0));
        }
    }

    public void a(long j) {
    }

    public void a(long j, long j2) {
    }

    public void a(Message message) {
    }

    public void a(View view, boolean z) {
    }

    public void a(@Nullable ViewGroup viewGroup) {
    }

    public void a(String str) {
    }

    public void a(boolean z) {
    }

    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public void b(@Nullable ViewGroup viewGroup) {
    }

    public void b(boolean z) {
    }

    public boolean b(int i2) {
        return false;
    }

    public void c() {
    }

    public void c(boolean z) {
        this.C = z;
        if (z) {
            com.bytedance.sdk.openadsdk.core.a.a aVar = this.F;
            if (aVar != null) {
                aVar.a(true);
            }
            com.bytedance.sdk.openadsdk.core.a.a aVar2 = this.G;
            if (aVar2 != null) {
                aVar2.a(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.a.a aVar3 = this.F;
        if (aVar3 != null) {
            aVar3.a(false);
            this.F.c(true);
        }
        com.bytedance.sdk.openadsdk.core.a.a aVar4 = this.G;
        if (aVar4 != null) {
            aVar4.a(false);
            this.G.c(true);
        }
    }

    public void d(int i2) {
        al.a(this.f28671a, 0);
        com.bytedance.sdk.openadsdk.core.video.renderview.b bVar = this.f28672b;
        if (bVar != null) {
            bVar.setVisibility(i2);
        }
    }

    public void g() {
        ProgressBar progressBar = this.o;
        if (progressBar != null) {
            progressBar.setProgress(0);
            this.o.setSecondaryProgress(0);
        }
        c(8);
        if (x()) {
            this.f28672b.setVisibility(8);
        }
        ImageView imageView = this.f28676f;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        c(8);
        al.a(this.f28678h, 8);
        al.a((View) this.f28679i, 8);
        al.a(this.j, 8);
        al.a((View) this.k, 8);
        al.a((View) this.l, 8);
        al.a((View) this.m, 8);
        com.bytedance.sdk.openadsdk.core.widget.h hVar = this.A;
        if (hVar != null) {
            hVar.a(true);
        }
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return this.u;
    }

    public void j() {
        a(true, false);
    }

    public boolean k() {
        return this.v;
    }

    public void l() {
    }

    public boolean m() {
        com.bytedance.sdk.openadsdk.core.widget.h hVar = this.A;
        return hVar != null && hVar.a();
    }

    public void n() {
        String str;
        int i2;
        com.bytedance.sdk.openadsdk.core.a.a aVar;
        String str2 = this.C ? "embeded_ad" : "embeded_ad_landingpage";
        if (ak.b(this.y)) {
            str = this.C ? "draw_ad" : "draw_ad_landingpage";
            i2 = 6;
        } else if (ak.e(this.y)) {
            str = "rewarded_video";
            i2 = 7;
        } else if (ak.f(this.y)) {
            str = "fullscreen_interstitial_ad";
            i2 = 5;
        } else {
            str = str2;
            i2 = 1;
        }
        if (this.y.Z() == 4) {
            com.bytedance.sdk.openadsdk.downloadnew.core.a a2 = com.bytedance.sdk.openadsdk.downloadnew.a.a(this.z, this.y, str);
            this.D = a2;
            a2.a(2, new a.InterfaceC0308a() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.1
                @Override // com.bytedance.sdk.openadsdk.downloadnew.core.a.InterfaceC0308a
                public boolean a(int i3, l lVar, String str3, String str4, Object obj) {
                    if (i3 == 2 && lVar != null && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                        if (str4.equals("click_start_play")) {
                            String str5 = h.this.C ? "click_start" : "click_start_detail";
                            h hVar = h.this;
                            com.bytedance.sdk.openadsdk.c.d.a(hVar.z, hVar.y, str3, str5, (JSONObject) null);
                            return true;
                        } else if (str4.equals("click_open")) {
                            h hVar2 = h.this;
                            if (hVar2.C) {
                                Context context = hVar2.z;
                                l lVar2 = hVar2.y;
                                com.bytedance.sdk.openadsdk.c.d.j(context, lVar2, str3, ak.h(lVar2), null);
                            } else {
                                com.bytedance.sdk.openadsdk.c.d.i(hVar2.z, hVar2.y, str3, "click_open_detail", null);
                            }
                        }
                    }
                    return true;
                }
            });
        }
        z();
        com.bytedance.sdk.openadsdk.core.a.a aVar2 = new com.bytedance.sdk.openadsdk.core.a.a(this.z, this.y, str, i2);
        this.F = aVar2;
        aVar2.d(true);
        this.F.b(true);
        if (this.C) {
            this.F.a(true);
        } else {
            this.F.a(false);
            this.F.c(true);
        }
        this.F.a(this.E);
        this.F.e(true);
        com.bytedance.sdk.openadsdk.downloadnew.core.a aVar3 = this.D;
        if (aVar3 != null && (aVar = this.F) != null) {
            aVar.a(aVar3);
        }
        if (y()) {
            com.bytedance.sdk.openadsdk.core.a.a aVar4 = new com.bytedance.sdk.openadsdk.core.a.a(this.z, this.y, str, i2) { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.2
                @Override // com.bytedance.sdk.openadsdk.core.a.a
                public boolean b() {
                    com.bytedance.sdk.openadsdk.core.widget.h hVar = h.this.A;
                    boolean a3 = hVar != null ? hVar.a() : false;
                    StringBuilder sb = new StringBuilder();
                    sb.append("isVisible=");
                    sb.append(a3);
                    sb.append(",mPlayBtn.getVisibility() == VISIBLE->");
                    sb.append(h.this.f28673c.getVisibility() == 0);
                    u.c("ClickCreativeListener", sb.toString());
                    return a3 || h.this.f28673c.getVisibility() == 0;
                }

                @Override // com.bytedance.sdk.openadsdk.core.a.a
                public boolean c() {
                    View view;
                    RoundImageView roundImageView;
                    TextView textView;
                    View view2 = h.this.f28678h;
                    return (view2 != null && view2.getVisibility() == 0) || ((view = h.this.j) != null && view.getVisibility() == 0) || (((roundImageView = h.this.k) != null && roundImageView.getVisibility() == 0) || ((textView = h.this.l) != null && textView.getVisibility() == 0));
                }
            };
            this.G = aVar4;
            aVar4.d(true);
            this.G.a(new b.a() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.3
                @Override // com.bytedance.sdk.openadsdk.core.a.b.a
                public void a(View view, int i3) {
                    if (h.this.M != null) {
                        h.this.M.a(view, i3);
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
            com.bytedance.sdk.openadsdk.downloadnew.core.a aVar5 = this.D;
            if (aVar5 != null) {
                this.G.a(aVar5);
            }
            View view = this.f28671a;
            if (view != null) {
                view.setOnClickListener(this.G);
                this.f28671a.setOnTouchListener(this.G);
            }
        }
    }

    public com.bytedance.sdk.openadsdk.core.video.renderview.b o() {
        return this.f28672b;
    }

    public void p() {
        if (this.B == null || this.A != null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.bytedance.sdk.openadsdk.core.widget.h hVar = new com.bytedance.sdk.openadsdk.core.widget.h();
        this.A = hVar;
        hVar.a(this.z, this.f28671a);
        this.A.a(this.B, this);
        u.b("useTime", "mVideoTrafficTipLayout use time :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void q() {
        com.bytedance.sdk.openadsdk.core.widget.h hVar = this.A;
        if (hVar != null) {
            hVar.a(false);
        }
    }

    public boolean r() {
        if (this.B == null) {
            u.f("NewLiveViewLayout", "callback is null");
            return false;
        }
        return true;
    }

    public View s() {
        return this.f28671a;
    }

    public void t() {
        al.g(this.f28674d);
        al.g(this.f28675e);
        ImageView imageView = this.f28673c;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        al.a((View) this.f28673c, 8);
    }

    @RequiresApi(api = 14)
    @TargetApi(14)
    public void u() {
        al.a(this.f28671a, 0);
        com.bytedance.sdk.openadsdk.core.video.renderview.b bVar = this.f28672b;
        if (bVar != null) {
            View view = bVar.getView();
            if (view instanceof TextureView) {
                ViewParent parent = view.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    int indexOfChild = viewGroup.indexOfChild(view);
                    viewGroup.removeView(view);
                    viewGroup.addView(view, indexOfChild);
                }
            }
            al.a(view, 8);
            al.a(view, 0);
        }
    }

    public void v() {
        al.a(this.f28678h, 8);
        al.a((View) this.f28679i, 8);
        al.a(this.j, 8);
        al.a((View) this.k, 8);
        al.a((View) this.l, 8);
        al.a((View) this.m, 8);
        al.a((View) this.n, 8);
    }

    public void w() {
        al.f(this.f28674d);
        al.f(this.f28675e);
        ImageView imageView = this.f28676f;
        if (imageView != null) {
            al.f(imageView);
        }
    }

    public boolean x() {
        return !this.x.contains(b.a.alwayShowMediaView) || this.u;
    }

    public void a(NativeVideoTsView.b bVar) {
        this.M = bVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v36, types: [com.bytedance.sdk.openadsdk.core.video.renderview.SSRenderTextureView] */
    public void a(Context context, View view) {
        SSRenderSurfaceView sSRenderSurfaceView;
        long currentTimeMillis = System.currentTimeMillis();
        String a2 = ak.a(context);
        if (a2 == null) {
            a2 = "0";
        }
        boolean z = Build.VERSION.SDK_INT != 20 || Integer.valueOf(a2).intValue() >= 1572864;
        if (!A() && z && i.d().t() && Build.VERSION.SDK_INT >= 14) {
            ?? sSRenderTextureView = new SSRenderTextureView(this.z);
            u.b("NewLiveViewLayout", "use TextureView......");
            sSRenderSurfaceView = sSRenderTextureView;
        } else {
            SSRenderSurfaceView sSRenderSurfaceView2 = new SSRenderSurfaceView(this.z);
            u.b("NewLiveViewLayout", "use SurfaceView......");
            sSRenderSurfaceView = sSRenderSurfaceView2;
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(sSRenderSurfaceView, 0, layoutParams);
            view.setBackgroundColor(-16777216);
        }
        al.a((View) sSRenderSurfaceView, 8);
        this.f28672b = sSRenderSurfaceView;
        this.f28673c = (ImageView) view.findViewById(ad.e(context, "tt_video_play"));
        this.o = (ProgressBar) view.findViewById(ad.e(context, "tt_video_progress"));
        this.f28674d = view.findViewById(ad.e(context, "tt_video_loading_retry_layout"));
        this.f28675e = view.findViewById(ad.e(context, "tt_video_loading_progress"));
        this.f28676f = (ImageView) view.findViewById(ad.e(context, "tt_video_loading_cover_image"));
        this.f28677g = (ViewStub) view.findViewById(ad.e(context, "tt_video_ad_cover"));
        this.p = (ViewStub) view.findViewById(ad.e(context, "tt_video_draw_layout_viewStub"));
        u.b("useTime", "NativeVideoLayout**findViews use time :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void f() {
        al.f(this.f28674d);
    }

    public void d() {
        l lVar;
        al.g(this.f28674d);
        al.g(this.f28675e);
        if (this.f28676f != null && (lVar = this.y) != null && lVar.X() != null && this.y.X().h() != null) {
            al.g(this.f28676f);
            com.bytedance.sdk.openadsdk.i.e.c().a(this.y.X().h(), this.f28676f);
        }
        ImageView imageView = this.f28673c;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        al.a((View) this.f28673c, 8);
    }

    public void e() {
        a(false, this.u);
        v();
    }

    public void b(boolean z, boolean z2) {
        ImageView imageView = this.f28673c;
        if (imageView != null) {
            if (z) {
                imageView.setImageResource(ad.d(this.z, "tt_play_movebar_textpage"));
            } else {
                imageView.setImageResource(ad.d(this.z, "tt_stop_movebar_textpage"));
            }
        }
    }

    public void b(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = this.f28671a.getLayoutParams();
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.width = i2;
        }
        if (i3 == -1 || i3 == -2 || i3 > 0) {
            layoutParams.height = i3;
        }
        this.f28671a.setLayoutParams(layoutParams);
    }

    public void c(int i2, int i3) {
        this.s = i2;
        this.t = i3;
    }

    public void d(boolean z) {
        this.I = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.f28672b.getHolder()) {
            return;
        }
        this.v = false;
        if (r()) {
            this.B.b(this, surfaceHolder);
        }
    }

    public void c(@Nullable ViewGroup viewGroup) {
        if (viewGroup == null) {
            return;
        }
        if (this.f28671a.getParent() != null) {
            ((ViewGroup) this.f28671a.getParent()).removeView(this.f28671a);
        }
        viewGroup.addView(this.f28671a);
        c(0);
    }

    public h(Context context, View view, boolean z, EnumSet<b.a> enumSet, l lVar, c cVar) {
        this(context, view, z, enumSet, lVar, cVar, true);
    }

    public void c(int i2) {
        this.w = i2;
        al.a(this.f28671a, i2);
    }

    public void a(View view, Context context) {
        ViewStub viewStub;
        if (view == null || context == null || (viewStub = this.f28677g) == null || viewStub.getParent() == null || this.f28678h != null) {
            return;
        }
        this.f28678h = this.f28677g.inflate();
        this.f28679i = (ImageView) view.findViewById(ad.e(context, "tt_video_ad_finish_cover_image"));
        this.j = view.findViewById(ad.e(context, "tt_video_ad_cover_center_layout"));
        this.k = (RoundImageView) view.findViewById(ad.e(context, "tt_video_ad_logo_image"));
        this.l = (TextView) view.findViewById(ad.e(context, "tt_video_btn_ad_image_tv"));
        this.m = (TextView) view.findViewById(ad.e(context, "tt_video_ad_name"));
        this.n = (TextView) view.findViewById(ad.e(context, "tt_video_ad_button"));
    }

    public boolean a(int i2, v vVar, boolean z) {
        com.bytedance.sdk.openadsdk.core.widget.h hVar = this.A;
        return hVar == null || hVar.a(i2, vVar, z);
    }

    public void a(a aVar) {
        if (aVar instanceof d) {
            this.B = (d) aVar;
            p();
        }
    }

    public void a() {
        this.f28672b.a(this);
        ImageView imageView = this.f28673c;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (h.this.r()) {
                        TextView textView = h.this.n;
                        if (textView == null || textView.getVisibility() != 0) {
                            h hVar = h.this;
                            hVar.B.a(hVar, view);
                        }
                    }
                }
            });
        }
    }

    public void a(int i2, int i3) {
        if (i2 == -1) {
            i2 = al.c(this.z);
        }
        if (i2 <= 0) {
            return;
        }
        this.q = i2;
        if (!i() && !h() && !this.x.contains(b.a.fixedSize)) {
            this.r = e(i2);
        } else {
            this.r = i3;
        }
        b(this.q, this.r);
    }

    public void a(int i2) {
        u.c("Progress", "setSeekProgress-percent=" + i2);
        al.a((View) this.o, 0);
        ProgressBar progressBar = this.o;
        if (progressBar != null) {
            progressBar.setProgress(i2);
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public void a(l lVar, WeakReference<Context> weakReference, boolean z) {
        l lVar2;
        String ak;
        l lVar3;
        l lVar4;
        if (lVar == null) {
            return;
        }
        a(false, this.u);
        a(this.f28671a, p.a());
        View view = this.f28678h;
        if (view != null) {
            al.a(view, 0);
        }
        ImageView imageView = this.f28679i;
        if (imageView != null) {
            al.a((View) imageView, 0);
        }
        if (ak.b(this.y)) {
            b(this.f28671a, p.a());
            al.a(this.j, 8);
            al.a((View) this.f28679i, 0);
            al.a(this.J, 0);
            al.a((View) this.K, 0);
            al.a((View) this.L, 0);
            if (this.L != null && x.c(p.a()) == 0) {
                al.a((View) this.L, 8);
            }
            View view2 = this.f28678h;
            if (view2 != null) {
                view2.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.6
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view3) {
                        c cVar = h.this.E;
                        if (cVar != null) {
                            ((a) cVar).g();
                            TTDrawFeedAd.DrawVideoListener drawVideoListener = h.this.H;
                            if (drawVideoListener != null) {
                                drawVideoListener.onClickRetry();
                            }
                        }
                    }
                });
            }
            if (this.f28679i != null && (lVar4 = this.y) != null && lVar4.X() != null && this.y.X().h() != null) {
                com.bytedance.sdk.openadsdk.core.video.e.b.a((long) this.y.X().e(), this.y.X().i(), new b.InterfaceC0302b() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.h.7
                    @Override // com.bytedance.sdk.openadsdk.core.video.e.b.InterfaceC0302b
                    public void a(Bitmap bitmap) {
                        if (bitmap != null) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) h.this.f28679i.getLayoutParams();
                            if (bitmap.getWidth() > bitmap.getHeight()) {
                                layoutParams.width = al.c(p.a());
                                layoutParams.height = (bitmap.getHeight() * al.c(p.a())) / bitmap.getWidth();
                                layoutParams.addRule(13);
                                h.this.f28679i.setLayoutParams(layoutParams);
                            }
                            h.this.f28679i.setImageBitmap(bitmap);
                            return;
                        }
                        com.bytedance.sdk.openadsdk.i.e.c().a(h.this.y.X().h(), h.this.f28679i);
                    }
                });
            }
        } else {
            al.a(this.j, 0);
            if (this.f28679i != null && (lVar2 = this.y) != null && lVar2.X() != null && this.y.X().h() != null) {
                com.bytedance.sdk.openadsdk.i.e.c().a(this.y.X().h(), this.f28679i);
            }
        }
        if (!TextUtils.isEmpty(lVar.Y())) {
            ak = lVar.Y();
        } else if (!TextUtils.isEmpty(lVar.aj())) {
            ak = lVar.aj();
        } else {
            ak = !TextUtils.isEmpty(lVar.ak()) ? lVar.ak() : "";
        }
        if (this.k != null && (lVar3 = this.y) != null && lVar3.aa() != null && this.y.aa().a() != null) {
            al.a((View) this.k, 0);
            al.a((View) this.l, 4);
            com.bytedance.sdk.openadsdk.i.e.c().a(this.y.aa().a(), this.k);
            if (y()) {
                this.k.setOnClickListener(this.G);
                this.k.setOnTouchListener(this.G);
            } else {
                this.k.setOnClickListener(this.F);
                this.k.setOnTouchListener(this.F);
            }
        } else if (!TextUtils.isEmpty(ak)) {
            al.a((View) this.k, 4);
            al.a((View) this.l, 0);
            TextView textView = this.l;
            if (textView != null) {
                textView.setText(ak.substring(0, 1));
                if (y()) {
                    this.l.setOnClickListener(this.G);
                    this.l.setOnTouchListener(this.G);
                } else {
                    this.l.setOnClickListener(this.F);
                    this.l.setOnTouchListener(this.F);
                }
            }
        }
        if (this.m != null && !TextUtils.isEmpty(ak)) {
            this.m.setText(ak);
        }
        al.a((View) this.m, 0);
        al.a((View) this.n, 0);
        String al = lVar.al();
        if (TextUtils.isEmpty(al)) {
            int Z = lVar.Z();
            if (Z == 4) {
                al = ad.a(this.z, "tt_video_download_apk");
            } else if (Z != 5) {
                al = ad.a(this.z, "tt_video_mobile_go_detail");
            } else {
                al = ad.a(this.z, "tt_video_dial_phone");
            }
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setText(al);
            this.n.setOnClickListener(this.F);
            this.n.setOnTouchListener(this.F);
        }
        TextView textView3 = this.K;
        if (textView3 != null) {
            textView3.setText(al);
            this.K.setOnClickListener(this.F);
            this.K.setOnTouchListener(this.F);
        }
        if (this.I) {
            return;
        }
        f(4);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder != this.f28672b.getHolder()) {
            return;
        }
        this.v = true;
        if (r()) {
            this.B.a(this, surfaceHolder);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (surfaceHolder == this.f28672b.getHolder() && r()) {
            this.B.a(this, surfaceHolder, i2, i3, i4);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.renderview.a
    public void a(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.v = true;
        if (r()) {
            this.B.a(this, surfaceTexture);
        }
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

    public void a(boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        al.a((View) this.o, 0);
        al.a((View) this.f28673c, (!z || this.f28674d.getVisibility() == 0) ? 8 : 8);
    }

    public void a(boolean z, boolean z2) {
        al.a((View) this.o, z ? 0 : 8);
        al.a((View) this.f28673c, 8);
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        this.H = drawVideoListener;
        com.bytedance.sdk.openadsdk.core.a.a aVar = this.F;
        if (aVar != null) {
            aVar.a(drawVideoListener);
        }
    }
}
