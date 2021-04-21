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
import com.bytedance.sdk.openadsdk.core.d.l;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.b;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.d;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.h;
import com.bytedance.sdk.openadsdk.core.widget.h;
import com.bytedance.sdk.openadsdk.utils.ad;
import com.bytedance.sdk.openadsdk.utils.ak;
import com.bytedance.sdk.openadsdk.utils.al;
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
/* loaded from: classes5.dex */
public abstract class a implements c, d, am.a {
    public WeakReference<e> D;
    public int E;
    public long L;
    public int N;

    /* renamed from: a  reason: collision with root package name */
    public final WeakReference<Context> f28344a;

    /* renamed from: b  reason: collision with root package name */
    public final l f28345b;

    /* renamed from: c  reason: collision with root package name */
    public long f28346c;
    public long i;
    public h j;
    public final ViewGroup k;
    public com.bytedance.sdk.openadsdk.core.video.d.d o;
    public c.a p;
    public ArrayList<Runnable> s;
    public boolean t;
    public final boolean u;
    public final am l = new am(this);
    public long m = 0;
    public long n = 0;
    public long q = 0;
    public long r = 0;
    public boolean v = false;
    public boolean w = false;
    public boolean x = true;
    public boolean y = false;
    public long z = 0;
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;

    /* renamed from: d  reason: collision with root package name */
    public Map<String, Object> f28347d = null;

    /* renamed from: e  reason: collision with root package name */
    public long f28348e = 0;

