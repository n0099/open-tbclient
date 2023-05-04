package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class y32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(u22 u22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, u22Var)) == null) {
            x32 x32Var = (x32) k42.a(u22Var);
            if (x32Var == null) {
                x42.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return x32Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
