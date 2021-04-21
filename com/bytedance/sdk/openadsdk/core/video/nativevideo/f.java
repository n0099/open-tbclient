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
import com.baidu.sapi2.SapiOptions;
import com.baidu.tbadk.core.util.resourceLoaderProc.BigImageLoaderProc;
import com.bytedance.sdk.openadsdk.TTDrawFeedAd;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.widget.h;
import com.bytedance.sdk.openadsdk.core.y;
import com.bytedance.sdk.openadsdk.utils.ad;
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
/* loaded from: classes5.dex */
public class f implements c, d, am.a {
    public WeakReference<c.InterfaceC0317c> E;
    public WeakReference<a> F;
    public int G;
    public int H;
    public long T;
    public int V;

    /* renamed from: b  reason: collision with root package name */
    public h f28414b;

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<ViewGroup> f28415c;

    /* renamed from: g  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.video.d.d f28419g;

    /* renamed from: h  reason: collision with root package name */
    public c.a f28420h;
    public long k;
    public List<Runnable> l;
    public final WeakReference<Context> n;
    public final boolean o;
    public final l r;
    public String u;
    public boolean v;
    public boolean w;
    public WeakReference<e> x;

    /* renamed from: d  reason: collision with root package name */
    public final am f28416d = new am(this);

