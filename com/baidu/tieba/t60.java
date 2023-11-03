package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t60 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s60 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s60 a() {
        InterceptResult invokeV;
        s60 s60Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t60.class) {
                if (a == null) {
                    a = new s60();
                }
                s60Var = a;
            }
            return s60Var;
        }
        return (s60) invokeV.objValue;
    }
}
