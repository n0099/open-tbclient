package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p24 a() {
        InterceptResult invokeV;
        p24 p24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q24.class) {
                if (a == null) {
                    a = new p24();
                }
                p24Var = a;
            }
            return p24Var;
        }
        return (p24) invokeV.objValue;
    }
}
