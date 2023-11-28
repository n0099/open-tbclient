package com.baidu.tieba;

import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatsItem;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.downloads.DownloadConstants;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.tbadk.performanceLog.PerformanceLogger;
import com.baidu.tbadk.performanceLog.PerformanceLoggerHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.meizu.cloud.pushsdk.constants.PushConstants;
/* loaded from: classes7.dex */
public class mp5 extends sp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public mp5() {
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

    @Override // com.baidu.tieba.sp5
    public void a(pp5 pp5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, pp5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time_t");
        e(logItem, pp5Var);
        String str2 = "1";
        if (pp5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        logItem.append("ishttp", str);
        if (!pp5Var.b) {
            str2 = "0";
        }
        logItem.append("issuccess", str2);
        logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        logItem.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(pp5Var.e));
        logItem.append("wt", String.valueOf(pp5Var.p));
        logItem.append("qt", String.valueOf(pp5Var.f));
        logItem.append("connt", String.valueOf(pp5Var.g));
        logItem.append("rwt", String.valueOf(pp5Var.h));
        logItem.append("dect", String.valueOf(pp5Var.k));
        logItem.append("parset", String.valueOf(pp5Var.l));
        logItem.append("rendert", String.valueOf(pp5Var.o));
        logItem.append("ss", String.valueOf(pp5Var.q));
        logItem.append("hs", String.valueOf(pp5Var.r));
        if (pp5Var.s && (i = pp5Var.t) != 0) {
            logItem.append("salno", String.valueOf(i));
            long j = pp5Var.u;
            if (j != 0) {
                logItem.append("scosttime", String.valueOf(j));
            }
        }
        int i2 = pp5Var.v;
        if (i2 != 0) {
            logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (pp5Var.s) {
            logItem.append("c_logid", String.valueOf(pp5Var.A));
        } else {
            logItem.append(PushConstants.SEQ_ID, String.valueOf(pp5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
    }

    @Override // com.baidu.tieba.sp5
    public void b(pp5 pp5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, pp5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || pp5Var.D <= 0) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time_t");
        e(logItem, pp5Var);
        logItem.append("pct", String.valueOf(pp5Var.D));
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

    @Override // com.baidu.tieba.sp5
    public void c(pp5 pp5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, pp5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || pp5Var.B > 0) {
            if (!z && pp5Var.C <= 0) {
                return;
            }
            BdStatsItem logItem = PerformanceLogger.getLogItem();
            logItem.append("action", "time_t");
            e(logItem, pp5Var);
            if (z) {
                logItem.append("put", String.valueOf(pp5Var.B));
            } else {
                logItem.append("pdt", String.valueOf(pp5Var.C));
            }
            String str2 = "1";
            if (pp5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            logItem.append("ishttp", str);
            if (!pp5Var.b) {
                str2 = "0";
            }
            logItem.append("issuccess", str2);
            logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            logItem.append("qt", String.valueOf(pp5Var.f));
            logItem.append("connt", String.valueOf(pp5Var.g));
            logItem.append("rwt", String.valueOf(pp5Var.h));
            logItem.append("dect", String.valueOf(pp5Var.k));
            logItem.append("parset", String.valueOf(pp5Var.l));
            logItem.append("rendert", String.valueOf(pp5Var.o));
            logItem.append("ss", String.valueOf(pp5Var.q));
            logItem.append("hs", String.valueOf(pp5Var.r));
            if (pp5Var.s && (i = pp5Var.t) != 0) {
                logItem.append("salno", String.valueOf(i));
                long j = pp5Var.u;
                if (j != 0) {
                    logItem.append("scosttime", String.valueOf(j));
                }
            }
            int i2 = pp5Var.v;
            if (i2 != 0) {
                logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.subType, logItem);
        }
    }

    public final void e(BdStatsItem bdStatsItem, pp5 pp5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, bdStatsItem, pp5Var) == null) && (pp5Var instanceof lp5)) {
            bdStatsItem.append("ptype", Integer.valueOf(((lp5) pp5Var).F));
        }
    }
}
