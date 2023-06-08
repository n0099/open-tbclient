package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kr9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kr9 a() {
        InterceptResult invokeV;
        kr9 kr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lr9.class) {
                if (a == null) {
                    a = new kr9();
                }
                kr9Var = a;
            }
            return kr9Var;
        }
        return (kr9) invokeV.objValue;
    }
}
