package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class us5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ts5 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ts5 a() {
        InterceptResult invokeV;
        ts5 ts5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (us5.class) {
                if (a == null) {
                    a = new ts5();
                }
                ts5Var = a;
            }
            return ts5Var;
        }
        return (ts5) invokeV.objValue;
    }
}
