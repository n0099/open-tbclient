package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ny2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile my2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized my2 a() {
        InterceptResult invokeV;
        my2 my2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ny2.class) {
                if (a == null) {
                    a = new my2();
                }
                my2Var = a;
            }
            return my2Var;
        }
        return (my2) invokeV.objValue;
    }
}
