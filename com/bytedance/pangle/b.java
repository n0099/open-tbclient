package com.bytedance.pangle;

import android.os.Build;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.bytedance.pangle.flipped.FlippedV2Impl;
/* loaded from: classes4.dex */
public final class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a() {
        com.bytedance.pangle.flipped.c aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65536, null) == null) {
            int i = Build.VERSION.SDK_INT;
            boolean z = false;
            if (i >= 30 || (i == 29 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                aVar = new FlippedV2Impl();
            } else {
                int i2 = Build.VERSION.SDK_INT;
                if (i2 >= 28 || (i2 == 27 && Build.VERSION.PREVIEW_SDK_INT > 0)) {
                    z = true;
                }
                if (z) {
                    aVar = new com.bytedance.pangle.flipped.b();
                } else {
                    aVar = new com.bytedance.pangle.flipped.a();
                }
            }
            aVar.invokeHiddenApiRestrictions();
        }
    }
}
