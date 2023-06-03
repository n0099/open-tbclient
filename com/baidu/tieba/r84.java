package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q84 a() {
        InterceptResult invokeV;
        q84 q84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r84.class) {
                if (a == null) {
                    a = new q84();
                }
                q84Var = a;
            }
            return q84Var;
        }
        return (q84) invokeV.objValue;
    }
}
