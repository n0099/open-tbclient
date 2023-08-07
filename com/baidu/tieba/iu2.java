package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iu2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hu2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hu2 a() {
        InterceptResult invokeV;
        hu2 hu2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iu2.class) {
                if (a == null) {
                    a = new hu2();
                }
                hu2Var = a;
            }
            return hu2Var;
        }
        return (hu2) invokeV.objValue;
    }
}
