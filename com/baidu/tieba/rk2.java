package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class rk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qk2 a() {
        InterceptResult invokeV;
        qk2 qk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rk2.class) {
                if (a == null) {
                    a = new qk2();
                }
                qk2Var = a;
            }
            return qk2Var;
        }
        return (qk2) invokeV.objValue;
    }
}
