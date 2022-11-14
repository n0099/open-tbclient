package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class q64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p64 a() {
        InterceptResult invokeV;
        p64 p64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q64.class) {
                if (a == null) {
                    a = new p64();
                }
                p64Var = a;
            }
            return p64Var;
        }
        return (p64) invokeV.objValue;
    }
}
