package com.baidu.tieba;

import android.content.res.Resources;
import android.util.TypedValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes9.dex */
public final class zl7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final int a(Number number) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, number)) == null) {
            Intrinsics.checkNotNullParameter(number, "<this>");
            return (int) TypedValue.applyDimension(1, number.floatValue(), Resources.getSystem().getDisplayMetrics());
        }
        return invokeL.intValue;
    }
}
