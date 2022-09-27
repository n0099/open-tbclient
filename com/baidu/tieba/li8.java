package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class li8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ki8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ki8 a() {
        InterceptResult invokeV;
        ki8 ki8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (li8.class) {
                if (a == null) {
                    a = new ki8();
                }
                ki8Var = a;
            }
            return ki8Var;
        }
        return (ki8) invokeV.objValue;
    }
}
