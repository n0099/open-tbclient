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
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes5.dex */
public class mm5 extends km5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public mm5() {
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

    public void b(im5 im5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, im5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        og a = km5.a();
        a.b("action", "time");
        String str2 = "0";
        if (!im5Var.s) {
            str = "0";
        } else {
            str = "1";
        }
        a.b("ishttp", str);
        if (im5Var.b) {
            str2 = "1";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b("wt", String.valueOf(im5Var.p));
        a.b("qt", String.valueOf(im5Var.f));
        a.b("connt", String.valueOf(im5Var.g));
        a.b("rwt", String.valueOf(im5Var.h));
        a.b("fbt", String.valueOf(im5Var.i));
        a.b("abt", String.valueOf(im5Var.j));
        a.b("dect", String.valueOf(im5Var.k));
        a.b("parset", String.valueOf(im5Var.l));
        a.b("tqt", String.valueOf(im5Var.n));
        a.b("rendert", String.valueOf(im5Var.o));
        a.b("ss", String.valueOf(im5Var.q));
        a.b("hs", String.valueOf(im5Var.r));
        if (im5Var.s && (i = im5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = im5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        if (im5Var.s) {
            a.b("hrtn", String.valueOf(im5Var.w));
            a.b("hrtt", String.valueOf(im5Var.x));
        }
        int i2 = im5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (im5Var.y) {
            a.b("pt", "1");
        } else {
            a.b("sysct", String.valueOf(im5Var.c));
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(im5Var.e));
            a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(im5Var.d));
            a.b("df", String.valueOf(im5Var.m));
        }
        if (im5Var.s) {
            a.b("c_logid", String.valueOf(im5Var.A));
            long j2 = im5Var.z;
            if (j2 != 0) {
                a.b(PushConstants.SEQ_ID, String.valueOf(j2 & 4294967295L));
            }
        } else {
            a.b(PushConstants.SEQ_ID, String.valueOf(im5Var.z & 4294967295L));
        }
        HashMap<String, String> hashMap = im5Var.E;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : im5Var.E.entrySet()) {
                a.b(entry.getKey(), entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    public void c(im5 im5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, im5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || im5Var.D <= 0) {
            return;
        }
        og a = km5.a();
        a.b("action", "time");
        a.b("pct", String.valueOf(im5Var.D));
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

    public void d(im5 im5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, im5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || im5Var.B > 0) {
            if (!z && im5Var.C <= 0) {
                return;
            }
            og a = km5.a();
            a.b("action", "time");
            if (z) {
                a.b("put", String.valueOf(im5Var.B));
            } else {
                a.b("pdt", String.valueOf(im5Var.C));
            }
            String str2 = "1";
            if (im5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!im5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(im5Var.f));
            a.b("connt", String.valueOf(im5Var.g));
            a.b("rwt", String.valueOf(im5Var.h));
            a.b("dect", String.valueOf(im5Var.k));
            a.b("parset", String.valueOf(im5Var.l));
            a.b("rendert", String.valueOf(im5Var.o));
            a.b("ss", String.valueOf(im5Var.q));
            a.b("hs", String.valueOf(im5Var.r));
            if (im5Var.s && (i = im5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = im5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = im5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void e(cm5 cm5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, cm5Var) != null) || cm5Var == null || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        og a = km5.a();
        a.b("action", FpsTracer.UBC_KEY_FLUENCY);
        a.b(FpsConstants.REPORT_FPS, String.valueOf(cm5Var.b()));
        BdStatisticsManager.getInstance().performance(this.a, a);
        og a2 = km5.a();
        a2.b("action", "mem");
        a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
        BdStatisticsManager.getInstance().performance(this.a, a2);
    }
}
