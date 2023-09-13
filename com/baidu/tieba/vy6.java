package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static uy6 a(TbPageContext tbPageContext, BdUniqueId bdUniqueId, int i) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(65536, null, tbPageContext, bdUniqueId, i)) == null) {
            if (tbPageContext == null) {
                return null;
            }
            if (i == 1) {
                return new zy6(tbPageContext, bdUniqueId, i);
            }
            if (i == 2) {
                return new yy6(tbPageContext, bdUniqueId, i);
            }
            if (i != 3) {
                return null;
            }
            return new wy6(tbPageContext, bdUniqueId, i);
        }
        return (uy6) invokeLLI.objValue;
    }
}
