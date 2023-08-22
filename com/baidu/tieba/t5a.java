package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t5a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s5a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s5a a() {
        InterceptResult invokeV;
        s5a s5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t5a.class) {
                if (a == null) {
                    a = new s5a();
                }
                s5aVar = a;
            }
            return s5aVar;
        }
        return (s5a) invokeV.objValue;
    }
}
