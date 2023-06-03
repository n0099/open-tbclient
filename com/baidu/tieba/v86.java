package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class v86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile u86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized u86 a() {
        InterceptResult invokeV;
        u86 u86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (v86.class) {
                if (a == null) {
                    a = new u86();
                }
                u86Var = a;
            }
            return u86Var;
        }
        return (u86) invokeV.objValue;
    }
}
