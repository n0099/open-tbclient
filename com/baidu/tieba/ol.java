package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ol {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nl a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nl a() {
        InterceptResult invokeV;
        nl nlVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ol.class) {
                if (a == null) {
                    a = new nl();
                }
                nlVar = a;
            }
            return nlVar;
        }
        return (nl) invokeV.objValue;
    }
}
