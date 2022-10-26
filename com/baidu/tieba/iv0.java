package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class iv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hv0 a() {
        InterceptResult invokeV;
        hv0 hv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iv0.class) {
                if (a == null) {
                    a = new hv0();
                }
                hv0Var = a;
            }
            return hv0Var;
        }
        return (hv0) invokeV.objValue;
    }
}
