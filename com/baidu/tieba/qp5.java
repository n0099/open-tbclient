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
public class qp5 extends wp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public qp5() {
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

    @Override // com.baidu.tieba.wp5
    public void a(tp5 tp5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, tp5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time_t");
        e(logItem, tp5Var);
        String str2 = "1";
        if (tp5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        logItem.append("ishttp", str);
        if (!tp5Var.b) {
            str2 = "0";
        }
        logItem.append("issuccess", str2);
        logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        logItem.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(tp5Var.e));
        logItem.append("wt", String.valueOf(tp5Var.p));
        logItem.append("qt", String.valueOf(tp5Var.f));
        logItem.append("connt", String.valueOf(tp5Var.g));
        logItem.append("rwt", String.valueOf(tp5Var.h));
        logItem.append("dect", String.valueOf(tp5Var.k));
        logItem.append("parset", String.valueOf(tp5Var.l));
        logItem.append("rendert", String.valueOf(tp5Var.o));
        logItem.append("ss", String.valueOf(tp5Var.q));
        logItem.append("hs", String.valueOf(tp5Var.r));
        if (tp5Var.s && (i = tp5Var.t) != 0) {
            logItem.append("salno", String.valueOf(i));
            long j = tp5Var.u;
            if (j != 0) {
                logItem.append("scosttime", String.valueOf(j));
            }
        }
        int i2 = tp5Var.v;
        if (i2 != 0) {
            logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (tp5Var.s) {
            logItem.append("c_logid", String.valueOf(tp5Var.A));
        } else {
            logItem.append(PushConstants.SEQ_ID, String.valueOf(tp5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
    }

    @Override // com.baidu.tieba.wp5
    public void b(tp5 tp5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tp5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || tp5Var.D <= 0) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time_t");
        e(logItem, tp5Var);
        logItem.append("pct", String.valueOf(tp5Var.D));
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

    @Override // com.baidu.tieba.wp5
    public void c(tp5 tp5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, tp5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || tp5Var.B > 0) {
            if (!z && tp5Var.C <= 0) {
                return;
            }
            BdStatsItem logItem = PerformanceLogger.getLogItem();
            logItem.append("action", "time_t");
            e(logItem, tp5Var);
            if (z) {
                logItem.append("put", String.valueOf(tp5Var.B));
            } else {
                logItem.append("pdt", String.valueOf(tp5Var.C));
            }
            String str2 = "1";
            if (tp5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            logItem.append("ishttp", str);
            if (!tp5Var.b) {
                str2 = "0";
            }
            logItem.append("issuccess", str2);
            logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            logItem.append("qt", String.valueOf(tp5Var.f));
            logItem.append("connt", String.valueOf(tp5Var.g));
            logItem.append("rwt", String.valueOf(tp5Var.h));
            logItem.append("dect", String.valueOf(tp5Var.k));
            logItem.append("parset", String.valueOf(tp5Var.l));
            logItem.append("rendert", String.valueOf(tp5Var.o));
            logItem.append("ss", String.valueOf(tp5Var.q));
            logItem.append("hs", String.valueOf(tp5Var.r));
            if (tp5Var.s && (i = tp5Var.t) != 0) {
                logItem.append("salno", String.valueOf(i));
                long j = tp5Var.u;
                if (j != 0) {
                    logItem.append("scosttime", String.valueOf(j));
                }
            }
            int i2 = tp5Var.v;
            if (i2 != 0) {
                logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.subType, logItem);
        }
    }

    public final void e(BdStatsItem bdStatsItem, tp5 tp5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, bdStatsItem, tp5Var) == null) && (tp5Var instanceof pp5)) {
            bdStatsItem.append("ptype", Integer.valueOf(((pp5) tp5Var).F));
        }
    }
}
