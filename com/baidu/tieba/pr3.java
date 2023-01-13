package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class pr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile or3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized or3 a() {
        InterceptResult invokeV;
        or3 or3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pr3.class) {
                if (a == null) {
                    a = new or3();
                }
                or3Var = a;
            }
            return or3Var;
        }
        return (or3) invokeV.objValue;
    }
}
