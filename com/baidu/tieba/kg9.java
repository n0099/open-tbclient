package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class kg9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static jg9 a(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof ze9)) {
                return ((ze9) tbPageContext.getPageActivity()).P();
            }
            return null;
        }
        return (jg9) invokeL.objValue;
    }

    public static LegoListFragment b(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof ze9)) {
                return ((ze9) tbPageContext.getPageActivity()).Y();
            }
            return null;
        }
        return (LegoListFragment) invokeL.objValue;
    }

    public static og9 c(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof ze9)) {
                return ((ze9) tbPageContext.getPageActivity()).V0();
            }
            return null;
        }
        return (og9) invokeL.objValue;
    }
}
