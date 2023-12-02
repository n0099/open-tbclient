package com.baidu.tieba;

import android.view.Window;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zn4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static boolean a() {
        InterceptResult invokeV;
        SwanAppActivity w;
        Window window;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            k63 c0 = k63.c0();
            if (c0 == null || (w = c0.w()) == null || w.isFinishing() || (window = w.getWindow()) == null || (window.getAttributes().flags & 1024) != 1024) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
