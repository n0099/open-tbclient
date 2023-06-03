package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class y36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static s36 a(t36 t36Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, t36Var)) == null) {
            if (t36Var != null && (t36Var.a() instanceof TbPageContext) && (((TbPageContext) t36Var.a()).getPageActivity() instanceof s36)) {
                return (s36) ((TbPageContext) t36Var.a()).getPageActivity();
            }
            return null;
        }
        return (s36) invokeL.objValue;
    }
}
