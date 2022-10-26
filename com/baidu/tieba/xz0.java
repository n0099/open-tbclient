package com.baidu.tieba;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class xz0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean f(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65541, null, obj)) == null) ? obj == null : invokeL.booleanValue;
    }

    public static void n(Exception exc) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, null, exc) == null) {
        }
    }

    public static void a(List list, Object obj, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLI(65536, null, list, obj, i) != null) || f(list) || !e(list, i)) {
            return;
        }
        try {
            list.add(i, obj);
        } catch (Exception e) {
            n(e);
        }
    }

    public static boolean b(List list, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, list, obj)) == null) {
            if (f(list)) {
                return false;
            }
            try {
                return list.add(obj);
            } catch (Exception e) {
                n(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void c(Collection collection, Collection collection2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65538, null, collection, collection2) == null) && collection2 != null && collection != null) {
            collection.addAll(collection2);
        }
    }

    public static Object d(List list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, list, i)) == null) {
            if (g(list) || !e(list, i)) {
                return null;
            }
            try {
                return list.get(i);
            } catch (Exception e) {
                n(e);
                return null;
            }
        }
        return invokeLI.objValue;
    }

    public static boolean e(List list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TRACKBALL, null, list, i)) == null) {
            if (f(list) || i < 0) {
                return false;
            }
            try {
                if (i >= list.size()) {
                    return false;
                }
                return true;
            } catch (Exception e) {
                n(e);
                return false;
            }
        }
        return invokeLI.booleanValue;
    }

    public static Object i(List list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65544, null, list, i)) == null) {
            if (g(list) || !e(list, i)) {
                return null;
            }
            try {
                return list.remove(i);
            } catch (Exception e) {
                n(e);
                return null;
            }
        }
        return invokeLI.objValue;
    }

    public static boolean j(List list, Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65545, null, list, obj)) == null) {
            if (g(list)) {
                return false;
            }
            try {
                return list.remove(obj);
            } catch (Exception e) {
                n(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static boolean k(List list, Collection collection) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65546, null, list, collection)) == null) {
            if (f(list)) {
                return false;
            }
            try {
                return list.removeAll(collection);
            } catch (Exception e) {
                Log.e("CollectionUtils", "throw exception when List removeAll");
                n(e);
                return false;
            }
        }
        return invokeLL.booleanValue;
    }

    public static void m(List list, Comparator comparator) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65548, null, list, comparator) != null) || f(list)) {
            return;
        }
        try {
            Collections.sort(list, comparator);
        } catch (Exception e) {
            Log.e("CollectionUtils", "throw exception when List sort");
            n(e);
        }
    }

    public static boolean g(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, list)) == null) {
            if (!f(list) && !list.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean h(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, map)) == null) {
            if (!f(map) && !map.isEmpty()) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int l(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, null, list)) == null) {
            if (!f(list) && !list.isEmpty()) {
                return list.size();
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
