package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x04 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w04 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w04 a() {
        InterceptResult invokeV;
        w04 w04Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x04.class) {
                if (a == null) {
                    a = new w04();
                }
                w04Var = a;
            }
            return w04Var;
        }
        return (w04) invokeV.objValue;
    }
}
