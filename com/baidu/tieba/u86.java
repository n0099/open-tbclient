package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class u86 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile t86 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized t86 a() {
        InterceptResult invokeV;
        t86 t86Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (u86.class) {
                if (a == null) {
                    a = new t86();
                }
                t86Var = a;
            }
            return t86Var;
        }
        return (t86) invokeV.objValue;
    }
}
