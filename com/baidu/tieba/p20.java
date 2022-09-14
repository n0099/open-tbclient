package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.config.ABTestConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class p20 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a(Object obj, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLZ = interceptable.invokeLZ(65536, null, obj, z)) == null) ? obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z : invokeLZ.booleanValue;
    }

    public static double b(Object obj, double d) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{obj, Double.valueOf(d)})) == null) {
            if (obj != null) {
                try {
                    if (obj instanceof Double) {
                        return ((Double) obj).doubleValue();
                    }
                    if (obj instanceof Number) {
                        return ((Number) obj).doubleValue();
                    }
                    if (obj instanceof String) {
                        return Double.valueOf((String) obj).doubleValue();
                    }
                } catch (NumberFormatException e) {
                    if (ABTestConfig.isDebug()) {
                        throw new ClassCastException("getDoubleSwitch exception " + e);
                    }
                }
            }
            return d;
        }
        return invokeCommon.doubleValue;
    }

    public static int c(Object obj, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, obj, i)) == null) {
            if (obj != null) {
                try {
                    if (obj instanceof Integer) {
                        return ((Integer) obj).intValue();
                    }
                    if (obj instanceof Number) {
                        return ((Number) obj).intValue();
                    }
                    if (obj instanceof String) {
                        return Integer.parseInt((String) obj);
                    }
                } catch (NumberFormatException e) {
                    if (ABTestConfig.isDebug()) {
                        throw new ClassCastException("getIntSwitch exception " + e);
                    }
                }
            }
            return i;
        }
        return invokeLI.intValue;
    }

    public static int d(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                return Integer.parseInt(str);
            } catch (Exception unused) {
                return 0;
            }
        }
        return invokeL.intValue;
    }

    public static long e(Object obj, long j) {
        InterceptResult invokeLJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLJ = interceptable.invokeLJ(InputDeviceCompat.SOURCE_TRACKBALL, null, obj, j)) == null) {
            if (obj != null) {
                try {
                    if (obj instanceof Long) {
                        return ((Long) obj).longValue();
                    }
                    if (obj instanceof Number) {
                        return ((Number) obj).longValue();
                    }
                    if (obj instanceof String) {
                        return (long) Double.parseDouble((String) obj);
                    }
                } catch (NumberFormatException e) {
                    if (ABTestConfig.isDebug()) {
                        throw new ClassCastException("getLongSwitch exception " + e);
                    }
                }
            }
            return j;
        }
        return invokeLJ.longValue;
    }

    public static String f(Object obj, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, obj, str)) == null) ? obj != null ? String.valueOf(obj) : str : (String) invokeLL.objValue;
    }
}
