package com.baidu.tieba;

import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.log.NetLog;
import com.baidu.searchbox.fluency.tracer.FpsTracer;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rh {
    public static /* synthetic */ Interceptable $ic = null;
    public static String a = "net_work_http_log";
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1448315959, "Lcom/baidu/tieba/rh;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1448315959, "Lcom/baidu/tieba/rh;");
        }
    }

    public static void a(String str, int i, String str2, boolean z, boolean z2, long j, long j2, long j3, long j4, long j5, int i2) {
        String str3;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), str2, Boolean.valueOf(z), Boolean.valueOf(z2), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j3), Long.valueOf(j4), Long.valueOf(j5), Integer.valueOf(i2)}) != null) || !BdBaseApplication.getInst().isSmallFlow()) {
            return;
        }
        ch statsItem = BdStatisticsManager.getInstance().getStatsItem("pfmonitor");
        statsItem.b("action", "network_monitor_a");
        statsItem.b("cmd", String.valueOf(i));
        statsItem.b("url", str2);
        String str4 = "1";
        if (z) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        statsItem.b("issuccess", str3);
        if (!z2) {
            str4 = "0";
        }
        statsItem.b("ishttp", str4);
        statsItem.b(FpsTracer.UBC_KEY_NET_TYPE, BdNetTypeUtil.getNetType());
        statsItem.b("connt", String.valueOf(j));
        statsItem.b("rwt", String.valueOf(j2));
        statsItem.b("parset", String.valueOf(j3));
        statsItem.b("fbt", String.valueOf(j4));
        statsItem.b("abt", String.valueOf(j5));
        statsItem.b("salno", String.valueOf(i2));
        NetLog.getInstance().c(a, statsItem.toString());
        BdStatisticsManager.getInstance().performance(str, statsItem);
    }
}
