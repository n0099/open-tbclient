package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qi8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pi8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pi8 a() {
        InterceptResult invokeV;
        pi8 pi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qi8.class) {
                if (a == null) {
                    a = new pi8();
                }
                pi8Var = a;
            }
            return pi8Var;
        }
        return (pi8) invokeV.objValue;
    }
}
