package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ns2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ms2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ms2 a() {
        InterceptResult invokeV;
        ms2 ms2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ns2.class) {
                if (a == null) {
                    a = new ms2();
                }
                ms2Var = a;
            }
            return ms2Var;
        }
        return (ms2) invokeV.objValue;
    }
}
