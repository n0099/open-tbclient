package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes7.dex */
public final class oa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<pc7<?>> dataList, u87 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            k97 k97Var = new k97();
            k97Var.a = feedLiveComponent.top_label;
            k97Var.b = feedLiveComponent.bottom_label;
            k97Var.c = feedLiveComponent.audience_label;
            k97Var.d = feedLiveComponent.cover_url;
            k97Var.f = feedLiveComponent.schema;
            k97Var.e = v87.b(feedExtraData, "live_head_show");
            dataList.add(new qc7(new e77(k97Var, CollectionsKt__CollectionsKt.listOf((Object[]) new w97[]{v87.b(feedExtraData, "live_click"), v87.b(feedExtraData, "live_click2"), v87.b(feedExtraData, "live_click3")}), null, 4, null), "live"));
        }
    }
}
