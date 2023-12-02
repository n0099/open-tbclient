package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pv6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static ov6 a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, tbPageContext, bdUniqueId, i)) == null) {
            if (tbPageContext == null) {
                return null;
            }
            if (i == 1) {
                return new tv6(tbPageContext, bdUniqueId, i);
            }
            if (i == 2) {
                return new sv6(tbPageContext, bdUniqueId, i);
            }
            if (i != 3) {
                return null;
            }
            return new qv6(tbPageContext, bdUniqueId, i);
        }
        return (ov6) invokeLLI.objValue;
    }
}
