package com.baidu.tieba;

import android.view.Gravity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public final class l0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(65536, null, i)) == null) {
            int absoluteGravity = Gravity.getAbsoluteGravity(i, 0) & 7;
            if ((i & 112) != 16 || absoluteGravity != 1) {
                return false;
            }
            return true;
        }
        return invokeI.booleanValue;
    }
}
