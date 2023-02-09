package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatistics;
import tv.athena.revenue.RevenueManager;
/* loaded from: classes6.dex */
public class wla {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static IPayEventStatistics a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i, i2)) == null) {
            IRevenue revenue = RevenueManager.instance().getRevenue(i, i2);
            if (revenue == null) {
                RLog.error("UIStatisticReporter", "getSDKReporter error revenue null", new Object[0]);
                return null;
            }
            return revenue.getPayEventStatistic();
        }
        return (IPayEventStatistics) invokeII.objValue;
    }

    public static void b(int i, int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65537, null, i, i2, str) == null) {
            IPayEventStatistics a = a(i, i2);
            if (a == null) {
                RLog.error("UIStatisticReporter", "report error isdkReporter null", new Object[0]);
            } else {
                a.reportUiEvent(str);
            }
        }
    }

    public static void c(int i, int i2, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2}) == null) {
            IPayEventStatistics a = a(i, i2);
            if (a == null) {
                RLog.error("UIStatisticReporter", "report error isdkReporter null", new Object[0]);
            } else {
                a.reportUiEvent(str, str2);
            }
        }
    }

    public static void d(int i, int i2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, str4}) == null) {
            IPayEventStatistics a = a(i, i2);
            if (a == null) {
                RLog.error("UIStatisticReporter", "report error isdkReporter null", new Object[0]);
            } else {
                a.reportUvEvent(str, str2, str3, str4);
            }
        }
    }
}
