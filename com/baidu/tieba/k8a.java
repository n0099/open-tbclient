package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class k8a {
    public static /* synthetic */ Interceptable $ic;
    public static volatile j8a a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized j8a a() {
        InterceptResult invokeV;
        j8a j8aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (k8a.class) {
                if (a == null) {
                    a = new j8a();
                }
                j8aVar = a;
            }
            return j8aVar;
        }
        return (j8a) invokeV.objValue;
    }
}
