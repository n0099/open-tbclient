package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class poa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ooa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ooa a() {
        InterceptResult invokeV;
        ooa ooaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (poa.class) {
                if (a == null) {
                    a = new ooa();
                }
                ooaVar = a;
            }
            return ooaVar;
        }
        return (ooa) invokeV.objValue;
    }
}
