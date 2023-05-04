package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class q36 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p36 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p36 a() {
        InterceptResult invokeV;
        p36 p36Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q36.class) {
                if (a == null) {
                    a = new p36();
                }
                p36Var = a;
            }
            return p36Var;
        }
        return (p36) invokeV.objValue;
    }
}
