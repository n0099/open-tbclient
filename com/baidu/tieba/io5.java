package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes6.dex */
public class io5 extends po5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public io5() {
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

    @Override // com.baidu.tieba.po5
    public void b(lo5 lo5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, lo5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        xg a = no5.a();
        a.b("action", "time_t");
        f(a, lo5Var);
        String str2 = "1";
        if (lo5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        a.b("ishttp", str);
        if (!lo5Var.b) {
            str2 = "0";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(lo5Var.e));
        a.b("wt", String.valueOf(lo5Var.p));
        a.b("qt", String.valueOf(lo5Var.f));
        a.b("connt", String.valueOf(lo5Var.g));
        a.b("rwt", String.valueOf(lo5Var.h));
        a.b("dect", String.valueOf(lo5Var.k));
        a.b("parset", String.valueOf(lo5Var.l));
        a.b("rendert", String.valueOf(lo5Var.o));
        a.b("ss", String.valueOf(lo5Var.q));
        a.b("hs", String.valueOf(lo5Var.r));
        if (lo5Var.s && (i = lo5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = lo5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        int i2 = lo5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (lo5Var.s) {
            a.b("c_logid", String.valueOf(lo5Var.A));
        } else {
            a.b(PushConstants.SEQ_ID, String.valueOf(lo5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    @Override // com.baidu.tieba.po5
    public void c(lo5 lo5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, lo5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || lo5Var.D <= 0) {
            return;
        }
        xg a = no5.a();
        a.b("action", "time_t");
        f(a, lo5Var);
        a.b("pct", String.valueOf(lo5Var.D));
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

    @Override // com.baidu.tieba.po5
    public void d(lo5 lo5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, lo5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || lo5Var.B > 0) {
            if (!z && lo5Var.C <= 0) {
                return;
            }
            xg a = no5.a();
            a.b("action", "time_t");
            f(a, lo5Var);
            if (z) {
                a.b("put", String.valueOf(lo5Var.B));
            } else {
                a.b("pdt", String.valueOf(lo5Var.C));
            }
            String str2 = "1";
            if (lo5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!lo5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(lo5Var.f));
            a.b("connt", String.valueOf(lo5Var.g));
            a.b("rwt", String.valueOf(lo5Var.h));
            a.b("dect", String.valueOf(lo5Var.k));
            a.b("parset", String.valueOf(lo5Var.l));
            a.b("rendert", String.valueOf(lo5Var.o));
            a.b("ss", String.valueOf(lo5Var.q));
            a.b("hs", String.valueOf(lo5Var.r));
            if (lo5Var.s && (i = lo5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = lo5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = lo5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public final void f(xg xgVar, lo5 lo5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, xgVar, lo5Var) == null) && (lo5Var instanceof ho5)) {
            xgVar.c("ptype", Integer.valueOf(((ho5) lo5Var).F));
        }
    }
}
