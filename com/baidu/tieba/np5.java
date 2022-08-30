package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class np5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile mp5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized mp5 a() {
        InterceptResult invokeV;
        mp5 mp5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (np5.class) {
                if (a == null) {
                    a = new mp5();
                }
                mp5Var = a;
            }
            return mp5Var;
        }
        return (mp5) invokeV.objValue;
    }
}
