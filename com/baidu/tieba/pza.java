package com.baidu.tieba;

import androidx.fragment.app.FragmentActivity;
import com.baidu.tieba.tracker.Monitor;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class pza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FragmentActivity fragmentActivity, Pair<String, String>... params) {
        rza rzaVar;
        nza<rza> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, fragmentActivity, params) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragmentActivity instanceof rza) {
                rzaVar = (rza) fragmentActivity;
            } else {
                rzaVar = null;
            }
            if (rzaVar != null && (d = Monitor.a.d(rzaVar)) != null) {
                d.b(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void c(FragmentActivity fragmentActivity, Pair<String, String>... params) {
        rza rzaVar;
        nza<rza> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, fragmentActivity, params) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragmentActivity instanceof rza) {
                rzaVar = (rza) fragmentActivity;
            } else {
                rzaVar = null;
            }
            if (rzaVar != null && (d = Monitor.a.d(rzaVar)) != null) {
                d.g(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void b(FragmentActivity fragmentActivity) {
        rza rzaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, fragmentActivity) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if (fragmentActivity instanceof rza) {
                rzaVar = (rza) fragmentActivity;
            } else {
                rzaVar = null;
            }
            if (rzaVar != null) {
                Monitor.a.b(fragmentActivity, rzaVar).e();
            }
        }
    }
}
