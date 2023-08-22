package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLayout;
/* loaded from: classes7.dex */
public final class q77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(p77 p77Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, p77Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(p77Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            p77Var.a().b(oa7.a.a(feedLayout.business_info));
            p77Var.c().b(oa7.a.a(feedLayout.log_info));
        }
    }

    public static final Map<String, String> c(p77 p77Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, p77Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(p77Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            HashMap hashMap = new HashMap();
            nb7 nb7Var = p77Var.e().get(statStrategyKey);
            if (nb7Var != null) {
                hashMap.putAll(nb7Var.a(p77Var.a()));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static final r87 b(p77 p77Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, p77Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(p77Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            nb7 nb7Var = p77Var.e().get(statStrategyKey);
            if (nb7Var instanceof ob7) {
                statStrategyKey = ((ob7) nb7Var).c(p77Var.a());
            }
            r87 r87Var = new r87(null, null, null, null, null, 31, null);
            nb7 nb7Var2 = p77Var.e().get(statStrategyKey);
            if (nb7Var2 != null) {
                r87Var = new r87(nb7Var2.getKey(), nb7Var2.a(p77Var.a()), p77Var.c().a(), null, null, 24, null);
                if (nb7Var2 instanceof lb7) {
                    r87Var.g(((lb7) nb7Var2).b());
                }
                if (nb7Var2 instanceof z77) {
                    r87Var.f(((z77) nb7Var2).d());
                }
            }
            return r87Var;
        }
        return (r87) invokeLL.objValue;
    }
}
