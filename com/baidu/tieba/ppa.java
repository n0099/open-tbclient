package com.baidu.tieba;

import androidx.fragment.app.Fragment;
import com.baidu.tieba.tracker.Monitor;
import com.baidu.tieba.tracker.core.data.EventParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class ppa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Fragment fragment, Pair<String, String>... params) {
        qpa qpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof qpa) {
                qpaVar = (qpa) fragment;
            } else {
                qpaVar = null;
            }
            if (qpaVar != null) {
                Monitor.a.a(fragment, qpaVar).b(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void b(Fragment fragment, Pair<String, ? extends Object>... params) {
        qpa qpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof qpa) {
                qpaVar = (qpa) fragment;
            } else {
                qpaVar = null;
            }
            if (qpaVar != null) {
                Monitor.a.a(fragment, qpaVar).e().fillTrackParams(new EventParams((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void c(Fragment fragment, Pair<String, String>... params) {
        qpa qpaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof qpa) {
                qpaVar = (qpa) fragment;
            } else {
                qpaVar = null;
            }
            if (qpaVar != null) {
                Monitor.a.a(fragment, qpaVar).g(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }
}
