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
public class xa5 extends va5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public xa5() {
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

    public void b(ta5 ta5Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ta5Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            xg a = va5.a();
            a.b("action", "time");
            a.b("ishttp", ta5Var.s ? "1" : "0");
            a.b("issuccess", ta5Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("wt", String.valueOf(ta5Var.p));
            a.b("qt", String.valueOf(ta5Var.f));
            a.b("connt", String.valueOf(ta5Var.g));
            a.b("rwt", String.valueOf(ta5Var.h));
            a.b("fbt", String.valueOf(ta5Var.i));
            a.b("abt", String.valueOf(ta5Var.j));
            a.b("dect", String.valueOf(ta5Var.k));
            a.b("parset", String.valueOf(ta5Var.l));
            a.b("tqt", String.valueOf(ta5Var.n));
            a.b("rendert", String.valueOf(ta5Var.o));
            a.b("ss", String.valueOf(ta5Var.q));
            a.b("hs", String.valueOf(ta5Var.r));
            if (ta5Var.s && (i = ta5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = ta5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            if (ta5Var.s) {
                a.b("hrtn", String.valueOf(ta5Var.w));
                a.b("hrtt", String.valueOf(ta5Var.x));
            }
            int i2 = ta5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (ta5Var.y) {
                a.b(Config.PLATFORM_TYPE, "1");
            } else {
                a.b("sysct", String.valueOf(ta5Var.c));
                a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(ta5Var.e));
                a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(ta5Var.d));
                a.b("df", String.valueOf(ta5Var.m));
            }
            if (ta5Var.s) {
                a.b("c_logid", String.valueOf(ta5Var.A));
                long j2 = ta5Var.z;
                if (j2 != 0) {
                    a.b("seq_id", String.valueOf(j2 & 4294967295L));
                }
            } else {
                a.b("seq_id", String.valueOf(ta5Var.z & 4294967295L));
            }
            HashMap<String, String> hashMap = ta5Var.E;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : ta5Var.E.entrySet()) {
                    a.b(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void c(ta5 ta5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ta5Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && ta5Var.D > 0) {
            xg a = va5.a();
            a.b("action", "time");
            a.b("pct", String.valueOf(ta5Var.D));
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

    public void d(ta5 ta5Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, ta5Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || ta5Var.B > 0) {
                if (z || ta5Var.C > 0) {
                    xg a = va5.a();
                    a.b("action", "time");
                    if (z) {
                        a.b("put", String.valueOf(ta5Var.B));
                    } else {
                        a.b("pdt", String.valueOf(ta5Var.C));
                    }
                    a.b("ishttp", ta5Var.s ? "1" : "0");
                    a.b("issuccess", ta5Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(ta5Var.f));
                    a.b("connt", String.valueOf(ta5Var.g));
                    a.b("rwt", String.valueOf(ta5Var.h));
                    a.b("dect", String.valueOf(ta5Var.k));
                    a.b("parset", String.valueOf(ta5Var.l));
                    a.b("rendert", String.valueOf(ta5Var.o));
                    a.b("ss", String.valueOf(ta5Var.q));
                    a.b("hs", String.valueOf(ta5Var.r));
                    if (ta5Var.s && (i = ta5Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = ta5Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = ta5Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public void e(na5 na5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, na5Var) == null) && na5Var != null && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            xg a = va5.a();
            a.b("action", FpsTracer.UBC_KEY_FLUENCY);
            a.b(FpsConstants.REPORT_FPS, String.valueOf(na5Var.b()));
            BdStatisticsManager.getInstance().performance(this.a, a);
            xg a2 = va5.a();
            a2.b("action", "mem");
            a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
            BdStatisticsManager.getInstance().performance(this.a, a2);
        }
    }
}
