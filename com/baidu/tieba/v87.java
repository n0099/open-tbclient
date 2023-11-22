package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedRoomComponent;
/* loaded from: classes8.dex */
public final class v87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedRoomComponent feedRoomComponent, List<ab7<?>> dataList, a67 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedRoomComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedRoomComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            tm6 tm6Var = new tm6();
            tm6Var.p(feedRoomComponent.status);
            tm6Var.q(feedRoomComponent.top_label);
            tm6Var.l(feedRoomComponent.cover_url);
            tm6Var.s(feedRoomComponent.scheme);
            tm6Var.v(feedRoomComponent.voice);
            tm6Var.t(feedRoomComponent.bottom_labels);
            dataList.add(new bb7(new c47(tm6Var, b67.d(feedExtraData, "card_pei_wan_click", null, 2, null), b67.d(feedExtraData, "voice_pei_wan_click", null, 2, null), b67.d(feedExtraData, "card_pei_wan_show", null, 2, null), feedExtraData.a().a(), feedExtraData.c().a()), "pei_wan"));
        }
    }
}
