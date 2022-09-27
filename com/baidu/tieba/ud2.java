package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ud2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948207078, "Lcom/baidu/tieba/ud2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948207078, "Lcom/baidu/tieba/ud2;");
                return;
            }
        }
        a = vj1.a;
    }

    public static void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, null) == null) {
            f(0).f().c();
            f(0).e().f();
            if (f(1) != null) {
                f(1).f().c();
                f(1).e().f();
            }
        }
    }

    public static <T extends re2> Exception b(int i, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, t)) == null) {
            xd2 f = f(i);
            if (f == null) {
                return new Exception("SwanExtCore-Manager doRemoteUpdate: null extensionCoreManager");
            }
            return f.a(t);
        }
        return (Exception) invokeIL.objValue;
    }

    public static ExtensionCore c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            xd2 f = f(i);
            if (f == null) {
                return null;
            }
            return f.c();
        }
        return (ExtensionCore) invokeI.objValue;
    }

    public static long d(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TRACKBALL, null, i)) == null) {
            ExtensionCore c = c(i);
            if (c != null) {
                return c.extensionCoreVersionCode;
            }
            return 0L;
        }
        return invokeI.longValue;
    }

    public static String e(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65541, null, i)) == null) {
            ExtensionCore c = c(i);
            return (c == null || TextUtils.isEmpty(c.extensionCoreVersionName)) ? "0" : c.extensionCoreVersionName;
        }
        return (String) invokeI.objValue;
    }

    public static xd2 f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (i == 1) {
                xd2 t = tm2.i().t();
                if (t == null && vj1.a) {
                    Log.e("SwanGameRuntime", "非手百环境依赖注入接口getSwanGameExtensionCoreManager未实现，直接返回");
                }
                return t;
            }
            return td2.k();
        }
        return (xd2) invokeI.objValue;
    }

    public static void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, null, i, i2) == null) {
            if (a) {
                Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
            }
            if ("com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) || i != i2) {
                a();
                cf2.i(0, true);
                cf2.i(1, true);
            }
        }
    }

    public static void h(int i, @Nullable ei3<Exception> ei3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i, ei3Var) == null) {
            xd2 f = f(i);
            if (f != null) {
                f.g(ei3Var);
            } else if (ei3Var != null) {
                ei3Var.a(null);
            }
        }
    }
}
