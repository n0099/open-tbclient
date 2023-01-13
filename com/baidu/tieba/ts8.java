package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ts8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ss8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ss8 a() {
        InterceptResult invokeV;
        ss8 ss8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ts8.class) {
                if (a == null) {
                    a = new ss8();
                }
                ss8Var = a;
            }
            return ss8Var;
        }
        return (ss8) invokeV.objValue;
    }
}
