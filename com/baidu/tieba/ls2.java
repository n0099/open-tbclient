package com.baidu.tieba;

import android.os.Looper;
import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.hl3;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
import java.util.List;
/* loaded from: classes5.dex */
public class ls2 implements xs2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static SwanAppConfigData a(File file) {
        InterceptResult invokeL;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, file)) == null) {
            if (file != null && file.exists()) {
                long currentTimeMillis = System.currentTimeMillis();
                SwanAppConfigData b = f83.b(file.getAbsolutePath());
                if (xs2.a) {
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
                SwanAppConfigData swanAppConfigData = (SwanAppConfigData) ms2.c().b(file.getAbsolutePath());
                if (swanAppConfigData == null) {
                    swanAppConfigData = w13.e().j(file);
                    if (swanAppConfigData == null) {
                        swanAppConfigData = a(file);
                    }
                    ms2.c().d(file.getAbsolutePath(), swanAppConfigData);
                } else if (xs2.a) {
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
            Boolean bool = (Boolean) ms2.c().b("getNightModeStateCache");
            if (bool == null) {
                return Boolean.valueOf(ar2.M().a());
            }
            if (z) {
                ms2.c().e("getNightModeStateCache");
            }
            return bool;
        }
        return (Boolean) invokeZ.objValue;
    }

    public static List<hl3.a> d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            List<hl3.a> list = (List) ms2.c().b("getStorageListCache");
            if (list == null) {
                List<hl3.a> d = hl3.d();
                ms2.c().d("getStorageListCache", d);
                return d;
            }
            return list;
        }
        return (List) invokeV.objValue;
    }

    public static void e(Boolean bool) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, bool) == null) {
            ms2.c().d("getNightModeStateCache", bool);
        }
    }
}
