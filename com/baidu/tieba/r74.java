package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class r74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q74 a() {
        InterceptResult invokeV;
        q74 q74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r74.class) {
                if (a == null) {
                    a = new q74();
                }
                q74Var = a;
            }
            return q74Var;
        }
        return (q74) invokeV.objValue;
    }
}
