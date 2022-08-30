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
/* loaded from: classes5.dex */
public class sa5 extends za5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public sa5() {
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

    @Override // com.baidu.tieba.za5
    public void b(va5 va5Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, va5Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            xg a = xa5.a();
            a.b("action", "time_t");
            f(a, va5Var);
            a.b("ishttp", va5Var.s ? "1" : "0");
            a.b("issuccess", va5Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(va5Var.e));
            a.b("wt", String.valueOf(va5Var.p));
            a.b("qt", String.valueOf(va5Var.f));
            a.b("connt", String.valueOf(va5Var.g));
            a.b("rwt", String.valueOf(va5Var.h));
            a.b("dect", String.valueOf(va5Var.k));
            a.b("parset", String.valueOf(va5Var.l));
            a.b("rendert", String.valueOf(va5Var.o));
            a.b("ss", String.valueOf(va5Var.q));
            a.b("hs", String.valueOf(va5Var.r));
            if (va5Var.s && (i = va5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = va5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = va5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (va5Var.s) {
                a.b("c_logid", String.valueOf(va5Var.A));
            } else {
                a.b("seq_id", String.valueOf(va5Var.z & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    @Override // com.baidu.tieba.za5
    public void c(va5 va5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, va5Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && va5Var.D > 0) {
            xg a = xa5.a();
            a.b("action", "time_t");
            f(a, va5Var);
            a.b("pct", String.valueOf(va5Var.D));
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

    @Override // com.baidu.tieba.za5
    public void d(va5 va5Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, va5Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || va5Var.B > 0) {
                if (z || va5Var.C > 0) {
                    xg a = xa5.a();
                    a.b("action", "time_t");
                    f(a, va5Var);
                    if (z) {
                        a.b("put", String.valueOf(va5Var.B));
                    } else {
                        a.b("pdt", String.valueOf(va5Var.C));
                    }
                    a.b("ishttp", va5Var.s ? "1" : "0");
                    a.b("issuccess", va5Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(va5Var.f));
                    a.b("connt", String.valueOf(va5Var.g));
                    a.b("rwt", String.valueOf(va5Var.h));
                    a.b("dect", String.valueOf(va5Var.k));
                    a.b("parset", String.valueOf(va5Var.l));
                    a.b("rendert", String.valueOf(va5Var.o));
                    a.b("ss", String.valueOf(va5Var.q));
                    a.b("hs", String.valueOf(va5Var.r));
                    if (va5Var.s && (i = va5Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = va5Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = va5Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public final void f(xg xgVar, va5 va5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, xgVar, va5Var) == null) && (va5Var instanceof ra5)) {
            xgVar.c("ptype", Integer.valueOf(((ra5) va5Var).F));
        }
    }
}
