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
/* loaded from: classes8.dex */
public class ws5 extends dt5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ws5() {
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

    @Override // com.baidu.tieba.dt5
    public void b(zs5 zs5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, zs5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        dh a = bt5.a();
        a.b("action", "time_t");
        f(a, zs5Var);
        String str2 = "1";
        if (zs5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        a.b("ishttp", str);
        if (!zs5Var.b) {
            str2 = "0";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(zs5Var.e));
        a.b("wt", String.valueOf(zs5Var.p));
        a.b("qt", String.valueOf(zs5Var.f));
        a.b("connt", String.valueOf(zs5Var.g));
        a.b("rwt", String.valueOf(zs5Var.h));
        a.b("dect", String.valueOf(zs5Var.k));
        a.b("parset", String.valueOf(zs5Var.l));
        a.b("rendert", String.valueOf(zs5Var.o));
        a.b("ss", String.valueOf(zs5Var.q));
        a.b("hs", String.valueOf(zs5Var.r));
        if (zs5Var.s && (i = zs5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = zs5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        int i2 = zs5Var.v;
        if (i2 != 0) {
            a.c(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (zs5Var.s) {
            a.b("c_logid", String.valueOf(zs5Var.A));
        } else {
            a.b(PushConstants.SEQ_ID, String.valueOf(zs5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    @Override // com.baidu.tieba.dt5
    public void c(zs5 zs5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, zs5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || zs5Var.D <= 0) {
            return;
        }
        dh a = bt5.a();
        a.b("action", "time_t");
        f(a, zs5Var);
        a.b("pct", String.valueOf(zs5Var.D));
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

    @Override // com.baidu.tieba.dt5
    public void d(zs5 zs5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, zs5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || zs5Var.B > 0) {
            if (!z && zs5Var.C <= 0) {
                return;
            }
            dh a = bt5.a();
            a.b("action", "time_t");
            f(a, zs5Var);
            if (z) {
                a.b("put", String.valueOf(zs5Var.B));
            } else {
                a.b("pdt", String.valueOf(zs5Var.C));
            }
            String str2 = "1";
            if (zs5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!zs5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(zs5Var.f));
            a.b("connt", String.valueOf(zs5Var.g));
            a.b("rwt", String.valueOf(zs5Var.h));
            a.b("dect", String.valueOf(zs5Var.k));
            a.b("parset", String.valueOf(zs5Var.l));
            a.b("rendert", String.valueOf(zs5Var.o));
            a.b("ss", String.valueOf(zs5Var.q));
            a.b("hs", String.valueOf(zs5Var.r));
            if (zs5Var.s && (i = zs5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = zs5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = zs5Var.v;
            if (i2 != 0) {
                a.c(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public final void f(dh dhVar, zs5 zs5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, dhVar, zs5Var) == null) && (zs5Var instanceof vs5)) {
            dhVar.c("ptype", Integer.valueOf(((vs5) zs5Var).F));
        }
    }
}
