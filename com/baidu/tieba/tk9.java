package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sk9 a() {
        InterceptResult invokeV;
        sk9 sk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tk9.class) {
                if (a == null) {
                    a = new sk9();
                }
                sk9Var = a;
            }
            return sk9Var;
        }
        return (sk9) invokeV.objValue;
    }
}
