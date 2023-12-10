package com.baidu.tieba;

import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Voice;
/* loaded from: classes8.dex */
public final class t97 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Voice voice, List<sb7<? extends Object>> mutableList, r67 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, voice, mutableList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(voice, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            String voice_md5 = voice.voice_md5;
            Intrinsics.checkNotNullExpressionValue(voice_md5, "voice_md5");
            mutableList.add(new tb7(new d57(new n87(CommonStatisticKey.FRS_VOICE_PLAY, voice_md5, voice.during_time.intValue() / 1000), CollectionsKt__CollectionsJVMKt.listOf(s67.e(feedExtraData, "voice_btn_click", null, 2, null))), "feed_voice"));
        }
    }
}
