package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kr2 a() {
        InterceptResult invokeV;
        kr2 kr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lr2.class) {
                if (a == null) {
                    a = new kr2();
                }
                kr2Var = a;
            }
            return kr2Var;
        }
        return (kr2) invokeV.objValue;
    }
}
