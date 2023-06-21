package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes8.dex */
public class ys5 extends ws5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ys5() {
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

    public void b(us5 us5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, us5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        ch a = ws5.a();
        a.b("action", "time");
        String str2 = "0";
        if (!us5Var.s) {
            str = "0";
        } else {
            str = "1";
        }
        a.b("ishttp", str);
        if (us5Var.b) {
            str2 = "1";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b("wt", String.valueOf(us5Var.p));
        a.b("qt", String.valueOf(us5Var.f));
        a.b("connt", String.valueOf(us5Var.g));
        a.b("rwt", String.valueOf(us5Var.h));
        a.b("fbt", String.valueOf(us5Var.i));
        a.b("abt", String.valueOf(us5Var.j));
        a.b("dect", String.valueOf(us5Var.k));
        a.b("parset", String.valueOf(us5Var.l));
        a.b("tqt", String.valueOf(us5Var.n));
        a.b("rendert", String.valueOf(us5Var.o));
        a.b("ss", String.valueOf(us5Var.q));
        a.b("hs", String.valueOf(us5Var.r));
        if (us5Var.s && (i = us5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = us5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        if (us5Var.s) {
            a.b("hrtn", String.valueOf(us5Var.w));
            a.b("hrtt", String.valueOf(us5Var.x));
        }
        int i2 = us5Var.v;
        if (i2 != 0) {
            a.c(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (us5Var.y) {
            a.b("pt", "1");
        } else {
            a.b("sysct", String.valueOf(us5Var.c));
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(us5Var.e));
            a.b("lt", String.valueOf(us5Var.d));
            a.b("df", String.valueOf(us5Var.m));
        }
        if (us5Var.s) {
            a.b("c_logid", String.valueOf(us5Var.A));
            long j2 = us5Var.z;
            if (j2 != 0) {
                a.b(PushConstants.SEQ_ID, String.valueOf(j2 & 4294967295L));
            }
        } else {
            a.b(PushConstants.SEQ_ID, String.valueOf(us5Var.z & 4294967295L));
        }
        HashMap<String, String> hashMap = us5Var.E;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : us5Var.E.entrySet()) {
                a.b(entry.getKey(), entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    public void c(us5 us5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, us5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || us5Var.D <= 0) {
            return;
        }
        ch a = ws5.a();
        a.b("action", "time");
        a.b("pct", String.valueOf(us5Var.D));
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

    public void d(us5 us5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, us5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || us5Var.B > 0) {
            if (!z && us5Var.C <= 0) {
                return;
            }
            ch a = ws5.a();
            a.b("action", "time");
            if (z) {
                a.b("put", String.valueOf(us5Var.B));
            } else {
                a.b("pdt", String.valueOf(us5Var.C));
            }
            String str2 = "1";
            if (us5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!us5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(us5Var.f));
            a.b("connt", String.valueOf(us5Var.g));
            a.b("rwt", String.valueOf(us5Var.h));
            a.b("dect", String.valueOf(us5Var.k));
            a.b("parset", String.valueOf(us5Var.l));
            a.b("rendert", String.valueOf(us5Var.o));
            a.b("ss", String.valueOf(us5Var.q));
            a.b("hs", String.valueOf(us5Var.r));
            if (us5Var.s && (i = us5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = us5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = us5Var.v;
            if (i2 != 0) {
                a.c(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void e(os5 os5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, os5Var) != null) || os5Var == null || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        ch a = ws5.a();
        a.b("action", FpsTracer.UBC_KEY_FLUENCY);
        a.b(FpsConstants.REPORT_FPS, String.valueOf(os5Var.b()));
        BdStatisticsManager.getInstance().performance(this.a, a);
        ch a2 = ws5.a();
        a2.b("action", "mem");
        a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
        BdStatisticsManager.getInstance().performance(this.a, a2);
    }
}
