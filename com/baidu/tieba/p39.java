package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class p39 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static o39 a(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof e29)) {
                return ((e29) tbPageContext.getPageActivity()).X();
            }
            return null;
        }
        return (o39) invokeL.objValue;
    }

    public static LegoListFragment b(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof e29)) {
                return ((e29) tbPageContext.getPageActivity()).o0();
            }
            return null;
        }
        return (LegoListFragment) invokeL.objValue;
    }

    public static t39 c(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof e29)) {
                return ((e29) tbPageContext.getPageActivity()).b1();
            }
            return null;
        }
        return (t39) invokeL.objValue;
    }
}
