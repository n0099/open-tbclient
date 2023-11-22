package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class mha {
    public static /* synthetic */ Interceptable $ic;
    public static volatile lha a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized lha a() {
        InterceptResult invokeV;
        lha lhaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (mha.class) {
                if (a == null) {
                    a = new lha();
                }
                lhaVar = a;
            }
            return lhaVar;
        }
        return (lha) invokeV.objValue;
    }
}
