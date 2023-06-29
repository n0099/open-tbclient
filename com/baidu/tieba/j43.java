package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class j43 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile i43 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized i43 a() {
        InterceptResult invokeV;
        i43 i43Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (j43.class) {
                if (a == null) {
                    a = new i43();
                }
                i43Var = a;
            }
            return i43Var;
        }
        return (i43) invokeV.objValue;
    }
}
