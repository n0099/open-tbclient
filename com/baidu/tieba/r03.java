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
/* loaded from: classes7.dex */
public class r03 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948067764, "Lcom/baidu/tieba/r03;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948067764, "Lcom/baidu/tieba/r03;");
                return;
            }
        }
        a = am1.a;
    }

    @SuppressLint({"BDThrowableCheck"})
    public static boolean a(Context context, @NonNull s03 s03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, context, s03Var)) == null) {
            if (context instanceof SwanAppBaseActivity) {
                return true;
            }
            s03Var.b(2, "method should be called after setActivityRef");
            if (!a) {
                return false;
            }
            throw new IllegalStateException("this method should be called after setActivityRef");
        }
        return invokeLL.booleanValue;
    }

    public static boolean c(ArrayList<String> arrayList, @NonNull s03 s03Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, arrayList, s03Var)) == null) {
            if (arrayList != null && !arrayList.isEmpty()) {
                return false;
            }
            s03Var.a("permission has already granted");
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
                if (!km4.a(context, str)) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLL.objValue;
    }

    public static boolean b(@NonNull Context context, @NonNull String str, @NonNull s03 s03Var) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, context, str, s03Var)) == null) {
            if (km4.a(context, str)) {
                s03Var.a("permission has already granted");
                return true;
            }
            return false;
        }
        return invokeLLL.booleanValue;
    }

    public static void e(@NonNull String str, @NonNull String[] strArr, int i, @NonNull Context context, @NonNull s03 s03Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65541, null, new Object[]{str, strArr, Integer.valueOf(i), context, s03Var}) != null) || !a(context, s03Var) || b(context, str, s03Var)) {
            return;
        }
        f(context, strArr, i, s03Var);
    }

    public static void f(@NonNull Context context, @NonNull String[] strArr, int i, @NonNull s03 s03Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLIL(65542, null, context, strArr, i, s03Var) != null) || !a(context, s03Var)) {
            return;
        }
        ArrayList<String> d = d(context, strArr);
        if (c(d, s03Var)) {
            return;
        }
        ((SwanAppBaseActivity) context).z(i, (String[]) d.toArray(new String[0]), new o03(context, i, s03Var));
    }

    public static void g(@NonNull String[] strArr, int i, @NonNull Context context, @NonNull s03 s03Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLILL(65543, null, strArr, i, context, s03Var) != null) || !a(context, s03Var)) {
            return;
        }
        ArrayList<String> d = d(context, strArr);
        if (c(d, s03Var)) {
            return;
        }
        f(context, (String[]) d.toArray(new String[0]), i, s03Var);
    }
}
