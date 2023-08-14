package com.baidu.tieba;

import com.yy.transvod.player.common.AlphaChannelData;
import com.yy.transvod.player.common.MixAudioExtraInfo;
import com.yy.transvod.player.common.MixVideoExtraInfo;
import com.yy.transvod.player.common.VideoExtraInfo;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public interface wtb {
    @Deprecated
    void onDSEMixAudioExtraInfoV1(pub pubVar, ArrayList<MixAudioExtraInfo> arrayList);

    void onSEIAlphaChannelInfo(pub pubVar, int i, ArrayList<AlphaChannelData> arrayList);

    @Deprecated
    void onSEIAudioExtraInfoV0(pub pubVar, ArrayList<Long> arrayList);

    void onSEIAudioOriginalData(pub pubVar, byte[] bArr, int i);

    void onSEIMixVideoExtraInfo(pub pubVar, int i, ArrayList<MixVideoExtraInfo> arrayList);

    void onSEIVideoExtraInfo(pub pubVar, int i, ArrayList<VideoExtraInfo> arrayList);

    void onSEIVideoOriginalData(pub pubVar, byte[] bArr, int i);
}
