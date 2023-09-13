package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class yaa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile xaa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized xaa a() {
        InterceptResult invokeV;
        xaa xaaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (yaa.class) {
                if (a == null) {
                    a = new xaa();
                }
                xaaVar = a;
            }
            return xaaVar;
        }
        return (xaa) invokeV.objValue;
    }
}
