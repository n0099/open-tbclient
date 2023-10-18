package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class o14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile n14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized n14 a() {
        InterceptResult invokeV;
        n14 n14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (o14.class) {
                if (a == null) {
                    a = new n14();
                }
                n14Var = a;
            }
            return n14Var;
        }
        return (n14) invokeV.objValue;
    }
}
