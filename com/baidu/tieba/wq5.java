package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class wq5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static qq5 a(rq5 rq5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, rq5Var)) == null) {
            if (rq5Var != null && (rq5Var.a() instanceof TbPageContext) && (((TbPageContext) rq5Var.a()).getPageActivity() instanceof qq5)) {
                return (qq5) ((TbPageContext) rq5Var.a()).getPageActivity();
            }
            return null;
        }
        return (qq5) invokeL.objValue;
    }
}
