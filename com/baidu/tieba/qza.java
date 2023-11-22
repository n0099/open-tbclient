package com.baidu.tieba;

import androidx.fragment.app.Fragment;
import com.baidu.tieba.hza;
import com.baidu.tieba.tracker.Monitor;
import com.baidu.tieba.tracker.core.data.EventParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes8.dex */
public final class qza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Fragment fragment, Pair<String, String>... params) {
        rza rzaVar;
        nza<rza> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof rza) {
                rzaVar = (rza) fragment;
            } else {
                rzaVar = null;
            }
            if (rzaVar != null && (d = Monitor.a.d(rzaVar)) != null) {
                d.b(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void b(Fragment fragment, Pair<String, ? extends Object>... params) {
        rza rzaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof rza) {
                rzaVar = (rza) fragment;
            } else {
                rzaVar = null;
            }
            if (rzaVar != null) {
                Monitor.a.a(fragment, rzaVar, hza.c.a).e().fillTrackParams(new EventParams((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void c(Fragment fragment, Pair<String, String>... params) {
        rza rzaVar;
        nza<rza> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof rza) {
                rzaVar = (rza) fragment;
            } else {
                rzaVar = null;
            }
            if (rzaVar != null && (d = Monitor.a.d(rzaVar)) != null) {
                d.g(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }
}
