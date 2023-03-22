package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ir2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hr2 a() {
        InterceptResult invokeV;
        hr2 hr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ir2.class) {
                if (a == null) {
                    a = new hr2();
                }
                hr2Var = a;
            }
            return hr2Var;
        }
        return (hr2) invokeV.objValue;
    }
}
