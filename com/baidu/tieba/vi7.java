package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class vi7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean h(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65543, null, obj)) == null) ? obj == null : invokeL.booleanValue;
    }

    public static <T> void a(List<T> list, T t) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, list, t) != null) || h(list)) {
            return;
        }
        try {
            list.add(t);
        } catch (Exception e) {
            BdLog.e(e);
            j(e);
        }
    }

    public static <T> T d(List<T> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65539, null, list, i)) == null) {
            if (e(list) || !g(list, i)) {
                return null;
            }
            try {
                return list.get(i);
            } catch (Exception e) {
                BdLog.e(e);
                j(e);
                return null;
            }
        }
        return (T) invokeLI.objValue;
    }

    public static boolean g(List list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65542, null, list, i)) == null) {
            if (h(list) || i < 0 || i >= list.size()) {
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static <T> void b(List<T> list, T t, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(65537, null, list, t, i) == null) && !h(list) && i >= 0 && i <= list.size()) {
            try {
                list.add(i, t);
            } catch (Exception e) {
                BdLog.e(e);
                j(e);
            }
        }
    }

    public static void c(List list) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65538, null, list) != null) || e(list)) {
            return;
        }
        try {
            list.clear();
        } catch (Exception e) {
            BdLog.e(e);
            j(e);
        }
    }

    public static boolean e(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, list)) == null) {
            if (!h(list) && !list.isEmpty()) {
                return false;
            }
            BdLog.e("list is empty");
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(Map map) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, map)) == null) {
            if (!h(map) && !map.isEmpty()) {
                return false;
            }
            BdLog.e("map is empty");
            return true;
        }
        return invokeL.booleanValue;
    }

    public static int i(List list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, list)) == null) {
            if (!h(list) && !list.isEmpty()) {
                try {
                    return list.size();
                } catch (Exception e) {
                    BdLog.e(e);
                    j(e);
                }
            }
            return 0;
        }
        return invokeL.intValue;
    }

    public static void j(Exception exc) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65545, null, exc) == null) && BdBaseApplication.getInst().isDebugMode() && (exc instanceof RuntimeException)) {
            throw ((RuntimeException) exc);
        }
    }
}
