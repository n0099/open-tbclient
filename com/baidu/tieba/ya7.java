package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedRoomComponent;
/* loaded from: classes8.dex */
public final class ya7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedRoomComponent feedRoomComponent, List<yc7<?>> dataList, b97 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedRoomComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedRoomComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            nq6 nq6Var = new nq6();
            nq6Var.p(feedRoomComponent.status);
            nq6Var.q(feedRoomComponent.top_label);
            nq6Var.l(feedRoomComponent.cover_url);
            nq6Var.s(feedRoomComponent.scheme);
            nq6Var.v(feedRoomComponent.voice);
            nq6Var.t(feedRoomComponent.bottom_labels);
            dataList.add(new zc7(new p77(nq6Var, c97.d(feedExtraData, "card_pei_wan_click", null, 2, null), c97.d(feedExtraData, "voice_pei_wan_click", null, 2, null), c97.d(feedExtraData, "card_pei_wan_show", null, 2, null)), "pei_wan"));
        }
    }
}
