package com.baidu.tieba;

import com.baidu.tieba.z07;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedKV;
import tbclient.FeedLayout;
/* loaded from: classes6.dex */
public final class vy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(uy6 uy6Var, FeedLayout feedLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, uy6Var, feedLayout) == null) {
            Intrinsics.checkNotNullParameter(uy6Var, "<this>");
            Intrinsics.checkNotNullParameter(feedLayout, "feedLayout");
            hy6 a = uy6Var.a();
            z07.a aVar = z07.a;
            List<FeedKV> list = feedLayout.business_info;
            Intrinsics.checkNotNullExpressionValue(list, "feedLayout.business_info");
            a.b(aVar.a(list));
            dz6 b = uy6Var.b();
            z07.a aVar2 = z07.a;
            List<FeedKV> list2 = feedLayout.log_info;
            Intrinsics.checkNotNullExpressionValue(list2, "feedLayout.log_info");
            b.b(aVar2.a(list2));
        }
    }

    public static final lz6 b(uy6 uy6Var, String statStrategyKey) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, uy6Var, statStrategyKey)) == null) {
            Intrinsics.checkNotNullParameter(uy6Var, "<this>");
            Intrinsics.checkNotNullParameter(statStrategyKey, "statStrategyKey");
            lz6 lz6Var = new lz6(null, null, null, 7, null);
            v17 v17Var = uy6Var.d().get(statStrategyKey);
            if (v17Var != null) {
                return new lz6(v17Var.getKey(), v17Var.a(uy6Var.a()), uy6Var.b().a());
            }
            return lz6Var;
        }
        return (lz6) invokeLL.objValue;
    }
}
