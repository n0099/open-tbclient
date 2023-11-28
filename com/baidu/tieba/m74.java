package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class m74 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l74 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l74 a() {
        InterceptResult invokeV;
        l74 l74Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m74.class) {
                if (a == null) {
                    a = new l74();
                }
                l74Var = a;
            }
            return l74Var;
        }
        return (l74) invokeV.objValue;
    }
}
