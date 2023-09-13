package com.baidu.tieba;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FeedRoomComponent;
/* loaded from: classes7.dex */
public final class qa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(FeedRoomComponent feedRoomComponent, List<pc7<?>> dataList, u87 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, feedRoomComponent, dataList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(feedRoomComponent, "<this>");
            Intrinsics.checkNotNullParameter(dataList, "dataList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            hq6 hq6Var = new hq6();
            hq6Var.p(feedRoomComponent.status);
            hq6Var.q(feedRoomComponent.top_label);
            hq6Var.l(feedRoomComponent.cover_url);
            hq6Var.s(feedRoomComponent.scheme);
            hq6Var.v(feedRoomComponent.voice);
            hq6Var.t(feedRoomComponent.bottom_labels);
            dataList.add(new qc7(new i77(hq6Var, v87.b(feedExtraData, "card_pei_wan_click"), v87.b(feedExtraData, "voice_pei_wan_click"), v87.b(feedExtraData, "card_pei_wan_show")), "pei_wan"));
        }
    }
}
