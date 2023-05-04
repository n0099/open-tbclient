package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class vda {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uda a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uda a() {
        InterceptResult invokeV;
        uda udaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vda.class) {
                if (a == null) {
                    a = new uda();
                }
                udaVar = a;
            }
            return udaVar;
        }
        return (uda) invokeV.objValue;
    }
}
