package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class oi9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ni9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ni9 a() {
        InterceptResult invokeV;
        ni9 ni9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oi9.class) {
                if (a == null) {
                    a = new ni9();
                }
                ni9Var = a;
            }
            return ni9Var;
        }
        return (ni9) invokeV.objValue;
    }
}
