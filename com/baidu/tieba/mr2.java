package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class mr2 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lr2 a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lr2 a() {
        InterceptResult invokeV;
        lr2 lr2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mr2.class) {
                if (a == null) {
                    a = new lr2();
                }
                lr2Var = a;
            }
            return lr2Var;
        }
        return (lr2) invokeV.objValue;
    }
}
