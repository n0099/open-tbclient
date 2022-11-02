package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class qk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pk8 a() {
        InterceptResult invokeV;
        pk8 pk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qk8.class) {
                if (a == null) {
                    a = new pk8();
                }
                pk8Var = a;
            }
            return pk8Var;
        }
        return (pk8) invokeV.objValue;
    }
}
