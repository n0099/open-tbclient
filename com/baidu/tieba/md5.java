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
public class md5 extends td5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public md5() {
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

    @Override // com.baidu.tieba.td5
    public void b(pd5 pd5Var) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, pd5Var) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            lh a = rd5.a();
            a.b("action", "time_t");
            f(a, pd5Var);
            a.b("ishttp", pd5Var.s ? "1" : "0");
            a.b("issuccess", pd5Var.b ? "1" : "0");
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(pd5Var.e));
            a.b("wt", String.valueOf(pd5Var.p));
            a.b("qt", String.valueOf(pd5Var.f));
            a.b("connt", String.valueOf(pd5Var.g));
            a.b("rwt", String.valueOf(pd5Var.h));
            a.b("dect", String.valueOf(pd5Var.k));
            a.b("parset", String.valueOf(pd5Var.l));
            a.b("rendert", String.valueOf(pd5Var.o));
            a.b("ss", String.valueOf(pd5Var.q));
            a.b("hs", String.valueOf(pd5Var.r));
            if (pd5Var.s && (i = pd5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = pd5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = pd5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            if (pd5Var.s) {
                a.b("c_logid", String.valueOf(pd5Var.A));
            } else {
                a.b("seq_id", String.valueOf(pd5Var.z & 4294967295L));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    @Override // com.baidu.tieba.td5
    public void c(pd5 pd5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pd5Var, i) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow() && pd5Var.D > 0) {
            lh a = rd5.a();
            a.b("action", "time_t");
            f(a, pd5Var);
            a.b("pct", String.valueOf(pd5Var.D));
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

    @Override // com.baidu.tieba.td5
    public void d(pd5 pd5Var, boolean z) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, pd5Var, z) == null) && PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            if (!z || pd5Var.B > 0) {
                if (z || pd5Var.C > 0) {
                    lh a = rd5.a();
                    a.b("action", "time_t");
                    f(a, pd5Var);
                    if (z) {
                        a.b("put", String.valueOf(pd5Var.B));
                    } else {
                        a.b("pdt", String.valueOf(pd5Var.C));
                    }
                    a.b("ishttp", pd5Var.s ? "1" : "0");
                    a.b("issuccess", pd5Var.b ? "1" : "0");
                    a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
                    a.b("qt", String.valueOf(pd5Var.f));
                    a.b("connt", String.valueOf(pd5Var.g));
                    a.b("rwt", String.valueOf(pd5Var.h));
                    a.b("dect", String.valueOf(pd5Var.k));
                    a.b("parset", String.valueOf(pd5Var.l));
                    a.b("rendert", String.valueOf(pd5Var.o));
                    a.b("ss", String.valueOf(pd5Var.q));
                    a.b("hs", String.valueOf(pd5Var.r));
                    if (pd5Var.s && (i = pd5Var.t) != 0) {
                        a.b("salno", String.valueOf(i));
                        long j = pd5Var.u;
                        if (j != 0) {
                            a.b("scosttime", String.valueOf(j));
                        }
                    }
                    int i2 = pd5Var.v;
                    if (i2 != 0) {
                        a.c("errcode", Integer.valueOf(i2));
                    }
                    BdStatisticsManager.getInstance().performance(this.a, a);
                }
            }
        }
    }

    public final void f(lh lhVar, pd5 pd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, lhVar, pd5Var) == null) && (pd5Var instanceof ld5)) {
            lhVar.c("ptype", Integer.valueOf(((ld5) pd5Var).F));
        }
    }
}
