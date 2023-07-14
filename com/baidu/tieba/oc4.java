package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nc4 a() {
        InterceptResult invokeV;
        nc4 nc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oc4.class) {
                if (a == null) {
                    a = new nc4();
                }
                nc4Var = a;
            }
            return nc4Var;
        }
        return (nc4) invokeV.objValue;
    }
}
