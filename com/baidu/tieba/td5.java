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
/* loaded from: classes5.dex */
public class td5 extends rd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public td5() {
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

    public void b(pd5 pd5Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, pd5Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            lh a = rd5.a();
            a.b("action", "time");
            a.b("ishttp", pd5Var.s ? "1" : "0");
            a.b("issuccess", pd5Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("wt", String.valueOf(pd5Var.p));
            a.b("qt", String.valueOf(pd5Var.f));
            a.b("connt", String.valueOf(pd5Var.g));
            a.b("rwt", String.valueOf(pd5Var.h));
            a.b("fbt", String.valueOf(pd5Var.i));
            a.b("abt", String.valueOf(pd5Var.j));
            a.b("dect", String.valueOf(pd5Var.k));
            a.b("parset", String.valueOf(pd5Var.l));
            a.b("tqt", String.valueOf(pd5Var.n));
            a.b("rendert", String.valueOf(pd5Var.o));
            a.b("ss", String.valueOf(pd5Var.q));
            a.b("hs", String.valueOf(pd5Var.r));
            if (pd5Var.s && (i = pd5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = pd5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            if (pd5Var.s) {
                a.b("hrtn", String.valueOf(pd5Var.w));
                a.b("hrtt", String.valueOf(pd5Var.x));
            }
            int i2 = pd5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (pd5Var.y) {
                a.b(Config.PLATFORM_TYPE, "1");
            } else {
                a.b("sysct", String.valueOf(pd5Var.c));
                a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(pd5Var.e));
                a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(pd5Var.d));
                a.b("df", String.valueOf(pd5Var.m));
            }
            if (pd5Var.s) {
                a.b("c_logid", String.valueOf(pd5Var.A));
                long j2 = pd5Var.z;
                if (j2 != 0) {
                    a.b("seq_id", String.valueOf(j2 & 4294967295L));
                }
            } else {
                a.b("seq_id", String.valueOf(pd5Var.z & 4294967295L));
            }
            HashMap<String, String> hashMap = pd5Var.E;
            if (hashMap != null && !hashMap.isEmpty()) {
                for (Map.Entry<String, String> entry : pd5Var.E.entrySet()) {
                    a.b(entry.getKey(), entry.getValue());
                }
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void c(pd5 pd5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pd5Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && pd5Var.D > 0) {
            lh a = rd5.a();
            a.b("action", "time");
            a.b("pct", String.valueOf(pd5Var.D));
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

    public void d(pd5 pd5Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, pd5Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || pd5Var.B > 0) {
                if (z || pd5Var.C > 0) {
                    lh a = rd5.a();
                    a.b("action", "time");
                    if (z) {
                        a.b("put", String.valueOf(pd5Var.B));
                    } else {
                        a.b("pdt", String.valueOf(pd5Var.C));
                    }
                    a.b("ishttp", pd5Var.s ? "1" : "0");
                    a.b("issuccess", pd5Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(pd5Var.f));
                    a.b("connt", String.valueOf(pd5Var.g));
                    a.b("rwt", String.valueOf(pd5Var.h));
                    a.b("dect", String.valueOf(pd5Var.k));
                    a.b("parset", String.valueOf(pd5Var.l));
                    a.b("rendert", String.valueOf(pd5Var.o));
                    a.b("ss", String.valueOf(pd5Var.q));
                    a.b("hs", String.valueOf(pd5Var.r));
                    if (pd5Var.s && (i = pd5Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = pd5Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = pd5Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public void e(jd5 jd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, jd5Var) == null) && jd5Var != null && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            lh a = rd5.a();
            a.b("action", FpsTracer.UBC_KEY_FLUENCY);
            a.b(FpsConstants.REPORT_FPS, String.valueOf(jd5Var.b()));
            BdStatisticsManager.getInstance().performance(this.a, a);
            lh a2 = rd5.a();
            a2.b("action", "mem");
            a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
            BdStatisticsManager.getInstance().performance(this.a, a2);
        }
    }
}
