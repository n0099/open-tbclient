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
import com.baidu.ar.face.algo.FAUEnum;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.component.utils.u;
import com.bytedance.sdk.openadsdk.CacheDirConstants;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.c.c;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes5.dex */
public class d implements u.a, c.a, c.b, c.InterfaceC0343c, c.d, c.e, c.f, c.g {
    public static /* synthetic */ Interceptable $ic;
    public static boolean m;
    public static final SparseIntArray o;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public c f30623a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f30624b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f30625c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f30626d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f30627e;

    /* renamed from: f  reason: collision with root package name */
    public int f30628f;

    /* renamed from: g  reason: collision with root package name */
    public long f30629g;

    /* renamed from: h  reason: collision with root package name */
    public final Handler f30630h;

    /* renamed from: i  reason: collision with root package name */
    public Handler f30631i;
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
        o = new SparseIntArray();
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

    private int A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            AudioManager audioManager = (AudioManager) o.a().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            if (audioManager != null) {
                return audioManager.getStreamVolume(3);
            }
            return -1;
        }
        return invokeV.intValue;
    }

    private void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) && m) {
            a(this.l, false);
            m = false;
        }
    }

    private void C() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || this.w > 0) {
            return;
        }
        this.w = System.currentTimeMillis();
    }

    private void D() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) || this.w <= 0) {
            return;
        }
        this.v += System.currentTimeMillis() - this.w;
        this.w = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65556, this) == null) && this.f30623a == null) {
            j.b("SSMediaPlayeWrapper", "SSMediaPlayerWrapper use System Mediaplayer");
            b bVar = new b();
            this.f30623a = bVar;
            this.n = "0";
            bVar.a((c.e) this);
            this.f30623a.a((c.b) this);
            this.f30623a.a((c.InterfaceC0343c) this);
            this.f30623a.a((c.a) this);
            this.f30623a.a((c.f) this);
            this.f30623a.a((c.d) this);
            this.f30623a.a((c.g) this);
            try {
                this.f30623a.b(this.f30624b);
            } catch (Throwable th) {
                j.a("SSMediaPlayeWrapper", "setLooping error: ", th);
            }
            this.f30625c = false;
        }
    }

    private void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65557, this) == null) {
            j.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke !");
            b(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f30633a;

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
                    this.f30633a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30633a.f30630h == null) {
                        return;
                    }
                    this.f30633a.f30630h.sendEmptyMessage(104);
                    j.b("tag_video_play", "[video] MediaPlayerProxy#start first play prepare invoke ! sendMsg --> OP_PREPARE_ASYNC");
                }
            });
        }
    }

    private void s() {
        c cVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65558, this) == null) || (cVar = this.f30623a) == null) {
            return;
        }
        try {
            cVar.l();
        } catch (Throwable th) {
            j.a("SSMediaPlayeWrapper", "releaseMediaplayer error1: ", th);
        }
        this.f30623a.a((c.b) null);
        this.f30623a.a((c.g) null);
        this.f30623a.a((c.a) null);
        this.f30623a.a((c.d) null);
        this.f30623a.a((c.InterfaceC0343c) null);
        this.f30623a.a((c.e) null);
        this.f30623a.a((c.f) null);
        try {
            this.f30623a.k();
        } catch (Throwable th2) {
            j.a("SSMediaPlayeWrapper", "releaseMediaplayer error2: ", th2);
        }
    }

    private void t() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65559, this) == null) || (handler = this.f30630h) == null || handler.getLooper() == null) {
            return;
        }
        try {
            j.b("SSMediaPlayeWrapper", "onDestory............");
            this.f30630h.getLooper().quit();
        } catch (Throwable th) {
            j.a("SSMediaPlayeWrapper", "onDestroy error: ", th);
        }
    }

    private void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65560, this) == null) {
            Integer valueOf = Integer.valueOf(o.get(this.k));
            if (valueOf == null) {
                o.put(this.k, 1);
            } else {
                o.put(this.k, Integer.valueOf(valueOf.intValue() + 1).intValue());
            }
        }
    }

    private void v() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65561, this) == null) || this.z || this.w > 0) {
            return;
        }
        this.w = System.currentTimeMillis();
    }

    private void w() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65562, this) == null) || this.f30626d) {
            return;
        }
        this.f30626d = true;
        Iterator it = new ArrayList(this.j).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.j.clear();
        this.f30626d = false;
    }

    private void x() {
        ArrayList<Runnable> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65563, this) == null) || (arrayList = this.j) == null || arrayList.isEmpty()) {
            return;
        }
        w();
    }

    private void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65564, this) == null) {
            ArrayList<Runnable> arrayList = this.j;
            if (arrayList != null && !arrayList.isEmpty()) {
                w();
            } else {
                t();
            }
        }
    }

    private void z() {
        ArrayList<Runnable> arrayList;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65565, this) == null) || (arrayList = this.j) == null || arrayList.isEmpty()) {
            return;
        }
        this.j.clear();
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            b(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ d f30634a;

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
                    this.f30634a = this;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30634a.f30630h == null) {
                        return;
                    }
                    this.f30634a.f30630h.sendEmptyMessage(105);
                }
            });
        }
    }

    public void e() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048595, this) == null) || (handler = this.f30630h) == null) {
            return;
        }
        handler.obtainMessage(108).sendToTarget();
    }

    public void f() {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048596, this) == null) || (handler = this.f30630h) == null) {
            return;
        }
        handler.obtainMessage(109).sendToTarget();
    }

    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) ? (this.f30628f == 206 || this.f30630h.hasMessages(100)) && !this.r : invokeV.booleanValue;
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? k() || g() || i() : invokeV.booleanValue;
    }

    public boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? (this.f30628f == 207 || this.r) && !this.f30630h.hasMessages(100) : invokeV.booleanValue;
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f30628f == 203 : invokeV.booleanValue;
    }

    public boolean k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f30628f == 205 : invokeV.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) ? this.f30628f == 209 : invokeV.booleanValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            this.v = 0L;
            this.w = System.currentTimeMillis();
        }
    }

    public long n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) ? this.y : invokeV.longValue;
    }

    public long o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            D();
            return this.v;
        }
        return invokeV.longValue;
    }

    public long p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048606, this)) == null) {
            if (this.w > 0) {
                this.v += System.currentTimeMillis() - this.w;
                this.w = System.currentTimeMillis();
            }
            return this.v;
        }
        return invokeV.longValue;
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
        this.f30623a = null;
        this.f30624b = false;
        this.f30625c = false;
        this.f30628f = 201;
        this.f30629g = -1L;
        this.k = 0;
        this.n = "0";
        this.q = new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d f30632a;

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
                this.f30632a = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                    this.f30632a.f30630h.sendEmptyMessageDelayed(100, 0L);
                    j.b("tag_video_play", "[video] MediaPlayerProxy#start not first play ! sendMsg --> OP_START , video start to play !");
                }
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
        this.f30631i = handler;
        HandlerThread handlerThread = new HandlerThread("VideoManager");
        handlerThread.start();
        this.f30630h = new u(handlerThread.getLooper(), this);
        this.z = Build.VERSION.SDK_INT >= 17;
        q();
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.f30630h.removeMessages(100);
            this.r = true;
            this.f30630h.sendEmptyMessage(101);
            D();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f30628f = 203;
            D();
            z();
            if (this.f30630h != null) {
                try {
                    b("release");
                    this.f30630h.removeCallbacksAndMessages(null);
                    if (this.f30623a != null) {
                        this.f30627e = true;
                        this.f30630h.sendEmptyMessage(103);
                    }
                } catch (Throwable th) {
                    t();
                    j.a("SSMediaPlayeWrapper", "release error: ", th);
                }
            }
        }
    }

    public void a(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.p = z;
        }
    }

    public MediaPlayer a() throws Throwable {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            c cVar = this.f30623a;
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
            j.f("SSMediaPlayeWrapper", "what,extra:" + i2 + "," + i3);
            if (this.f30623a != cVar) {
                return false;
            }
            Handler handler = this.f30631i;
            if (handler != null) {
                handler.obtainMessage(304, i2, i3).sendToTarget();
                if (i3 == -1004) {
                    this.f30631i.obtainMessage(303, i2, i3).sendToTarget();
                }
            }
            b(i2, i3);
            return false;
        }
        return invokeLII.booleanValue;
    }

    public void a(boolean z, long j, boolean z2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), Long.valueOf(j), Boolean.valueOf(z2)}) == null) {
            j.b("tag_video_play", "[video] MediaPlayerProxy#start firstSeekToPosition=" + j + ",firstPlay :" + z + ",isPauseOtherMusicVolume=" + z2);
            this.r = false;
            if (!z2) {
                if (this.f30623a != null) {
                    b(true);
                }
            } else if (this.f30623a != null) {
                b(false);
            }
            if (z) {
                j.b("tag_video_play", "[video] first start , SSMediaPlayer  start method !");
                r();
                this.f30629g = j;
                return;
            }
            C();
            c cVar = this.f30623a;
            if (cVar != null) {
                try {
                    if (j <= cVar.i()) {
                        j = this.f30623a.i();
                    }
                    this.f30629g = j;
                } catch (Throwable th) {
                    j.b("tag_video_play", "[video] MediaPlayerProxy#start  error: getCurrentPosition :" + th.toString());
                }
            }
            if (this.p) {
                b(this.q);
            } else {
                a(this.q);
            }
        }
    }

    private void b(int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65551, this, i2, i3) == null) {
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
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.f
    public void c(c cVar) {
        Handler handler;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048593, this, cVar) == null) || (handler = this.f30631i) == null) {
            return;
        }
        handler.sendEmptyMessage(ARPMessageType.MSG_TYPE_IMU_MIRROR_DATA);
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.e
    public void b(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) {
            this.f30628f = 205;
            if (this.r) {
                this.f30630h.post(new Runnable(this) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.8
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ d f30643a;

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
                        this.f30643a = this;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                            try {
                                this.f30643a.f30623a.h();
                                this.f30643a.f30628f = 207;
                                this.f30643a.r = false;
                            } catch (Throwable th) {
                                j.a("SSMediaPlayeWrapper", "onPrepared error: ", th);
                            }
                        }
                    }
                });
            } else {
                Handler handler = this.f30630h;
                handler.sendMessage(handler.obtainMessage(100, -1, -1));
            }
            o.delete(this.k);
            Handler handler2 = this.f30631i;
            if (handler2 != null) {
                handler2.sendEmptyMessage(305);
            }
            v();
        }
    }

    public void a(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            D();
            int i2 = this.f30628f;
            if (i2 == 207 || i2 == 206 || i2 == 209) {
                b(new Runnable(this, j) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* renamed from: a  reason: collision with root package name */
                    public final /* synthetic */ long f30635a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ d f30636b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(j)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f30636b = this;
                        this.f30635a = j;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f30636b.f30630h == null) {
                            return;
                        }
                        this.f30636b.f30630h.obtainMessage(106, Long.valueOf(this.f30635a)).sendToTarget();
                    }
                });
            }
        }
    }

    public void a(SurfaceTexture surfaceTexture) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, surfaceTexture) == null) {
            b(new Runnable(this, surfaceTexture) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ SurfaceTexture f30637a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f30638b;

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
                    this.f30638b = this;
                    this.f30637a = surfaceTexture;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f30638b.q();
                        if (this.f30638b.f30630h != null) {
                            this.f30638b.f30630h.obtainMessage(111, this.f30637a).sendToTarget();
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
                public final /* synthetic */ SurfaceHolder f30639a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f30640b;

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
                    this.f30640b = this;
                    this.f30639a = surfaceHolder;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f30640b.q();
                        if (this.f30640b.f30630h != null) {
                            this.f30640b.f30630h.obtainMessage(110, this.f30639a).sendToTarget();
                        }
                    }
                }
            });
        }
    }

    public void a(com.bytedance.sdk.openadsdk.o.f.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            b(new Runnable(this, bVar) { // from class: com.bytedance.sdk.openadsdk.core.video.c.d.7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ com.bytedance.sdk.openadsdk.o.f.b f30641a;

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ d f30642b;

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
                    this.f30642b = this;
                    this.f30641a = bVar;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.f30642b.q();
                        if (this.f30642b.f30630h != null) {
                            this.f30642b.f30630h.obtainMessage(107, this.f30641a).sendToTarget();
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:186:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b4  */
    @Override // com.bytedance.sdk.component.utils.u.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Message message) {
        boolean z;
        long i2;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048579, this, message) != null) {
            return;
        }
        int i3 = message.what;
        j.b("tag_video_play", "[video]  execute , mCurrentState = " + this.f30628f + " handlerMsg=" + i3);
        c cVar = this.f30623a;
        if (cVar != null) {
            long j = 0;
            switch (message.what) {
                case 100:
                    int i4 = this.f30628f;
                    if (i4 == 205 || i4 == 206 || i4 == 207 || i4 == 209) {
                        try {
                            this.f30623a.f();
                            j.b("tag_video_play", "[video] OP_START execute , mMediaPlayer real start !");
                            this.f30628f = 206;
                            if (this.f30629g >= 0) {
                                this.f30623a.a(this.f30629g);
                                this.f30629g = -1L;
                            }
                            if (this.f30631i != null) {
                                this.f30631i.removeMessages(312);
                                this.f30631i.sendEmptyMessage(313);
                            }
                        } catch (Throwable th) {
                            j.a("tag_video_play", "OP_START error: ", th);
                        }
                        z = false;
                        break;
                    }
                    z = true;
                    break;
                case 101:
                    int i5 = this.f30628f;
                    if (i5 == 206 || i5 == 207 || i5 == 209) {
                        try {
                            j.b("tag_video_play", "[video] OP_PAUSE execute , mMediaPlayer  OP_PAUSE !");
                            this.f30623a.h();
                            this.f30628f = 207;
                            try {
                                this.r = false;
                            } catch (Throwable th2) {
                                th = th2;
                                j.a("NativeVideoController", "OP_PAUSE error: ", th);
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
                        j.b("tag_video_play", "[video] OP_RELEASE execute , releaseMediaplayer !");
                        this.f30628f = 201;
                        break;
                    } catch (Throwable th4) {
                        j.a("SSMediaPlayeWrapper", "OP_RESET error: ", th4);
                        break;
                    }
                case 103:
                    try {
                        s();
                        j.b("tag_video_play", "[video] OP_RELEASE execute , releaseMediaplayer !");
                    } catch (Throwable th5) {
                        j.c("NativeVideoController", "OP_RELEASE error: ", th5);
                    }
                    this.f30627e = false;
                    a(309, (Object) null);
                    this.f30628f = 203;
                    this.f30623a = null;
                    y();
                    break;
                case 104:
                    int i6 = this.f30628f;
                    if (i6 == 202 || i6 == 208) {
                        try {
                            ((b) this.f30623a).e().prepareAsync();
                            j.b("tag_video_play", "[video] OP_PREPARE_ASYNC execute , mMediaPlayer real prepareAsync !");
                            if (this.f30631i != null) {
                                this.f30631i.sendEmptyMessageDelayed(312, 10000L);
                                break;
                            }
                        } catch (Throwable th6) {
                            j.c("NativeVideoController", "OP_PREPARE_ASYNC error: ", th6);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 105:
                    int i7 = this.f30628f;
                    if (i7 == 205 || i7 == 206 || i7 == 208 || i7 == 207 || i7 == 209) {
                        try {
                            this.f30623a.g();
                            this.f30628f = 208;
                            break;
                        } catch (Throwable th7) {
                            j.a("SSMediaPlayeWrapper", "OP_STOP error: ", th7);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 106:
                    int i8 = this.f30628f;
                    if (i8 == 206 || i8 == 207 || i8 == 209) {
                        try {
                            this.f30623a.a(((Long) message.obj).longValue());
                            break;
                        } catch (Throwable th8) {
                            j.a("SSMediaPlayeWrapper", "OP_SEEKTO error: ", th8);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 107:
                    int i9 = this.f30628f;
                    if (i9 == 201 || i9 == 203) {
                        try {
                            com.bytedance.sdk.openadsdk.o.f.b bVar = (com.bytedance.sdk.openadsdk.o.f.b) message.obj;
                            if (TextUtils.isEmpty(bVar.d())) {
                                bVar.c(CacheDirConstants.getFeedCacheDir());
                            }
                            if (TextUtils.isEmpty(bVar.b())) {
                                bVar.b(com.bytedance.sdk.component.video.d.a.a(bVar.a()));
                            }
                            File file = new File(bVar.d(), bVar.b());
                            if (file.exists()) {
                                j.b("SSMediaPlayeWrapper", "try paly local:" + file.getAbsolutePath());
                                if (com.bytedance.sdk.openadsdk.multipro.b.b()) {
                                    a(file.getAbsolutePath());
                                } else {
                                    this.f30623a.a(file.getAbsolutePath());
                                }
                            } else {
                                j.b("SSMediaPlayeWrapper", "paly net:" + bVar.a());
                                if (bVar.f31758b == 1 && Build.VERSION.SDK_INT < 23) {
                                    this.f30623a.a(bVar.a());
                                } else if (Build.VERSION.SDK_INT >= 23) {
                                    this.f30623a.a(bVar);
                                } else {
                                    String b2 = com.bytedance.sdk.openadsdk.o.f.a.a().b(bVar);
                                    j.f("cache009", "使用Video缓存-OP_SET_DATASOURCE-proxyurl=" + b2);
                                    if (b2 != null && com.bytedance.sdk.openadsdk.multipro.b.b() && b2.startsWith("file")) {
                                        Uri parse = Uri.parse(b2);
                                        j.f("cache010", "使用uri parse =" + parse.getPath());
                                        a(parse.getPath());
                                    } else {
                                        this.f30623a.a(b2);
                                    }
                                }
                            }
                            this.f30628f = 202;
                            if (this.f30631i != null) {
                                this.f30631i.obtainMessage(314).sendToTarget();
                                break;
                            }
                        } catch (Throwable th9) {
                            j.a("SSMediaPlayeWrapper", "OP_SET_DATASOURCE error: ", th9);
                            break;
                        }
                    }
                    z = true;
                    break;
                case 108:
                    int i10 = this.f30628f;
                    if (i10 == 206 || i10 == 207) {
                        try {
                            j = this.f30623a.j();
                        } catch (Throwable th10) {
                            j.a("SSMediaPlayeWrapper", "OP_REQUEST_DURATION error: ", th10);
                        }
                    }
                    a(108, Long.valueOf(j));
                    break;
                case 109:
                    int i11 = this.f30628f;
                    if (i11 == 206 || i11 == 207) {
                        try {
                            i2 = this.f30623a.i();
                        } catch (Throwable th11) {
                            j.a("SSMediaPlayeWrapper", "OP_REQUEST_CUR_POSITION error: ", th11);
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
                            this.f30623a.a(o.a(), 10);
                        }
                        this.f30623a.a(true);
                        break;
                    } catch (Throwable th12) {
                        j.a("SSMediaPlayeWrapper", "OP_SET_DISPLAY error: ", th12);
                        break;
                    }
                case 111:
                    try {
                        if (Build.VERSION.SDK_INT >= 14) {
                            cVar.a(new Surface((SurfaceTexture) message.obj));
                        }
                        this.f30623a.a(true);
                        this.f30623a.a(o.a(), 10);
                        x();
                        break;
                    } catch (Throwable th13) {
                        j.a("SSMediaPlayeWrapper", "OP_SET_SURFACE error: ", th13);
                        break;
                    }
            }
            if (z) {
                this.f30628f = 200;
                if (this.f30625c) {
                    return;
                }
                a(308, Integer.valueOf(i3));
                this.f30625c = true;
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
        if (!(interceptable == null || interceptable.invokeL(65553, this, runnable) == null) || runnable == null) {
            return;
        }
        if (!this.f30627e) {
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
                    this.f30623a.a(0.0f, 0.0f);
                } else {
                    this.f30623a.a(1.0f, 1.0f);
                }
            } catch (Throwable th) {
                j.a("SSMediaPlayeWrapper", "setQuietPlay error: ", th);
            }
        }
    }

    private void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65554, this, str) == null) {
            Handler handler = this.f30630h;
            if (handler != null) {
                handler.removeMessages(201);
            }
            synchronized (this.s) {
                if (this.t != null) {
                    this.t = null;
                }
            }
        }
    }

    private void a(String str) throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65548, this, str) == null) {
            FileInputStream fileInputStream = new FileInputStream(str);
            this.f30623a.a(fileInputStream.getFD());
            fileInputStream.close();
        }
    }

    private void a(int i2, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65545, this, i2, obj) == null) {
            if (i2 == 309) {
                B();
            }
            Handler handler = this.f30631i;
            if (handler != null) {
                handler.obtainMessage(i2, obj).sendToTarget();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.a
    public void a(c cVar, int i2) {
        Handler handler;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(1048582, this, cVar, i2) == null) && this.f30623a == cVar && (handler = this.f30631i) != null) {
            handler.obtainMessage(301, Integer.valueOf(i2)).sendToTarget();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.b
    public void a(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, cVar) == null) {
            this.f30628f = !this.f30624b ? FAUEnum.PR_TIMEOUT : 206;
            o.delete(this.k);
            Handler handler = this.f30631i;
            if (handler != null) {
                handler.obtainMessage(302).sendToTarget();
            }
            b("completion");
            D();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.video.c.c.InterfaceC0343c
    public boolean a(c cVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(1048587, this, cVar, i2, i3)) == null) {
            j.f("SSMediaPlayeWrapper", "what=" + i2 + "extra=" + i3);
            u();
            this.f30628f = 200;
            Handler handler = this.f30631i;
            if (handler != null) {
                handler.obtainMessage(303, i2, i3).sendToTarget();
            }
            Handler handler2 = this.f30630h;
            if (handler2 != null) {
                handler2.removeMessages(108);
                this.f30630h.removeMessages(109);
            }
            if (!this.f30625c) {
                a(308, Integer.valueOf(i2));
                this.f30625c = true;
            }
            if (a(i2, i3)) {
                t();
            }
            return true;
        }
        return invokeLII.booleanValue;
    }

    private boolean a(int i2, int i3) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65549, this, i2, i3)) == null) {
            j.b("SSMediaPlayeWrapper", "OnError - Error code: " + i2 + " Extra code: " + i3);
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
        if (interceptable == null || interceptable.invokeL(65547, this, runnable) == null) {
            if (this.j == null) {
                this.j = new ArrayList<>();
            }
            this.j.add(runnable);
        }
    }

    private void a(int i2, boolean z) {
        int A;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65546, this, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            if (z && (A = A()) != i2) {
                m = true;
                this.l = A;
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
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{cVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) || (handler = this.f30631i) == null) {
            return;
        }
        handler.obtainMessage(311, i2, i3).sendToTarget();
    }
}
