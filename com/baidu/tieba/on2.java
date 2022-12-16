package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class on2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nn2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nn2 a() {
        InterceptResult invokeV;
        nn2 nn2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (on2.class) {
                if (a == null) {
                    a = new nn2();
                }
                nn2Var = a;
            }
            return nn2Var;
        }
        return (nn2) invokeV.objValue;
    }
}
