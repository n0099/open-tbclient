package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class xz5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static rz5 a(sz5 sz5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sz5Var)) == null) {
            if (sz5Var != null && (sz5Var.a() instanceof TbPageContext) && (((TbPageContext) sz5Var.a()).getPageActivity() instanceof rz5)) {
                return (rz5) ((TbPageContext) sz5Var.a()).getPageActivity();
            }
            return null;
        }
        return (rz5) invokeL.objValue;
    }
}
