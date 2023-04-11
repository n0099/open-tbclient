package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class kx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ex5 a(fx5 fx5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, fx5Var)) == null) {
            if (fx5Var != null && (fx5Var.a() instanceof TbPageContext) && (((TbPageContext) fx5Var.a()).getPageActivity() instanceof ex5)) {
                return (ex5) ((TbPageContext) fx5Var.a()).getPageActivity();
            }
            return null;
        }
        return (ex5) invokeL.objValue;
    }
}
