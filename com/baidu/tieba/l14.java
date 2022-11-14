package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class l14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile k14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized k14 a() {
        InterceptResult invokeV;
        k14 k14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (l14.class) {
                if (a == null) {
                    a = new k14();
                }
                k14Var = a;
            }
            return k14Var;
        }
        return (k14) invokeV.objValue;
    }
}
