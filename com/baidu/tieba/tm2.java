package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class tm2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sm2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sm2 a() {
        InterceptResult invokeV;
        sm2 sm2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tm2.class) {
                if (a == null) {
                    a = new sm2();
                }
                sm2Var = a;
            }
            return sm2Var;
        }
        return (sm2) invokeV.objValue;
    }
}
