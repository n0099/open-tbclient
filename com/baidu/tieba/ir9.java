package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ir9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hr9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hr9 a() {
        InterceptResult invokeV;
        hr9 hr9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ir9.class) {
                if (a == null) {
                    a = new hr9();
                }
                hr9Var = a;
            }
            return hr9Var;
        }
        return (hr9) invokeV.objValue;
    }
}
