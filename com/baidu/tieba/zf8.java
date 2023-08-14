package com.baidu.tieba;

import android.graphics.Rect;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class zf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final boolean a(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, view2)) == null) {
            Intrinsics.checkNotNullParameter(view2, "<this>");
            if (ViewCompat.isAttachedToWindow(view2) && view2.getVisibility() == 0 && view2.getLocalVisibleRect(new Rect())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }
}
