package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s66 a() {
        InterceptResult invokeV;
        s66 s66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t66.class) {
                if (a == null) {
                    a = new s66();
                }
                s66Var = a;
            }
            return s66Var;
        }
        return (s66) invokeV.objValue;
    }
}
