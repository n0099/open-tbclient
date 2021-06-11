package com.bytedance.sdk.openadsdk.core.video.d;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.utils.am;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class d implements c.a, c.b, c.InterfaceC0298c, c.d, c.e, c.f, c.g, am.a {
    public static boolean m = false;
    public static final SparseIntArray o = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    public c f28520a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28521b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28522c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28523d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28524e;

    /* renamed from: f  reason: collision with root package name */
    public int f28525f;

    /* renamed from: g  reason: collision with root package name */
    public long f28526g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f28527h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f28528i;
    public ArrayList<Runnable> j;
    public int k;
    public int l;
    public String n;
    public boolean p;
    public Runnable q;
    public boolean r;
    public final Object s;
    public StringBuilder t;
    public boolean u;
    public long v;
    public long w;
    public long x;
    public long y;
    public boolean z;

    public d(Handler handler) {
        this(handler, -1);
    }

    private int A() {
        AudioManager audioManager = (AudioManager) p.a().getSystemService("audio");
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return -1;
    }

    private void B() {
        if (m) {
            a(this.l, false);
            m = false;
        }
    }

    private void C() {
        if (this.w <= 0) {
            this.w = System.currentTimeMillis();
        }
    }

    private void D() {
        if (this.w > 0) {
            this.v += System.currentTimeMillis() - this.w;
            this.w = 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f28520a == null) {
            u.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
            b bVar = new b();
            this.f28520a = bVar;
            this.n = "0";
            bVar.a((c.e) this);
            this.f28520a.a((c.b) this);
            this.f28520a.a((c.InterfaceC0298c) this);
            this.f28520a.a((c.a) this);
            this.f28520a.a((c.f) this);
            this.f28520a.a((c.d) this);
            this.f28520a.a((c.g) this);
            try {
                this.f28520a.b(this.f28521b);
            } catch (Throwable th) {
                u.a("SSMediaPlayeWrapper", "setLooping error: ", th);
            }
            this.f28522c = false;
        }
    }

    private void r() {
        u.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke !");
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f28527h != null) {
                    d.this.f28527h.sendEmptyMessage(104);
                    u.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
                }
            }
        });
    }

    private void s() {
        c cVar = this.f28520a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.l();
        } catch (Throwable th) {
            u.a("SSMediaPlayeWrapper", "releaseMediaplayer error1: ", th);
        }
        this.f28520a.a((c.b) null);
        this.f28520a.a((c.g) null);
        this.f28520a.a((c.a) null);
        this.f28520a.a((c.d) null);
        this.f28520a.a((c.InterfaceC0298c) null);
        this.f28520a.a((c.e) null);
        this.f28520a.a((c.f) null);
        try {
            this.f28520a.k();
        } catch (Throwable th2) {
            u.a("SSMediaPlayeWrapper", "releaseMediaplayer error2: ", th2);
        }
    }

    private void t() {
        Handler handler = this.f28527h;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        try {
            u.b("SSMediaPlayeWrapper", "onDestory............");
            this.f28527h.getLooper().quit();
        } catch (Throwable th) {
            u.a("SSMediaPlayeWrapper", "onDestroy error: ", th);
        }
    }

    private void u() {
        Integer valueOf = Integer.valueOf(o.get(this.k));
        if (valueOf == null) {
            o.put(this.k, 1);
        } else {
            o.put(this.k, Integer.valueOf(valueOf.intValue() + 1).intValue());
        }
    }

    private void v() {
        if (this.z || this.w > 0) {
            return;
        }
        this.w = System.currentTimeMillis();
    }

    private void w() {
        if (this.f28523d) {
            return;
        }
        this.f28523d = true;
        Iterator it = new ArrayList(this.j).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.j.clear();
        this.f28523d = false;
    }

    private void x() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        w();
    }

    private void y() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList != null && !arrayList.isEmpty()) {
            w();
        } else {
            t();
        }
    }

    private void z() {
        ArrayList<Runnable> arrayList = this.j;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        this.j.clear();
    }

    public void d() {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f28527h != null) {
                    d.this.f28527h.sendEmptyMessage(105);
                }
            }
        });
    }

    public void e() {
        Handler handler = this.f28527h;
        if (handler != null) {
            handler.obtainMessage(108).sendToTarget();
        }
    }

    public void f() {
        Handler handler = this.f28527h;
        if (handler != null) {
            handler.obtainMessage(109).sendToTarget();
        }
    }

    public boolean g() {
        return (this.f28525f == 206 || this.f28527h.hasMessages(100)) && !this.r;
    }

    public boolean h() {
        return k() || g() || i();
    }

    public boolean i() {
        return (this.f28525f == 207 || this.r) && !this.f28527h.hasMessages(100);
    }

    public boolean j() {
        return this.f28525f == 203;
    }

    public boolean k() {
        return this.f28525f == 205;
    }

    public boolean l() {
        return this.f28525f == 209;
    }

    public void m() {
        this.v = 0L;
        this.w = System.currentTimeMillis();
    }

    public long n() {
        return this.y;
    }

    public long o() {
        D();
        return this.v;
    }

    public long p() {
        if (this.w > 0) {
            this.v += System.currentTimeMillis() - this.w;
            this.w = System.currentTimeMillis();
        }
        return this.v;
    }

    @SuppressLint({"unused"})
    public d(Handler handler, int i2) {
        this.f28520a = null;
        this.f28521b = false;
        this.f28522c = false;
        this.f28525f = 201;
        this.f28526g = -1L;
        this.k = 0;
        this.n = "0";
        this.q = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.f28527h.sendEmptyMessageDelayed(100, 0L);
                u.b("tag_video_play", "[video] MediaPlayerProxy#start not first play ! sendMsg --> OP_START , video start to play !");
            }
        };
        this.s = new Object();
        this.t = null;
        this.u = false;
        this.v = 0L;
        this.w = 0L;
        this.x = 0L;
        this.y = 0L;
        this.z = false;
        this.k = 0;
        this.f28528i = handler;
        HandlerThread handlerThread = new HandlerThread("VideoManager");
        handlerThread.start();
        this.f28527h = new am(handlerThread.getLooper(), this);
        this.z = Build.VERSION.SDK_INT >= 17;
        q();
    }

    public void b() {
        this.f28527h.removeMessages(100);
        this.r = true;
        this.f28527h.sendEmptyMessage(101);
        D();
    }

    public void c() {
        this.f28525f = 203;
        D();
        z();
        if (this.f28527h != null) {
            try {
                b("release");
                this.f28527h.removeCallbacksAndMessages(null);
                if (this.f28520a != null) {
                    this.f28524e = true;
                    this.f28527h.sendEmptyMessage(103);
                }
            } catch (Throwable th) {
                t();
                u.a("SSMediaPlayeWrapper", "release error: ", th);
            }
        }
    }

    public void a(boolean z) {
        this.p = z;
    }

    public MediaPlayer a() throws Throwable {
        c cVar = this.f28520a;
        if (cVar != null) {
            return ((b) cVar).e();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.d
    public boolean b(c cVar, int i2, int i3) {
        u.f("SSMediaPlayeWrapper", "what,extra:" + i2 + "," + i3);
        if (this.f28520a != cVar) {
            return false;
        }
        Handler handler = this.f28528i;
        if (handler != null) {
            handler.obtainMessage(304, i2, i3).sendToTarget();
            if (i3 == -1004) {
                this.f28528i.obtainMessage(303, i2, i3).sendToTarget();
            }
        }
        b(i2, i3);
        return false;
    }

    public void a(boolean z, long j, boolean z2) {
        u.b("tag_video_play", "[video] MediaPlayerProxy#start firstSeekToPosition=" + j + ",firstPlay :" + z + ",isPauseOtherMusicVolume=" + z2);
        this.r = false;
        if (!z2) {
            if (this.f28520a != null) {
                b(true);
            }
        } else if (this.f28520a != null) {
            b(false);
        }
        if (z) {
            u.b("tag_video_play", "[video] first start , SSMediaPlayer  start method !");
            r();
            this.f28526g = j;
            return;
        }
        C();
        c cVar = this.f28520a;
        if (cVar != null) {
            try {
                if (j <= cVar.i()) {
                    j = this.f28520a.i();
                }
                this.f28526g = j;
            } catch (Throwable th) {
                u.b("tag_video_play", "[video] MediaPlayerProxy#start  error: getCurrentPosition :" + th.toString());
            }
        }
        if (this.p) {
            b(this.q);
        } else {
            a(this.q);
        }
    }

    private void b(int i2, int i3) {
        if (i2 == 701) {
            D();
            this.x = SystemClock.elapsedRealtime();
        } else if (i2 == 702) {
            if (this.w <= 0) {
                this.w = System.currentTimeMillis();
            }
            if (this.x > 0) {
                this.y += SystemClock.elapsedRealtime() - this.x;
                this.x = 0L;
            }
        } else if (this.z && i2 == 3 && this.w <= 0) {
            this.w = System.currentTimeMillis();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.f
    public void c(c cVar) {
        Handler handler = this.f28528i;
        if (handler != null) {
            handler.sendEmptyMessage(306);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.e
    public void b(c cVar) {
        this.f28525f = 205;
        if (this.r) {
            this.f28527h.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.f28520a.h();
                        d.this.f28525f = 207;
                        d.this.r = false;
                    } catch (Throwable th) {
                        u.a("SSMediaPlayeWrapper", "onPrepared error: ", th);
                    }
                }
            });
        } else {
            Handler handler = this.f28527h;
            handler.sendMessage(handler.obtainMessage(100, -1, -1));
        }
        o.delete(this.k);
        Handler handler2 = this.f28528i;
        if (handler2 != null) {
            handler2.sendEmptyMessage(305);
        }
        v();
    }

    public void a(final long j) {
        D();
        int i2 = this.f28525f;
        if (i2 == 207 || i2 == 206 || i2 == 209) {
            b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f28527h != null) {
                        d.this.f28527h.obtainMessage(106, Long.valueOf(j)).sendToTarget();
                    }
                }
            });
        }
    }

    public void a(final SurfaceTexture surfaceTexture) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.5
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.f28527h != null) {
                    d.this.f28527h.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    public void a(final SurfaceHolder surfaceHolder) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.6
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.f28527h != null) {
                    d.this.f28527h.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public void a(final com.bytedance.sdk.openadsdk.core.video.b.a aVar) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.7
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.f28527h != null) {
                    d.this.f28527h.obtainMessage(107, aVar).sendToTarget();
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a1 A[Catch: all -> 0x01ae, TRY_LEAVE, TryCatch #5 {all -> 0x01ae, blocks: (B:43:0x00df, B:46:0x00f0, B:49:0x00f7, B:51:0x00fd, B:54:0x0103, B:56:0x011a, B:58:0x0122, B:73:0x0199, B:75:0x01a1, B:59:0x012a, B:61:0x014a, B:63:0x0150, B:65:0x0158, B:66:0x017e, B:67:0x0184, B:69:0x018a, B:71:0x0190, B:72:0x0194), top: B:167:0x00df }] */
    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Message message) {
        boolean z;
        long i2;
        int i3 = message.what;
        u.b("tag_video_play", "[video]  execute , mCurrentState = " + this.f28525f + " handlerMsg=" + i3);
        c cVar = this.f28520a;
        if (cVar != null) {
            long j = 0;
            switch (message.what) {
                case 100:
                    int i4 = this.f28525f;
                    if (i4 == 205 || i4 == 206 || i4 == 207 || i4 == 209) {
                        try {
                            this.f28520a.f();
                            u.b("tag_video_play", "[video] OP_START execute , mMediaPlayer real start !");
                            this.f28525f = 206;
                            if (this.f28526g >= 0) {
                                this.f28520a.a(this.f28526g);
                                this.f28526g = -1L;
                            }
                            if (this.f28528i != null) {
                                this.f28528i.removeMessages(312);
                                this.f28528i.sendEmptyMessage(313);
                            }
                        } catch (Throwable th) {
                            u.a("tag_video_play", "OP_START error: ", th);
                        }
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 101:
                    int i5 = this.f28525f;
                    if (i5 == 206 || i5 == 207 || i5 == 209) {
                        try {
                            u.b("tag_video_play", "[video] OP_PAUSE execute , mMediaPlayer  OP_PAUSE !");
                            this.f28520a.h();
                            this.f28525f = 207;
                            try {
                                this.r = false;
                            } catch (Throwable th2) {
                                th = th2;
                                u.a("NativeVideoController", "OP_PAUSE error: ", th);
                                z = false;
                                if (z) {
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                        z = false;
                    }
                    z = true;
                    break;
                case 102:
                    try {
                        cVar.l();
                        u.b("tag_video_play", "[video] OP_RELEASE execute , releaseMediaplayer !");
                        this.f28525f = 201;
                        break;
                    } catch (Throwable th4) {
                        u.a("SSMediaPlayeWrapper", "OP_RESET error: ", th4);
                        break;
                    }
                case 103:
                    try {
                        s();
                        u.b("tag_video_play", "[video] OP_RELEASE execute , releaseMediaplayer !");
                    } catch (Throwable th5) {
                        u.c("NativeVideoController", "OP_RELEASE error: ", th5);
                    }
                    this.f28524e = false;
                    a(309, (Object) null);
                    this.f28525f = 203;
                    this.f28520a = null;
                    y();
                    break;
                case 104:
                    int i6 = this.f28525f;
                    if (i6 == 202 || i6 == 208) {
                        try {
                            ((b) this.f28520a).e().prepareAsync();
                            u.b("tag_video_play", "[video] OP_PREPARE_ASYNC execute , mMediaPlayer real prepareAsync !");
                            if (this.f28528i != null) {
                                this.f28528i.sendEmptyMessageDelayed(312, 10000L);
                                break;
                            }
                        } catch (Throwable th6) {
                            u.c("NativeVideoController", "OP_PREPARE_ASYNC error: ", th6);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 105:
                    int i7 = this.f28525f;
                    if (i7 == 205 || i7 == 206 || i7 == 208 || i7 == 207 || i7 == 209) {
                        try {
                            this.f28520a.g();
                            this.f28525f = 208;
                            break;
                        } catch (Throwable th7) {
                            u.a("SSMediaPlayeWrapper", "OP_STOP error: ", th7);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 106:
                    int i8 = this.f28525f;
                    if (i8 == 206 || i8 == 207 || i8 == 209) {
                        try {
                            this.f28520a.a(((Long) message.obj).longValue());
                            break;
                        } catch (Throwable th8) {
                            u.a("SSMediaPlayeWrapper", "OP_SEEKTO error: ", th8);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 107:
                    int i9 = this.f28525f;
                    if (i9 == 201 || i9 == 203) {
                        try {
                            com.bytedance.sdk.openadsdk.core.video.b.a aVar = (com.bytedance.sdk.openadsdk.core.video.b.a) message.obj;
                            String str = aVar.f28486a;
                            String a2 = com.bytedance.sdk.openadsdk.core.video.a.a.a(str);
                            if (!TextUtils.isEmpty(a2)) {
                                str = a2;
                            }
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            if (!str.startsWith("/") && aVar.f28488c != 1) {
                                com.bytedance.sdk.openadsdk.k.f.b b2 = new com.bytedance.sdk.openadsdk.k.f.b().a(aVar.f28486a).b(aVar.f28489d);
                                if (Build.VERSION.SDK_INT >= 23 && str.startsWith("http")) {
                                    this.f28520a.a(str, aVar.f28489d);
                                } else {
                                    String b3 = com.bytedance.sdk.openadsdk.k.f.a.a().b(b2);
                                    u.f("cache009", "使用Video缓存-OP_SET_DATASOURCE-proxyurl=" + b3);
                                    if (b3 != null && com.bytedance.sdk.openadsdk.multipro.b.b() && b3.startsWith("file")) {
                                        Uri parse = Uri.parse(b3);
                                        u.f("cache010", "使用uri parse =" + parse.getPath());
                                        a(parse.getPath());
                                    } else {
                                        this.f28520a.a(b3);
                                    }
                                }
                                this.f28525f = 202;
                                if (this.f28528i != null) {
                                    this.f28528i.obtainMessage(314).sendToTarget();
                                    break;
                                }
                            }
                            if (com.bytedance.sdk.openadsdk.multipro.b.b() && str.startsWith("/")) {
                                a(str);
                            } else {
                                this.f28520a.a(str);
                            }
                            this.f28525f = 202;
                            if (this.f28528i != null) {
                            }
                        } catch (Throwable th9) {
                            u.a("SSMediaPlayeWrapper", "OP_SET_DATASOURCE error: ", th9);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 108:
                    int i10 = this.f28525f;
                    if (i10 == 206 || i10 == 207) {
                        try {
                            j = this.f28520a.j();
                        } catch (Throwable th10) {
                            u.a("SSMediaPlayeWrapper", "OP_REQUEST_DURATION error: ", th10);
                        }
                    }
                    a(108, Long.valueOf(j));
                    break;
                case 109:
                    int i11 = this.f28525f;
                    if (i11 == 206 || i11 == 207) {
                        try {
                            i2 = this.f28520a.i();
                        } catch (Throwable th11) {
                            u.a("SSMediaPlayeWrapper", "OP_REQUEST_CUR_POSITION error: ", th11);
                        }
                        if (i2 > 0) {
                            a(109, Long.valueOf(i2));
                            break;
                        }
                    }
                    i2 = 0;
                    if (i2 > 0) {
                    }
                    break;
                case 110:
                    try {
                        cVar.a((SurfaceHolder) message.obj);
                        if (this.k == 2) {
                            this.f28520a.a(p.a(), 10);
                        }
                        this.f28520a.a(true);
                        break;
                    } catch (Throwable th12) {
                        u.a("SSMediaPlayeWrapper", "OP_SET_DISPLAY error: ", th12);
                        break;
                    }
                case 111:
                    try {
                        if (Build.VERSION.SDK_INT >= 14) {
                            cVar.a(new Surface((SurfaceTexture) message.obj));
                        }
                        this.f28520a.a(true);
                        this.f28520a.a(p.a(), 10);
                        x();
                        break;
                    } catch (Throwable th13) {
                        u.a("SSMediaPlayeWrapper", "OP_SET_SURFACE error: ", th13);
                        break;
                    }
            }
            if (z) {
                this.f28525f = 200;
                if (this.f28522c) {
                    return;
                }
                a(308, Integer.valueOf(i3));
                this.f28522c = true;
                return;
            }
            return;
        }
        z = false;
        if (z) {
        }
    }

    private void b(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!this.f28524e) {
            runnable.run();
        } else {
            a(runnable);
        }
    }

    public void b(boolean z) {
        try {
            if (z) {
                this.f28520a.a(0.0f, 0.0f);
            } else {
                this.f28520a.a(1.0f, 1.0f);
            }
        } catch (Throwable th) {
            u.a("SSMediaPlayeWrapper", "setQuietPlay error: ", th);
        }
    }

    private void b(String str) {
        Handler handler = this.f28527h;
        if (handler != null) {
            handler.removeMessages(201);
        }
        synchronized (this.s) {
            if (this.t != null) {
                this.t = null;
            }
        }
    }

    private void a(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.f28520a.a(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void a(int i2, Object obj) {
        if (i2 == 309) {
            B();
        }
        Handler handler = this.f28528i;
        if (handler != null) {
            handler.obtainMessage(i2, obj).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.a
    public void a(c cVar, int i2) {
        Handler handler;
        if (this.f28520a == cVar && (handler = this.f28528i) != null) {
            handler.obtainMessage(301, Integer.valueOf(i2)).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.b
    public void a(c cVar) {
        this.f28525f = !this.f28521b ? 209 : 206;
        o.delete(this.k);
        Handler handler = this.f28528i;
        if (handler != null) {
            handler.obtainMessage(302).sendToTarget();
        }
        b("completion");
        D();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.InterfaceC0298c
    public boolean a(c cVar, int i2, int i3) {
        u.f("SSMediaPlayeWrapper", "what=" + i2 + "extra=" + i3);
        u();
        this.f28525f = 200;
        Handler handler = this.f28528i;
        if (handler != null) {
            handler.obtainMessage(303, i2, i3).sendToTarget();
        }
        Handler handler2 = this.f28527h;
        if (handler2 != null) {
            handler2.removeMessages(108);
            this.f28527h.removeMessages(109);
        }
        if (!this.f28522c) {
            a(308, Integer.valueOf(i2));
            this.f28522c = true;
        }
        if (a(i2, i3)) {
            t();
        }
        return true;
    }

    private boolean a(int i2, int i3) {
        u.b("SSMediaPlayeWrapper", "OnError - Error code: " + i2 + " Extra code: " + i3);
        boolean z = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
        if (i3 == 1 || i3 == 700 || i3 == 800) {
            return true;
        }
        return z;
    }

    private void a(Runnable runnable) {
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.add(runnable);
    }

    private void a(int i2, boolean z) {
        int A;
        if (z && (A = A()) != i2) {
            m = true;
            this.l = A;
        }
        AudioManager audioManager = (AudioManager) p.a().getSystemService("audio");
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i2, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.g
    public void a(c cVar, int i2, int i3, int i4, int i5) {
        Handler handler = this.f28528i;
        if (handler != null) {
            handler.obtainMessage(311, i2, i3).sendToTarget();
        }
    }
}
