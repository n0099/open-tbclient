package com.baidu.tieba;

import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public final class u2a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(PbModel pbModel) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, pbModel)) == null) {
            if (pbModel != null) {
                z = pbModel.Y1();
            } else {
                z = false;
            }
            if (!z) {
                if (pbModel != null) {
                    z2 = pbModel.b2();
                } else {
                    z2 = false;
                }
                if (!z2) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
