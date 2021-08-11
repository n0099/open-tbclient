package com.bytedance.sdk.openadsdk.component.reward.c;

import android.app.Activity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.sdk.openadsdk.core.e.m;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static a a(Activity activity, m mVar, int i2, int i3, int i4, float f2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65536, null, new Object[]{activity, mVar, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Float.valueOf(f2)})) == null) {
            if (d.a(mVar)) {
                return new d(activity, mVar, i2, i3, i4, f2);
            }
            if (c.c(mVar)) {
                return new c(activity, mVar, i2, i3, i4, f2);
            }
            if (e.a(mVar)) {
                return new e(activity, mVar, i2, i3, i4, f2);
            }
            return null;
        }
        return (a) invokeCommon.objValue;
    }
}
