package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class sa4 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ra4 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ra4 a() {
        InterceptResult invokeV;
        ra4 ra4Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sa4.class) {
                if (a == null) {
                    a = new ra4();
                }
                ra4Var = a;
            }
            return ra4Var;
        }
        return (ra4) invokeV.objValue;
    }
}
