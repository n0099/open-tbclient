package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m44 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l44 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l44 a() {
        InterceptResult invokeV;
        l44 l44Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m44.class) {
                if (a == null) {
                    a = new l44();
                }
                l44Var = a;
            }
            return l44Var;
        }
        return (l44) invokeV.objValue;
    }
}
