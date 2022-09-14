package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x91 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w91 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w91 a() {
        InterceptResult invokeV;
        w91 w91Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x91.class) {
                if (a == null) {
                    a = new w91();
                }
                w91Var = a;
            }
            return w91Var;
        }
        return (w91) invokeV.objValue;
    }
}
