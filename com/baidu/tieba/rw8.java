package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rw8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qw8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qw8 a() {
        InterceptResult invokeV;
        qw8 qw8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rw8.class) {
                if (a == null) {
                    a = new qw8();
                }
                qw8Var = a;
            }
            return qw8Var;
        }
        return (qw8) invokeV.objValue;
    }
}
