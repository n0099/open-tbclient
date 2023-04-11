package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pf9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile of9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized of9 a() {
        InterceptResult invokeV;
        of9 of9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pf9.class) {
                if (a == null) {
                    a = new of9();
                }
                of9Var = a;
            }
            return of9Var;
        }
        return (of9) invokeV.objValue;
    }
}
