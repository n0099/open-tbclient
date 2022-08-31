package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class sk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static mk5 a(nk5 nk5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, nk5Var)) == null) {
            if (nk5Var != null && (nk5Var.a() instanceof TbPageContext) && (((TbPageContext) nk5Var.a()).getPageActivity() instanceof mk5)) {
                return (mk5) ((TbPageContext) nk5Var.a()).getPageActivity();
            }
            return null;
        }
        return (mk5) invokeL.objValue;
    }
}
