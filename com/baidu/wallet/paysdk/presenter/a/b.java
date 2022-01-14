package com.baidu.wallet.paysdk.presenter.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.paysdk.contract.a;
/* loaded from: classes13.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static a.InterfaceC2012a a(int i2, a.b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i2, bVar)) == null) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        return null;
                    }
                    return new c(bVar);
                }
                return new a(bVar);
            }
            return new d(bVar);
        }
        return (a.InterfaceC2012a) invokeIL.objValue;
    }
}
