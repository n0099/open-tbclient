package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vn5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static pn5 a(qn5 qn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, qn5Var)) == null) {
            if (qn5Var != null && (qn5Var.a() instanceof TbPageContext) && (((TbPageContext) qn5Var.a()).getPageActivity() instanceof pn5)) {
                return (pn5) ((TbPageContext) qn5Var.a()).getPageActivity();
            }
            return null;
        }
        return (pn5) invokeL.objValue;
    }
}
