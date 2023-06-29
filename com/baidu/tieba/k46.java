package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k46 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static e46 a(f46 f46Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, f46Var)) == null) {
            if (f46Var != null && (f46Var.a() instanceof TbPageContext) && (((TbPageContext) f46Var.a()).getPageActivity() instanceof e46)) {
                return (e46) ((TbPageContext) f46Var.a()).getPageActivity();
            }
            return null;
        }
        return (e46) invokeL.objValue;
    }
}
