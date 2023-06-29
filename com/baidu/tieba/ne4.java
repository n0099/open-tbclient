package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ne4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile me4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized me4 a() {
        InterceptResult invokeV;
        me4 me4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ne4.class) {
                if (a == null) {
                    a = new me4();
                }
                me4Var = a;
            }
            return me4Var;
        }
        return (me4) invokeV.objValue;
    }
}
