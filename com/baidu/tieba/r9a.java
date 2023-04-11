package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class r9a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q9a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q9a a() {
        InterceptResult invokeV;
        q9a q9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r9a.class) {
                if (a == null) {
                    a = new q9a();
                }
                q9aVar = a;
            }
            return q9aVar;
        }
        return (q9a) invokeV.objValue;
    }
}
