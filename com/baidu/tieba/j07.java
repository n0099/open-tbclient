package com.baidu.tieba;

import com.baidu.tieba.n27;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedKV;
import tbclient.FeedLayout;
/* loaded from: classes6.dex */
public final class j07 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(i07 i07Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, i07Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(i07Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            vz6 a = i07Var.a();
            n27.a aVar = n27.a;
            List<FeedKV> list = feedLayout.business_info;
            Intrinsics.checkNotNullExpressionValue(list, "feedLayout.business_info");
            a.b(aVar.a(list));
            r07 b = i07Var.b();
            n27.a aVar2 = n27.a;
            List<FeedKV> list2 = feedLayout.log_info;
            Intrinsics.checkNotNullExpressionValue(list2, "feedLayout.log_info");
            b.b(aVar2.a(list2));
        }
    }

    public static final z07 b(i07 i07Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, i07Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(i07Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            z07 z07Var = new z07(null, null, null, 7, null);
            j37 j37Var = i07Var.d().get(statStrategyKey);
            if (j37Var != null) {
                return new z07(j37Var.getKey(), j37Var.a(i07Var.a()), i07Var.b().a());
            }
            return z07Var;
        }
        return (z07) invokeLL.objValue;
    }
}
