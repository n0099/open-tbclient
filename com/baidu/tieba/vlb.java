package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public interface vlb {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(omb ombVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(omb ombVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(omb ombVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(omb ombVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(omb ombVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(omb ombVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(omb ombVar, byte[] bArr, int i);
}
