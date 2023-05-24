package com.baidu.tieba;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tbclient.Voice;
/* loaded from: classes7.dex */
public final class u17 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final void a(Voice voice, List<g37<? extends Object>> mutableList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, voice, mutableList) == null) {
            Intrinsics.checkNotNullParameter(voice, "<this>");
            Intrinsics.checkNotNullParameter(mutableList, "mutableList");
            mutableList.add(b(voice));
        }
    }

    public static final h37<VoiceData.VoiceModel> b(Voice voice) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, voice)) == null) {
            Intrinsics.checkNotNullParameter(voice, "<this>");
            VoiceData.VoiceModel voiceModel = new VoiceData.VoiceModel();
            voiceModel.from = CommonStatisticKey.FRS_VOICE_PLAY;
            voiceModel.setVoiceId(voice.voice_md5);
            voiceModel.setDuration(voice.during_time.intValue() / 1000);
            return new h37<>(voiceModel, "feed_voice");
        }
        return (h37) invokeL.objValue;
    }
}
