package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m4a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l4a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l4a a() {
        InterceptResult invokeV;
        l4a l4aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m4a.class) {
                if (a == null) {
                    a = new l4a();
                }
                l4aVar = a;
            }
            return l4aVar;
        }
        return (l4a) invokeV.objValue;
    }
}
