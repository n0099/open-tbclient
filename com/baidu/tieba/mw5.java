package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mw5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lw5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lw5 a() {
        InterceptResult invokeV;
        lw5 lw5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mw5.class) {
                if (a == null) {
                    a = new lw5();
                }
                lw5Var = a;
            }
            return lw5Var;
        }
        return (lw5) invokeV.objValue;
    }
}
