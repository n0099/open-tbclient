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
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
@SuppressLint({"ViewConstructor"})
/* loaded from: classes6.dex */
public class NativeVideoTsView extends FrameLayout implements c.a, f.a, am.a {
    private AtomicBoolean A;

    /* renamed from: a  reason: collision with root package name */
    protected final l f6722a;

    /* renamed from: b  reason: collision with root package name */
    protected c f6723b;
    protected FrameLayout c;
    protected boolean d;
    protected RelativeLayout e;
    protected ImageView f;
    protected ImageView g;
    protected ImageView h;
    protected String i;
    protected int j;
    AtomicBoolean k;
    boolean l;
    public a m;
    private final Context n;
    private ViewGroup o;
    private boolean p;
    private boolean q;
    private boolean r;
    private long s;
    private final am t;
    private boolean u;
    private final String v;
    private ViewStub w;
    private c.b x;
    private final AtomicBoolean y;
    private boolean z;

    /* loaded from: classes6.dex */
    public interface a {
        void a(boolean z, long j, long j2, long j3, boolean z2);
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(View view, int i);
    }

    public void setDrawVideoListener(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        if (this.f6723b != null) {
            ((f) this.f6723b).a(drawVideoListener);
        }
    }

    public void setVideoAdClickListener(b bVar) {
        if (this.f6723b != null) {
            ((f) this.f6723b).a(bVar);
        }
    }

    public void setControllerStatusCallBack(a aVar) {
        this.m = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j, int i) {
        if (this.x != null) {
            this.x.d_();
        }
    }

