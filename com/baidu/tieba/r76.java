package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class r76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q76 a() {
        InterceptResult invokeV;
        q76 q76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r76.class) {
                if (a == null) {
                    a = new q76();
                }
                q76Var = a;
            }
            return q76Var;
        }
        return (q76) invokeV.objValue;
    }
}
