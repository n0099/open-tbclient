package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class io3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ho3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ho3 a() {
        InterceptResult invokeV;
        ho3 ho3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (io3.class) {
                if (a == null) {
                    a = new ho3();
                }
                ho3Var = a;
            }
            return ho3Var;
        }
        return (ho3) invokeV.objValue;
    }
}
