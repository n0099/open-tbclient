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
import com.baidu.tieba.hgb;
import com.baidu.tieba.tgb;
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
public class wgb extends yhb implements tgb.b {
    public static /* synthetic */ Interceptable $ic = null;
    public static String L = "os";
    public static String M = "osversion";
    public static String N = "version";
    public static String O = "model";
    public transient /* synthetic */ FieldHolder $fh;
    public Handler A;
    public TransVodProxy B;
    public bhb C;
    public pgb D;
    public AtomicInteger E;
    public boolean F;
    public boolean G;
    public WeakReference<e> H;
    public vgb I;
    public final TransVodProxy.a J;
    public final hgb.a K;
    public final String c;
    public final int d;
    public String e;
    public String f;
    public final Object g;
    public Context h;
    public dgb i;
    public thb j;
    public thb k;
    public thb l;
    public thb m;
    public thb n;
    public thb o;
    public shb p;
    public zgb q;
    public String r;
    public String s;
    public jfb t;
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
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948271031, "Lcom/baidu/tieba/wgb;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948271031, "Lcom/baidu/tieba/wgb;");
        }
    }

    public final void q0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048622, this) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public class a implements vgb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wgb a;

        public a(wgb wgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wgbVar;
        }

        @Override // com.baidu.tieba.vgb
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
                            ((xhb) this.a.l).L();
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
        public final /* synthetic */ wgb a;

        public b(wgb wgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wgbVar;
        }
    }

    /* loaded from: classes8.dex */
    public class c implements hgb.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wgb a;

        @Override // com.baidu.tieba.hgb.a
        public void onStop() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            }
        }

        public c(wgb wgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wgbVar;
        }

        @Override // com.baidu.tieba.hgb.a
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
                                                        wgb wgbVar = this.a;
                                                        if (message.arg1 == 1) {
                                                            z = true;
                                                        }
                                                        wgbVar.r0(z);
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
                                    mgb mgbVar = (mgb) message.obj;
                                    this.a.y0((Executor) mgbVar.a, mgbVar.b);
                                    return;
                                }
                                this.a.D0((sgb) message.obj);
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

        @Override // com.baidu.tieba.hgb.a
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

        @Override // com.baidu.tieba.hgb.a
        public void onResume() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                this.a.G = false;
                String str = this.a.c;
                TLog.h(str, "MediaPlaySession.onResume " + this.a.e);
                if (this.a.B != null) {
                    this.a.B.n();
                }
                tgb.i();
                String str2 = this.a.c;
                TLog.h(str2, "MediaPlaySession.onResume " + this.a.f);
            }
        }

        @Override // com.baidu.tieba.hgb.a
        public void onStart() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                String str = this.a.c;
                TLog.h(str, "MediaPlaySession.onStart " + this.a.e);
                this.a.C = new bhb(this.a.h, this.a.i);
                wgb wgbVar = this.a;
                wgbVar.B = wgbVar.C.d(this.a.d, this.a.i);
                this.a.B.k(this.a.J);
                this.a.B.t(this.a.I);
                wgb wgbVar2 = this.a;
                wgbVar2.j = new uhb(wgbVar2.d);
                wgb wgbVar3 = this.a;
                wgbVar3.k = new uhb(wgbVar3.d);
                this.a.m = new phb(this.a.d);
                String str2 = this.a.c;
                TLog.h(str2, "MediaPlaySession.onStart " + this.a.f);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ wgb a;

        public d(wgb wgbVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {wgbVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = wgbVar;
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
                    tgb.k(this.a);
                }
                kgb.f().d();
                TLog.g(this, "release thread: end");
                if (this.a.A != null) {
                    this.a.A.getLooper().quit();
                }
            }
        }
    }

    public wgb(dgb dgbVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dgbVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = wgb.class.getSimpleName();
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
        this.D = new pgb(String.valueOf(this.d));
        this.E = new AtomicInteger(1);
        this.G = false;
        this.H = new WeakReference<>(null);
        this.I = new a(this);
        this.J = new b(this);
        this.K = new c(this);
        this.i = dgbVar;
        this.D.setName("VOD MediaPlaySession");
        this.b = this.d;
        this.D.b(this.K);
    }

    public void V0(jfb jfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, jfbVar) == null) {
            TLog.g(this, "setDataSourceAndPrepare");
            if (this.E.get() == 9) {
                TLog.c(this, this.d + "invalid state");
            }
            if (jfbVar.k() == null || jfbVar.k().isEmpty()) {
                TLog.c(this, this.d + "DataSource is empty");
            }
            this.E.set(2);
            jfbVar.o(L, "Android");
            jfbVar.o(M, Build.VERSION.RELEASE);
            jfbVar.o(N, "12.1.0.24");
            jfbVar.o(O, Build.MODEL);
            this.r = jfbVar.k();
            this.t = jfbVar;
            this.u = jfbVar.l();
            this.v = jfbVar.h();
            this.w = jfbVar.b();
            this.y = jfbVar.d();
            this.z = jfbVar.c();
            this.a = (int) jfbVar.j();
            this.x = jfbVar.i();
            synchronized (this.g) {
                Message obtain = Message.obtain();
                obtain.arg1 = this.a;
                obtain.what = 1043;
                this.D.g(1043);
                this.D.sendMessage(obtain);
            }
        }
    }

    public final void D0(sgb sgbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sgbVar) == null) {
            TLog.g(this, "MediaPlaySession internalSetEffectResources");
            ((xhb) this.l).S(sgbVar);
        }
    }

    public void W0(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048598, this, i) == null) {
            ((xhb) this.l).R(i);
        }
    }

    public void X0(sgb sgbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, sgbVar) == null) {
            TLog.g(this, "MediaPlaySession setEffectResources");
            synchronized (this.g) {
                Message obtain = Message.obtain();
                obtain.what = ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE;
                obtain.obj = sgbVar;
                this.D.g(ARPMessageType.MSG_TYPE_VIDEO_PLAY_INFO_UPDATE);
                this.D.sendMessage(obtain);
            }
        }
    }

    public void Y0(boolean z) {
        xhb xhbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048600, this, z) == null) && (xhbVar = (xhb) this.l) != null) {
            xhbVar.T(z);
        }
    }

    public void Z0(boolean z) {
        xhb xhbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048601, this, z) == null) && (xhbVar = (xhb) this.l) != null) {
            xhbVar.U(z);
        }
    }

    public void a1(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            ((xhb) this.l).V(z);
        }
    }

    @Override // com.baidu.tieba.tgb.b
    public void c(boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048604, this, z) == null) {
            synchronized (this.g) {
                this.D.g(1020);
                pgb pgbVar = this.D;
                if (z) {
                    i = 1;
                } else {
                    i = 0;
                }
                pgbVar.sendMessage(Message.obtain(null, 1020, i, 0));
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
            ((xhb) this.l).W(i);
        }
    }

    public void e1(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048607, this, i) == null) {
            ((xhb) this.l).X(i);
        }
    }

    public void f1(boolean z) {
        shb shbVar;
        chb h;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeZ(1048608, this, z) != null) || (shbVar = this.p) == null || (h = shbVar.h()) == null) {
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

    public void k0(igb igbVar) {
        chb h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048615, this, igbVar) == null) {
            ((xhb) this.l).I(igbVar);
            shb shbVar = this.p;
            if (shbVar != null && (h = shbVar.h()) != null) {
                h.k(igbVar.a);
            }
        }
    }

    public final void o0(int i) {
        thb thbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048620, this, i) == null) && (thbVar = this.m) != null) {
            thbVar.u(i);
        }
    }

    public final void y0(Executor executor, Object obj) {
        thb thbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048630, this, executor, obj) == null) && (thbVar = this.l) != null) {
            ((xhb) thbVar).P(executor, obj);
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
            thb thbVar = this.l;
            if (thbVar != null) {
                thbVar.o();
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
            jfb jfbVar = this.t;
            if (jfbVar != null) {
                this.B.s(this.r, this.u, this.v, this.w, i, this.y, this.z, this.x, jfbVar.g());
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
                    TLog.c(this, String.format(Locale.getDefault(), "want to seekTo,Illegal state ,mCurrentState = %s", ogb.a[i]));
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
                thb thbVar = this.l;
                if (thbVar != null) {
                    ((xhb) thbVar).G();
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
        thb thbVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && (thbVar = this.o) != null) {
            thbVar.e(true);
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
        chb h;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            ((xhb) this.l).H();
            shb shbVar = this.p;
            if (shbVar != null && (h = shbVar.h()) != null) {
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
            thb thbVar = this.m;
            if (thbVar != null) {
                ((phb) thbVar).F(this.a);
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
            thb thbVar = this.l;
            if (thbVar != null) {
                ((xhb) thbVar).M(this.a);
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
            thb thbVar = this.m;
            if (thbVar != null) {
                ((phb) thbVar).H(this.a);
            }
            TransVodProxy transVodProxy = this.B;
            if (transVodProxy != null) {
                transVodProxy.o(false);
            }
            tgb.i();
        }
    }

    public final void x0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048629, this) == null) {
            thb thbVar = this.l;
            if (thbVar != null) {
                ((xhb) thbVar).Q(this.a);
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
                mgb mgbVar = new mgb(executor, obj);
                this.D.g(ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE);
                this.D.sendMessage(Message.obtain(null, ErrorConstant.Code.DOWNLOAD_ERROR_CREATEFILE, mgbVar));
            }
            TLog.g(this, "MediaPlaySession screenShot " + this.f);
        }
    }

    public void U0(jfb jfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, jfbVar) == null) {
            TLog.g(this, "setDataSource");
            if (this.E.get() == 9) {
                TLog.c(this, this.d + "invalid state");
            }
            if (jfbVar.k() == null || jfbVar.k().isEmpty()) {
                TLog.c(this, this.d + "DataSource is empty");
            }
            jfbVar.o(L, "Android");
            jfbVar.o(M, Build.VERSION.RELEASE);
            jfbVar.o(N, "12.1.0.24");
            jfbVar.o(O, Build.MODEL);
            this.r = jfbVar.k();
            this.t = jfbVar;
            this.u = jfbVar.l();
            this.v = jfbVar.h();
            this.w = jfbVar.b();
            this.y = jfbVar.d();
            this.z = jfbVar.c();
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
                tgb.i();
            }
        }
    }

    public void h1(Context context, Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048611, this, context, obj) == null) {
            TLog.g(this, "MediaPlaySession.onResume enter");
            synchronized (this.g) {
                zgb zgbVar = new zgb();
                this.q = zgbVar;
                zgbVar.x(this.I);
                TLog.g(this, "MediaPlaySession is for live : start");
                this.h = context.getApplicationContext();
                this.E.set(1);
                this.p = new shb();
                xhb xhbVar = new xhb(context, obj, this.d, this.i.f, this.i.l, this.q);
                this.l = xhbVar;
                xhbVar.s(this.I);
                this.D.start();
                tgb.g(this.h, this);
            }
            TLog.g(this, "MediaPlaySession.onResume leave");
        }
    }

    public void k1(int i, jfb jfbVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048616, this, i, jfbVar) == null) {
            synchronized (this.g) {
                if (this.E.get() == 9) {
                    TLog.c(this, this.d + "invalid state");
                }
                ArrayList<String> f = jfbVar.f();
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
                bundle.putString("pcdnManufacturer", jfbVar.e());
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
                    TLog.l(this, this.d + "already playing? mCurrentState = " + ogb.a[i2]);
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
                if (i != 6 && i != 7 && i != 8 && i != 9 && i != 4) {
                    TLog.c(this, String.format(Locale.getDefault(), "want to stop,Illegal state ,mCurrentState = %s", ogb.a[i]));
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
                    aib aibVar = new aib(this.d, this.q);
                    if (this.i.b == 1 && ggb.c()) {
                        aibVar.z(true);
                    } else {
                        aibVar.z(false);
                    }
                    if (this.i.c == 1 && ggb.d()) {
                        aibVar.A(true);
                    } else {
                        aibVar.A(false);
                    }
                    aibVar.B(((xhb) this.l).J(), this.i.h, this.i.i);
                    this.n = aibVar;
                }
                this.n.r(this.r);
                this.n.s(this.I);
                this.n.h(i);
                if (this.o == null) {
                    if (this.i.d == 1) {
                        this.o = new nhb(this.d);
                    } else {
                        this.o = new ohb(this.d, this.q);
                    }
                }
                this.o.r(this.r);
                this.o.s(this.I);
                this.o.e(true);
                this.o.h(i);
                this.l.h(i);
                this.m.h(i);
                this.p.k(this.D.k(), this.B, this.h);
                shb shbVar = this.p;
                shbVar.a(0, this.j);
                shbVar.a(0, this.n);
                shbVar.a(0, this.l);
                shb shbVar2 = this.p;
                shbVar2.a(1, this.k);
                shbVar2.a(1, this.o);
                shbVar2.a(1, this.m);
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
                    tgb.i();
                }
            }
            TLog.g(this, "MediaPlaySession internalPlay" + this.f);
        }
    }

    public final void v0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048627, this) == null) {
            bhb bhbVar = this.C;
            if (bhbVar != null) {
                bhbVar.g();
            } else {
                TLog.h(this.c, "mTransVodProxy is invalid, no need to release.");
            }
            HandlerThread handlerThread = new HandlerThread("release");
            handlerThread.setPriority(pgb.n(-2));
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            this.A = handler;
            handler.post(new d(this));
        }
    }
}
