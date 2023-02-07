package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class ps2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile os2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized os2 a() {
        InterceptResult invokeV;
        os2 os2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ps2.class) {
                if (a == null) {
                    a = new os2();
                }
                os2Var = a;
            }
            return os2Var;
        }
        return (os2) invokeV.objValue;
    }
}
