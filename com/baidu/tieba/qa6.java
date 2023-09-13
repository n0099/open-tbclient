package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qa6 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pa6 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pa6 a() {
        InterceptResult invokeV;
        pa6 pa6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qa6.class) {
                if (a == null) {
                    a = new pa6();
                }
                pa6Var = a;
            }
            return pa6Var;
        }
        return (pa6) invokeV.objValue;
    }
}
