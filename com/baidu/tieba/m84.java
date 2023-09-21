package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class m84 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l84 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l84 a() {
        InterceptResult invokeV;
        l84 l84Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m84.class) {
                if (a == null) {
                    a = new l84();
                }
                l84Var = a;
            }
            return l84Var;
        }
        return (l84) invokeV.objValue;
    }
}
