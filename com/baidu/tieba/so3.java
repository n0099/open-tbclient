package com.baidu.tieba;

import android.text.TextUtils;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes8.dex */
public class so3 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1948158098, "Lcom/baidu/tieba/so3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1948158098, "Lcom/baidu/tieba/so3;");
                return;
            }
        }
        a = nr1.a;
    }

    public static boolean a(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, str2)) == null) {
            if (b(str) > b(str2)) {
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public static long b(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            String[] g = g(str);
            if (g == null) {
                return 0L;
            }
            long j = 0;
            for (int i = 0; i < g.length; i++) {
                try {
                    j += Integer.parseInt(g[i]) * ((long) Math.pow(1000.0d, (g.length - i) - 1));
                } catch (NumberFormatException e) {
                    d82.l("SwanAppSwanCoreUtils", "getVersionCode exception", e);
                    return 0L;
                }
            }
            d82.b("SwanAppSwanCoreUtils", "getVersion version: ", str, " ,versionCode: ", Long.valueOf(j));
            return j;
        }
        return invokeL.longValue;
    }

    public static long c(String str) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            String[] g = g(str);
            if (g == null) {
                return 0L;
            }
            long j2 = 0;
            for (int i = 0; i < 3; i++) {
                try {
                    if (i < g.length) {
                        j = Integer.parseInt(g[i]);
                    } else {
                        j = 0;
                    }
                    j2 = (j2 << 16) | j;
                } catch (NumberFormatException e) {
                    if (!a) {
                        return 0L;
                    }
                    throw e;
                }
            }
            if (a) {
                Log.d("SwanAppSwanCoreUtils", "getVersion version: " + str + " ,versionCode: " + j2);
            }
            return j2;
        }
        return invokeL.longValue;
    }

    public static String d(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(InputDeviceCompat.SOURCE_TRACKBALL, null, j)) == null) {
            if (j < 0) {
                d82.k("SwanAppSwanCoreUtils", "versionCode < 0, versionCode = " + j);
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            long j2 = j;
            for (int i = 2; i >= 0; i--) {
                if (i > 0) {
                    long pow = (long) Math.pow(1000.0d, i);
                    sb.append(j2 / pow);
                    sb.append(".");
                    j2 %= pow;
                } else {
                    sb.append(j2);
                }
            }
            String sb2 = sb.toString();
            d82.b("SwanAppSwanCoreUtils", "getVersionName version code: ", Long.valueOf(j), " ,version name: ", sb2);
            return sb2;
        }
        return (String) invokeJ.objValue;
    }

    public static boolean e(String str) {
        InterceptResult invokeL;
        String[] list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (!file.isDirectory() || (list = file.list()) == null || list.length <= 0) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static boolean f(String str) {
        InterceptResult invokeL;
        long j;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65542, null, str)) == null) {
            long b = b(str);
            SwanCoreVersion d0 = xh2.U().d0();
            if (d0 != null) {
                j = b(d0.swanCoreVersionName);
            } else {
                j = 0;
            }
            if (j < b) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static String[] g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String[] split = str.split("\\.");
            if (split.length != 3) {
                return null;
            }
            return split;
        }
        return (String[]) invokeL.objValue;
    }
}
