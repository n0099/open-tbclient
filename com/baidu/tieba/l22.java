package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class l22 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(i12 i12Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, i12Var)) == null) {
            k22 k22Var = (k22) x22.a(i12Var);
            if (k22Var == null) {
                k32.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return k22Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
