package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lu3 a() {
        InterceptResult invokeV;
        lu3 lu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mu3.class) {
                if (a == null) {
                    a = new lu3();
                }
                lu3Var = a;
            }
            return lu3Var;
        }
        return (lu3) invokeV.objValue;
    }
}
