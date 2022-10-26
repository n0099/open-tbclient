package com.baidu.tieba;

import com.baidu.swan.apps.canvas.view.CanvasView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nz1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static CanvasView a(jy1 jy1Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jy1Var)) == null) {
            mz1 mz1Var = (mz1) zz1.a(jy1Var);
            if (mz1Var == null) {
                m02.c("Component-Canvas-Utils", "get canvas view fail: find a null component");
                return null;
            }
            return mz1Var.i;
        }
        return (CanvasView) invokeL.objValue;
    }
}
