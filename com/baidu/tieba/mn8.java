package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mn8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ln8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ln8 a() {
        InterceptResult invokeV;
        ln8 ln8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mn8.class) {
                if (a == null) {
                    a = new ln8();
                }
                ln8Var = a;
            }
            return ln8Var;
        }
        return (ln8) invokeV.objValue;
    }
}
