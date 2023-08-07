package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r1a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q1a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q1a a() {
        InterceptResult invokeV;
        q1a q1aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r1a.class) {
                if (a == null) {
                    a = new q1a();
                }
                q1aVar = a;
            }
            return q1aVar;
        }
        return (q1a) invokeV.objValue;
    }
}
