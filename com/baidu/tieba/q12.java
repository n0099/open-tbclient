package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q12 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    @Nullable
    public static CanvasView a(n02 n02Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, n02Var)) == null) {
            p12 p12Var = (p12) c22.a(n02Var);
            if (p12Var == null) {
                p22.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return p12Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