    private void d() {
        a(0L, 0);
        this.x = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void b(long j, int i) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a() {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c.a
    public void a(long j, long j2) {
        if (this.x != null) {
            this.x.a(j, j2);
        }
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar) {
        this(context, lVar, false);
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar, boolean z) {
        this(context, lVar, z, "embeded_ad");
    }

    public NativeVideoTsView(@NonNull Context context, @NonNull l lVar, boolean z, String str) {
        super(context);
        this.p = true;
        this.d = true;
        this.q = false;
        this.i = "embeded_ad";
        this.j = 50;
        this.r = true;
        this.k = new AtomicBoolean(false);
        this.t = new am(this);
        this.u = false;
        this.v = Build.MODEL;
        this.l = false;
        this.y = new AtomicBoolean(false);
        this.z = true;
        this.A = new AtomicBoolean(false);
        this.i = str;
        this.n = context;
        this.f6722a = lVar;
        this.q = z;
        setContentDescription("NativeVideoAdView");
        b();
        i();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        if (this.f6722a != null) {
            int d = aj.d(this.f6722a.W());
            switch (p.h().c(d)) {
                case 1:
                    this.p = x.d(this.n);
                    break;
                case 2:
                    this.p = x.e(this.n) || x.d(this.n);
                    break;
                case 3:
                    this.p = false;
                    break;
                case 4:
                    this.l = true;
                    break;
            }
            if (!this.q) {
                this.d = p.h().a(d);
            } else {
                this.d = false;
            }
            if ("splash_ad".equals(this.i)) {
                this.p = true;
                this.d = true;
            }
            if (this.f6723b != null) {
                this.f6723b.e(this.p);
            }
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.q && this.m != null && this.f6723b != null) {
            this.m.a(this.f6723b.v(), this.f6723b.r(), this.f6723b.o(), this.f6723b.m(), this.p);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private View a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(ac.e(this.n, "tt_native_video_layout"));
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.o = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(ac.e(this.n, "tt_native_video_frame"));
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.c = frameLayout2;
        ViewStub viewStub = new ViewStub(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        viewStub.setId(ac.e(this.n, "tt_native_video_img_cover_viewStub"));
        viewStub.setLayoutResource(ac.f(this.n, "tt_native_video_img_cover_layout"));
        viewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(viewStub);
        this.w = viewStub;
        return frameLayout;
    }

    private void i() {
        addView(a(this.n));
        k();
    }

    public void f() {
        if (this.n != null && this.w != null && this.w.getParent() != null && this.f6722a != null && this.e == null) {
            this.e = (RelativeLayout) this.w.inflate();
            if (this.f6722a.F() != null && this.f6722a.F().g() != null) {
                com.bytedance.sdk.openadsdk.i.e.a(this.n).a(this.f6722a.F().g(), this.f);
            }
            this.f = (ImageView) findViewById(ac.e(this.n, "tt_native_video_img_id"));
            this.h = (ImageView) findViewById(ac.e(this.n, "tt_native_video_play"));
            j();
        }
    }

    private void j() {
        if ((this instanceof NativeDrawVideoTsView) && !this.k.get() && i.c().s() != null) {
            this.h.setImageBitmap(i.c().s());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.h.getLayoutParams();
            int a2 = (int) ak.a(getContext(), this.j);
            layoutParams.width = a2;
            layoutParams.height = a2;
            this.h.setLayoutParams(layoutParams);
            this.k.set(true);
        }
    }

    private void k() {
        this.f6723b = new f(this.n, this.c, this.f6722a, this.i, !v());
        l();
        this.o.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                ((f) NativeVideoTsView.this.f6723b).a(NativeVideoTsView.this.o.getWidth(), NativeVideoTsView.this.o.getHeight());
                NativeVideoTsView.this.o.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        });
    }

    public void setVideoAdLoadListener(c.InterfaceC1013c interfaceC1013c) {
        if (this.f6723b != null) {
            this.f6723b.a(interfaceC1013c);
        }
    }

    public void setNativeVideoAdListener(c.a aVar) {
        if (this.f6723b != null) {
            this.f6723b.a(aVar);
        }
    }

    public boolean a(long j, boolean z, boolean z2) {
        this.o.setVisibility(0);
        if (this.f6723b == null) {
            this.f6723b = new f(this.n, this.c, this.f6722a, this.i);
            l();
        }
        this.s = j;
        if (v()) {
            this.f6723b.b(false);
            boolean a2 = this.f6723b.a(this.f6722a.F().h(), this.f6722a.T(), this.o.getWidth(), this.o.getHeight(), null, this.f6722a.W(), j, u());
            if ((j > 0 && !z && !z2) || (j > 0 && z)) {
                long j2 = 0;
                int i = 0;
                if (this.f6723b != null) {
                    j2 = this.f6723b.o();
                    i = this.f6723b.q();
                }
                com.bytedance.sdk.openadsdk.c.d.a(this.n, this.f6722a, this.i, "feed_continue", j2, i, aj.a(this.f6722a, this.f6723b.n(), this.f6723b.t()));
            }
            return a2;
        }
        return true;
    }

    private void l() {
        if (this.f6723b != null) {
            this.f6723b.e(this.p);
            ((f) this.f6723b).a((f.a) this);
            this.f6723b.a(this);
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
        if (this.f6723b == null) {
            k();
        } else if ((this.f6723b instanceof f) && !v()) {
            ((f) this.f6723b).x();
        }
        if (this.f6723b != null && this.y.get()) {
            this.y.set(false);
            b();
            if (g()) {
                ak.a((View) this.e, 8);
                if (this.g != null) {
                    ak.a((View) this.g, 8);
                }
                this.f6723b.a(this.f6722a.F().h(), this.f6722a.T(), this.o.getWidth(), this.o.getHeight(), null, this.f6722a.W(), 0L, u());
                this.f6723b.d(false);
            } else if (this.f6723b.v()) {
                u.b("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.f6723b.v());
                b(true);
            } else {
                u.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
                f();
                ak.a((View) this.e, 0);
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
        this.m = null;
        h();
        o();
    }

    private void o() {
        if (!this.y.get()) {
            this.y.set(true);
            if (this.f6723b != null) {
                this.f6723b.a(true);
            }
        }
        this.A.set(false);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 4 || i == 8) {
            o();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
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
        this.t.sendEmptyMessageDelayed(1, 500L);
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
        if (this.f6722a != null && this.f6723b != null) {
            boolean q = q();
            r();
            if (q && this.f6723b.v()) {
                u.b("NativeVideoAdView", "changeVideoStatus---isFromDetailPage()=" + q + "，mNativeVideoController.isPlayComplete()=" + this.f6723b.v());
                b(true);
                d();
            } else if (z && !this.f6723b.v() && !this.f6723b.s()) {
                if (this.f6723b.t() != null && this.f6723b.t().i()) {
                    if (this.p) {
                        if ("ALP-AL00".equals(this.v)) {
                            this.f6723b.j();
                        } else {
                            ((f) this.f6723b).g(q);
                        }
                        if (this.x != null) {
                            this.x.c();
                        }
                    }
                } else if (this.p && this.f6723b.t() == null) {
                    if (!this.y.get()) {
                        this.y.set(true);
                    }
                    this.A.set(false);
                    m();
                }
            } else if (this.f6723b.t() != null && this.f6723b.t().g()) {
                this.f6723b.h();
                if (this.x != null) {
                    this.x.d();
                }
            }
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        s();
        if (q() && this.f6723b != null && this.f6723b.v()) {
            r();
            ak.a((View) this.e, 8);
            b(true);
            d();
            return;
        }
        b();
        if (v() || !g() || this.f6723b == null || this.f6723b.s()) {
            if (!g()) {
                if (!z && this.f6723b != null && this.f6723b.t() != null && this.f6723b.t().g()) {
                    this.t.removeMessages(1);
                    c(false);
                } else if (z) {
                    this.t.obtainMessage(1).sendToTarget();
                }
            }
        } else if (this.t != null) {
            if (z && this.f6723b != null && !this.f6723b.v()) {
                this.t.obtainMessage(1).sendToTarget();
                return;
            }
            this.t.removeMessages(1);
            c(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        s();
        if (this.z) {
            this.z = i == 0;
        }
        if (q() && this.f6723b != null && this.f6723b.v()) {
            r();
            ak.a((View) this.e, 8);
            b(true);
            d();
            return;
        }
        b();
        if (!v() && g() && this.f6723b != null && !this.f6723b.s()) {
            if (this.r) {
                this.f6723b.a(this.f6722a.F().h(), this.f6722a.T(), this.o.getWidth(), this.o.getHeight(), null, this.f6722a.W(), this.s, u());
                this.r = false;
                ak.a((View) this.e, 8);
            }
            if (i == 0 && this.t != null && this.f6723b != null && !this.f6723b.v()) {
                this.t.obtainMessage(1).sendToTarget();
            }
        }
    }

    private void s() {
        if (!(this.f6723b == null || v() || !com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false))) {
            boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
            long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", 0L);
            long a4 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.f6723b.o());
            long a5 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", this.f6723b.r());
            this.f6723b.d(a2);
            this.f6723b.a(a3);
            this.f6723b.b(a4);
            this.f6723b.c(a5);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) false);
            u.f("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + a2 + ",position=" + a3 + ",totalPlayDuration=" + a4 + ",duration=" + a5);
        }
    }

    public void setNativeVideoController(c cVar) {
        this.f6723b = cVar;
    }

    public c getNativeVideoController() {
        return this.f6723b;
    }

    public boolean g() {
        return this.p;
    }

    public void setIsAutoPlay(boolean z) {
        if (!this.u) {
            int c = p.h().c(aj.d(this.f6722a.W()));
            if (z && c != 4) {
                if (x.e(this.n)) {
                    if (!t()) {
                        z = false;
                    }
                } else if (!x.d(this.n)) {
                    z = false;
                }
            }
            this.p = z;
            if (this.f6723b != null) {
                this.f6723b.e(this.p);
            }
            if (!this.p) {
                f();
                if (this.e != null) {
                    ak.a((View) this.e, 0);
                    com.bytedance.sdk.openadsdk.i.e.a(this.n).a(this.f6722a.F().g(), this.f);
                }
            } else {
                ak.a((View) this.e, 8);
            }
            this.u = true;
        }
    }

    private boolean t() {
        return 2 == p.h().c(aj.d(this.f6722a.W()));
    }

    private boolean u() {
        return this.d;
    }

    public void setIsQuiet(boolean z) {
        this.d = z;
        if (this.f6723b != null) {
            this.f6723b.c(z);
        }
    }

    private boolean v() {
        return this.q;
    }

    public void setVideoAdInteractionListener(c.b bVar) {
        this.x = bVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void e() {
        if (this.x != null) {
            this.x.e();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.f.a
    public void a(int i) {
        b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        if (x.c(p.a()) != 0) {
            if (this.f6723b.t() != null) {
                if (this.f6723b.t().g()) {
                    c(false);
                    if (this.t != null) {
                        this.t.removeMessages(1);
                    }
                    a(true);
                    return;
                } else if (this.f6723b.t().i()) {
                    c(true);
                    if (this.t != null) {
                        this.t.sendEmptyMessageDelayed(1, 500L);
                    }
                    a(false);
                    return;
                }
            }
            if (!g() && !this.A.get()) {
                this.A.set(true);
                w();
                this.f6723b.a(this.f6722a.F().h(), this.f6722a.T(), this.o.getWidth(), this.o.getHeight(), null, this.f6722a.W(), this.s, u());
                if (this.t != null) {
                    this.t.sendEmptyMessageDelayed(1, 500L);
                }
                a(false);
            }
        }
    }

    protected void a(boolean z) {
        if (this.g == null) {
            this.g = new ImageView(getContext());
            if (i.c().s() != null) {
                this.g.setImageBitmap(i.c().s());
            } else {
                this.g.setImageResource(ac.d(p.a(), "tt_new_play_video"));
            }
            this.g.setScaleType(ImageView.ScaleType.FIT_XY);
            int a2 = (int) ak.a(getContext(), this.j);
            int a3 = (int) ak.a(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(a2, a2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = a3;
            layoutParams.bottomMargin = a3;
            this.o.addView(this.g, layoutParams);
        }
        if (z) {
            this.g.setVisibility(0);
        } else {
            this.g.setVisibility(8);
        }
    }

    public void b(boolean z) {
        if (this.f6723b != null) {
            this.f6723b.d(z);
            h u = this.f6723b.u();
            if (u != null) {
                u.w();
                View s = u.s();
                if (s != null) {
                    if (s.getParent() != null) {
                        ((ViewGroup) s.getParent()).removeView(s);
                    }
                    s.setVisibility(0);
                    addView(s);
                    u.a(this.f6722a, new WeakReference<>(this.n), false);
                }
            }
        }
    }

    public void h() {
        h u;
        if (this.f6723b != null && (u = this.f6723b.u()) != null) {
            u.e();
            View s = u.s();
            if (s != null) {
                s.setVisibility(8);
                if (s.getParent() != null) {
                    ((ViewGroup) s.getParent()).removeView(s);
                }
            }
        }
    }

    private void w() {
        ak.f(this.g);
        ak.f(this.e);
    }
}
