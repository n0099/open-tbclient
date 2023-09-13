package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes8.dex */
public class uf1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(boolean z, String str, Object... objArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(65536, null, new Object[]{Boolean.valueOf(z), str, objArr}) != null) || z) {
            return;
        }
        throw new IllegalArgumentException(String.format(str, objArr));
    }
}
