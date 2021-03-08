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
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.ar.face.algo.FAUEnum;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.video.d.c;
import com.bytedance.sdk.openadsdk.utils.al;
import com.bytedance.sdk.openadsdk.utils.u;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import okhttp3.internal.http.StatusLine;
import org.apache.http.HttpHost;
/* loaded from: classes6.dex */
public class d implements c.a, c.b, c.InterfaceC1022c, c.d, c.e, c.f, c.g, al.a {
    private static boolean m = false;
    private static final SparseIntArray o = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    private c f4536a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private long g;
    private final Handler h;
    private Handler i;
    private ArrayList<Runnable> j;
    private int k;
    private int l;
    private String n;
    private boolean p;
    private Runnable q;
    private boolean r;
    private final Object s;
    private StringBuilder t;
    private boolean u;
    private long v;
    private long w;
    private long x;
    private long y;
    private boolean z;

    public d(Handler handler) {
        this(handler, -1);
    }

    @SuppressLint({"unused"})
    public d(Handler handler, int i) {
        this.f4536a = null;
        this.b = false;
        this.c = false;
        this.f = 201;
        this.g = -1L;
        this.k = 0;
        this.n = "0";
        this.q = new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                d.this.h.sendEmptyMessageDelayed(100, 0L);
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
        this.h = new al(handlerThread.getLooper(), this);
        this.z = Build.VERSION.SDK_INT >= 17;
        q();
    }

    public void a(boolean z) {
        this.p = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        if (this.f4536a == null) {
            u.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
            this.f4536a = new b();
            this.n = "0";
            this.f4536a.a((c.e) this);
            this.f4536a.a((c.b) this);
            this.f4536a.a((c.InterfaceC1022c) this);
            this.f4536a.a((c.a) this);
            this.f4536a.a((c.f) this);
            this.f4536a.a((c.d) this);
            this.f4536a.a((c.g) this);
            try {
                this.f4536a.b(this.b);
            } catch (Throwable th) {
                u.a("SSMediaPlayeWrapper", "setLooping error: ", th);
            }
            this.c = false;
        }
    }

    public MediaPlayer a() throws Throwable {
        if (this.f4536a != null) {
            return ((b) this.f4536a).e();
        }
        return null;
    }

