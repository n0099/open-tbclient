package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jx9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ix9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ix9 a() {
        InterceptResult invokeV;
        ix9 ix9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jx9.class) {
                if (a == null) {
                    a = new ix9();
                }
                ix9Var = a;
            }
            return ix9Var;
        }
        return (ix9) invokeV.objValue;
    }
}
