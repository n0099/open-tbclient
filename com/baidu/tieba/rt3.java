package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class rt3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qt3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized qt3 a() {
        InterceptResult invokeV;
        qt3 qt3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (rt3.class) {
                if (a == null) {
                    a = new qt3();
                }
                qt3Var = a;
            }
            return qt3Var;
        }
        return (qt3) invokeV.objValue;
    }
}
