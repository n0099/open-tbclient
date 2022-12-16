package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class iv5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hv5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hv5 a() {
        InterceptResult invokeV;
        hv5 hv5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iv5.class) {
                if (a == null) {
                    a = new hv5();
                }
                hv5Var = a;
            }
            return hv5Var;
        }
        return (hv5) invokeV.objValue;
    }
}
