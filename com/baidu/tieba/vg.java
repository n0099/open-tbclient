package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vg {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ug a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ug a() {
        InterceptResult invokeV;
        ug ugVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vg.class) {
                if (a == null) {
                    a = new ug();
                }
                ugVar = a;
            }
            return ugVar;
        }
        return (ug) invokeV.objValue;
    }
}
