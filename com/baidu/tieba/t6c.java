package com.baidu.tieba;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.ar.arplay.core.message.ARPMessageType;
import com.baidu.searchbox.pms.constants.ErrorConstant;
import com.baidu.tieba.e6c;
import com.baidu.tieba.q6c;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.transvod.player.core.TransVodProxy;
import com.yy.transvod.player.log.TLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes8.dex */
public class t6c extends v7c implements q6c.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String L = "os";
    public static String M = "osversion";
    public static String N = "version";
    public static String O = "model";
    public transient /* synthetic */ FieldHolder $fh;
    public Handler A;
    public TransVodProxy B;
    public y6c C;
    public m6c D;
    public AtomicInteger E;
    public boolean F;
    public boolean G;
    public WeakReference<e> H;
    public s6c I;
    public final TransVodProxy.a J;
    public final e6c.a K;
    public final String c;
    public final int d;
    public String e;
    public String f;
    public final Object g;
    public Context h;
    public a6c i;
    public q7c j;
    public q7c k;
    public q7c l;
    public q7c m;
    public q7c n;
    public q7c o;
    public p7c p;
    public w6c q;
    public String r;
    public String s;
    public g5c t;
    public int u;
    public int v;
    public int w;
    public long x;
    public boolean y;
    public boolean z;

    /* loaded from: classes8.dex */
    public interface e {
        void a(Message message);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948134600, "Lcom/baidu/tieba/t6c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948134600, "Lcom/baidu/tieba/t6c;");
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements s6c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t6c a;

        public a(t6c t6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t6cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t6cVar;
        }

        @Override // com.baidu.tieba.s6c
        public void a(Message message, int i) {
            int i2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, message, i) == null) {
                if (i != this.a.a && (i2 = message.what) != 5203 && i2 != 5204) {
                    TLog.h(this.a.c, String.format(Locale.getDefault(), "the message is old type %d + taskId %d  + mPlayTaskId %d", Integer.valueOf(message.what), Integer.valueOf(i), Integer.valueOf(this.a.a)));
                    return;
                }
                e eVar = (e) this.a.H.get();
                if (eVar != null) {
                    eVar.a(message);
                    if (message.what == 5102) {
                        this.a.J0();
                    }
                    if (message.what == 5000) {
                        if (message.arg1 == 5) {
                            this.a.q.D(message.arg2);
                        }
                        if (message.arg1 == 6 && this.a.l != null) {
                            ((u7c) this.a.l).L();
                        }
                    }
                    if (message.what != 53) {
                        return;
                    }
                    this.a.F = true;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements TransVodProxy.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t6c a;

        public b(t6c t6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t6cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t6cVar;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements e6c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t6c a;

        @Override // com.baidu.tieba.e6c.a
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        public c(t6c t6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t6cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t6cVar;
        }

        @Override // com.baidu.tieba.e6c.a
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, message) == null) {
                int i = message.what;
                if (i != 1001) {
                    if (i == 1002) {
                        this.a.F0();
                        return;
                    }
                    boolean z = false;
                    if (i != 1004) {
                        if (i != 1005) {
                            if (i != 1012) {
                                if (i != 1031) {
                                    if (i != 2205) {
                                        switch (i) {
                                            case 1008:
                                                this.a.p0();
                                                return;
                                            case 1009:
                                                this.a.q0();
                                                return;
                                            case 1010:
                                                this.a.v0();
                                                return;
                                            default:
                                                switch (i) {
                                                    case 1014:
                                                        this.a.E0(message.arg1);
                                                        return;
                                                    case 1015:
                                                        this.a.s0();
                                                        return;
                                                    case 1016:
                                                        this.a.w0();
                                                        return;
                                                    case 1017:
                                                        this.a.t0();
                                                        return;
                                                    case 1018:
                                                        this.a.x0();
                                                        return;
                                                    case 1019:
                                                        this.a.n0(message.arg1);
                                                        return;
                                                    case 1020:
                                                        t6c t6cVar = this.a;
                                                        if (message.arg1 == 1) {
                                                            z = true;
                                                        }
                                                        t6cVar.r0(z);
                                                        return;
                                                    default:
                                                        switch (i) {
                                                            case 1041:
                                                                this.a.G0(message.arg1, message.getData().getString("pcdnManufacturer"), message.getData().getStringArray("pcdnUrls"));
                                                                return;
                                                            case 1042:
                                                                this.a.B0();
                                                                return;
                                                            case 1043:
                                                                this.a.C0(message.arg1);
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                }
                                        }
                                    }
                                    j6c j6cVar = (j6c) message.obj;
                                    this.a.y0((Executor) j6cVar.a, j6cVar.b);
                                    return;
                                }
                                this.a.D0((p6c) message.obj);
                                return;
                            }
                            this.a.o0(message.arg1);
                            return;
                        }
                        this.a.z0(message.arg1);
                        return;
                    }
                    this.a.A0(message.arg1, message.arg2, 0);
                    return;
                }
                this.a.u0(message.arg1, message.getData().getLong("startTimeMs"));
            }
        }

        @Override // com.baidu.tieba.e6c.a
        public void onPause() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.G = true;
                String str = this.a.c;
                TLog.h(str, "MediaPlaySession.onPause " + this.a.e);
                if (this.a.B != null) {
                    this.a.B.h();
                }
                String str2 = this.a.c;
                TLog.h(str2, "MediaPlaySession.onPause " + this.a.f);
            }
        }

        @Override // com.baidu.tieba.e6c.a
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.G = false;
                String str = this.a.c;
                TLog.h(str, "MediaPlaySession.onResume " + this.a.e);
                if (this.a.B != null) {
                    this.a.B.n();
                }
                q6c.i();
                String str2 = this.a.c;
                TLog.h(str2, "MediaPlaySession.onResume " + this.a.f);
            }
        }

        @Override // com.baidu.tieba.e6c.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                String str = this.a.c;
                TLog.h(str, "MediaPlaySession.onStart " + this.a.e);
                this.a.C = new y6c(this.a.h, this.a.i);
                t6c t6cVar = this.a;
                t6cVar.B = t6cVar.C.d(this.a.d, this.a.i);
                this.a.B.k(this.a.J);
                this.a.B.t(this.a.I);
                t6c t6cVar2 = this.a;
                t6cVar2.j = new r7c(t6cVar2.d);
                t6c t6cVar3 = this.a;
                t6cVar3.k = new r7c(t6cVar3.d);
                this.a.m = new m7c(this.a.d);
                String str2 = this.a.c;
                TLog.h(str2, "MediaPlaySession.onStart " + this.a.f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ t6c a;

        public d(t6c t6cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {t6cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = t6cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                synchronized (this.a.g) {
                    TLog.g(this, "release thread: begin");
                    this.a.D.c();
                    this.a.B = null;
                    this.a.j = null;
                    this.a.k = null;
                    if (this.a.l != null) {
                        this.a.l.p();
                    }
                    if (this.a.m != null) {
                        this.a.m.p();
                    }
                    if (this.a.n != null) {
                        this.a.n.p();
                    }
                    if (this.a.o != null) {
                        this.a.o.p();
                    }
                    this.a.l = null;
                    this.a.m = null;
                    this.a.n = null;
                    this.a.o = null;
                    this.a.h = null;
                    this.a.p = null;
                    if (this.a.C != null) {
                        this.a.C.f();
                    }
                    q6c.k(this.a);
                }
                h6c.f().d();
                TLog.g(this, "release thread: end");
                if (this.a.A != null) {
                    this.a.A.getLooper().quit();
                }
            }
        }
    }

    public t6c(a6c a6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a6cVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = t6c.class.getSimpleName();
        this.d = hashCode();
        this.e = this.d + " enter.";
        this.f = this.d + " leave.";
        this.g = new Object();
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = 0;
        this.v = 1;
        this.w = 1;
        this.y = false;
        this.z = false;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = new m6c(String.valueOf(this.d));
        this.E = new AtomicInteger(1);
        this.G = false;
        this.H = new WeakReference<>(null);
        this.I = new a(this);
        this.J = new b(this);
        this.K = new c(this);
        this.i = a6cVar;
        this.D.setName("VOD MediaPlaySession");
        this.b = this.d;
        this.D.b(this.K);
    }

    public void V0(g5c g5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, g5cVar) == null) {
            TLog.g(this, "setDataSourceAndPrepare");
            if (this.E.get() == 9) {
                TLog.c(this, this.d + "invalid state");
            }
            if (g5cVar.k() == null || g5cVar.k().isEmpty()) {
                TLog.c(this, this.d + "DataSource is empty");
            }
            this.E.set(2);
            g5cVar.o(L, "Android");
            g5cVar.o(M, Build.VERSION.RELEASE);
            g5cVar.o(N, "12.1.0.34");
            g5cVar.o(O, Build.MODEL);
            this.r = g5cVar.k();
            this.t = g5cVar;
            this.u = g5cVar.l();
            this.v = g5cVar.h();
            this.w = g5cVar.b();
            this.y = g5cVar.d();
            this.z = g5cVar.c();
            this.a = (int) g5cVar.j();
            this.x = g5cVar.i();
            synchronized (this.g) {
                Message obtain = Message.obtain();
                obtain.arg1 = this.a;
                obtain.what = 1043;
                this.D.g(1043);
                this.D.sendMessage(obtain);
            }
        }
    }

    public final void D0(p6c p6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, p6cVar) == null) {
            TLog.g(this, "MediaPlaySession internalSetEffectResources");
            ((u7c) this.l).S(p6cVar);
        }
    }

    public void W0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            ((u7c) this.l).R(i);
        }
    }

    public void X0(p6c p6cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, p6cVar) == null) {
            TLog.g(this, "MediaPlaySession setEffectResources");
            synchronized (this.g) {
                Message obtain = Message.obtain();
                obtain.what = ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE;
                obtain.obj = p6cVar;
                this.D.g(ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE);
                this.D.sendMessage(obtain);
            }
        }
    }

    public void Y0(boolean z) {
        u7c u7cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && (u7cVar = (u7c) this.l) != null) {
            u7cVar.T(z);
        }
    }

    public void Z0(boolean z) {
        u7c u7cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048601, this, z) == null) && (u7cVar = (u7c) this.l) != null) {
            u7cVar.U(z);
        }
    }

    public void a1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            ((u7c) this.l).V(z);
        }
    }

    @Override // com.baidu.tieba.q6c.b
    public void c(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            synchronized (this.g) {
                this.D.g(1020);
                m6c m6cVar = this.D;
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                m6cVar.sendMessage(Message.obtain(null, 1020, i, 0));
            }
        }
    }

    public void c1(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, eVar) == null) {
            this.H = new WeakReference<>(eVar);
        }
    }

    public void d1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            ((u7c) this.l).W(i);
        }
    }

    public void e1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            ((u7c) this.l).X(i);
        }
    }

    public void f1(boolean z) {
        p7c p7cVar;
        z6c h;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048608, this, z) != null) || (p7cVar = this.p) == null || (h = p7cVar.h()) == null) {
            return;
        }
        h.j(z);
    }

    public void g1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048610, this, i) == null) {
            synchronized (this.g) {
                this.D.g(1012);
                this.D.sendMessage(Message.obtain(null, 1012, i, 0));
            }
        }
    }

    public void k0(f6c f6cVar) {
        z6c h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, f6cVar) == null) {
            ((u7c) this.l).I(f6cVar);
            p7c p7cVar = this.p;
            if (p7cVar != null && (h = p7cVar.h()) != null) {
                h.k(f6cVar.a);
            }
        }
    }

    public final void o0(int i) {
        q7c q7cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048620, this, i) == null) && (q7cVar = this.m) != null) {
            q7cVar.u(i);
        }
    }

    public final void y0(Executor executor, Object obj) {
        q7c q7cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048630, this, executor, obj) == null) && (q7cVar = this.l) != null) {
            ((u7c) q7cVar).P(executor, obj);
        }
    }

    public final void G0(int i, String str, String[] strArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(1048582, this, i, str, strArr) == null) {
            TLog.g(this, "MediaPlaySession internalUpdatePcdnUrls " + this.e);
            TransVodProxy transVodProxy = this.B;
            if (transVodProxy != null) {
                transVodProxy.x(i, str, strArr);
            }
        }
    }

    public final void A0(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048576, this, i, i2, i3) == null) {
            TLog.g(this, String.format(Locale.getDefault(), "%d internalSetCacheTime(%d, %d) enter.", Integer.valueOf(this.d), Integer.valueOf(i), Integer.valueOf(i2)));
            TransVodProxy transVodProxy = this.B;
            if (transVodProxy != null) {
                transVodProxy.q(i, i2, i3);
            }
            TLog.g(this, String.format(Locale.getDefault(), "%d internalSetCacheTime(%d, %d) leave.", Integer.valueOf(this.d), Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            TLog.g(this, "MediaPlaySession internalSetDataSource " + this.e);
            if (this.B != null && !TextUtils.isEmpty(this.r)) {
                this.B.r(this.r, this.u);
            }
            TLog.g(this, "MediaPlaySession internalSetDataSource " + this.f);
        }
    }

    public void H0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            TLog.g(this, "MediaPlaySession onAppInbackground " + this.e);
            synchronized (this.g) {
                this.D.g(1019);
                this.D.sendMessage(Message.obtain(null, 1019, 0, 0));
            }
            TLog.g(this, "MediaPlaySession onAppInbackground " + this.f);
        }
    }

    public void I0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TLog.g(this, "MediaPlaySession onAppInfront " + this.e);
            synchronized (this.g) {
                this.D.g(1019);
                this.D.sendMessage(Message.obtain(null, 1019, 1, 0));
            }
            TLog.g(this, "MediaPlaySession onAppInfront " + this.f);
        }
    }

    public void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            TLog.g(this, "MediaPlaySession pausePlayWithAudio " + this.e);
            synchronized (this.g) {
                this.E.get();
                this.D.g(1015);
                this.D.f(1015);
            }
            TLog.g(this, "MediaPlaySession pausePlayWithAudio " + this.f);
        }
    }

    public void M0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            TLog.g(this, "MediaPlaySession pausePlayWithVideo " + this.e);
            synchronized (this.g) {
                this.E.get();
                this.D.g(1017);
                this.D.f(1017);
            }
            TLog.g(this, "MediaPlaySession pausePlayWithVideo " + this.f);
        }
    }

    public void Q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            TLog.g(this, "MediaPlaySession resumePlayWithAudio " + this.e);
            synchronized (this.g) {
                this.E.get();
                this.D.g(1016);
                this.D.f(1016);
            }
            TLog.g(this, "MediaPlaySession resumePlayWithAudio " + this.f);
        }
    }

    public void R0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            TLog.g(this, "MediaPlaySession resumePlayWithVideo " + this.e);
            synchronized (this.g) {
                this.E.get();
                this.D.g(1018);
                this.D.f(1018);
            }
            TLog.g(this, "MediaPlaySession resumePlayWithVideo " + this.f);
        }
    }

    public final void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048621, this) == null) {
            TLog.g(this, String.format(Locale.getDefault(), "%d internalClearRender enter.", Integer.valueOf(this.d)));
            q7c q7cVar = this.l;
            if (q7cVar != null) {
                q7cVar.o();
            }
            TLog.g(this, String.format(Locale.getDefault(), "%d internalClearRender leave.", Integer.valueOf(this.d)));
        }
    }

    public final void C0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            TLog.g(this, "MediaPlaySession internalSetDataSourceAndPrepare " + this.e);
            if (this.B != null && !TextUtils.isEmpty(this.r)) {
                this.B.r(this.r, this.u);
            }
            TLog.g(this, "MediaPlaySession internalSetDataSourceAndPrepare " + this.f);
            g5c g5cVar = this.t;
            if (g5cVar != null) {
                this.B.s(this.r, this.u, this.v, this.w, i, this.y, this.z, this.x, g5cVar.g());
            }
        }
    }

    public void T0(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            TLog.g(this, "MediaPlaySession seekTo " + this.e);
            synchronized (this.g) {
                int i = this.E.get();
                if (i != 6 && i != 7) {
                    TLog.c(this, String.format(Locale.getDefault(), "want to seekTo,Illegal state ,mCurrentState = %s", l6c.a[i]));
                }
                this.D.g(1005);
                this.D.sendMessage(Message.obtain(null, 1005, (int) j, 0));
            }
            TLog.g(this, "MediaPlaySession seekTo " + this.f);
        }
    }

    public final void E0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            TLog.g(this, String.format(Locale.getDefault(), "%d internalSetNumberOfLoops(%d) enter.", Integer.valueOf(this.d), Integer.valueOf(i)));
            TransVodProxy transVodProxy = this.B;
            if (transVodProxy != null) {
                transVodProxy.u(i);
            }
            TLog.g(this, String.format(Locale.getDefault(), "%d internalSetNumberOfLoops(%d) leave.", Integer.valueOf(this.d), Integer.valueOf(i)));
        }
    }

    public final void r0(boolean z) {
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048623, this, z) == null) {
            Locale locale = Locale.getDefault();
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(this.d);
            String str = "Gain";
            if (z) {
                obj = "Gain";
            } else {
                obj = "Loss";
            }
            objArr[1] = obj;
            TLog.g(this, String.format(locale, "%d internalFocusChange(%s) enter.", objArr));
            TransVodProxy transVodProxy = this.B;
            if (transVodProxy != null) {
                transVodProxy.b(z);
            }
            Locale locale2 = Locale.getDefault();
            Object[] objArr2 = new Object[2];
            objArr2[0] = Integer.valueOf(this.d);
            if (!z) {
                str = "Loss";
            }
            objArr2[1] = str;
            TLog.g(this, String.format(locale2, "%d internalFocusChange(%s) leave.", objArr2));
        }
    }

    public final void z0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048631, this, i) == null) {
            TLog.g(this, String.format(Locale.getDefault(), "%d internalSeekTo(%d) enter.", Integer.valueOf(this.d), Integer.valueOf(i)));
            TransVodProxy transVodProxy = this.B;
            if (transVodProxy != null) {
                transVodProxy.p(i);
            }
            TLog.g(this, String.format(Locale.getDefault(), "%d internalSeekTo(%d) leave.", Integer.valueOf(this.d), Integer.valueOf(i)));
        }
    }

    public final void F0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            TLog.g(this, "MediaPlaySession internalStop " + this.e);
            TransVodProxy transVodProxy = this.B;
            if (transVodProxy != null) {
                transVodProxy.v(false);
            }
            this.p.d();
            this.p.n();
            this.p.b();
            if (this.y) {
                TLog.g(this, "MediaPlaySession is for live : stop");
                this.q.F();
            } else {
                q7c q7cVar = this.l;
                if (q7cVar != null) {
                    ((u7c) q7cVar).G();
                }
            }
            TLog.g(this, "MediaPlaySession internalStop " + this.f);
        }
    }

    public void K0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            TLog.g(this, "MediaPlaySession pause " + this.e);
            synchronized (this.g) {
                int i = this.E.get();
                if (i == 6) {
                    this.E.set(7);
                    this.D.o();
                    TLog.g(this, this.d + "paused source = " + this.r);
                } else {
                    TLog.c(this, this.d + "state=" + i);
                }
            }
            TLog.g(this, "MediaPlaySession pause " + this.f);
        }
    }

    public void N0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            TLog.g(this, "MediaPlaySession release " + this.e);
            if (this.E.get() != 1) {
                this.E.set(1);
                this.D.g(1002);
                this.D.f(1002);
            }
            this.E.set(9);
            this.D.g(1010);
            this.D.f(1010);
            TLog.g(this, "MediaPlaySession release " + this.f);
        }
    }

    public void P0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            TLog.g(this, "MediaPlaySession resume " + this.e);
            synchronized (this.g) {
                int i = this.E.get();
                if (i == 7) {
                    this.D.p();
                    this.E.set(6);
                } else {
                    TLog.c(this, this.d + "state=" + i);
                }
            }
            TLog.g(this, "MediaPlaySession resume " + this.f);
        }
    }

    public void J0() {
        q7c q7cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (q7cVar = this.o) != null) {
            q7cVar.e(true);
        }
    }

    public void O0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            TLog.g(this, "MediaPlaySession reset seek time");
        }
    }

    public void finalize() throws Throwable {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048609, this) == null) {
            super.finalize();
        }
    }

    public void j0() {
        z6c h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            ((u7c) this.l).H();
            p7c p7cVar = this.p;
            if (p7cVar != null && (h = p7cVar.h()) != null) {
                h.k(true);
            }
        }
    }

    public String l0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            if (!TextUtils.isEmpty(this.s)) {
                return this.s;
            }
            TransVodProxy transVodProxy = this.B;
            if (transVodProxy != null) {
                this.s = transVodProxy.d();
            }
            return this.s;
        }
        return (String) invokeV.objValue;
    }

    public final int m0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048618, this)) == null) {
            return this.d;
        }
        return invokeV.intValue;
    }

    public final void s0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            this.G = true;
            q7c q7cVar = this.m;
            if (q7cVar != null) {
                ((m7c) q7cVar).F(this.a);
            }
            TransVodProxy transVodProxy = this.B;
            if (transVodProxy != null) {
                transVodProxy.i(false);
            }
        }
    }

    public final void t0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            q7c q7cVar = this.l;
            if (q7cVar != null) {
                ((u7c) q7cVar).M(this.a);
            }
            TransVodProxy transVodProxy = this.B;
            if (transVodProxy != null) {
                transVodProxy.i(true);
            }
        }
    }

    public final void w0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048628, this) == null) {
            this.G = false;
            q7c q7cVar = this.m;
            if (q7cVar != null) {
                ((m7c) q7cVar).H(this.a);
            }
            TransVodProxy transVodProxy = this.B;
            if (transVodProxy != null) {
                transVodProxy.o(false);
            }
            q6c.i();
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            q7c q7cVar = this.l;
            if (q7cVar != null) {
                ((u7c) q7cVar).Q(this.a);
            }
            TransVodProxy transVodProxy = this.B;
            if (transVodProxy != null) {
                transVodProxy.o(true);
            }
        }
    }

    public void S0(Executor executor, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048594, this, executor, obj) == null) {
            TLog.g(this, "MediaPlaySession screenShot " + this.e);
            synchronized (this.g) {
                j6c j6cVar = new j6c(executor, obj);
                this.D.g(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE);
                this.D.sendMessage(Message.obtain(null, ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, j6cVar));
            }
            TLog.g(this, "MediaPlaySession screenShot " + this.f);
        }
    }

    public void U0(g5c g5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, g5cVar) == null) {
            TLog.g(this, "setDataSource");
            if (this.E.get() == 9) {
                TLog.c(this, this.d + "invalid state");
            }
            if (g5cVar.k() == null || g5cVar.k().isEmpty()) {
                TLog.c(this, this.d + "DataSource is empty");
            }
            g5cVar.o(L, "Android");
            g5cVar.o(M, Build.VERSION.RELEASE);
            g5cVar.o(N, "12.1.0.34");
            g5cVar.o(O, Build.MODEL);
            this.r = g5cVar.k();
            this.t = g5cVar;
            this.u = g5cVar.l();
            this.v = g5cVar.h();
            this.w = g5cVar.b();
            this.y = g5cVar.d();
            this.z = g5cVar.c();
            synchronized (this.g) {
                Message obtain = Message.obtain();
                obtain.what = 1042;
                this.D.g(1042);
                this.D.sendMessage(obtain);
            }
        }
    }

    public void b1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048603, this, i) == null) {
            TLog.g(this, "MediaPlaySession setNumberOfLoops" + this.e);
            synchronized (this.g) {
                this.D.g(1014);
                this.D.sendMessage(Message.obtain(null, 1014, i, 0));
            }
        }
    }

    public void n0(int i) {
        String str;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048619, this, i) == null) {
            if (this.B != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("MediaPlaySession internalAppFrontBackGround: ");
                if (i == 1) {
                    str = " front";
                } else {
                    str = "back";
                }
                sb.append(str);
                TLog.g(this, sb.toString());
                TransVodProxy transVodProxy = this.B;
                if (i != 1) {
                    z = true;
                } else {
                    z = false;
                }
                transVodProxy.a(z);
            }
            if (i == 1 && !this.G) {
                q6c.i();
            }
        }
    }

    public void h1(Context context, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, context, obj) == null) {
            TLog.g(this, "MediaPlaySession.onResume enter");
            synchronized (this.g) {
                w6c w6cVar = new w6c();
                this.q = w6cVar;
                w6cVar.x(this.I);
                TLog.g(this, "MediaPlaySession is for live : start");
                this.h = context.getApplicationContext();
                this.E.set(1);
                this.p = new p7c();
                u7c u7cVar = new u7c(context, obj, this.d, this.i.f, this.i.l, this.q);
                this.l = u7cVar;
                u7cVar.s(this.I);
                this.D.start();
                q6c.g(this.h, this);
            }
            TLog.g(this, "MediaPlaySession.onResume leave");
        }
    }

    public void k1(int i, g5c g5cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048616, this, i, g5cVar) == null) {
            synchronized (this.g) {
                if (this.E.get() == 9) {
                    TLog.c(this, this.d + "invalid state");
                }
                ArrayList<String> f = g5cVar.f();
                if (f == null || f.isEmpty()) {
                    TLog.c(this, this.d + "DataSource is empty");
                }
                TLog.g(this, "updatePcdnDataSource");
                Message obtain = Message.obtain();
                obtain.what = 1041;
                obtain.arg1 = i;
                Bundle bundle = new Bundle();
                String[] strArr = new String[f.size()];
                f.toArray(strArr);
                bundle.putStringArray("pcdnUrls", strArr);
                bundle.putString("pcdnManufacturer", g5cVar.e());
                obtain.setData(bundle);
                this.D.g(1041);
                this.D.sendMessage(obtain);
            }
        }
    }

    public void i1(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048612, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            this.a = i;
            this.p.l(System.currentTimeMillis());
            TLog.g(this, "MediaPlaySession start " + this.e);
            int i2 = this.E.get();
            TLog.g(this, this.d + "start state = " + i2 + " taskId=" + i);
            synchronized (this.g) {
                if (i2 != 2 && i2 != 1) {
                    TLog.g(this, this.d + "want to play but is playing source = " + this.r);
                    this.E.set(1);
                    this.D.g(1002);
                    this.D.f(1002);
                    TLog.g(this, this.d + "sendEmptyMessage(MEDIA_PIPELINE_STOP) source = " + this.r);
                    i2 = 1;
                }
                if (i2 != 2 && i2 != 3 && i2 != 4 && i2 != 1 && i2 != 8) {
                    TLog.l(this, this.d + "already playing? mCurrentState = " + l6c.a[i2]);
                }
                this.E.set(6);
                this.D.r(2);
                this.s = null;
                Message obtain = Message.obtain();
                obtain.what = 1001;
                obtain.arg1 = this.a;
                Bundle bundle = new Bundle();
                bundle.putLong("startTimeMs", j);
                obtain.setData(bundle);
                this.D.g(1001);
                this.D.sendMessage(obtain);
                TLog.l(this, this.d + "sendEmptyMessage(MEDIA_PIPELINE_PLAY) source = " + this.r + " taskId " + this.a);
            }
            TLog.g(this, "MediaPlaySession start " + this.f);
        }
    }

    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048614, this) == null) {
            TLog.g(this, "MediaPlaySession stop " + this.e);
            synchronized (this.g) {
                int i = this.E.get();
                if (i != 6 && i != 7 && i != 8 && i != 9 && i != 4 && i != 2 && i != 3) {
                    TLog.c(this, String.format(Locale.getDefault(), "want to stop,Illegal state ,mCurrentState = %s", l6c.a[i]));
                }
                this.E.set(1);
                this.D.g(1002);
                this.D.f(1002);
                TLog.g(this, this.d + "stop source = " + this.r);
            }
            TLog.g(this, "MediaPlaySession stop " + this.f);
        }
    }

    public final void u0(int i, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048626, this, new Object[]{Integer.valueOf(i), Long.valueOf(j)}) == null) {
            TLog.g(this, "MediaPlaySession internalPlay" + this.e);
            synchronized (this.g) {
                this.k.h(i);
                this.j.h(i);
                boolean z = false;
                if (this.n == null) {
                    x7c x7cVar = new x7c(this.d, this.q);
                    if (this.i.b == 1 && d6c.c()) {
                        x7cVar.z(true);
                    } else {
                        x7cVar.z(false);
                    }
                    if (this.i.c == 1 && d6c.d()) {
                        x7cVar.A(true);
                    } else {
                        x7cVar.A(false);
                    }
                    x7cVar.B(((u7c) this.l).J(), this.i.h, this.i.i);
                    this.n = x7cVar;
                }
                this.n.r(this.r);
                this.n.s(this.I);
                this.n.h(i);
                if (this.o == null) {
                    if (this.i.d == 1) {
                        this.o = new k7c(this.d);
                    } else {
                        this.o = new l7c(this.d, this.q);
                    }
                }
                this.o.r(this.r);
                this.o.s(this.I);
                this.o.e(true);
                this.o.h(i);
                this.l.h(i);
                this.m.h(i);
                this.p.k(this.D.k(), this.B, this.h);
                p7c p7cVar = this.p;
                p7cVar.a(0, this.j);
                p7cVar.a(0, this.n);
                p7cVar.a(0, this.l);
                p7c p7cVar2 = this.p;
                p7cVar2.a(1, this.k);
                p7cVar2.a(1, this.o);
                p7cVar2.a(1, this.m);
                this.p.c();
                this.p.m();
                StringBuilder sb = new StringBuilder();
                sb.append("MediaPlaySession mCurrnetDataSource:");
                if (this.t != null) {
                    z = true;
                }
                sb.append(z);
                TLog.g(this, sb.toString());
                if (this.t != null) {
                    this.B.j(this.r, this.u, this.v, this.w, i, this.y, this.z, j, this.t.g());
                }
                if (this.y) {
                    this.q.E(i);
                    TLog.g(this, "MediaPlaySession is for live : start");
                }
                TLog.g(this, "MediaPlaySession internalPlay" + this.r + " protocal " + this.u + " fastAccess " + this.z);
                if (!this.G) {
                    q6c.i();
                }
            }
            TLog.g(this, "MediaPlaySession internalPlay" + this.f);
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            y6c y6cVar = this.C;
            if (y6cVar != null) {
                y6cVar.g();
            } else {
                TLog.h(this.c, "mTransVodProxy is invalid, no need to release.");
            }
            HandlerThread handlerThread = new HandlerThread("release");
            handlerThread.setPriority(m6c.n(-2));
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.A = handler;
            handler.post(new d(this));
        }
    }
}
