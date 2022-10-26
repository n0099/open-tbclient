package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class x74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile w74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized w74 a() {
        InterceptResult invokeV;
        w74 w74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (x74.class) {
                if (a == null) {
                    a = new w74();
                }
                w74Var = a;
            }
            return w74Var;
        }
        return (w74) invokeV.objValue;
    }
}
