package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static i06 a(j06 j06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, j06Var)) == null) {
            if (j06Var != null && (j06Var.a() instanceof TbPageContext) && (((TbPageContext) j06Var.a()).getPageActivity() instanceof i06)) {
                return (i06) ((TbPageContext) j06Var.a()).getPageActivity();
            }
            return null;
        }
        return (i06) invokeL.objValue;
    }
}
