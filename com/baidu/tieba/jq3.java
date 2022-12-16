package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class jq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized iq3 a() {
        InterceptResult invokeV;
        iq3 iq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jq3.class) {
                if (a == null) {
                    a = new iq3();
                }
                iq3Var = a;
            }
            return iq3Var;
        }
        return (iq3) invokeV.objValue;
    }
}
