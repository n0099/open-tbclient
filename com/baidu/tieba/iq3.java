package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class iq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hq3 a() {
        InterceptResult invokeV;
        hq3 hq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iq3.class) {
                if (a == null) {
                    a = new hq3();
                }
                hq3Var = a;
            }
            return hq3Var;
        }
        return (hq3) invokeV.objValue;
    }
}
