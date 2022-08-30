package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class v14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u14 a() {
        InterceptResult invokeV;
        u14 u14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v14.class) {
                if (a == null) {
                    a = new u14();
                }
                u14Var = a;
            }
            return u14Var;
        }
        return (u14) invokeV.objValue;
    }
}
