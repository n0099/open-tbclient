package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.searchbox.fluency.utils.FpsConstants;
import com.baidu.tbadk.performanceLog.PerformanceLogger;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class it5 extends PerformanceLogger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public it5() {
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

    public void a(ft5 ft5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ft5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time");
        String str2 = "0";
        if (!ft5Var.s) {
            str = "0";
        } else {
            str = "1";
        }
        logItem.append("ishttp", str);
        if (ft5Var.b) {
            str2 = "1";
        }
        logItem.append("issuccess", str2);
        logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        logItem.append("wt", String.valueOf(ft5Var.p));
        logItem.append("qt", String.valueOf(ft5Var.f));
        logItem.append("connt", String.valueOf(ft5Var.g));
        logItem.append("rwt", String.valueOf(ft5Var.h));
        logItem.append("fbt", String.valueOf(ft5Var.i));
        logItem.append("abt", String.valueOf(ft5Var.j));
        logItem.append("dect", String.valueOf(ft5Var.k));
        logItem.append("parset", String.valueOf(ft5Var.l));
        logItem.append("tqt", String.valueOf(ft5Var.n));
        logItem.append("rendert", String.valueOf(ft5Var.o));
        logItem.append("ss", String.valueOf(ft5Var.q));
        logItem.append("hs", String.valueOf(ft5Var.r));
        if (ft5Var.s && (i = ft5Var.t) != 0) {
            logItem.append("salno", String.valueOf(i));
            long j = ft5Var.u;
            if (j != 0) {
                logItem.append("scosttime", String.valueOf(j));
            }
        }
        if (ft5Var.s) {
            logItem.append("hrtn", String.valueOf(ft5Var.w));
            logItem.append("hrtt", String.valueOf(ft5Var.x));
        }
        int i2 = ft5Var.v;
        if (i2 != 0) {
            logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (ft5Var.y) {
            logItem.append("pt", "1");
        } else {
            logItem.append("sysct", String.valueOf(ft5Var.c));
            logItem.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(ft5Var.e));
            logItem.append("lt", String.valueOf(ft5Var.d));
            logItem.append("df", String.valueOf(ft5Var.m));
        }
        if (ft5Var.s) {
            logItem.append("c_logid", String.valueOf(ft5Var.A));
            long j2 = ft5Var.z;
            if (j2 != 0) {
                logItem.append(PushConstants.SEQ_ID, String.valueOf(j2 & 4294967295L));
            }
        } else {
            logItem.append(PushConstants.SEQ_ID, String.valueOf(ft5Var.z & 4294967295L));
        }
        HashMap<String, String> hashMap = ft5Var.E;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : ft5Var.E.entrySet()) {
                logItem.append(entry.getKey(), entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
    }

    public void b(ft5 ft5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ft5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || ft5Var.D <= 0) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time");
        logItem.append("pct", String.valueOf(ft5Var.D));
        if (i != 0) {
            if (i != 40) {
                return;
            }
            logItem.append("pct_type", String.valueOf(101));
        } else {
            logItem.append("pct_type", String.valueOf(100));
        }
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
    }

    public void c(ft5 ft5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, ft5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || ft5Var.B > 0) {
            if (!z && ft5Var.C <= 0) {
                return;
            }
            BdStatsItem logItem = PerformanceLogger.getLogItem();
            logItem.append("action", "time");
            if (z) {
                logItem.append("put", String.valueOf(ft5Var.B));
            } else {
                logItem.append("pdt", String.valueOf(ft5Var.C));
            }
            String str2 = "1";
            if (ft5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            logItem.append("ishttp", str);
            if (!ft5Var.b) {
                str2 = "0";
            }
            logItem.append("issuccess", str2);
            logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            logItem.append("qt", String.valueOf(ft5Var.f));
            logItem.append("connt", String.valueOf(ft5Var.g));
            logItem.append("rwt", String.valueOf(ft5Var.h));
            logItem.append("dect", String.valueOf(ft5Var.k));
            logItem.append("parset", String.valueOf(ft5Var.l));
            logItem.append("rendert", String.valueOf(ft5Var.o));
            logItem.append("ss", String.valueOf(ft5Var.q));
            logItem.append("hs", String.valueOf(ft5Var.r));
            if (ft5Var.s && (i = ft5Var.t) != 0) {
                logItem.append("salno", String.valueOf(i));
                long j = ft5Var.u;
                if (j != 0) {
                    logItem.append("scosttime", String.valueOf(j));
                }
            }
            int i2 = ft5Var.v;
            if (i2 != 0) {
                logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.subType, logItem);
        }
    }

    public void d(zs5 zs5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, zs5Var) != null) || zs5Var == null || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", FpsTracer.UBC_KEY_FLUENCY);
        logItem.append(FpsConstants.REPORT_FPS, String.valueOf(zs5Var.b()));
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
        BdStatsItem logItem2 = PerformanceLogger.getLogItem();
        logItem2.append("action", "mem");
        logItem2.append("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
        BdStatisticsManager.getInstance().performance(this.subType, logItem2);
    }
}
