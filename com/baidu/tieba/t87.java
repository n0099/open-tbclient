package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLayout;
/* loaded from: classes8.dex */
public final class t87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(s87 s87Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, s87Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(s87Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            s87Var.a().b(rb7.a.a(feedLayout.business_info));
            s87Var.c().b(rb7.a.a(feedLayout.log_info));
        }
    }

    public static final Map<String, String> c(s87 s87Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, s87Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(s87Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            HashMap hashMap = new HashMap();
            qc7 qc7Var = s87Var.e().get(statStrategyKey);
            if (qc7Var != null) {
                hashMap.putAll(qc7Var.a(s87Var.a()));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static final u97 b(s87 s87Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, s87Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(s87Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            qc7 qc7Var = s87Var.e().get(statStrategyKey);
            if (qc7Var instanceof rc7) {
                statStrategyKey = ((rc7) qc7Var).c(s87Var.a());
            }
            u97 u97Var = new u97(null, null, null, null, null, 31, null);
            qc7 qc7Var2 = s87Var.e().get(statStrategyKey);
            if (qc7Var2 != null) {
                u97Var = new u97(qc7Var2.getKey(), qc7Var2.a(s87Var.a()), s87Var.c().a(), null, null, 24, null);
                if (qc7Var2 instanceof oc7) {
                    u97Var.g(((oc7) qc7Var2).b());
                }
                if (qc7Var2 instanceof c97) {
                    u97Var.f(((c97) qc7Var2).d());
                }
            }
            return u97Var;
        }
        return (u97) invokeLL.objValue;
    }
}
