package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sr8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rr8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rr8 a() {
        InterceptResult invokeV;
        rr8 rr8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sr8.class) {
                if (a == null) {
                    a = new rr8();
                }
                rr8Var = a;
            }
            return rr8Var;
        }
        return (rr8) invokeV.objValue;
    }
}
