package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class or3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nr3 a() {
        InterceptResult invokeV;
        nr3 nr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (or3.class) {
                if (a == null) {
                    a = new nr3();
                }
                nr3Var = a;
            }
            return nr3Var;
        }
        return (nr3) invokeV.objValue;
    }
}
