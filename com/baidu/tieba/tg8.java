package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class tg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sg8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sg8 a() {
        InterceptResult invokeV;
        sg8 sg8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tg8.class) {
                if (a == null) {
                    a = new sg8();
                }
                sg8Var = a;
            }
            return sg8Var;
        }
        return (sg8) invokeV.objValue;
    }
}
