package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class on5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static in5 a(jn5 jn5Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, jn5Var)) == null) {
            if (jn5Var != null && (jn5Var.a() instanceof TbPageContext) && (((TbPageContext) jn5Var.a()).getPageActivity() instanceof in5)) {
                return (in5) ((TbPageContext) jn5Var.a()).getPageActivity();
            }
            return null;
        }
        return (in5) invokeL.objValue;
    }
}
