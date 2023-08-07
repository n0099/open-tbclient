package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class z62 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(v52 v52Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, v52Var)) == null) {
            y62 y62Var = (y62) l72.a(v52Var);
            if (y62Var == null) {
                y72.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return y62Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
