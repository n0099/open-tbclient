package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static p26 a(q26 q26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, q26Var)) == null) {
            if (q26Var != null && (q26Var.a() instanceof TbPageContext) && (((TbPageContext) q26Var.a()).getPageActivity() instanceof p26)) {
                return (p26) ((TbPageContext) q26Var.a()).getPageActivity();
            }
            return null;
        }
        return (p26) invokeL.objValue;
    }
}
