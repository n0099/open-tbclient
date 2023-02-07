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
public class ok5 extends vk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ok5() {
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

    @Override // com.baidu.tieba.vk5
    public void b(rk5 rk5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, rk5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        lh a = tk5.a();
        a.b("action", "time_t");
        f(a, rk5Var);
        String str2 = "1";
        if (rk5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        a.b("ishttp", str);
        if (!rk5Var.b) {
            str2 = "0";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(rk5Var.e));
        a.b("wt", String.valueOf(rk5Var.p));
        a.b("qt", String.valueOf(rk5Var.f));
        a.b("connt", String.valueOf(rk5Var.g));
        a.b("rwt", String.valueOf(rk5Var.h));
        a.b("dect", String.valueOf(rk5Var.k));
        a.b("parset", String.valueOf(rk5Var.l));
        a.b("rendert", String.valueOf(rk5Var.o));
        a.b("ss", String.valueOf(rk5Var.q));
        a.b("hs", String.valueOf(rk5Var.r));
        if (rk5Var.s && (i = rk5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = rk5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        int i2 = rk5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (rk5Var.s) {
            a.b("c_logid", String.valueOf(rk5Var.A));
        } else {
            a.b("seq_id", String.valueOf(rk5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    @Override // com.baidu.tieba.vk5
    public void c(rk5 rk5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rk5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || rk5Var.D <= 0) {
            return;
        }
        lh a = tk5.a();
        a.b("action", "time_t");
        f(a, rk5Var);
        a.b("pct", String.valueOf(rk5Var.D));
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

    @Override // com.baidu.tieba.vk5
    public void d(rk5 rk5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, rk5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || rk5Var.B > 0) {
            if (!z && rk5Var.C <= 0) {
                return;
            }
            lh a = tk5.a();
            a.b("action", "time_t");
            f(a, rk5Var);
            if (z) {
                a.b("put", String.valueOf(rk5Var.B));
            } else {
                a.b("pdt", String.valueOf(rk5Var.C));
            }
            String str2 = "1";
            if (rk5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!rk5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(rk5Var.f));
            a.b("connt", String.valueOf(rk5Var.g));
            a.b("rwt", String.valueOf(rk5Var.h));
            a.b("dect", String.valueOf(rk5Var.k));
            a.b("parset", String.valueOf(rk5Var.l));
            a.b("rendert", String.valueOf(rk5Var.o));
            a.b("ss", String.valueOf(rk5Var.q));
            a.b("hs", String.valueOf(rk5Var.r));
            if (rk5Var.s && (i = rk5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = rk5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = rk5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public final void f(lh lhVar, rk5 rk5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, lhVar, rk5Var) == null) && (rk5Var instanceof nk5)) {
            lhVar.c("ptype", Integer.valueOf(((nk5) rk5Var).F));
        }
    }
}
