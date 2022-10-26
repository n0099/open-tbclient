package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes6.dex */
public class zz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean d(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) ? obj == null : invokeL.booleanValue;
    }

    public static void h(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, exc) == null) {
        }
    }

    public static boolean a(Map map, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, map, obj)) == null) {
            if (d(map)) {
                return false;
            }
            try {
                return map.containsKey(obj);
            } catch (Exception e) {
                h(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static Object b(Map map, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, map, obj)) == null) {
            if (d(map)) {
                return null;
            }
            try {
                return map.get(obj);
            } catch (Exception e) {
                h(e);
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public static boolean f(Map map, Map map2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, map, map2)) == null) {
            if (d(map)) {
                return false;
            }
            try {
                map.putAll(map2);
                return true;
            } catch (Exception e) {
                h(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static Object g(Map map, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, map, obj)) == null) {
            if (d(map)) {
                return null;
            }
            try {
                return map.remove(obj);
            } catch (Exception e) {
                h(e);
                return null;
            }
        }
        return invokeLL.objValue;
    }

    public static boolean c(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, map)) == null) {
            if (!d(map) && !map.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean e(Map map, Object obj, Object obj2) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, obj, obj2)) == null) {
            if (d(map)) {
                return false;
            }
            try {
                map.put(obj, obj2);
                return true;
            } catch (Exception e) {
                h(e);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
