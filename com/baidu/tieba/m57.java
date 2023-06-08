package com.baidu.tieba;

import com.baidu.tieba.q77;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedKV;
import tbclient.FeedLayout;
/* loaded from: classes6.dex */
public final class m57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(l57 l57Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, l57Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(l57Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            y47 a = l57Var.a();
            q77.a aVar = q77.a;
            List<FeedKV> list = feedLayout.business_info;
            Intrinsics.checkNotNullExpressionValue(list, "feedLayout.business_info");
            a.b(aVar.a(list));
            u57 b = l57Var.b();
            q77.a aVar2 = q77.a;
            List<FeedKV> list2 = feedLayout.log_info;
            Intrinsics.checkNotNullExpressionValue(list2, "feedLayout.log_info");
            b.b(aVar2.a(list2));
        }
    }

    public static final c67 b(l57 l57Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, l57Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(l57Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            c67 c67Var = new c67(null, null, null, 7, null);
            m87 m87Var = l57Var.d().get(statStrategyKey);
            if (m87Var != null) {
                return new c67(m87Var.getKey(), m87Var.a(l57Var.a()), l57Var.b().a());
            }
            return c67Var;
        }
        return (c67) invokeLL.objValue;
    }
}
