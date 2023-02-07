package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rx0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qx0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qx0 a() {
        InterceptResult invokeV;
        qx0 qx0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rx0.class) {
                if (a == null) {
                    a = new qx0();
                }
                qx0Var = a;
            }
            return qx0Var;
        }
        return (qx0) invokeV.objValue;
    }
}
