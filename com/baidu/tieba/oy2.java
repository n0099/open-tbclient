package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class oy2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948048513, "Lcom/baidu/tieba/oy2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948048513, "Lcom/baidu/tieba/oy2;");
                return;
            }
        }
        a = wj1.a;
    }

    public static boolean a(Context context, py2 py2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, py2Var)) == null) {
            if (context instanceof SwanAppBaseActivity) {
                return true;
            }
            py2Var.b(2, "method should be called after setActivityRef");
            if (!a) {
                return false;
            }
            throw new IllegalStateException("this method should be called after setActivityRef");
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(ArrayList arrayList, py2 py2Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, arrayList, py2Var)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                return false;
            }
            py2Var.a("permission has already granted");
            return true;
        }
        return invokeLL.booleanValue;
    }

    public static ArrayList d(Context context, String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, strArr)) == null) {
            ArrayList arrayList = new ArrayList();
            for (String str : strArr) {
                if (!ik4.a(context, str)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static boolean b(Context context, String str, py2 py2Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, py2Var)) == null) {
            if (ik4.a(context, str)) {
                py2Var.a("permission has already granted");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void e(String str, String[] strArr, int i, Context context, py2 py2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65541, null, new Object[]{str, strArr, Integer.valueOf(i), context, py2Var}) != null) || !a(context, py2Var) || b(context, str, py2Var)) {
            return;
        }
        g(context, strArr, i, py2Var);
    }

    @Deprecated
    public static void f(Context context, String[] strArr, int i, py2 py2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLIL(65542, null, context, strArr, i, py2Var) != null) || !a(context, py2Var)) {
            return;
        }
        ArrayList d = d(context, strArr);
        if (c(d, py2Var)) {
            return;
        }
        ((SwanAppBaseActivity) context).y(i, (String[]) d.toArray(new String[0]), new ky2(i, py2Var));
    }

    public static void g(Context context, String[] strArr, int i, py2 py2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLIL(65543, null, context, strArr, i, py2Var) != null) || !a(context, py2Var)) {
            return;
        }
        ArrayList d = d(context, strArr);
        if (c(d, py2Var)) {
            return;
        }
        ((SwanAppBaseActivity) context).y(i, (String[]) d.toArray(new String[0]), new ly2(context, i, py2Var));
    }

    public static void h(String[] strArr, int i, Context context, py2 py2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65544, null, strArr, i, context, py2Var) != null) || !a(context, py2Var)) {
            return;
        }
        ArrayList d = d(context, strArr);
        if (c(d, py2Var)) {
            return;
        }
        g(context, (String[]) d.toArray(new String[0]), i, py2Var);
    }

    @Deprecated
    public static void requestPermissions(String[] strArr, int i, Context context, py2 py2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65545, null, strArr, i, context, py2Var) != null) || !a(context, py2Var)) {
            return;
        }
        ArrayList d = d(context, strArr);
        if (c(d, py2Var)) {
            return;
        }
        f(context, (String[]) d.toArray(new String[0]), i, py2Var);
    }
}
