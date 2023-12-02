package com.baidu.tieba;

import androidx.fragment.app.FragmentActivity;
import com.baidu.tieba.tracker.Monitor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes6.dex */
public final class k4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FragmentActivity fragmentActivity, Pair<String, String>... params) {
        l4b l4bVar;
        i4b<l4b> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, fragmentActivity, params) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragmentActivity instanceof l4b) {
                l4bVar = (l4b) fragmentActivity;
            } else {
                l4bVar = null;
            }
            if (l4bVar != null && (d = Monitor.a.d(l4bVar)) != null) {
                d.b(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void c(FragmentActivity fragmentActivity, Pair<String, String>... params) {
        l4b l4bVar;
        i4b<l4b> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, fragmentActivity, params) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragmentActivity instanceof l4b) {
                l4bVar = (l4b) fragmentActivity;
            } else {
                l4bVar = null;
            }
            if (l4bVar != null && (d = Monitor.a.d(l4bVar)) != null) {
                d.l(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void b(FragmentActivity fragmentActivity) {
        l4b l4bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, fragmentActivity) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if (fragmentActivity instanceof l4b) {
                l4bVar = (l4b) fragmentActivity;
            } else {
                l4bVar = null;
            }
            if (l4bVar != null) {
                Monitor.a.b(fragmentActivity, l4bVar).g();
            }
        }
    }
}
