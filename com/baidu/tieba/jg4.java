package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jg4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ig4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ig4 a() {
        InterceptResult invokeV;
        ig4 ig4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jg4.class) {
                if (a == null) {
                    a = new ig4();
                }
                ig4Var = a;
            }
            return ig4Var;
        }
        return (ig4) invokeV.objValue;
    }
}
