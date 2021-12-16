package com.baidu.wallet.newbindcard.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.wallet.newbindcard.b.c;
import com.baidu.wallet.newbindcard.ui.NewBindCardMainActivity;
/* loaded from: classes13.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static com.baidu.wallet.newbindcard.b.a a(int i2, NewBindCardMainActivity newBindCardMainActivity) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65536, null, i2, newBindCardMainActivity)) == null) {
            if (i2 != 80) {
                return null;
            }
            return new c(newBindCardMainActivity);
        }
        return (com.baidu.wallet.newbindcard.b.a) invokeIL.objValue;
    }
}
