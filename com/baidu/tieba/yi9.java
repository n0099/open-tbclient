package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class yi9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xi9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xi9 a() {
        InterceptResult invokeV;
        xi9 xi9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yi9.class) {
                if (a == null) {
                    a = new xi9();
                }
                xi9Var = a;
            }
            return xi9Var;
        }
        return (xi9) invokeV.objValue;
    }
}
