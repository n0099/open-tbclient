package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qk9 a() {
        InterceptResult invokeV;
        qk9 qk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rk9.class) {
                if (a == null) {
                    a = new qk9();
                }
                qk9Var = a;
            }
            return qk9Var;
        }
        return (qk9) invokeV.objValue;
    }
}
