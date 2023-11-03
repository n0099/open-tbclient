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
/* loaded from: classes7.dex */
public class pg2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948061006, "Lcom/baidu/tieba/pg2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948061006, "Lcom/baidu/tieba/pg2;");
                return;
            }
        }
        a = rm1.a;
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

    public static <T extends mh2> Exception b(int i, T t) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i, t)) == null) {
            sg2 f = f(i);
            if (f == null) {
                return new Exception("SwanExtCore-Manager doRemoteUpdate: null extensionCoreManager");
            }
            return f.a(t);
        }
        return (Exception) invokeIL.objValue;
    }

    public static void h(int i, @Nullable zk3<Exception> zk3Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65544, null, i, zk3Var) == null) {
            sg2 f = f(i);
            if (f != null) {
                f.g(zk3Var);
            } else if (zk3Var != null) {
                zk3Var.a(null);
            }
        }
    }

    public static ExtensionCore c(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65539, null, i)) == null) {
            sg2 f = f(i);
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
            if (c != null && !TextUtils.isEmpty(c.extensionCoreVersionName)) {
                return c.extensionCoreVersionName;
            }
            return "0";
        }
        return (String) invokeI.objValue;
    }

    public static sg2 f(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65542, null, i)) == null) {
            if (i == 1) {
                sg2 t = op2.i().t();
                if (t == null && rm1.a) {
                    Log.e("SwanGameRuntime", "非手百环境依赖注入接口getSwanGameExtensionCoreManager未实现，直接返回");
                }
                return t;
            }
            return og2.k();
        }
        return (sg2) invokeI.objValue;
    }

    public static void g(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(65543, null, i, i2) == null) {
            if (a) {
                Log.d("SwanExtCore-Manager", "onAppUpgrade oldVersion: " + i + " ,newVersion: " + i2);
            }
            if (!"com.baidu.searchbox.smartapp".equals(AppRuntime.getAppContext().getPackageName()) && i == i2) {
                return;
            }
            a();
            xh2.i(0, true);
            xh2.i(1, true);
        }
    }
}
