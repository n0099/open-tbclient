package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class rz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qz3 a() {
        InterceptResult invokeV;
        qz3 qz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rz3.class) {
                if (a == null) {
                    a = new qz3();
                }
                qz3Var = a;
            }
            return qz3Var;
        }
        return (qz3) invokeV.objValue;
    }
}
