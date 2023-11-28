package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Map;
/* loaded from: classes7.dex */
public class ny0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean d(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, obj)) == null) ? obj == null : invokeL.booleanValue;
    }

    public static void i(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65544, null, exc) == null) {
        }
    }

    public static <K, V> boolean a(Map<K, V> map, K k) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, map, k)) == null) {
            if (d(map)) {
                return false;
            }
            try {
                return map.containsKey(k);
            } catch (Exception e) {
                i(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static <K, V> V b(Map<K, V> map, K k) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, map, k)) == null) {
            if (d(map)) {
                return null;
            }
            try {
                return map.get(k);
            } catch (Exception e) {
                i(e);
                return null;
            }
        }
        return (V) invokeLL.objValue;
    }

    public static <K, V> boolean f(Map<K, V> map, Map<? extends K, ? extends V> map2) {
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
                i(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static <K, V> V g(Map<K, V> map, K k) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, map, k)) == null) {
            if (d(map)) {
                return null;
            }
            try {
                return map.remove(k);
            } catch (Exception e) {
                i(e);
                return null;
            }
        }
        return (V) invokeLL.objValue;
    }

    public static <K, V> boolean c(Map<K, V> map) {
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

    public static <K, V> int h(Map<K, V> map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, map)) == null) {
            if (d(map)) {
                return 0;
            }
            return map.size();
        }
        return invokeL.intValue;
    }

    public static <K, V> boolean e(Map<K, V> map, K k, V v) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, map, k, v)) == null) {
            if (d(map)) {
                return false;
            }
            try {
                map.put(k, v);
                return true;
            } catch (Exception e) {
                i(e);
                return false;
            }
        }
        return invokeLLL.booleanValue;
    }
}
