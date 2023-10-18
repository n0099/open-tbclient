package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ty5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ny5 a(oy5 oy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, oy5Var)) == null) {
            if (oy5Var != null && (oy5Var.a() instanceof TbPageContext) && (((TbPageContext) oy5Var.a()).getPageActivity() instanceof ny5)) {
                return (ny5) ((TbPageContext) oy5Var.a()).getPageActivity();
            }
            return null;
        }
        return (ny5) invokeL.objValue;
    }
}
