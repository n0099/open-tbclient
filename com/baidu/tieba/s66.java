package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class s66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile r66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized r66 a() {
        InterceptResult invokeV;
        r66 r66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (s66.class) {
                if (a == null) {
                    a = new r66();
                }
                r66Var = a;
            }
            return r66Var;
        }
        return (r66) invokeV.objValue;
    }
}
