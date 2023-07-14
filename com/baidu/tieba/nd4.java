package com.baidu.tieba;

import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class nd4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(dj2 dj2Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(65536, null, dj2Var, str) == null) && dj2Var != null && dj2Var.m().hasEventListener("deviceOrientationChange")) {
            JSEvent jSEvent = new JSEvent("deviceOrientationChange");
            jSEvent.data = new pd4(str);
            dj2Var.dispatchEvent(jSEvent);
        }
    }
}