    public void a(boolean z, long j, boolean z2) {
        u.b("tag_video_play", "[video] MediaPlayerProxy#start firstSeekToPosition=" + j + ",firstPlay :" + z + ",isPauseOtherMusicVolume=" + z2);
        this.r = false;
        if (!z2) {
            if (this.f4536a != null) {
                b(true);
            }
        } else if (this.f4536a != null) {
            b(false);
        }
        if (z) {
            u.b("tag_video_play", "[video] first start , SSMediaPlayer  start method !");
            r();
            this.g = j;
            return;
        }
        C();
        if (this.f4536a != null) {
            try {
                if (j <= this.f4536a.i()) {
                    j = this.f4536a.i();
                }
                this.g = j;
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

    public void b() {
        this.h.removeMessages(100);
        this.r = true;
        this.h.sendEmptyMessage(101);
        D();
    }

    public void c() {
        this.f = 203;
        D();
        z();
        if (this.h != null) {
            try {
                b("release");
                this.h.removeCallbacksAndMessages(null);
                if (this.f4536a != null) {
                    this.e = true;
                    this.h.sendEmptyMessage(103);
                }
            } catch (Throwable th) {
                t();
                u.a("SSMediaPlayeWrapper", "release error: ", th);
            }
        }
    }

    private void r() {
        u.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke !");
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.h != null) {
                    d.this.h.sendEmptyMessage(104);
                    u.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
                }
            }
        });
    }

    public void d() {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.3
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.h != null) {
                    d.this.h.sendEmptyMessage(105);
                }
            }
        });
    }

    public void a(final long j) {
        D();
        if (this.f == 207 || this.f == 206 || this.f == 209) {
            b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.h != null) {
                        d.this.h.obtainMessage(106, Long.valueOf(j)).sendToTarget();
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
                if (d.this.h != null) {
                    d.this.h.obtainMessage(111, surfaceTexture).sendToTarget();
                }
            }
        });
    }

    public void a(final SurfaceHolder surfaceHolder) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.6
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.h != null) {
                    d.this.h.obtainMessage(110, surfaceHolder).sendToTarget();
                }
            }
        });
    }

    public void e() {
        if (this.h != null) {
            this.h.obtainMessage(108).sendToTarget();
        }
    }

    public void f() {
        if (this.h != null) {
            this.h.obtainMessage(109).sendToTarget();
        }
    }

    public void a(final com.bytedance.sdk.openadsdk.core.video.b.a aVar) {
        b(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.7
            @Override // java.lang.Runnable
            public void run() {
                d.this.q();
                if (d.this.h != null) {
                    d.this.h.obtainMessage(107, aVar).sendToTarget();
                }
            }
        });
    }

    public boolean g() {
        return (this.f == 206 || this.h.hasMessages(100)) && !this.r;
    }

    public boolean h() {
        return k() || g() || i();
    }

    public boolean i() {
        return (this.f == 207 || this.r) && !this.h.hasMessages(100);
    }

    public boolean j() {
        return this.f == 203;
    }

    public boolean k() {
        return this.f == 205;
    }

    public boolean l() {
        return this.f == 209;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:185:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x003f  */
    @Override // com.bytedance.sdk.openadsdk.utils.al.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Message message) {
        boolean z;
        long i;
        long j = 0;
        int i2 = message.what;
        u.b("tag_video_play", "[video]  execute , mCurrentState = " + this.f + " handlerMsg=" + i2);
        if (this.f4536a != null) {
            switch (message.what) {
                case 100:
                    if (this.f != 205 && this.f != 206 && this.f != 207 && this.f != 209) {
                        z = true;
                        break;
                    } else {
                        try {
                            this.f4536a.f();
                            u.b("tag_video_play", "[video] OP_START execute , mMediaPlayer real start !");
                            this.f = 206;
                            if (this.g >= 0) {
                                this.f4536a.a(this.g);
                                this.g = -1L;
                            }
                            if (this.i != null) {
                                this.i.removeMessages(312);
                                this.i.sendEmptyMessage(313);
                            }
                            z = false;
                            break;
                        } catch (Throwable th) {
                            u.a("tag_video_play", "OP_START error: ", th);
                            z = false;
                            break;
                        }
                    }
                    break;
                case 101:
                    if (this.f != 206 && this.f != 207 && this.f != 209) {
                        z = true;
                        break;
                    } else {
                        try {
                            u.b("tag_video_play", "[video] OP_PAUSE execute , mMediaPlayer  OP_PAUSE !");
                            this.f4536a.h();
                            this.f = 207;
                            this.r = false;
                            z = false;
                            break;
                        } catch (Throwable th2) {
                            u.a("NativeVideoController", "OP_PAUSE error: ", th2);
                            z = false;
                            break;
                        }
                    }
                    break;
                case 102:
                    try {
                        this.f4536a.l();
                        u.b("tag_video_play", "[video] OP_RELEASE execute , releaseMediaplayer !");
                        this.f = 201;
                        z = false;
                        break;
                    } catch (Throwable th3) {
                        u.a("SSMediaPlayeWrapper", "OP_RESET error: ", th3);
                        z = false;
                        break;
                    }
                case 103:
                    try {
                        s();
                        u.b("tag_video_play", "[video] OP_RELEASE execute , releaseMediaplayer !");
                    } catch (Throwable th4) {
                        u.c("NativeVideoController", "OP_RELEASE error: ", th4);
                    }
                    this.e = false;
                    a(309, (Object) null);
                    this.f = 203;
                    this.f4536a = null;
                    y();
                    z = false;
                    break;
                case 104:
                    if (this.f != 202 && this.f != 208) {
                        z = true;
                        break;
                    } else {
                        try {
                            ((b) this.f4536a).e().prepareAsync();
                            u.b("tag_video_play", "[video] OP_PREPARE_ASYNC execute , mMediaPlayer real prepareAsync !");
                            if (this.i != null) {
                                this.i.sendEmptyMessageDelayed(312, 10000L);
                            }
                            z = false;
                            break;
                        } catch (Throwable th5) {
                            u.c("NativeVideoController", "OP_PREPARE_ASYNC error: ", th5);
                            z = false;
                            break;
                        }
                    }
                    break;
                case 105:
                    if (this.f != 205 && this.f != 206 && this.f != 208 && this.f != 207 && this.f != 209) {
                        z = true;
                        break;
                    } else {
                        try {
                            this.f4536a.g();
                            this.f = 208;
                            z = false;
                            break;
                        } catch (Throwable th6) {
                            u.a("SSMediaPlayeWrapper", "OP_STOP error: ", th6);
                            z = false;
                            break;
                        }
                    }
                    break;
                case 106:
                    if (this.f != 206 && this.f != 207 && this.f != 209) {
                        z = true;
                        break;
                    } else {
                        try {
                            this.f4536a.a(((Long) message.obj).longValue());
                            z = false;
                            break;
                        } catch (Throwable th7) {
                            u.a("SSMediaPlayeWrapper", "OP_SEEKTO error: ", th7);
                            z = false;
                            break;
                        }
                    }
                case 107:
                    if (this.f != 201 && this.f != 203) {
                        z = true;
                        break;
                    } else {
                        try {
                            com.bytedance.sdk.openadsdk.core.video.b.a aVar = (com.bytedance.sdk.openadsdk.core.video.b.a) message.obj;
                            String str = aVar.f4525a;
                            String c = com.bytedance.sdk.openadsdk.core.video.a.a.c(str);
                            if (TextUtils.isEmpty(c)) {
                                c = str;
                            }
                            if (!TextUtils.isEmpty(c)) {
                                if (c.startsWith("/") || aVar.c == 1) {
                                    if (com.bytedance.sdk.openadsdk.multipro.b.b() && c.startsWith("/")) {
                                        a(c);
                                    } else {
                                        this.f4536a.a(c);
                                    }
                                } else {
                                    com.bytedance.sdk.openadsdk.i.f.b b = new com.bytedance.sdk.openadsdk.i.f.b().a(aVar.f4525a).b(aVar.d);
                                    if (Build.VERSION.SDK_INT >= 23 && c.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                                        this.f4536a.a(c, aVar.d);
                                    } else {
                                        String b2 = com.bytedance.sdk.openadsdk.i.f.a.a().b(b);
                                        u.f("cache009", "使用Video缓存-OP_SET_DATASOURCE-proxyurl=" + b2);
                                        if (b2 != null && com.bytedance.sdk.openadsdk.multipro.b.b() && b2.startsWith("file")) {
                                            Uri parse = Uri.parse(b2);
                                            u.f("cache010", "使用uri parse =" + parse.getPath());
                                            a(parse.getPath());
                                        } else {
                                            this.f4536a.a(b2);
                                        }
                                    }
                                }
                                this.f = 202;
                                if (this.i != null) {
                                    this.i.obtainMessage(314).sendToTarget();
                                }
                                z = false;
                                break;
                            } else {
                                return;
                            }
                        } catch (Throwable th8) {
                            u.a("SSMediaPlayeWrapper", "OP_SET_DATASOURCE error: ", th8);
                            z = false;
                            break;
                        }
                    }
                    break;
                case 108:
                    if (this.f == 206 || this.f == 207) {
                        try {
                            j = this.f4536a.j();
                        } catch (Throwable th9) {
                            u.a("SSMediaPlayeWrapper", "OP_REQUEST_DURATION error: ", th9);
                        }
                    }
                    a(108, Long.valueOf(j));
                    z = false;
                    break;
                case 109:
                    if (this.f == 206 || this.f == 207) {
                        try {
                            i = this.f4536a.i();
                        } catch (Throwable th10) {
                            u.a("SSMediaPlayeWrapper", "OP_REQUEST_CUR_POSITION error: ", th10);
                        }
                        if (i > 0) {
                            a(109, Long.valueOf(i));
                            z = false;
                            break;
                        }
                    }
                    i = 0;
                    if (i > 0) {
                    }
                    break;
                case 110:
                    try {
                        this.f4536a.a((SurfaceHolder) message.obj);
                        if (this.k == 2) {
                            this.f4536a.a(p.a(), 10);
                        }
                        this.f4536a.a(true);
                        z = false;
                        break;
                    } catch (Throwable th11) {
                        u.a("SSMediaPlayeWrapper", "OP_SET_DISPLAY error: ", th11);
                        z = false;
                        break;
                    }
                case 111:
                    try {
                        if (Build.VERSION.SDK_INT >= 14) {
                            this.f4536a.a(new Surface((SurfaceTexture) message.obj));
                        }
                        this.f4536a.a(true);
                        this.f4536a.a(p.a(), 10);
                        x();
                        z = false;
                        break;
                    } catch (Throwable th12) {
                        u.a("SSMediaPlayeWrapper", "OP_SET_SURFACE error: ", th12);
                        z = false;
                        break;
                    }
                case 201:
                    z = false;
                    break;
            }
            if (!z) {
                this.f = 200;
                if (!this.c) {
                    a(StatusLine.HTTP_PERM_REDIRECT, Integer.valueOf(i2));
                    this.c = true;
                    return;
                }
                return;
            }
            return;
        }
        z = false;
        if (!z) {
        }
    }

    private void a(String str) throws Throwable {
        FileInputStream fileInputStream = new FileInputStream(str);
        this.f4536a.a(fileInputStream.getFD());
        fileInputStream.close();
    }

    private void s() {
        if (this.f4536a != null) {
            try {
                this.f4536a.l();
            } catch (Throwable th) {
                u.a("SSMediaPlayeWrapper", "releaseMediaplayer error1: ", th);
            }
            this.f4536a.a((c.b) null);
            this.f4536a.a((c.g) null);
            this.f4536a.a((c.a) null);
            this.f4536a.a((c.d) null);
            this.f4536a.a((c.InterfaceC1022c) null);
            this.f4536a.a((c.e) null);
            this.f4536a.a((c.f) null);
            try {
                this.f4536a.k();
            } catch (Throwable th2) {
                u.a("SSMediaPlayeWrapper", "releaseMediaplayer error2: ", th2);
            }
        }
    }

    private void t() {
        if (this.h != null && this.h.getLooper() != null) {
            try {
                u.b("SSMediaPlayeWrapper", "onDestory............");
                this.h.getLooper().quit();
            } catch (Throwable th) {
                u.a("SSMediaPlayeWrapper", "onDestroy error: ", th);
            }
        }
    }

    private void a(int i, Object obj) {
        if (i == 309) {
            B();
        }
        if (this.i != null) {
            this.i.obtainMessage(i, obj).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.a
    public void a(c cVar, int i) {
        if (this.f4536a == cVar && this.i != null) {
            this.i.obtainMessage(301, Integer.valueOf(i)).sendToTarget();
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

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.b
    public void a(c cVar) {
        this.f = !this.b ? FAUEnum.PR_TIMEOUT : 206;
        o.delete(this.k);
        if (this.i != null) {
            this.i.obtainMessage(302).sendToTarget();
        }
        b("completion");
        D();
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.InterfaceC1022c
    public boolean a(c cVar, int i, int i2) {
        u.f("SSMediaPlayeWrapper", "what=" + i + "extra=" + i2);
        u();
        this.f = 200;
        if (this.i != null) {
            this.i.obtainMessage(303, i, i2).sendToTarget();
        }
        if (this.h != null) {
            this.h.removeMessages(108);
            this.h.removeMessages(109);
        }
        if (!this.c) {
            a(StatusLine.HTTP_PERM_REDIRECT, Integer.valueOf(i));
            this.c = true;
        }
        if (a(i, i2)) {
            t();
        }
        return true;
    }

    private boolean a(int i, int i2) {
        u.b("SSMediaPlayeWrapper", "OnError - Error code: " + i + " Extra code: " + i2);
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

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.d
    public boolean b(c cVar, int i, int i2) {
        u.f("SSMediaPlayeWrapper", "what,extra:" + i + "," + i2);
        if (this.f4536a == cVar) {
            if (this.i != null) {
                this.i.obtainMessage(304, i, i2).sendToTarget();
                if (i2 == -1004) {
                    this.i.obtainMessage(303, i, i2).sendToTarget();
                }
            }
            b(i, i2);
        }
        return false;
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

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.e
    public void b(c cVar) {
        this.f = 205;
        if (this.r) {
            this.h.post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.video.d.d.8
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        d.this.f4536a.h();
                        d.this.f = 207;
                        d.this.r = false;
                    } catch (Throwable th) {
                        u.a("SSMediaPlayeWrapper", "onPrepared error: ", th);
                    }
                }
            });
        } else {
            this.h.sendMessage(this.h.obtainMessage(100, -1, -1));
        }
        o.delete(this.k);
        if (this.i != null) {
            this.i.sendEmptyMessage(305);
        }
        v();
    }

    private void v() {
        if (!this.z && this.w <= 0) {
            this.w = System.currentTimeMillis();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.f
    public void c(c cVar) {
        if (this.i != null) {
            this.i.sendEmptyMessage(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA);
        }
    }

    private void a(Runnable runnable) {
        if (this.j == null) {
            this.j = new ArrayList<>();
        }
        this.j.add(runnable);
    }

    private void w() {
        if (!this.d) {
            this.d = true;
            Iterator it = new ArrayList(this.j).iterator();
            while (it.hasNext()) {
                ((Runnable) it.next()).run();
            }
            this.j.clear();
            this.d = false;
        }
    }

    private void x() {
        if (this.j != null && !this.j.isEmpty()) {
            w();
        }
    }

    private void y() {
        if (this.j == null || this.j.isEmpty()) {
            t();
        } else {
            w();
        }
    }

    private void z() {
        if (this.j != null && !this.j.isEmpty()) {
            this.j.clear();
        }
    }

    private void b(Runnable runnable) {
        if (runnable != null) {
            if (!this.e) {
                runnable.run();
            } else {
                a(runnable);
            }
        }
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

    public void b(boolean z) {
        try {
            if (z) {
                this.f4536a.a(0.0f, 0.0f);
            } else {
                this.f4536a.a(1.0f, 1.0f);
            }
        } catch (Throwable th) {
            u.a("SSMediaPlayeWrapper", "setQuietPlay error: ", th);
        }
    }

    private void b(String str) {
        if (this.h != null) {
            this.h.removeMessages(201);
        }
        synchronized (this.s) {
            if (this.t != null) {
                this.t = null;
            }
        }
    }

    private void C() {
        if (this.w <= 0) {
            this.w = System.currentTimeMillis();
        }
    }

    public void m() {
        this.v = 0L;
        this.w = System.currentTimeMillis();
    }

    private void D() {
        if (this.w > 0) {
            this.v += System.currentTimeMillis() - this.w;
            this.w = 0L;
        }
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

    @Override // com.bytedance.sdk.openadsdk.core.video.d.c.g
    public void a(c cVar, int i, int i2, int i3, int i4) {
        if (this.i != null) {
            this.i.obtainMessage(311, i, i2).sendToTarget();
        }
    }
}
