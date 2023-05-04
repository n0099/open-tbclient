package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ly5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static fy5 a(gy5 gy5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, gy5Var)) == null) {
            if (gy5Var != null && (gy5Var.a() instanceof TbPageContext) && (((TbPageContext) gy5Var.a()).getPageActivity() instanceof fy5)) {
                return (fy5) ((TbPageContext) gy5Var.a()).getPageActivity();
            }
            return null;
        }
        return (fy5) invokeL.objValue;
    }
}
