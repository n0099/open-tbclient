package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class mna {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lna a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lna a() {
        InterceptResult invokeV;
        lna lnaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mna.class) {
                if (a == null) {
                    a = new lna();
                }
                lnaVar = a;
            }
            return lnaVar;
        }
        return (lna) invokeV.objValue;
    }
}
