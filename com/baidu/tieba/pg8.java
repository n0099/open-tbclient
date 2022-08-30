package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pg8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile og8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized og8 a() {
        InterceptResult invokeV;
        og8 og8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pg8.class) {
                if (a == null) {
                    a = new og8();
                }
                og8Var = a;
            }
            return og8Var;
        }
        return (og8) invokeV.objValue;
    }
}
