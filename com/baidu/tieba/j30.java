package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j30 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i30 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i30 a() {
        InterceptResult invokeV;
        i30 i30Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j30.class) {
                if (a == null) {
                    a = new i30();
                }
                i30Var = a;
            }
            return i30Var;
        }
        return (i30) invokeV.objValue;
    }
}
