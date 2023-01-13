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
public class kg5 extends ig5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kg5() {
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

    public void b(gg5 gg5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, gg5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        gh a = ig5.a();
        a.b("action", "time");
        String str2 = "0";
        if (!gg5Var.s) {
            str = "0";
        } else {
            str = "1";
        }
        a.b("ishttp", str);
        if (gg5Var.b) {
            str2 = "1";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b("wt", String.valueOf(gg5Var.p));
        a.b("qt", String.valueOf(gg5Var.f));
        a.b("connt", String.valueOf(gg5Var.g));
        a.b("rwt", String.valueOf(gg5Var.h));
        a.b("fbt", String.valueOf(gg5Var.i));
        a.b("abt", String.valueOf(gg5Var.j));
        a.b("dect", String.valueOf(gg5Var.k));
        a.b("parset", String.valueOf(gg5Var.l));
        a.b("tqt", String.valueOf(gg5Var.n));
        a.b("rendert", String.valueOf(gg5Var.o));
        a.b("ss", String.valueOf(gg5Var.q));
        a.b("hs", String.valueOf(gg5Var.r));
        if (gg5Var.s && (i = gg5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = gg5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        if (gg5Var.s) {
            a.b("hrtn", String.valueOf(gg5Var.w));
            a.b("hrtt", String.valueOf(gg5Var.x));
        }
        int i2 = gg5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (gg5Var.y) {
            a.b(Config.PLATFORM_TYPE, "1");
        } else {
            a.b("sysct", String.valueOf(gg5Var.c));
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(gg5Var.e));
            a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(gg5Var.d));
            a.b("df", String.valueOf(gg5Var.m));
        }
        if (gg5Var.s) {
            a.b("c_logid", String.valueOf(gg5Var.A));
            long j2 = gg5Var.z;
            if (j2 != 0) {
                a.b("seq_id", String.valueOf(j2 & 4294967295L));
            }
        } else {
            a.b("seq_id", String.valueOf(gg5Var.z & 4294967295L));
        }
        HashMap<String, String> hashMap = gg5Var.E;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : gg5Var.E.entrySet()) {
                a.b(entry.getKey(), entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    public void c(gg5 gg5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gg5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || gg5Var.D <= 0) {
            return;
        }
        gh a = ig5.a();
        a.b("action", "time");
        a.b("pct", String.valueOf(gg5Var.D));
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

    public void d(gg5 gg5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, gg5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || gg5Var.B > 0) {
            if (!z && gg5Var.C <= 0) {
                return;
            }
            gh a = ig5.a();
            a.b("action", "time");
            if (z) {
                a.b("put", String.valueOf(gg5Var.B));
            } else {
                a.b("pdt", String.valueOf(gg5Var.C));
            }
            String str2 = "1";
            if (gg5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!gg5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(gg5Var.f));
            a.b("connt", String.valueOf(gg5Var.g));
            a.b("rwt", String.valueOf(gg5Var.h));
            a.b("dect", String.valueOf(gg5Var.k));
            a.b("parset", String.valueOf(gg5Var.l));
            a.b("rendert", String.valueOf(gg5Var.o));
            a.b("ss", String.valueOf(gg5Var.q));
            a.b("hs", String.valueOf(gg5Var.r));
            if (gg5Var.s && (i = gg5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = gg5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = gg5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void e(ag5 ag5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, ag5Var) != null) || ag5Var == null || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        gh a = ig5.a();
        a.b("action", FpsTracer.UBC_KEY_FLUENCY);
        a.b(FpsConstants.REPORT_FPS, String.valueOf(ag5Var.b()));
        BdStatisticsManager.getInstance().performance(this.a, a);
        gh a2 = ig5.a();
        a2.b("action", "mem");
        a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
        BdStatisticsManager.getInstance().performance(this.a, a2);
    }
}
