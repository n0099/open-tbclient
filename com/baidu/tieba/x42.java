package com.baidu.tieba;

import android.os.Environment;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.tieba.pq2;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.File;
/* loaded from: classes6.dex */
public class x42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static pq2.g a(qs2 qs2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qs2Var)) == null) {
            File file = new File(Environment.getExternalStorageDirectory() + "/" + y42.d());
            pq2.M(file, b(), qs2Var);
            xn4.j(file);
            pq2.g gVar = new pq2.g();
            File file2 = new File(b(), "app.json");
            SwanAppConfigData c = SwanAppConfigData.c(xn4.E(file2), b());
            gVar.a = b().getPath() + File.separator;
            gVar.b = c;
            t42.k("ADBDebugBundleHelper", "configFile path: " + file2.getPath() + " exist: " + file2.exists() + " info.mAppBundlePath path: " + gVar.a);
            return gVar;
        }
        return (pq2.g) invokeL.objValue;
    }

    public static File b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            File file = new File(AppRuntime.getAppContext().getFilesDir(), "aiapps_adb_debug");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return (File) invokeV.objValue;
    }

    public static String c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            return AppRuntime.getAppContext().getFilesDir() + File.separator + "aiapps_adb_debug";
        }
        return (String) invokeV.objValue;
    }
}
