package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes8.dex */
public final class t87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<ab7<?>> dataList, a67 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            u67 u67Var = new u67();
            u67Var.a = feedLiveComponent.top_label;
            u67Var.b = feedLiveComponent.bottom_label;
            u67Var.c = feedLiveComponent.audience_label;
            u67Var.d = feedLiveComponent.cover_url;
            u67Var.f = feedLiveComponent.schema;
            u67Var.e = b67.d(feedExtraData, "live_head_show", null, 2, null);
            dataList.add(new bb7(new y37(u67Var, CollectionsKt__CollectionsKt.listOf((Object[]) new n77[]{b67.d(feedExtraData, "live_click", null, 2, null), b67.d(feedExtraData, "live_click2", null, 2, null), b67.d(feedExtraData, "live_click3", null, 2, null)}), feedExtraData.a().a(), feedExtraData.c().a(), null, 16, null), "live"));
        }
    }
}
