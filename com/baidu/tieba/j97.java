package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes6.dex */
public final class j97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<jb7<?>> dataList, p77 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            f87 f87Var = new f87();
            f87Var.a = feedLiveComponent.top_label;
            f87Var.b = feedLiveComponent.bottom_label;
            f87Var.c = feedLiveComponent.audience_label;
            f87Var.d = feedLiveComponent.cover_url;
            f87Var.f = feedLiveComponent.schema;
            f87Var.e = q77.b(feedExtraData, "live_head_show");
            dataList.add(new kb7(new a67(f87Var, CollectionsKt__CollectionsKt.listOf((Object[]) new r87[]{q77.b(feedExtraData, "live_click"), q77.b(feedExtraData, "live_click2"), q77.b(feedExtraData, "live_click3")}), null, 4, null), "live"));
        }
    }
}
