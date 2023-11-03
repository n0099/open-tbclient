package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ma4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile la4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized la4 a() {
        InterceptResult invokeV;
        la4 la4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ma4.class) {
                if (a == null) {
                    a = new la4();
                }
                la4Var = a;
            }
            return la4Var;
        }
        return (la4) invokeV.objValue;
    }
}
