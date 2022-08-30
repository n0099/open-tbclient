package com.baidu.tieba;

import com.baidu.tbadk.core.BaseFragment;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class m56 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static l56 a(BaseFragment baseFragment, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65536, null, baseFragment, i)) == null) {
            if (baseFragment == null) {
                return null;
            }
            if (i == 1) {
                return new q56(baseFragment, i);
            }
            if (i == 2) {
                return new p56(baseFragment, i);
            }
            if (i == 3) {
                return new n56(baseFragment, i);
            }
            return null;
        }
        return (l56) invokeLI.objValue;
    }
}
