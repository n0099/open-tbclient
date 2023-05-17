package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class la4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ka4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ka4 a() {
        InterceptResult invokeV;
        ka4 ka4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (la4.class) {
                if (a == null) {
                    a = new ka4();
                }
                ka4Var = a;
            }
            return ka4Var;
        }
        return (ka4) invokeV.objValue;
    }
}
