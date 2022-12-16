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
public class vf5 extends tf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public vf5() {
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

    public void b(rf5 rf5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, rf5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        fh a = tf5.a();
        a.b("action", "time");
        String str2 = "0";
        if (!rf5Var.s) {
            str = "0";
        } else {
            str = "1";
        }
        a.b("ishttp", str);
        if (rf5Var.b) {
            str2 = "1";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b("wt", String.valueOf(rf5Var.p));
        a.b("qt", String.valueOf(rf5Var.f));
        a.b("connt", String.valueOf(rf5Var.g));
        a.b("rwt", String.valueOf(rf5Var.h));
        a.b("fbt", String.valueOf(rf5Var.i));
        a.b("abt", String.valueOf(rf5Var.j));
        a.b("dect", String.valueOf(rf5Var.k));
        a.b("parset", String.valueOf(rf5Var.l));
        a.b("tqt", String.valueOf(rf5Var.n));
        a.b("rendert", String.valueOf(rf5Var.o));
        a.b("ss", String.valueOf(rf5Var.q));
        a.b("hs", String.valueOf(rf5Var.r));
        if (rf5Var.s && (i = rf5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = rf5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        if (rf5Var.s) {
            a.b("hrtn", String.valueOf(rf5Var.w));
            a.b("hrtt", String.valueOf(rf5Var.x));
        }
        int i2 = rf5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (rf5Var.y) {
            a.b(Config.PLATFORM_TYPE, "1");
        } else {
            a.b("sysct", String.valueOf(rf5Var.c));
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(rf5Var.e));
            a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(rf5Var.d));
            a.b("df", String.valueOf(rf5Var.m));
        }
        if (rf5Var.s) {
            a.b("c_logid", String.valueOf(rf5Var.A));
            long j2 = rf5Var.z;
            if (j2 != 0) {
                a.b("seq_id", String.valueOf(j2 & 4294967295L));
            }
        } else {
            a.b("seq_id", String.valueOf(rf5Var.z & 4294967295L));
        }
        HashMap<String, String> hashMap = rf5Var.E;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : rf5Var.E.entrySet()) {
                a.b(entry.getKey(), entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    public void c(rf5 rf5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rf5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || rf5Var.D <= 0) {
            return;
        }
        fh a = tf5.a();
        a.b("action", "time");
        a.b("pct", String.valueOf(rf5Var.D));
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

    public void d(rf5 rf5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, rf5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || rf5Var.B > 0) {
            if (!z && rf5Var.C <= 0) {
                return;
            }
            fh a = tf5.a();
            a.b("action", "time");
            if (z) {
                a.b("put", String.valueOf(rf5Var.B));
            } else {
                a.b("pdt", String.valueOf(rf5Var.C));
            }
            String str2 = "1";
            if (rf5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!rf5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(rf5Var.f));
            a.b("connt", String.valueOf(rf5Var.g));
            a.b("rwt", String.valueOf(rf5Var.h));
            a.b("dect", String.valueOf(rf5Var.k));
            a.b("parset", String.valueOf(rf5Var.l));
            a.b("rendert", String.valueOf(rf5Var.o));
            a.b("ss", String.valueOf(rf5Var.q));
            a.b("hs", String.valueOf(rf5Var.r));
            if (rf5Var.s && (i = rf5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = rf5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = rf5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void e(lf5 lf5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, lf5Var) != null) || lf5Var == null || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        fh a = tf5.a();
        a.b("action", FpsTracer.UBC_KEY_FLUENCY);
        a.b(FpsConstants.REPORT_FPS, String.valueOf(lf5Var.b()));
        BdStatisticsManager.getInstance().performance(this.a, a);
        fh a2 = tf5.a();
        a2.b("action", "mem");
        a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
        BdStatisticsManager.getInstance().performance(this.a, a2);
    }
}
