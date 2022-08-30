package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tm3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sm3 a() {
        InterceptResult invokeV;
        sm3 sm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tm3.class) {
                if (a == null) {
                    a = new sm3();
                }
                sm3Var = a;
            }
            return sm3Var;
        }
        return (sm3) invokeV.objValue;
    }
}
