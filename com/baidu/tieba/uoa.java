package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uoa {
    public static /* synthetic */ Interceptable $ic;
    public static volatile toa a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized toa a() {
        InterceptResult invokeV;
        toa toaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (uoa.class) {
                if (a == null) {
                    a = new toa();
                }
                toaVar = a;
            }
            return toaVar;
        }
        return (toa) invokeV.objValue;
    }
}
