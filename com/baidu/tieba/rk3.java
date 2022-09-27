package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class rk3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qk3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qk3 a() {
        InterceptResult invokeV;
        qk3 qk3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rk3.class) {
                if (a == null) {
                    a = new qk3();
                }
                qk3Var = a;
            }
            return qk3Var;
        }
        return (qk3) invokeV.objValue;
    }
}
