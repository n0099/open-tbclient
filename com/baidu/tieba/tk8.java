package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sk8 a() {
        InterceptResult invokeV;
        sk8 sk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tk8.class) {
                if (a == null) {
                    a = new sk8();
                }
                sk8Var = a;
            }
            return sk8Var;
        }
        return (sk8) invokeV.objValue;
    }
}
