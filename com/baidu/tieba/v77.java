package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes8.dex */
public final class v77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<v97<?>> dataList, b67 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            r67 r67Var = new r67();
            r67Var.a = feedLiveComponent.top_label;
            r67Var.b = feedLiveComponent.bottom_label;
            r67Var.c = feedLiveComponent.audience_label;
            r67Var.d = feedLiveComponent.cover_url;
            r67Var.f = feedLiveComponent.schema;
            r67Var.e = c67.b(feedExtraData, "live_head_show");
            dataList.add(new w97(new m47(r67Var, CollectionsKt__CollectionsKt.listOf((Object[]) new d77[]{c67.b(feedExtraData, "live_click"), c67.b(feedExtraData, "live_click2"), c67.b(feedExtraData, "live_click3")}), null, 4, null), "live"));
        }
    }
}
