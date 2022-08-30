package com.baidu.tieba;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.so.SoLoader;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public final class t63 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) ? hk2.e0().c() : (String) invokeV.objValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) ? SoLoader.load(AppRuntime.getAppContext(), "audioengine") : invokeV.booleanValue;
    }

    public static v63 c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (!hk2.w0().d()) {
                return a72.c(false);
            }
            return SoLoader.loadV8EngineSo(AppRuntime.getAppContext());
        }
        return (v63) invokeV.objValue;
    }
}
