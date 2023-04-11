package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ju3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile iu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized iu3 a() {
        InterceptResult invokeV;
        iu3 iu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ju3.class) {
                if (a == null) {
                    a = new iu3();
                }
                iu3Var = a;
            }
            return iu3Var;
        }
        return (iu3) invokeV.objValue;
    }
}
