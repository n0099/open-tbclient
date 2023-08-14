package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static q26 a(r26 r26Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, r26Var)) == null) {
            if (r26Var != null && (r26Var.a() instanceof TbPageContext) && (((TbPageContext) r26Var.a()).getPageActivity() instanceof q26)) {
                return (q26) ((TbPageContext) r26Var.a()).getPageActivity();
            }
            return null;
        }
        return (q26) invokeL.objValue;
    }
}
