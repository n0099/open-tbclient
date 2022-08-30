package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class za5 extends xa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public za5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public void b(va5 va5Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, va5Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            xg a = xa5.a();
            a.b("action", "time");
            a.b("ishttp", va5Var.s ? "1" : "0");
            a.b("issuccess", va5Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("wt", String.valueOf(va5Var.p));
            a.b("qt", String.valueOf(va5Var.f));
            a.b("connt", String.valueOf(va5Var.g));
            a.b("rwt", String.valueOf(va5Var.h));
            a.b("fbt", String.valueOf(va5Var.i));
            a.b("abt", String.valueOf(va5Var.j));
            a.b("dect", String.valueOf(va5Var.k));
            a.b("parset", String.valueOf(va5Var.l));
            a.b("tqt", String.valueOf(va5Var.n));
            a.b("rendert", String.valueOf(va5Var.o));
            a.b("ss", String.valueOf(va5Var.q));
            a.b("hs", String.valueOf(va5Var.r));
            if (va5Var.s && (i = va5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = va5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            if (va5Var.s) {
                a.b("hrtn", String.valueOf(va5Var.w));
                a.b("hrtt", String.valueOf(va5Var.x));
            }
            int i2 = va5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (va5Var.y) {
                a.b(Config.PLATFORM_TYPE, "1");
            } else {
                a.b("sysct", String.valueOf(va5Var.c));
                a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(va5Var.e));
                a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(va5Var.d));
                a.b("df", String.valueOf(va5Var.m));
            }
            if (va5Var.s) {
                a.b("c_logid", String.valueOf(va5Var.A));
                long j2 = va5Var.z;
                if (j2 != 0) {
                    a.b("seq_id", String.valueOf(j2 & 4294967295L));
                }
            } else {
                a.b("seq_id", String.valueOf(va5Var.z & 4294967295L));
            }
            HashMap<String, String> hashMap = va5Var.E;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : va5Var.E.entrySet()) {
                    a.b(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void c(va5 va5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, va5Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && va5Var.D > 0) {
            xg a = xa5.a();
            a.b("action", "time");
            a.b("pct", String.valueOf(va5Var.D));
            if (i == 0) {
                a.b("pct_type", String.valueOf(100));
            } else if (i != 40) {
                return;
            } else {
                a.b("pct_type", String.valueOf(101));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void d(va5 va5Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, va5Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || va5Var.B > 0) {
                if (z || va5Var.C > 0) {
                    xg a = xa5.a();
                    a.b("action", "time");
                    if (z) {
                        a.b("put", String.valueOf(va5Var.B));
                    } else {
                        a.b("pdt", String.valueOf(va5Var.C));
                    }
                    a.b("ishttp", va5Var.s ? "1" : "0");
                    a.b("issuccess", va5Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(va5Var.f));
                    a.b("connt", String.valueOf(va5Var.g));
                    a.b("rwt", String.valueOf(va5Var.h));
                    a.b("dect", String.valueOf(va5Var.k));
                    a.b("parset", String.valueOf(va5Var.l));
                    a.b("rendert", String.valueOf(va5Var.o));
                    a.b("ss", String.valueOf(va5Var.q));
                    a.b("hs", String.valueOf(va5Var.r));
                    if (va5Var.s && (i = va5Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = va5Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = va5Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public void e(pa5 pa5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, pa5Var) == null) && pa5Var != null && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            xg a = xa5.a();
            a.b("action", FpsTracer.UBC_KEY_FLUENCY);
            a.b(FpsConstants.REPORT_FPS, String.valueOf(pa5Var.b()));
            BdStatisticsManager.getInstance().performance(this.a, a);
            xg a2 = xa5.a();
            a2.b("action", "mem");
            a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
            BdStatisticsManager.getInstance().performance(this.a, a2);
        }
    }
}
