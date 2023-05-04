package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mi9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile li9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized li9 a() {
        InterceptResult invokeV;
        li9 li9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mi9.class) {
                if (a == null) {
                    a = new li9();
                }
                li9Var = a;
            }
            return li9Var;
        }
        return (li9) invokeV.objValue;
    }
}
