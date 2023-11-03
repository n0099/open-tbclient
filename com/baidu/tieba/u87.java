package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedRoomComponent;
/* loaded from: classes8.dex */
public final class u87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedRoomComponent feedRoomComponent, List<za7<?>> dataList, z57 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedRoomComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedRoomComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            sm6 sm6Var = new sm6();
            sm6Var.p(feedRoomComponent.status);
            sm6Var.q(feedRoomComponent.top_label);
            sm6Var.l(feedRoomComponent.cover_url);
            sm6Var.s(feedRoomComponent.scheme);
            sm6Var.v(feedRoomComponent.voice);
            sm6Var.t(feedRoomComponent.bottom_labels);
            dataList.add(new ab7(new b47(sm6Var, a67.d(feedExtraData, "card_pei_wan_click", null, 2, null), a67.d(feedExtraData, "voice_pei_wan_click", null, 2, null), a67.d(feedExtraData, "card_pei_wan_show", null, 2, null), feedExtraData.a().a(), feedExtraData.c().a()), "pei_wan"));
        }
    }
}
