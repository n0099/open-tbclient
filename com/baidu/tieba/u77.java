package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes8.dex */
public final class u77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<u97<?>> dataList, a67 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            q67 q67Var = new q67();
            q67Var.a = feedLiveComponent.top_label;
            q67Var.b = feedLiveComponent.bottom_label;
            q67Var.c = feedLiveComponent.audience_label;
            q67Var.d = feedLiveComponent.cover_url;
            q67Var.f = feedLiveComponent.schema;
            q67Var.e = b67.b(feedExtraData, "live_head_show");
            dataList.add(new v97(new l47(q67Var, CollectionsKt__CollectionsKt.listOf((Object[]) new c77[]{b67.b(feedExtraData, "live_click"), b67.b(feedExtraData, "live_click2"), b67.b(feedExtraData, "live_click3")}), null, 4, null), "live"));
        }
    }
}
