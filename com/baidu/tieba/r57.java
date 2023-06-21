package com.baidu.tieba;

import com.baidu.tieba.v77;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedKV;
import tbclient.FeedLayout;
/* loaded from: classes7.dex */
public final class r57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(q57 q57Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, q57Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(q57Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            d57 a = q57Var.a();
            v77.a aVar = v77.a;
            List<FeedKV> list = feedLayout.business_info;
            Intrinsics.checkNotNullExpressionValue(list, "feedLayout.business_info");
            a.b(aVar.a(list));
            z57 b = q57Var.b();
            v77.a aVar2 = v77.a;
            List<FeedKV> list2 = feedLayout.log_info;
            Intrinsics.checkNotNullExpressionValue(list2, "feedLayout.log_info");
            b.b(aVar2.a(list2));
        }
    }

    public static final h67 b(q57 q57Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, q57Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(q57Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            h67 h67Var = new h67(null, null, null, 7, null);
            r87 r87Var = q57Var.d().get(statStrategyKey);
            if (r87Var != null) {
                return new h67(r87Var.getKey(), r87Var.a(q57Var.a()), q57Var.b().a());
            }
            return h67Var;
        }
        return (h67) invokeLL.objValue;
    }
}
