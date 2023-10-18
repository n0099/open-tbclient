package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class m46 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile l46 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized l46 a() {
        InterceptResult invokeV;
        l46 l46Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (m46.class) {
                if (a == null) {
                    a = new l46();
                }
                l46Var = a;
            }
            return l46Var;
        }
        return (l46) invokeV.objValue;
    }
}
