package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qt9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pt9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pt9 a() {
        InterceptResult invokeV;
        pt9 pt9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qt9.class) {
                if (a == null) {
                    a = new pt9();
                }
                pt9Var = a;
            }
            return pt9Var;
        }
        return (pt9) invokeV.objValue;
    }
}
