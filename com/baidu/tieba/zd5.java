package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class zd5 extends xd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public zd5() {
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

    public void b(vd5 vd5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, vd5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        mh a = xd5.a();
        a.b("action", "time");
        String str2 = "0";
        if (!vd5Var.s) {
            str = "0";
        } else {
            str = "1";
        }
        a.b("ishttp", str);
        if (vd5Var.b) {
            str2 = "1";
        }
        a.b("issuccess", str2);
        a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        a.b("wt", String.valueOf(vd5Var.p));
        a.b("qt", String.valueOf(vd5Var.f));
        a.b("connt", String.valueOf(vd5Var.g));
        a.b("rwt", String.valueOf(vd5Var.h));
        a.b("fbt", String.valueOf(vd5Var.i));
        a.b("abt", String.valueOf(vd5Var.j));
        a.b("dect", String.valueOf(vd5Var.k));
        a.b("parset", String.valueOf(vd5Var.l));
        a.b("tqt", String.valueOf(vd5Var.n));
        a.b("rendert", String.valueOf(vd5Var.o));
        a.b("ss", String.valueOf(vd5Var.q));
        a.b("hs", String.valueOf(vd5Var.r));
        if (vd5Var.s && (i = vd5Var.t) != 0) {
            a.b("salno", String.valueOf(i));
            long j = vd5Var.u;
            if (j != 0) {
                a.b("scosttime", String.valueOf(j));
            }
        }
        if (vd5Var.s) {
            a.b("hrtn", String.valueOf(vd5Var.w));
            a.b("hrtt", String.valueOf(vd5Var.x));
        }
        int i2 = vd5Var.v;
        if (i2 != 0) {
            a.c("errcode", Integer.valueOf(i2));
        }
        if (vd5Var.y) {
            a.b(Config.PLATFORM_TYPE, "1");
        } else {
            a.b("sysct", String.valueOf(vd5Var.c));
            a.b(Config.EXCEPTION_CRASH_TYPE, String.valueOf(vd5Var.e));
            a.b(WebvttCueParser.ENTITY_LESS_THAN, String.valueOf(vd5Var.d));
            a.b("df", String.valueOf(vd5Var.m));
        }
        if (vd5Var.s) {
            a.b("c_logid", String.valueOf(vd5Var.A));
            long j2 = vd5Var.z;
            if (j2 != 0) {
                a.b("seq_id", String.valueOf(j2 & 4294967295L));
            }
        } else {
            a.b("seq_id", String.valueOf(vd5Var.z & 4294967295L));
        }
        HashMap hashMap = vd5Var.E;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry entry : vd5Var.E.entrySet()) {
                a.b((String) entry.getKey(), (String) entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().performance(this.a, a);
    }

    public void c(vd5 vd5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, vd5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || vd5Var.D <= 0) {
            return;
        }
        mh a = xd5.a();
        a.b("action", "time");
        a.b("pct", String.valueOf(vd5Var.D));
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

    public void d(vd5 vd5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, vd5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || vd5Var.B > 0) {
            if (!z && vd5Var.C <= 0) {
                return;
            }
            mh a = xd5.a();
            a.b("action", "time");
            if (z) {
                a.b("put", String.valueOf(vd5Var.B));
            } else {
                a.b("pdt", String.valueOf(vd5Var.C));
            }
            String str2 = "1";
            if (vd5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            a.b("ishttp", str);
            if (!vd5Var.b) {
                str2 = "0";
            }
            a.b("issuccess", str2);
            a.b(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            a.b("qt", String.valueOf(vd5Var.f));
            a.b("connt", String.valueOf(vd5Var.g));
            a.b("rwt", String.valueOf(vd5Var.h));
            a.b("dect", String.valueOf(vd5Var.k));
            a.b("parset", String.valueOf(vd5Var.l));
            a.b("rendert", String.valueOf(vd5Var.o));
            a.b("ss", String.valueOf(vd5Var.q));
            a.b("hs", String.valueOf(vd5Var.r));
            if (vd5Var.s && (i = vd5Var.t) != 0) {
                a.b("salno", String.valueOf(i));
                long j = vd5Var.u;
                if (j != 0) {
                    a.b("scosttime", String.valueOf(j));
                }
            }
            int i2 = vd5Var.v;
            if (i2 != 0) {
                a.c("errcode", Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.a, a);
        }
    }

    public void e(pd5 pd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, pd5Var) != null) || pd5Var == null || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        mh a = xd5.a();
        a.b("action", FpsTracer.UBC_KEY_FLUENCY);
        a.b(FpsConstants.REPORT_FPS, String.valueOf(pd5Var.b()));
        BdStatisticsManager.getInstance().performance(this.a, a);
        mh a2 = xd5.a();
        a2.b("action", "mem");
        a2.b("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
        BdStatisticsManager.getInstance().performance(this.a, a2);
    }
}
