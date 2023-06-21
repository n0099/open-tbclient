package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class sc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rc4 a() {
        InterceptResult invokeV;
        rc4 rc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sc4.class) {
                if (a == null) {
                    a = new rc4();
                }
                rc4Var = a;
            }
            return rc4Var;
        }
        return (rc4) invokeV.objValue;
    }
}
