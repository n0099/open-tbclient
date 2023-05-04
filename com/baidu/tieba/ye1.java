package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ye1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xe1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xe1 a() {
        InterceptResult invokeV;
        xe1 xe1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ye1.class) {
                if (a == null) {
                    a = new xe1();
                }
                xe1Var = a;
            }
            return xe1Var;
        }
        return (xe1) invokeV.objValue;
    }
}
