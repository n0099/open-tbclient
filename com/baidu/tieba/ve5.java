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
/* loaded from: classes6.dex */
public class ve5 extends cf5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ve5() {
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

    @Override // com.baidu.tieba.cf5
    public void b(ye5 ye5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ye5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        fh a = af5.a();
        a.b("action", "time_t");
        f(a, ye5Var);
        String str2 = "1";
        if (ye5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        a.b("ishttp", str);
        if (!ye5Var.b) {
            str2 = "0";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(ye5Var.e));
        a.b("wt", String.valueOf(ye5Var.p));
        a.b("qt", String.valueOf(ye5Var.f));
        a.b("connt", String.valueOf(ye5Var.g));
        a.b("rwt", String.valueOf(ye5Var.h));
        a.b("dect", String.valueOf(ye5Var.k));
        a.b("parset", String.valueOf(ye5Var.l));
        a.b("rendert", String.valueOf(ye5Var.o));
        a.b("ss", String.valueOf(ye5Var.q));
        a.b("hs", String.valueOf(ye5Var.r));
        if (ye5Var.s && (i = ye5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = ye5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        int i2 = ye5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (ye5Var.s) {
            a.b("c_logid", String.valueOf(ye5Var.A));
        } else {
            a.b("seq_id", String.valueOf(ye5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    @Override // com.baidu.tieba.cf5
    public void c(ye5 ye5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ye5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || ye5Var.D <= 0) {
            return;
        }
        fh a = af5.a();
        a.b("action", "time_t");
        f(a, ye5Var);
        a.b("pct", String.valueOf(ye5Var.D));
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

    @Override // com.baidu.tieba.cf5
    public void d(ye5 ye5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, ye5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || ye5Var.B > 0) {
            if (!z && ye5Var.C <= 0) {
                return;
            }
            fh a = af5.a();
            a.b("action", "time_t");
            f(a, ye5Var);
            if (z) {
                a.b("put", String.valueOf(ye5Var.B));
            } else {
                a.b("pdt", String.valueOf(ye5Var.C));
            }
            String str2 = "1";
            if (ye5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!ye5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(ye5Var.f));
            a.b("connt", String.valueOf(ye5Var.g));
            a.b("rwt", String.valueOf(ye5Var.h));
            a.b("dect", String.valueOf(ye5Var.k));
            a.b("parset", String.valueOf(ye5Var.l));
            a.b("rendert", String.valueOf(ye5Var.o));
            a.b("ss", String.valueOf(ye5Var.q));
            a.b("hs", String.valueOf(ye5Var.r));
            if (ye5Var.s && (i = ye5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = ye5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = ye5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public final void f(fh fhVar, ye5 ye5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, fhVar, ye5Var) == null) && (ye5Var instanceof ue5)) {
            fhVar.c("ptype", Integer.valueOf(((ue5) ye5Var).F));
        }
    }
}
