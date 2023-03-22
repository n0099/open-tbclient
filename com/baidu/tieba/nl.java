package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class nl {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ml a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ml a() {
        InterceptResult invokeV;
        ml mlVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nl.class) {
                if (a == null) {
                    a = new ml();
                }
                mlVar = a;
            }
            return mlVar;
        }
        return (ml) invokeV.objValue;
    }
}
