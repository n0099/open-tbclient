package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x3a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w3a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w3a a() {
        InterceptResult invokeV;
        w3a w3aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x3a.class) {
                if (a == null) {
                    a = new w3a();
                }
                w3aVar = a;
            }
            return w3aVar;
        }
        return (w3a) invokeV.objValue;
    }
}
