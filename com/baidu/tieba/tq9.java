package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tq9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sq9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sq9 a() {
        InterceptResult invokeV;
        sq9 sq9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tq9.class) {
                if (a == null) {
                    a = new sq9();
                }
                sq9Var = a;
            }
            return sq9Var;
        }
        return (sq9) invokeV.objValue;
    }
}
