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
public class oe5 extends ve5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public oe5() {
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

    @Override // com.baidu.tieba.ve5
    public void b(re5 re5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, re5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        eh a = te5.a();
        a.b("action", "time_t");
        f(a, re5Var);
        String str2 = "1";
        if (re5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        a.b("ishttp", str);
        if (!re5Var.b) {
            str2 = "0";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(re5Var.e));
        a.b("wt", String.valueOf(re5Var.p));
        a.b("qt", String.valueOf(re5Var.f));
        a.b("connt", String.valueOf(re5Var.g));
        a.b("rwt", String.valueOf(re5Var.h));
        a.b("dect", String.valueOf(re5Var.k));
        a.b("parset", String.valueOf(re5Var.l));
        a.b("rendert", String.valueOf(re5Var.o));
        a.b("ss", String.valueOf(re5Var.q));
        a.b("hs", String.valueOf(re5Var.r));
        if (re5Var.s && (i = re5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = re5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        int i2 = re5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (re5Var.s) {
            a.b("c_logid", String.valueOf(re5Var.A));
        } else {
            a.b("seq_id", String.valueOf(re5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    @Override // com.baidu.tieba.ve5
    public void c(re5 re5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, re5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || re5Var.D <= 0) {
            return;
        }
        eh a = te5.a();
        a.b("action", "time_t");
        f(a, re5Var);
        a.b("pct", String.valueOf(re5Var.D));
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

    @Override // com.baidu.tieba.ve5
    public void d(re5 re5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, re5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || re5Var.B > 0) {
            if (!z && re5Var.C <= 0) {
                return;
            }
            eh a = te5.a();
            a.b("action", "time_t");
            f(a, re5Var);
            if (z) {
                a.b("put", String.valueOf(re5Var.B));
            } else {
                a.b("pdt", String.valueOf(re5Var.C));
            }
            String str2 = "1";
            if (re5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!re5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(re5Var.f));
            a.b("connt", String.valueOf(re5Var.g));
            a.b("rwt", String.valueOf(re5Var.h));
            a.b("dect", String.valueOf(re5Var.k));
            a.b("parset", String.valueOf(re5Var.l));
            a.b("rendert", String.valueOf(re5Var.o));
            a.b("ss", String.valueOf(re5Var.q));
            a.b("hs", String.valueOf(re5Var.r));
            if (re5Var.s && (i = re5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = re5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = re5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public final void f(eh ehVar, re5 re5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, ehVar, re5Var) == null) && (re5Var instanceof ne5)) {
            ehVar.c("ptype", Integer.valueOf(((ne5) re5Var).F));
        }
    }
}
