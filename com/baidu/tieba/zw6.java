package com.baidu.tieba;

import android.os.Trace;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class zw6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(65536, null) != null) || !s05.e()) {
            return;
        }
        Trace.endSection();
    }

    public static final void b(String name) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, name) == null) {
            Intrinsics.checkNotNullParameter(name, "name");
            if (!s05.e()) {
                return;
            }
            Trace.beginSection(name);
        }
    }
}
