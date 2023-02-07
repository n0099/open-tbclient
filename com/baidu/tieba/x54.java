package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w54 a() {
        InterceptResult invokeV;
        w54 w54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x54.class) {
                if (a == null) {
                    a = new w54();
                }
                w54Var = a;
            }
            return w54Var;
        }
        return (w54) invokeV.objValue;
    }
}
