package com.baidu.tieba;

import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Voice;
/* loaded from: classes8.dex */
public final class ya7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Voice voice, List<pc7<? extends Object>> mutableList, u87 feedExtraData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65536, null, voice, mutableList, feedExtraData) == null) {
            Intrinsics.checkNotNullParameter(voice, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            Intrinsics.checkNotNullParameter(feedExtraData, "feedExtraData");
            String voice_md5 = voice.voice_md5;
            Intrinsics.checkNotNullExpressionValue(voice_md5, "voice_md5");
            mutableList.add(new qc7(new s77(new ba7(CommonStatisticKey.FRS_VOICE_PLAY, voice_md5, voice.during_time.intValue() / 1000), CollectionsKt__CollectionsJVMKt.listOf(v87.b(feedExtraData, "voice_btn_click"))), "feed_voice"));
        }
    }
}
