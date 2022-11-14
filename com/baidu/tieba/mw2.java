package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mw2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lw2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lw2 a() {
        InterceptResult invokeV;
        lw2 lw2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mw2.class) {
                if (a == null) {
                    a = new lw2();
                }
                lw2Var = a;
            }
            return lw2Var;
        }
        return (lw2) invokeV.objValue;
    }
}
