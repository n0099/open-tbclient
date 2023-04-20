package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.SwanAppBaseActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class x23 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948248432, "Lcom/baidu/tieba/x23;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948248432, "Lcom/baidu/tieba/x23;");
                return;
            }
        }
        a = fo1.a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean a(Context context, @NonNull y23 y23Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, y23Var)) == null) {
            if (context instanceof SwanAppBaseActivity) {
                return true;
            }
            y23Var.b(2, "method should be called after setActivityRef");
            if (!a) {
                return false;
            }
            throw new IllegalStateException("this method should be called after setActivityRef");
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(ArrayList<String> arrayList, @NonNull y23 y23Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, arrayList, y23Var)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                return false;
            }
            y23Var.a("permission has already granted");
            return true;
        }
        return invokeLL.booleanValue;
    }

    @NonNull
    public static ArrayList<String> d(@NonNull Context context, @NonNull String[] strArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, context, strArr)) == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            for (String str : strArr) {
                if (!ro4.a(context, str)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static boolean b(@NonNull Context context, @NonNull String str, @NonNull y23 y23Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, y23Var)) == null) {
            if (ro4.a(context, str)) {
                y23Var.a("permission has already granted");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void e(@NonNull String str, @NonNull String[] strArr, int i, @NonNull Context context, @NonNull y23 y23Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65541, null, new Object[]{str, strArr, Integer.valueOf(i), context, y23Var}) != null) || !a(context, y23Var) || b(context, str, y23Var)) {
            return;
        }
        g(context, strArr, i, y23Var);
    }

    @Deprecated
    public static void f(@NonNull Context context, @NonNull String[] strArr, int i, @NonNull y23 y23Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLIL(65542, null, context, strArr, i, y23Var) != null) || !a(context, y23Var)) {
            return;
        }
        ArrayList<String> d = d(context, strArr);
        if (c(d, y23Var)) {
            return;
        }
        ((SwanAppBaseActivity) context).A(i, (String[]) d.toArray(new String[0]), new t23(i, y23Var));
    }

    public static void g(@NonNull Context context, @NonNull String[] strArr, int i, @NonNull y23 y23Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLIL(65543, null, context, strArr, i, y23Var) != null) || !a(context, y23Var)) {
            return;
        }
        ArrayList<String> d = d(context, strArr);
        if (c(d, y23Var)) {
            return;
        }
        ((SwanAppBaseActivity) context).A(i, (String[]) d.toArray(new String[0]), new u23(context, i, y23Var));
    }

    public static void h(@NonNull String[] strArr, int i, @NonNull Context context, @NonNull y23 y23Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65544, null, strArr, i, context, y23Var) != null) || !a(context, y23Var)) {
            return;
        }
        ArrayList<String> d = d(context, strArr);
        if (c(d, y23Var)) {
            return;
        }
        g(context, (String[]) d.toArray(new String[0]), i, y23Var);
    }

    @Deprecated
    public static void requestPermissions(@NonNull String[] strArr, int i, @NonNull Context context, @NonNull y23 y23Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65545, null, strArr, i, context, y23Var) != null) || !a(context, y23Var)) {
            return;
        }
        ArrayList<String> d = d(context, strArr);
        if (c(d, y23Var)) {
            return;
        }
        f(context, (String[]) d.toArray(new String[0]), i, y23Var);
    }
}
