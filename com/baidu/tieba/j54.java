package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes4.dex */
public class j54 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i54 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i54 a() {
        InterceptResult invokeV;
        i54 i54Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j54.class) {
                if (a == null) {
                    a = new i54();
                }
                i54Var = a;
            }
            return i54Var;
        }
        return (i54) invokeV.objValue;
    }
}
