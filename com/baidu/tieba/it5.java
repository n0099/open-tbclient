package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class it5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ht5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ht5 a() {
        InterceptResult invokeV;
        ht5 ht5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (it5.class) {
                if (a == null) {
                    a = new ht5();
                }
                ht5Var = a;
            }
            return ht5Var;
        }
        return (ht5) invokeV.objValue;
    }
}
