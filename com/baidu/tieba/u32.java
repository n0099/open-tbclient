package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class u32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(q22 q22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, q22Var)) == null) {
            t32 t32Var = (t32) g42.a(q22Var);
            if (t32Var == null) {
                t42.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return t32Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
