package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class qi9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pi9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pi9 a() {
        InterceptResult invokeV;
        pi9 pi9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qi9.class) {
                if (a == null) {
                    a = new pi9();
                }
                pi9Var = a;
            }
            return pi9Var;
        }
        return (pi9) invokeV.objValue;
    }
}
