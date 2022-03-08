package com.baidu.wallet.core.lollipop.json;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class JSON {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public JSON() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static double checkDouble(double d2) throws JSONException {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65537, null, new Object[]{Double.valueOf(d2)})) == null) {
            if (Double.isInfinite(d2) || Double.isNaN(d2)) {
                throw new JSONException("Forbidden numeric value: " + d2);
            }
            return d2;
        }
        return invokeCommon.doubleValue;
    }

    public static Boolean toBoolean(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, obj)) == null) {
            if (obj instanceof Boolean) {
                return (Boolean) obj;
            }
            if (obj instanceof String) {
                String str = (String) obj;
                if ("true".equalsIgnoreCase(str)) {
                    return Boolean.TRUE;
                }
                if ("false".equalsIgnoreCase(str)) {
                    return Boolean.FALSE;
                }
                return null;
            }
            return null;
        }
        return (Boolean) invokeL.objValue;
    }

    public static Double toDouble(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) {
            if (obj instanceof Double) {
                return (Double) obj;
            }
            if (obj instanceof Number) {
                return Double.valueOf(((Number) obj).doubleValue());
            }
            if (obj instanceof String) {
                try {
                    return Double.valueOf((String) obj);
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            return null;
        }
        return (Double) invokeL.objValue;
    }

    public static Integer toInteger(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, obj)) == null) {
            if (obj instanceof Integer) {
                return (Integer) obj;
            }
            if (obj instanceof Number) {
                return Integer.valueOf(((Number) obj).intValue());
            }
            if (obj instanceof String) {
                try {
                    return Integer.valueOf((int) Double.parseDouble((String) obj));
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            return null;
        }
        return (Integer) invokeL.objValue;
    }

    public static Long toLong(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) {
            if (obj instanceof Long) {
                return (Long) obj;
            }
            if (obj instanceof Number) {
                return Long.valueOf(((Number) obj).longValue());
            }
            if (obj instanceof String) {
                try {
                    return Long.valueOf((long) Double.parseDouble((String) obj));
                } catch (NumberFormatException unused) {
                    return null;
                }
            }
            return null;
        }
        return (Long) invokeL.objValue;
    }

    public static String toString(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, obj)) == null) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj != null) {
                return String.valueOf(obj);
            }
            return null;
        }
        return (String) invokeL.objValue;
    }

    public static JSONException typeMismatch(Object obj, Object obj2, String str) throws JSONException {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65543, null, obj, obj2, str)) == null) {
            if (obj2 == null) {
                throw new JSONException("Value at " + obj + " is null.");
            }
            throw new JSONException("Value " + obj2 + " at " + obj + " of type " + obj2.getClass().getName() + " cannot be converted to " + str);
        }
        return (JSONException) invokeLLL.objValue;
    }

    public static JSONException typeMismatch(Object obj, String str) throws JSONException {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65544, null, obj, str)) == null) {
            if (obj == null) {
                throw new JSONException("Value is null.");
            }
            throw new JSONException("Value " + obj + " of type " + obj.getClass().getName() + " cannot be converted to " + str);
        }
        return (JSONException) invokeLL.objValue;
    }
}
