package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rx9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qx9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qx9 a() {
        InterceptResult invokeV;
        qx9 qx9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rx9.class) {
                if (a == null) {
                    a = new qx9();
                }
                qx9Var = a;
            }
            return qx9Var;
        }
        return (qx9) invokeV.objValue;
    }
}
