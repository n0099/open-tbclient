package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mg9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lg9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lg9 a() {
        InterceptResult invokeV;
        lg9 lg9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mg9.class) {
                if (a == null) {
                    a = new lg9();
                }
                lg9Var = a;
            }
            return lg9Var;
        }
        return (lg9) invokeV.objValue;
    }
}
