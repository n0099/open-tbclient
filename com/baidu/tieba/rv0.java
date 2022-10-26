package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class rv0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qv0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qv0 a() {
        InterceptResult invokeV;
        qv0 qv0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rv0.class) {
                if (a == null) {
                    a = new qv0();
                }
                qv0Var = a;
            }
            return qv0Var;
        }
        return (qv0) invokeV.objValue;
    }
}
