package com.baidu.tieba;

import com.baidu.tieba.o77;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedKV;
import tbclient.FeedLayout;
/* loaded from: classes6.dex */
public final class k57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(j57 j57Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, j57Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(j57Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            w47 a = j57Var.a();
            o77.a aVar = o77.a;
            List<FeedKV> list = feedLayout.business_info;
            Intrinsics.checkNotNullExpressionValue(list, "feedLayout.business_info");
            a.b(aVar.a(list));
            s57 b = j57Var.b();
            o77.a aVar2 = o77.a;
            List<FeedKV> list2 = feedLayout.log_info;
            Intrinsics.checkNotNullExpressionValue(list2, "feedLayout.log_info");
            b.b(aVar2.a(list2));
        }
    }

    public static final a67 b(j57 j57Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, j57Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(j57Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            a67 a67Var = new a67(null, null, null, 7, null);
            k87 k87Var = j57Var.d().get(statStrategyKey);
            if (k87Var != null) {
                return new a67(k87Var.getKey(), k87Var.a(j57Var.a()), j57Var.b().a());
            }
            return a67Var;
        }
        return (a67) invokeLL.objValue;
    }
}
