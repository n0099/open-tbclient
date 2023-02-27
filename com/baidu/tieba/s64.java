package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class s64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r64 a() {
        InterceptResult invokeV;
        r64 r64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s64.class) {
                if (a == null) {
                    a = new r64();
                }
                r64Var = a;
            }
            return r64Var;
        }
        return (r64) invokeV.objValue;
    }
}
