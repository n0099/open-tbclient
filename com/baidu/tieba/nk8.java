package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nk8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mk8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mk8 a() {
        InterceptResult invokeV;
        mk8 mk8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nk8.class) {
                if (a == null) {
                    a = new mk8();
                }
                mk8Var = a;
            }
            return mk8Var;
        }
        return (mk8) invokeV.objValue;
    }
}
