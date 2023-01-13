package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class js8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile is8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized is8 a() {
        InterceptResult invokeV;
        is8 is8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (js8.class) {
                if (a == null) {
                    a = new is8();
                }
                is8Var = a;
            }
            return is8Var;
        }
        return (is8) invokeV.objValue;
    }
}
