package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.ViewCompat;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.h;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.internal.http.StatusLine;
/* loaded from: classes6.dex */
public class f implements c, d, al.a {
    private WeakReference<c.InterfaceC1024c> E;
    private WeakReference<a> F;
    private int G;
    private int H;
    private long T;
    private int V;
    private h b;
    private final WeakReference<ViewGroup> c;
    private com.bytedance.sdk.openadsdk.core.video.d.d g;
    private c.a h;
    private long k;
    private List<Runnable> l;
    private final WeakReference<Context> n;
    private final boolean o;
    private final l r;
    private String u;
    private boolean v;
    private boolean w;
    private WeakReference<e> x;
    private final al d = new al(this);
    private long e = 0;
    private long f = 0;
    private long i = 0;
    private long j = 0;
    private boolean m = false;
    private boolean p = false;
    private boolean q = false;
    private boolean s = true;
    private boolean t = false;
    private long y = 0;
    private boolean z = false;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    private boolean D = true;
    private int I = 0;
    private boolean J = false;
    private boolean K = true;
    private final Runnable L = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.g != null) {
                f.this.g.e();
            }
        }
    };
    private final Runnable M = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.h != null) {
                f.this.h.a();
            }
        }
    };
    private final Runnable N = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.5
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.g != null) {
                if (f.this.k <= 0) {
                    f.this.g.e();
                }
                f.this.g.f();
            }
            f.this.d.postDelayed(this, 200L);
        }
    };
    private int O = 0;
    private long P = 0;

    /* renamed from: a  reason: collision with root package name */
    Runnable f4551a = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.6
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.b != null) {
                f.this.b.a(f.this.r, f.this.n, false);
                f.this.b.w();
                f.this.d(true);
                u.f("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    private long Q = 0;
    private long R = 0;
    private boolean S = false;
    private final BroadcastReceiver U = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.7
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                f.this.h();
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                f.this.d(context);
            }
        }
    };
    private boolean W = false;

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i);

        void f();
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        if (this.b != null) {
            this.b.a(drawVideoListener);
        }
    }

    public void a(final NativeVideoTsView.b bVar) {
        if (this.s && this.b != null) {
            this.b.a(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.1
                @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
                public void a(View view, int i) {
                    if (bVar != null) {
                        bVar.a(view, i);
                    }
                }
            });
        }
    }

    public void a(int i, int i2) {
        if (i != 0 && i2 != 0) {
            this.G = i;
            this.H = i2;
            u.b("NativeVideoController", "width=" + i + "height=" + i2);
        }
    }

    private boolean z() {
        u.b("NativeVideoController", "retryCount=" + this.I);
        if (1 <= this.I) {
            if (this.b != null) {
                this.b.w();
                this.b.a(this.r, this.n, false);
                return false;
            }
            return false;
        } else if (this.g != null) {
            this.I++;
            u.b("NativeVideoController", "isPlaying=" + this.g.g() + ",isPaused=" + this.g.i() + ",isPrepared=" + this.g.k() + ",isStarted=" + this.g.h());
            return (this.g.g() && this.g.i() && this.g.k() && this.g.h()) ? false : true;
        } else {
            return false;
        }
    }

    @SuppressLint({"InflateParams"})
    private void b(Context context) {
        View inflate;
        EnumSet noneOf = EnumSet.noneOf(b.a.class);
        noneOf.add(b.a.hideCloseBtn);
        noneOf.add(b.a.hideBackBtn);
        if (this.s) {
            inflate = c(context);
        } else {
            inflate = LayoutInflater.from(context.getApplicationContext()).inflate(ac.f(context, "tt_video_detail_layout"), (ViewGroup) null, false);
        }
        if (inflate != null) {
            if (this.s) {
                this.b = new h(context, inflate, true, noneOf, this.r, this, a());
            } else {
                this.b = new g(context, inflate, true, noneOf, this.r, this, false);
            }
            this.b.a(this);
        }
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(ac.e(context, "tt_root_view"));
        relativeLayout.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(ac.e(context, "tt_video_loading_retry_layout"));
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(ac.e(context, "tt_video_loading_cover_image"));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        ProgressBar progressBar = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        progressBar.setId(ac.e(context, "tt_video_loading_progress"));
        layoutParams3.addRule(13, -1);
        progressBar.setLayoutParams(layoutParams3);
        progressBar.setIndeterminateDrawable(ac.c(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(progressBar);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(ac.e(context, "tt_video_play"));
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setImageResource(ac.d(context, "tt_play_movebar_textpage"));
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        ProgressBar progressBar2 = new ProgressBar(context, null, ac.g(context, "tt_Widget_ProgressBar_Horizontal"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        progressBar2.setMax(100);
        progressBar2.setId(ac.e(context, "tt_video_progress"));
        progressBar2.setBackgroundColor(0);
        progressBar2.setIndeterminateDrawable(null);
        progressBar2.setProgressDrawable(ac.c(context, "tt_video_progress_drawable"));
        progressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        progressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(progressBar2);
        ViewStub viewStub = new ViewStub(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        viewStub.setId(ac.e(context, "tt_video_ad_cover"));
        viewStub.setLayoutParams(layoutParams6);
        viewStub.setLayoutResource(ac.f(context, "tt_video_ad_cover_layout"));
        relativeLayout.addView(viewStub);
        ViewStub viewStub2 = new ViewStub(context);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(13, -1);
        viewStub2.setId(ac.e(context, "tt_video_draw_layout_viewStub"));
        viewStub2.setLayoutParams(layoutParams7);
        viewStub2.setLayoutResource(ac.f(context, "tt_video_draw_btn_layout"));
        relativeLayout.addView(viewStub2);
        return relativeLayout;
    }

    public f(Context context, ViewGroup viewGroup, l lVar, String str, boolean z, boolean z2, boolean z3) {
        this.u = "embeded_ad";
        this.v = false;
        this.w = true;
        this.G = 0;
        this.H = 0;
        this.V = 1;
        this.V = x.c(context);
        b(z);
        this.u = str;
        try {
            this.G = viewGroup.getWidth();
            this.H = viewGroup.getHeight();
        } catch (Throwable th) {
        }
        this.c = new WeakReference<>(viewGroup);
        this.n = new WeakReference<>(context);
        this.r = lVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17;
        this.v = z2;
        this.w = z3;
    }

    public f(Context context, ViewGroup viewGroup, l lVar, String str, boolean z, boolean z2) {
        this.u = "embeded_ad";
        this.v = false;
        this.w = true;
        this.G = 0;
        this.H = 0;
        this.V = 1;
        this.V = x.c(context);
        try {
            this.G = viewGroup.getWidth();
            this.H = viewGroup.getHeight();
        } catch (Throwable th) {
        }
        this.c = new WeakReference<>(viewGroup);
        this.u = str;
        this.n = new WeakReference<>(context);
        this.r = lVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17;
        this.v = z;
        this.w = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public h v() {
        return this.b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC1024c interfaceC1024c) {
        this.E = new WeakReference<>(interfaceC1024c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(String str, String str2, int i, int i2, List<String> list, String str3, long j, boolean z) {
        u.b("tag_video_play", "[video] start NativeVideoController#playVideoUrl and video url is :\r\n" + str);
        if (TextUtils.isEmpty(str)) {
            u.f("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.t = z;
        this.i = j;
        if (j <= 0) {
            this.q = false;
            this.p = false;
        }
        if (j > 0) {
            this.i = j;
            this.j = this.j > this.i ? this.j : this.i;
        }
        if (this.b != null) {
            this.b.e();
            if (this.O == 0) {
                this.b.d();
            }
            this.b.c(i, i2);
            this.b.c(this.c.get());
            this.b.a(i, i2);
        }
        if (this.g == null) {
            this.g = new com.bytedance.sdk.openadsdk.core.video.d.d(this.d);
        }
        u.b("tag_video_play", "[video] new MediaPlayer");
        this.f = 0L;
        try {
            a(str);
            return true;
        } catch (Exception e) {
            u.f("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + e.toString());
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.d.d u() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j) {
        this.i = j;
        this.j = this.j > this.i ? this.j : this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z) {
        this.s = z;
        if (this.b != null) {
            this.b.c(z);
        }
    }

    public boolean a() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean t() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j) {
        this.y = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long s() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j) {
        this.k = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long p() {
        if (this.g == null) {
            return 0L;
        }
        return this.g.o() + this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long q() {
        return 0L;
    }

    public boolean b() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        this.t = z;
        if (this.g != null) {
            this.g.b(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        return this.B;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int r() {
        return com.bytedance.sdk.openadsdk.core.video.e.a.a(this.j, this.k);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
    }

    private void a(String str) {
        u.b("tag_video_play", "[video] NativeVideoController#playVideo has invoke !");
        if (this.g != null) {
            com.bytedance.sdk.openadsdk.core.video.b.a aVar = new com.bytedance.sdk.openadsdk.core.video.b.a();
            aVar.f4525a = str;
            if (this.r != null) {
                if (this.r.R() != null) {
                    aVar.d = this.r.R().l();
                }
                aVar.b = String.valueOf(aj.d(this.r.aj()));
            }
            aVar.c = 0;
            this.g.a(aVar);
            u.b("tag_video_play", "[video] MediaPlayerProxy has setDataSource !");
        }
        this.e = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.b.d(8);
            this.b.d(0);
            a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.2
                @Override // java.lang.Runnable
                public void run() {
                    f.this.e = System.currentTimeMillis();
                    f.this.b.c(0);
                    if (f.this.g == null || f.this.i != 0) {
                        if (f.this.g != null) {
                            f.this.g.a(true, f.this.i, f.this.t ? false : true);
                        }
                    } else {
                        f.this.g.a(true, 0L, f.this.t ? false : true);
                    }
                    if (f.this.d != null) {
                        f.this.d.postDelayed(f.this.L, 100L);
                    }
                    f.this.A();
                }
            });
        }
        if (this.s) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        B();
        this.d.postDelayed(this.N, 800L);
    }

    private void B() {
        this.d.removeCallbacks(this.N);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        this.x = new WeakReference<>(eVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long o() {
        if (u() == null) {
            return 0L;
        }
        return u().n();
    }

    private void b(int i) {
        this.O++;
        if (C() && this.b != null) {
            this.b.w();
            if (this.h != null) {
                this.h.a(this.f, com.bytedance.sdk.openadsdk.core.video.e.a.a(this.i, this.k));
            }
            this.f = System.currentTimeMillis() - this.e;
            if (!aj.b(this.r) || this.O >= 2) {
                this.b.a(this.r, this.n, true);
            }
            if (!this.q) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_over", p(), 100, c());
                this.q = true;
                a(this.k, this.k);
                long j = this.k;
                this.i = j;
                this.j = j;
            }
            if (!this.s && this.S) {
                e(this.b, null);
            }
            this.B = true;
            if (aj.b(this.r) && this.O < 2) {
                g();
            }
        }
    }

    private boolean C() {
        return (this.n == null || this.n.get() == null) ? false : true;
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            if (this.b.k() && this.m) {
                runnable.run();
            } else {
                b(runnable);
            }
        }
    }

    private void b(Runnable runnable) {
        if (this.l == null) {
            this.l = Collections.synchronizedList(new ArrayList());
        }
        this.l.add(runnable);
    }

    private void D() {
        if (this.l != null && !this.l.isEmpty()) {
            Iterator it = new ArrayList(this.l).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.l.clear();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.h = aVar;
    }

    protected Map<String, Object> c() {
        return aj.a(this.r, o(), u());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void h() {
        if (this.g != null) {
            this.g.b();
        }
        if (!this.q && this.p) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", true)) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", p(), r(), c());
                }
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", (Boolean) true);
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.u.a().b()) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", p(), r(), c());
            }
            com.bytedance.sdk.openadsdk.core.u.a().a(true);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        if (this.g != null) {
            this.g.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        if (this.g != null) {
            this.g.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        if (this.b != null) {
            this.b.e();
        }
        if (this.b != null) {
            this.b.u();
        }
        E();
    }

    public void g(boolean z) {
        if (this.b != null) {
            this.b.e();
        }
        if (this.b != null && z) {
            this.b.u();
        }
        E();
    }

    private void E() {
        if (this.g != null) {
            this.g.a(false, this.i, !this.t);
            A();
        }
        if (this.p) {
            com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_continue", p(), r(), c());
        }
    }

    public void d(long j) {
        this.i = j;
        this.j = this.j > this.i ? this.j : this.i;
        if (this.b != null) {
            this.b.e();
        }
        if (this.g != null) {
            this.g.a(true, this.i, !this.t);
            A();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z) {
        if (this.s) {
            this.P = p();
        }
        if (!this.q && this.p) {
            if (z) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_break", this.P, r(), c());
                this.q = false;
            } else {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", this.P, r(), c());
            }
        }
        m();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void m() {
        if (this.g != null) {
            this.g.c();
            this.g = null;
        }
        if (!aj.b(this.r) || this.O == 2) {
            this.b.a(this.r, this.n, true);
        }
        if (this.d != null) {
            this.d.removeCallbacks(this.N);
            this.d.removeCallbacks(this.M);
            this.d.removeCallbacks(this.L);
            this.d.removeCallbacksAndMessages(null);
        }
        B();
        if (this.l != null) {
            this.l.clear();
        }
        if (this.s) {
            y();
        }
    }

    private void F() {
        this.R = SystemClock.elapsedRealtime() - this.Q;
        if (!this.p) {
            Map<String, Object> a2 = aj.a(this.R, this.r, u());
            if (this.D) {
                com.bytedance.sdk.openadsdk.c.d.c(this.n.get(), this.r, this.u, "feed_auto_play", a2);
            } else if (this.i <= 0) {
                com.bytedance.sdk.openadsdk.c.d.c(this.n.get(), this.r, this.u, "feed_play", a2);
            }
            this.p = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        if (this.b != null && message != null && this.n != null && this.n.get() != null) {
            switch (message.what) {
                case 108:
                    if ((message.obj instanceof Long) && ((Long) message.obj).longValue() > 0) {
                        this.k = ((Long) message.obj).longValue();
                        return;
                    }
                    return;
                case 109:
                    if (message.obj instanceof Long) {
                        this.i = ((Long) message.obj).longValue();
                        this.j = this.j > this.i ? this.j : this.i;
                        a(this.i, this.k);
                        return;
                    }
                    return;
                case 302:
                    b(message.what);
                    return;
                case 303:
                    int i = message.arg1;
                    int i2 = message.arg2;
                    b(i, i2);
                    u.f("NativeVideoController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                    if (!e() || i2 == -1004) {
                        u.f("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + i + "," + i2);
                        if (c(i, i2)) {
                            u.f("NativeVideoController", "出错后展示结果页、、、、、、、");
                            this.b.a(this.r, this.n, false);
                            d(true);
                            m();
                        }
                        if (this.b != null) {
                            this.b.w();
                        }
                        if (this.h != null) {
                            this.h.b(this.f, com.bytedance.sdk.openadsdk.core.video.e.a.a(this.i, this.k));
                        }
                        if (this.E != null && this.E.get() != null && !e()) {
                            this.E.get().a(i, i2);
                            return;
                        }
                        return;
                    }
                    return;
                case 304:
                    int i3 = message.arg1;
                    if (this.b != null) {
                        if (i3 == 3 || i3 == 702) {
                            this.b.w();
                            this.d.removeCallbacks(this.f4551a);
                            this.J = false;
                        } else if (i3 == 701) {
                            this.b.t();
                            this.d.postDelayed(this.f4551a, 8000L);
                            this.J = true;
                        }
                    }
                    if (this.o && i3 == 3) {
                        if (this.s && this.F != null && this.F.get() != null) {
                            this.F.get().f();
                        }
                        this.d.removeCallbacks(this.f4551a);
                    }
                    if (this.o && i3 == 3) {
                        F();
                        return;
                    }
                    return;
                case 305:
                    if (this.E != null && this.E.get() != null) {
                        this.E.get().f();
                    }
                    if (this.d != null) {
                        this.d.removeCallbacks(this.M);
                    }
                    if (!this.o) {
                        F();
                    }
                    if (this.b != null) {
                        this.b.w();
                    }
                    this.d.removeCallbacks(this.f4551a);
                    return;
                case ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA /* 306 */:
                    if (this.b != null) {
                        this.b.w();
                        return;
                    }
                    return;
                case StatusLine.HTTP_PERM_REDIRECT /* 308 */:
                    u.f("NativeVideoController", "播放器状态出错 STAT_ERROR 200 、、、、、、、");
                    G();
                    b(StatusLine.HTTP_PERM_REDIRECT, 0);
                    return;
                case 309:
                    u.c("NativeVideoController", "SSMediaPlayerWrapper 释放了。。。。。");
                    return;
                case 311:
                    I();
                    return;
                case 312:
                    if (z()) {
                        u.f("NativeVideoController", "CALLBACK_ON_RETRY_VIDEO_TIME-....重试....");
                        m();
                        this.g = null;
                        a(this.r.R().i(), this.r.ag(), this.G, this.H, null, this.r.aj(), 0L, b());
                        return;
                    }
                    u.c("NativeVideoController", "不满足条件，无法重试");
                    b(312, 0);
                    return;
                case 313:
                    H();
                    if (this.F != null && this.F.get() != null) {
                        this.F.get().f();
                        return;
                    }
                    return;
                case 314:
                    try {
                        ((Boolean) message.obj).booleanValue();
                    } catch (Throwable th) {
                    }
                    this.Q = SystemClock.elapsedRealtime();
                    return;
                default:
                    return;
            }
        }
    }

    private void b(int i, int i2) {
        if (this.r != null) {
            boolean e = e();
            String str = e ? "play_error" : "play_start_error";
            Map<String, Object> a2 = aj.a(this.r, i, i2, u());
            if (e) {
                a2.put("duration", Long.valueOf(p()));
                a2.put("percent", Integer.valueOf(r()));
                a2.put("buffers_time", Long.valueOf(o()));
            }
            com.bytedance.sdk.openadsdk.c.d.d(this.n.get(), this.r, this.u, str, a2);
        }
    }

    private void G() {
        if (this.c.get() != null && !y.a(this.c.get(), 20, 0)) {
            u.f("NativeVideoController", "onStateError 出错后展示结果页、、、、、、、");
            this.b.a(this.r, this.n, false);
            d(true);
            m();
        }
    }

    private void H() {
        u.b("NativeVideoController", "before auseWhenInvisible、、、、、、、");
        if (this.c.get() != null && !y.a(this.c.get(), 20, 0)) {
            u.b("NativeVideoController", "in pauseWhenInvisible、、、、、、、");
            i();
        }
    }

    private void I() {
        int i;
        int i2;
        u.b("ChangeVideoSize", "[step-0]  TAG is 'ChangeVideoSize' ....... start  changeVideoSize >>>>>>>>>>>>>>>>>>>>>>>");
        try {
            if (this.n == null || this.n.get() == null || J() == null || this.g == null || this.g.a() == null || this.c == null || this.c.get() == null) {
                u.b("ChangeVideoSize", "[step-1] >>>>> mContextRef=" + this.n + ",mContextRef.get()=" + (this.n != null ? this.n.get() : null) + ",getIRenderView() =" + J());
                u.b("ChangeVideoSize", "[step-1] >>>>> mMediaPlayerProxy == null:" + (this.g == null) + ",mMediaPlayerProxy.getMediaPlayer() == null:" + (this.g != null && this.g.a() == null));
                return;
            }
            MediaPlayer a2 = this.g.a();
            int videoWidth = a2.getVideoWidth();
            int videoHeight = a2.getVideoHeight();
            int width = this.c.get().getWidth();
            int height = this.c.get().getHeight();
            if (width <= 0 || height <= 0 || videoHeight <= 0 || videoWidth <= 0) {
                u.b("ChangeVideoSize", " container or video exist size <= 0");
                return;
            }
            if (videoWidth == videoHeight) {
                if (width > height) {
                    i2 = height;
                    i = height;
                } else {
                    i2 = width;
                    i = width;
                }
            } else if (videoWidth > videoHeight) {
                i2 = (int) ((width * 1.0d) / ((videoWidth * 1.0f) / videoHeight));
                i = width;
            } else {
                i = (int) ((height * 1.0d) / ((videoHeight * 1.0f) / videoWidth));
                i2 = height;
            }
            if (i2 > height || i2 <= 0) {
                i2 = height;
            }
            if (i > width || i <= 0) {
                i = width;
            }
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
            layoutParams.addRule(13);
            if (J() instanceof TextureView) {
                ((TextureView) J()).setLayoutParams(layoutParams);
                u.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to TextureView complete ! >>>>>>>");
            } else if (J() instanceof SurfaceView) {
                ((SurfaceView) J()).setLayoutParams(layoutParams);
                u.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to SurfaceView complete !>>>>>>>");
            }
        } catch (Throwable th) {
            u.b("ChangeVideoSize", "[step-11] >>>>> changeVideoSize error !!!!! ：" + th.toString());
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b J() {
        if (this.n == null || this.n.get() == null || this.n.get().getResources().getConfiguration().orientation != 1 || this.b == null) {
            return null;
        }
        return this.b.o();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view) {
        if (this.g != null && C()) {
            if (this.g.g()) {
                h();
                this.b.b(true, false);
                this.b.c();
            } else if (!this.g.i()) {
                if (this.b != null) {
                    this.b.c(this.c.get());
                }
                d(this.i);
                if (this.b != null) {
                    this.b.b(false, false);
                }
            } else {
                g(false);
                if (this.b != null) {
                    this.b.b(false, false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i) {
        if (this.g != null) {
            A();
            a(this.T, c(i));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, int i) {
        if (this.g != null) {
            B();
        }
        if (this.b != null) {
            this.b.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i, boolean z) {
        if (C()) {
            long l = (((float) (i * this.k)) * 1.0f) / ac.l(this.n.get(), "tt_video_progress_max");
            if (this.k > 0) {
                this.T = (int) l;
            } else {
                this.T = 0L;
            }
            if (this.b != null) {
                this.b.a(this.T);
            }
        }
    }

    private void a(long j, long j2) {
        this.i = j;
        this.k = j2;
        this.b.a(j, j2);
        this.b.a(com.bytedance.sdk.openadsdk.core.video.e.a.a(j, j2));
        try {
            if (this.h != null) {
                this.h.a(j, j2);
            }
        } catch (Throwable th) {
            u.c("NativeVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, View view) {
        b(bVar, view, false, false);
    }

    public void b(b bVar, View view, boolean z, boolean z2) {
        if (C()) {
            h(!this.S);
            if (!(this.n.get() instanceof Activity)) {
                u.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.S) {
                a(z ? 8 : 0);
                if (this.b != null) {
                    this.b.a(this.c.get());
                    this.b.b(false);
                }
            } else {
                a(1);
                if (this.b != null) {
                    this.b.b(this.c.get());
                    this.b.b(false);
                }
            }
            e eVar = this.x != null ? this.x.get() : null;
            if (eVar != null) {
                eVar.a(this.S);
            }
        }
    }

    public void a(int i) {
        if (C()) {
            boolean z = i == 0 || i == 8;
            Context context = this.n.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable th) {
                }
                if (!z) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void c(b bVar, View view) {
        if (this.b != null) {
            this.b.g();
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view, boolean z, boolean z2) {
        if (this.s) {
            h();
        }
        if (z && !this.s && !d()) {
            this.b.b(!e(), false);
            this.b.a(z2, true, false);
        }
        if (this.g != null && this.g.g()) {
            this.b.c();
            this.b.b();
            return;
        }
        this.b.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(b bVar, View view) {
        if (this.S) {
            h(false);
            if (this.b != null) {
                this.b.b(this.c.get());
            }
            a(1);
            return;
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(b bVar, View view) {
        a(bVar, view, false);
    }

    public void a(b bVar, View view, boolean z) {
        K();
    }

    private void K() {
        if (C()) {
            h(!this.S);
            if (!(this.n.get() instanceof Activity)) {
                u.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.b != null) {
                this.b.b(this.c.get());
                this.b.b(false);
            }
            a(1);
            e eVar = this.x != null ? this.x.get() : null;
            if (eVar != null) {
                eVar.a(this.S);
            }
        }
    }

    private void h(boolean z) {
        this.S = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(b bVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder) {
        this.m = true;
        if (this.g != null) {
            this.g.a(this.m);
        }
        if (this.g != null) {
            this.g.a(surfaceHolder);
            D();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceHolder surfaceHolder) {
        this.m = false;
        if (this.g != null) {
            this.g.a(this.m);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceTexture surfaceTexture) {
        this.m = true;
        if (this.g != null) {
            this.g.a(this.m);
        }
        if (this.g != null) {
            this.g.a(surfaceTexture);
            D();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceTexture surfaceTexture) {
        this.m = false;
        if (this.g != null) {
            this.g.a(this.m);
        }
    }

    public boolean d() {
        return this.g == null || this.g.l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void g() {
        if (x.c(p.a()) != 0) {
            m();
            a(this.r.R().i(), this.r.ag(), this.G, this.H, null, this.r.aj(), 0L, b());
            d(false);
        }
    }

    public boolean e() {
        return this.g != null && this.g.g();
    }

    private void a(long j, boolean z) {
        if (this.g != null) {
            if (z) {
                L();
            }
            this.g.a(j);
        }
    }

    private boolean c(int i) {
        return this.b.b(i);
    }

    private void L() {
        if (this.b != null) {
            this.b.c(0);
            this.b.a(false, false);
            this.b.b(false);
            this.b.b();
            this.b.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(h.a aVar, String str) {
        switch (aVar) {
            case PAUSE_VIDEO:
                h();
                return;
            case RELEASE_VIDEO:
                a(true);
                return;
            case START_VIDEO:
                k();
                this.z = false;
                this.A = true;
                return;
            default:
                return;
        }
    }

    private boolean d(int i) {
        int c = x.c(p.a());
        if (c == 0) {
            h();
            this.z = true;
            if (this.b != null) {
                this.b.a(this.r, this.n, false);
            }
        }
        if (c != 4 && c != 0) {
            if (this.b != null) {
                this.b.e();
            }
            h();
            this.z = true;
            this.A = false;
            if (this.b == null || this.r == null) {
                return true;
            }
            return this.b.a(i, this.r.R(), this.w);
        } else if (c == 4) {
            this.z = false;
            if (this.b != null) {
                this.b.q();
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private void a(Context context, int i) {
        if (C() && context != null && this.V != i) {
            this.V = i;
            if (i != 4 && i != 0) {
                this.A = false;
            }
            if (!this.A && !w() && this.v) {
                d(2);
            }
            if (this.F != null && this.F.get() != null) {
                this.F.get().a(this.V);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        int c = x.c(context);
        a(context, c);
        if (c == 4) {
            this.z = false;
        }
    }

    public void a(Context context) {
        int c = x.c(context);
        a(context, c);
        if (c == 4) {
            this.z = false;
            k();
        }
    }

    public void f() {
        if (!this.W && this.K) {
            Context applicationContext = p.a().getApplicationContext();
            this.W = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                applicationContext.registerReceiver(this.U, intentFilter);
            } catch (Exception e) {
            }
        }
    }

    public void y() {
        if (this.W && this.K) {
            Context applicationContext = p.a().getApplicationContext();
            this.W = false;
            try {
                applicationContext.unregisterReceiver(this.U);
            } catch (Exception e) {
            }
        }
    }

    public void a(a aVar) {
        this.F = new WeakReference<>(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        this.B = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
        this.D = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean x() {
        return this.J;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z) {
        this.K = z;
    }

    private boolean c(int i, int i2) {
        u.b("TTVideoWebPageActivity", "OnError - Error code: " + i + " Extra code: " + i2);
        boolean z = false;
        switch (i) {
            case -1010:
            case -1007:
            case -1004:
            case -110:
            case 100:
            case 200:
                z = true;
                break;
        }
        switch (i2) {
            case 1:
            case 700:
            case 800:
                return true;
            default:
                return z;
        }
    }
}
