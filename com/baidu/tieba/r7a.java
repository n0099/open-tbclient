package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r7a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q7a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q7a a() {
        InterceptResult invokeV;
        q7a q7aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r7a.class) {
                if (a == null) {
                    a = new q7a();
                }
                q7aVar = a;
            }
            return q7aVar;
        }
        return (q7a) invokeV.objValue;
    }
}
