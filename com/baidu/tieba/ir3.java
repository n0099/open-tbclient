package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ir3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hr3 a() {
        InterceptResult invokeV;
        hr3 hr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ir3.class) {
                if (a == null) {
                    a = new hr3();
                }
                hr3Var = a;
            }
            return hr3Var;
        }
        return (hr3) invokeV.objValue;
    }
}
