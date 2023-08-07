package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ku2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ju2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ju2 a() {
        InterceptResult invokeV;
        ju2 ju2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ku2.class) {
                if (a == null) {
                    a = new ju2();
                }
                ju2Var = a;
            }
            return ju2Var;
        }
        return (ju2) invokeV.objValue;
    }
}
