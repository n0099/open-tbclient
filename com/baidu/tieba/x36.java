package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class x36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w36 a() {
        InterceptResult invokeV;
        w36 w36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x36.class) {
                if (a == null) {
                    a = new w36();
                }
                w36Var = a;
            }
            return w36Var;
        }
        return (w36) invokeV.objValue;
    }
}
