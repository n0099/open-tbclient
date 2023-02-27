package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class os9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ns9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ns9 a() {
        InterceptResult invokeV;
        ns9 ns9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (os9.class) {
                if (a == null) {
                    a = new ns9();
                }
                ns9Var = a;
            }
            return ns9Var;
        }
        return (ns9) invokeV.objValue;
    }
}