    /* renamed from: e  reason: collision with root package name */
    public long f28417e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f28418f = 0;
    public long i = 0;
    public long j = 0;
    public boolean m = false;
    public boolean p = false;
    public boolean q = false;
    public boolean s = true;
    public boolean t = false;
    public long y = 0;
    public boolean z = false;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public boolean D = true;
    public int I = 0;
    public boolean J = false;
    public boolean K = true;
    public final Runnable L = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f28419g != null) {
                f.this.f28419g.e();
            }
        }
    };
    public final Runnable M = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f28420h != null) {
                f.this.f28420h.a();
            }
        }
    };
    public final Runnable N = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.5
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f28419g != null) {
                if (f.this.k <= 0) {
                    f.this.f28419g.e();
                }
                f.this.f28419g.f();
            }
            f.this.f28416d.postDelayed(this, 200L);
        }
    };
    public int O = 0;
    public long P = 0;

    /* renamed from: a  reason: collision with root package name */
    public Runnable f28413a = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.6
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.f28414b != null) {
                f.this.f28414b.a(f.this.r, f.this.n, false);
                f.this.f28414b.w();
                f.this.d(true);
                u.f("NativeVideoController", "出错后展示结果页、、、、、、、showAdCard");
            }
        }
    };
    public long Q = 0;
    public long R = 0;
    public boolean S = false;
    public final BroadcastReceiver U = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.7
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
    public boolean W = false;

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.f$8  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass8 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28429a;

        static {
            int[] iArr = new int[h.a.values().length];
            f28429a = iArr;
            try {
                iArr[h.a.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28429a[h.a.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28429a[h.a.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i);

        void g();
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
        } catch (Throwable unused) {
        }
        this.f28415c = new WeakReference<>(viewGroup);
        this.n = new WeakReference<>(context);
        this.r = lVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17;
        this.v = z2;
        this.w = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        B();
        this.f28416d.postDelayed(this.N, 800L);
    }

    private void B() {
        this.f28416d.removeCallbacks(this.N);
    }

    private boolean C() {
        WeakReference<Context> weakReference = this.n;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void D() {
        List<Runnable> list = this.l;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.l).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.l.clear();
    }

    private void E() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar != null) {
            dVar.a(false, this.i, !this.t);
            A();
        }
        if (this.p) {
            com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_continue", p(), r(), c());
        }
    }

    private void F() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.Q;
        this.R = elapsedRealtime;
        if (this.p) {
            return;
        }
        Map<String, Object> a2 = ak.a(elapsedRealtime, this.r, u());
        if (this.D) {
            com.bytedance.sdk.openadsdk.c.d.c(this.n.get(), this.r, this.u, "feed_auto_play", a2);
        } else if (this.i <= 0) {
            com.bytedance.sdk.openadsdk.c.d.c(this.n.get(), this.r, this.u, "feed_play", a2);
        }
        this.p = true;
    }

    private void G() {
        if (this.f28415c.get() == null || y.a(this.f28415c.get(), 20, 0)) {
            return;
        }
        u.f("NativeVideoController", "onStateError 出错后展示结果页、、、、、、、");
        this.f28414b.a(this.r, this.n, false);
        d(true);
        m();
    }

    private void H() {
        u.b("NativeVideoController", "before auseWhenInvisible、、、、、、、");
        if (this.f28415c.get() == null || y.a(this.f28415c.get(), 20, 0)) {
            return;
        }
        u.b("NativeVideoController", "in pauseWhenInvisible、、、、、、、");
        i();
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0094, code lost:
        if (r2 > 0) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0097, code lost:
        r3 = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void I() {
        int i;
        int i2;
        u.b("ChangeVideoSize", "[step-0]  TAG is 'ChangeVideoSize' ....... start  changeVideoSize >>>>>>>>>>>>>>>>>>>>>>>");
        try {
            if (this.n != null && this.n.get() != null && J() != null && this.f28419g != null && this.f28419g.a() != null && this.f28415c != null && this.f28415c.get() != null) {
                MediaPlayer a2 = this.f28419g.a();
                int videoWidth = a2.getVideoWidth();
                int videoHeight = a2.getVideoHeight();
                int width = this.f28415c.get().getWidth();
                int height = this.f28415c.get().getHeight();
                if (width > 0 && height > 0 && videoHeight > 0 && videoWidth > 0) {
                    if (videoWidth == videoHeight) {
                        i2 = width > height ? height : width;
                        i = i2;
                    } else if (videoWidth > videoHeight) {
                        i2 = (int) ((width * 1.0d) / ((videoWidth * 1.0f) / videoHeight));
                        i = width;
                    } else {
                        i = (int) ((height * 1.0d) / ((videoHeight * 1.0f) / videoWidth));
                        i2 = height;
                    }
                    if (i2 <= height && i2 > 0) {
                        height = i2;
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
                    layoutParams.addRule(13);
                    if (J() instanceof TextureView) {
                        ((TextureView) J()).setLayoutParams(layoutParams);
                        u.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to TextureView complete ! >>>>>>>");
                        return;
                    } else if (J() instanceof SurfaceView) {
                        ((SurfaceView) J()).setLayoutParams(layoutParams);
                        u.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to SurfaceView complete !>>>>>>>");
                        return;
                    } else {
                        return;
                    }
                }
                u.b("ChangeVideoSize", " container or video exist size <= 0");
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[step-1] >>>>> mContextRef=");
            sb.append(this.n);
            sb.append(",mContextRef.get()=");
            sb.append(this.n != null ? this.n.get() : null);
            sb.append(",getIRenderView() =");
            sb.append(J());
            u.b("ChangeVideoSize", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[step-1] >>>>> mMediaPlayerProxy == null:");
            boolean z = true;
            sb2.append(this.f28419g == null);
            sb2.append(",mMediaPlayerProxy.getMediaPlayer() == null:");
            if (this.f28419g == null || this.f28419g.a() != null) {
                z = false;
            }
            sb2.append(z);
            u.b("ChangeVideoSize", sb2.toString());
        } catch (Throwable th) {
            u.b("ChangeVideoSize", "[step-11] >>>>> changeVideoSize error !!!!! ：" + th.toString());
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b J() {
        h hVar;
        WeakReference<Context> weakReference = this.n;
        if (weakReference == null || weakReference.get() == null || this.n.get().getResources().getConfiguration().orientation != 1 || (hVar = this.f28414b) == null) {
            return null;
        }
        return hVar.o();
    }

    private void K() {
        if (C()) {
            h(!this.S);
            if (!(this.n.get() instanceof Activity)) {
                u.b("NativeVideoController", "context is not activity, not support this function.");
                return;
            }
            h hVar = this.f28414b;
            if (hVar != null) {
                hVar.b(this.f28415c.get());
                this.f28414b.b(false);
            }
            a(1);
            WeakReference<e> weakReference = this.x;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.S);
            }
        }
    }

    private void L() {
        h hVar = this.f28414b;
        if (hVar != null) {
            hVar.c(0);
            this.f28414b.a(false, false);
            this.f28414b.b(false);
            this.f28414b.b();
            this.f28414b.d();
        }
    }

    private boolean z() {
        u.b("NativeVideoController", "retryCount=" + this.I);
        int i = this.I;
        if (1 <= i) {
            h hVar = this.f28414b;
            if (hVar != null) {
                hVar.w();
                this.f28414b.a(this.r, this.n, false);
            }
            return false;
        } else if (this.f28419g == null) {
            return false;
        } else {
            this.I = i + 1;
            u.b("NativeVideoController", "isPlaying=" + this.f28419g.g() + ",isPaused=" + this.f28419g.i() + ",isPrepared=" + this.f28419g.k() + ",isStarted=" + this.f28419g.h());
            return (this.f28419g.g() && this.f28419g.i() && this.f28419g.k() && this.f28419g.h()) ? false : true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(b bVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void m() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar != null) {
            dVar.c();
            this.f28419g = null;
        }
        if (!ak.b(this.r) || this.O == 2) {
            this.f28414b.a(this.r, this.n, true);
        }
        am amVar = this.f28416d;
        if (amVar != null) {
            amVar.removeCallbacks(this.N);
            this.f28416d.removeCallbacks(this.M);
            this.f28416d.removeCallbacks(this.L);
            this.f28416d.removeCallbacksAndMessages(null);
        }
        B();
        List<Runnable> list = this.l;
        if (list != null) {
            list.clear();
        }
        if (this.s) {
            y();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long o() {
        if (u() == null) {
            return 0L;
        }
        return u().n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long p() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar == null) {
            return 0L;
        }
        return dVar.o() + this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long q() {
        return 0L;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int r() {
        return com.bytedance.sdk.openadsdk.core.video.e.a.a(this.j, this.k);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long s() {
        return this.k;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean t() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.d.d u() {
        return this.f28419g;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public h v() {
        return this.f28414b;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        return this.B;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean x() {
        return this.J;
    }

    public void y() {
        if (this.W && this.K) {
            Context applicationContext = p.a().getApplicationContext();
            this.W = false;
            try {
                applicationContext.unregisterReceiver(this.U);
            } catch (Exception unused) {
            }
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
            inflate = LayoutInflater.from(context.getApplicationContext()).inflate(ad.f(context, "tt_video_detail_layout"), (ViewGroup) null, false);
        }
        View view = inflate;
        if (view == null) {
            return;
        }
        if (this.s) {
            this.f28414b = new h(context, view, true, noneOf, this.r, this, a());
        } else {
            this.f28414b = new g(context, view, true, noneOf, this.r, this, false);
        }
        this.f28414b.a(this);
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(ad.e(context, "tt_root_view"));
        relativeLayout.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        ViewGroup.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(ad.e(context, "tt_video_loading_retry_layout"));
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(ad.e(context, "tt_video_loading_cover_image"));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        ProgressBar progressBar = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        progressBar.setId(ad.e(context, "tt_video_loading_progress"));
        layoutParams3.addRule(13, -1);
        progressBar.setLayoutParams(layoutParams3);
        progressBar.setIndeterminateDrawable(ad.c(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(progressBar);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(ad.e(context, "tt_video_play"));
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setImageResource(ad.d(context, "tt_play_movebar_textpage"));
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        ProgressBar progressBar2 = new ProgressBar(context, null, ad.g(context, "tt_Widget_ProgressBar_Horizontal"));
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 1.5f, resources.getDisplayMetrics()));
        progressBar2.setMax(100);
        progressBar2.setId(ad.e(context, "tt_video_progress"));
        progressBar2.setBackgroundColor(0);
        progressBar2.setIndeterminateDrawable(null);
        progressBar2.setProgressDrawable(ad.c(context, "tt_video_progress_drawable"));
        progressBar2.setVisibility(8);
        layoutParams5.addRule(12, -1);
        progressBar2.setLayoutParams(layoutParams5);
        relativeLayout.addView(progressBar2);
        ViewStub viewStub = new ViewStub(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-1, -1);
        viewStub.setId(ad.e(context, "tt_video_ad_cover"));
        viewStub.setLayoutParams(layoutParams6);
        viewStub.setLayoutResource(ad.f(context, "tt_video_ad_cover_layout"));
        relativeLayout.addView(viewStub);
        ViewStub viewStub2 = new ViewStub(context);
        RelativeLayout.LayoutParams layoutParams7 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams7.addRule(13, -1);
        viewStub2.setId(ad.e(context, "tt_video_draw_layout_viewStub"));
        viewStub2.setLayoutParams(layoutParams7);
        viewStub2.setLayoutResource(ad.f(context, "tt_video_draw_btn_layout"));
        relativeLayout.addView(viewStub2);
        return relativeLayout;
    }

    public void d(long j) {
        this.i = j;
        long j2 = this.j;
        if (j2 > j) {
            j = j2;
        }
        this.j = j;
        h hVar = this.f28414b;
        if (hVar != null) {
            hVar.e();
        }
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar != null) {
            dVar.a(true, this.i, !this.t);
            A();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(b bVar, View view) {
        a(bVar, view, false);
    }

    public void f() {
        if (this.W || !this.K) {
            return;
        }
        Context applicationContext = p.a().getApplicationContext();
        this.W = true;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            applicationContext.registerReceiver(this.U, intentFilter);
        } catch (Exception unused) {
        }
    }

    public void g(boolean z) {
        h hVar = this.f28414b;
        if (hVar != null) {
            hVar.e();
        }
        h hVar2 = this.f28414b;
        if (hVar2 != null && z) {
            hVar2.u();
        }
        E();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void h() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar != null) {
            dVar.b();
        }
        if (this.q || !this.p) {
            return;
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
            if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", true)) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", p(), r(), c());
            }
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", Boolean.TRUE);
            return;
        }
        if (com.bytedance.sdk.openadsdk.core.u.a().b()) {
            com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_pause", p(), r(), c());
        }
        com.bytedance.sdk.openadsdk.core.u.a().a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        h hVar = this.f28414b;
        if (hVar != null) {
            hVar.e();
        }
        h hVar2 = this.f28414b;
        if (hVar2 != null) {
            hVar2.u();
        }
        E();
    }

    public boolean e() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        return dVar != null && dVar.g();
    }

    public void a(TTDrawFeedAd.DrawVideoListener drawVideoListener) {
        h hVar = this.f28414b;
        if (hVar != null) {
            hVar.a(drawVideoListener);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
        this.D = z;
    }

    public void a(final NativeVideoTsView.b bVar) {
        h hVar;
        if (!this.s || (hVar = this.f28414b) == null) {
            return;
        }
        hVar.a(new NativeVideoTsView.b() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.1
            @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.b
            public void a(View view, int i) {
                NativeVideoTsView.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.a(view, i);
                }
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void g() {
        if (x.c(p.a()) == 0) {
            return;
        }
        m();
        a(this.r.X().i(), this.r.am(), this.G, this.H, null, this.r.ap(), 0L, b());
        d(false);
    }

    public void a(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return;
        }
        this.G = i;
        this.H = i2;
        u.b("NativeVideoController", BigImageLoaderProc.NCDN_PER + i + "height=" + i2);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z) {
        this.K = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(b bVar, View view) {
        if (this.S) {
            h(false);
            h hVar = this.f28414b;
            if (hVar != null) {
                hVar.b(this.f28415c.get());
            }
            a(1);
            return;
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC0317c interfaceC0317c) {
        this.E = new WeakReference<>(interfaceC0317c);
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
        int i3 = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        if (i3 <= 0) {
            this.q = false;
            this.p = false;
        }
        if (i3 > 0) {
            this.i = j;
            long j2 = this.j;
            if (j2 > j) {
                j = j2;
            }
            this.j = j;
        }
        h hVar = this.f28414b;
        if (hVar != null) {
            hVar.e();
            if (this.O == 0) {
                this.f28414b.d();
            }
            this.f28414b.c(i, i2);
            this.f28414b.c(this.f28415c.get());
            this.f28414b.a(i, i2);
        }
        if (this.f28419g == null) {
            this.f28419g = new com.bytedance.sdk.openadsdk.core.video.d.d(this.f28416d);
        }
        u.b("tag_video_play", "[video] new MediaPlayer");
        this.f28418f = 0L;
        try {
            a(str);
            return true;
        } catch (Exception e2) {
            u.f("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + e2.toString());
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z) {
        this.s = z;
        h hVar = this.f28414b;
        if (hVar != null) {
            hVar.c(z);
        }
    }

    public boolean d() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        return dVar == null || dVar.l();
    }

    private boolean d(int i) {
        l lVar;
        int c2 = x.c(p.a());
        if (c2 == 0) {
            h();
            this.z = true;
            h hVar = this.f28414b;
            if (hVar != null) {
                hVar.a(this.r, this.n, false);
            }
        }
        if (c2 != 4 && c2 != 0) {
            h hVar2 = this.f28414b;
            if (hVar2 != null) {
                hVar2.e();
            }
            h();
            this.z = true;
            this.A = false;
            h hVar3 = this.f28414b;
            if (hVar3 != null && (lVar = this.r) != null) {
                return hVar3.a(i, lVar.X(), this.w);
            }
        } else if (c2 == 4) {
            this.z = false;
            h hVar4 = this.f28414b;
            if (hVar4 != null) {
                hVar4.q();
            }
        }
        return true;
    }

    private void h(boolean z) {
        this.S = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j) {
        this.y = j;
    }

    public boolean b() {
        return this.t;
    }

    private void b(int i) {
        h hVar;
        this.O++;
        if (C() && (hVar = this.f28414b) != null) {
            hVar.w();
            c.a aVar = this.f28420h;
            if (aVar != null) {
                aVar.a(this.f28418f, com.bytedance.sdk.openadsdk.core.video.e.a.a(this.i, this.k));
            }
            this.f28418f = System.currentTimeMillis() - this.f28417e;
            if (!ak.b(this.r) || this.O >= 2) {
                this.f28414b.a(this.r, this.n, true);
            }
            if (!this.q) {
                com.bytedance.sdk.openadsdk.c.d.a(this.n.get(), this.r, this.u, "feed_over", p(), 100, c());
                this.q = true;
                long j = this.k;
                a(j, j);
                long j2 = this.k;
                this.i = j2;
                this.j = j2;
            }
            if (!this.s && this.S) {
                e(this.f28414b, null);
            }
            this.B = true;
            if (!ak.b(this.r) || this.O >= 2) {
                return;
            }
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context) {
        int c2 = x.c(context);
        a(context, c2);
        if (c2 == 4) {
            this.z = false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j) {
        this.i = j;
        long j2 = this.j;
        if (j2 > j) {
            j = j2;
        }
        this.j = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        this.B = z;
    }

    public boolean a() {
        return this.s;
    }

    private void a(String str) {
        u.b("tag_video_play", "[video] NativeVideoController#playVideo has invoke !");
        if (this.f28419g != null) {
            com.bytedance.sdk.openadsdk.core.video.b.a aVar = new com.bytedance.sdk.openadsdk.core.video.b.a();
            aVar.f28340a = str;
            l lVar = this.r;
            if (lVar != null) {
                if (lVar.X() != null) {
                    aVar.f28343d = this.r.X().l();
                }
                aVar.f28341b = String.valueOf(ak.d(this.r.ap()));
            }
            aVar.f28342c = 0;
            this.f28419g.a(aVar);
            u.b("tag_video_play", "[video] MediaPlayerProxy has setDataSource !");
        }
        this.f28417e = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.f28414b.d(8);
            this.f28414b.d(0);
            a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.nativevideo.f.2
                @Override // java.lang.Runnable
                public void run() {
                    f.this.f28417e = System.currentTimeMillis();
                    f.this.f28414b.c(0);
                    if (f.this.f28419g == null || f.this.i != 0) {
                        if (f.this.f28419g != null) {
                            f.this.f28419g.a(true, f.this.i, !f.this.t);
                        }
                    } else {
                        f.this.f28419g.a(true, 0L, !f.this.t);
                    }
                    if (f.this.f28416d != null) {
                        f.this.f28416d.postDelayed(f.this.L, 100L);
                    }
                    f.this.A();
                }
            });
        }
        if (this.s) {
            f();
        }
    }

    private void b(Runnable runnable) {
        if (this.l == null) {
            this.l = Collections.synchronizedList(new ArrayList());
        }
        this.l.add(runnable);
    }

    private void b(int i, int i2) {
        if (this.r == null) {
            return;
        }
        boolean e2 = e();
        String str = e2 ? "play_error" : "play_start_error";
        Map<String, Object> a2 = ak.a(this.r, i, i2, u());
        if (e2) {
            a2.put("duration", Long.valueOf(p()));
            a2.put(SapiOptions.s, Integer.valueOf(r()));
            a2.put("buffers_time", Long.valueOf(o()));
        }
        com.bytedance.sdk.openadsdk.c.d.d(this.n.get(), this.r, this.u, str, a2);
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
        } catch (Throwable unused) {
        }
        this.f28415c = new WeakReference<>(viewGroup);
        this.u = str;
        this.n = new WeakReference<>(context);
        this.r = lVar;
        b(context);
        this.o = Build.VERSION.SDK_INT >= 17;
        this.v = z;
        this.w = z2;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, int i) {
        if (this.f28419g != null) {
            B();
        }
        h hVar = this.f28414b;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        this.x = new WeakReference<>(eVar);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, View view) {
        b(bVar, view, false, false);
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (this.f28414b.k() && this.m) {
            runnable.run();
        } else {
            b(runnable);
        }
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
                h hVar = this.f28414b;
                if (hVar != null) {
                    hVar.a(this.f28415c.get());
                    this.f28414b.b(false);
                }
            } else {
                a(1);
                h hVar2 = this.f28414b;
                if (hVar2 != null) {
                    hVar2.b(this.f28415c.get());
                    this.f28414b.b(false);
                }
            }
            WeakReference<e> weakReference = this.x;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.S);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.f28420h = aVar;
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
    public void c(long j) {
        this.k = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        this.t = z;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar != null) {
            dVar.b(z);
        }
    }

    public Map<String, Object> c() {
        return ak.a(this.r, o(), u());
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void c(b bVar, View view) {
        h hVar = this.f28414b;
        if (hVar != null) {
            hVar.g();
        }
        a(true);
    }

    private boolean c(int i) {
        return this.f28414b.b(i);
    }

    private boolean c(int i, int i2) {
        u.b("TTVideoWebPageActivity", "OnError - Error code: " + i + " Extra code: " + i2);
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z;
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        WeakReference<a> weakReference2;
        if (this.f28414b == null || message == null || (weakReference = this.n) == null || weakReference.get() == null) {
            return;
        }
        int i = message.what;
        if (i == 108) {
            Object obj = message.obj;
            if (!(obj instanceof Long) || ((Long) obj).longValue() <= 0) {
                return;
            }
            this.k = ((Long) message.obj).longValue();
        } else if (i == 109) {
            Object obj2 = message.obj;
            if (obj2 instanceof Long) {
                long longValue = ((Long) obj2).longValue();
                this.i = longValue;
                long j = this.j;
                if (j > longValue) {
                    longValue = j;
                }
                this.j = longValue;
                a(this.i, this.k);
            }
        } else if (i == 308) {
            u.f("NativeVideoController", "播放器状态出错 STAT_ERROR 200 、、、、、、、");
            G();
            b(308, 0);
        } else if (i != 309) {
            switch (i) {
                case 302:
                    b(i);
                    return;
                case 303:
                    int i2 = message.arg1;
                    int i3 = message.arg2;
                    b(i2, i3);
                    u.f("NativeVideoController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                    if (!e() || i3 == -1004) {
                        u.f("NativeVideoController", "出错后 errorcode,extra、、、、、、、" + i2 + "," + i3);
                        if (c(i2, i3)) {
                            u.f("NativeVideoController", "出错后展示结果页、、、、、、、");
                            this.f28414b.a(this.r, this.n, false);
                            d(true);
                            m();
                        }
                        h hVar = this.f28414b;
                        if (hVar != null) {
                            hVar.w();
                        }
                        c.a aVar = this.f28420h;
                        if (aVar != null) {
                            aVar.b(this.f28418f, com.bytedance.sdk.openadsdk.core.video.e.a.a(this.i, this.k));
                        }
                        WeakReference<c.InterfaceC0317c> weakReference3 = this.E;
                        if (weakReference3 == null || weakReference3.get() == null || e()) {
                            return;
                        }
                        this.E.get().a(i2, i3);
                        return;
                    }
                    return;
                case 304:
                    int i4 = message.arg1;
                    h hVar2 = this.f28414b;
                    if (hVar2 != null) {
                        if (i4 == 3 || i4 == 702) {
                            this.f28414b.w();
                            this.f28416d.removeCallbacks(this.f28413a);
                            this.J = false;
                        } else if (i4 == 701) {
                            hVar2.t();
                            this.f28416d.postDelayed(this.f28413a, 8000L);
                            this.J = true;
                        }
                    }
                    if (this.o && i4 == 3) {
                        if (this.s && (weakReference2 = this.F) != null && weakReference2.get() != null) {
                            this.F.get().g();
                        }
                        this.f28416d.removeCallbacks(this.f28413a);
                    }
                    if (this.o && i4 == 3) {
                        F();
                        return;
                    }
                    return;
                case 305:
                    WeakReference<c.InterfaceC0317c> weakReference4 = this.E;
                    if (weakReference4 != null && weakReference4.get() != null) {
                        this.E.get().f();
                    }
                    am amVar = this.f28416d;
                    if (amVar != null) {
                        amVar.removeCallbacks(this.M);
                    }
                    if (!this.o) {
                        F();
                    }
                    h hVar3 = this.f28414b;
                    if (hVar3 != null) {
                        hVar3.w();
                    }
                    this.f28416d.removeCallbacks(this.f28413a);
                    return;
                case 306:
                    h hVar4 = this.f28414b;
                    if (hVar4 != null) {
                        hVar4.w();
                        return;
                    }
                    return;
                default:
                    switch (i) {
                        case 311:
                            I();
                            return;
                        case 312:
                            if (z()) {
                                u.f("NativeVideoController", "CALLBACK_ON_RETRY_VIDEO_TIME-....重试....");
                                m();
                                this.f28419g = null;
                                a(this.r.X().i(), this.r.am(), this.G, this.H, null, this.r.ap(), 0L, b());
                                return;
                            }
                            u.c("NativeVideoController", "不满足条件，无法重试");
                            b(312, 0);
                            return;
                        case 313:
                            H();
                            WeakReference<a> weakReference5 = this.F;
                            if (weakReference5 == null || weakReference5.get() == null) {
                                return;
                            }
                            this.F.get().g();
                            return;
                        case 314:
                            try {
                                ((Boolean) message.obj).booleanValue();
                            } catch (Throwable unused) {
                            }
                            this.Q = SystemClock.elapsedRealtime();
                            return;
                        default:
                            return;
                    }
            }
        } else {
            u.c("NativeVideoController", "SSMediaPlayerWrapper 释放了。。。。。");
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceHolder surfaceHolder) {
        this.m = false;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar != null) {
            dVar.a(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(b bVar, SurfaceTexture surfaceTexture) {
        this.m = false;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar != null) {
            dVar.a(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, View view) {
        if (this.f28419g == null || !C()) {
            return;
        }
        if (this.f28419g.g()) {
            h();
            this.f28414b.b(true, false);
            this.f28414b.c();
        } else if (!this.f28419g.i()) {
            h hVar = this.f28414b;
            if (hVar != null) {
                hVar.c(this.f28415c.get());
            }
            d(this.i);
            h hVar2 = this.f28414b;
            if (hVar2 != null) {
                hVar2.b(false, false);
            }
        } else {
            g(false);
            h hVar3 = this.f28414b;
            if (hVar3 != null) {
                hVar3.b(false, false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i) {
        if (this.f28419g == null) {
            return;
        }
        A();
        a(this.T, c(i));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, int i, boolean z) {
        if (C()) {
            long l = (((float) (i * this.k)) * 1.0f) / ad.l(this.n.get(), "tt_video_progress_max");
            if (this.k > 0) {
                this.T = (int) l;
            } else {
                this.T = 0L;
            }
            h hVar = this.f28414b;
            if (hVar != null) {
                hVar.a(this.T);
            }
        }
    }

    private void a(long j, long j2) {
        this.i = j;
        this.k = j2;
        this.f28414b.a(j, j2);
        this.f28414b.a(com.bytedance.sdk.openadsdk.core.video.e.a.a(j, j2));
        try {
            if (this.f28420h != null) {
                this.f28420h.a(j, j2);
            }
        } catch (Throwable th) {
            u.c("NativeVideoController", "onProgressUpdate error: ", th);
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
                } catch (Throwable unused) {
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
    public void a(b bVar, View view, boolean z, boolean z2) {
        if (this.s) {
            h();
        }
        if (z && !this.s && !d()) {
            this.f28414b.b(!e(), false);
            this.f28414b.a(z2, true, false);
        }
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar != null && dVar.g()) {
            this.f28414b.c();
            this.f28414b.b();
            return;
        }
        this.f28414b.c();
    }

    public void a(b bVar, View view, boolean z) {
        K();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceHolder surfaceHolder) {
        this.m = true;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar != null) {
            dVar.a(true);
        }
        com.bytedance.sdk.openadsdk.core.video.d.d dVar2 = this.f28419g;
        if (dVar2 == null) {
            return;
        }
        dVar2.a(surfaceHolder);
        D();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(b bVar, SurfaceTexture surfaceTexture) {
        this.m = true;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.f28419g;
        if (dVar != null) {
            dVar.a(true);
        }
        com.bytedance.sdk.openadsdk.core.video.d.d dVar2 = this.f28419g;
        if (dVar2 == null) {
            return;
        }
        dVar2.a(surfaceTexture);
        D();
    }

    private void a(long j, boolean z) {
        if (this.f28419g == null) {
            return;
        }
        if (z) {
            L();
        }
        this.f28419g.a(j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(h.a aVar, String str) {
        int i = AnonymousClass8.f28429a[aVar.ordinal()];
        if (i == 1) {
            h();
        } else if (i == 2) {
            a(true);
        } else if (i != 3) {
        } else {
            k();
            this.z = false;
            this.A = true;
        }
    }

    private void a(Context context, int i) {
        if (!C() || context == null || this.V == i) {
            return;
        }
        this.V = i;
        if (i != 4 && i != 0) {
            this.A = false;
        }
        if (!this.A && !w() && this.v) {
            d(2);
        }
        WeakReference<a> weakReference = this.F;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.F.get().a(this.V);
    }

    public void a(Context context) {
        int c2 = x.c(context);
        a(context, c2);
        if (c2 == 4) {
            this.z = false;
            k();
        }
    }

    public void a(a aVar) {
        this.F = new WeakReference<>(aVar);
    }
}
