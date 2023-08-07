package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j4a a() {
        InterceptResult invokeV;
        j4a j4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k4a.class) {
                if (a == null) {
                    a = new j4a();
                }
                j4aVar = a;
            }
            return j4aVar;
        }
        return (j4a) invokeV.objValue;
    }
}
