package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes6.dex */
public final class n17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<g37<?>> dataList, i07 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            p07 p07Var = new p07();
            p07Var.a = feedLiveComponent.top_label;
            p07Var.b = feedLiveComponent.bottom_label;
            p07Var.c = feedLiveComponent.audience_label;
            p07Var.d = feedLiveComponent.cover_url;
            p07Var.f = feedLiveComponent.schema;
            p07Var.e = j07.b(feedExtraData, "live_head_show");
            dataList.add(new h37(new dz6(p07Var, null, 2, null), "live"));
        }
    }
}
