package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.lego.activity.LegoListFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o09 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static n09 a(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof cz8)) {
                return ((cz8) tbPageContext.getPageActivity()).j0();
            }
            return null;
        }
        return (n09) invokeL.objValue;
    }

    public static LegoListFragment b(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof cz8)) {
                return ((cz8) tbPageContext.getPageActivity()).q0();
            }
            return null;
        }
        return (LegoListFragment) invokeL.objValue;
    }

    public static s09 c(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, tbPageContext)) == null) {
            if (tbPageContext != null && (tbPageContext.getPageActivity() instanceof cz8)) {
                return ((cz8) tbPageContext.getPageActivity()).g1();
            }
            return null;
        }
        return (s09) invokeL.objValue;
    }
}
