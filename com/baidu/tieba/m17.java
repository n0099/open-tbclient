package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedLiveComponent;
/* loaded from: classes6.dex */
public final class m17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedLiveComponent feedLiveComponent, List<f37<?>> dataList, h07 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedLiveComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedLiveComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            o07 o07Var = new o07();
            o07Var.a = feedLiveComponent.top_label;
            o07Var.b = feedLiveComponent.bottom_label;
            o07Var.c = feedLiveComponent.audience_label;
            o07Var.d = feedLiveComponent.cover_url;
            o07Var.f = feedLiveComponent.schema;
            o07Var.e = i07.b(feedExtraData, "live_head_show");
            dataList.add(new g37(new cz6(o07Var, null, 2, null), "live"));
        }
    }
}
