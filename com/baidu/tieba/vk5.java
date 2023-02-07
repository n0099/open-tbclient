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
public class vk5 extends tk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vk5() {
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

    public void b(rk5 rk5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, rk5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        lh a = tk5.a();
        a.b("action", "time");
        String str2 = "0";
        if (!rk5Var.s) {
            str = "0";
        } else {
            str = "1";
        }
        a.b("ishttp", str);
        if (rk5Var.b) {
            str2 = "1";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b("wt", String.valueOf(rk5Var.p));
        a.b("qt", String.valueOf(rk5Var.f));
        a.b("connt", String.valueOf(rk5Var.g));
        a.b("rwt", String.valueOf(rk5Var.h));
        a.b("fbt", String.valueOf(rk5Var.i));
        a.b("abt", String.valueOf(rk5Var.j));
        a.b("dect", String.valueOf(rk5Var.k));
        a.b("parset", String.valueOf(rk5Var.l));
        a.b("tqt", String.valueOf(rk5Var.n));
        a.b("rendert", String.valueOf(rk5Var.o));
        a.b("ss", String.valueOf(rk5Var.q));
        a.b("hs", String.valueOf(rk5Var.r));
        if (rk5Var.s && (i = rk5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = rk5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        if (rk5Var.s) {
            a.b("hrtn", String.valueOf(rk5Var.w));
            a.b("hrtt", String.valueOf(rk5Var.x));
        }
        int i2 = rk5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (rk5Var.y) {
            a.b(Config.PLATFORM_TYPE, "1");
        } else {
            a.b("sysct", String.valueOf(rk5Var.c));
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(rk5Var.e));
            a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(rk5Var.d));
            a.b("df", String.valueOf(rk5Var.m));
        }
        if (rk5Var.s) {
            a.b("c_logid", String.valueOf(rk5Var.A));
            long j2 = rk5Var.z;
            if (j2 != 0) {
                a.b("seq_id", String.valueOf(j2 & 4294967295L));
            }
        } else {
            a.b("seq_id", String.valueOf(rk5Var.z & 4294967295L));
        }
        HashMap<String, String> hashMap = rk5Var.E;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : rk5Var.E.entrySet()) {
                a.b(entry.getKey(), entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    public void c(rk5 rk5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rk5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || rk5Var.D <= 0) {
            return;
        }
        lh a = tk5.a();
        a.b("action", "time");
        a.b("pct", String.valueOf(rk5Var.D));
        if (i != 0) {
            if (i != 40) {
                return;
            }
            a.b("pct_type", String.valueOf(101));
        } else {
            a.b("pct_type", String.valueOf(100));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    public void d(rk5 rk5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, rk5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || rk5Var.B > 0) {
            if (!z && rk5Var.C <= 0) {
                return;
            }
            lh a = tk5.a();
            a.b("action", "time");
            if (z) {
                a.b("put", String.valueOf(rk5Var.B));
            } else {
                a.b("pdt", String.valueOf(rk5Var.C));
            }
            String str2 = "1";
            if (rk5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!rk5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(rk5Var.f));
            a.b("connt", String.valueOf(rk5Var.g));
            a.b("rwt", String.valueOf(rk5Var.h));
            a.b("dect", String.valueOf(rk5Var.k));
            a.b("parset", String.valueOf(rk5Var.l));
            a.b("rendert", String.valueOf(rk5Var.o));
            a.b("ss", String.valueOf(rk5Var.q));
            a.b("hs", String.valueOf(rk5Var.r));
            if (rk5Var.s && (i = rk5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = rk5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = rk5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void e(lk5 lk5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, lk5Var) != null) || lk5Var == null || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        lh a = tk5.a();
        a.b("action", FpsTracer.UBC_KEY_FLUENCY);
        a.b(FpsConstants.REPORT_FPS, String.valueOf(lk5Var.b()));
        BdStatisticsManager.getInstance().performance(this.a, a);
        lh a2 = tk5.a();
        a2.b("action", "mem");
        a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
        BdStatisticsManager.getInstance().performance(this.a, a2);
    }
}
