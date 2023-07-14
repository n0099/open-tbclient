package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class q5a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile p5a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized p5a a() {
        InterceptResult invokeV;
        p5a p5aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (q5a.class) {
                if (a == null) {
                    a = new p5a();
                }
                p5aVar = a;
            }
            return p5aVar;
        }
        return (p5a) invokeV.objValue;
    }
}
