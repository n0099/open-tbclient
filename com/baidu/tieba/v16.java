package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v16 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u16 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u16 a() {
        InterceptResult invokeV;
        u16 u16Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v16.class) {
                if (a == null) {
                    a = new u16();
                }
                u16Var = a;
            }
            return u16Var;
        }
        return (u16) invokeV.objValue;
    }
}
