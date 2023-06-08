package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes6.dex */
public class ms5 extends ts5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ms5() {
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

    @Override // com.baidu.tieba.ts5
    public void b(ps5 ps5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ps5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        bh a = rs5.a();
        a.b("action", "time_t");
        f(a, ps5Var);
        String str2 = "1";
        if (ps5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        a.b("ishttp", str);
        if (!ps5Var.b) {
            str2 = "0";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(ps5Var.e));
        a.b("wt", String.valueOf(ps5Var.p));
        a.b("qt", String.valueOf(ps5Var.f));
        a.b("connt", String.valueOf(ps5Var.g));
        a.b("rwt", String.valueOf(ps5Var.h));
        a.b("dect", String.valueOf(ps5Var.k));
        a.b("parset", String.valueOf(ps5Var.l));
        a.b("rendert", String.valueOf(ps5Var.o));
        a.b("ss", String.valueOf(ps5Var.q));
        a.b("hs", String.valueOf(ps5Var.r));
        if (ps5Var.s && (i = ps5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = ps5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        int i2 = ps5Var.v;
        if (i2 != 0) {
            a.c(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (ps5Var.s) {
            a.b("c_logid", String.valueOf(ps5Var.A));
        } else {
            a.b(PushConstants.SEQ_ID, String.valueOf(ps5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    @Override // com.baidu.tieba.ts5
    public void c(ps5 ps5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ps5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || ps5Var.D <= 0) {
            return;
        }
        bh a = rs5.a();
        a.b("action", "time_t");
        f(a, ps5Var);
        a.b("pct", String.valueOf(ps5Var.D));
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

    @Override // com.baidu.tieba.ts5
    public void d(ps5 ps5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, ps5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || ps5Var.B > 0) {
            if (!z && ps5Var.C <= 0) {
                return;
            }
            bh a = rs5.a();
            a.b("action", "time_t");
            f(a, ps5Var);
            if (z) {
                a.b("put", String.valueOf(ps5Var.B));
            } else {
                a.b("pdt", String.valueOf(ps5Var.C));
            }
            String str2 = "1";
            if (ps5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!ps5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(ps5Var.f));
            a.b("connt", String.valueOf(ps5Var.g));
            a.b("rwt", String.valueOf(ps5Var.h));
            a.b("dect", String.valueOf(ps5Var.k));
            a.b("parset", String.valueOf(ps5Var.l));
            a.b("rendert", String.valueOf(ps5Var.o));
            a.b("ss", String.valueOf(ps5Var.q));
            a.b("hs", String.valueOf(ps5Var.r));
            if (ps5Var.s && (i = ps5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = ps5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = ps5Var.v;
            if (i2 != 0) {
                a.c(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public final void f(bh bhVar, ps5 ps5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, bhVar, ps5Var) == null) && (ps5Var instanceof ls5)) {
            bhVar.c("ptype", Integer.valueOf(((ls5) ps5Var).F));
        }
    }
}
