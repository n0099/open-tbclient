package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v24 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u24 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u24 a() {
        InterceptResult invokeV;
        u24 u24Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v24.class) {
                if (a == null) {
                    a = new u24();
                }
                u24Var = a;
            }
            return u24Var;
        }
        return (u24) invokeV.objValue;
    }
}
