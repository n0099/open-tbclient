package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class kr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile jr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized jr3 a() {
        InterceptResult invokeV;
        jr3 jr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (kr3.class) {
                if (a == null) {
                    a = new jr3();
                }
                jr3Var = a;
            }
            return jr3Var;
        }
        return (jr3) invokeV.objValue;
    }
}
