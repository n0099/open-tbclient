package com.baidu.wallet.paysdk.presenter;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.paysdk.ui.PayBaseBeanActivity;
/* loaded from: classes12.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static k a(int i2, PayBaseBeanActivity payBaseBeanActivity) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i2, payBaseBeanActivity)) == null) {
            if (i2 != 1) {
                if (i2 != 3) {
                    if (i2 != 5) {
                        return null;
                    }
                    return new com.baidu.wallet.newbindcard.b.b(payBaseBeanActivity);
                }
                return new j(payBaseBeanActivity);
            }
            return new i(payBaseBeanActivity);
        }
        return (k) invokeIL.objValue;
    }
}
