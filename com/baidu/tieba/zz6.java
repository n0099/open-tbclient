package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes7.dex */
public final class zz6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<s17<?>> dataList, uy6 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            bz6 bz6Var = new bz6();
            bz6Var.a = feedLiveComponent.top_label;
            bz6Var.b = feedLiveComponent.bottom_label;
            bz6Var.c = feedLiveComponent.audience_label;
            bz6Var.d = feedLiveComponent.cover_url;
            bz6Var.f = feedLiveComponent.schema;
            bz6Var.e = vy6.b(feedExtraData, "live_head_show");
            dataList.add(new t17(new px6(bz6Var, null, 2, null), "live"));
        }
    }
}
