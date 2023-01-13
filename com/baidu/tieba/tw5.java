package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tw5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sw5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sw5 a() {
        InterceptResult invokeV;
        sw5 sw5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tw5.class) {
                if (a == null) {
                    a = new sw5();
                }
                sw5Var = a;
            }
            return sw5Var;
        }
        return (sw5) invokeV.objValue;
    }
}
