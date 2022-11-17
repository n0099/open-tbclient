package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class rk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qk8 a() {
        InterceptResult invokeV;
        qk8 qk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rk8.class) {
                if (a == null) {
                    a = new qk8();
                }
                qk8Var = a;
            }
            return qk8Var;
        }
        return (qk8) invokeV.objValue;
    }
}
