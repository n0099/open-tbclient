package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class pq6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final <T extends Comparable<? super T>> nq6<T> a(T initial, Function1<? super T, Unit> change) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, initial, change)) == null) {
            Intrinsics.checkNotNullParameter(initial, "initial");
            Intrinsics.checkNotNullParameter(change, "change");
            return new nq6<>(initial, change);
        }
        return (nq6) invokeLL.objValue;
    }
}
