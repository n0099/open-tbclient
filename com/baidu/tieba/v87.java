package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLayout;
/* loaded from: classes8.dex */
public final class v87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(u87 u87Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, u87Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(u87Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            u87Var.a().b(ub7.a.a(feedLayout.business_info));
            u87Var.c().b(ub7.a.a(feedLayout.log_info));
        }
    }

    public static final Map<String, String> c(u87 u87Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, u87Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(u87Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            HashMap hashMap = new HashMap();
            tc7 tc7Var = u87Var.e().get(statStrategyKey);
            if (tc7Var != null) {
                hashMap.putAll(tc7Var.a(u87Var.a()));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static final w97 b(u87 u87Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, u87Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(u87Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            tc7 tc7Var = u87Var.e().get(statStrategyKey);
            if (tc7Var instanceof uc7) {
                statStrategyKey = ((uc7) tc7Var).c(u87Var.a());
            }
            w97 w97Var = new w97(null, null, null, null, null, 31, null);
            tc7 tc7Var2 = u87Var.e().get(statStrategyKey);
            if (tc7Var2 != null) {
                w97Var = new w97(tc7Var2.getKey(), tc7Var2.a(u87Var.a()), u87Var.c().a(), null, null, 24, null);
                if (tc7Var2 instanceof rc7) {
                    w97Var.g(((rc7) tc7Var2).b());
                }
                if (tc7Var2 instanceof e97) {
                    w97Var.f(((e97) tc7Var2).d());
                }
            }
            return w97Var;
        }
        return (w97) invokeLL.objValue;
    }
}
