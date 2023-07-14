package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t2b {
    public static /* synthetic */ Interceptable $ic;
    public static volatile s2b a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized s2b a() {
        InterceptResult invokeV;
        s2b s2bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (t2b.class) {
                if (a == null) {
                    a = new s2b();
                }
                s2bVar = a;
            }
            return s2bVar;
        }
        return (s2b) invokeV.objValue;
    }
}
