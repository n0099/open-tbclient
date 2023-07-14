package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes7.dex */
public final class ma7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<mc7<?>> dataList, s87 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            i97 i97Var = new i97();
            i97Var.a = feedLiveComponent.top_label;
            i97Var.b = feedLiveComponent.bottom_label;
            i97Var.c = feedLiveComponent.audience_label;
            i97Var.d = feedLiveComponent.cover_url;
            i97Var.f = feedLiveComponent.schema;
            i97Var.e = t87.b(feedExtraData, "live_head_show");
            dataList.add(new nc7(new d77(i97Var, CollectionsKt__CollectionsKt.listOf((Object[]) new u97[]{t87.b(feedExtraData, "live_click"), t87.b(feedExtraData, "live_click2"), t87.b(feedExtraData, "live_click3")}), null, 4, null), "live"));
        }
    }
}
