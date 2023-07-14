package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public interface sub {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(lvb lvbVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(lvb lvbVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(lvb lvbVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(lvb lvbVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(lvb lvbVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(lvb lvbVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(lvb lvbVar, byte[] bArr, int i);
}
