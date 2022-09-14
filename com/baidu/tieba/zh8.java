package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class zh8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile yh8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized yh8 a() {
        InterceptResult invokeV;
        yh8 yh8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (zh8.class) {
                if (a == null) {
                    a = new yh8();
                }
                yh8Var = a;
            }
            return yh8Var;
        }
        return (yh8) invokeV.objValue;
    }
}
