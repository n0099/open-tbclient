package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class n52 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(j42 j42Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, j42Var)) == null) {
            m52 m52Var = (m52) z52.a(j42Var);
            if (m52Var == null) {
                m62.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return m52Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
