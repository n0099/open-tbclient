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
public class kp5 extends PerformanceLogger {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public kp5() {
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

    public void a(hp5 hp5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, hp5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time");
        String str2 = "0";
        if (!hp5Var.s) {
            str = "0";
        } else {
            str = "1";
        }
        logItem.append("ishttp", str);
        if (hp5Var.b) {
            str2 = "1";
        }
        logItem.append("issuccess", str2);
        logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        logItem.append("wt", String.valueOf(hp5Var.p));
        logItem.append("qt", String.valueOf(hp5Var.f));
        logItem.append("connt", String.valueOf(hp5Var.g));
        logItem.append("rwt", String.valueOf(hp5Var.h));
        logItem.append("fbt", String.valueOf(hp5Var.i));
        logItem.append("abt", String.valueOf(hp5Var.j));
        logItem.append("dect", String.valueOf(hp5Var.k));
        logItem.append("parset", String.valueOf(hp5Var.l));
        logItem.append("tqt", String.valueOf(hp5Var.n));
        logItem.append("rendert", String.valueOf(hp5Var.o));
        logItem.append("ss", String.valueOf(hp5Var.q));
        logItem.append("hs", String.valueOf(hp5Var.r));
        if (hp5Var.s && (i = hp5Var.t) != 0) {
            logItem.append("salno", String.valueOf(i));
            long j = hp5Var.u;
            if (j != 0) {
                logItem.append("scosttime", String.valueOf(j));
            }
        }
        if (hp5Var.s) {
            logItem.append("hrtn", String.valueOf(hp5Var.w));
            logItem.append("hrtt", String.valueOf(hp5Var.x));
        }
        int i2 = hp5Var.v;
        if (i2 != 0) {
            logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (hp5Var.y) {
            logItem.append("pt", "1");
        } else {
            logItem.append("sysct", String.valueOf(hp5Var.c));
            logItem.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(hp5Var.e));
            logItem.append("lt", String.valueOf(hp5Var.d));
            logItem.append("df", String.valueOf(hp5Var.m));
        }
        if (hp5Var.s) {
            logItem.append("c_logid", String.valueOf(hp5Var.A));
            long j2 = hp5Var.z;
            if (j2 != 0) {
                logItem.append(PushConstants.SEQ_ID, String.valueOf(j2 & 4294967295L));
            }
        } else {
            logItem.append(PushConstants.SEQ_ID, String.valueOf(hp5Var.z & 4294967295L));
        }
        HashMap<String, String> hashMap = hp5Var.E;
        if (hashMap != null && !hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : hp5Var.E.entrySet()) {
                logItem.append(entry.getKey(), entry.getValue());
            }
        }
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
    }

    public void b(hp5 hp5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, hp5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || hp5Var.D <= 0) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time");
        logItem.append("pct", String.valueOf(hp5Var.D));
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

    public void c(hp5 hp5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, hp5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || hp5Var.B > 0) {
            if (!z && hp5Var.C <= 0) {
                return;
            }
            BdStatsItem logItem = PerformanceLogger.getLogItem();
            logItem.append("action", "time");
            if (z) {
                logItem.append("put", String.valueOf(hp5Var.B));
            } else {
                logItem.append("pdt", String.valueOf(hp5Var.C));
            }
            String str2 = "1";
            if (hp5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            logItem.append("ishttp", str);
            if (!hp5Var.b) {
                str2 = "0";
            }
            logItem.append("issuccess", str2);
            logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            logItem.append("qt", String.valueOf(hp5Var.f));
            logItem.append("connt", String.valueOf(hp5Var.g));
            logItem.append("rwt", String.valueOf(hp5Var.h));
            logItem.append("dect", String.valueOf(hp5Var.k));
            logItem.append("parset", String.valueOf(hp5Var.l));
            logItem.append("rendert", String.valueOf(hp5Var.o));
            logItem.append("ss", String.valueOf(hp5Var.q));
            logItem.append("hs", String.valueOf(hp5Var.r));
            if (hp5Var.s && (i = hp5Var.t) != 0) {
                logItem.append("salno", String.valueOf(i));
                long j = hp5Var.u;
                if (j != 0) {
                    logItem.append("scosttime", String.valueOf(j));
                }
            }
            int i2 = hp5Var.v;
            if (i2 != 0) {
                logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.subType, logItem);
        }
    }

    public void d(bp5 bp5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, bp5Var) != null) || bp5Var == null || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", FpsTracer.UBC_KEY_FLUENCY);
        logItem.append(FpsConstants.REPORT_FPS, String.valueOf(bp5Var.b()));
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
        BdStatsItem logItem2 = PerformanceLogger.getLogItem();
        logItem2.append("action", "mem");
        logItem2.append("memp", String.valueOf(PerformanceLoggerHelper.getInstance().getCurrentUsedMemory()));
        BdStatisticsManager.getInstance().performance(this.subType, logItem2);
    }
}
