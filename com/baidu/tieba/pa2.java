package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.tieba.bn2;
import com.baidu.tieba.cp2;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes5.dex */
public class pa2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public static Boolean b;
    public static int c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948055240, "Lcom/baidu/tieba/pa2;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948055240, "Lcom/baidu/tieba/pa2;");
                return;
            }
        }
        a = pk1.a;
        mn2.g0().getSwitch("swan_naview_slave_preload_type", 0);
        c = 0;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            Boolean bool = b;
            if (bool != null) {
                return bool.booleanValue();
            }
            Boolean valueOf = Boolean.valueOf(a());
            b = valueOf;
            return valueOf.booleanValue();
        }
        return invokeV.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            if (c == 2) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) {
            if (c == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (c == 3) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            boolean z = false;
            if (!za2.U().r0()) {
                Log.w("NASlaveConfig", "v8 is not enabled");
                return false;
            } else if (!mn2.F0().j(1)) {
                return false;
            } else {
                String c0 = za2.U().c0();
                if (TextUtils.isEmpty(c0)) {
                    Log.w("NASlaveConfig", "base path is not exists");
                    return false;
                } else if (!new File(c0, "slave-talos/index.js").isFile()) {
                    Log.w("NASlaveConfig", "talos-js file is not exists");
                    return false;
                } else if (a && e03.Y()) {
                    return true;
                } else {
                    if (c != 0) {
                        z = true;
                    }
                    if (a) {
                        Log.d("NASlaveConfig", "isNARenderEnabled canUseNA: " + z);
                    }
                    return z;
                }
            }
        }
        return invokeV.booleanValue;
    }

    public static int b(@Nullable u43 u43Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, u43Var)) == null) {
            if (u43Var == null || !d()) {
                return 0;
            }
            return "na".equals(u43Var.r) ? 1 : 0;
        }
        return invokeL.intValue;
    }

    public static int c(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            if (str == null) {
                return 0;
            }
            if (str.contains("?")) {
                str = str.substring(0, str.indexOf("?"));
            }
            int b2 = b(sp2.U().f(str));
            if (a) {
                Log.d("NASlaveConfig", "getSlaveType pageUrl: " + str + " slaveType:" + b2);
            }
            return b2;
        }
        return invokeL.intValue;
    }

    public static boolean h(f43 f43Var) {
        InterceptResult invokeL;
        cp2.a W;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65544, null, f43Var)) == null) {
            if (f43Var == null || !f43Var.E()) {
                return false;
            }
            if (e03.B(f43Var.W())) {
                str = bn2.b.g().getPath() + File.separator;
            } else {
                str = bn2.e.i(W.H(), W.v1()).getPath() + File.separator;
            }
            if (a) {
                Log.d("NASlaveConfig", "手动解析的basePath: " + str);
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            sp2.U().K(str);
            return true;
        }
        return invokeL.booleanValue;
    }
}
