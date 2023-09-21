package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class jca {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ica a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ica a() {
        InterceptResult invokeV;
        ica icaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jca.class) {
                if (a == null) {
                    a = new ica();
                }
                icaVar = a;
            }
            return icaVar;
        }
        return (ica) invokeV.objValue;
    }
}
