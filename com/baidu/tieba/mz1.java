package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(iy1 iy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, iy1Var)) == null) {
            lz1 lz1Var = (lz1) yz1.a(iy1Var);
            if (lz1Var == null) {
                l02.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return lz1Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
