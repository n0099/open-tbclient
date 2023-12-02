package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes6.dex */
public final class k97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<rb7<?>> dataList, r67 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            l77 l77Var = new l77();
            l77Var.a = feedLiveComponent.top_label;
            l77Var.b = feedLiveComponent.bottom_label;
            l77Var.c = feedLiveComponent.audience_label;
            l77Var.d = feedLiveComponent.cover_url;
            l77Var.f = feedLiveComponent.schema;
            l77Var.e = s67.e(feedExtraData, "live_head_show", null, 2, null);
            dataList.add(new sb7(new p47(l77Var, CollectionsKt__CollectionsKt.listOf((Object[]) new e87[]{s67.e(feedExtraData, "live_click", null, 2, null), s67.e(feedExtraData, "live_click2", null, 2, null), s67.e(feedExtraData, "live_click3", null, 2, null)}), feedExtraData.a().a(), feedExtraData.c().a(), null, 16, null), "live"));
        }
    }
}
