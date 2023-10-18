package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vs3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile us3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized us3 a() {
        InterceptResult invokeV;
        us3 us3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vs3.class) {
                if (a == null) {
                    a = new us3();
                }
                us3Var = a;
            }
            return us3Var;
        }
        return (us3) invokeV.objValue;
    }
}
