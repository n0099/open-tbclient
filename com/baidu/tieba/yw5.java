package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yw5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static sw5 a(tw5 tw5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tw5Var)) == null) {
            if (tw5Var != null && (tw5Var.a() instanceof TbPageContext) && (((TbPageContext) tw5Var.a()).getPageActivity() instanceof sw5)) {
                return (sw5) ((TbPageContext) tw5Var.a()).getPageActivity();
            }
            return null;
        }
        return (sw5) invokeL.objValue;
    }
}
