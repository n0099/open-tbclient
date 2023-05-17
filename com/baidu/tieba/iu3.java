package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class iu3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile hu3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized hu3 a() {
        InterceptResult invokeV;
        hu3 hu3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (iu3.class) {
                if (a == null) {
                    a = new hu3();
                }
                hu3Var = a;
            }
            return hu3Var;
        }
        return (hu3) invokeV.objValue;
    }
}
