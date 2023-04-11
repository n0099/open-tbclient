package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v32 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(r22 r22Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, r22Var)) == null) {
            u32 u32Var = (u32) h42.a(r22Var);
            if (u32Var == null) {
                u42.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return u32Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
