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
/* loaded from: classes7.dex */
public class pn5 extends PerformanceLogger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public pn5() {
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

    public void a(mn5 mn5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, mn5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time");
        String str2 = "0";
        if (!mn5Var.s) {
            str = "0";
        } else {
            str = "1";
        }
        logItem.append("ishttp", str);
        if (mn5Var.b) {
            str2 = "1";
        }
        logItem.append("issuccess", str2);
        logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        logItem.append("wt", String.valueOf(mn5Var.p));
        logItem.append("qt", String.valueOf(mn5Var.f));
        logItem.append("connt", String.valueOf(mn5Var.g));
        logItem.append("rwt", String.valueOf(mn5Var.h));
        logItem.append("fbt", String.valueOf(mn5Var.i));
        logItem.append("abt", String.valueOf(mn5Var.j));
        logItem.append("dect", String.valueOf(mn5Var.k));
        logItem.append("parset", String.valueOf(mn5Var.l));
        logItem.append("tqt", String.valueOf(mn5Var.n));
        logItem.append("rendert", String.valueOf(mn5Var.o));
        logItem.append("ss", String.valueOf(mn5Var.q));
        logItem.append("hs", String.valueOf(mn5Var.r));
        if (mn5Var.s && (i = mn5Var.t) != 0) {
            logItem.append("salno", String.valueOf(i));
            long j = mn5Var.u;
            if (j != 0) {
                logItem.append("scosttime", String.valueOf(j));
            }
        }
        if (mn5Var.s) {
            logItem.append("hrtn", String.valueOf(mn5Var.w));
            logItem.append("hrtt", String.valueOf(mn5Var.x));
        }
        int i2 = mn5Var.v;
        if (i2 != 0) {
            logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (mn5Var.y) {
            logItem.append("pt", "1");
        } else {
            logItem.append("sysct", String.valueOf(mn5Var.c));
            logItem.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(mn5Var.e));
            logItem.append("lt", String.valueOf(mn5Var.d));
            logItem.append("df", String.valueOf(mn5Var.m));
        }
        if (mn5Var.s) {
            logItem.append("c_logid", String.valueOf(mn5Var.A));
            long j2 = mn5Var.z;
            if (j2 != 0) {
                logItem.append(PushConstants.SEQ_ID, String.valueOf(j2 & 4294967295L));
            }
        } else {
            logItem.append(PushConstants.SEQ_ID, String.valueOf(mn5Var.z & 4294967295L));
        }
        HashMap<String, String> hashMap = mn5Var.E;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : mn5Var.E.entrySet()) {
                logItem.append(entry.getKey(), entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
    }

    public void b(mn5 mn5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mn5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || mn5Var.D <= 0) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time");
        logItem.append("pct", String.valueOf(mn5Var.D));
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

    public void c(mn5 mn5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, mn5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || mn5Var.B > 0) {
            if (!z && mn5Var.C <= 0) {
                return;
            }
            BdStatsItem logItem = PerformanceLogger.getLogItem();
            logItem.append("action", "time");
            if (z) {
                logItem.append("put", String.valueOf(mn5Var.B));
            } else {
                logItem.append("pdt", String.valueOf(mn5Var.C));
            }
            String str2 = "1";
            if (mn5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            logItem.append("ishttp", str);
            if (!mn5Var.b) {
                str2 = "0";
            }
            logItem.append("issuccess", str2);
            logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            logItem.append("qt", String.valueOf(mn5Var.f));
            logItem.append("connt", String.valueOf(mn5Var.g));
            logItem.append("rwt", String.valueOf(mn5Var.h));
            logItem.append("dect", String.valueOf(mn5Var.k));
            logItem.append("parset", String.valueOf(mn5Var.l));
            logItem.append("rendert", String.valueOf(mn5Var.o));
            logItem.append("ss", String.valueOf(mn5Var.q));
            logItem.append("hs", String.valueOf(mn5Var.r));
            if (mn5Var.s && (i = mn5Var.t) != 0) {
                logItem.append("salno", String.valueOf(i));
                long j = mn5Var.u;
                if (j != 0) {
                    logItem.append("scosttime", String.valueOf(j));
                }
            }
            int i2 = mn5Var.v;
            if (i2 != 0) {
                logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.subType, logItem);
        }
    }

    public void d(gn5 gn5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, gn5Var) != null) || gn5Var == null || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", FpsTracer.UBC_KEY_FLUENCY);
        logItem.append(FpsConstants.REPORT_FPS, String.valueOf(gn5Var.b()));
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
        BdStatsItem logItem2 = PerformanceLogger.getLogItem();
        logItem2.append("action", "mem");
        logItem2.append("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
        BdStatisticsManager.getInstance().performance(this.subType, logItem2);
    }
}
