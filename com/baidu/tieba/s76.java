package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class s76 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r76 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r76 a() {
        InterceptResult invokeV;
        r76 r76Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s76.class) {
                if (a == null) {
                    a = new r76();
                }
                r76Var = a;
            }
            return r76Var;
        }
        return (r76) invokeV.objValue;
    }
}
