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
/* loaded from: classes5.dex */
public class d implements c.a, c.b, c.InterfaceC0313c, c.d, c.e, c.f, c.g, am.a {
    public static boolean m = false;
    public static final SparseIntArray o = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    public c f28365a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f28366b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f28367c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f28368d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f28369e;

    /* renamed from: f  reason: collision with root package name */
    public int f28370f;

    /* renamed from: g  reason: collision with root package name */
    public long f28371g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f28372h;
    public Handler i;
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
        if (this.f28365a == null) {
            u.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
            b bVar = new b();
            this.f28365a = bVar;
            this.n = "0";
            bVar.a((c.e) this);
            this.f28365a.a((c.b) this);
            this.f28365a.a((c.InterfaceC0313c) this);
            this.f28365a.a((c.a) this);
            this.f28365a.a((c.f) this);
            this.f28365a.a((c.d) this);
            this.f28365a.a((c.g) this);
            try {
                this.f28365a.b(this.f28366b);
            } catch (Throwable th) {
                u.a("SSMediaPlayeWrapper", "setLooping error: ", th);
            }
            this.f28367c = false;
        }
    }

    private void r() {
        u.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke !");
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.f28372h != null) {
                    d.this.f28372h.sendEmptyMessage(104);
                    u.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
                }
            }
        });
    }

    private void s() {
        c cVar = this.f28365a;
        if (cVar == null) {
            return;
        }
        try {
            cVar.l();
        } catch (Throwable th) {
            u.a("SSMediaPlayeWrapper", "releaseMediaplayer error1: ", th);
        }
        this.f28365a.a((c.b) null);
        this.f28365a.a((c.g) null);
        this.f28365a.a((c.a) null);
        this.f28365a.a((c.d) null);
        this.f28365a.a((c.InterfaceC0313c) null);
        this.f28365a.a((c.e) null);
        this.f28365a.a((c.f) null);
        try {
            this.f28365a.k();
        } catch (Throwable th2) {
            u.a("SSMediaPlayeWrapper", "releaseMediaplayer error2: ", th2);
        }
    }

    private void t() {
        Handler handler = this.f28372h;
        if (handler == null || handler.getLooper() == null) {
            return;
        }
        try {
            u.b("SSMediaPlayeWrapper", "onDestory............");
            this.f28372h.getLooper().quit();
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
        if (this.f28368d) {
            return;
        }
        this.f28368d = true;
        Iterator it = new ArrayList(this.j).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.j.clear();
        this.f28368d = false;
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
                if (d.this.f28372h != null) {
                    d.this.f28372h.sendEmptyMessage(105);
                }
            }
        });
    }

    public void e() {
        Handler handler = this.f28372h;
        if (handler != null) {
            handler.obtainMessage(108).sendToTarget();
        }
    }

    public void f() {
        Handler handler = this.f28372h;
        if (handler != null) {
            handler.obtainMessage(109).sendToTarget();
        }
    }

    public boolean g() {
        return (this.f28370f == 206 || this.f28372h.hasMessages(100)) && !this.r;
    }

    public boolean h() {
        return k() || g() || i();
    }

    public boolean i() {
        return (this.f28370f == 207 || this.r) && !this.f28372h.hasMessages(100);
    }

    public boolean j() {
        return this.f28370f == 203;
    }

    public boolean k() {
        return this.f28370f == 205;
    }

    public boolean l() {
        return this.f28370f == 209;
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
    public d(Handler handler, int i) {
        this.f28365a = null;
        this.f28366b = false;
        this.f28367c = false;
        this.f28370f = 201;
        this.f28371g = -1L;
        this.k = 0;
        this.n = "0";
        this.q = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.f28372h.sendEmptyMessageDelayed(100, 0L);
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
        this.i = handler;
        HandlerThread handlerThread = new HandlerThread("VideoManager");
        handlerThread.start();
        this.f28372h = new am(handlerThread.getLooper(), this);
        this.z = Build.VERSION.SDK_INT >= 17;
        q();
    }

    public void b() {
        this.f28372h.removeMessages(100);
        this.r = true;
        this.f28372h.sendEmptyMessage(101);
        D();
    }

    public void c() {
        this.f28370f = 203;
        D();
        z();
        if (this.f28372h != null) {
            try {
                b("release");
                this.f28372h.removeCallbacksAndMessages(null);
                if (this.f28365a != null) {
                    this.f28369e = true;
                    this.f28372h.sendEmptyMessage(103);
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
        c cVar = this.f28365a;
        if (cVar != null) {
            return ((b) cVar).e();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.d
    public boolean b(c cVar, int i, int i2) {
        u.f("SSMediaPlayeWrapper", "what,extra:" + i + "," + i2);
        if (this.f28365a != cVar) {
            return false;
        }
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(304, i, i2).sendToTarget();
            if (i2 == -1004) {
                this.i.obtainMessage(303, i, i2).sendToTarget();
            }
        }
        b(i, i2);
        return false;
    }

    public void a(boolean z, long j, boolean z2) {
        u.b("tag_video_play", "[video] MediaPlayerProxy#start firstSeekToPosition=" + j + ",firstPlay :" + z + ",isPauseOtherMusicVolume=" + z2);
        this.r = false;
        if (!z2) {
            if (this.f28365a != null) {
                b(true);
            }
        } else if (this.f28365a != null) {
            b(false);
        }
        if (z) {
            u.b("tag_video_play", "[video] first start , SSMediaPlayer  start method !");
            r();
            this.f28371g = j;
            return;
        }
        C();
        c cVar = this.f28365a;
        if (cVar != null) {
            try {
                if (j <= cVar.i()) {
                    j = this.f28365a.i();
                }
                this.f28371g = j;
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

    private void b(int i, int i2) {
        if (i == 701) {
            D();
            this.x = SystemClock.elapsedRealtime();
        } else if (i == 702) {
            if (this.w <= 0) {
                this.w = System.currentTimeMillis();
            }
            if (this.x > 0) {
                this.y += SystemClock.elapsedRealtime() - this.x;
                this.x = 0L;
            }
        } else if (this.z && i == 3 && this.w <= 0) {
            this.w = System.currentTimeMillis();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.f
    public void c(c cVar) {
        Handler handler = this.i;
        if (handler != null) {
            handler.sendEmptyMessage(306);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.e
    public void b(c cVar) {
        this.f28370f = 205;
        if (this.r) {
            this.f28372h.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.f28365a.h();
                        d.this.f28370f = 207;
                        d.this.r = false;
                    } catch (Throwable th) {
                        u.a("SSMediaPlayeWrapper", "onPrepared error: ", th);
                    }
                }
            });
        } else {
            Handler handler = this.f28372h;
            handler.sendMessage(handler.obtainMessage(100, -1, -1));
        }
        o.delete(this.k);
        Handler handler2 = this.i;
        if (handler2 != null) {
            handler2.sendEmptyMessage(305);
        }
        v();
    }

    public void a(final long j) {
        D();
        int i = this.f28370f;
        if (i == 207 || i == 206 || i == 209) {
            b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.f28372h != null) {
                        d.this.f28372h.obtainMessage(106, Long.valueOf(j)).sendToTarget();
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
                if (d.this.f28372h != null) {
                    d.this.f28372h.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    public void a(final SurfaceHolder surfaceHolder) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.6
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.f28372h != null) {
                    d.this.f28372h.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public void a(final com.bytedance.sdk.openadsdk.core.video.b.a aVar) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.7
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.f28372h != null) {
                    d.this.f28372h.obtainMessage(107, aVar).sendToTarget();
                }
            }
        });
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:153:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a3 A[Catch: all -> 0x01b0, TRY_LEAVE, TryCatch #7 {all -> 0x01b0, blocks: (B:43:0x00df, B:46:0x00f0, B:49:0x00f7, B:51:0x00fd, B:54:0x0103, B:56:0x011a, B:58:0x0122, B:73:0x019b, B:75:0x01a3, B:59:0x012a, B:61:0x014b, B:63:0x0151, B:65:0x0159, B:66:0x0180, B:67:0x0186, B:69:0x018c, B:71:0x0192, B:72:0x0196), top: B:171:0x00df }] */
    @Override // com.bytedance.sdk.openadsdk.utils.am.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Message message) {
        boolean z;
        long i;
        int i2 = message.what;
        u.b("tag_video_play", "[video]  execute , mCurrentState = " + this.f28370f + " handlerMsg=" + i2);
        c cVar = this.f28365a;
        if (cVar != null) {
            long j = 0;
            switch (message.what) {
                case 100:
                    int i3 = this.f28370f;
                    if (i3 == 205 || i3 == 206 || i3 == 207 || i3 == 209) {
                        try {
                            this.f28365a.f();
                            u.b("tag_video_play", "[video] OP_START execute , mMediaPlayer real start !");
                            this.f28370f = 206;
                            if (this.f28371g >= 0) {
                                this.f28365a.a(this.f28371g);
                                this.f28371g = -1L;
                            }
                            if (this.i != null) {
                                this.i.removeMessages(312);
                                this.i.sendEmptyMessage(313);
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
                    int i4 = this.f28370f;
                    if (i4 == 206 || i4 == 207 || i4 == 209) {
                        try {
                            u.b("tag_video_play", "[video] OP_PAUSE execute , mMediaPlayer  OP_PAUSE !");
                            this.f28365a.h();
                            this.f28370f = 207;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                        try {
                            this.r = false;
                        } catch (Throwable th3) {
                            th = th3;
                            u.a("NativeVideoController", "OP_PAUSE error: ", th);
                            z = false;
                            if (z) {
                            }
                        }
                        z = false;
                    }
                    z = true;
                    break;
                case 102:
                    try {
                        cVar.l();
                        u.b("tag_video_play", "[video] OP_RELEASE execute , releaseMediaplayer !");
                        this.f28370f = 201;
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
                    this.f28369e = false;
                    a(309, (Object) null);
                    this.f28370f = 203;
                    this.f28365a = null;
                    y();
                    break;
                case 104:
                    int i5 = this.f28370f;
                    if (i5 == 202 || i5 == 208) {
                        try {
                            ((b) this.f28365a).e().prepareAsync();
                            u.b("tag_video_play", "[video] OP_PREPARE_ASYNC execute , mMediaPlayer real prepareAsync !");
                            if (this.i != null) {
                                this.i.sendEmptyMessageDelayed(312, 10000L);
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
                    int i6 = this.f28370f;
                    if (i6 == 205 || i6 == 206 || i6 == 208 || i6 == 207 || i6 == 209) {
                        try {
                            this.f28365a.g();
                            this.f28370f = 208;
                            break;
                        } catch (Throwable th7) {
                            u.a("SSMediaPlayeWrapper", "OP_STOP error: ", th7);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 106:
                    int i7 = this.f28370f;
                    if (i7 == 206 || i7 == 207 || i7 == 209) {
                        try {
                            this.f28365a.a(((Long) message.obj).longValue());
                            break;
                        } catch (Throwable th8) {
                            u.a("SSMediaPlayeWrapper", "OP_SEEKTO error: ", th8);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 107:
                    int i8 = this.f28370f;
                    if (i8 == 201 || i8 == 203) {
                        try {
                            com.bytedance.sdk.openadsdk.core.video.b.a aVar = (com.bytedance.sdk.openadsdk.core.video.b.a) message.obj;
                            String str = aVar.f28332a;
                            String a2 = com.bytedance.sdk.openadsdk.core.video.a.a.a(str);
                            if (!TextUtils.isEmpty(a2)) {
                                str = a2;
                            }
                            if (TextUtils.isEmpty(str)) {
                                return;
                            }
                            if (!str.startsWith("/") && aVar.f28334c != 1) {
                                com.bytedance.sdk.openadsdk.k.f.b b2 = new com.bytedance.sdk.openadsdk.k.f.b().a(aVar.f28332a).b(aVar.f28335d);
                                if (Build.VERSION.SDK_INT >= 23 && str.startsWith("http")) {
                                    this.f28365a.a(str, aVar.f28335d);
                                } else {
                                    String b3 = com.bytedance.sdk.openadsdk.k.f.a.a().b(b2);
                                    u.f("cache009", "使用Video缓存-OP_SET_DATASOURCE-proxyurl=" + b3);
                                    if (b3 != null && com.bytedance.sdk.openadsdk.multipro.b.b() && b3.startsWith("file")) {
                                        Uri parse = Uri.parse(b3);
                                        u.f("cache010", "使用uri parse =" + parse.getPath());
                                        a(parse.getPath());
                                    } else {
                                        this.f28365a.a(b3);
                                    }
                                }
                                this.f28370f = 202;
                                if (this.i != null) {
                                    this.i.obtainMessage(314).sendToTarget();
                                    break;
                                }
                            }
                            if (com.bytedance.sdk.openadsdk.multipro.b.b() && str.startsWith("/")) {
                                a(str);
                            } else {
                                this.f28365a.a(str);
                            }
                            this.f28370f = 202;
                            if (this.i != null) {
                            }
                        } catch (Throwable th9) {
                            u.a("SSMediaPlayeWrapper", "OP_SET_DATASOURCE error: ", th9);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 108:
                    int i9 = this.f28370f;
                    if (i9 == 206 || i9 == 207) {
                        try {
                            j = this.f28365a.j();
                        } catch (Throwable th10) {
                            u.a("SSMediaPlayeWrapper", "OP_REQUEST_DURATION error: ", th10);
                        }
                    }
                    a(108, Long.valueOf(j));
                    break;
                case 109:
                    int i10 = this.f28370f;
                    if (i10 == 206 || i10 == 207) {
                        try {
                            i = this.f28365a.i();
                        } catch (Throwable th11) {
                            u.a("SSMediaPlayeWrapper", "OP_REQUEST_CUR_POSITION error: ", th11);
                        }
                        if (i > 0) {
                            a(109, Long.valueOf(i));
                            break;
                        }
                    }
                    i = 0;
                    if (i > 0) {
                    }
                    break;
                case 110:
                    try {
                        cVar.a((SurfaceHolder) message.obj);
                        if (this.k == 2) {
                            this.f28365a.a(p.a(), 10);
                        }
                        this.f28365a.a(true);
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
                        this.f28365a.a(true);
                        this.f28365a.a(p.a(), 10);
                        x();
                        break;
                    } catch (Throwable th13) {
                        u.a("SSMediaPlayeWrapper", "OP_SET_SURFACE error: ", th13);
                        break;
                    }
            }
            if (z) {
                this.f28370f = 200;
                if (this.f28367c) {
                    return;
                }
                a(308, Integer.valueOf(i2));
                this.f28367c = true;
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
        if (!this.f28369e) {
            runnable.run();
        } else {
            a(runnable);
        }
    }

    public void b(boolean z) {
        try {
            if (z) {
                this.f28365a.a(0.0f, 0.0f);
            } else {
                this.f28365a.a(1.0f, 1.0f);
            }
        } catch (Throwable th) {
            u.a("SSMediaPlayeWrapper", "setQuietPlay error: ", th);
        }
    }

    private void b(String str) {
        Handler handler = this.f28372h;
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
        this.f28365a.a(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void a(int i, Object obj) {
        if (i == 309) {
            B();
        }
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(i, obj).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.a
    public void a(c cVar, int i) {
        Handler handler;
        if (this.f28365a == cVar && (handler = this.i) != null) {
            handler.obtainMessage(301, Integer.valueOf(i)).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.b
    public void a(c cVar) {
        this.f28370f = !this.f28366b ? 209 : 206;
        o.delete(this.k);
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(302).sendToTarget();
        }
        b("completion");
        D();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.InterfaceC0313c
    public boolean a(c cVar, int i, int i2) {
        u.f("SSMediaPlayeWrapper", "what=" + i + "extra=" + i2);
        u();
        this.f28370f = 200;
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(303, i, i2).sendToTarget();
        }
        Handler handler2 = this.f28372h;
        if (handler2 != null) {
            handler2.removeMessages(108);
            this.f28372h.removeMessages(109);
        }
        if (!this.f28367c) {
            a(308, Integer.valueOf(i));
            this.f28367c = true;
        }
        if (a(i, i2)) {
            t();
        }
        return true;
    }

    private boolean a(int i, int i2) {
        u.b("SSMediaPlayeWrapper", "OnError - Error code: " + i + " Extra code: " + i2);
        boolean z = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
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

    private void a(int i, boolean z) {
        int A;
        if (z && (A = A()) != i) {
            m = true;
            this.l = A;
        }
        AudioManager audioManager = (AudioManager) p.a().getSystemService("audio");
        if (audioManager != null) {
            audioManager.setStreamVolume(3, i, 0);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.g
    public void a(c cVar, int i, int i2, int i3, int i4) {
        Handler handler = this.i;
        if (handler != null) {
            handler.obtainMessage(311, i, i2).sendToTarget();
        }
    }
}
