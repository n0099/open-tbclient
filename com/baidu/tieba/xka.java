package com.baidu.tieba;

import android.content.res.Resources;
import android.util.TypedValue;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xka {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(65536, null, f)) == null) {
            return (int) TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics());
        }
        return invokeF.intValue;
    }
}
