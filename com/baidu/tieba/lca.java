package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class lca {
    public static /* synthetic */ Interceptable $ic;
    public static volatile kca a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized kca a() {
        InterceptResult invokeV;
        kca kcaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (lca.class) {
                if (a == null) {
                    a = new kca();
                }
                kcaVar = a;
            }
            return kcaVar;
        }
        return (kca) invokeV.objValue;
    }
}
