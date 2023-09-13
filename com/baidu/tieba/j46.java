package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static d46 a(e46 e46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, e46Var)) == null) {
            if (e46Var != null && (e46Var.a() instanceof TbPageContext) && (((TbPageContext) e46Var.a()).getPageActivity() instanceof d46)) {
                return (d46) ((TbPageContext) e46Var.a()).getPageActivity();
            }
            return null;
        }
        return (d46) invokeL.objValue;
    }
}
