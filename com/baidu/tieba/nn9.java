package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nn9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mn9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mn9 a() {
        InterceptResult invokeV;
        mn9 mn9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nn9.class) {
                if (a == null) {
                    a = new mn9();
                }
                mn9Var = a;
            }
            return mn9Var;
        }
        return (mn9) invokeV.objValue;
    }
}
