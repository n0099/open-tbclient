package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class rw5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qw5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qw5 a() {
        InterceptResult invokeV;
        qw5 qw5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rw5.class) {
                if (a == null) {
                    a = new qw5();
                }
                qw5Var = a;
            }
            return qw5Var;
        }
        return (qw5) invokeV.objValue;
    }
}
