package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lk9 a() {
        InterceptResult invokeV;
        lk9 lk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mk9.class) {
                if (a == null) {
                    a = new lk9();
                }
                lk9Var = a;
            }
            return lk9Var;
        }
        return (lk9) invokeV.objValue;
    }
}
