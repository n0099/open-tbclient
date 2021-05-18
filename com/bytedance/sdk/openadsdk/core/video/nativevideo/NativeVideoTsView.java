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
    public final Context f28513a;

    /* renamed from: b  reason: collision with root package name */
    public final l f28514b;

    /* renamed from: c  reason: collision with root package name */
    public c f28515c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f28516d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28517e;

    /* renamed from: f  reason: collision with root package name */
    public RelativeLayout f28518f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f28519g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f28520h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f28521i;
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
        void a(View view, int i2);
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar) {
        this(context, lVar, false, false);
    }

    private void c(boolean z) {
        if (this.f28514b == null || this.f28515c == null) {
            return;
        }
        boolean q = q();
        r();
        if (q && this.f28515c.w()) {
            u.b("NativeVideoAdView", "changeVideoStatus---isFromDetailPage()=" + q + "，mNativeVideoController.isPlayComplete()=" + this.f28515c.w());
            b(true);
            d();
        } else if (z && !this.f28515c.w() && !this.f28515c.t()) {
            if (this.f28515c.u() != null && this.f28515c.u().i()) {
                if (this.q) {
                    if ("ALP-AL00".equals(this.z)) {
                        this.f28515c.k();
                    } else {
                        ((f) this.f28515c).g(q);
                    }
                    c.b bVar = this.B;
                    if (bVar != null) {
                        bVar.c();
                    }
                }
            } else if (this.q && this.f28515c.u() == null) {
                if (!this.C.get()) {
                    this.C.set(true);
                }
                this.F.set(false);
                m();
            }
        } else if (this.f28515c.u() == null || !this.f28515c.u().g()) {
        } else {
            this.f28515c.h();
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
        addView(a(this.f28513a));
        k();
    }

    private void f() {
        if (!(this instanceof NativeDrawVideoTsView) || this.m.get() || i.d().u() == null) {
            return;
        }
        this.f28521i.setImageBitmap(i.d().u());
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f28521i.getLayoutParams();
        int a2 = (int) al.a(getContext(), this.l);
        layoutParams.width = a2;
        layoutParams.height = a2;
        this.f28521i.setLayoutParams(layoutParams);
        this.m.set(true);
    }

    private void k() {
        this.f28515c = new f(this.f28513a, this.f28516d, this.f28514b, this.k, !v(), this.s, this.t);
        l();
        this.p.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                ((f) nativeVideoTsView.f28515c).a(nativeVideoTsView.p.getWidth(), NativeVideoTsView.this.p.getHeight());
                NativeVideoTsView.this.p.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    private void l() {
        c cVar = this.f28515c;
        if (cVar == null) {
            return;
        }
        cVar.e(this.q);
        ((f) this.f28515c).a((f.a) this);
        this.f28515c.a(this);
    }

    private void m() {
        c cVar = this.f28515c;
        if (cVar == null) {
            k();
        } else if ((cVar instanceof f) && !v()) {
            ((f) this.f28515c).f();
        }
        if (this.f28515c == null || !this.C.get()) {
            return;
        }
        this.C.set(false);
        b();
        if (i()) {
            al.a((View) this.f28518f, 8);
            ImageView imageView = this.f28520h;
            if (imageView != null) {
                al.a((View) imageView, 8);
            }
            l lVar = this.f28514b;
            if (lVar != null && lVar.X() != null) {
                this.f28515c.a(this.f28514b.X().i(), this.f28514b.am(), this.p.getWidth(), this.p.getHeight(), null, this.f28514b.ap(), 0L, u());
                this.f28515c.d(false);
                return;
            }
            u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        } else if (this.f28515c.w()) {
            u.b("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.f28515c.w());
            b(true);
        } else {
            u.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
            h();
            al.a((View) this.f28518f, 0);
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
            c cVar = this.f28515c;
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
        if (this.f28515c == null || v() || !com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false)) {
            return;
        }
        boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
        long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", -1L);
        long a4 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.f28515c.p());
        long a5 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", this.f28515c.s());
        this.f28515c.d(a2);
        if (a2) {
            this.f28515c.a(a5);
        } else {
            this.f28515c.a(a3);
        }
        this.f28515c.b(a4);
        this.f28515c.c(a5);
        com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", Boolean.FALSE);
        u.f("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + a2 + ",position=" + a3 + ",totalPlayDuration=" + a4 + ",duration=" + a5);
    }

    private boolean t() {
        return 2 == p.h().c(ak.d(this.f28514b.ap()));
    }

    private boolean u() {
        return this.f28517e;
    }

    private boolean v() {
        return this.r;
    }

    private void w() {
        al.f(this.f28520h);
        al.f(this.f28518f);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a() {
    }

    public void b() {
        l lVar = this.f28514b;
        if (lVar == null) {
            return;
        }
        int d2 = ak.d(lVar.ap());
        int c2 = p.h().c(d2);
        if (c2 == 1) {
            this.q = x.d(this.f28513a);
        } else if (c2 == 2) {
            this.q = x.e(this.f28513a) || x.d(this.f28513a);
        } else if (c2 == 3) {
            this.q = false;
        } else if (c2 == 4) {
            this.n = true;
        }
        if (!this.r) {
            this.f28517e = p.h().a(d2);
        } else {
            this.f28517e = false;
        }
        if ("splash_ad".equals(this.k)) {
            this.q = true;
            this.f28517e = true;
        }
        c cVar = this.f28515c;
        if (cVar != null) {
            cVar.e(this.q);
        }
        if ("feed_video_middle_page".equals(this.k)) {
            this.q = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void b(long j, int i2) {
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
        return this.f28515c;
    }

    public void h() {
        ViewStub viewStub;
        if (this.f28513a == null || (viewStub = this.A) == null || viewStub.getParent() == null || this.f28514b == null || this.f28518f != null) {
            return;
        }
        this.f28518f = (RelativeLayout) this.A.inflate();
        this.f28519g = (ImageView) findViewById(ad.e(this.f28513a, "tt_native_video_img_id"));
        ImageView imageView = (ImageView) findViewById(ad.e(this.f28513a, "tt_native_video_play"));
        this.f28521i = imageView;
        if (this.j) {
            al.a((View) imageView, 0);
        }
        if (this.f28514b.X() != null && this.f28514b.X().h() != null) {
            com.bytedance.sdk.openadsdk.i.e.c().a(this.f28514b.X().h(), this.f28519g);
        }
        f();
    }

    public boolean i() {
        return this.q;
    }

    public void j() {
        h v;
        c cVar = this.f28515c;
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
        if (!this.r && (aVar = this.o) != null && (cVar = this.f28515c) != null) {
            aVar.a(cVar.w(), this.f28515c.s(), this.f28515c.p(), this.f28515c.n(), this.q);
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
        if (q() && (cVar4 = this.f28515c) != null && cVar4.w()) {
            r();
            al.a((View) this.f28518f, 8);
            b(true);
            d();
            return;
        }
        b();
        if (!v() && i() && (cVar2 = this.f28515c) != null && !cVar2.t()) {
            if (this.x != null) {
                if (z && (cVar3 = this.f28515c) != null && !cVar3.w()) {
                    this.x.obtainMessage(1).sendToTarget();
                    return;
                }
                this.x.removeMessages(1);
                c(false);
            }
        } else if (i()) {
        } else {
            if (!z && (cVar = this.f28515c) != null && cVar.u() != null && this.f28515c.u().g()) {
                this.x.removeMessages(1);
                c(false);
            } else if (z) {
                this.x.obtainMessage(1).sendToTarget();
            }
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i2) {
        c cVar;
        l lVar;
        c cVar2;
        c cVar3;
        super.onWindowVisibilityChanged(i2);
        s();
        if (this.D) {
            this.D = i2 == 0;
        }
        if (q() && (cVar3 = this.f28515c) != null && cVar3.w()) {
            r();
            al.a((View) this.f28518f, 8);
            b(true);
            d();
            return;
        }
        b();
        if (v() || !i() || (cVar = this.f28515c) == null || cVar.t() || (lVar = this.f28514b) == null) {
            return;
        }
        if (this.v && lVar.X() != null) {
            this.f28515c.a(this.f28514b.X().i(), this.f28514b.am(), this.p.getWidth(), this.p.getHeight(), null, this.f28514b.ap(), this.w, u());
            this.v = false;
            al.a((View) this.f28518f, 8);
        } else {
            u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
        }
        if (i2 != 0 || this.x == null || (cVar2 = this.f28515c) == null || cVar2.w()) {
            return;
        }
        this.x.obtainMessage(1).sendToTarget();
    }

    public void setControllerStatusCallBack(a aVar) {
        this.o = aVar;
    }

    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        c cVar = this.f28515c;
        if (cVar != null) {
            ((f) cVar).a(drawVideoListener);
        }
    }

    public void setIsAutoPlay(boolean z) {
        l lVar;
        if (this.y || (lVar = this.f28514b) == null) {
            return;
        }
        int c2 = p.h().c(ak.d(lVar.ap()));
        if (z && c2 != 4 && (!x.e(this.f28513a) ? !x.d(this.f28513a) : !t())) {
            z = false;
        }
        this.q = z;
        c cVar = this.f28515c;
        if (cVar != null) {
            cVar.e(z);
        }
        if (!this.q) {
            h();
            RelativeLayout relativeLayout = this.f28518f;
            if (relativeLayout != null) {
                al.a((View) relativeLayout, 0);
                if (this.f28514b.X() != null) {
                    com.bytedance.sdk.openadsdk.i.e.c().a(this.f28514b.X().h(), this.f28519g);
                } else {
                    u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
            }
        } else {
            al.a((View) this.f28518f, 8);
        }
        this.y = true;
    }

    public void setIsQuiet(boolean z) {
        this.f28517e = z;
        c cVar = this.f28515c;
        if (cVar != null) {
            cVar.c(z);
        }
    }

    public void setNativeVideoAdListener(c.a aVar) {
        c cVar = this.f28515c;
        if (cVar != null) {
            cVar.a(aVar);
        }
    }

    public void setNativeVideoController(c cVar) {
        this.f28515c = cVar;
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        this.j = z;
    }

    public void setVideoAdClickListener(b bVar) {
        c cVar = this.f28515c;
        if (cVar != null) {
            ((f) cVar).a(bVar);
        }
    }

    public void setVideoAdInteractionListener(c.b bVar) {
        this.B = bVar;
    }

    public void setVideoAdLoadListener(c.InterfaceC0297c interfaceC0297c) {
        c cVar = this.f28515c;
        if (cVar != null) {
            cVar.a(interfaceC0297c);
        }
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 4 || i2 == 8) {
            o();
        }
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar, boolean z, boolean z2) {
        this(context, lVar, z, z2, "embeded_ad", false, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j, int i2) {
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
        this.f28517e = true;
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
        this.f28513a = context;
        this.f28514b = lVar;
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
        frameLayout.setId(ad.e(this.f28513a, "tt_native_video_layout"));
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.p = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(ad.e(this.f28513a, "tt_native_video_frame"));
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.f28516d = frameLayout2;
        ViewStub viewStub = new ViewStub(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        viewStub.setId(ad.e(this.f28513a, "tt_native_video_img_cover_viewStub"));
        viewStub.setLayoutResource(ad.f(this.f28513a, "tt_native_video_img_cover_layout"));
        viewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(viewStub);
        this.A = viewStub;
        return frameLayout;
    }

    public void b(int i2) {
        if (x.c(p.a()) == 0) {
            return;
        }
        if (this.f28515c.u() != null) {
            if (this.f28515c.u().g() && i2 == 2) {
                c(false);
                am amVar = this.x;
                if (amVar != null) {
                    amVar.removeMessages(1);
                }
                a(true);
                return;
            } else if (this.f28515c.u().i() && i2 == 3) {
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
        l lVar = this.f28514b;
        if (lVar != null && lVar.X() != null) {
            w();
            this.f28515c.a(this.f28514b.X().i(), this.f28514b.am(), this.p.getWidth(), this.p.getHeight(), null, this.f28514b.ap(), this.w, u());
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
        int i2;
        this.p.setVisibility(0);
        if (this.f28515c == null) {
            this.f28515c = new f(this.f28513a, this.f28516d, this.f28514b, this.k, this.s, this.t);
            l();
        }
        this.w = j;
        if (v()) {
            this.f28515c.b(false);
            l lVar = this.f28514b;
            boolean a2 = (lVar == null || lVar.X() == null) ? false : this.f28515c.a(this.f28514b.X().i(), this.f28514b.am(), this.p.getWidth(), this.p.getHeight(), null, this.f28514b.ap(), j, u());
            int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
            if ((i3 > 0 && !z && !z2) || (i3 > 0 && z && !this.u)) {
                c cVar = this.f28515c;
                if (cVar != null) {
                    j2 = cVar.p();
                    i2 = this.f28515c.r();
                } else {
                    j2 = 0;
                    i2 = 0;
                }
                com.bytedance.sdk.openadsdk.c.d.a(this.f28513a, this.f28514b, this.k, "feed_continue", j2, i2, ak.a(this.f28514b, this.f28515c.o(), this.f28515c.u()));
            }
            return a2;
        }
        return true;
    }

    public void c() {
        if (x.c(p.a()) == 0) {
            return;
        }
        if (this.f28515c.u() != null) {
            if (this.f28515c.u().g()) {
                c(false);
                am amVar = this.x;
                if (amVar != null) {
                    amVar.removeMessages(1);
                }
                a(true);
                return;
            } else if (this.f28515c.u().i()) {
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
        l lVar = this.f28514b;
        if (lVar != null && lVar.X() != null) {
            w();
            this.f28515c.a(this.f28514b.X().i(), this.f28514b.am(), this.p.getWidth(), this.p.getHeight(), null, this.f28514b.ap(), this.w, u());
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
        c cVar = this.f28515c;
        if (cVar != null) {
            cVar.d(z);
            h v = this.f28515c.v();
            if (v != null) {
                v.w();
                View s = v.s();
                if (s != null) {
                    if (s.getParent() != null) {
                        ((ViewGroup) s.getParent()).removeView(s);
                    }
                    s.setVisibility(0);
                    addView(s);
                    v.a(this.f28514b, new WeakReference<>(this.f28513a), false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void a(int i2) {
        b();
    }

    public void a(boolean z) {
        if (this.f28520h == null) {
            this.f28520h = new ImageView(getContext());
            if (i.d().u() != null) {
                this.f28520h.setImageBitmap(i.d().u());
            } else {
                this.f28520h.setImageResource(ad.d(p.a(), "tt_new_play_video"));
            }
            this.f28520h.setScaleType(ImageView.ScaleType.FIT_XY);
            int a2 = (int) al.a(getContext(), this.l);
            int a3 = (int) al.a(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = a3;
            layoutParams.bottomMargin = a3;
            this.p.addView(this.f28520h, layoutParams);
        }
        if (z) {
            this.f28520h.setVisibility(0);
        } else {
            this.f28520h.setVisibility(8);
        }
    }
}
