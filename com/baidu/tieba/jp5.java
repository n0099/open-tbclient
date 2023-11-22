package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.launch.stats.SpeedStatsMainTable;
import com.baidu.tbadk.performanceLog.PerformanceLogger;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class jp5 extends PerformanceLogger {
    public static /* synthetic */ Interceptable $ic;
    public static jp5 D;
    public transient /* synthetic */ FieldHolder $fh;
    public long A;
    public long B;
    public long C;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long n;
    public long o;
    public long p;
    public long q;
    public long r;
    public long s;
    public long t;
    public long u;
    public long v;
    public long w;
    public long x;
    public long y;
    public long z;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947891002, "Lcom/baidu/tieba/jp5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947891002, "Lcom/baidu/tieba/jp5;");
        }
    }

    public void A(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
        }
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048590, this, j) == null) {
        }
    }

    public void o(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
        }
    }

    public jp5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
        this.e = -1L;
        this.f = -1L;
        this.g = -1L;
        this.h = -1L;
        this.i = -1L;
        this.j = -1L;
        this.k = -1L;
        this.l = -1L;
        this.m = -1L;
        this.n = -1L;
        this.o = -1L;
        this.p = -1L;
        this.q = -1L;
        this.r = -1L;
        this.s = -1L;
        this.t = -1L;
        this.u = -1L;
        this.v = -1L;
        this.w = -1L;
        this.x = -1L;
        this.y = -1L;
        this.z = -1L;
        this.A = -1L;
        this.B = -1L;
        this.C = -1L;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.a = false;
            this.b = false;
            this.e = -1L;
            this.f = -1L;
            this.v = -1L;
            this.g = -1L;
            this.h = -1L;
            this.i = -1L;
            this.A = -1L;
            this.s = -1L;
            this.t = -1L;
            this.q = -1L;
            this.B = -1L;
            this.C = -1L;
            this.j = -1L;
            this.k = -1L;
            this.l = -1L;
            this.m = -1L;
            this.n = -1L;
            this.o = -1L;
            this.p = -1L;
            this.r = -1L;
            this.u = -1L;
            this.w = -1L;
            this.x = -1L;
            this.y = -1L;
            this.z = -1L;
        }
    }

    public static jp5 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (D == null) {
                synchronized (jp5.class) {
                    if (D == null) {
                        D = new jp5();
                    }
                }
            }
            return D;
        }
        return (jp5) invokeV.objValue;
    }

    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.e;
        }
        return invokeV.longValue;
    }

    public long c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.v;
        }
        return invokeV.longValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public void B(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j) == null) {
            this.x = j;
        }
    }

    public void C(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) != null) || this.y > 0) {
            return;
        }
        this.y = j;
    }

    public void D(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.z = j;
        }
    }

    public void E(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048580, this, j) == null) {
            this.f = j;
        }
    }

    public void F(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j) == null) {
            this.n = j;
        }
    }

    public void G(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048582, this, j) == null) {
            this.m = j;
        }
    }

    public void H(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048583, this, j) == null) {
            this.w = j;
        }
    }

    public void i(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048591, this, j) == null) {
            this.q = j;
        }
    }

    public void j(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048592, this, j) == null) {
            this.r = j;
        }
    }

    public void k(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048593, this, j) == null) {
            this.t = j;
        }
    }

    public void l(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048594, this, j) == null) {
            this.s = j;
        }
    }

    public void m(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048595, this, j) == null) {
            this.o = j;
        }
    }

    public void n(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeJ(1048596, this, j) != null) || this.u > 0) {
            return;
        }
        this.u = j;
        this.v = System.currentTimeMillis() - this.e;
    }

    public void p(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048598, this, j) == null) {
            this.j = j;
        }
    }

    public void q(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048599, this, j) == null) {
            this.l = j;
        }
    }

    public void r(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048600, this, j) == null) {
            this.k = j;
        }
    }

    public void s(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048601, this, j) == null) {
            this.e = j;
        }
    }

    public void t(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048602, this, j) == null) {
            this.g = j;
        }
    }

    public void u(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048603, this, j) == null) {
            this.A = j;
        }
    }

    public void v(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048604, this, j) == null) {
            this.B = j;
        }
    }

    public void w(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048605, this, j) == null) {
            this.C = j;
            this.b = true;
        }
    }

    public void x(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048606, this, j) == null) {
            this.p = j;
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.a = z;
        }
    }

    public void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048608, this, j) == null) {
            this.h = j;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            long j = 0;
            if (this.C - this.e <= 0 || this.c || this.u <= 0 || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
                return;
            }
            long j2 = this.f - this.e;
            long j3 = -1;
            long j4 = this.s;
            if (j4 > 0) {
                j3 = this.t - j4;
            }
            this.c = true;
            long j5 = this.C - this.B;
            BdStatsItem logItem = PerformanceLogger.getLogItem();
            logItem.append("procname", "main");
            logItem.append("appc", String.valueOf(j2));
            logItem.append("loadclass", String.valueOf(this.g));
            logItem.append("sapiinit", String.valueOf(this.h));
            logItem.append("acctinit", String.valueOf(this.z));
            logItem.append("iminit", String.valueOf(this.x));
            logItem.append("plugininit", String.valueOf(this.y));
            logItem.append("patchloaded", String.valueOf(this.i));
            logItem.append("naslibinit", String.valueOf(this.j));
            logItem.append("websocketinit", String.valueOf(this.k));
            logItem.append("settinginit", String.valueOf(this.l));
            logItem.append("toastinit", String.valueOf(this.m));
            logItem.append("tiebastaticinit", String.valueOf(this.n));
            logItem.append("cdninit", String.valueOf(this.o));
            logItem.append("messagesetinit", String.valueOf(this.p));
            logItem.append("logores", String.valueOf(this.A));
            logItem.append("opttest", String.valueOf(1));
            long j6 = this.q;
            String str = "1";
            if (j6 > 0 && this.s > 0 && j3 > 0) {
                logItem.append("adc", String.valueOf(j6 + this.r));
                logItem.append(SpeedStatsMainTable.AD_SHOW, String.valueOf(j3));
                logItem.append("adrequest", String.valueOf(this.r));
                j = this.q + this.r + j3;
                logItem.append("hasad", "1");
            } else {
                logItem.append("hasad", "0");
                long j7 = this.r;
                if (j7 > 0) {
                    j = j7;
                }
            }
            logItem.append("tabc", String.valueOf(j5));
            logItem.append("costt", String.valueOf(this.v - j));
            if (!this.a) {
                str = "0";
            }
            logItem.append("newinst", str);
            logItem.append("pluginloadsync", Boolean.valueOf(this.d));
            logItem.append("hptotal", String.valueOf(this.u));
            logItem.append("locationinit", String.valueOf(j2 + this.A + this.q + j3 + this.r + j5 + this.u));
            logItem.append("userperceptiont", String.valueOf(this.w - j));
            BdStatisticsManager.getInstance().performance("startt", logItem);
            g();
        }
    }

    public void f(long j) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeJ(1048588, this, j) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && j > 0) {
            BdStatsItem logItem = PerformanceLogger.getLogItem();
            logItem.append("procname", com.baidu.mobads.sdk.internal.cl.b);
            logItem.append("costt", String.valueOf(j));
            BdStatisticsManager.getInstance().performance("startt", logItem);
        }
    }
}
