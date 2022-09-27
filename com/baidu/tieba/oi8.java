package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class oi8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ni8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ni8 a() {
        InterceptResult invokeV;
        ni8 ni8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oi8.class) {
                if (a == null) {
                    a = new ni8();
                }
                ni8Var = a;
            }
            return ni8Var;
        }
        return (ni8) invokeV.objValue;
    }
}
