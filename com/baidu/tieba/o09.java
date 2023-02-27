package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class o09 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n09 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n09 a() {
        InterceptResult invokeV;
        n09 n09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o09.class) {
                if (a == null) {
                    a = new n09();
                }
                n09Var = a;
            }
            return n09Var;
        }
        return (n09) invokeV.objValue;
    }
}
