package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class qha {
    public static /* synthetic */ Interceptable $ic;
    public static volatile pha a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized pha a() {
        InterceptResult invokeV;
        pha phaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (qha.class) {
                if (a == null) {
                    a = new pha();
                }
                phaVar = a;
            }
            return phaVar;
        }
        return (pha) invokeV.objValue;
    }
}
