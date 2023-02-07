package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public class jm {
    public static /* synthetic */ Interceptable $ic;
    public static volatile im a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized im a() {
        InterceptResult invokeV;
        im imVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (jm.class) {
                if (a == null) {
                    a = new im();
                }
                imVar = a;
            }
            return imVar;
        }
        return (im) invokeV.objValue;
    }
}
