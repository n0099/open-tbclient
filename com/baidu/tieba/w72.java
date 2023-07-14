package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w72 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(s62 s62Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, s62Var)) == null) {
            v72 v72Var = (v72) i82.a(s62Var);
            if (v72Var == null) {
                v82.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return v72Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
