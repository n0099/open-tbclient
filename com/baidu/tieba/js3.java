package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class js3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile is3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized is3 a() {
        InterceptResult invokeV;
        is3 is3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (js3.class) {
                if (a == null) {
                    a = new is3();
                }
                is3Var = a;
            }
            return is3Var;
        }
        return (is3) invokeV.objValue;
    }
}
