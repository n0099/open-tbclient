package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class kp2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jp2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jp2 a() {
        InterceptResult invokeV;
        jp2 jp2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kp2.class) {
                if (a == null) {
                    a = new jp2();
                }
                jp2Var = a;
            }
            return jp2Var;
        }
        return (jp2) invokeV.objValue;
    }
}
