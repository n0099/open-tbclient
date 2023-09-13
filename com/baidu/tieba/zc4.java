package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class zc4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(pi2 pi2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, pi2Var, str) == null) && pi2Var != null && pi2Var.m().hasEventListener("deviceOrientationChange")) {
            JSEvent jSEvent = new JSEvent("deviceOrientationChange");
            jSEvent.data = new bd4(str);
            pi2Var.dispatchEvent(jSEvent);
        }
    }
}
