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
public class ks5 extends rs5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ks5() {
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

    @Override // com.baidu.tieba.rs5
    public void b(ns5 ns5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ns5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        bh a = ps5.a();
        a.b("action", "time_t");
        f(a, ns5Var);
        String str2 = "1";
        if (ns5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        a.b("ishttp", str);
        if (!ns5Var.b) {
            str2 = "0";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(ns5Var.e));
        a.b("wt", String.valueOf(ns5Var.p));
        a.b("qt", String.valueOf(ns5Var.f));
        a.b("connt", String.valueOf(ns5Var.g));
        a.b("rwt", String.valueOf(ns5Var.h));
        a.b("dect", String.valueOf(ns5Var.k));
        a.b("parset", String.valueOf(ns5Var.l));
        a.b("rendert", String.valueOf(ns5Var.o));
        a.b("ss", String.valueOf(ns5Var.q));
        a.b("hs", String.valueOf(ns5Var.r));
        if (ns5Var.s && (i = ns5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = ns5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        int i2 = ns5Var.v;
        if (i2 != 0) {
            a.c(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (ns5Var.s) {
            a.b("c_logid", String.valueOf(ns5Var.A));
        } else {
            a.b(PushConstants.SEQ_ID, String.valueOf(ns5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    @Override // com.baidu.tieba.rs5
    public void c(ns5 ns5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ns5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || ns5Var.D <= 0) {
            return;
        }
        bh a = ps5.a();
        a.b("action", "time_t");
        f(a, ns5Var);
        a.b("pct", String.valueOf(ns5Var.D));
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

    @Override // com.baidu.tieba.rs5
    public void d(ns5 ns5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, ns5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || ns5Var.B > 0) {
            if (!z && ns5Var.C <= 0) {
                return;
            }
            bh a = ps5.a();
            a.b("action", "time_t");
            f(a, ns5Var);
            if (z) {
                a.b("put", String.valueOf(ns5Var.B));
            } else {
                a.b("pdt", String.valueOf(ns5Var.C));
            }
            String str2 = "1";
            if (ns5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!ns5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(ns5Var.f));
            a.b("connt", String.valueOf(ns5Var.g));
            a.b("rwt", String.valueOf(ns5Var.h));
            a.b("dect", String.valueOf(ns5Var.k));
            a.b("parset", String.valueOf(ns5Var.l));
            a.b("rendert", String.valueOf(ns5Var.o));
            a.b("ss", String.valueOf(ns5Var.q));
            a.b("hs", String.valueOf(ns5Var.r));
            if (ns5Var.s && (i = ns5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = ns5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = ns5Var.v;
            if (i2 != 0) {
                a.c(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public final void f(bh bhVar, ns5 ns5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, bhVar, ns5Var) == null) && (ns5Var instanceof js5)) {
            bhVar.c("ptype", Integer.valueOf(((js5) ns5Var).F));
        }
    }
}
