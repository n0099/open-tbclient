package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x42 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(t32 t32Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, t32Var)) == null) {
            w42 w42Var = (w42) j52.a(t32Var);
            if (w42Var == null) {
                w52.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return w42Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
