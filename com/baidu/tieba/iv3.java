package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class iv3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hv3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hv3 a() {
        InterceptResult invokeV;
        hv3 hv3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iv3.class) {
                if (a == null) {
                    a = new hv3();
                }
                hv3Var = a;
            }
            return hv3Var;
        }
        return (hv3) invokeV.objValue;
    }
}
