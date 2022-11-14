package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mw0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lw0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lw0 a() {
        InterceptResult invokeV;
        lw0 lw0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mw0.class) {
                if (a == null) {
                    a = new lw0();
                }
                lw0Var = a;
            }
            return lw0Var;
        }
        return (lw0) invokeV.objValue;
    }
}
