package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class um3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tm3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tm3 a() {
        InterceptResult invokeV;
        tm3 tm3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (um3.class) {
                if (a == null) {
                    a = new tm3();
                }
                tm3Var = a;
            }
            return tm3Var;
        }
        return (tm3) invokeV.objValue;
    }
}
