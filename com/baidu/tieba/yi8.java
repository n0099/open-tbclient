package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class yi8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xi8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xi8 a() {
        InterceptResult invokeV;
        xi8 xi8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yi8.class) {
                if (a == null) {
                    a = new xi8();
                }
                xi8Var = a;
            }
            return xi8Var;
        }
        return (xi8) invokeV.objValue;
    }
}
