package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i76 a() {
        InterceptResult invokeV;
        i76 i76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j76.class) {
                if (a == null) {
                    a = new i76();
                }
                i76Var = a;
            }
            return i76Var;
        }
        return (i76) invokeV.objValue;
    }
}
