package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.huawei.hms.framework.common.StringUtils;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import java.text.DecimalFormat;
/* loaded from: classes5.dex */
public class lva {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a(double d) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Double.valueOf(d)})) == null) {
            long j = (long) d;
            if (d == j) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return String.valueOf(j);
            }
            return new DecimalFormat("#.##").format(d);
        }
        return (String) invokeCommon.objValue;
    }

    public static String b(double d) {
        InterceptResult invokeCommon;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d)})) == null) {
            long j = (long) d;
            if (d == j) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return String.valueOf(j);
            }
            return new DecimalFormat("#.#").format(d);
        }
        return (String) invokeCommon.objValue;
    }

    public static double c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return 0.0d;
            }
            try {
                return Double.valueOf(str).doubleValue();
            } catch (Throwable unused) {
                RLog.error(StringUtils.TAG, "safeParseDouble " + str, new Object[0]);
                return 0.0d;
            }
        }
        return invokeL.doubleValue;
    }

    public static long d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null || str.length() == 0) {
                return 0L;
            }
            try {
                return Long.valueOf(str).longValue();
            } catch (Throwable unused) {
                RLog.error(StringUtils.TAG, "safeParseLong " + str, new Object[0]);
                return 0L;
            }
        }
        return invokeL.longValue;
    }
}
