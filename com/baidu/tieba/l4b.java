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
public final class l4b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FragmentActivity fragmentActivity, Pair<String, String>... params) {
        m4b m4bVar;
        j4b<m4b> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, fragmentActivity, params) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragmentActivity instanceof m4b) {
                m4bVar = (m4b) fragmentActivity;
            } else {
                m4bVar = null;
            }
            if (m4bVar != null && (d = Monitor.a.d(m4bVar)) != null) {
                d.b(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void c(FragmentActivity fragmentActivity, Pair<String, String>... params) {
        m4b m4bVar;
        j4b<m4b> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, fragmentActivity, params) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragmentActivity instanceof m4b) {
                m4bVar = (m4b) fragmentActivity;
            } else {
                m4bVar = null;
            }
            if (m4bVar != null && (d = Monitor.a.d(m4bVar)) != null) {
                d.l(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void b(FragmentActivity fragmentActivity) {
        m4b m4bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, fragmentActivity) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if (fragmentActivity instanceof m4b) {
                m4bVar = (m4b) fragmentActivity;
            } else {
                m4bVar = null;
            }
            if (m4bVar != null) {
                Monitor.a.b(fragmentActivity, m4bVar).g();
            }
        }
    }
}
