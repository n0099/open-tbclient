package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class l64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k64 a() {
        InterceptResult invokeV;
        k64 k64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l64.class) {
                if (a == null) {
                    a = new k64();
                }
                k64Var = a;
            }
            return k64Var;
        }
        return (k64) invokeV.objValue;
    }
}
