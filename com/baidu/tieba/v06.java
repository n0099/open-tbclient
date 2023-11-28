package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static p06 a(q06 q06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, q06Var)) == null) {
            if (q06Var != null && (q06Var.a() instanceof TbPageContext) && (((TbPageContext) q06Var.a()).getPageActivity() instanceof p06)) {
                return (p06) ((TbPageContext) q06Var.a()).getPageActivity();
            }
            return null;
        }
        return (p06) invokeL.objValue;
    }
}
