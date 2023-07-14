package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class ug1 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tg1 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tg1 a() {
        InterceptResult invokeV;
        tg1 tg1Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ug1.class) {
                if (a == null) {
                    a = new tg1();
                }
                tg1Var = a;
            }
            return tg1Var;
        }
        return (tg1) invokeV.objValue;
    }
}
