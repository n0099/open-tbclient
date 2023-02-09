package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tw8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sw8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sw8 a() {
        InterceptResult invokeV;
        sw8 sw8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tw8.class) {
                if (a == null) {
                    a = new sw8();
                }
                sw8Var = a;
            }
            return sw8Var;
        }
        return (sw8) invokeV.objValue;
    }
}
