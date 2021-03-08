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
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class NativeVideoTsView extends FrameLayout implements c.a, f.a, al.a {
    private ViewStub A;
    private c.b B;
    private final AtomicBoolean C;
    private boolean D;
    private boolean E;
    private AtomicBoolean F;

    /* renamed from: a  reason: collision with root package name */
    private final Context f4548a;
    protected final l b;
    protected c c;
    protected FrameLayout d;
    protected boolean e;
    protected RelativeLayout f;
    protected ImageView g;
    protected ImageView h;
    protected ImageView i;
    protected boolean j;
    protected String k;
    protected int l;
    AtomicBoolean m;
    boolean n;
    public a o;
    private ViewGroup p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private long w;
    private final al x;
    private boolean y;
    private final String z;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, long j, long j2, long j3, boolean z2);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(View view, int i);
    }

    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        if (this.c != null) {
            ((f) this.c).a(drawVideoListener);
        }
    }

    public void setVideoAdClickListener(b bVar) {
        if (this.c != null) {
            ((f) this.c).a(bVar);
        }
    }

    public void setControllerStatusCallBack(a aVar) {
        this.o = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j, int i) {
        if (this.B != null) {
            this.B.d();
        }
    }

    private void d() {
        a(0L, 0);
        this.B = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void b(long j, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j, long j2) {
        if (this.B != null) {
            this.B.a(j, j2);
        }
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar) {
        this(context, lVar, false, false);
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar, boolean z, boolean z2) {
        this(context, lVar, z, z2, "embeded_ad", false, false);
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar, String str, boolean z, boolean z2) {
        this(context, lVar, false, false, str, z, z2);
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar, boolean z, boolean z2, String str, boolean z3, boolean z4) {
        super(context);
        this.q = true;
        this.e = true;
        this.r = false;
        this.s = false;
        this.t = true;
        this.u = false;
        this.j = true;
        this.k = "embeded_ad";
        this.l = 50;
        this.v = true;
        this.m = new AtomicBoolean(false);
        this.x = new al(this);
        this.y = false;
        this.z = Build.MODEL;
        this.n = false;
        this.C = new AtomicBoolean(false);
        this.D = true;
        this.F = new AtomicBoolean(false);
        this.k = str;
        this.f4548a = context;
        this.b = lVar;
        this.r = z;
        this.u = z2;
        this.s = z3;
        this.t = z4;
        setContentDescription("NativeVideoAdView");
        b();
        e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.b != null) {
            int d = aj.d(this.b.aj());
            switch (p.h().c(d)) {
                case 1:
                    this.q = x.d(this.f4548a);
                    break;
                case 2:
                    this.q = x.e(this.f4548a) || x.d(this.f4548a);
                    break;
                case 3:
                    this.q = false;
                    break;
                case 4:
                    this.n = true;
                    break;
            }
            if (!this.r) {
                this.e = p.h().a(d);
            } else {
                this.e = false;
            }
            if ("splash_ad".equals(this.k)) {
                this.q = true;
                this.e = true;
            }
            if (this.c != null) {
                this.c.e(this.q);
            }
            if ("feed_video_middle_page".equals(this.k)) {
                this.q = true;
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.r && this.o != null && this.c != null) {
            this.o.a(this.c.w(), this.c.s(), this.c.p(), this.c.n(), this.q);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private View a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(ac.e(this.f4548a, "tt_native_video_layout"));
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.p = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(ac.e(this.f4548a, "tt_native_video_frame"));
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.d = frameLayout2;
        ViewStub viewStub = new ViewStub(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        viewStub.setId(ac.e(this.f4548a, "tt_native_video_img_cover_viewStub"));
        viewStub.setLayoutResource(ac.f(this.f4548a, "tt_native_video_img_cover_layout"));
        viewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(viewStub);
        this.A = viewStub;
        return frameLayout;
    }

    private void e() {
        addView(a(this.f4548a));
        k();
    }

    public void g() {
        if (this.f4548a != null && this.A != null && this.A.getParent() != null && this.b != null && this.f == null) {
            this.f = (RelativeLayout) this.A.inflate();
            this.g = (ImageView) findViewById(ac.e(this.f4548a, "tt_native_video_img_id"));
            this.i = (ImageView) findViewById(ac.e(this.f4548a, "tt_native_video_play"));
            if (this.j) {
                ak.a((View) this.i, 0);
            }
            if (this.b.R() != null && this.b.R().h() != null) {
                com.bytedance.sdk.openadsdk.h.d.a(this.f4548a).a(this.b.R().h(), this.g);
            }
            j();
        }
    }

    private void j() {
        if ((this instanceof NativeDrawVideoTsView) && !this.m.get() && i.d().t() != null) {
            this.i.setImageBitmap(i.d().t());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.i.getLayoutParams();
            int a2 = (int) ak.a(getContext(), this.l);
            layoutParams.width = a2;
            layoutParams.height = a2;
            this.i.setLayoutParams(layoutParams);
            this.m.set(true);
        }
    }

    private void k() {
        this.c = new f(this.f4548a, this.d, this.b, this.k, !v(), this.s, this.t);
        l();
        this.p.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ((f) NativeVideoTsView.this.c).a(NativeVideoTsView.this.p.getWidth(), NativeVideoTsView.this.p.getHeight());
                NativeVideoTsView.this.p.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public void setVideoAdLoadListener(c.InterfaceC1024c interfaceC1024c) {
        if (this.c != null) {
            this.c.a(interfaceC1024c);
        }
    }

    public void setNativeVideoAdListener(c.a aVar) {
        if (this.c != null) {
            this.c.a(aVar);
        }
    }

    public boolean a(long j, boolean z, boolean z2) {
        this.p.setVisibility(0);
        if (this.c == null) {
            this.c = new f(this.f4548a, this.d, this.b, this.k, this.s, this.t);
            l();
        }
        this.w = j;
        if (v()) {
            this.c.b(false);
            boolean z3 = false;
            if (this.b != null && this.b.R() != null) {
                z3 = this.c.a(this.b.R().i(), this.b.ag(), this.p.getWidth(), this.p.getHeight(), null, this.b.aj(), j, u());
            }
            if ((j > 0 && !z && !z2) || (j > 0 && z && !this.u)) {
                long j2 = 0;
                int i = 0;
                if (this.c != null) {
                    j2 = this.c.p();
                    i = this.c.r();
                }
                com.bytedance.sdk.openadsdk.c.d.a(this.f4548a, this.b, this.k, "feed_continue", j2, i, aj.a(this.b, this.c.o(), this.c.u()));
            }
            return z3;
        }
        return true;
    }

    private void l() {
        if (this.c != null) {
            this.c.e(this.q);
            ((f) this.c).a((f.a) this);
            this.c.a(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        m();
    }

    private void m() {
        if (this.c == null) {
            k();
        } else if ((this.c instanceof f) && !v()) {
            ((f) this.c).f();
        }
        if (this.c != null && this.C.get()) {
            this.C.set(false);
            b();
            if (h()) {
                ak.a((View) this.f, 8);
                if (this.h != null) {
                    ak.a((View) this.h, 8);
                }
                if (this.b != null && this.b.R() != null) {
                    this.c.a(this.b.R().i(), this.b.ag(), this.p.getWidth(), this.p.getHeight(), null, this.b.aj(), 0L, u());
                    this.c.d(false);
                    return;
                }
                u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            } else if (this.c.w()) {
                u.b("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.c.w());
                b(true);
            } else {
                u.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
                g();
                ak.a((View) this.f, 0);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n();
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        n();
    }

    private void n() {
        this.o = null;
        i();
        o();
    }

    private void o() {
        if (!this.C.get()) {
            this.C.set(true);
            if (this.c != null) {
                this.c.a(true);
            }
        }
        this.F.set(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            o();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        switch (message.what) {
            case 1:
                p();
                return;
            default:
                return;
        }
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
        if (!v()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) false);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", (Boolean) false);
        }
    }

    private void c(boolean z) {
        if (this.b != null && this.c != null) {
            boolean q = q();
            r();
            if (q && this.c.w()) {
                u.b("NativeVideoAdView", "changeVideoStatus---isFromDetailPage()=" + q + "，mNativeVideoController.isPlayComplete()=" + this.c.w());
                b(true);
                d();
            } else if (z && !this.c.w() && !this.c.t()) {
                if (this.c.u() != null && this.c.u().i()) {
                    if (this.q) {
                        if ("ALP-AL00".equals(this.z)) {
                            this.c.k();
                        } else {
                            ((f) this.c).g(q);
                        }
                        if (this.B != null) {
                            this.B.c();
                        }
                    }
                } else if (this.q && this.c.u() == null) {
                    if (!this.C.get()) {
                        this.C.set(true);
                    }
                    this.F.set(false);
                    m();
                }
            } else if (this.c.u() != null && this.c.u().g()) {
                this.c.h();
                if (this.B != null) {
                    this.B.e_();
                }
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        s();
        if (q() && this.c != null && this.c.w()) {
            r();
            ak.a((View) this.f, 8);
            b(true);
            d();
            return;
        }
        b();
        if (v() || !h() || this.c == null || this.c.t()) {
            if (!h()) {
                if (!z && this.c != null && this.c.u() != null && this.c.u().g()) {
                    this.x.removeMessages(1);
                    c(false);
                } else if (z) {
                    this.x.obtainMessage(1).sendToTarget();
                }
            }
        } else if (this.x != null) {
            if (z && this.c != null && !this.c.w()) {
                this.x.obtainMessage(1).sendToTarget();
                return;
            }
            this.x.removeMessages(1);
            c(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        s();
        if (this.D) {
            this.D = i == 0;
        }
        if (q() && this.c != null && this.c.w()) {
            r();
            ak.a((View) this.f, 8);
            b(true);
            d();
            return;
        }
        b();
        if (!v() && h() && this.c != null && !this.c.t() && this.b != null) {
            if (this.v && this.b.R() != null) {
                this.c.a(this.b.R().i(), this.b.ag(), this.p.getWidth(), this.p.getHeight(), null, this.b.aj(), this.w, u());
                this.v = false;
                ak.a((View) this.f, 8);
            } else {
                u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
            }
            if (i == 0 && this.x != null && this.c != null && !this.c.w()) {
                this.x.obtainMessage(1).sendToTarget();
            }
        }
    }

    private void s() {
        if (!(this.c == null || v() || !com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false))) {
            boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
            long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", -1L);
            long a4 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.c.p());
            long a5 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", this.c.s());
            this.c.d(a2);
            if (a2) {
                this.c.a(a5);
            } else {
                this.c.a(a3);
            }
            this.c.b(a4);
            this.c.c(a5);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) false);
            u.f("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + a2 + ",position=" + a3 + ",totalPlayDuration=" + a4 + ",duration=" + a5);
        }
    }

    public void setNativeVideoController(c cVar) {
        this.c = cVar;
    }

    public c getNativeVideoController() {
        return this.c;
    }

    public boolean h() {
        return this.q;
    }

    public void setIsAutoPlay(boolean z) {
        if (!this.y && this.b != null) {
            int c = p.h().c(aj.d(this.b.aj()));
            if (z && c != 4) {
                if (x.e(this.f4548a)) {
                    if (!t()) {
                        z = false;
                    }
                } else if (!x.d(this.f4548a)) {
                    z = false;
                }
            }
            this.q = z;
            if (this.c != null) {
                this.c.e(this.q);
            }
            if (!this.q) {
                g();
                if (this.f != null) {
                    ak.a((View) this.f, 0);
                    if (this.b.R() != null) {
                        com.bytedance.sdk.openadsdk.h.d.a(this.f4548a).a(this.b.R().h(), this.g);
                    } else {
                        u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                    }
                }
            } else {
                ak.a((View) this.f, 8);
            }
            this.y = true;
        }
    }

    private boolean t() {
        return 2 == p.h().c(aj.d(this.b.aj()));
    }

    private boolean u() {
        return this.e;
    }

    public void setIsQuiet(boolean z) {
        this.e = z;
        if (this.c != null) {
            this.c.c(z);
        }
    }

    private boolean v() {
        return this.r;
    }

    public void setVideoAdInteractionListener(c.b bVar) {
        this.B = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void f() {
        if (this.B != null && !this.E) {
            this.E = true;
            this.B.d_();
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z) {
        this.j = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void a(int i) {
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(int i) {
        if (x.c(p.a()) != 0) {
            if (this.c.u() != null) {
                if (this.c.u().g() && i == 2) {
                    c(false);
                    if (this.x != null) {
                        this.x.removeMessages(1);
                    }
                    a(true);
                    return;
                } else if (this.c.u().i() && i == 3) {
                    this.q = true;
                    c(true);
                    b();
                    if (this.x != null) {
                        this.x.sendEmptyMessageDelayed(1, 500L);
                    }
                    a(false);
                    return;
                }
            }
            if (!h() && !this.F.get()) {
                this.F.set(true);
                if (this.b != null && this.b.R() != null) {
                    w();
                    this.c.a(this.b.R().i(), this.b.ag(), this.p.getWidth(), this.p.getHeight(), null, this.b.aj(), this.w, u());
                } else {
                    u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
                if (this.x != null) {
                    this.x.sendEmptyMessageDelayed(1, 500L);
                }
                a(false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        if (x.c(p.a()) != 0) {
            if (this.c.u() != null) {
                if (this.c.u().g()) {
                    c(false);
                    if (this.x != null) {
                        this.x.removeMessages(1);
                    }
                    a(true);
                    return;
                } else if (this.c.u().i()) {
                    this.q = true;
                    c(true);
                    b();
                    if (this.x != null) {
                        this.x.sendEmptyMessageDelayed(1, 500L);
                    }
                    a(false);
                    return;
                }
            }
            if (!h() && !this.F.get()) {
                this.F.set(true);
                if (this.b != null && this.b.R() != null) {
                    w();
                    this.c.a(this.b.R().i(), this.b.ag(), this.p.getWidth(), this.p.getHeight(), null, this.b.aj(), this.w, u());
                } else {
                    u.f("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                }
                if (this.x != null) {
                    this.x.sendEmptyMessageDelayed(1, 500L);
                }
                a(false);
            }
        }
    }

    protected void a(boolean z) {
        if (this.h == null) {
            this.h = new ImageView(getContext());
            if (i.d().t() != null) {
                this.h.setImageBitmap(i.d().t());
            } else {
                this.h.setImageResource(ac.d(p.a(), "tt_new_play_video"));
            }
            this.h.setScaleType(ImageView.ScaleType.FIT_XY);
            int a2 = (int) ak.a(getContext(), this.l);
            int a3 = (int) ak.a(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = a3;
            layoutParams.bottomMargin = a3;
            this.p.addView(this.h, layoutParams);
        }
        if (z) {
            this.h.setVisibility(0);
        } else {
            this.h.setVisibility(8);
        }
    }

    public void b(boolean z) {
        if (this.c != null) {
            this.c.d(z);
            h v = this.c.v();
            if (v != null) {
                v.w();
                View s = v.s();
                if (s != null) {
                    if (s.getParent() != null) {
                        ((ViewGroup) s.getParent()).removeView(s);
                    }
                    s.setVisibility(0);
                    addView(s);
                    v.a(this.b, new WeakReference<>(this.f4548a), false);
                }
            }
        }
    }

    public void i() {
        h v;
        if (this.c != null && (v = this.c.v()) != null) {
            v.e();
            View s = v.s();
            if (s != null) {
                s.setVisibility(8);
                if (s.getParent() != null) {
                    ((ViewGroup) s.getParent()).removeView(s);
                }
            }
        }
    }

    private void w() {
        ak.f(this.h);
        ak.f(this.f);
    }
}