    /* renamed from: f  reason: collision with root package name */
    public long f28349f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f28350g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f28351h = false;
    public boolean F = false;
    public boolean G = true;
    public final Runnable H = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.o != null) {
                a.this.o.e();
            }
        }
    };
    public final Runnable I = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.3
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.p != null) {
                a.this.p.a();
            }
        }
    };
    public final Runnable J = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.4
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.o != null) {
                a aVar = a.this;
                if (aVar.f28346c <= 0) {
                    aVar.o.e();
                }
                a.this.o.f();
            }
            a.this.l.postDelayed(this, 200L);
        }
    };
    public boolean K = false;
    public final BroadcastReceiver M = new BroadcastReceiver() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.5
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
    public boolean O = false;

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.c.a$6  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass6 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f28357a;

        static {
            int[] iArr = new int[h.a.values().length];
            f28357a = iArr;
            try {
                iArr[h.a.PAUSE_VIDEO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28357a[h.a.RELEASE_VIDEO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28357a[h.a.START_VIDEO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public a(Context context, ViewGroup viewGroup, l lVar) {
        this.N = 1;
        this.N = x.c(context);
        this.k = viewGroup;
        this.f28344a = new WeakReference<>(context);
        this.f28345b = lVar;
        a(context);
        this.E = ak.d(this.f28345b.ap());
        this.u = Build.VERSION.SDK_INT >= 17;
    }

    private void D() {
        int H;
        int a2 = a();
        if (a2 != 2 && a2 != 1) {
            H = a2 == 3 ? p.h().f(String.valueOf(this.E)) : 5;
        } else {
            H = p.h().H() * 1000;
        }
        this.l.removeCallbacks(this.I);
        this.l.postDelayed(this.I, H);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        F();
        this.l.postDelayed(this.J, 800L);
    }

    private void F() {
        this.l.removeCallbacks(this.J);
    }

    private boolean G() {
        WeakReference<Context> weakReference = this.f28344a;
        return (weakReference == null || weakReference.get() == null) ? false : true;
    }

    private void H() {
        ArrayList<Runnable> arrayList = this.s;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        Iterator it = new ArrayList(this.s).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.s.clear();
    }

    private boolean I() throws Throwable {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar;
        l lVar;
        WeakReference<Context> weakReference = this.f28344a;
        return weakReference == null || weakReference.get() == null || L() == null || (dVar = this.o) == null || dVar.a() == null || (lVar = this.f28345b) == null || lVar.S() != null || this.f28345b.n() == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0124 A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:3:0x0004, B:6:0x0025, B:10:0x0047, B:14:0x005d, B:20:0x0079, B:26:0x00f3, B:33:0x0107, B:35:0x0124, B:37:0x0144, B:39:0x0156, B:41:0x015e, B:45:0x0179, B:47:0x0181, B:42:0x0168, B:44:0x0170, B:48:0x018a, B:31:0x0101, B:18:0x006d), top: B:53:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0156 A[Catch: all -> 0x0190, TryCatch #0 {all -> 0x0190, blocks: (B:3:0x0004, B:6:0x0025, B:10:0x0047, B:14:0x005d, B:20:0x0079, B:26:0x00f3, B:33:0x0107, B:35:0x0124, B:37:0x0144, B:39:0x0156, B:41:0x015e, B:45:0x0179, B:47:0x0181, B:42:0x0168, B:44:0x0170, B:48:0x018a, B:31:0x0101, B:18:0x006d), top: B:53:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void J() {
        try {
            u.c("changeVideoSize", "changeVideoSize start.......mMaterialMeta.getAdSlot()=" + this.f28345b.p());
            if (I()) {
                return;
            }
            u.c("changeVideoSize", "changeVideoSize start check condition complete ... go ..");
            int[] b2 = al.b(p.a());
            MediaPlayer a2 = this.o.a();
            boolean z = false;
            boolean z2 = this.f28345b.aq() == 15;
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
                    videoHeight = f3;
                    z = true;
                }
                u.c("changeVideoSize", "适配后宽高：videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
                if (z) {
                    u.c("changeVideoSize", " 屏幕比例和视频比例相同，以及其他情况都按照屏幕宽高播放，videoHeight=" + f3 + "，videoWidth=" + f2);
                } else {
                    f2 = videoWidth;
                    f3 = videoHeight;
                }
                int i = (int) f2;
                int i2 = (int) f3;
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
                layoutParams.addRule(13);
                if (L() != null) {
                    if (L() instanceof TextureView) {
                        ((TextureView) L()).setLayoutParams(layoutParams);
                    } else if (L() instanceof SurfaceView) {
                        ((SurfaceView) L()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.k.getLayoutParams();
                    if (layoutParams2 != null) {
                        layoutParams2.height = i2;
                        layoutParams2.width = i;
                        this.k.setLayoutParams(layoutParams2);
                    }
                }
                u.b("changeVideoSize", "changeVideoSize .... complete ... end !!!");
            }
            if (f5 > 1.7777778f && f4 == 1.7777778f) {
                videoHeight = (9.0f * f2) / 16.0f;
                videoWidth = f2;
                z = true;
            }
            u.c("changeVideoSize", "适配后宽高：videoHeight=" + videoHeight + ",videoWidth=" + videoWidth);
            if (z) {
            }
            int i3 = (int) f2;
            int i22 = (int) f3;
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i3, i22);
            layoutParams3.addRule(13);
            if (L() != null) {
            }
            u.b("changeVideoSize", "changeVideoSize .... complete ... end !!!");
        } catch (Throwable th) {
            u.c("changeVideoSize", "changeSize error", th);
        }
    }

    private void K() {
        int[] b2;
        try {
            if (this.f28344a != null && this.f28344a.get() != null && L() != null && this.o != null && this.o.a() != null && this.f28345b != null) {
                boolean z = this.f28345b.aq() == 15;
                float f2 = al.b(p.a())[1];
                MediaPlayer a2 = this.o.a();
                a(b2[0], f2, a2.getVideoWidth(), a2.getVideoHeight(), z);
                u.b("changeVideoSize", "changeSize=end");
            }
        } catch (Throwable th) {
            u.a("changeVideoSize", "changeSize error", th);
        }
    }

    private com.bytedance.sdk.openadsdk.core.video.renderview.b L() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar;
        WeakReference<Context> weakReference = this.f28344a;
        if (weakReference == null || weakReference.get() == null || (hVar = this.j) == null) {
            return null;
        }
        return hVar.o();
    }

    private void M() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
        if (hVar != null) {
            hVar.c(0);
            this.j.a(false, false);
            this.j.b(false);
            this.j.b();
            this.j.d();
        }
    }

    public boolean A() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        return dVar != null && dVar.g();
    }

    public Map<String, Object> B() {
        HashMap hashMap = new HashMap();
        Map<String, Object> map = this.f28347d;
        if (map != null) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> a2 = ak.a(this.f28349f, this.f28345b, u());
        if (a2 != null) {
            for (Map.Entry<String, Object> entry2 : a2.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }

    public Map<String, Object> C() {
        HashMap hashMap = new HashMap();
        Map<String, Object> a2 = ak.a(this.f28345b, o(), u());
        if (a2 != null) {
            for (Map.Entry<String, Object> entry : a2.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, Object> map = this.f28347d;
        if (map != null) {
            for (Map.Entry<String, Object> entry2 : map.entrySet()) {
                hashMap.put(entry2.getKey(), entry2.getValue());
            }
        }
        return hashMap;
    }

    public abstract int a();

    public abstract void a(int i, int i2);

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder, int i, int i2, int i3) {
    }

    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.InterfaceC0317c interfaceC0317c) {
    }

    public abstract void b();

    public abstract void c();

    public abstract void d();

    public abstract void e();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void e(boolean z) {
    }

    public abstract void f();

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void f(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void i() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.b();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void j() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.d();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void k() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
        if (hVar != null) {
            hVar.e();
            this.j.q();
            this.j.u();
        }
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.a(false, this.q, !this.y);
            E();
        }
        if (this.w || !this.v) {
            return;
        }
        d();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void l() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.c();
            this.o = null;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
        if (hVar != null) {
            hVar.g();
        }
        am amVar = this.l;
        if (amVar != null) {
            amVar.removeCallbacks(this.I);
            this.l.removeCallbacks(this.H);
            this.l.removeCallbacksAndMessages(null);
            F();
        }
        this.p = null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void m() {
        l();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long n() {
        return this.q;
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
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar == null) {
            return 0L;
        }
        return dVar.o() + this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long q() {
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar == null) {
            return 0L;
        }
        return dVar.p() + this.z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public int r() {
        return com.bytedance.sdk.openadsdk.core.video.e.a.a(this.r, this.f28346c);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public long s() {
        return this.f28346c;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean t() {
        return this.A;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.d.d u() {
        return this.o;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public com.bytedance.sdk.openadsdk.core.video.nativevideo.h v() {
        return this.j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean w() {
        return this.C;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean x() {
        return this.F;
    }

    public void y() {
        if (this.w || !this.v) {
            return;
        }
        d();
    }

    public boolean z() {
        return this.o.l();
    }

    private void g(boolean z) {
        this.K = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(boolean z) {
        this.x = z;
        this.j.c(z);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(long j) {
        this.f28346c = j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void d(boolean z) {
        this.C = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void e(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        a(bVar, view, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void f(boolean z) {
        this.G = z;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void h() {
        this.i = p();
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.b();
        }
        if (this.w || !this.v) {
            return;
        }
        c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void c(boolean z) {
        this.y = z;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.b(z);
        }
    }

    public void d(long j) {
        this.q = j;
        long j2 = this.r;
        if (j2 > j) {
            j = j2;
        }
        this.r = j;
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
        if (hVar != null) {
            hVar.e();
        }
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.a(true, this.q, !this.y);
            E();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void g() {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
        if (hVar != null) {
            hVar.b();
            this.j.e();
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.j;
        if (hVar2 != null) {
            hVar2.u();
        }
        d(-1L);
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.m();
        }
    }

    @SuppressLint({"InflateParams"})
    private void a(Context context) {
        EnumSet noneOf = EnumSet.noneOf(b.a.class);
        noneOf.add(b.a.hideCloseBtn);
        noneOf.add(b.a.hideBackBtn);
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = new com.bytedance.sdk.openadsdk.core.video.nativevideo.h(context.getApplicationContext(), LayoutInflater.from(context.getApplicationContext()).inflate(ad.f(context, "tt_video_play_layout_for_live"), (ViewGroup) null, false), true, noneOf, this.f28345b, this);
        this.j = hVar;
        hVar.a(this);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void b(long j) {
        this.z = j;
    }

    private void b(int i) {
        if (G() && this.j != null) {
            this.l.removeCallbacks(this.I);
            this.j.w();
            long currentTimeMillis = System.currentTimeMillis() - this.m;
            this.n = currentTimeMillis;
            c.a aVar = this.p;
            if (aVar != null) {
                aVar.a(currentTimeMillis, com.bytedance.sdk.openadsdk.core.video.e.a.a(this.q, this.f28346c));
            }
            if (ak.d(this.f28345b)) {
                this.j.a(this.f28345b, this.f28344a, true);
            }
            if (!this.w) {
                b();
                this.w = true;
                long j = this.f28346c;
                a(j, j);
                long j2 = this.f28346c;
                this.q = j2;
                this.r = j2;
            }
            this.C = true;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void c(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
        if (hVar != null) {
            hVar.g();
        }
        a(true);
    }

    private boolean c(int i) {
        return this.j.b(i);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void d(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        if (this.K) {
            g(false);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
            if (hVar != null) {
                hVar.b(this.k);
            }
            a(1);
            return;
        }
        a(true);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public boolean a(String str, String str2, int i, int i2, List<String> list, String str3, long j, boolean z) {
        u.b("BaseVideoController", "video local url " + str);
        if (TextUtils.isEmpty(str)) {
            u.f("BaseVideoController", "No video info");
            return false;
        }
        this.f28350g = !str.startsWith("http");
        this.y = z;
        if (j > 0) {
            this.q = j;
            long j2 = this.r;
            if (j2 > j) {
                j = j2;
            }
            this.r = j;
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
        if (hVar != null) {
            hVar.e();
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
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean d(int i) {
        l lVar;
        int c2 = x.c(p.a());
        if (c2 != 4 && c2 != 0) {
            h();
            this.A = true;
            this.B = false;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
            if (hVar != null && (lVar = this.f28345b) != null) {
                return hVar.a(i, lVar.X(), true);
            }
        } else if (c2 == 4) {
            this.A = false;
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.j;
            if (hVar2 != null) {
                hVar2.q();
            }
        }
        return true;
    }

    private void b(Runnable runnable) {
        if (this.s == null) {
            this.s = new ArrayList<>();
        }
        this.s.add(runnable);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i) {
        if (this.o != null) {
            F();
        }
        com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
        if (hVar != null) {
            hVar.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view) {
        b(bVar, view, false, false);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(long j) {
        this.q = j;
        long j2 = this.r;
        if (j2 > j) {
            j = j2;
        }
        this.r = j;
    }

    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z, boolean z2) {
        if (G()) {
            g(!this.K);
            if (!(this.f28344a.get() instanceof Activity)) {
                u.b("BaseVideoController", "context is not activity, not support this function.");
                return;
            }
            if (this.K) {
                a(z ? 8 : 0);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
                if (hVar != null) {
                    hVar.a(this.k);
                    this.j.b(false);
                }
            } else {
                a(1);
                com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.j;
                if (hVar2 != null) {
                    hVar2.b(this.k);
                    this.j.b(false);
                }
            }
            WeakReference<e> weakReference = this.D;
            e eVar = weakReference != null ? weakReference.get() : null;
            if (eVar != null) {
                eVar.a(this.K);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(Map<String, Object> map) {
        this.f28347d = map;
    }

    private void a(String str) throws Exception {
        if (this.o != null) {
            com.bytedance.sdk.openadsdk.core.video.b.a aVar = new com.bytedance.sdk.openadsdk.core.video.b.a();
            aVar.f28340a = str;
            l lVar = this.f28345b;
            if (lVar != null) {
                if (lVar.X() != null) {
                    aVar.f28343d = this.f28345b.X().l();
                }
                aVar.f28341b = String.valueOf(ak.d(this.f28345b.ap()));
            }
            aVar.f28342c = 1;
            this.o.a(aVar);
        }
        this.m = System.currentTimeMillis();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.j.d(8);
        this.j.d(0);
        a(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.c.a.1
            @Override // java.lang.Runnable
            public void run() {
                a.this.m = System.currentTimeMillis();
                a.this.j.c(0);
                if (a.this.o == null || a.this.q != 0) {
                    if (a.this.o != null) {
                        a.this.o.a(true, a.this.q, !a.this.y);
                    }
                } else {
                    a.this.o.a(true, 0L, !a.this.y);
                }
                if (a.this.l != null) {
                    a.this.l.postDelayed(a.this.H, 100L);
                }
                a.this.E();
            }
        });
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        this.t = false;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.a(false);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(e eVar) {
        this.D = new WeakReference<>(eVar);
    }

    private void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (this.j.k() && this.t) {
            runnable.run();
        } else {
            b(runnable);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void b(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        this.t = false;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null) {
            dVar.a(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Context context) {
        int c2;
        if (G() && this.N != (c2 = x.c(context))) {
            if (!this.B) {
                d(2);
            }
            this.N = c2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(c.a aVar) {
        this.p = aVar;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.c
    public void a(boolean z) {
        l();
    }

    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    public void a(Message message) {
        WeakReference<Context> weakReference;
        if (this.j == null || message == null || (weakReference = this.f28344a) == null || weakReference.get() == null) {
            return;
        }
        int i = message.what;
        if (i == 108) {
            Object obj = message.obj;
            if (!(obj instanceof Long) || ((Long) obj).longValue() <= 0) {
                return;
            }
            this.f28346c = ((Long) message.obj).longValue();
        } else if (i == 109) {
            Object obj2 = message.obj;
            if (obj2 instanceof Long) {
                long longValue = ((Long) obj2).longValue();
                this.q = longValue;
                long j = this.r;
                if (j > longValue) {
                    longValue = j;
                }
                this.r = longValue;
                a(this.q, this.f28346c);
            }
        } else if (i == 308) {
            a(308, 0);
        } else if (i == 311) {
            l lVar = this.f28345b;
            if (lVar != null && lVar.l() == 0) {
                K();
            } else {
                J();
            }
        } else if (i != 314) {
            switch (i) {
                case 302:
                    b(i);
                    return;
                case 303:
                    a(message.arg1, message.arg2);
                    this.l.removeCallbacks(this.I);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
                    if (hVar != null) {
                        hVar.w();
                    }
                    c.a aVar = this.p;
                    if (aVar != null) {
                        aVar.b(this.n, com.bytedance.sdk.openadsdk.core.video.e.a.a(this.q, this.f28346c));
                        return;
                    }
                    return;
                case 304:
                    int i2 = message.arg1;
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.j;
                    if (hVar2 != null) {
                        if (i2 == 3 || i2 == 702) {
                            this.j.w();
                            this.l.removeCallbacks(this.I);
                            this.F = false;
                        } else if (i2 == 701) {
                            hVar2.t();
                            D();
                            this.F = true;
                        }
                    }
                    if (this.u && i2 == 3 && !this.v) {
                        this.f28349f = SystemClock.elapsedRealtime() - this.f28348e;
                        e();
                        this.v = true;
                        this.f28351h = true;
                        return;
                    }
                    return;
                case 305:
                    am amVar = this.l;
                    if (amVar != null) {
                        amVar.removeCallbacks(this.I);
                    }
                    if (!this.u && !this.v) {
                        this.f28349f = SystemClock.elapsedRealtime() - this.f28348e;
                        f();
                        this.v = true;
                    }
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar3 = this.j;
                    if (hVar3 != null) {
                        hVar3.w();
                        return;
                    }
                    return;
                case 306:
                    this.l.removeCallbacks(this.I);
                    com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar4 = this.j;
                    if (hVar4 != null) {
                        hVar4.w();
                        return;
                    }
                    return;
                default:
                    return;
            }
        } else {
            this.f28348e = SystemClock.elapsedRealtime();
        }
    }

    private void a(float f2, float f3, float f4, float f5, boolean z) {
        RelativeLayout.LayoutParams layoutParams;
        try {
            u.b("changeVideoSize", "screenWidth=" + f2 + ",screenHeight=" + f3);
            u.b("changeVideoSize", "videoHeight=" + f5 + ",videoWidth=" + f4);
            if (f4 <= 0.0f || f5 <= 0.0f) {
                f4 = this.f28345b.X().c();
                f5 = this.f28345b.X().b();
            }
            if (f5 > 0.0f && f4 > 0.0f) {
                if (z) {
                    if (f4 < f5) {
                        return;
                    }
                    u.b("changeVideoSize", "竖屏模式下按视频宽度计算放大倍数值");
                    layoutParams = new RelativeLayout.LayoutParams((int) f2, (int) ((f5 * f2) / f4));
                    layoutParams.addRule(13);
                } else if (f4 > f5) {
                    return;
                } else {
                    u.b("changeVideoSize", "横屏模式下按视频高度计算放大倍数值");
                    RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) ((f4 * f3) / f5), (int) f3);
                    layoutParams2.addRule(13);
                    layoutParams = layoutParams2;
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
        if (this.o == null || !G()) {
            return;
        }
        if (this.o.g()) {
            h();
            this.j.b(true, false);
            this.j.c();
        } else if (!this.o.i()) {
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
            if (hVar != null) {
                hVar.c(this.k);
            }
            d(this.q);
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar2 = this.j;
            if (hVar2 != null) {
                hVar2.b(false, false);
            }
        } else {
            k();
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar3 = this.j;
            if (hVar3 != null) {
                hVar3.b(false, false);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i) {
        if (this.o == null) {
            return;
        }
        E();
        a(this.L, c(i));
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, int i, boolean z) {
        if (G()) {
            long l = (((float) (i * this.f28346c)) * 1.0f) / ad.l(this.f28344a.get(), "tt_video_progress_max");
            if (this.f28346c > 0) {
                this.L = (int) l;
            } else {
                this.L = 0L;
            }
            com.bytedance.sdk.openadsdk.core.video.nativevideo.h hVar = this.j;
            if (hVar != null) {
                hVar.a(this.L);
            }
        }
    }

    private void a(long j, long j2) {
        this.q = j;
        this.f28346c = j2;
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

    public void a(int i) {
        if (G()) {
            boolean z = i == 0 || i == 8;
            Context context = this.f28344a.get();
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
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, View view, boolean z, boolean z2) {
        if (this.x) {
            h();
        }
        if (z && !this.x && !z()) {
            this.j.b(!A(), false);
            this.j.a(z2, true, false);
        }
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar != null && dVar.g()) {
            this.j.c();
            this.j.b();
            return;
        }
        this.j.c();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceHolder surfaceHolder) {
        this.t = true;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar == null) {
            return;
        }
        if (dVar != null) {
            dVar.a(true);
        }
        this.o.a(surfaceHolder);
        H();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.a
    public void a(com.bytedance.sdk.openadsdk.core.video.nativevideo.b bVar, SurfaceTexture surfaceTexture) {
        this.t = true;
        com.bytedance.sdk.openadsdk.core.video.d.d dVar = this.o;
        if (dVar == null) {
            return;
        }
        if (dVar != null) {
            dVar.a(true);
        }
        this.o.a(surfaceTexture);
        H();
    }

    private void a(long j, boolean z) {
        if (this.o == null) {
            return;
        }
        if (z) {
            M();
        }
        this.o.a(j);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.d
    public void a(h.a aVar, String str) {
        int i = AnonymousClass6.f28357a[aVar.ordinal()];
        if (i == 1) {
            h();
        } else if (i == 2) {
            a(true);
        } else if (i != 3) {
        } else {
            k();
            this.A = false;
            this.B = true;
        }
    }
}
