package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pr9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile or9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized or9 a() {
        InterceptResult invokeV;
        or9 or9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pr9.class) {
                if (a == null) {
                    a = new or9();
                }
                or9Var = a;
            }
            return or9Var;
        }
        return (or9) invokeV.objValue;
    }
}
