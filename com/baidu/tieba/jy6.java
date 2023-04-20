package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes5.dex */
public final class jy6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<c07<?>> dataList, ex6 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            lx6 lx6Var = new lx6();
            lx6Var.a = feedLiveComponent.top_label;
            lx6Var.b = feedLiveComponent.bottom_label;
            lx6Var.c = feedLiveComponent.audience_label;
            lx6Var.d = feedLiveComponent.cover_url;
            lx6Var.f = feedLiveComponent.schema;
            lx6Var.e = fx6.b(feedExtraData, "live_head_show");
            dataList.add(new d07(new zv6(lx6Var, null, 2, null), "live"));
        }
    }
}
