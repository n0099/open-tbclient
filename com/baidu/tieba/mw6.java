package com.baidu.tieba;

import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static lw6 a(BaseFragment baseFragment, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, baseFragment, i)) == null) {
            if (baseFragment == null) {
                return null;
            }
            if (i == 1) {
                return new qw6(baseFragment, i);
            }
            if (i == 2) {
                return new pw6(baseFragment, i);
            }
            if (i != 3) {
                return null;
            }
            return new nw6(baseFragment, i);
        }
        return (lw6) invokeLI.objValue;
    }
}
