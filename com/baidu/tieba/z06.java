package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes9.dex */
public class z06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static t06 a(u06 u06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, u06Var)) == null) {
            if (u06Var != null && (u06Var.a() instanceof TbPageContext) && (((TbPageContext) u06Var.a()).getPageActivity() instanceof t06)) {
                return (t06) ((TbPageContext) u06Var.a()).getPageActivity();
            }
            return null;
        }
        return (t06) invokeL.objValue;
    }
}
