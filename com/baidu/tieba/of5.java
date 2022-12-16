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
public class of5 extends vf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public of5() {
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

    @Override // com.baidu.tieba.vf5
    public void b(rf5 rf5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, rf5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        fh a = tf5.a();
        a.b("action", "time_t");
        f(a, rf5Var);
        String str2 = "1";
        if (rf5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        a.b("ishttp", str);
        if (!rf5Var.b) {
            str2 = "0";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(rf5Var.e));
        a.b("wt", String.valueOf(rf5Var.p));
        a.b("qt", String.valueOf(rf5Var.f));
        a.b("connt", String.valueOf(rf5Var.g));
        a.b("rwt", String.valueOf(rf5Var.h));
        a.b("dect", String.valueOf(rf5Var.k));
        a.b("parset", String.valueOf(rf5Var.l));
        a.b("rendert", String.valueOf(rf5Var.o));
        a.b("ss", String.valueOf(rf5Var.q));
        a.b("hs", String.valueOf(rf5Var.r));
        if (rf5Var.s && (i = rf5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = rf5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        int i2 = rf5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (rf5Var.s) {
            a.b("c_logid", String.valueOf(rf5Var.A));
        } else {
            a.b("seq_id", String.valueOf(rf5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    @Override // com.baidu.tieba.vf5
    public void c(rf5 rf5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, rf5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || rf5Var.D <= 0) {
            return;
        }
        fh a = tf5.a();
        a.b("action", "time_t");
        f(a, rf5Var);
        a.b("pct", String.valueOf(rf5Var.D));
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

    @Override // com.baidu.tieba.vf5
    public void d(rf5 rf5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, rf5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || rf5Var.B > 0) {
            if (!z && rf5Var.C <= 0) {
                return;
            }
            fh a = tf5.a();
            a.b("action", "time_t");
            f(a, rf5Var);
            if (z) {
                a.b("put", String.valueOf(rf5Var.B));
            } else {
                a.b("pdt", String.valueOf(rf5Var.C));
            }
            String str2 = "1";
            if (rf5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!rf5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(rf5Var.f));
            a.b("connt", String.valueOf(rf5Var.g));
            a.b("rwt", String.valueOf(rf5Var.h));
            a.b("dect", String.valueOf(rf5Var.k));
            a.b("parset", String.valueOf(rf5Var.l));
            a.b("rendert", String.valueOf(rf5Var.o));
            a.b("ss", String.valueOf(rf5Var.q));
            a.b("hs", String.valueOf(rf5Var.r));
            if (rf5Var.s && (i = rf5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = rf5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = rf5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public final void f(fh fhVar, rf5 rf5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, fhVar, rf5Var) == null) && (rf5Var instanceof nf5)) {
            fhVar.c("ptype", Integer.valueOf(((nf5) rf5Var).F));
        }
    }
}
