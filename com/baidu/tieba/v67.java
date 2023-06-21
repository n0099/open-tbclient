package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes8.dex */
public final class v67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<o87<?>> dataList, q57 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            x57 x57Var = new x57();
            x57Var.a = feedLiveComponent.top_label;
            x57Var.b = feedLiveComponent.bottom_label;
            x57Var.c = feedLiveComponent.audience_label;
            x57Var.d = feedLiveComponent.cover_url;
            x57Var.f = feedLiveComponent.schema;
            x57Var.e = r57.b(feedExtraData, "live_head_show");
            dataList.add(new p87(new l47(x57Var, null, 2, null), "live"));
        }
    }
}
