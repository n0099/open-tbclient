package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class tca {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sca a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sca a() {
        InterceptResult invokeV;
        sca scaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tca.class) {
                if (a == null) {
                    a = new sca();
                }
                scaVar = a;
            }
            return scaVar;
        }
        return (sca) invokeV.objValue;
    }
}
