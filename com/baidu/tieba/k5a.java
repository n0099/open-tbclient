package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k5a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j5a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j5a a() {
        InterceptResult invokeV;
        j5a j5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k5a.class) {
                if (a == null) {
                    a = new j5a();
                }
                j5aVar = a;
            }
            return j5aVar;
        }
        return (j5a) invokeV.objValue;
    }
}
