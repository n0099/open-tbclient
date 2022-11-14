package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lk8 a() {
        InterceptResult invokeV;
        lk8 lk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mk8.class) {
                if (a == null) {
                    a = new lk8();
                }
                lk8Var = a;
            }
            return lk8Var;
        }
        return (lk8) invokeV.objValue;
    }
}
