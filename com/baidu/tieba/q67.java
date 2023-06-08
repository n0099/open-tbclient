package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes7.dex */
public final class q67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<j87<?>> dataList, l57 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            s57 s57Var = new s57();
            s57Var.a = feedLiveComponent.top_label;
            s57Var.b = feedLiveComponent.bottom_label;
            s57Var.c = feedLiveComponent.audience_label;
            s57Var.d = feedLiveComponent.cover_url;
            s57Var.f = feedLiveComponent.schema;
            s57Var.e = m57.b(feedExtraData, "live_head_show");
            dataList.add(new k87(new g47(s57Var, null, 2, null), "live"));
        }
    }
}
