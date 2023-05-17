package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mw3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lw3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lw3 a() {
        InterceptResult invokeV;
        lw3 lw3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mw3.class) {
                if (a == null) {
                    a = new lw3();
                }
                lw3Var = a;
            }
            return lw3Var;
        }
        return (lw3) invokeV.objValue;
    }
}
