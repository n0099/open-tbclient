package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLayout;
/* loaded from: classes7.dex */
public final class l37 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final v27 a(k37 k37Var, Map<String, String> appendMap) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, k37Var, appendMap)) == null) {
            Intrinsics.checkNotNullParameter(k37Var, "<this>");
            Intrinsics.checkNotNullParameter(appendMap, "appendMap");
            v27 v27Var = new v27();
            v27Var.a().putAll(k37Var.a().a());
            v27Var.a().putAll(appendMap);
            return v27Var;
        }
        return (v27) invokeLL.objValue;
    }

    public static final void b(k37 k37Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, k37Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(k37Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            k37Var.a().b(m67.a.a(feedLayout.business_info));
            k37Var.c().b(m67.a.a(feedLayout.log_info));
        }
    }

    public static final Map<String, String> e(k37 k37Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(InputDeviceCompat.SOURCE_TRACKBALL, null, k37Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(k37Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            HashMap hashMap = new HashMap();
            l77 l77Var = k37Var.e().get(statStrategyKey);
            if (l77Var != null) {
                hashMap.putAll(l77Var.a(k37Var.a()));
            }
            return hashMap;
        }
        return (Map) invokeLL.objValue;
    }

    public static final n47 c(k37 k37Var, String statStrategyKey, v27 v27Var) {
        InterceptResult invokeLLL;
        v27 v27Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, k37Var, statStrategyKey, v27Var)) == null) {
            Intrinsics.checkNotNullParameter(k37Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            l77 l77Var = k37Var.e().get(statStrategyKey);
            if (l77Var instanceof m77) {
                m77 m77Var = (m77) l77Var;
                if (v27Var == null) {
                    v27Var2 = k37Var.a();
                } else {
                    v27Var2 = v27Var;
                }
                statStrategyKey = m77Var.c(v27Var2);
            }
            n47 n47Var = new n47(null, null, null, null, null, 31, null);
            l77 l77Var2 = k37Var.e().get(statStrategyKey);
            if (l77Var2 != null) {
                String key = l77Var2.getKey();
                if (v27Var == null) {
                    v27Var = k37Var.a();
                }
                n47Var = new n47(key, l77Var2.a(v27Var), k37Var.c().a(), null, null, 24, null);
                if (l77Var2 instanceof j77) {
                    n47Var.g(((j77) l77Var2).b());
                }
                if (l77Var2 instanceof u37) {
                    n47Var.f(((u37) l77Var2).d());
                }
            }
            return n47Var;
        }
        return (n47) invokeLLL.objValue;
    }

    public static /* synthetic */ n47 d(k37 k37Var, String str, v27 v27Var, int i, Object obj) {
        if ((i & 2) != 0) {
            v27Var = null;
        }
        return c(k37Var, str, v27Var);
    }
}
