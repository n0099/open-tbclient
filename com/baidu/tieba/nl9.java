package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class nl9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ml9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized ml9 a() {
        InterceptResult invokeV;
        ml9 ml9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (nl9.class) {
                if (a == null) {
                    a = new ml9();
                }
                ml9Var = a;
            }
            return ml9Var;
        }
        return (ml9) invokeV.objValue;
    }
}
