package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sw3 a() {
        InterceptResult invokeV;
        sw3 sw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tw3.class) {
                if (a == null) {
                    a = new sw3();
                }
                sw3Var = a;
            }
            return sw3Var;
        }
        return (sw3) invokeV.objValue;
    }
}
