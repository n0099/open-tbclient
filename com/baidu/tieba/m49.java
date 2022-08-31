package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class m49 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l49 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l49 a() {
        InterceptResult invokeV;
        l49 l49Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m49.class) {
                if (a == null) {
                    a = new l49();
                }
                l49Var = a;
            }
            return l49Var;
        }
        return (l49) invokeV.objValue;
    }
}
