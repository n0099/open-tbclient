package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
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
public class ip5 extends PerformanceLogger {
    public static /* synthetic */ Interceptable $ic = null;
    public static int a = 100;
    public static int b = 10;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947861211, "Lcom/baidu/tieba/ip5;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947861211, "Lcom/baidu/tieba/ip5;");
        }
    }

    /* loaded from: classes6.dex */
    public static class a {
        public static /* synthetic */ Interceptable $ic;
        public static int a;
        public static int b;
        public static int c;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                BdStatsItem logItem = PerformanceLogger.getLogItem();
                logItem.append("action", "imbusy");
                logItem.append("totalNum", String.valueOf(a));
                logItem.append("tfailNum", String.valueOf(b));
                logItem.append("qfailNum", String.valueOf(c));
                BdStatisticsManager.getInstance().performance("im", logItem);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                b = 0;
                c = 0;
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static int a;
        public static long b;
        public static long c;
        public static long d;
        public static int e;
        public static int f;
        public static long g;
        public transient /* synthetic */ FieldHolder $fh;

        public static void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65536, null) == null) {
                BdStatsItem logItem = PerformanceLogger.getLogItem();
                logItem.append("action", "imcost");
                logItem.append("dect", String.valueOf(b));
                logItem.append("dlsize", String.valueOf(c));
                logItem.append("dbt", String.valueOf(d));
                logItem.append("pnum", String.valueOf(e));
                logItem.append("reqcost", String.valueOf(g));
                logItem.append("cpu", String.valueOf(f));
                logItem.append("totalNum", String.valueOf(a));
                BdStatisticsManager.getInstance().performance("im", logItem);
                b();
            }
        }

        public static void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(65537, null) == null) {
                a = 0;
                b = 0L;
                c = 0L;
                d = 0L;
                e = 0;
                f = 0;
            }
        }
    }

    public ip5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65539, null) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (b.a > b) {
            b.a();
        }
        if (a.a > b) {
            a.a();
        }
    }

    public static void a(boolean z, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            a.a++;
            if (z2) {
                a.b++;
            } else if (z3) {
                a.c++;
            }
            if (a.a > a) {
                a.a();
            }
        }
    }

    public void b(fp5 fp5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, fp5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (b.a < a) {
            b.b += fp5Var.b;
            b.c += fp5Var.c;
            b.d += fp5Var.d;
            b.e += fp5Var.e;
            b.g += fp5Var.f;
            b.f += fp5Var.g;
            b.a++;
            return;
        }
        b.a();
    }
}
