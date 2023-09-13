package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qw3 a() {
        InterceptResult invokeV;
        qw3 qw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rw3.class) {
                if (a == null) {
                    a = new qw3();
                }
                qw3Var = a;
            }
            return qw3Var;
        }
        return (qw3) invokeV.objValue;
    }
}
