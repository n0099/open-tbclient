package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lt3 a() {
        InterceptResult invokeV;
        lt3 lt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mt3.class) {
                if (a == null) {
                    a = new lt3();
                }
                lt3Var = a;
            }
            return lt3Var;
        }
        return (lt3) invokeV.objValue;
    }
}
