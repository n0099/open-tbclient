package com.baidu.tieba;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xr0 {
    public static /* synthetic */ Interceptable $ic;
    public static int a;
    public static int b;
    public static Context c;
    public static boolean d;
    public static ay0 e;
    public static zw0 f;
    public static String g;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1948309843, "Lcom/baidu/tieba/xr0;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1948309843, "Lcom/baidu/tieba/xr0;");
        }
    }

    @NonNull
    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return g;
        }
        return (String) invokeV.objValue;
    }

    public static Context b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return c;
        }
        return (Context) invokeV.objValue;
    }

    @NonNull
    public static zw0 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            if (f == null) {
                f = new yw0();
            }
            return f;
        }
        return (zw0) invokeV.objValue;
    }

    @NonNull
    public static ay0 d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (e == null) {
                e = new by0();
            }
            return e;
        }
        return (ay0) invokeV.objValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            return d;
        }
        return invokeV.booleanValue;
    }

    public static void e(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65541, null, z) == null) {
            h(z);
            Context context = c;
            if (context != null) {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                b = Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels);
                a = Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels);
            }
        }
    }

    public static void g(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, null, context) == null) {
            c = context;
        }
    }

    public static void h(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(65544, null, z) == null) {
            d = z;
        }
    }

    public static void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65545, null, str) == null) {
            g = str;
        }
    }

    public static void j(@NonNull zw0 zw0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65546, null, zw0Var) == null) {
            f = zw0Var;
        }
    }
}
