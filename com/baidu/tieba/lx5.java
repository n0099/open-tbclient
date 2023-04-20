package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fx5 a(gx5 gx5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gx5Var)) == null) {
            if (gx5Var != null && (gx5Var.a() instanceof TbPageContext) && (((TbPageContext) gx5Var.a()).getPageActivity() instanceof fx5)) {
                return (fx5) ((TbPageContext) gx5Var.a()).getPageActivity();
            }
            return null;
        }
        return (fx5) invokeL.objValue;
    }
}
