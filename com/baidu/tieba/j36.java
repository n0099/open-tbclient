package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class j36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i36 a() {
        InterceptResult invokeV;
        i36 i36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j36.class) {
                if (a == null) {
                    a = new i36();
                }
                i36Var = a;
            }
            return i36Var;
        }
        return (i36) invokeV.objValue;
    }
}
