package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n36 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static h36 a(i36 i36Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, i36Var)) == null) {
            if (i36Var != null && (i36Var.a() instanceof TbPageContext) && (((TbPageContext) i36Var.a()).getPageActivity() instanceof h36)) {
                return (h36) ((TbPageContext) i36Var.a()).getPageActivity();
            }
            return null;
        }
        return (h36) invokeL.objValue;
    }
}
