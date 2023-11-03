package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes8.dex */
public final class s87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<za7<?>> dataList, z57 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            t67 t67Var = new t67();
            t67Var.a = feedLiveComponent.top_label;
            t67Var.b = feedLiveComponent.bottom_label;
            t67Var.c = feedLiveComponent.audience_label;
            t67Var.d = feedLiveComponent.cover_url;
            t67Var.f = feedLiveComponent.schema;
            t67Var.e = a67.d(feedExtraData, "live_head_show", null, 2, null);
            dataList.add(new ab7(new x37(t67Var, CollectionsKt__CollectionsKt.listOf((Object[]) new m77[]{a67.d(feedExtraData, "live_click", null, 2, null), a67.d(feedExtraData, "live_click2", null, 2, null), a67.d(feedExtraData, "live_click3", null, 2, null)}), feedExtraData.a().a(), feedExtraData.c().a(), null, 16, null), "live"));
        }
    }
}
