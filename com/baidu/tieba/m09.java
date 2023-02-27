package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class m09 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l09 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l09 a() {
        InterceptResult invokeV;
        l09 l09Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m09.class) {
                if (a == null) {
                    a = new l09();
                }
                l09Var = a;
            }
            return l09Var;
        }
        return (l09) invokeV.objValue;
    }
}
