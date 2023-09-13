package com.baidu.tieba;

import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import tbclient.ExcPbPage.ExcContent;
/* loaded from: classes6.dex */
public class lr9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ir9 a(TbPageContext<?> tbPageContext, ExcContent excContent) {
        InterceptResult invokeLL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, tbPageContext, excContent)) == null) {
            if (excContent == null || (l = excContent.type) == null) {
                return null;
            }
            if (l.longValue() == 2) {
                return new gr9(excContent);
            }
            if (excContent.type.longValue() == 0) {
                return new mr9(tbPageContext.getPageActivity(), excContent);
            }
            if (excContent.type.longValue() != 1) {
                return null;
            }
            return new hr9(tbPageContext, excContent);
        }
        return (ir9) invokeLL.objValue;
    }

    public static final jr9 b(ExcContent excContent) {
        InterceptResult invokeL;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, excContent)) == null) {
            if (excContent == null || (l = excContent.type) == null || !l.equals(3L)) {
                return null;
            }
            return new kr9(excContent);
        }
        return (jr9) invokeL.objValue;
    }
}
