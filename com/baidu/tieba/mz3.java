package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mz3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lz3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lz3 a() {
        InterceptResult invokeV;
        lz3 lz3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mz3.class) {
                if (a == null) {
                    a = new lz3();
                }
                lz3Var = a;
            }
            return lz3Var;
        }
        return (lz3) invokeV.objValue;
    }
}
