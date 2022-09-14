package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class so3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ro3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ro3 a() {
        InterceptResult invokeV;
        ro3 ro3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (so3.class) {
                if (a == null) {
                    a = new ro3();
                }
                ro3Var = a;
            }
            return ro3Var;
        }
        return (ro3) invokeV.objValue;
    }
}
