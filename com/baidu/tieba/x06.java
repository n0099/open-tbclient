package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x06 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w06 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w06 a() {
        InterceptResult invokeV;
        w06 w06Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x06.class) {
                if (a == null) {
                    a = new w06();
                }
                w06Var = a;
            }
            return w06Var;
        }
        return (w06) invokeV.objValue;
    }
}
