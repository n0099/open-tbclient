package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import com.baidu.tieba.tracker.Monitor;
import com.baidu.tieba.tracker.core.data.EventParams;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.Arrays;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class rna {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Fragment fragment, String pid, Pair<String, String>... params) {
        sna snaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, fragment, pid, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(pid, "pid");
            Intrinsics.checkNotNullParameter(params, "params");
            ona<sna> b = Monitor.a.b(pid);
            if (fragment instanceof sna) {
                snaVar = (sna) fragment;
            } else {
                snaVar = null;
            }
            if (snaVar != null && b != null) {
                b.b((Pair[]) Arrays.copyOf(params, params.length));
            }
        }
    }

    public static final void c(Fragment fragment, String pid, Pair<String, ? extends Object>... params) {
        sna snaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, fragment, pid, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(pid, "pid");
            Intrinsics.checkNotNullParameter(params, "params");
            ona<sna> a = Monitor.a.a(fragment, pid);
            if (fragment instanceof sna) {
                snaVar = (sna) fragment;
            } else {
                snaVar = null;
            }
            if (snaVar != null) {
                a.e(snaVar, 20000L).fillTrackParams(new EventParams((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void e(Fragment fragment, String pid, Pair<String, String>... params) {
        sna snaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TRACKBALL, null, fragment, pid, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(pid, "pid");
            Intrinsics.checkNotNullParameter(params, "params");
            ona<sna> b = Monitor.a.b(pid);
            if (fragment instanceof sna) {
                snaVar = (sna) fragment;
            } else {
                snaVar = null;
            }
            if (snaVar != null && b != null) {
                b.f((Pair[]) Arrays.copyOf(params, params.length));
            }
        }
    }

    public static final void b(Fragment fragment, Pair<String, String>... params) {
        sna snaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof sna) {
                snaVar = (sna) fragment;
            } else {
                snaVar = null;
            }
            if (snaVar != null) {
                a(fragment, snaVar.getTraceId(), (Pair[]) Arrays.copyOf(params, params.length));
            }
        }
    }

    public static final void d(Fragment fragment, Pair<String, ? extends Object>... params) {
        sna snaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof sna) {
                snaVar = (sna) fragment;
            } else {
                snaVar = null;
            }
            if (snaVar != null) {
                c(fragment, snaVar.getTraceId(), (Pair[]) Arrays.copyOf(params, params.length));
            }
        }
    }

    public static final void f(Fragment fragment, Pair<String, String>... params) {
        sna snaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65541, null, fragment, params) == null) {
            Intrinsics.checkNotNullParameter(fragment, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragment instanceof sna) {
                snaVar = (sna) fragment;
            } else {
                snaVar = null;
            }
            if (snaVar != null) {
                e(fragment, snaVar.getTraceId(), (Pair[]) Arrays.copyOf(params, params.length));
            }
        }
    }
}
