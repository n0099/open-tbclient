package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes5.dex */
public final class iy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<b07<?>> dataList, dx6 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            kx6 kx6Var = new kx6();
            kx6Var.a = feedLiveComponent.top_label;
            kx6Var.b = feedLiveComponent.bottom_label;
            kx6Var.c = feedLiveComponent.audience_label;
            kx6Var.d = feedLiveComponent.cover_url;
            kx6Var.f = feedLiveComponent.schema;
            kx6Var.e = ex6.b(feedExtraData, "live_head_show");
            dataList.add(new c07(new yv6(kx6Var, null, 2, null), "live"));
        }
    }
}
