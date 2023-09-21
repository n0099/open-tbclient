package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes8.dex */
public final class wa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<yc7<?>> dataList, b97 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            r97 r97Var = new r97();
            r97Var.a = feedLiveComponent.top_label;
            r97Var.b = feedLiveComponent.bottom_label;
            r97Var.c = feedLiveComponent.audience_label;
            r97Var.d = feedLiveComponent.cover_url;
            r97Var.f = feedLiveComponent.schema;
            r97Var.e = c97.d(feedExtraData, "live_head_show", null, 2, null);
            dataList.add(new zc7(new l77(r97Var, CollectionsKt__CollectionsKt.listOf((Object[]) new ea7[]{c97.d(feedExtraData, "live_click", null, 2, null), c97.d(feedExtraData, "live_click2", null, 2, null), c97.d(feedExtraData, "live_click3", null, 2, null)}), null, 4, null), "live"));
        }
    }
}
