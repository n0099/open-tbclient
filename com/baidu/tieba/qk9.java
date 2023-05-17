package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qk9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pk9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pk9 a() {
        InterceptResult invokeV;
        pk9 pk9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qk9.class) {
                if (a == null) {
                    a = new pk9();
                }
                pk9Var = a;
            }
            return pk9Var;
        }
        return (pk9) invokeV.objValue;
    }
}
