package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class m14 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l14 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l14 a() {
        InterceptResult invokeV;
        l14 l14Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m14.class) {
                if (a == null) {
                    a = new l14();
                }
                l14Var = a;
            }
            return l14Var;
        }
        return (l14) invokeV.objValue;
    }
}
