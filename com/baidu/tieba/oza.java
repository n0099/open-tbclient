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
public final class oza {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FragmentActivity fragmentActivity, Pair<String, String>... params) {
        qza qzaVar;
        mza<qza> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, fragmentActivity, params) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragmentActivity instanceof qza) {
                qzaVar = (qza) fragmentActivity;
            } else {
                qzaVar = null;
            }
            if (qzaVar != null && (d = Monitor.a.d(qzaVar)) != null) {
                d.b(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void c(FragmentActivity fragmentActivity, Pair<String, String>... params) {
        qza qzaVar;
        mza<qza> d;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, fragmentActivity, params) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            Intrinsics.checkNotNullParameter(params, "params");
            if (fragmentActivity instanceof qza) {
                qzaVar = (qza) fragmentActivity;
            } else {
                qzaVar = null;
            }
            if (qzaVar != null && (d = Monitor.a.d(qzaVar)) != null) {
                d.g(MapsKt__MapsKt.mapOf((Pair[]) Arrays.copyOf(params, params.length)));
            }
        }
    }

    public static final void b(FragmentActivity fragmentActivity) {
        qza qzaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, fragmentActivity) == null) {
            Intrinsics.checkNotNullParameter(fragmentActivity, "<this>");
            if (fragmentActivity instanceof qza) {
                qzaVar = (qza) fragmentActivity;
            } else {
                qzaVar = null;
            }
            if (qzaVar != null) {
                Monitor.a.b(fragmentActivity, qzaVar).e();
            }
        }
    }
}
