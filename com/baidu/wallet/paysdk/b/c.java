package com.baidu.wallet.paysdk.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes2.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static j a(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i2)) == null) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 == 3) {
                            return new d();
                        }
                        if (i2 == 5) {
                            return new e();
                        }
                        if (i2 != 6) {
                            if (i2 != 7) {
                                if (i2 != 9) {
                                    return new b();
                                }
                                return new f();
                            }
                        }
                    }
                    return new g();
                }
                return new a();
            }
            return new h();
        }
        return (j) invokeI.objValue;
    }
}
