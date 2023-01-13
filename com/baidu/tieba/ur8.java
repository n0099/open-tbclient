package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ur8 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile tr8 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized tr8 a() {
        InterceptResult invokeV;
        tr8 tr8Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ur8.class) {
                if (a == null) {
                    a = new tr8();
                }
                tr8Var = a;
            }
            return tr8Var;
        }
        return (tr8) invokeV.objValue;
    }
}
