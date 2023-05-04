package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class sca {
    public static /* synthetic */ Interceptable $ic;
    public static volatile rca a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized rca a() {
        InterceptResult invokeV;
        rca rcaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (sca.class) {
                if (a == null) {
                    a = new rca();
                }
                rcaVar = a;
            }
            return rcaVar;
        }
        return (rca) invokeV.objValue;
    }
}
