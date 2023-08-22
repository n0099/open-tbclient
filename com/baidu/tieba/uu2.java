package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uu2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tu2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tu2 a() {
        InterceptResult invokeV;
        tu2 tu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uu2.class) {
                if (a == null) {
                    a = new tu2();
                }
                tu2Var = a;
            }
            return tu2Var;
        }
        return (tu2) invokeV.objValue;
    }
}
