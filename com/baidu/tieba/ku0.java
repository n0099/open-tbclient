package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class ku0 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ju0 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ju0 a() {
        InterceptResult invokeV;
        ju0 ju0Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ku0.class) {
                if (a == null) {
                    a = new ju0();
                }
                ju0Var = a;
            }
            return ju0Var;
        }
        return (ju0) invokeV.objValue;
    }
}
