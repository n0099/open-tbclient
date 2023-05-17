package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class m64 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l64 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l64 a() {
        InterceptResult invokeV;
        l64 l64Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m64.class) {
                if (a == null) {
                    a = new l64();
                }
                l64Var = a;
            }
            return l64Var;
        }
        return (l64) invokeV.objValue;
    }
}
