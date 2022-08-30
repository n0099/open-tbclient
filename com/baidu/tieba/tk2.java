package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tk2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sk2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sk2 a() {
        InterceptResult invokeV;
        sk2 sk2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tk2.class) {
                if (a == null) {
                    a = new sk2();
                }
                sk2Var = a;
            }
            return sk2Var;
        }
        return (sk2) invokeV.objValue;
    }
}
