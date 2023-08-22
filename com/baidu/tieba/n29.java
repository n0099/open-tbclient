package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class n29 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static m29 a(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof c19)) {
                return ((c19) tbPageContext.getPageActivity()).Z();
            }
            return null;
        }
        return (m29) invokeL.objValue;
    }

    public static LegoListFragment b(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof c19)) {
                return ((c19) tbPageContext.getPageActivity()).p0();
            }
            return null;
        }
        return (LegoListFragment) invokeL.objValue;
    }

    public static r29 c(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof c19)) {
                return ((c19) tbPageContext.getPageActivity()).a1();
            }
            return null;
        }
        return (r29) invokeL.objValue;
    }
}
