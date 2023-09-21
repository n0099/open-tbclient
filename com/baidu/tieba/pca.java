package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class pca {
    public static /* synthetic */ Interceptable $ic;
    public static volatile oca a;
    public transient /* synthetic */ FieldHolder $fh;

    public static synchronized oca a() {
        InterceptResult invokeV;
        oca ocaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65536, null)) == null) {
            synchronized (pca.class) {
                if (a == null) {
                    a = new oca();
                }
                ocaVar = a;
            }
            return ocaVar;
        }
        return (oca) invokeV.objValue;
    }
}
