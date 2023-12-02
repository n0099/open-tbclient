package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vpa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile upa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized upa a() {
        InterceptResult invokeV;
        upa upaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vpa.class) {
                if (a == null) {
                    a = new upa();
                }
                upaVar = a;
            }
            return upaVar;
        }
        return (upa) invokeV.objValue;
    }
}
