package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class w3a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile v3a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized v3a a() {
        InterceptResult invokeV;
        v3a v3aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (w3a.class) {
                if (a == null) {
                    a = new v3a();
                }
                v3aVar = a;
            }
            return v3aVar;
        }
        return (v3a) invokeV.objValue;
    }
}
