package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zy1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(vx1 vx1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, vx1Var)) == null) {
            yy1 yy1Var = (yy1) lz1.a(vx1Var);
            if (yy1Var == null) {
                yz1.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return yy1Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
