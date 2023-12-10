package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedRoomComponent;
/* loaded from: classes7.dex */
public final class m97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedRoomComponent feedRoomComponent, List<sb7<?>> dataList, r67 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedRoomComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedRoomComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            in6 in6Var = new in6();
            in6Var.p(feedRoomComponent.status);
            in6Var.q(feedRoomComponent.top_label);
            in6Var.l(feedRoomComponent.cover_url);
            in6Var.s(feedRoomComponent.scheme);
            in6Var.x(feedRoomComponent.voice);
            in6Var.t(feedRoomComponent.bottom_labels);
            dataList.add(new tb7(new t47(in6Var, s67.e(feedExtraData, "card_pei_wan_click", null, 2, null), s67.e(feedExtraData, "voice_pei_wan_click", null, 2, null), s67.e(feedExtraData, "card_pei_wan_show", null, 2, null), feedExtraData.a().a(), feedExtraData.c().a()), "pei_wan"));
        }
    }
}
