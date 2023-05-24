package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ol9 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nl9 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nl9 a() {
        InterceptResult invokeV;
        nl9 nl9Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (ol9.class) {
                if (a == null) {
                    a = new nl9();
                }
                nl9Var = a;
            }
            return nl9Var;
        }
        return (nl9) invokeV.objValue;
    }
}
