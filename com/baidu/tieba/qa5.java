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
public class qa5 extends xa5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qa5() {
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

    @Override // com.baidu.tieba.xa5
    public void b(ta5 ta5Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, ta5Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            xg a = va5.a();
            a.b("action", "time_t");
            f(a, ta5Var);
            a.b("ishttp", ta5Var.s ? "1" : "0");
            a.b("issuccess", ta5Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(ta5Var.e));
            a.b("wt", String.valueOf(ta5Var.p));
            a.b("qt", String.valueOf(ta5Var.f));
            a.b("connt", String.valueOf(ta5Var.g));
            a.b("rwt", String.valueOf(ta5Var.h));
            a.b("dect", String.valueOf(ta5Var.k));
            a.b("parset", String.valueOf(ta5Var.l));
            a.b("rendert", String.valueOf(ta5Var.o));
            a.b("ss", String.valueOf(ta5Var.q));
            a.b("hs", String.valueOf(ta5Var.r));
            if (ta5Var.s && (i = ta5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = ta5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = ta5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (ta5Var.s) {
                a.b("c_logid", String.valueOf(ta5Var.A));
            } else {
                a.b("seq_id", String.valueOf(ta5Var.z & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    @Override // com.baidu.tieba.xa5
    public void c(ta5 ta5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ta5Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && ta5Var.D > 0) {
            xg a = va5.a();
            a.b("action", "time_t");
            f(a, ta5Var);
            a.b("pct", String.valueOf(ta5Var.D));
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

    @Override // com.baidu.tieba.xa5
    public void d(ta5 ta5Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, ta5Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || ta5Var.B > 0) {
                if (z || ta5Var.C > 0) {
                    xg a = va5.a();
                    a.b("action", "time_t");
                    f(a, ta5Var);
                    if (z) {
                        a.b("put", String.valueOf(ta5Var.B));
                    } else {
                        a.b("pdt", String.valueOf(ta5Var.C));
                    }
                    a.b("ishttp", ta5Var.s ? "1" : "0");
                    a.b("issuccess", ta5Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(ta5Var.f));
                    a.b("connt", String.valueOf(ta5Var.g));
                    a.b("rwt", String.valueOf(ta5Var.h));
                    a.b("dect", String.valueOf(ta5Var.k));
                    a.b("parset", String.valueOf(ta5Var.l));
                    a.b("rendert", String.valueOf(ta5Var.o));
                    a.b("ss", String.valueOf(ta5Var.q));
                    a.b("hs", String.valueOf(ta5Var.r));
                    if (ta5Var.s && (i = ta5Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = ta5Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = ta5Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public final void f(xg xgVar, ta5 ta5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, xgVar, ta5Var) == null) && (ta5Var instanceof pa5)) {
            xgVar.c("ptype", Integer.valueOf(((pa5) ta5Var).F));
        }
    }
}
