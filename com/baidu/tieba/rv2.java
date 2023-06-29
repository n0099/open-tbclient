package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rv2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qv2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qv2 a() {
        InterceptResult invokeV;
        qv2 qv2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rv2.class) {
                if (a == null) {
                    a = new qv2();
                }
                qv2Var = a;
            }
            return qv2Var;
        }
        return (qv2) invokeV.objValue;
    }
}
