package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class tfa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile sfa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized sfa a() {
        InterceptResult invokeV;
        sfa sfaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (tfa.class) {
                if (a == null) {
                    a = new sfa();
                }
                sfaVar = a;
            }
            return sfaVar;
        }
        return (sfa) invokeV.objValue;
    }
}
