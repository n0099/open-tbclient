package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class r26 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile q26 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized q26 a() {
        InterceptResult invokeV;
        q26 q26Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (r26.class) {
                if (a == null) {
                    a = new q26();
                }
                q26Var = a;
            }
            return q26Var;
        }
        return (q26) invokeV.objValue;
    }
}
