package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class it0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ht0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ht0 a() {
        InterceptResult invokeV;
        ht0 ht0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (it0.class) {
                if (a == null) {
                    a = new ht0();
                }
                ht0Var = a;
            }
            return ht0Var;
        }
        return (ht0) invokeV.objValue;
    }
}
