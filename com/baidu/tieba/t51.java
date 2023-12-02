package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class t51 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static <T> void a(@NonNull d61 d61Var, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(65536, null, d61Var, str) != null) || TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.startsWith("javascript:")) {
            str = "javascript:" + str;
        }
        d61Var.loadUrl(str, null);
    }

    public static void b(@NonNull d61 d61Var, int i, int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{d61Var, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) == null) {
            a(d61Var, "NadJsControl.visibleRectChange(".concat(String.valueOf(i)).concat(",").concat(String.valueOf(i2)).concat(",").concat(String.valueOf(i3)).concat(",").concat(String.valueOf(i4)).concat(");"));
        }
    }
}
