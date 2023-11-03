package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class oka {
    public static /* synthetic */ Interceptable $ic;
    public static volatile nka a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized nka a() {
        InterceptResult invokeV;
        nka nkaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (oka.class) {
                if (a == null) {
                    a = new nka();
                }
                nkaVar = a;
            }
            return nkaVar;
        }
        return (nka) invokeV.objValue;
    }
}
