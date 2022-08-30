package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uk5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ok5 a(pk5 pk5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pk5Var)) == null) {
            if (pk5Var != null && (pk5Var.a() instanceof TbPageContext) && (((TbPageContext) pk5Var.a()).getPageActivity() instanceof ok5)) {
                return (ok5) ((TbPageContext) pk5Var.a()).getPageActivity();
            }
            return null;
        }
        return (ok5) invokeL.objValue;
    }
}
