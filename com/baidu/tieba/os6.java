package com.baidu.tieba;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public class os6 implements hs6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public WeakReference<Runnable> a;
    public boolean b;

    @Override // com.baidu.tieba.hs6
    public final void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, runnable) == null) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.b = true;
            this.a = new WeakReference<>(runnable);
        }
    }

    public final void b(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            this.a = new WeakReference<>(runnable);
        }
    }
}
