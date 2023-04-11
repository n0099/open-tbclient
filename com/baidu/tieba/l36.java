package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class l36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k36 a() {
        InterceptResult invokeV;
        k36 k36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l36.class) {
                if (a == null) {
                    a = new k36();
                }
                k36Var = a;
            }
            return k36Var;
        }
        return (k36) invokeV.objValue;
    }
}
