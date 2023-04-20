package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class w32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(s22 s22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, s22Var)) == null) {
            v32 v32Var = (v32) i42.a(s22Var);
            if (v32Var == null) {
                v42.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return v32Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
