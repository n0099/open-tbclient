package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class m66 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l66 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l66 a() {
        InterceptResult invokeV;
        l66 l66Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m66.class) {
                if (a == null) {
                    a = new l66();
                }
                l66Var = a;
            }
            return l66Var;
        }
        return (l66) invokeV.objValue;
    }
}
