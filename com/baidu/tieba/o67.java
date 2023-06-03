package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes7.dex */
public final class o67 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<h87<?>> dataList, j57 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            q57 q57Var = new q57();
            q57Var.a = feedLiveComponent.top_label;
            q57Var.b = feedLiveComponent.bottom_label;
            q57Var.c = feedLiveComponent.audience_label;
            q57Var.d = feedLiveComponent.cover_url;
            q57Var.f = feedLiveComponent.schema;
            q57Var.e = k57.b(feedExtraData, "live_head_show");
            dataList.add(new i87(new e47(q57Var, null, 2, null), "live"));
        }
    }
}
