package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lka a() {
        InterceptResult invokeV;
        lka lkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mka.class) {
                if (a == null) {
                    a = new lka();
                }
                lkaVar = a;
            }
            return lkaVar;
        }
        return (lka) invokeV.objValue;
    }
}
