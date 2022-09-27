package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tq3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sq3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sq3 a() {
        InterceptResult invokeV;
        sq3 sq3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tq3.class) {
                if (a == null) {
                    a = new sq3();
                }
                sq3Var = a;
            }
            return sq3Var;
        }
        return (sq3) invokeV.objValue;
    }
}
