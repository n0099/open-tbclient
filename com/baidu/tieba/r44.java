package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class r44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q44 a() {
        InterceptResult invokeV;
        q44 q44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r44.class) {
                if (a == null) {
                    a = new q44();
                }
                q44Var = a;
            }
            return q44Var;
        }
        return (q44) invokeV.objValue;
    }
}
