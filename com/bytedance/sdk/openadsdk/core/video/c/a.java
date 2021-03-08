package com.bytedance.sdk.openadsdk.core.video.c;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.h;
import com.bytedance.sdk.openadsdk.core.widget.h;
import com.bytedance.sdk.openadsdk.utils.ac;
import com.bytedance.sdk.openadsdk.utils.aj;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import com.bytedance.sdk.openadsdk.utils.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import okhttp3.internal.http.StatusLine;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public abstract class a implements c, d, al.a {
    private WeakReference<e> D;
    private int E;
    private long L;
    private int N;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f4526a;
    public final l b;
    public long c;
    public long i;
    private h j;
    private final ViewGroup k;
    private com.bytedance.sdk.openadsdk.core.video.d.d o;
    private c.a p;
    private ArrayList<Runnable> s;
    private boolean t;
    private final boolean u;
    private final al l = new al(this);
    private long m = 0;
    private long n = 0;
    private long q = 0;
    private long r = 0;
    private boolean v = false;
    private boolean w = false;
    private boolean x = true;
    private boolean y = false;
    private long z = 0;
    private boolean A = false;
    private boolean B = false;
    private boolean C = false;
    protected Map<String, Object> d = null;
    protected long e = 0;
    protected long f = 0;
    protected boolean g = false;
    protected boolean h = false;
    private boolean F = false;
    private boolean G = true;
    private final Runnable H = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.o != null) {
                a.this.o.e();
            }
        }
    };
    private final Runnable I = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.p != null) {
                a.this.p.a();
            }
        }
    };
    private final Runnable J = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.4
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.o != null) {
                if (a.this.c <= 0) {
                    a.this.o.e();
                }
                a.this.o.f();
            }
            a.this.l.postDelayed(this, 200L);
        }
    };
    private boolean K = false;
    private final BroadcastReceiver M = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.5
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                a.this.h();
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                a.this.b(context);
            }
        }
    };
    private boolean O = false;

    protected abstract int a();

    protected abstract void a(int i, int i2);

    protected abstract void b();

    protected abstract void c();

    protected abstract void d();

    protected abstract void e();

    protected abstract void f();

    @SuppressLint({"InflateParams"})
    private void a(Context context) {
        EnumSet noneOf = EnumSet.noneOf(b.a.class);
        noneOf.add(b.a.hideCloseBtn);
        noneOf.add(b.a.hideBackBtn);
        this.j = new h(context.getApplicationContext(), LayoutInflater.from(context.getApplicationContext()).inflate(ac.f(context, "tt_video_play_layout_for_live"), (ViewGroup) null, false), true, noneOf, this.b, this);
        this.j.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, ViewGroup viewGroup, l lVar) {
        this.N = 1;
        this.N = x.c(context);
        this.k = viewGroup;
        this.f4526a = new WeakReference<>(context);
        this.b = lVar;
        a(context);
        this.E = aj.d(this.b.aj());
        this.u = Build.VERSION.SDK_INT >= 17;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(String str, String str2, int i, int i2, List<String> list, String str3, long j, boolean z) {
        u.b("BaseVideoController", "video local url " + str);
        if (TextUtils.isEmpty(str)) {
            u.f("BaseVideoController", "No video info");
            return false;
        }
        this.g = !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME);
        this.y = z;
        if (j > 0) {
            this.q = j;
            this.r = this.r > this.q ? this.r : this.q;
        }
        if (this.j != null) {
            this.j.e();
            this.j.d();
            this.j.c(i, i2);
            this.j.c(this.k);
        }
        if (this.o == null) {
            this.o = new com.bytedance.sdk.openadsdk.core.video.d.d(this.l);
        }
        this.n = 0L;
        try {
            a(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.d.d u() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public h v() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        return this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j) {
        this.q = j;
        this.r = this.r > this.q ? this.r : this.q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z) {
        this.x = z;
        this.j.c(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean t() {
        return this.A;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j) {
        this.z = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long s() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j) {
        this.c = j;
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
        if (this.o == null) {
            return 0L;
        }
        return this.o.o() + this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        this.y = z;
        if (this.o != null) {
            this.o.b(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long q() {
        if (this.o == null) {
            return 0L;
        }
        return this.o.p() + this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        return this.C;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        this.C = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean x() {
        return this.F;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z) {
        this.G = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int r() {
        return com.bytedance.sdk.openadsdk.core.video.e.a.a(this.r, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
        this.d = map;
    }

    private void a(String str) throws Exception {
        if (this.o != null) {
            com.bytedance.sdk.openadsdk.core.video.b.a aVar = new com.bytedance.sdk.openadsdk.core.video.b.a();
            aVar.f4525a = str;
            if (this.b != null) {
                if (this.b.R() != null) {
                    aVar.d = this.b.R().l();
                }
                aVar.b = String.valueOf(aj.d(this.b.aj()));
            }
            aVar.c = 1;
            this.o.a(aVar);
        }
        this.m = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.j.d(8);
            this.j.d(0);
            a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.m = System.currentTimeMillis();
                    a.this.j.c(0);
                    if (a.this.o == null || a.this.q != 0) {
                        if (a.this.o != null) {
                            a.this.o.a(true, a.this.q, a.this.y ? false : true);
                        }
                    } else {
                        a.this.o.a(true, 0L, a.this.y ? false : true);
                    }
                    if (a.this.l != null) {
                        a.this.l.postDelayed(a.this.H, 100L);
                    }
                    a.this.E();
                }
            });
        }
    }

    private void D() {
        int i = 5;
        int a2 = a();
        if (a2 == 2 || a2 == 1) {
            i = p.h().H() * 1000;
        } else if (a2 == 3) {
            i = p.h().f(String.valueOf(this.E));
        }
        this.l.removeCallbacks(this.I);
        this.l.postDelayed(this.I, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        F();
        this.l.postDelayed(this.J, 800L);
    }

    private void F() {
        this.l.removeCallbacks(this.J);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        this.D = new WeakReference<>(eVar);
    }

    private void b(int i) {
        if (G() && this.j != null) {
            this.l.removeCallbacks(this.I);
            this.j.w();
            this.n = System.currentTimeMillis() - this.m;
            if (this.p != null) {
                this.p.a(this.n, com.bytedance.sdk.openadsdk.core.video.e.a.a(this.q, this.c));
            }
            if (aj.d(this.b)) {
                this.j.a(this.b, this.f4526a, true);
            }
            if (!this.w) {
                b();
                this.w = true;
                a(this.c, this.c);
                long j = this.c;
                this.q = j;
                this.r = j;
            }
            this.C = true;
        }
    }

    private boolean G() {
        return (this.f4526a == null || this.f4526a.get() == null) ? false : true;
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            if (this.j.k() && this.t) {
                runnable.run();
            } else {
                b(runnable);
            }
        }
    }

    private void b(Runnable runnable) {
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        this.s.add(runnable);
    }

    private void H() {
        if (this.s != null && !this.s.isEmpty()) {
            Iterator it = new ArrayList(this.s).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.s.clear();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.p = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC1024c interfaceC1024c) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void h() {
        this.i = p();
        if (this.o != null) {
            this.o.b();
        }
        if (!this.w && this.v) {
            c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        if (this.o != null) {
            this.o.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        if (this.j != null) {
            this.j.e();
            this.j.q();
            this.j.u();
        }
        if (this.o != null) {
            this.o.a(false, this.q, !this.y);
            E();
        }
        if (!this.w && this.v) {
            d();
        }
    }

    public void y() {
        if (!this.w && this.v) {
            d();
        }
    }

    public void d(long j) {
        this.q = j;
        this.r = this.r > this.q ? this.r : this.q;
        if (this.j != null) {
            this.j.e();
        }
        if (this.o != null) {
            this.o.a(true, this.q, !this.y);
            E();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        if (this.o != null) {
            this.o.c();
            this.o = null;
        }
        if (this.j != null) {
            this.j.g();
        }
        if (this.l != null) {
            this.l.removeCallbacks(this.I);
            this.l.removeCallbacks(this.H);
            this.l.removeCallbacksAndMessages(null);
            F();
        }
        this.p = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z) {
        l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void m() {
        l();
    }

    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    public void a(Message message) {
        if (this.j != null && message != null && this.f4526a != null && this.f4526a.get() != null) {
            switch (message.what) {
                case 108:
                    if ((message.obj instanceof Long) && ((Long) message.obj).longValue() > 0) {
                        this.c = ((Long) message.obj).longValue();
                        return;
                    }
                    return;
                case 109:
                    if (message.obj instanceof Long) {
                        this.q = ((Long) message.obj).longValue();
                        this.r = this.r > this.q ? this.r : this.q;
                        a(this.q, this.c);
                        return;
                    }
                    return;
                case 302:
                    b(message.what);
                    return;
                case 303:
                    a(message.arg1, message.arg2);
                    this.l.removeCallbacks(this.I);
                    if (this.j != null) {
                        this.j.w();
                    }
                    if (this.p != null) {
                        this.p.b(this.n, com.bytedance.sdk.openadsdk.core.video.e.a.a(this.q, this.c));
                        return;
                    }
                    return;
                case 304:
                    int i = message.arg1;
                    if (this.j != null) {
                        if (i == 3 || i == 702) {
                            this.j.w();
                            this.l.removeCallbacks(this.I);
                            this.F = false;
                        } else if (i == 701) {
                            this.j.t();
                            D();
                            this.F = true;
                        }
                    }
                    if (this.u && i == 3 && !this.v) {
                        this.f = SystemClock.elapsedRealtime() - this.e;
                        e();
                        this.v = true;
                        this.h = true;
                        return;
                    }
                    return;
                case 305:
                    if (this.l != null) {
                        this.l.removeCallbacks(this.I);
                    }
                    if (!this.u && !this.v) {
                        this.f = SystemClock.elapsedRealtime() - this.e;
                        f();
                        this.v = true;
                    }
                    if (this.j != null) {
                        this.j.w();
                        return;
                    }
                    return;
                case ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA /* 306 */:
                    this.l.removeCallbacks(this.I);
                    if (this.j != null) {
                        this.j.w();
                        return;
                    }
                    return;
                case StatusLine.HTTP_PERM_REDIRECT /* 308 */:
                    a(StatusLine.HTTP_PERM_REDIRECT, 0);
                    return;
                case 311:
                    if (this.b != null && this.b.l() == 0) {
                        K();
                        return;
                    } else {
                        J();
                        return;
                    }
                case 314:
                    this.e = SystemClock.elapsedRealtime();
                    return;
                default:
                    return;
            }
        }
    }

    private boolean I() throws Throwable {
        return this.f4526a == null || this.f4526a.get() == null || L() == null || this.o == null || this.o.a() == null || this.b == null || this.b.M() != null || this.b.n() == 1;
    }

    private void J() {
        float f;
        boolean z = true;
        try {
            u.c("changeVideoSize", "changeVideoSize start.......mMaterialMeta.getAdSlot()=" + this.b.p());
            if (!I()) {
                u.c("changeVideoSize", "changeVideoSize start check condition complete ... go ..");
                int[] b = ak.b(p.a());
                MediaPlayer a2 = this.o.a();
                boolean z2 = this.b.ak() == 15;
                float f2 = b[0];
                float f3 = b[1];
                float videoWidth = a2.getVideoWidth();
                float videoHeight = a2.getVideoHeight();
                if (z2) {
                    if (videoWidth > videoHeight) {
                        u.b("changeVideoSize", "横转竖屏单独适配.....");
                        a(f2, f3, videoWidth, videoHeight, true);
                        return;
                    }
                } else if (videoWidth < videoHeight) {
                    u.b("changeVideoSize", "竖屏转横单独适配.....");
                    a(f2, f3, videoWidth, videoHeight, false);
                    return;
                }
                float f4 = videoWidth / videoHeight;
                float f5 = f2 / f3;
                u.b("changeVideoSize", "screenHeight=" + f3 + ",screenWidth=" + f2);
                u.b("changeVideoSize", "videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                u.b("changeVideoSize", "视频宽高比,videoScale=" + f4 + ",屏幕宽高比.screenScale=" + f5 + ",VERTICAL_SCALE(9:16)=0.5625,HORIZONTAL_SCALE(16:9) =1.7777778");
                if (z2) {
                    if (f5 < 0.5625f && f4 == 0.5625f) {
                        videoWidth = (9.0f * f3) / 16.0f;
                        f = f3;
                    }
                    f = videoHeight;
                    z = false;
                } else {
                    if (f5 > 1.7777778f && f4 == 1.7777778f) {
                        f = (9.0f * f2) / 16.0f;
                        videoWidth = f2;
                    }
                    f = videoHeight;
                    z = false;
                }
                u.c("changeVideoSize", "适配后宽高：videoHeight=" + f + ",videoWidth=" + videoWidth);
                if (z) {
                    f3 = f;
                    f2 = videoWidth;
                } else {
                    u.c("changeVideoSize", " 屏幕比例和视频比例相同，以及其他情况都按照屏幕宽高播放，videoHeight=" + f3 + "，videoWidth=" + f2);
                }
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f2, (int) f3);
                layoutParams.addRule(13);
                if (L() != null) {
                    if (L() instanceof TextureView) {
                        ((TextureView) L()).setLayoutParams(layoutParams);
                    } else if (L() instanceof SurfaceView) {
                        ((SurfaceView) L()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.k.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = (int) f3;
                        layoutParams2.width = (int) f2;
                        this.k.setLayoutParams(layoutParams2);
                    }
                }
                u.b("changeVideoSize", "changeVideoSize .... complete ... end !!!");
            }
        } catch (Throwable th) {
            u.c("changeVideoSize", "changeSize error", th);
        }
    }

    private void K() {
        int[] b;
        try {
            if (this.f4526a != null && this.f4526a.get() != null && L() != null && this.o != null && this.o.a() != null && this.b != null) {
                boolean z = this.b.ak() == 15;
                float f = ak.b(p.a())[1];
                MediaPlayer a2 = this.o.a();
                a(b[0], f, a2.getVideoWidth(), a2.getVideoHeight(), z);
                u.b("changeVideoSize", "changeSize=end");
            }
        } catch (Throwable th) {
            u.a("changeVideoSize", "changeSize error", th);
        }
    }

    private void a(float f, float f2, float f3, float f4, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        try {
            u.b("changeVideoSize", "screenWidth=" + f + ",screenHeight=" + f2);
            u.b("changeVideoSize", "videoHeight=" + f4 + ",videoWidth=" + f3);
            if (f3 <= 0.0f || f4 <= 0.0f) {
                f3 = this.b.R().c();
                f4 = this.b.R().b();
            }
            if (f4 > 0.0f && f3 > 0.0f) {
                if (z) {
                    if (f3 >= f4) {
                        u.b("changeVideoSize", "竖屏模式下按视频宽度计算放大倍数值");
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) f, (int) ((f4 * f) / f3));
                        layoutParams2.addRule(13);
                        layoutParams = layoutParams2;
                    } else {
                        return;
                    }
                } else if (f3 <= f4) {
                    u.b("changeVideoSize", "横屏模式下按视频高度计算放大倍数值");
                    RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) ((f3 * f2) / f4), (int) f2);
                    layoutParams3.addRule(13);
                    layoutParams = layoutParams3;
                } else {
                    return;
                }
                if (L() != null) {
                    if (L() instanceof TextureView) {
                        ((TextureView) L()).setLayoutParams(layoutParams);
                    } else if (L() instanceof SurfaceView) {
                        ((SurfaceView) L()).setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Throwable th) {
            u.a("changeVideoSize", "changeSize error", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        if (this.o != null && G()) {
            if (this.o.g()) {
                h();
                this.j.b(true, false);
                this.j.c();
            } else if (!this.o.i()) {
                if (this.j != null) {
                    this.j.c(this.k);
                }
                d(this.q);
                if (this.j != null) {
                    this.j.b(false, false);
                }
            } else {
                k();
                if (this.j != null) {
                    this.j.b(false, false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i) {
        if (this.o != null) {
            E();
            a(this.L, c(i));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i) {
        if (this.o != null) {
            F();
        }
        if (this.j != null) {
            this.j.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i, boolean z) {
        if (G()) {
            long l = (((float) (i * this.c)) * 1.0f) / ac.l(this.f4526a.get(), "tt_video_progress_max");
            if (this.c > 0) {
                this.L = (int) l;
            } else {
                this.L = 0L;
            }
            if (this.j != null) {
                this.j.a(this.L);
            }
        }
    }

    private void a(long j, long j2) {
        this.q = j;
        this.c = j2;
        this.j.a(j, j2);
        this.j.a(com.bytedance.sdk.openadsdk.core.video.e.a.a(j, j2));
        try {
            if (this.p != null) {
                this.p.a(j, j2);
            }
        } catch (Throwable th) {
            u.c("BaseVideoController", "onProgressUpdate error: ", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        b(bVar, view, false, false);
    }

    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z, boolean z2) {
        if (G()) {
            g(!this.K);
            if (!(this.f4526a.get() instanceof Activity)) {
                u.b("BaseVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.K) {
                a(z ? 8 : 0);
                if (this.j != null) {
                    this.j.a(this.k);
                    this.j.b(false);
                }
            } else {
                a(1);
                if (this.j != null) {
                    this.j.b(this.k);
                    this.j.b(false);
                }
            }
            e eVar = this.D != null ? this.D.get() : null;
            if (eVar != null) {
                eVar.a(this.K);
            }
        }
    }

    public void a(int i) {
        if (G()) {
            boolean z = i == 0 || i == 8;
            Context context = this.f4526a.get();
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
    public void c(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        if (this.j != null) {
            this.j.g();
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z, boolean z2) {
        if (this.x) {
            h();
        }
        if (z && !this.x && !z()) {
            this.j.b(!A(), false);
            this.j.a(z2, true, false);
        }
        if (this.o != null && this.o.g()) {
            this.j.c();
            this.j.b();
            return;
        }
        this.j.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        if (this.K) {
            g(false);
            if (this.j != null) {
                this.j.b(this.k);
            }
            a(1);
            return;
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        a(bVar, view, false);
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z) {
    }

    private void g(boolean z) {
        this.K = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        this.t = true;
        if (this.o != null) {
            if (this.o != null) {
                this.o.a(true);
            }
            this.o.a(surfaceHolder);
            H();
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b L() {
        if (this.f4526a == null || this.f4526a.get() == null || this.j == null) {
            return null;
        }
        return this.j.o();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        this.t = false;
        if (this.o != null) {
            this.o.a(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        this.t = true;
        if (this.o != null) {
            if (this.o != null) {
                this.o.a(true);
            }
            this.o.a(surfaceTexture);
            H();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        this.t = false;
        if (this.o != null) {
            this.o.a(false);
        }
    }

    public boolean z() {
        return this.o.l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void g() {
        if (this.j != null) {
            this.j.b();
            this.j.e();
        }
        if (this.j != null) {
            this.j.u();
        }
        d(-1L);
        if (this.o != null) {
            this.o.m();
        }
    }

    public boolean A() {
        return this.o != null && this.o.g();
    }

    private void a(long j, boolean z) {
        if (this.o != null) {
            if (z) {
                M();
            }
            this.o.a(j);
        }
    }

    private boolean c(int i) {
        return this.j.b(i);
    }

    private void M() {
        if (this.j != null) {
            this.j.c(0);
            this.j.a(false, false);
            this.j.b(false);
            this.j.b();
            this.j.d();
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
                this.A = false;
                this.B = true;
                return;
            default:
                return;
        }
    }

    private boolean d(int i) {
        int c = x.c(p.a());
        if (c != 4 && c != 0) {
            h();
            this.A = true;
            this.B = false;
            if (this.j == null || this.b == null) {
                return true;
            }
            return this.j.a(i, this.b.R(), true);
        } else if (c == 4) {
            this.A = false;
            if (this.j != null) {
                this.j.q();
                return true;
            }
            return true;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        int c;
        if (G() && this.N != (c = x.c(context))) {
            if (!this.B) {
                d(2);
            }
            this.N = c;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        if (this.o != null) {
            this.o.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> B() {
        HashMap hashMap = new HashMap();
        if (this.d != null) {
            for (Map.Entry<String, Object> entry : this.d.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> a2 = aj.a(this.f, this.b, u());
        if (a2 != null) {
            for (Map.Entry<String, Object> entry2 : a2.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> C() {
        HashMap hashMap = new HashMap();
        Map<String, Object> a2 = aj.a(this.b, o(), u());
        if (a2 != null) {
            for (Map.Entry<String, Object> entry : a2.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        if (this.d != null) {
            for (Map.Entry<String, Object> entry2 : this.d.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }
}
