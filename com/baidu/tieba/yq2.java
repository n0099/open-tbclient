package com.baidu.tieba;

import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.uj3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes9.dex */
public class yq2 implements kr2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static SwanAppConfigData a(File file) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            if (file != null && file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                SwanAppConfigData b = s63.b(file.getAbsolutePath());
                if (kr2.a) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder();
                    sb.append("buildAppJsonConfig cost = ");
                    sb.append(currentTimeMillis2 - currentTimeMillis);
                    sb.append("ms ; current thread is main = ");
                    if (Looper.getMainLooper() == Looper.myLooper()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    sb.append(z);
                    sb.append(" ; path = ");
                    sb.append(file);
                    Log.d("SwanPerformance", sb.toString());
                }
                return b;
            }
            return null;
        }
        return (SwanAppConfigData) invokeL.objValue;
    }

    public static SwanAppConfigData b(File file) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, file)) == null) {
            if (file != null && file.exists()) {
                SwanAppConfigData swanAppConfigData = (SwanAppConfigData) zq2.c().b(file.getAbsolutePath());
                if (swanAppConfigData == null) {
                    swanAppConfigData = j03.e().j(file);
                    if (swanAppConfigData == null) {
                        swanAppConfigData = a(file);
                    }
                    zq2.c().d(file.getAbsolutePath(), swanAppConfigData);
                } else if (kr2.a) {
                    Log.d("SwanPerformance", "adopt cached app.json");
                }
                return swanAppConfigData;
            }
            return null;
        }
        return (SwanAppConfigData) invokeL.objValue;
    }

    public static Boolean c(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(65538, null, z)) == null) {
            Boolean bool = (Boolean) zq2.c().b("getNightModeStateCache");
            if (bool == null) {
                return Boolean.valueOf(np2.M().a());
            }
            if (z) {
                zq2.c().e("getNightModeStateCache");
            }
            return bool;
        }
        return (Boolean) invokeZ.objValue;
    }

    public static List<uj3.a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            List<uj3.a> list = (List) zq2.c().b("getStorageListCache");
            if (list == null) {
                List<uj3.a> d = uj3.d();
                zq2.c().d("getStorageListCache", d);
                return d;
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public static void e(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bool) == null) {
            zq2.c().d("getNightModeStateCache", bool);
        }
    }
}
