package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class s34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r34 a() {
        InterceptResult invokeV;
        r34 r34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s34.class) {
                if (a == null) {
                    a = new r34();
                }
                r34Var = a;
            }
            return r34Var;
        }
        return (r34) invokeV.objValue;
    }
}
