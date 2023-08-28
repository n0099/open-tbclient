package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IPayEventStatisticsApi;
import tv.athena.revenue.RevenueManager;
/* loaded from: classes9.dex */
public class zfc {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static IPayEventStatisticsApi a(int i, int i2) {
        InterceptResult invokeII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeII = interceptable.invokeII(65536, null, i, i2)) == null) {
            IRevenue revenue = RevenueManager.instance().getRevenue(i, i2);
            if (revenue == null) {
                RLog.error("PayUVEventStatisticsUtil", "getPayEventStatisticsApi error revenue null", new Object[0]);
                return null;
            }
            return revenue.getPayEventStatisticApi();
        }
        return (IPayEventStatisticsApi) invokeII.objValue;
    }

    public static void b(int i, int i2, String str, String str2, String str3, String str4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, str2, str3, str4}) == null) {
            IPayEventStatisticsApi a = a(i, i2);
            if (a == null) {
                RLog.error("PayUVEventStatisticsUtil", "report error payEventStatisticsApi null", new Object[0]);
            } else {
                a.reportUvEvent(str, str2, str3, str4);
            }
        }
    }
}
