package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static i56 a(j56 j56Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, j56Var)) == null) {
            if (j56Var != null && (j56Var.a() instanceof TbPageContext) && (((TbPageContext) j56Var.a()).getPageActivity() instanceof i56)) {
                return (i56) ((TbPageContext) j56Var.a()).getPageActivity();
            }
            return null;
        }
        return (i56) invokeL.objValue;
    }
}
