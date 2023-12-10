package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLayout;
import tbclient.VideoDoubleRowLayout;
/* loaded from: classes8.dex */
public final class s67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final v57 a(r67 r67Var, Map<String, String> appendMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, r67Var, appendMap)) == null) {
            Intrinsics.checkNotNullParameter(r67Var, "<this>");
            Intrinsics.checkNotNullParameter(appendMap, "appendMap");
            v57 v57Var = new v57();
            v57Var.a().putAll(r67Var.a().a());
            v57Var.a().putAll(appendMap);
            return v57Var;
        }
        return (v57) invokeLL.objValue;
    }

    public static final void b(r67 r67Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, r67Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(r67Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            r67Var.a().b(wa7.a.a(feedLayout.business_info));
            r67Var.c().b(wa7.a.a(feedLayout.log_info));
        }
    }

    public static final void c(r67 r67Var, VideoDoubleRowLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, r67Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(r67Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            r67Var.a().b(wa7.a.a(feedLayout.business_info));
            r67Var.c().b(wa7.a.a(feedLayout.log_info));
        }
    }

    public static final Map<String, String> f(r67 r67Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, r67Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(r67Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            HashMap hashMap = new HashMap();
            zb7 zb7Var = r67Var.e().get(statStrategyKey);
            if (zb7Var != null) {
                hashMap.putAll(zb7Var.a(r67Var.a()));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static final e87 d(r67 r67Var, String statStrategyKey, v57 v57Var) {
        InterceptResult invokeLLL;
        v57 v57Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65539, null, r67Var, statStrategyKey, v57Var)) == null) {
            Intrinsics.checkNotNullParameter(r67Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            zb7 zb7Var = r67Var.e().get(statStrategyKey);
            if (zb7Var instanceof ac7) {
                ac7 ac7Var = (ac7) zb7Var;
                if (v57Var == null) {
                    v57Var2 = r67Var.a();
                } else {
                    v57Var2 = v57Var;
                }
                statStrategyKey = ac7Var.c(v57Var2);
            }
            e87 e87Var = new e87(null, null, null, null, null, 31, null);
            zb7 zb7Var2 = r67Var.e().get(statStrategyKey);
            if (zb7Var2 != null) {
                String key = zb7Var2.getKey();
                if (v57Var == null) {
                    v57Var = r67Var.a();
                }
                e87Var = new e87(key, zb7Var2.a(v57Var), r67Var.c().a(), null, null, 24, null);
                if (zb7Var2 instanceof wb7) {
                    e87Var.g(((wb7) zb7Var2).b());
                }
                if (zb7Var2 instanceof f77) {
                    e87Var.f(((f77) zb7Var2).d());
                }
            }
            return e87Var;
        }
        return (e87) invokeLLL.objValue;
    }

    public static /* synthetic */ e87 e(r67 r67Var, String str, v57 v57Var, int i, Object obj) {
        if ((i & 2) != 0) {
            v57Var = null;
        }
        return d(r67Var, str, v57Var);
    }
}
