package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uo5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static oo5 a(po5 po5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, po5Var)) == null) {
            if (po5Var != null && (po5Var.a() instanceof TbPageContext) && (((TbPageContext) po5Var.a()).getPageActivity() instanceof oo5)) {
                return (oo5) ((TbPageContext) po5Var.a()).getPageActivity();
            }
            return null;
        }
        return (oo5) invokeL.objValue;
    }
}
