package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class k02 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(gz1 gz1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gz1Var)) == null) {
            j02 j02Var = (j02) w02.a(gz1Var);
            if (j02Var == null) {
                j12.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return j02Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
