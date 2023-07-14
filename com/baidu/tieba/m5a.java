package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m5a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l5a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l5a a() {
        InterceptResult invokeV;
        l5a l5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m5a.class) {
                if (a == null) {
                    a = new l5a();
                }
                l5aVar = a;
            }
            return l5aVar;
        }
        return (l5a) invokeV.objValue;
    }
}
