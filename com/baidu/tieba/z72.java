package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(v62 v62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, v62Var)) == null) {
            y72 y72Var = (y72) l82.a(v62Var);
            if (y72Var == null) {
                y82.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return y72Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
