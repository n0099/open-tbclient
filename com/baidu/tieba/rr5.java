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
public class rr5 extends xr5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public rr5() {
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

    @Override // com.baidu.tieba.xr5
    public void a(ur5 ur5Var) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, ur5Var) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time_t");
        e(logItem, ur5Var);
        String str2 = "1";
        if (ur5Var.s) {
            str = "1";
        } else {
            str = "0";
        }
        logItem.append("ishttp", str);
        if (!ur5Var.b) {
            str2 = "0";
        }
        logItem.append("issuccess", str2);
        logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
        logItem.append(Config.EXCEPTION_CRASH_TYPE, String.valueOf(ur5Var.e));
        logItem.append("wt", String.valueOf(ur5Var.p));
        logItem.append("qt", String.valueOf(ur5Var.f));
        logItem.append("connt", String.valueOf(ur5Var.g));
        logItem.append("rwt", String.valueOf(ur5Var.h));
        logItem.append("dect", String.valueOf(ur5Var.k));
        logItem.append("parset", String.valueOf(ur5Var.l));
        logItem.append("rendert", String.valueOf(ur5Var.o));
        logItem.append("ss", String.valueOf(ur5Var.q));
        logItem.append("hs", String.valueOf(ur5Var.r));
        if (ur5Var.s && (i = ur5Var.t) != 0) {
            logItem.append("salno", String.valueOf(i));
            long j = ur5Var.u;
            if (j != 0) {
                logItem.append("scosttime", String.valueOf(j));
            }
        }
        int i2 = ur5Var.v;
        if (i2 != 0) {
            logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
        }
        if (ur5Var.s) {
            logItem.append("c_logid", String.valueOf(ur5Var.A));
        } else {
            logItem.append(PushConstants.SEQ_ID, String.valueOf(ur5Var.z & 4294967295L));
        }
        BdStatisticsManager.getInstance().performance(this.subType, logItem);
    }

    @Override // com.baidu.tieba.xr5
    public void b(ur5 ur5Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ur5Var, i) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow() || ur5Var.D <= 0) {
            return;
        }
        BdStatsItem logItem = PerformanceLogger.getLogItem();
        logItem.append("action", "time_t");
        e(logItem, ur5Var);
        logItem.append("pct", String.valueOf(ur5Var.D));
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

    @Override // com.baidu.tieba.xr5
    public void c(ur5 ur5Var, boolean z) {
        String str;
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, ur5Var, z) != null) || !PerformanceLoggerHelper.getInstance().isSmallFlow()) {
            return;
        }
        if (!z || ur5Var.B > 0) {
            if (!z && ur5Var.C <= 0) {
                return;
            }
            BdStatsItem logItem = PerformanceLogger.getLogItem();
            logItem.append("action", "time_t");
            e(logItem, ur5Var);
            if (z) {
                logItem.append("put", String.valueOf(ur5Var.B));
            } else {
                logItem.append("pdt", String.valueOf(ur5Var.C));
            }
            String str2 = "1";
            if (ur5Var.s) {
                str = "1";
            } else {
                str = "0";
            }
            logItem.append("ishttp", str);
            if (!ur5Var.b) {
                str2 = "0";
            }
            logItem.append("issuccess", str2);
            logItem.append(FpsTracer.UBC_KEY_NET_TYPE, PerformanceLoggerHelper.getInstance().getNetType());
            logItem.append("qt", String.valueOf(ur5Var.f));
            logItem.append("connt", String.valueOf(ur5Var.g));
            logItem.append("rwt", String.valueOf(ur5Var.h));
            logItem.append("dect", String.valueOf(ur5Var.k));
            logItem.append("parset", String.valueOf(ur5Var.l));
            logItem.append("rendert", String.valueOf(ur5Var.o));
            logItem.append("ss", String.valueOf(ur5Var.q));
            logItem.append("hs", String.valueOf(ur5Var.r));
            if (ur5Var.s && (i = ur5Var.t) != 0) {
                logItem.append("salno", String.valueOf(i));
                long j = ur5Var.u;
                if (j != 0) {
                    logItem.append("scosttime", String.valueOf(j));
                }
            }
            int i2 = ur5Var.v;
            if (i2 != 0) {
                logItem.append(DownloadConstants.DOWNLOAD_FEEDBACK_EXTRA_KEY_ERR_CODE, Integer.valueOf(i2));
            }
            BdStatisticsManager.getInstance().performance(this.subType, logItem);
        }
    }

    public final void e(BdStatsItem bdStatsItem, ur5 ur5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, bdStatsItem, ur5Var) == null) && (ur5Var instanceof qr5)) {
            bdStatsItem.append("ptype", Integer.valueOf(((qr5) ur5Var).F));
        }
    }
}
