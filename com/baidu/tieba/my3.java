package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class my3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ly3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ly3 a() {
        InterceptResult invokeV;
        ly3 ly3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (my3.class) {
                if (a == null) {
                    a = new ly3();
                }
                ly3Var = a;
            }
            return ly3Var;
        }
        return (ly3) invokeV.objValue;
    }
}
