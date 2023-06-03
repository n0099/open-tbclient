package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hv2 a() {
        InterceptResult invokeV;
        hv2 hv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iv2.class) {
                if (a == null) {
                    a = new hv2();
                }
                hv2Var = a;
            }
            return hv2Var;
        }
        return (hv2) invokeV.objValue;
    }
}
