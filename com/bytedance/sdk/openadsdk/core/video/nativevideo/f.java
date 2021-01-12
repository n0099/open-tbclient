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
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.am;
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
/* loaded from: classes4.dex */
public class f implements c, d, am.a {
    private WeakReference<c.InterfaceC1007c> C;
    private WeakReference<a> D;
    private int E;
    private int F;
    private long R;
    private int T;

    /* renamed from: b  reason: collision with root package name */
    private h f6726b;
    private final WeakReference<ViewGroup> c;
    private com.bytedance.sdk.openadsdk.core.video.c.d g;
    private c.a h;
    private long k;
    private List<Runnable> l;
    private boolean m;
    private final WeakReference<Context> n;
    private final boolean o;
    private final l r;
    private String u;
    private WeakReference<e> v;
    private final am d = new am(this);
    private long e = 0;
    private long f = 0;
    private long i = 0;
    private long j = 0;
    private boolean p = false;
    private boolean q = false;
    private boolean s = true;
    private boolean t = false;
    private long w = 0;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;
    private boolean A = false;
    private boolean B = true;
    private int G = 0;
    private boolean H = false;
    private boolean I = true;
    private final Runnable J = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.g != null) {
                f.this.g.e();
            }
        }
    };
    private final Runnable K = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.h != null) {
                f.this.h.a();
            }
        }
    };
    private final Runnable L = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.5
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
    private int M = 0;
    private long N = 0;

    /* renamed from: a  reason: collision with root package name */
    Runnable f6725a = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.6
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f6726b != null) {
                f.this.f6726b.a(f.this.r, f.this.n, false);
                f.this.f6726b.w();
                f.this.d(true);
                u.f("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    private long O = 0;
    private long P = 0;
    private boolean Q = false;
    private final BroadcastReceiver S = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.7
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
    private boolean U = false;

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i);

        void e();
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        if (this.f6726b != null) {
            this.f6726b.a(drawVideoListener);
        }
    }

    public void a(final NativeVideoTsView.b bVar) {
        if (this.s && this.f6726b != null) {
            this.f6726b.a(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.1
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
            this.E = i;
            this.F = i2;
            u.b("NativeVideoController", "width=" + i + "height=" + i2);
        }
    }

    private boolean z() {
        u.b("NativeVideoController", "retryCount=" + this.G);
        if (1 <= this.G) {
            if (this.f6726b != null) {
                this.f6726b.w();
                this.f6726b.a(this.r, this.n, false);
                return false;
            }
            return false;
        } else if (this.g != null) {
            this.G++;
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
                this.f6726b = new h(context, inflate, true, noneOf, this.r, this, a());
            } else {
                this.f6726b = new g(context, inflate, true, noneOf, this.r, this, false);
            }
            this.f6726b.a(this);
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

    public f(Context context, ViewGroup viewGroup, l lVar, String str, boolean z) {
        this.u = "embeded_ad";
        this.E = 0;
        this.F = 0;
        this.T = 1;
        this.T = x.c(context);
        b(z);
        this.u = str;
        try {
            this.E = viewGroup.getWidth();
            this.F = viewGroup.getHeight();
        } catch (Throwable th) {
        }
        this.c = new WeakReference<>(viewGroup);
        this.n = new WeakReference<>(context);
        this.r = lVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17;
    }

    public f(Context context, ViewGroup viewGroup, l lVar, String str) {
        this.u = "embeded_ad";
        this.E = 0;
        this.F = 0;
        this.T = 1;
        this.T = x.c(context);
        try {
            this.E = viewGroup.getWidth();
            this.F = viewGroup.getHeight();
        } catch (Throwable th) {
        }
        this.c = new WeakReference<>(viewGroup);
        this.u = str;
        this.n = new WeakReference<>(context);
        this.r = lVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public h u() {
        return this.f6726b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC1007c interfaceC1007c) {
        this.C = new WeakReference<>(interfaceC1007c);
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
        if (this.f6726b != null) {
            this.f6726b.e();
            if (this.M == 0) {
                this.f6726b.d();
            }
            this.f6726b.c(i, i2);
            this.f6726b.c(this.c.get());
            this.f6726b.a(i, i2);
        }
        if (this.g == null) {
            this.g = new com.bytedance.sdk.openadsdk.core.video.c.d(this.d);
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
    public com.bytedance.sdk.openadsdk.core.video.c.d t() {
        return this.g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long m() {
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
        if (this.f6726b != null) {
            this.f6726b.c(z);
        }
    }

    public boolean a() {
        return this.s;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean s() {
        return this.x;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j) {
        this.w = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long r() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j) {
        this.k = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long o() {
        if (this.g == null) {
            return 0L;
        }
        return this.g.o() + this.w;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long p() {
        return 0L;
    }

    public boolean b() {
        return this.t;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        this.t = z;
        if (this.g != null) {
            this.g.a(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean v() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int q() {
        return com.bytedance.sdk.openadsdk.core.video.d.a.a(this.j, this.k);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
    }

    private void a(String str) {
        u.b("tag_video_play", "[video] NativeVideoController#playVideo has invoke !");
        if (this.g != null) {
            com.bytedance.sdk.openadsdk.core.video.a.a aVar = new com.bytedance.sdk.openadsdk.core.video.a.a();
            aVar.f6687a = str;
            if (this.r != null) {
                if (this.r.F() != null) {
                    aVar.d = this.r.F().k();
                }
                aVar.f6688b = String.valueOf(aj.d(this.r.W()));
            }
            aVar.c = 0;
            this.g.a(aVar);
            u.b("tag_video_play", "[video] MediaPlayerProxy has setDataSource !");
        }
        this.e = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.f6726b.d(8);
            this.f6726b.d(0);
            a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.2
                @Override // java.lang.Runnable
                public void run() {
                    f.this.e = System.currentTimeMillis();
                    f.this.f6726b.c(0);
                    if (f.this.g == null || f.this.i != 0) {
                        if (f.this.g != null) {
                            f.this.g.a(true, f.this.i, f.this.t ? false : true);
                        }
                    } else {
                        f.this.g.a(true, 0L, f.this.t ? false : true);
                    }
                    if (f.this.d != null) {
                        f.this.d.postDelayed(f.this.J, 100L);
                    }
                    f.this.A();
                }
            });
        }
        if (this.s) {
            x();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        B();
        this.d.postDelayed(this.L, 800L);
    }

    private void B() {
        this.d.removeCallbacks(this.L);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        this.v = new WeakReference<>(eVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        if (t() == null) {
            return 0L;
        }
        return t().n();
    }

    private void b(int i) {
        this.M++;
        if (C() && this.f6726b != null) {
            this.f6726b.w();
            if (this.h != null) {
                this.h.a(this.f, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.i, this.k));
            }
            this.f = System.currentTimeMillis() - this.e;
            if (!aj.b(this.r) || this.M >= 2) {
                this.f6726b.a(this.r, this.n, true);
            }
            if (!this.q) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_over", o(), 100, c());
                this.q = true;
                a(this.k, this.k);
                long j = this.k;
                this.i = j;
                this.j = j;
            }
            if (!this.s && this.Q) {
                e(this.f6726b, null);
            }
            this.z = true;
            if (aj.b(this.r) && this.M < 2) {
                g();
            }
        }
    }

    private boolean C() {
        return (this.n == null || this.n.get() == null) ? false : true;
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            if (this.f6726b.k() && this.m) {
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
        return aj.a(this.r, n(), t());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void h() {
        if (this.g != null) {
            this.g.b();
        }
        if (!this.q && this.p) {
            if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", true)) {
                    com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", o(), q(), c());
                }
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", (Boolean) true);
                return;
            }
            if (com.bytedance.sdk.openadsdk.core.u.a().b()) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", o(), q(), c());
            }
            com.bytedance.sdk.openadsdk.core.u.a().a(true);
        }
    }

    public void d() {
        if (this.g != null) {
            this.g.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        if (this.g != null) {
            this.g.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        if (this.f6726b != null) {
            this.f6726b.e();
        }
        if (this.f6726b != null) {
            this.f6726b.u();
        }
        E();
    }

    public void g(boolean z) {
        if (this.f6726b != null) {
            this.f6726b.e();
        }
        if (this.f6726b != null && z) {
            this.f6726b.u();
        }
        E();
    }

    private void E() {
        if (this.g != null) {
            this.g.a(false, this.i, !this.t);
            A();
        }
        if (this.p) {
            com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_continue", o(), q(), c());
        }
    }

    public void d(long j) {
        this.i = j;
        this.j = this.j > this.i ? this.j : this.i;
        if (this.f6726b != null) {
            this.f6726b.e();
        }
        if (this.g != null) {
            this.g.a(true, this.i, !this.t);
            A();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        a(true);
    }

    public void e(long j) {
        this.N = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z) {
        if (this.s) {
            this.N = o();
        }
        if (!this.q && this.p) {
            if (z) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_break", this.N, q(), c());
                this.q = false;
            } else {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", this.N, q(), c());
            }
        }
        l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        if (this.g != null) {
            this.g.c();
            this.g = null;
        }
        if (!aj.b(this.r) || this.M == 2) {
            this.f6726b.a(this.r, this.n, true);
        }
        if (this.d != null) {
            this.d.removeCallbacks(this.L);
            this.d.removeCallbacks(this.K);
            this.d.removeCallbacks(this.J);
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
        this.P = SystemClock.elapsedRealtime() - this.O;
        if (!this.p) {
            Map<String, Object> a2 = aj.a(this.P, this.r, t());
            if (this.B) {
                com.bytedance.sdk.openadsdk.c.d.c(this.n.get(), this.r, this.u, "feed_auto_play", a2);
            } else if (this.i <= 0) {
                com.bytedance.sdk.openadsdk.c.d.c(this.n.get(), this.r, this.u, "feed_play", a2);
            }
            this.p = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (this.f6726b != null && message != null && this.n != null && this.n.get() != null) {
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
                    if (!f() || i2 == -1004) {
                        u.f("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + i + "," + i2);
                        if (c(i, i2)) {
                            u.f("NativeVideoController", "出错后展示结果页、、、、、、、");
                            this.f6726b.a(this.r, this.n, false);
                            d(true);
                            l();
                        }
                        if (this.f6726b != null) {
                            this.f6726b.w();
                        }
                        if (this.h != null) {
                            this.h.b(this.f, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.i, this.k));
                        }
                        if (this.C != null && this.C.get() != null && !f()) {
                            this.C.get().a(i, i2);
                            return;
                        }
                        return;
                    }
                    return;
                case 304:
                    int i3 = message.arg1;
                    if (this.f6726b != null) {
                        if (i3 == 3 || i3 == 702) {
                            this.f6726b.w();
                            this.d.removeCallbacks(this.f6725a);
                            this.H = false;
                        } else if (i3 == 701) {
                            this.f6726b.t();
                            this.d.postDelayed(this.f6725a, 8000L);
                            this.H = true;
                        }
                    }
                    if (this.o && i3 == 3) {
                        if (this.s && this.D != null && this.D.get() != null) {
                            this.D.get().e();
                        }
                        this.d.removeCallbacks(this.f6725a);
                    }
                    if (this.o && i3 == 3) {
                        F();
                        return;
                    }
                    return;
                case 305:
                    if (this.C != null && this.C.get() != null) {
                        this.C.get().f();
                    }
                    if (this.d != null) {
                        this.d.removeCallbacks(this.K);
                    }
                    if (!this.o) {
                        F();
                    }
                    if (this.f6726b != null) {
                        this.f6726b.w();
                    }
                    this.d.removeCallbacks(this.f6725a);
                    return;
                case ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA /* 306 */:
                    if (this.f6726b != null) {
                        this.f6726b.w();
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
                        l();
                        this.g = null;
                        a(this.r.F().h(), this.r.T(), this.E, this.F, null, this.r.W(), 0L, b());
                        return;
                    }
                    u.c("NativeVideoController", "不满足条件，无法重试");
                    return;
                case 313:
                    H();
                    return;
                case 314:
                    try {
                        ((Boolean) message.obj).booleanValue();
                    } catch (Throwable th) {
                    }
                    this.O = SystemClock.elapsedRealtime();
                    return;
                default:
                    return;
            }
        }
    }

    private void b(int i, int i2) {
        if (this.r != null) {
            boolean f = f();
            String str = f ? "play_error" : "play_start_error";
            Map<String, Object> a2 = aj.a(this.r, i, i2, t());
            if (f) {
                a2.put("duration", Long.valueOf(o()));
                a2.put("percent", Integer.valueOf(q()));
                a2.put("buffers_time", Long.valueOf(n()));
            }
            com.bytedance.sdk.openadsdk.c.d.d(this.n.get(), this.r, this.u, str, a2);
        }
    }

    private void G() {
        if (this.c.get() != null && !y.a(this.c.get(), 20, 0)) {
            u.f("NativeVideoController", "onStateError 出错后展示结果页、、、、、、、");
            this.f6726b.a(this.r, this.n, false);
            d(true);
            l();
        }
    }

    private void H() {
        u.b("NativeVideoController", "before auseWhenInvisible、、、、、、、");
        if (this.c.get() != null && !y.a(this.c.get(), 20, 0)) {
            u.b("NativeVideoController", "in pauseWhenInvisible、、、、、、、");
            d();
        }
    }

    private void I() {
        RelativeLayout.LayoutParams layoutParams = null;
        u.b("ChangeVideoSize", "[step-0]  TAG is 'ChangeVideoSize' ....... start  changeVideoSize >>>>>>>>>>>>>>>>>>>>>>>");
        try {
            if (this.n == null || this.n.get() == null || J() == null || this.g == null || this.g.a() == null) {
                u.b("ChangeVideoSize", "[step-1] >>>>> mContextRef=" + this.n + ",mContextRef.get()=" + (this.n != null ? this.n.get() : null) + ",getIRenderView() =" + J());
                StringBuilder append = new StringBuilder().append("[step-1] >>>>> mMediaPlayerProxy == null:").append(this.g == null).append(",mMediaPlayerProxy.getMediaPlayer() == null:");
                if (this.g == null || this.g.a() != null) {
                    r3 = false;
                }
                u.b("ChangeVideoSize", append.append(r3).toString());
                return;
            }
            boolean z = this.n.get().getResources().getConfiguration().orientation == 1;
            u.b("ChangeVideoSize", "[step-2] >>>>> isVectical=" + z);
            float c = ak.c(this.n.get());
            u.b("ChangeVideoSize", "[step-3] >>>>> screenWidth=" + c + ",screenHeight=" + ak.d(this.n.get()));
            MediaPlayer a2 = this.g.a();
            float videoWidth = a2.getVideoWidth();
            float videoHeight = a2.getVideoHeight();
            u.b("ChangeVideoSize", "[step-4] Get the videoWidth and videoHeight from mediaPlayer , videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
            if (videoWidth < videoHeight || videoHeight <= 0.0f || videoWidth <= 0.0f) {
                u.b("ChangeVideoSize", "[step-5] >> (videoWidth < videoHeight || videoHeight <= 0 || videoWidth <= 0) ->value:>>" + (videoWidth < videoHeight) + ">>, if value is false: continue to perform ....");
                return;
            }
            u.b("ChangeVideoSize", "[step-5] >>  videoWidth < videoHeight ->value:>>" + (videoWidth < videoHeight) + ">>, if value is false: continue to perform ....");
            float f = z ? (videoHeight * c) / videoWidth : 0.0f;
            u.b("ChangeVideoSize", "[step-6] >>>>> vHeight = (videoHeight * screenWidth) / videoWidth --> calculate the adaptive height , vHeight=" + f);
            if (!Float.valueOf(f).isNaN()) {
                u.b("ChangeVideoSize", "[step-7]  >>>>> vHeight check pass !");
                if (z) {
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) c, (int) f);
                    layoutParams2.addRule(13);
                    layoutParams = layoutParams2;
                }
                if (layoutParams != null) {
                    u.b("ChangeVideoSize", "[step-8] >>>>> create LayoutParams finish ! >> screenWidth = " + c + "，vHeight =" + f);
                    if (J() instanceof TextureView) {
                        ((TextureView) J()).setLayoutParams(layoutParams);
                        u.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to TextureView complete ! >>>>>>>");
                    } else if (J() instanceof SurfaceView) {
                        ((SurfaceView) J()).setLayoutParams(layoutParams);
                        u.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to SurfaceView complete !>>>>>>>");
                    }
                    u.b("ChangeVideoSize", "[step-10] end : changeVideoSize has complete ! >>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
                }
            }
        } catch (Throwable th) {
            u.b("ChangeVideoSize", "[step-11] >>>>> changeVideoSize error !!!!! ：" + th.toString());
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b J() {
        if (this.n == null || this.n.get() == null || this.n.get().getResources().getConfiguration().orientation != 1 || this.f6726b == null) {
            return null;
        }
        return this.f6726b.o();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view) {
        if (this.g != null && C()) {
            if (this.g.g()) {
                h();
                this.f6726b.b(true, false);
                this.f6726b.c();
            } else if (!this.g.i()) {
                if (this.f6726b != null) {
                    this.f6726b.c(this.c.get());
                }
                d(this.i);
                if (this.f6726b != null) {
                    this.f6726b.b(false, false);
                }
            } else {
                g(false);
                if (this.f6726b != null) {
                    this.f6726b.b(false, false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i) {
        if (this.g != null) {
            A();
            a(this.R, c(i));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, int i) {
        if (this.g != null) {
            B();
        }
        if (this.f6726b != null) {
            this.f6726b.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i, boolean z) {
        if (C()) {
            long l = (((float) (i * this.k)) * 1.0f) / ac.l(this.n.get(), "tt_video_progress_max");
            if (this.k > 0) {
                this.R = (int) l;
            } else {
                this.R = 0L;
            }
            if (this.f6726b != null) {
                this.f6726b.a(this.R);
            }
        }
    }

    private void a(long j, long j2) {
        this.i = j;
        this.k = j2;
        this.f6726b.a(j, j2);
        this.f6726b.a(com.bytedance.sdk.openadsdk.core.video.d.a.a(j, j2));
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
            h(!this.Q);
            if (!(this.n.get() instanceof Activity)) {
                u.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.Q) {
                a(z ? 8 : 0);
                if (this.f6726b != null) {
                    this.f6726b.a(this.c.get());
                    this.f6726b.b(false);
                }
            } else {
                a(1);
                if (this.f6726b != null) {
                    this.f6726b.b(this.c.get());
                    this.f6726b.b(false);
                }
            }
            e eVar = this.v != null ? this.v.get() : null;
            if (eVar != null) {
                eVar.a(this.Q);
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
        if (this.f6726b != null) {
            this.f6726b.g();
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view, boolean z, boolean z2) {
        if (this.s) {
            h();
        }
        if (z && !this.s && !e()) {
            this.f6726b.b(!f(), false);
            this.f6726b.a(z2, true, false);
        }
        if (this.g != null && this.g.g()) {
            this.f6726b.c();
            this.f6726b.b();
            return;
        }
        this.f6726b.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(b bVar, View view) {
        if (this.Q) {
            h(false);
            if (this.f6726b != null) {
                this.f6726b.b(this.c.get());
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
            h(!this.Q);
            if (!(this.n.get() instanceof Activity)) {
                u.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.f6726b != null) {
                this.f6726b.b(this.c.get());
                this.f6726b.b(false);
            }
            a(1);
            e eVar = this.v != null ? this.v.get() : null;
            if (eVar != null) {
                eVar.a(this.Q);
            }
        }
    }

    private void h(boolean z) {
        this.Q = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(b bVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder) {
        this.m = true;
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
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceTexture surfaceTexture) {
        this.m = true;
        if (this.g != null) {
            this.g.a(surfaceTexture);
            D();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceTexture surfaceTexture) {
        this.m = false;
    }

    public boolean e() {
        return this.g == null || this.g.l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void g() {
        if (x.c(p.a()) != 0) {
            l();
            a(this.r.F().h(), this.r.T(), this.E, this.F, null, this.r.W(), 0L, b());
            d(false);
        }
    }

    public boolean f() {
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
        return this.f6726b.b(i);
    }

    private void L() {
        if (this.f6726b != null) {
            this.f6726b.c(0);
            this.f6726b.a(false, false);
            this.f6726b.b(false);
            this.f6726b.b();
            this.f6726b.d();
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
                j();
                this.x = false;
                this.y = true;
                return;
            default:
                return;
        }
    }

    private boolean d(int i) {
        int c = x.c(p.a());
        if (c == 0) {
            h();
            this.x = true;
            if (this.f6726b != null) {
                this.f6726b.a(this.r, this.n, false);
            }
        }
        if (c != 4 && c != 0) {
            if (this.f6726b != null) {
                this.f6726b.e();
            }
            h();
            this.x = true;
            this.y = false;
            if (this.f6726b == null || this.r == null) {
                return true;
            }
            return this.f6726b.a(i, this.r.F());
        } else if (c == 4) {
            this.x = false;
            if (this.f6726b != null) {
                this.f6726b.q();
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    private void a(Context context, int i) {
        if (C() && context != null && this.T != i) {
            this.T = i;
            if (i != 4 && i != 0) {
                this.y = false;
            }
            if (!this.y && !v()) {
                d(2);
            }
            if (this.D != null && this.D.get() != null) {
                this.D.get().a(this.T);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        int c = x.c(context);
        a(context, c);
        if (c == 4) {
            this.x = false;
        }
    }

    public void a(Context context) {
        int c = x.c(context);
        a(context, c);
        if (c == 4) {
            this.x = false;
            j();
        }
    }

    public void x() {
        if (!this.U && this.I) {
            Context applicationContext = p.a().getApplicationContext();
            this.U = true;
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                applicationContext.registerReceiver(this.S, intentFilter);
            } catch (Exception e) {
            }
        }
    }

    public void y() {
        if (this.U && this.I) {
            Context applicationContext = p.a().getApplicationContext();
            this.U = false;
            try {
                applicationContext.unregisterReceiver(this.S);
            } catch (Exception e) {
            }
        }
    }

    public void a(a aVar) {
        this.D = new WeakReference<>(aVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        this.z = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
        this.B = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        return this.H;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z) {
        this.I = z;
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
