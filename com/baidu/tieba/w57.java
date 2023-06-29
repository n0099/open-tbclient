package com.baidu.tieba;

import com.baidu.tieba.a87;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedKV;
import tbclient.FeedLayout;
/* loaded from: classes8.dex */
public final class w57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(v57 v57Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, v57Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(v57Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            i57 a = v57Var.a();
            a87.a aVar = a87.a;
            List<FeedKV> list = feedLayout.business_info;
            Intrinsics.checkNotNullExpressionValue(list, "feedLayout.business_info");
            a.b(aVar.a(list));
            e67 b = v57Var.b();
            a87.a aVar2 = a87.a;
            List<FeedKV> list2 = feedLayout.log_info;
            Intrinsics.checkNotNullExpressionValue(list2, "feedLayout.log_info");
            b.b(aVar2.a(list2));
        }
    }

    public static final m67 b(v57 v57Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, v57Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(v57Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            m67 m67Var = new m67(null, null, null, 7, null);
            w87 w87Var = v57Var.d().get(statStrategyKey);
            if (w87Var != null) {
                return new m67(w87Var.getKey(), w87Var.a(v57Var.a()), v57Var.b().a());
            }
            return m67Var;
        }
        return (m67) invokeLL.objValue;
    }
}
