package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mma {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lma a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lma a() {
        InterceptResult invokeV;
        lma lmaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mma.class) {
                if (a == null) {
                    a = new lma();
                }
                lmaVar = a;
            }
            return lmaVar;
        }
        return (lma) invokeV.objValue;
    }
}
