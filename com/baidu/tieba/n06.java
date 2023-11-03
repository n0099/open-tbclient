package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n06 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static h06 a(i06 i06Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, i06Var)) == null) {
            if (i06Var != null && (i06Var.a() instanceof TbPageContext) && (((TbPageContext) i06Var.a()).getPageActivity() instanceof h06)) {
                return (h06) ((TbPageContext) i06Var.a()).getPageActivity();
            }
            return null;
        }
        return (h06) invokeL.objValue;
    }
}
