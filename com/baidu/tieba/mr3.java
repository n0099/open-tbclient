package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mr3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lr3 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lr3 a() {
        InterceptResult invokeV;
        lr3 lr3Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mr3.class) {
                if (a == null) {
                    a = new lr3();
                }
                lr3Var = a;
            }
            return lr3Var;
        }
        return (lr3) invokeV.objValue;
    }
}
