package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile su3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized su3 a() {
        InterceptResult invokeV;
        su3 su3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tu3.class) {
                if (a == null) {
                    a = new su3();
                }
                su3Var = a;
            }
            return su3Var;
        }
        return (su3) invokeV.objValue;
    }
}
