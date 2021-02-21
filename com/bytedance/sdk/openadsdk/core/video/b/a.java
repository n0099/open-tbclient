package com.bytedance.sdk.openadsdk.core.video.b;

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
import com.bytedance.sdk.openadsdk.utils.am;
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
public abstract class a implements c, d, am.a {
    private WeakReference<e> C;
    private int D;
    private long K;
    private int M;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f6691a;

    /* renamed from: b  reason: collision with root package name */
    public final l f6692b;
    public long c;
    public long h;
    private h i;
    private final ViewGroup j;
    private com.bytedance.sdk.openadsdk.core.video.c.d n;
    private c.a o;
    private ArrayList<Runnable> r;
    private boolean s;
    private final boolean t;
    private final am k = new am(this);
    private long l = 0;
    private long m = 0;
    private long p = 0;
    private long q = 0;
    private boolean u = false;
    private boolean v = false;
    private boolean w = true;
    private boolean x = false;
    private long y = 0;
    private boolean z = false;
    private boolean A = false;
    private boolean B = false;
    protected Map<String, Object> d = null;
    protected long e = 0;
    protected long f = 0;
    protected boolean g = false;
    private boolean E = false;
    private boolean F = true;
    private final Runnable G = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.n != null) {
                a.this.n.e();
            }
        }
    };
    private final Runnable H = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.o != null) {
                a.this.o.a();
            }
        }
    };
    private final Runnable I = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.4
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.n != null) {
                if (a.this.c <= 0) {
                    a.this.n.e();
                }
                a.this.n.f();
            }
            a.this.k.postDelayed(this, 200L);
        }
    };
    private boolean J = false;
    private final BroadcastReceiver L = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.5
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
    private boolean N = false;

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
        this.i = new h(context.getApplicationContext(), LayoutInflater.from(context.getApplicationContext()).inflate(ac.f(context, "tt_video_play_layout_for_live"), (ViewGroup) null, false), true, noneOf, this.f6692b, this);
        this.i.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(Context context, ViewGroup viewGroup, l lVar) {
        this.M = 1;
        this.M = x.c(context);
        this.j = viewGroup;
        this.f6691a = new WeakReference<>(context);
        this.f6692b = lVar;
        a(context);
        this.D = aj.d(this.f6692b.W());
        this.t = Build.VERSION.SDK_INT >= 17;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(String str, String str2, int i, int i2, List<String> list, String str3, long j, boolean z) {
        u.b("BaseVideoController", "video local url " + str);
        if (TextUtils.isEmpty(str)) {
            u.f("BaseVideoController", "No video info");
            return false;
        }
        this.g = !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME);
        this.x = z;
        if (j > 0) {
            this.p = j;
            this.q = this.q > this.p ? this.q : this.p;
        }
        if (this.i != null) {
            this.i.e();
            this.i.d();
            this.i.c(i, i2);
            this.i.c(this.j);
        }
        if (this.n == null) {
            this.n = new com.bytedance.sdk.openadsdk.core.video.c.d(this.k);
        }
        this.m = 0L;
        try {
            a(str);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.c.d t() {
        return this.n;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public h u() {
        return this.i;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long m() {
        return this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j) {
        this.p = j;
        this.q = this.q > this.p ? this.q : this.p;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z) {
        this.w = z;
        this.i.c(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean s() {
        return this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j) {
        this.y = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long r() {
        return this.c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j) {
        this.c = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        if (t() == null) {
            return 0L;
        }
        return t().n();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long o() {
        if (this.n == null) {
            return 0L;
        }
        return this.n.o() + this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        this.x = z;
        if (this.n != null) {
            this.n.a(z);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long p() {
        if (this.n == null) {
            return 0L;
        }
        return this.n.p() + this.y;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean v() {
        return this.B;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        this.B = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        return this.E;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z) {
        this.F = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int q() {
        return com.bytedance.sdk.openadsdk.core.video.d.a.a(this.q, this.c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
        this.d = map;
    }

    private void a(String str) throws Exception {
        if (this.n != null) {
            com.bytedance.sdk.openadsdk.core.video.a.a aVar = new com.bytedance.sdk.openadsdk.core.video.a.a();
            aVar.f6689a = str;
            if (this.f6692b != null) {
                if (this.f6692b.F() != null) {
                    aVar.d = this.f6692b.F().k();
                }
                aVar.f6690b = String.valueOf(aj.d(this.f6692b.W()));
            }
            aVar.c = 1;
            this.n.a(aVar);
        }
        this.l = System.currentTimeMillis();
        if (!TextUtils.isEmpty(str)) {
            this.i.d(8);
            this.i.d(0);
            a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.b.a.1
                @Override // java.lang.Runnable
                public void run() {
                    a.this.l = System.currentTimeMillis();
                    a.this.i.c(0);
                    if (a.this.n == null || a.this.p != 0) {
                        if (a.this.n != null) {
                            a.this.n.a(true, a.this.p, a.this.x ? false : true);
                        }
                    } else {
                        a.this.n.a(true, 0L, a.this.x ? false : true);
                    }
                    if (a.this.k != null) {
                        a.this.k.postDelayed(a.this.G, 100L);
                    }
                    a.this.D();
                }
            });
        }
    }

    private void C() {
        int i = 5;
        int a2 = a();
        if (a2 == 2 || a2 == 1) {
            i = p.h().I() * 1000;
        } else if (a2 == 3) {
            i = p.h().f(String.valueOf(this.D));
        }
        this.k.removeCallbacks(this.H);
        this.k.postDelayed(this.H, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        E();
        this.k.postDelayed(this.I, 800L);
    }

    private void E() {
        this.k.removeCallbacks(this.I);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        this.C = new WeakReference<>(eVar);
    }

    private void b(int i) {
        if (F() && this.i != null) {
            this.k.removeCallbacks(this.H);
            this.i.w();
            this.m = System.currentTimeMillis() - this.l;
            if (this.o != null) {
                this.o.a(this.m, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.p, this.c));
            }
            if (aj.c(this.f6692b)) {
                this.i.a(this.f6692b, this.f6691a, true);
            }
            if (!this.v) {
                b();
                this.v = true;
                a(this.c, this.c);
                long j = this.c;
                this.p = j;
                this.q = j;
            }
            this.B = true;
        }
    }

    private boolean F() {
        return (this.f6691a == null || this.f6691a.get() == null) ? false : true;
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            if (this.i.k() && this.s) {
                runnable.run();
            } else {
                b(runnable);
            }
        }
    }

    private void b(Runnable runnable) {
        if (this.r == null) {
            this.r = new ArrayList<>();
        }
        this.r.add(runnable);
    }

    private void G() {
        if (this.r != null && !this.r.isEmpty()) {
            Iterator it = new ArrayList(this.r).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.r.clear();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.o = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC1013c interfaceC1013c) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void h() {
        this.h = o();
        if (this.n != null) {
            this.n.b();
        }
        if (!this.v && this.u) {
            c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        if (this.i != null) {
            this.i.e();
            this.i.q();
            this.i.u();
        }
        if (this.n != null) {
            this.n.a(false, this.p, !this.x);
            D();
        }
        if (!this.v && this.u) {
            d();
        }
    }

    public void x() {
        if (!this.v && this.u) {
            d();
        }
    }

    public void d(long j) {
        this.p = j;
        this.q = this.q > this.p ? this.q : this.p;
        if (this.i != null) {
            this.i.e();
        }
        if (this.n != null) {
            this.n.a(true, this.p, !this.x);
            D();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        if (this.n != null) {
            this.n.c();
            this.n = null;
        }
        if (this.i != null) {
            this.i.g();
        }
        if (this.k != null) {
            this.k.removeCallbacks(this.H);
            this.k.removeCallbacks(this.G);
            this.k.removeCallbacksAndMessages(null);
            E();
        }
        this.o = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z) {
        k();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        k();
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        if (this.i != null && message != null && this.f6691a != null && this.f6691a.get() != null) {
            switch (message.what) {
                case 108:
                    if ((message.obj instanceof Long) && ((Long) message.obj).longValue() > 0) {
                        this.c = ((Long) message.obj).longValue();
                        return;
                    }
                    return;
                case 109:
                    if (message.obj instanceof Long) {
                        this.p = ((Long) message.obj).longValue();
                        this.q = this.q > this.p ? this.q : this.p;
                        a(this.p, this.c);
                        return;
                    }
                    return;
                case 302:
                    b(message.what);
                    return;
                case 303:
                    a(message.arg1, message.arg2);
                    this.k.removeCallbacks(this.H);
                    if (this.i != null) {
                        this.i.w();
                    }
                    if (this.o != null) {
                        this.o.b(this.m, com.bytedance.sdk.openadsdk.core.video.d.a.a(this.p, this.c));
                        return;
                    }
                    return;
                case 304:
                    int i = message.arg1;
                    if (this.i != null) {
                        if (i == 3 || i == 702) {
                            this.i.w();
                            this.k.removeCallbacks(this.H);
                            this.E = false;
                        } else if (i == 701) {
                            this.i.t();
                            C();
                            this.E = true;
                        }
                    }
                    if (this.t && i == 3 && !this.u) {
                        this.f = SystemClock.elapsedRealtime() - this.e;
                        e();
                        this.u = true;
                        return;
                    }
                    return;
                case 305:
                    if (this.k != null) {
                        this.k.removeCallbacks(this.H);
                    }
                    if (!this.t && !this.u) {
                        this.f = SystemClock.elapsedRealtime() - this.e;
                        f();
                        this.u = true;
                    }
                    if (this.i != null) {
                        this.i.w();
                        return;
                    }
                    return;
                case ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA /* 306 */:
                    this.k.removeCallbacks(this.H);
                    if (this.i != null) {
                        this.i.w();
                        return;
                    }
                    return;
                case StatusLine.HTTP_PERM_REDIRECT /* 308 */:
                    a(StatusLine.HTTP_PERM_REDIRECT, 0);
                    return;
                case 311:
                    if (this.f6692b != null && this.f6692b.f() == 0) {
                        J();
                        return;
                    } else {
                        I();
                        return;
                    }
                case 314:
                    try {
                        ((Boolean) message.obj).booleanValue();
                    } catch (Throwable th) {
                    }
                    this.e = SystemClock.elapsedRealtime();
                    return;
                default:
                    return;
            }
        }
    }

    private boolean H() throws Throwable {
        return this.f6691a == null || this.f6691a.get() == null || K() == null || this.n == null || this.n.a() == null || this.f6692b == null || this.f6692b.B() != null || this.f6692b.h() == 1;
    }

    private void I() {
        float f;
        boolean z = true;
        try {
            u.c("changeVideoSize", "changeVideoSize start.......mMaterialMeta.getAdSlot()=" + this.f6692b.j());
            if (!H()) {
                u.c("changeVideoSize", "changeVideoSize start check condition complete ... go ..");
                int[] b2 = ak.b(p.a());
                MediaPlayer a2 = this.n.a();
                boolean z2 = this.f6692b.X() == 15;
                float f2 = b2[0];
                float f3 = b2[1];
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
                if (K() != null) {
                    if (K() instanceof TextureView) {
                        ((TextureView) K()).setLayoutParams(layoutParams);
                    } else if (K() instanceof SurfaceView) {
                        ((SurfaceView) K()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.j.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = (int) f3;
                        layoutParams2.width = (int) f2;
                        this.j.setLayoutParams(layoutParams2);
                    }
                }
                u.b("changeVideoSize", "changeVideoSize .... complete ... end !!!");
            }
        } catch (Throwable th) {
            u.c("changeVideoSize", "changeSize error", th);
        }
    }

    private void J() {
        int[] b2;
        try {
            if (this.f6691a != null && this.f6691a.get() != null && K() != null && this.n != null && this.n.a() != null && this.f6692b != null) {
                boolean z = this.f6692b.X() == 15;
                float f = ak.b(p.a())[1];
                MediaPlayer a2 = this.n.a();
                a(b2[0], f, a2.getVideoWidth(), a2.getVideoHeight(), z);
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
                f3 = this.f6692b.F().c();
                f4 = this.f6692b.F().b();
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
                if (K() != null) {
                    if (K() instanceof TextureView) {
                        ((TextureView) K()).setLayoutParams(layoutParams);
                    } else if (K() instanceof SurfaceView) {
                        ((SurfaceView) K()).setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Throwable th) {
            u.a("changeVideoSize", "changeSize error", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        if (this.n != null && F()) {
            if (this.n.g()) {
                h();
                this.i.b(true, false);
                this.i.c();
            } else if (!this.n.i()) {
                if (this.i != null) {
                    this.i.c(this.j);
                }
                d(this.p);
                if (this.i != null) {
                    this.i.b(false, false);
                }
            } else {
                j();
                if (this.i != null) {
                    this.i.b(false, false);
                }
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i) {
        if (this.n != null) {
            D();
            a(this.K, c(i));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i) {
        if (this.n != null) {
            E();
        }
        if (this.i != null) {
            this.i.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i, boolean z) {
        if (F()) {
            long l = (((float) (i * this.c)) * 1.0f) / ac.l(this.f6691a.get(), "tt_video_progress_max");
            if (this.c > 0) {
                this.K = (int) l;
            } else {
                this.K = 0L;
            }
            if (this.i != null) {
                this.i.a(this.K);
            }
        }
    }

    private void a(long j, long j2) {
        this.p = j;
        this.c = j2;
        this.i.a(j, j2);
        this.i.a(com.bytedance.sdk.openadsdk.core.video.d.a.a(j, j2));
        try {
            if (this.o != null) {
                this.o.a(j, j2);
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
        if (F()) {
            g(!this.J);
            if (!(this.f6691a.get() instanceof Activity)) {
                u.b("BaseVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.J) {
                a(z ? 8 : 0);
                if (this.i != null) {
                    this.i.a(this.j);
                    this.i.b(false);
                }
            } else {
                a(1);
                if (this.i != null) {
                    this.i.b(this.j);
                    this.i.b(false);
                }
            }
            e eVar = this.C != null ? this.C.get() : null;
            if (eVar != null) {
                eVar.a(this.J);
            }
        }
    }

    public void a(int i) {
        if (F()) {
            boolean z = i == 0 || i == 8;
            Context context = this.f6691a.get();
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
        if (this.i != null) {
            this.i.g();
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z, boolean z2) {
        if (this.w) {
            h();
        }
        if (z && !this.w && !y()) {
            this.i.b(!z(), false);
            this.i.a(z2, true, false);
        }
        if (this.n != null && this.n.g()) {
            this.i.c();
            this.i.b();
            return;
        }
        this.i.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        if (this.J) {
            g(false);
            if (this.i != null) {
                this.i.b(this.j);
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
        this.J = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        this.s = true;
        if (this.n != null) {
            this.n.a(surfaceHolder);
            G();
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b K() {
        if (this.f6691a == null || this.f6691a.get() == null || this.i == null) {
            return null;
        }
        return this.i.o();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        this.s = false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        this.s = true;
        if (this.n != null) {
            this.n.a(surfaceTexture);
            G();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        this.s = false;
    }

    public boolean y() {
        return this.n.l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void g() {
        if (this.i != null) {
            this.i.b();
            this.i.e();
        }
        if (this.i != null) {
            this.i.u();
        }
        d(-1L);
        if (this.n != null) {
            this.n.m();
        }
    }

    public boolean z() {
        return this.n != null && this.n.g();
    }

    private void a(long j, boolean z) {
        if (this.n != null) {
            if (z) {
                L();
            }
            this.n.a(j);
        }
    }

    private boolean c(int i) {
        return this.i.b(i);
    }

    private void L() {
        if (this.i != null) {
            this.i.c(0);
            this.i.a(false, false);
            this.i.b(false);
            this.i.b();
            this.i.d();
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
                this.z = false;
                this.A = true;
                return;
            default:
                return;
        }
    }

    private boolean d(int i) {
        int c = x.c(p.a());
        if (c != 4 && c != 0) {
            h();
            this.z = true;
            this.A = false;
            if (this.i == null || this.f6692b == null) {
                return true;
            }
            return this.i.a(i, this.f6692b.F());
        } else if (c == 4) {
            this.z = false;
            if (this.i != null) {
                this.i.q();
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
        if (F() && this.M != (c = x.c(context))) {
            if (!this.A) {
                d(2);
            }
            this.M = c;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        if (this.n != null) {
            this.n.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> A() {
        HashMap hashMap = new HashMap();
        if (this.d != null) {
            for (Map.Entry<String, Object> entry : this.d.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> a2 = aj.a(this.f, this.f6692b, t());
        if (a2 != null) {
            for (Map.Entry<String, Object> entry2 : a2.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Map<String, Object> B() {
        HashMap hashMap = new HashMap();
        Map<String, Object> a2 = aj.a(this.f6692b, n(), t());
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
