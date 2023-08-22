package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ly3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ky3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ky3 a() {
        InterceptResult invokeV;
        ky3 ky3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ly3.class) {
                if (a == null) {
                    a = new ky3();
                }
                ky3Var = a;
            }
            return ky3Var;
        }
        return (ky3) invokeV.objValue;
    }
}
