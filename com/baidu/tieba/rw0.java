package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qw0 a() {
        InterceptResult invokeV;
        qw0 qw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rw0.class) {
                if (a == null) {
                    a = new qw0();
                }
                qw0Var = a;
            }
            return qw0Var;
        }
        return (qw0) invokeV.objValue;
    }
}
