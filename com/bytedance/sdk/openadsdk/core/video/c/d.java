package com.bytedance.sdk.openadsdk.core.video.c;

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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.k;
import com.bytedance.sdk.component.utils.w;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.c.c;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes9.dex */
public class d implements w.a, c.a, c.b, c.InterfaceC1909c, c.d, c.e, c.f, c.g {
    public static /* synthetic */ Interceptable $ic;
    public static boolean s;
    public static final SparseIntArray u;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean A;
    public long B;
    public long C;
    public long D;
    public long E;
    public boolean F;

    /* renamed from: a  reason: collision with root package name */
    public int f67104a;

    /* renamed from: b  reason: collision with root package name */
    public c f67105b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f67106c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f67107d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f67108e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f67109f;

    /* renamed from: g  reason: collision with root package name */
    public int f67110g;

    /* renamed from: h  reason: collision with root package name */
    public long f67111h;

    /* renamed from: i  reason: collision with root package name */
    public final Handler f67112i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f67113j;
    public long k;
    public int l;
    public long m;
    public long n;
    public Handler o;
    public ArrayList<Runnable> p;
    public int q;
    public int r;
    public String t;
    public boolean v;
    public Runnable w;
    public boolean x;
    public final Object y;
    public StringBuilder z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-992179502, "Lcom/bytedance/sdk/openadsdk/core/video/c/d;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-992179502, "Lcom/bytedance/sdk/openadsdk/core/video/c/d;");
                return;
            }
        }
        u = new SparseIntArray();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public d(Handler handler) {
        this(handler, -1);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Handler) objArr2[0], ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    private void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            ArrayList<Runnable> arrayList = this.p;
            if (arrayList != null && !arrayList.isEmpty()) {
                y();
            } else {
                v();
            }
        }
    }

    private void B() {
        ArrayList<Runnable> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) || (arrayList = this.p) == null || arrayList.isEmpty()) {
            return;
        }
        this.p.clear();
    }

    private int C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            AudioManager audioManager = (AudioManager) o.a().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    private void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) && s) {
            a(this.r, false);
            s = false;
        }
    }

    private void E() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65543, this) == null) || this.C > 0) {
            return;
        }
        this.C = System.currentTimeMillis();
    }

    private void F() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, this) == null) || this.C <= 0) {
            return;
        }
        this.B += System.currentTimeMillis() - this.C;
        this.C = 0L;
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65558, this) == null) {
            this.k = 0L;
            this.l = 0;
            this.n = 0L;
            this.f67113j = false;
            this.m = Long.MIN_VALUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65559, this) == null) && this.f67105b == null) {
            k.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
            b bVar = new b();
            this.f67105b = bVar;
            this.t = "0";
            bVar.a((c.e) this);
            this.f67105b.a((c.b) this);
            this.f67105b.a((c.InterfaceC1909c) this);
            this.f67105b.a((c.a) this);
            this.f67105b.a((c.f) this);
            this.f67105b.a((c.d) this);
            this.f67105b.a((c.g) this);
            try {
                this.f67105b.b(this.f67106c);
            } catch (Throwable th) {
                k.a("SSMediaPlayeWrapper", "setLooping error: ", th);
            }
            this.f67107d = false;
        }
    }

    private void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            k.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke !");
            b(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67115a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67115a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f67115a.f67112i == null) {
                        return;
                    }
                    this.f67115a.f67112i.sendEmptyMessage(104);
                    k.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
                }
            });
        }
    }

    private void u() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || (cVar = this.f67105b) == null) {
            return;
        }
        try {
            cVar.l();
        } catch (Throwable th) {
            k.a("SSMediaPlayeWrapper", "releaseMediaplayer error1: ", th);
        }
        this.f67105b.a((c.b) null);
        this.f67105b.a((c.g) null);
        this.f67105b.a((c.a) null);
        this.f67105b.a((c.d) null);
        this.f67105b.a((c.InterfaceC1909c) null);
        this.f67105b.a((c.e) null);
        this.f67105b.a((c.f) null);
        try {
            this.f67105b.k();
        } catch (Throwable th2) {
            k.a("SSMediaPlayeWrapper", "releaseMediaplayer error2: ", th2);
        }
    }

    private void v() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || (handler = this.f67112i) == null || handler.getLooper() == null) {
            return;
        }
        try {
            k.b("SSMediaPlayeWrapper", "onDestory............");
            this.f67112i.getLooper().quit();
        } catch (Throwable th) {
            k.a("SSMediaPlayeWrapper", "onDestroy error: ", th);
        }
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65563, this) == null) {
            Integer valueOf = Integer.valueOf(u.get(this.q));
            if (valueOf == null) {
                u.put(this.q, 1);
            } else {
                u.put(this.q, Integer.valueOf(valueOf.intValue() + 1).intValue());
            }
        }
    }

    private void x() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65564, this) == null) || this.F || this.C > 0) {
            return;
        }
        this.C = System.currentTimeMillis();
    }

    private void y() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65565, this) == null) || this.f67108e) {
            return;
        }
        this.f67108e = true;
        Iterator it = new ArrayList(this.p).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.p.clear();
        this.f67108e = false;
    }

    private void z() {
        ArrayList<Runnable> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65566, this) == null) || (arrayList = this.p) == null || arrayList.isEmpty()) {
            return;
        }
        y();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f67116a;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67116a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f67116a.f67112i == null) {
                        return;
                    }
                    this.f67116a.f67112i.sendEmptyMessage(105);
                }
            });
        }
    }

    public void e() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (handler = this.f67112i) == null) {
            return;
        }
        handler.obtainMessage(108).sendToTarget();
    }

    public void f() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (handler = this.f67112i) == null) {
            return;
        }
        handler.obtainMessage(109).sendToTarget();
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.f67110g == 206 || this.f67112i.hasMessages(100)) && !this.x : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? k() || g() || i() : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.f67110g == 207 || this.x) && !this.f67112i.hasMessages(100) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f67110g == 203 : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f67110g == 205 : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f67110g == 209 : invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.B = 0L;
            this.C = System.currentTimeMillis();
        }
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                if (this.f67113j) {
                    long j2 = this.n;
                    if (j2 > 0) {
                        return this.k + j2;
                    }
                }
                return this.k;
            }
            return this.E;
        }
        return invokeV.longValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            F();
            return this.B;
        }
        return invokeV.longValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.C > 0) {
                this.B += System.currentTimeMillis() - this.C;
                this.C = System.currentTimeMillis();
            }
            return this.B;
        }
        return invokeV.longValue;
    }

    public int q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                return this.l;
            }
            return this.f67104a;
        }
        return invokeV.intValue;
    }

    @SuppressLint({"unused"})
    public d(Handler handler, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {handler, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f67104a = 0;
        this.f67105b = null;
        this.f67106c = false;
        this.f67107d = false;
        this.f67110g = 201;
        this.f67111h = -1L;
        this.f67113j = false;
        this.k = 0L;
        this.l = 0;
        this.m = Long.MIN_VALUE;
        this.n = 0L;
        this.q = 0;
        this.t = "0";
        this.w = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f67114a;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr2 = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i5 = newInitContext2.flag;
                    if ((i5 & 1) != 0) {
                        int i6 = i5 & 2;
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.f67114a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f67114a.f67112i.sendEmptyMessageDelayed(100, 0L);
                    k.b("tag_video_play", "[video] MediaPlayerProxy#start not first play ! sendMsg --> OP_START , video start to play !");
                }
            }
        };
        this.y = new Object();
        this.z = null;
        this.A = false;
        this.B = 0L;
        this.C = 0L;
        this.D = 0L;
        this.E = 0L;
        this.F = false;
        this.q = 0;
        this.o = handler;
        HandlerThread handlerThread = new HandlerThread("VideoManager");
        handlerThread.start();
        this.f67112i = new w(handlerThread.getLooper(), this);
        this.F = Build.VERSION.SDK_INT >= 17;
        s();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f67112i.removeMessages(100);
            this.x = true;
            this.f67112i.sendEmptyMessage(101);
            F();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f67110g = 203;
            F();
            B();
            if (this.f67112i != null) {
                try {
                    b("release");
                    this.f67112i.removeCallbacksAndMessages(null);
                    if (this.f67105b != null) {
                        this.f67109f = true;
                        this.f67112i.sendEmptyMessage(103);
                    }
                } catch (Throwable th) {
                    v();
                    k.a("SSMediaPlayeWrapper", "release error: ", th);
                }
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.v = z;
        }
    }

    public MediaPlayer a() throws Throwable {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = this.f67105b;
            if (cVar != null) {
                return ((b) cVar).e();
            }
            return null;
        }
        return (MediaPlayer) invokeV.objValue;
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.d
    public boolean b(c cVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048591, this, cVar, i2, i3)) == null) {
            k.f("SSMediaPlayeWrapper", "what,extra:" + i2 + "," + i3);
            if (this.f67105b != cVar) {
                return false;
            }
            Handler handler = this.o;
            if (handler != null) {
                handler.obtainMessage(304, i2, i3).sendToTarget();
                if (i3 == -1004) {
                    this.o.obtainMessage(303, i2, i3).sendToTarget();
                }
            }
            b(i2, i3);
            return false;
        }
        return invokeLII.booleanValue;
    }

    public void a(boolean z, long j2, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j2), Boolean.valueOf(z2)}) == null) {
            k.b("tag_video_play", "[video] MediaPlayerProxy#start firstSeekToPosition=" + j2 + ",firstPlay :" + z + ",isPauseOtherMusicVolume=" + z2);
            this.x = false;
            if (!z2) {
                if (this.f67105b != null) {
                    b(true);
                }
            } else if (this.f67105b != null) {
                b(false);
            }
            if (z) {
                k.b("tag_video_play", "[video] first start , SSMediaPlayer  start method !");
                t();
                this.f67111h = j2;
                return;
            }
            E();
            c cVar = this.f67105b;
            if (cVar != null) {
                try {
                    if (j2 <= cVar.i()) {
                        j2 = this.f67105b.i();
                    }
                    this.f67111h = j2;
                } catch (Throwable th) {
                    k.b("tag_video_play", "[video] MediaPlayerProxy#start  error: getCurrentPosition :" + th.toString());
                }
            }
            if (this.v) {
                b(this.w);
            } else {
                a(this.w);
            }
        }
    }

    private void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65553, this, i2, i3) == null) {
            if (i2 == 701) {
                F();
                this.D = SystemClock.elapsedRealtime();
                this.f67104a++;
            } else if (i2 == 702) {
                if (this.C <= 0) {
                    this.C = System.currentTimeMillis();
                }
                if (this.D > 0) {
                    this.E += SystemClock.elapsedRealtime() - this.D;
                    this.D = 0L;
                }
            } else if (this.F && i2 == 3 && this.C <= 0) {
                this.C = System.currentTimeMillis();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.f
    public void c(c cVar) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) || (handler = this.o) == null) {
            return;
        }
        handler.sendEmptyMessage(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA);
    }

    public void a(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2) == null) {
            F();
            int i2 = this.f67110g;
            if (i2 == 207 || i2 == 206 || i2 == 209) {
                b(new Runnable(this, j2) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ long f67117a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ d f67118b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(j2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67118b = this;
                        this.f67117a = j2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f67118b.f67112i == null) {
                            return;
                        }
                        this.f67118b.f67112i.obtainMessage(106, Long.valueOf(this.f67117a)).sendToTarget();
                    }
                });
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.e
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            this.f67110g = 205;
            if (this.x) {
                this.f67112i.post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ d f67125a;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f67125a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.f67125a.f67105b.h();
                                this.f67125a.f67110g = 207;
                                this.f67125a.x = false;
                            } catch (Throwable th) {
                                k.a("SSMediaPlayeWrapper", "onPrepared error: ", th);
                            }
                        }
                    }
                });
            } else {
                Handler handler = this.f67112i;
                handler.sendMessage(handler.obtainMessage(100, -1, -1));
            }
            u.delete(this.q);
            Handler handler2 = this.o;
            if (handler2 != null) {
                handler2.sendEmptyMessage(305);
            }
            x();
        }
    }

    public void a(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture) == null) {
            b(new Runnable(this, surfaceTexture) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SurfaceTexture f67119a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f67120b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, surfaceTexture};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67120b = this;
                    this.f67119a = surfaceTexture;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f67120b.s();
                        if (this.f67120b.f67112i != null) {
                            this.f67120b.f67112i.obtainMessage(111, this.f67119a).sendToTarget();
                        }
                    }
                }
            });
        }
    }

    public void a(SurfaceHolder surfaceHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, surfaceHolder) == null) {
            b(new Runnable(this, surfaceHolder) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.6
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SurfaceHolder f67121a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f67122b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, surfaceHolder};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67122b = this;
                    this.f67121a = surfaceHolder;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f67122b.s();
                        if (this.f67122b.f67112i != null) {
                            this.f67122b.f67112i.obtainMessage(110, this.f67121a).sendToTarget();
                        }
                    }
                }
            });
        }
    }

    public void a(com.bytedance.sdk.openadsdk.n.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            b(new Runnable(this, bVar) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.n.f.b f67123a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f67124b;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, bVar};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.f67124b = this;
                    this.f67123a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f67124b.s();
                        if (this.f67124b.f67112i != null) {
                            this.f67124b.f67112i.obtainMessage(107, this.f67123a).sendToTarget();
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:177:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:210:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ad  */
    @Override // com.bytedance.sdk.component.utils.w.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Message message) {
        boolean z;
        long j2;
        long i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, message) != null) {
            return;
        }
        int i3 = message.what;
        k.b("tag_video_play", "[video]  execute , mCurrentState = " + this.f67110g + " handlerMsg=" + i3);
        c cVar = this.f67105b;
        if (cVar != null) {
            switch (message.what) {
                case 100:
                    int i4 = this.f67110g;
                    if (i4 == 205 || i4 == 206 || i4 == 207 || i4 == 209) {
                        try {
                            this.f67105b.f();
                            k.b("tag_video_play", "[video] OP_START execute , mMediaPlayer real start !");
                            this.f67110g = 206;
                            if (this.f67111h >= 0) {
                                this.f67105b.a(this.f67111h);
                                this.f67111h = -1L;
                            }
                            if (this.o != null) {
                                this.o.removeMessages(312);
                                this.o.sendEmptyMessage(313);
                            }
                        } catch (Throwable th) {
                            k.a("tag_video_play", "OP_START error: ", th);
                        }
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 101:
                    if (this.f67113j) {
                        this.k += this.n;
                    }
                    this.f67113j = false;
                    this.n = 0L;
                    this.m = Long.MIN_VALUE;
                    int i5 = this.f67110g;
                    if (i5 == 206 || i5 == 207 || i5 == 209) {
                        try {
                            k.b("tag_video_play", "[video] OP_PAUSE execute , mMediaPlayer  OP_PAUSE !");
                            this.f67105b.h();
                            this.f67110g = 207;
                            try {
                                this.x = false;
                            } catch (Throwable th2) {
                                th = th2;
                                k.a("NativeVideoController", "OP_PAUSE error: ", th);
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
                        k.b("tag_video_play", "[video] OP_RELEASE execute , releaseMediaplayer !");
                        this.f67110g = 201;
                        break;
                    } catch (Throwable th4) {
                        k.a("SSMediaPlayeWrapper", "OP_RESET error: ", th4);
                        break;
                    }
                case 103:
                    try {
                        u();
                        k.b("tag_video_play", "[video] OP_RELEASE execute , releaseMediaplayer !");
                    } catch (Throwable th5) {
                        k.c("NativeVideoController", "OP_RELEASE error: ", th5);
                    }
                    this.f67109f = false;
                    a(309, (Object) null);
                    this.f67110g = 203;
                    this.f67105b = null;
                    A();
                    break;
                case 104:
                    int i6 = this.f67110g;
                    if (i6 == 202 || i6 == 208) {
                        try {
                            ((b) this.f67105b).e().prepareAsync();
                            k.b("tag_video_play", "[video] OP_PREPARE_ASYNC execute , mMediaPlayer real prepareAsync !");
                            if (this.o != null) {
                                this.o.sendEmptyMessageDelayed(312, 10000L);
                                break;
                            }
                        } catch (Throwable th6) {
                            k.c("NativeVideoController", "OP_PREPARE_ASYNC error: ", th6);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 105:
                    int i7 = this.f67110g;
                    if (i7 == 205 || i7 == 206 || i7 == 208 || i7 == 207 || i7 == 209) {
                        try {
                            this.f67105b.g();
                            this.f67110g = 208;
                            break;
                        } catch (Throwable th7) {
                            k.a("SSMediaPlayeWrapper", "OP_STOP error: ", th7);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 106:
                    int i8 = this.f67110g;
                    if (i8 == 206 || i8 == 207 || i8 == 209) {
                        try {
                            this.f67105b.a(((Long) message.obj).longValue());
                            break;
                        } catch (Throwable th8) {
                            k.a("SSMediaPlayeWrapper", "OP_SEEKTO error: ", th8);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 107:
                    r();
                    int i9 = this.f67110g;
                    if (i9 == 201 || i9 == 203) {
                        try {
                            com.bytedance.sdk.openadsdk.n.f.b bVar = (com.bytedance.sdk.openadsdk.n.f.b) message.obj;
                            if (TextUtils.isEmpty(bVar.c())) {
                                bVar.c(CacheDirConstants.getFeedCacheDir());
                            }
                            if (TextUtils.isEmpty(bVar.b())) {
                                bVar.b(com.bytedance.sdk.component.video.d.a.a(bVar.a()));
                            }
                            File file = new File(bVar.c(), bVar.b());
                            if (file.exists()) {
                                k.b("SSMediaPlayeWrapper", "try paly local:" + file.getAbsolutePath());
                                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                                    a(file.getAbsolutePath());
                                } else {
                                    this.f67105b.a(file.getAbsolutePath());
                                }
                            } else {
                                k.b("SSMediaPlayeWrapper", "paly net:" + bVar.a());
                                if (bVar.f68275b == 1 && Build.VERSION.SDK_INT < 23) {
                                    this.f67105b.a(bVar.a());
                                } else if (Build.VERSION.SDK_INT >= 23) {
                                    this.f67105b.a(bVar);
                                } else {
                                    String b2 = com.bytedance.sdk.openadsdk.n.f.a.a().b(bVar);
                                    k.f("cache009", "使用Video缓存-OP_SET_DATASOURCE-proxyurl=" + b2);
                                    if (b2 != null && com.bytedance.sdk.openadsdk.multipro.b.b() && b2.startsWith("file")) {
                                        Uri parse = Uri.parse(b2);
                                        k.f("cache010", "使用uri parse =" + parse.getPath());
                                        a(parse.getPath());
                                    } else {
                                        this.f67105b.a(b2);
                                    }
                                }
                            }
                            this.f67110g = 202;
                            if (this.o != null) {
                                this.o.obtainMessage(314).sendToTarget();
                                break;
                            }
                        } catch (Throwable th9) {
                            k.a("SSMediaPlayeWrapper", "OP_SET_DATASOURCE error: ", th9);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 108:
                    int i10 = this.f67110g;
                    if (i10 == 206 || i10 == 207) {
                        try {
                            j2 = this.f67105b.j();
                        } catch (Throwable th10) {
                            k.a("SSMediaPlayeWrapper", "OP_REQUEST_DURATION error: ", th10);
                        }
                        a(108, Long.valueOf(j2));
                        break;
                    }
                    j2 = 0;
                    a(108, Long.valueOf(j2));
                case 109:
                    int i11 = this.f67110g;
                    if (i11 == 206 || i11 == 207) {
                        try {
                            i2 = this.f67105b.i();
                        } catch (Throwable th11) {
                            k.a("SSMediaPlayeWrapper", "OP_REQUEST_CUR_POSITION error: ", th11);
                        }
                        if (i2 > 0) {
                            a(109, Long.valueOf(i2));
                            if (Build.VERSION.SDK_INT >= 23 && g()) {
                                long j3 = this.m;
                                if (j3 != Long.MIN_VALUE) {
                                    if (j3 == i2) {
                                        if (!this.f67113j && this.n >= 400) {
                                            this.l++;
                                            this.f67113j = true;
                                        }
                                        this.n += 200;
                                    } else {
                                        if (this.f67113j) {
                                            long j4 = this.k + this.n;
                                            this.k = j4;
                                            k.b("SSMediaPlayeWrapper", "handleMsg:  bufferingDuration =", Long.valueOf(j4), "  bufferingCount =", Integer.valueOf(this.l));
                                        }
                                        this.f67113j = false;
                                        this.n = 0L;
                                    }
                                }
                                this.m = i2;
                                break;
                            }
                        }
                    }
                    i2 = 0;
                    if (i2 > 0) {
                    }
                    break;
                case 110:
                    try {
                        cVar.a((SurfaceHolder) message.obj);
                        if (this.q == 2) {
                            this.f67105b.a(o.a(), 10);
                        }
                        this.f67105b.a(true);
                        break;
                    } catch (Throwable th12) {
                        k.a("SSMediaPlayeWrapper", "OP_SET_DISPLAY error: ", th12);
                        break;
                    }
                case 111:
                    try {
                        if (Build.VERSION.SDK_INT >= 14) {
                            cVar.a(new Surface((SurfaceTexture) message.obj));
                        }
                        this.f67105b.a(true);
                        this.f67105b.a(o.a(), 10);
                        z();
                        break;
                    } catch (Throwable th13) {
                        k.a("SSMediaPlayeWrapper", "OP_SET_SURFACE error: ", th13);
                        break;
                    }
            }
            if (z) {
                this.f67110g = 200;
                if (this.f67107d) {
                    return;
                }
                a(308, Integer.valueOf(i3));
                this.f67107d = true;
                return;
            }
            return;
        }
        z = false;
        if (z) {
        }
    }

    private void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65555, this, runnable) == null) || runnable == null) {
            return;
        }
        if (!this.f67109f) {
            runnable.run();
        } else {
            a(runnable);
        }
    }

    public void b(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            try {
                if (z) {
                    this.f67105b.a(0.0f, 0.0f);
                } else {
                    this.f67105b.a(1.0f, 1.0f);
                }
            } catch (Throwable th) {
                k.a("SSMediaPlayeWrapper", "setQuietPlay error: ", th);
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, this, str) == null) {
            Handler handler = this.f67112i;
            if (handler != null) {
                handler.removeMessages(201);
            }
            synchronized (this.y) {
                if (this.z != null) {
                    this.z = null;
                }
            }
        }
    }

    private void a(String str) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65550, this, str) == null) {
            FileInputStream fileInputStream = new FileInputStream(str);
            this.f67105b.a(fileInputStream.getFD());
            fileInputStream.close();
        }
    }

    private void a(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65547, this, i2, obj) == null) {
            if (i2 == 309) {
                D();
            }
            Handler handler = this.o;
            if (handler != null) {
                handler.obtainMessage(i2, obj).sendToTarget();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.a
    public void a(c cVar, int i2) {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, cVar, i2) == null) && this.f67105b == cVar && (handler = this.o) != null) {
            handler.obtainMessage(301, Integer.valueOf(i2)).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.b
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f67110g = !this.f67106c ? 209 : 206;
            u.delete(this.q);
            Handler handler = this.o;
            if (handler != null) {
                handler.obtainMessage(302).sendToTarget();
            }
            b("completion");
            F();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.InterfaceC1909c
    public boolean a(c cVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, cVar, i2, i3)) == null) {
            k.f("SSMediaPlayeWrapper", "what=" + i2 + "extra=" + i3);
            w();
            this.f67110g = 200;
            Handler handler = this.o;
            if (handler != null) {
                handler.obtainMessage(303, i2, i3).sendToTarget();
            }
            Handler handler2 = this.f67112i;
            if (handler2 != null) {
                handler2.removeMessages(108);
                this.f67112i.removeMessages(109);
            }
            if (!this.f67107d) {
                a(308, Integer.valueOf(i2));
                this.f67107d = true;
            }
            if (a(i2, i3)) {
                v();
            }
            return true;
        }
        return invokeLII.booleanValue;
    }

    private boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65551, this, i2, i3)) == null) {
            k.b("SSMediaPlayeWrapper", "OnError - Error code: " + i2 + " Extra code: " + i3);
            boolean z = i2 == -1010 || i2 == -1007 || i2 == -1004 || i2 == -110 || i2 == 100 || i2 == 200;
            if (i3 == 1 || i3 == 700 || i3 == 800) {
                return true;
            }
            return z;
        }
        return invokeII.booleanValue;
    }

    private void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, runnable) == null) {
            if (this.p == null) {
                this.p = new ArrayList<>();
            }
            this.p.add(runnable);
        }
    }

    private void a(int i2, boolean z) {
        int C;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65548, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z && (C = C()) != i2) {
                s = true;
                this.r = C;
            }
            AudioManager audioManager = (AudioManager) o.a().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (audioManager != null) {
                audioManager.setStreamVolume(3, i2, 0);
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.g
    public void a(c cVar, int i2, int i3, int i4, int i5) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (handler = this.o) == null) {
            return;
        }
        handler.obtainMessage(311, i2, i3).sendToTarget();
    }
}
