package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class uh8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile th8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized th8 a() {
        InterceptResult invokeV;
        th8 th8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uh8.class) {
                if (a == null) {
                    a = new th8();
                }
                th8Var = a;
            }
            return th8Var;
        }
        return (th8) invokeV.objValue;
    }
}
