package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t9a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s9a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s9a a() {
        InterceptResult invokeV;
        s9a s9aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t9a.class) {
                if (a == null) {
                    a = new s9a();
                }
                s9aVar = a;
            }
            return s9aVar;
        }
        return (s9a) invokeV.objValue;
    }
}
