package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLayout;
import tbclient.VideoDoubleRowLayout;
/* loaded from: classes7.dex */
public final class o67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final r57 a(n67 n67Var, Map<String, String> appendMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, n67Var, appendMap)) == null) {
            Intrinsics.checkNotNullParameter(n67Var, "<this>");
            Intrinsics.checkNotNullParameter(appendMap, "appendMap");
            r57 r57Var = new r57();
            r57Var.a().putAll(n67Var.a().a());
            r57Var.a().putAll(appendMap);
            return r57Var;
        }
        return (r57) invokeLL.objValue;
    }

    public static final void b(n67 n67Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, n67Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(n67Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            n67Var.a().b(ra7.a.a(feedLayout.business_info));
            n67Var.c().b(ra7.a.a(feedLayout.log_info));
        }
    }

    public static final void c(n67 n67Var, VideoDoubleRowLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, n67Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(n67Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            n67Var.a().b(ra7.a.a(feedLayout.business_info));
            n67Var.c().b(ra7.a.a(feedLayout.log_info));
        }
    }

    public static final Map<String, String> f(n67 n67Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, n67Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(n67Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            HashMap hashMap = new HashMap();
            ub7 ub7Var = n67Var.e().get(statStrategyKey);
            if (ub7Var != null) {
                hashMap.putAll(ub7Var.a(n67Var.a()));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static final a87 d(n67 n67Var, String statStrategyKey, r57 r57Var) {
        InterceptResult invokeLLL;
        r57 r57Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, n67Var, statStrategyKey, r57Var)) == null) {
            Intrinsics.checkNotNullParameter(n67Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            ub7 ub7Var = n67Var.e().get(statStrategyKey);
            if (ub7Var instanceof vb7) {
                vb7 vb7Var = (vb7) ub7Var;
                if (r57Var == null) {
                    r57Var2 = n67Var.a();
                } else {
                    r57Var2 = r57Var;
                }
                statStrategyKey = vb7Var.c(r57Var2);
            }
            a87 a87Var = new a87(null, null, null, null, null, 31, null);
            ub7 ub7Var2 = n67Var.e().get(statStrategyKey);
            if (ub7Var2 != null) {
                String key = ub7Var2.getKey();
                if (r57Var == null) {
                    r57Var = n67Var.a();
                }
                a87Var = new a87(key, ub7Var2.a(r57Var), n67Var.c().a(), null, null, 24, null);
                if (ub7Var2 instanceof rb7) {
                    a87Var.g(((rb7) ub7Var2).b());
                }
                if (ub7Var2 instanceof b77) {
                    a87Var.f(((b77) ub7Var2).d());
                }
            }
            return a87Var;
        }
        return (a87) invokeLLL.objValue;
    }

    public static /* synthetic */ a87 e(n67 n67Var, String str, r57 r57Var, int i, Object obj) {
        if ((i & 2) != 0) {
            r57Var = null;
        }
        return d(n67Var, str, r57Var);
    }
}
