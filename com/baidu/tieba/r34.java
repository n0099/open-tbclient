package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class r34 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q34 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q34 a() {
        InterceptResult invokeV;
        q34 q34Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r34.class) {
                if (a == null) {
                    a = new q34();
                }
                q34Var = a;
            }
            return q34Var;
        }
        return (q34) invokeV.objValue;
    }
}
