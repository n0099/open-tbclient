package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class vja {
    public static /* synthetic */ Interceptable $ic;
    public static volatile uja a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized uja a() {
        InterceptResult invokeV;
        uja ujaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (vja.class) {
                if (a == null) {
                    a = new uja();
                }
                ujaVar = a;
            }
            return ujaVar;
        }
        return (uja) invokeV.objValue;
    }
}
