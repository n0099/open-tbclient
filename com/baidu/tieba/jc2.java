package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class jc2 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static uc2 a(sc2 sc2Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, sc2Var)) == null) {
            int i = sc2Var.a;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return new tc2(sc2Var);
                        }
                        return new xc2(sc2Var);
                    }
                    return new vc2(sc2Var);
                }
                return new yc2(sc2Var);
            }
            return new wc2(sc2Var);
        }
        return (uc2) invokeL.objValue;
    }
}
