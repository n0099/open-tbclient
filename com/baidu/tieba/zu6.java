package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class zu6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends Comparable<? super T>> xu6<T> a(T initial, Function1<? super T, Unit> change) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, initial, change)) == null) {
            Intrinsics.checkNotNullParameter(initial, "initial");
            Intrinsics.checkNotNullParameter(change, "change");
            return new xu6<>(initial, change);
        }
        return (xu6) invokeLL.objValue;
    }
}
