package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class it3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ht3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ht3 a() {
        InterceptResult invokeV;
        ht3 ht3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (it3.class) {
                if (a == null) {
                    a = new ht3();
                }
                ht3Var = a;
            }
            return ht3Var;
        }
        return (ht3) invokeV.objValue;
    }
}
