package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class un8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tn8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tn8 a() {
        InterceptResult invokeV;
        tn8 tn8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (un8.class) {
                if (a == null) {
                    a = new tn8();
                }
                tn8Var = a;
            }
            return tn8Var;
        }
        return (tn8) invokeV.objValue;
    }
}
