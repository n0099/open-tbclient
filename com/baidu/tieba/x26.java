package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class x26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z)})) == null) {
            if (i != 80) {
                return -1;
            }
            return z ? R.anim.pickerview_slide_in_bottom : R.anim.pickerview_slide_out_bottom;
        }
        return invokeCommon.intValue;
    }
}
