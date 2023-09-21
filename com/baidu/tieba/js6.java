package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class js6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile is6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized is6 a() {
        InterceptResult invokeV;
        is6 is6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (js6.class) {
                if (a == null) {
                    a = new is6();
                }
                is6Var = a;
            }
            return is6Var;
        }
        return (is6) invokeV.objValue;
    }
}
