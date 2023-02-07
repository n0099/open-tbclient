package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u44 a() {
        InterceptResult invokeV;
        u44 u44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v44.class) {
                if (a == null) {
                    a = new u44();
                }
                u44Var = a;
            }
            return u44Var;
        }
        return (u44) invokeV.objValue;
    }
}
