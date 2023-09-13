package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mc4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lc4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lc4 a() {
        InterceptResult invokeV;
        lc4 lc4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mc4.class) {
                if (a == null) {
                    a = new lc4();
                }
                lc4Var = a;
            }
            return lc4Var;
        }
        return (lc4) invokeV.objValue;
    }
}
