package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class lr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kr3 a() {
        InterceptResult invokeV;
        kr3 kr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lr3.class) {
                if (a == null) {
                    a = new kr3();
                }
                kr3Var = a;
            }
            return kr3Var;
        }
        return (kr3) invokeV.objValue;
    }
}
