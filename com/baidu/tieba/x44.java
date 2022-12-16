package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w44 a() {
        InterceptResult invokeV;
        w44 w44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x44.class) {
                if (a == null) {
                    a = new w44();
                }
                w44Var = a;
            }
            return w44Var;
        }
        return (w44) invokeV.objValue;
    }
}
