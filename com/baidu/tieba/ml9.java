package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ml9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ll9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ll9 a() {
        InterceptResult invokeV;
        ll9 ll9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ml9.class) {
                if (a == null) {
                    a = new ll9();
                }
                ll9Var = a;
            }
            return ll9Var;
        }
        return (ll9) invokeV.objValue;
    }
}
