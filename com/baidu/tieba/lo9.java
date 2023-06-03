package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lo9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ko9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ko9 a() {
        InterceptResult invokeV;
        ko9 ko9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lo9.class) {
                if (a == null) {
                    a = new ko9();
                }
                ko9Var = a;
            }
            return ko9Var;
        }
        return (ko9) invokeV.objValue;
    }
}
