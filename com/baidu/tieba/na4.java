package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class na4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ma4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ma4 a() {
        InterceptResult invokeV;
        ma4 ma4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (na4.class) {
                if (a == null) {
                    a = new ma4();
                }
                ma4Var = a;
            }
            return ma4Var;
        }
        return (ma4) invokeV.objValue;
    }
}
