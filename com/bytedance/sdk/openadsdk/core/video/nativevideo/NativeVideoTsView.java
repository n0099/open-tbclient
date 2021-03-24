package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.i;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.f;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class NativeVideoTsView extends FrameLayout implements c.a, f.a, am.a {
    public ViewStub A;
    public c.b B;
    public final AtomicBoolean C;
    public boolean D;
    public boolean E;
    public AtomicBoolean F;

    /* renamed from: a  reason: collision with root package name */
    public final Context f28703a;

    /* renamed from: b  reason: collision with root package name */
    public final l f28704b;

    /* renamed from: c  reason: collision with root package name */
    public c f28705c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f28706d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28707e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f28708f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f28709g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f28710h;
    public ImageView i;
    public boolean j;
    public String k;
    public int l;
    public AtomicBoolean m;
    public boolean n;
    public a o;
    public ViewGroup p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;
    public boolean v;
    public long w;
    public final am x;
    public boolean y;
    public final String z;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, long j, long j2, long j3, boolean z2);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(View view, int i);
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar) {
        this(context, lVar, false, false);
    }

    private void c(boolean z) {
        if (this.f28704b == null || this.f28705c == null) {
            return;
        }
        boolean q = q();
        r();
        if (q && this.f28705c.w()) {
            u.b("NativeVideoAdView", "changeVideoStatus---isFromDetailPage()=" + q + "，mNativeVideoController.isPlayComplete()=" + this.f28705c.w());
            b(true);
            d();
        } else if (z && !this.f28705c.w() && !this.f28705c.t()) {
            if (this.f28705c.u() != null && this.f28705c.u().i()) {
                if (this.q) {
                    if ("ALP-AL00".equals(this.z)) {
                        this.f28705c.k();
                    } else {
                        ((f) this.f28705c).g(q);
                    }
                    c.b bVar = this.B;
                    if (bVar != null) {
                        bVar.c();
                    }
                }
            } else if (this.q && this.f28705c.u() == null) {
                if (!this.C.get()) {
                    this.C.set(true);
                }
                this.F.set(false);
                m();
            }
        } else if (this.f28705c.u() == null || !this.f28705c.u().g()) {
        } else {
            this.f28705c.h();
            c.b bVar2 = this.B;
            if (bVar2 != null) {
                bVar2.e_();
            }
        }
    }

    private void d() {
        a(0L, 0);
        this.B = null;
    }

    private void e() {
        addView(a(this.f28703a));
        k();
    }

    private void f() {
        if (!(this instanceof NativeDrawVideoTsView) || this.m.get() || i.d().u() == null) {
            return;
        }
        this.i.setImageBitmap(i.d().u());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
        int a2 = (int) al.a(getContext(), this.l);
        layoutParams.width = a2;
        layoutParams.height = a2;
        this.i.setLayoutParams(layoutParams);
        this.m.set(true);
    }

    private void k() {
        this.f28705c = new f(this.f28703a, this.f28706d, this.f28704b, this.k, !v(), this.s, this.t);
        l();
        this.p.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                ((f) nativeVideoTsView.f28705c).a(nativeVideoTsView.p.getWidth(), NativeVideoTsView.this.p.getHeight());
                NativeVideoTsView.this.p.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    private void l() {
        c cVar = this.f28705c;
        if (cVar == null) {
            return;
        }
        cVar.e(this.q);
        ((f) this.f28705c).a((f.a) this);
        this.f28705c.a(this);
    }

    private void m() {
        c cVar = this.f28705c;
        if (cVar == null) {
            k();
        } else if ((cVar instanceof f) && !v()) {
            ((f) this.f28705c).f();
        }
        if (this.f28705c == null || !this.C.get()) {
            return;
        }
        this.C.set(false);
        b();
        if (i()) {
            al.a((View) this.f28708f, 8);
            ImageView imageView = this.f28710h;
            if (imageView != null) {
                al.a((View) imageView, 8);
            }
            l lVar = this.f28704b;
            if (lVar != null && lVar.X() != null) {
                this.f28705c.a(this.f28704b.X().i(), this.f28704b.am(), this.p.getWidth(), this.p.getHeight(), null, this.f28704b.ap(), 0L, u());
                this.f28705c.d(false);
                return;
            }
            u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        } else if (this.f28705c.w()) {
            u.b("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.f28705c.w());
            b(true);
        } else {
            u.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
            h();
            al.a((View) this.f28708f, 0);
        }
    }

    private void n() {
        this.o = null;
        j();
        o();
    }

    private void o() {
        if (!this.C.get()) {
            this.C.set(true);
            c cVar = this.f28705c;
            if (cVar != null) {
                cVar.a(true);
            }
        }
        this.F.set(false);
    }

    private void p() {
        c(y.a(this, 50, 5));
        this.x.sendEmptyMessageDelayed(1, 500L);
    }

    private boolean q() {
        if (v()) {
            return false;
        }
        return com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
    }

    private void r() {
        if (v()) {
            return;
        }
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", Boolean.FALSE);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", Boolean.FALSE);
    }

    private void s() {
        if (this.f28705c == null || v() || !com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false)) {
            return;
        }
        boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
        long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", -1L);
        long a4 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.f28705c.p());
        long a5 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", this.f28705c.s());
        this.f28705c.d(a2);
        if (a2) {
            this.f28705c.a(a5);
        } else {
            this.f28705c.a(a3);
        }
        this.f28705c.b(a4);
        this.f28705c.c(a5);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.FALSE);
        u.f("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + a2 + ",position=" + a3 + ",totalPlayDuration=" + a4 + ",duration=" + a5);
    }

    private boolean t() {
        return 2 == p.h().c(ak.d(this.f28704b.ap()));
    }

    private boolean u() {
        return this.f28707e;
    }

    private boolean v() {
        return this.r;
    }

    private void w() {
        al.f(this.f28710h);
        al.f(this.f28708f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a() {
    }

    public void b() {
        l lVar = this.f28704b;
        if (lVar == null) {
            return;
        }
        int d2 = ak.d(lVar.ap());
        int c2 = p.h().c(d2);
        if (c2 == 1) {
            this.q = x.d(this.f28703a);
        } else if (c2 == 2) {
            this.q = x.e(this.f28703a) || x.d(this.f28703a);
        } else if (c2 == 3) {
            this.q = false;
        } else if (c2 == 4) {
            this.n = true;
        }
        if (!this.r) {
            this.f28707e = p.h().a(d2);
        } else {
            this.f28707e = false;
        }
        if ("splash_ad".equals(this.k)) {
            this.q = true;
            this.f28707e = true;
        }
        c cVar = this.f28705c;
        if (cVar != null) {
            cVar.e(this.q);
        }
        if ("feed_video_middle_page".equals(this.k)) {
            this.q = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void b(long j, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void g() {
        c.b bVar = this.B;
        if (bVar == null || this.E) {
            return;
        }
        this.E = true;
        bVar.d_();
    }

    public c getNativeVideoController() {
        return this.f28705c;
    }

    public void h() {
        ViewStub viewStub;
        if (this.f28703a == null || (viewStub = this.A) == null || viewStub.getParent() == null || this.f28704b == null || this.f28708f != null) {
            return;
        }
        this.f28708f = (RelativeLayout) this.A.inflate();
        this.f28709g = (ImageView) findViewById(ad.e(this.f28703a, "tt_native_video_img_id"));
        ImageView imageView = (ImageView) findViewById(ad.e(this.f28703a, "tt_native_video_play"));
        this.i = imageView;
        if (this.j) {
            al.a((View) imageView, 0);
        }
        if (this.f28704b.X() != null && this.f28704b.X().h() != null) {
            com.bytedance.sdk.openadsdk.i.e.c().a(this.f28704b.X().h(), this.f28709g);
        }
        f();
    }

    public boolean i() {
        return this.q;
    }

    public void j() {
        h v;
        c cVar = this.f28705c;
        if (cVar == null || (v = cVar.v()) == null) {
            return;
        }
        v.e();
        View s = v.s();
        if (s != null) {
            s.setVisibility(8);
            if (s.getParent() != null) {
                ((ViewGroup) s.getParent()).removeView(s);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        a aVar;
        c cVar;
        if (!this.r && (aVar = this.o) != null && (cVar = this.f28705c) != null) {
            aVar.a(cVar.w(), this.f28705c.s(), this.f28705c.p(), this.f28705c.n(), this.q);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        n();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        c cVar;
        c cVar2;
        c cVar3;
        c cVar4;
        super.onWindowFocusChanged(z);
        s();
        if (q() && (cVar4 = this.f28705c) != null && cVar4.w()) {
            r();
            al.a((View) this.f28708f, 8);
            b(true);
            d();
            return;
        }
        b();
        if (!v() && i() && (cVar2 = this.f28705c) != null && !cVar2.t()) {
            if (this.x != null) {
                if (z && (cVar3 = this.f28705c) != null && !cVar3.w()) {
                    this.x.obtainMessage(1).sendToTarget();
                    return;
                }
                this.x.removeMessages(1);
                c(false);
            }
        } else if (i()) {
        } else {
            if (!z && (cVar = this.f28705c) != null && cVar.u() != null && this.f28705c.u().g()) {
                this.x.removeMessages(1);
                c(false);
            } else if (z) {
                this.x.obtainMessage(1).sendToTarget();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        c cVar;
        l lVar;
        c cVar2;
        c cVar3;
        super.onWindowVisibilityChanged(i);
        s();
        if (this.D) {
            this.D = i == 0;
        }
        if (q() && (cVar3 = this.f28705c) != null && cVar3.w()) {
            r();
            al.a((View) this.f28708f, 8);
            b(true);
            d();
            return;
        }
        b();
        if (v() || !i() || (cVar = this.f28705c) == null || cVar.t() || (lVar = this.f28704b) == null) {
            return;
        }
        if (this.v && lVar.X() != null) {
            this.f28705c.a(this.f28704b.X().i(), this.f28704b.am(), this.p.getWidth(), this.p.getHeight(), null, this.f28704b.ap(), this.w, u());
            this.v = false;
            al.a((View) this.f28708f, 8);
        } else {
            u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        if (i != 0 || this.x == null || (cVar2 = this.f28705c) == null || cVar2.w()) {
            return;
        }
        this.x.obtainMessage(1).sendToTarget();
    }

    public void setControllerStatusCallBack(a aVar) {
        this.o = aVar;
    }

    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        c cVar = this.f28705c;
        if (cVar != null) {
            ((f) cVar).a(drawVideoListener);
        }
    }

    public void setIsAutoPlay(boolean z) {
        l lVar;
        if (this.y || (lVar = this.f28704b) == null) {
            return;
        }
        int c2 = p.h().c(ak.d(lVar.ap()));
        if (z && c2 != 4 && (!x.e(this.f28703a) ? !x.d(this.f28703a) : !t())) {
            z = false;
        }
        this.q = z;
        c cVar = this.f28705c;
        if (cVar != null) {
            cVar.e(z);
        }
        if (!this.q) {
            h();
            RelativeLayout relativeLayout = this.f28708f;
            if (relativeLayout != null) {
                al.a((View) relativeLayout, 0);
                if (this.f28704b.X() != null) {
                    com.bytedance.sdk.openadsdk.i.e.c().a(this.f28704b.X().h(), this.f28709g);
                } else {
                    u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        } else {
            al.a((View) this.f28708f, 8);
        }
        this.y = true;
    }

    public void setIsQuiet(boolean z) {
        this.f28707e = z;
        c cVar = this.f28705c;
        if (cVar != null) {
            cVar.c(z);
        }
    }

    public void setNativeVideoAdListener(c.a aVar) {
        c cVar = this.f28705c;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    public void setNativeVideoController(c cVar) {
        this.f28705c = cVar;
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        this.j = z;
    }

    public void setVideoAdClickListener(b bVar) {
        c cVar = this.f28705c;
        if (cVar != null) {
            ((f) cVar).a(bVar);
        }
    }

    public void setVideoAdInteractionListener(c.b bVar) {
        this.B = bVar;
    }

    public void setVideoAdLoadListener(c.InterfaceC0312c interfaceC0312c) {
        c cVar = this.f28705c;
        if (cVar != null) {
            cVar.a(interfaceC0312c);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            o();
        }
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar, boolean z, boolean z2) {
        this(context, lVar, z, z2, "embeded_ad", false, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j, int i) {
        c.b bVar = this.B;
        if (bVar != null) {
            bVar.d();
        }
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar, String str, boolean z, boolean z2) {
        this(context, lVar, false, false, str, z, z2);
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar, boolean z, boolean z2, String str, boolean z3, boolean z4) {
        super(context);
        this.q = true;
        this.f28707e = true;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = false;
        this.j = true;
        this.k = "embeded_ad";
        this.l = 50;
        this.v = true;
        this.m = new AtomicBoolean(false);
        this.x = new am(this);
        this.y = false;
        this.z = Build.MODEL;
        this.n = false;
        this.C = new AtomicBoolean(false);
        this.D = true;
        this.F = new AtomicBoolean(false);
        this.k = str;
        this.f28703a = context;
        this.f28704b = lVar;
        this.r = z;
        this.u = z2;
        this.s = z3;
        this.t = z4;
        setContentDescription("NativeVideoAdView");
        b();
        e();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j, long j2) {
        c.b bVar = this.B;
        if (bVar != null) {
            bVar.a(j, j2);
        }
    }

    private View a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(ad.e(this.f28703a, "tt_native_video_layout"));
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.p = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(ad.e(this.f28703a, "tt_native_video_frame"));
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.f28706d = frameLayout2;
        ViewStub viewStub = new ViewStub(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        viewStub.setId(ad.e(this.f28703a, "tt_native_video_img_cover_viewStub"));
        viewStub.setLayoutResource(ad.f(this.f28703a, "tt_native_video_img_cover_layout"));
        viewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(viewStub);
        this.A = viewStub;
        return frameLayout;
    }

    public void b(int i) {
        if (x.c(p.a()) == 0) {
            return;
        }
        if (this.f28705c.u() != null) {
            if (this.f28705c.u().g() && i == 2) {
                c(false);
                am amVar = this.x;
                if (amVar != null) {
                    amVar.removeMessages(1);
                }
                a(true);
                return;
            } else if (this.f28705c.u().i() && i == 3) {
                this.q = true;
                c(true);
                b();
                am amVar2 = this.x;
                if (amVar2 != null) {
                    amVar2.sendEmptyMessageDelayed(1, 500L);
                }
                a(false);
                return;
            }
        }
        if (i() || this.F.get()) {
            return;
        }
        this.F.set(true);
        l lVar = this.f28704b;
        if (lVar != null && lVar.X() != null) {
            w();
            this.f28705c.a(this.f28704b.X().i(), this.f28704b.am(), this.p.getWidth(), this.p.getHeight(), null, this.f28704b.ap(), this.w, u());
        } else {
            u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        am amVar3 = this.x;
        if (amVar3 != null) {
            amVar3.sendEmptyMessageDelayed(1, 500L);
        }
        a(false);
    }

    public boolean a(long j, boolean z, boolean z2) {
        long j2;
        int i;
        this.p.setVisibility(0);
        if (this.f28705c == null) {
            this.f28705c = new f(this.f28703a, this.f28706d, this.f28704b, this.k, this.s, this.t);
            l();
        }
        this.w = j;
        if (v()) {
            this.f28705c.b(false);
            l lVar = this.f28704b;
            boolean a2 = (lVar == null || lVar.X() == null) ? false : this.f28705c.a(this.f28704b.X().i(), this.f28704b.am(), this.p.getWidth(), this.p.getHeight(), null, this.f28704b.ap(), j, u());
            if ((j > 0 && !z && !z2) || (j > 0 && z && !this.u)) {
                c cVar = this.f28705c;
                if (cVar != null) {
                    j2 = cVar.p();
                    i = this.f28705c.r();
                } else {
                    j2 = 0;
                    i = 0;
                }
                com.bytedance.sdk.openadsdk.c.d.a(this.f28703a, this.f28704b, this.k, "feed_continue", j2, i, ak.a(this.f28704b, this.f28705c.o(), this.f28705c.u()));
            }
            return a2;
        }
        return true;
    }

    public void c() {
        if (x.c(p.a()) == 0) {
            return;
        }
        if (this.f28705c.u() != null) {
            if (this.f28705c.u().g()) {
                c(false);
                am amVar = this.x;
                if (amVar != null) {
                    amVar.removeMessages(1);
                }
                a(true);
                return;
            } else if (this.f28705c.u().i()) {
                this.q = true;
                c(true);
                b();
                am amVar2 = this.x;
                if (amVar2 != null) {
                    amVar2.sendEmptyMessageDelayed(1, 500L);
                }
                a(false);
                return;
            }
        }
        if (i() || this.F.get()) {
            return;
        }
        this.F.set(true);
        l lVar = this.f28704b;
        if (lVar != null && lVar.X() != null) {
            w();
            this.f28705c.a(this.f28704b.X().i(), this.f28704b.am(), this.p.getWidth(), this.p.getHeight(), null, this.f28704b.ap(), this.w, u());
        } else {
            u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        am amVar3 = this.x;
        if (amVar3 != null) {
            amVar3.sendEmptyMessageDelayed(1, 500L);
        }
        a(false);
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (message.what != 1) {
            return;
        }
        p();
    }

    public void b(boolean z) {
        c cVar = this.f28705c;
        if (cVar != null) {
            cVar.d(z);
            h v = this.f28705c.v();
            if (v != null) {
                v.w();
                View s = v.s();
                if (s != null) {
                    if (s.getParent() != null) {
                        ((ViewGroup) s.getParent()).removeView(s);
                    }
                    s.setVisibility(0);
                    addView(s);
                    v.a(this.f28704b, new WeakReference<>(this.f28703a), false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void a(int i) {
        b();
    }

    public void a(boolean z) {
        if (this.f28710h == null) {
            this.f28710h = new ImageView(getContext());
            if (i.d().u() != null) {
                this.f28710h.setImageBitmap(i.d().u());
            } else {
                this.f28710h.setImageResource(ad.d(p.a(), "tt_new_play_video"));
            }
            this.f28710h.setScaleType(ImageView.ScaleType.FIT_XY);
            int a2 = (int) al.a(getContext(), this.l);
            int a3 = (int) al.a(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = a3;
            layoutParams.bottomMargin = a3;
            this.p.addView(this.f28710h, layoutParams);
        }
        if (z) {
            this.f28710h.setVisibility(0);
        } else {
            this.f28710h.setVisibility(8);
        }
    }
}
