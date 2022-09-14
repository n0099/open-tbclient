package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class lr5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kr5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kr5 a() {
        InterceptResult invokeV;
        kr5 kr5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lr5.class) {
                if (a == null) {
                    a = new kr5();
                }
                kr5Var = a;
            }
            return kr5Var;
        }
        return (kr5) invokeV.objValue;
    }
}
